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
import com.vidhya.java.http.patch.jax.rs.entity.PersonUtil;
import javax.ejb.Singleton;

/** Singleton session bean used to store the {@code com.vde.rest.entity.Person} in the resource
 *
 * @author vidhya (it.vidhyadharan@gmail.com)
 */
@Singleton
public class EntityStorageBean {

    // name field
    private Person person = PersonUtil.DefaultPerson();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
 
    
}
