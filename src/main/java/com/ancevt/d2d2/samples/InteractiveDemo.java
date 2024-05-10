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
import com.ancevt.d2d2.display.Sprite;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.text.BitmapText;
import com.ancevt.d2d2.event.InteractiveEvent;
import com.ancevt.d2d2.display.interactive.InteractiveContainer;

public class InteractiveDemo implements D2D2Main {

    public static void main(String[] args) {
        D2D2.init(InteractiveDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        // Create a text object for status display
        BitmapText statusText = new BitmapText();
        // Set the text scale
        statusText.setScale(3, 3);
        // Add the text to the stage and set its position
        stage.add(statusText, 300, 50);

        // Create an interactive container with the sprite "flower.png"
        InteractiveContainer interactiveContainer = new InteractiveContainer(new Sprite("flower.png"));

        // Register a listener for the DOWN event for the container
        interactiveContainer.addEventListener(InteractiveEvent.DOWN, event -> {
            interactiveContainer.move(2, 2);
            statusText.setText("InteractiveEvent.DOWN");
        });

        // Register a listener for the UP event for the container
        interactiveContainer.addEventListener(InteractiveEvent.UP, event -> {
            interactiveContainer.move(-2, -2);
            statusText.setText("InteractiveEvent.UP");
        });

        // Register a listener for the HOVER event for the container
        interactiveContainer.addEventListener(InteractiveEvent.HOVER, event -> {
            interactiveContainer.setAlpha(1);
            statusText.setColor(Color.WHITE);
            statusText.setText("InteractiveEvent.HOVER");
        });

        // Register a listener for the OUT event for the container
        interactiveContainer.addEventListener(InteractiveEvent.OUT, event -> {
            interactiveContainer.setAlpha(0.5f);
            statusText.setColor(Color.GRAY);
            statusText.setText("InteractiveEvent.OUT");
        });

        // Register a listener for the KEY_TYPE event for the container
        interactiveContainer.addEventListener(InteractiveEvent.KEY_TYPE, event -> {
            InteractiveEvent e = event.casted();
            // Get the key type
            String keyType = e.getKeyType();
            // Set the status text
            statusText.setText("InteractiveEvent.KEY_TYPE:\n" + keyType);
        });

        // Add the container to the stage
        stage.add(interactiveContainer);
    }

}
