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
import com.ancevt.d2d2.display.texture.TextureClip;
import com.ancevt.d2d2.lifecycle.D2D2Application;
import com.ancevt.d2d2.display.SimpleSprite;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.texture.TextureAtlas;
import com.ancevt.d2d2.display.texture.TextureManager;

public class TextureManagerDemo implements D2D2Application {

    public static void main(String[] args) {
        D2D2.init(TextureManagerDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        // Get the texture manager from D2D2
        TextureManager textureManager = D2D2.textureManager();
        // Load the texture atlas from src/resources/assets/
        TextureAtlas textureAtlas = textureManager.loadTextureAtlas("d2d2-samples-tileset.png");
        // Create a texture from the atlas with the specified coordinates and dimensions
        TextureClip textureClip = textureAtlas.createTextureClip(256, 0, 144, 128);
        // Create a sprite using the created texture
        SimpleSprite sprite = new SimpleSprite(textureClip);

        // Add the sprite to the stage
        stage.addChild(sprite);
        // Center the sprite on the stage
        sprite.center();
    }

}
