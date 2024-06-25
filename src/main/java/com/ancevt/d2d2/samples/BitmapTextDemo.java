/**
 * Copyright (C) 2024 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ancevt.d2d2.samples;

import com.ancevt.d2d2.D2D2;
import com.ancevt.d2d2.display.text.Text;
import com.ancevt.d2d2.lifecycle.D2D2Application;
import com.ancevt.d2d2.display.Color;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.text.Font;
import com.ancevt.d2d2.display.text.TrueTypeFontBuilder;

public class BitmapTextDemo implements D2D2Application {

    public static void main(String[] args) {
        D2D2.init(BitmapTextDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {

        // ------------ Example 1 ------------

        // Create the first text with the default font, customize it, and place it on the stage
        Text text1 = new Text();
        text1.setText("text1: Using default font\nSecond line...\nThird...");
        text1.setColor(Color.YELLOW);
        text1.setScale(2, 2);
        stage.addChild(text1, 100, 100);


        // ------------ Example 2 ------------

        // Create the second text by generating a font from any TrueType font
        // using TrueTypeFontBuilder
        Font font = new TrueTypeFontBuilder()
            .fontSize(24)
            .assetPath("d2d2ttf/FreeSansBold.ttf")
            .textAntialias(true)
            .build();

        Text text2 = new Text(font);
        text2.setText("text2: Using TtfFontBuilder\n generated font");
        text2.setColor(Color.GREEN);
        // place it on the stage
        stage.addChild(text2, 100, 200);


        // ------------ Example 3 ------------

        // Create the third text using a font that has already been created
        // The following code demonstrates the ability to use multicolor in text
        // using hex-RGB tags in the format <FFFFFF>
        Text text3 = new Text(font);
        // Enable multicolor
        text3.setMulticolor(true);
        // Multicolor text should start with the `#` sign. It will not be rendered and will only signal
        // to the text that it should be rendered using multicolor
        text3.setText("text: <FF00FF>multicolor<FF99EE> text<0000FF> text\n" +
            "<AABBEE>The second line of text");

        stage.addChild(text3, 100, 300);
        // place it on the stage

    }

}
