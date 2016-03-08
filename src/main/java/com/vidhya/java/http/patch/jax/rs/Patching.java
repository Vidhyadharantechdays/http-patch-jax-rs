/*
 *  The MIT License (MIT)
 * 
 * Copyright (c) 2016 Vidhyadharan Deivamani < it.vidhyadharan@gmail.com >
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.vidhya.java.http.patch.jax.rs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import javax.annotation.Priority;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
/**
 * JAX-RS reader interceptor that implements server-side PATCH support.
 *
 * @author Vidhyadharan Deivamani < it.vidhyadharan@gmail.com >
 */
@Priority(1000)
@Provider
@PATCH 
public class Patching implements ReaderInterceptor {

    /**
     * Supported PATCH data format.
     */
    public static final String PATCH_MEDIA_TYPE = "application/json-patch+json";

    @Context
    private  UriInfo uriInfo;
    @Context 
    private  Providers providers;

    
    @SuppressWarnings("unchecked")
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext) throws IOException, WebApplicationException {
        // Get the resource we are being called on, and find the GET method
        System.out.println("Is calling");
        Object resource = uriInfo.getMatchedResources().get(0);

        Method found = null;
        for (Method next : resource.getClass().getMethods()) {
            if (next.getAnnotation(javax.ws.rs.GET.class) != null) {
                found = next;
                break;
            }
            if(next.getName().equals("getPerson")){
                found =next;
                break;
            }
        }

        if (found == null) {
            throw new WebApplicationException("No matching GET method on resource");
        }

        // Invoke the get method to get the state we are trying to patch
        Object bean;
        try {
            bean = found.invoke(resource);
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }

        // Convert this object to a an array of bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MessageBodyWriter bodyWriter =
                providers.getMessageBodyWriter(bean.getClass(), bean.getClass(),
                        new Annotation[0], MediaType.APPLICATION_JSON_TYPE);

        bodyWriter.writeTo(bean, bean.getClass(), bean.getClass(),
                new Annotation[0], MediaType.APPLICATION_JSON_TYPE,
                new MultivaluedHashMap<String, Object>(), baos);


        // Use the Jackson 2.x classes to convert both the incoming patch
        // and the current state of the object into a JsonNode / JsonPatch
        ObjectMapper mapper = new ObjectMapper();
        JsonNode serverState = mapper.readValue(baos.toByteArray(), JsonNode.class);
        JsonNode patchAsNode = mapper.readValue(readerInterceptorContext.getInputStream(), JsonNode.class);
        JsonPatch patch = JsonPatch.fromJson(patchAsNode);

        try {
            // Apply the patch
            JsonNode result = patch.apply(serverState);

            // Stream the result & modify the stream on the readerInterceptor
            ByteArrayOutputStream resultAsByteArray = new ByteArrayOutputStream();
            mapper.writeValue(resultAsByteArray, result);
            readerInterceptorContext.setInputStream(new ByteArrayInputStream(resultAsByteArray.toByteArray()));

            // Pass control back to the Jersey code
            return readerInterceptorContext.proceed();
        } catch (JsonPatchException ex) {
            throw new InternalServerErrorException("Error applying patch.", ex);
        }
    }

    
}
