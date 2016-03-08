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

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * A JAX-RS container response filter that applies {@code Accept-Patch} header
 * to any response to an {@code OPTIONS} request.
 *
 * 
 * @author vidhya (it.vidhyadharan@gmail.com)
 */
@Provider
public class AcceptPatchHeaderFilter implements ContainerResponseFilter {

    private static final String ACCEPT_PATCH_HEADER = "Accept-Patch";
    static final Logger logger = Logger.getLogger(AcceptPatchHeaderFilter.class.getName());

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext)
            throws IOException {

        logger.info("The method is "+requestContext.getMethod());
        if (HttpMethod.OPTIONS.equals(requestContext.getMethod())) {
            final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
            if (!headers.containsKey(ACCEPT_PATCH_HEADER)) {
                logger.info("Adding "+ACCEPT_PATCH_HEADER+" : "+Patching.PATCH_MEDIA_TYPE);
                headers.putSingle(ACCEPT_PATCH_HEADER, Patching.PATCH_MEDIA_TYPE);
            }
        }
        
        responseContext.getHeaders().add( "Access-Control-Allow-Origin", "*" );
        responseContext.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseContext.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH" );
    }
}
