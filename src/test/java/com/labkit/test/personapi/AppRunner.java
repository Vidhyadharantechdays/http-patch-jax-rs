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

import com.intuit.karate.ui.App;

/**
 * 
 * Class used for debugging the DSL feature. This will run the javafx ui
 * so that used for debugging.
 *
 * @author Vidhyadharan Deivamani (it.vidhyadharan@gmail.com)
 */
public class AppRunner {
    
    public static void main(String ... args){
        System.setProperty("karate.env", "dev");
        ClassLoader loader = AppRunner.class.getClassLoader();
        /* change the bellow feature and run&debug your DSL */
        String filePath = loader.getResource("com/labkit/test/personapi/ApiResource.feature").getFile();
        App.run(filePath,"prod");
    }
}
