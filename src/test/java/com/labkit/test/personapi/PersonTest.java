/*
 *  The MIT License (MIT)
 * 
 * Copyright (c) 2018 Vidhyadharan Deivamani < it.vidhyadharan@gmail.com >
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
package com.labkit.test.personapi;

import com.vidhya.java.http.patch.jax.rs.entity.Person;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 *
 * @author Vidhyadharan Deivamani (it.vidhyadharan@gmail.com)
 */
public class PersonTest {
    
    static Person vidhya =null;
    @BeforeClass
    public static void intialize() {
        vidhya = new Person();
        vidhya.setAge(30);
        vidhya.setEmail("it.vidhyadharan@gmail.com");
        vidhya.setTwitter("vidhya03");
        vidhya.setLocale("English");
        vidhya.setName("Vidhyadharan Deivamani");
    }

    @Test
    public void testPerson() {
        Assert.assertThat("Verify age",31,is(equalTo(vidhya.getAge())));
        Assert.assertThat("Verify Name","Vidhyadharan Deivamani",is(equalTo(vidhya.getName())));
        Assert.assertThat("Verify Locale","English",is(equalTo(vidhya.getLocale())));
        Assert.assertThat("Verify Twitter","vidhya03",is(equalTo(vidhya.getTwitter())));
        Assert.assertThat("Verify Email","it.vidhyadharan@gmail.com",is(equalTo(vidhya.getEmail())));
    }
    
}
