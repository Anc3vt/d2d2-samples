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

public class SimpleSpriteDemo extends D2D2Main {

    public static void main(String[] args) {
        D2D2.init(SimpleSpriteDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        // Create a sprite with the image "flower.png".
        // The resource file flower.png should be located in the src/resources/assets/ directory.
        Sprite sprite = new Sprite("flower.png");

        // Since Sprite inherits properties from IDisplayObject,
        // we can customize it using IDisplayObject methods.

        // Set the coordinates of the sprite
        sprite.setXY(100, 100);
        // Set the transparency of the sprite (value from 0.0f to 1.0f)
        sprite.setAlpha(0.75f);
        // Set the rotation angle of the sprite (degrees, values 0 - 360)
        sprite.setRotation(45);
        // Set the number of repetitions of the sprite along the X-axis
        sprite.setRepeatX(5);
        // Set the scale of the sprite along the X and Y axes. In the example below, we reduce the sprite size by half from the original.
        sprite.setScale(0.5f, 0.5f);

        // Add the sprite to the stage
        stage.add(sprite);
    }
}
