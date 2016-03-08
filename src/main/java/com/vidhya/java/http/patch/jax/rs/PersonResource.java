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

import com.vidhya.java.http.patch.jax.rs.entity.Person;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
                + "        <title>HTTP Patch demo</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1> Welcome to HTTP PATCH demo </h1>\n"
                + "<h4> The latest is <h3> "+ 
                entityStorage.getPerson().toString()
                + "</h3> </h4>"
                + "    </body>\n"
                + "</html>";
    }
    
    @Path("/person")
    @javax.ws.rs.GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return entityStorage.getPerson();
    }

    /**
     * PUT method for updating an instance of PersonResource
     * @param person representation for the resource
     */
    @Path("/person")
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void setPerson(Person person) {
        entityStorage.setPerson(person);
    }
    
    @Path("/person")
    @PATCH
    @Consumes(Patching.PATCH_MEDIA_TYPE)
    public Person patchPerson(Person person) {
        entityStorage.setPerson(person);
        return entityStorage.getPerson();
    }
}

