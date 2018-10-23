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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import com.vidhya.java.http.jax.rs.fileupload.FileUploadResource;

/**
 *
 * @author vidhya (it.vidhyadharan@gmail.com)
 */
public class FileUploadResourceTest {

    @Test
    public void testFileUpload() throws FileNotFoundException, URISyntaxException {

        FileUploadResource fUpload = new FileUploadResource();
        URL resourceURL = FileUploadResourceTest.class.getResource("upload-test-sample.txt");
        File file = new File(resourceURL.toURI());
        Response postOctetStream = fUpload.postOctetStream(new FileInputStream(file));
        Integer fileSize = (Integer) postOctetStream.getEntity();
        Assert.assertThat("Verify the response bytes ", 30, is(equalTo(fileSize)));
    }

    @Test
    public void testFileImgUpload() throws FileNotFoundException, URISyntaxException {

        FileUploadResource fUpload = new FileUploadResource();
        URL resourceURL = FileUploadResourceTest.class.getResource("image-png-sample.png");
        File file = new File(resourceURL.toURI());
        Response postOctetStream = fUpload.postImageFile(file);
        Integer fileSize = (Integer) postOctetStream.getEntity();
       // Assert.assertThat("Verify the image file size ", 530, is(equalTo(fileSize)));

    }
    
    /*  
    @Test(expected = IOException.class)
    public void testFileUploadException() throws IOException {

        FileUploadResource fUpload = new FileUploadResource();
        URL resourceURL = FileUploadResourceTest.class.getResource("upload-test-sample.txt");
        InputStream file = null;
        Response postOctetStream = fUpload.postOctetStream(new BufferedInputStream(file));
    }
    
    
   @Test(expected= FileNotFoundException.class)
    public void testFileUploadExceptionPNG() throws FileNotFoundException, URISyntaxException {

    	FileUploadResource fUpload = new FileUploadResource();
        URL resourceURL = FileUploadResourceTest.class.getResource("image-png-sample.png");
        //File file = new File(resourceURL.toURI());
        Response postOctetStream = fUpload.postImageFile(new File("Vidhya"));
        
    }*/


}
