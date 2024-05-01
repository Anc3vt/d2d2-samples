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
import com.ancevt.d2d2.lifecycle.D2D2Main;
import com.ancevt.d2d2.display.Color;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.text.BitmapFont;
import com.ancevt.d2d2.display.text.BitmapText;
import com.ancevt.d2d2.display.text.TrueTypeBitmapFontBuilder;

public class BitmapTextDemo extends D2D2Main {

    public static void main(String[] args) {
        D2D2.init(BitmapTextDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {

        // ------------ Example 1 ------------

        // Create the first bitmap text with the default bitmap font, customize it, and place it on the stage
        BitmapText bitmapText1 = new BitmapText();
        bitmapText1.setText("bitmapText1: Using default bitmap font\nSecond line...\nThird...");
        bitmapText1.setColor(Color.YELLOW);
        bitmapText1.setScale(2, 2);
        stage.add(bitmapText1, 100, 100);


        // ------------ Example 2 ------------

        // Create the second bitmap text by generating a bitmap font from any TrueType font
        // using TtfBitmapFontBuilder
        BitmapFont bitmapFont = new TrueTypeBitmapFontBuilder()
            .fontSize(24)
            .assetPath("d2d2ttf/FreeSansBold.ttf")
            .textAntialias(true)
            .build();

        BitmapText bitmapText2 = new BitmapText(bitmapFont);
        bitmapText2.setText("bitmapText2: Using TtfBitmapFontBuilder\n generated bitmap font");
        bitmapText2.setColor(Color.GREEN);
        // place it on the stage
        stage.add(bitmapText2, 100, 200);


        // ------------ Example 3 ------------

        // Create the third bitmap text using a bitmap font that has already been created
        // The following code demonstrates the ability to use multicolor in bitmap text
        // using hex-RGB tags in the format <FFFFFF>
        BitmapText bitmapText3 = new BitmapText(bitmapFont);
        // Enable multicolor
        bitmapText3.setMulticolor(true);
        // Multicolor text should start with the `#` sign. It will not be rendered and will only signal
        // to the bitmap text that it should be rendered using multicolor
        bitmapText3.setText("bitmapText3: <FF00FF>multicolor<FF99EE> bitmap<0000FF> text\n" +
            "<AABBEE>The second line of bitmap text");

        stage.add(bitmapText3, 100, 300);
        // place it on the stage

    }

}
