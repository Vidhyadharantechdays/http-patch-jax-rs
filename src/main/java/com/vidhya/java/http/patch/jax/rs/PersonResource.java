/*
 *  The MIT License (MIT)
 * 
 * Copyright (c) 2017 Vidhyadharan Deivamani < it.vidhyadharan@gmail.com >
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

import com.vidhya.java.http.patch.jax.rs.entity.Person;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vidhya (it.vidhyadharan@gmail.com)
 */

@Stateless
@Path("/")
public class PersonResource {

    @EJB
    private EntityStorageBean entityStorage;
    final private String changelist ="beta.v.1.2.1";
    /**
     * Retrieves current Person
     * @return an instance of Person
     */
    @GET
    @Produces("text/html")
    public String getGreeting() {
        return "<html>\n"
                + "     <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>RESTful service - Person API</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>  Welcome to Person API.</h1>\n"
                + "       <small>"+changelist+"</small>"
                + "<h4> The latest is "+ 
                entityStorage.getPerson().toString()
                + "</h4>"
                + "    </body>\n"
                + "</html>";
    }
    
    @Path("/v1/person")
    @javax.ws.rs.GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return entityStorage.getPerson();
    }
    
    @Path("/webapp/t1")
    @javax.ws.rs.GET
    @Produces(MediaType.TEXT_HTML)
    public String getT1() {
         return "<html>\n"
                + "     <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>Webapp T1</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>  Welcome to Web application T1.</h1>\n"
                + "       <small>"+changelist+"</small>"
                + "    </body>\n"
                + "</html>";
    }
    @Path("/webapp/t2")
    @javax.ws.rs.GET
    @Produces(MediaType.TEXT_HTML)
    public String getT2() {
         return "<html>\n"
                + "     <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>Webapp T2</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>  Welcome to Web application T2.</h1>\n"
                + "       <small>"+changelist+"</small>"
                + "    </body>\n"
                + "</html>";
    }

    /**
     * PUT method for updating an instance of PersonResource
     * @param person representation for the resource
     */
    @Path("/v1/person")
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void setPerson(Person person) {
        entityStorage.setPerson(person);
    }
    
    
     /**
     * POST method for updating an instance of PersonResource
     * @param person representation for the resource
     */
    @Path("/v1/person")
    @POST
    @Consumes({"application/xml", "application/json"})
    public void postPerson(Person person) {
        entityStorage.setPerson(person);
    }
    
    @Path("/v1/person")
    @PATCH
    @Consumes(Patching.PATCH_MEDIA_TYPE)
    public Person patchPerson(Person person) {
        entityStorage.setPerson(person);
        return entityStorage.getPerson();
    }
}

