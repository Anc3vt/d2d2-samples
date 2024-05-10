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
import com.ancevt.d2d2.common.PlainRect;
import com.ancevt.d2d2.debug.FpsMeter;
import com.ancevt.d2d2.display.Color;
import com.ancevt.d2d2.display.AnimatedSprite;
import com.ancevt.d2d2.display.IAnimated;
import com.ancevt.d2d2.display.Stage;

import java.util.Random;

public class AnimatedDemo implements D2D2Main {

    public static void main(String[] args) {
        D2D2.init(AnimatedDemo.class, args);
    }

    private static final Random random = new Random();

    @Override
    public void onCreate(Stage stage) {
        // Set the scene background color
        stage.setBackgroundColor(0x000010);

        // Create some background elements
        createSomeBackground();

        // Create an animated sprite
        IAnimated anim = new AnimatedSprite(
            // Load the texture atlas and create textures
            D2D2.textureManager().loadTextureAtlas("d2d2-samples-tileset.png").createTexturesHor(256, 128, 48, 48, 4)
        );

        // Set the scale of the sprite
        anim.setScale(8, 8);
        // Set the animation slowing factor
        anim.setSlowing(15);
        // Set the animation infinity loop
        anim.setLoop(true);
        // Start playing the animation
        anim.play();

        // Add the animated sprite to the stage
        stage.add(anim, 100, 100);

        // Add an FPS meter to the stage
        stage.add(new FpsMeter());
    }


    private void createSomeBackground() {
        Stage stage = D2D2.stage();

        for (int i = 0; i < stage.getHeight() * 2; i++) {
            float size = random.nextFloat(1f, 100f);

            PlainRect plainRect = new PlainRect(size, 5, Color.WHITE) {
                @Override
                public void onLoopUpdate() {
                    moveX(-1 * getY() / 50);

                    if (getX() < -getWidth()) {
                        setX(stage.getWidth());
                    }
                }
            };

            plainRect.setAlpha(0.05f);

            stage.add(plainRect, random.nextFloat(stage.getWidth()), i / 2);
        }
    }
}
