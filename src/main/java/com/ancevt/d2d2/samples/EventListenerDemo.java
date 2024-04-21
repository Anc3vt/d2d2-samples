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
import com.ancevt.d2d2.display.Sprite;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.text.BitmapText;
import com.ancevt.d2d2.event.Event;

public class EventListenerDemo extends D2D2Main {

    public static void main(String[] args) {
        D2D2.init(EventListenerDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {

        // ------------ Example 1 ------------

        // Create a status text for demonstration convenience
        BitmapText statusText = new BitmapText();
        statusText.setScale(3, 3);
        stage.add(statusText, 10, 10);

        // For example, register a listener for the RESIZE event for the Stage
        // When the window size changes (or when switching to fullscreen mode)
        // our status text will be updated
        stage.addEventListener(Event.RESIZE, event -> {
            float width = stage.getWidth();
            float height = stage.getHeight();

            statusText.setText((int) width + "x" + (int) height);
        });


        // ------------ Example 2 ------------

        // Create a sprite and set its coordinates
        Sprite sprite = new Sprite("flower.png");
        sprite.setXY(400, 300);

        // Register a listener for the LOOP_UPDATE event
        // In the code below, we rotate the sprite by 10 degrees counterclockwise at each update
        // of the D2D2 main loop. Thus, our sprite will rotate rapidly
        sprite.addEventListener(Event.LOOP_UPDATE, event -> {
            sprite.rotate(-5);
        });

        // Add the sprite to the stage
        stage.add(sprite);
    }

}
