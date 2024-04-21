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
import com.ancevt.d2d2.common.BorderedRect;
import com.ancevt.d2d2.display.Color;
import com.ancevt.d2d2.display.Container;
import com.ancevt.d2d2.display.IContainer;
import com.ancevt.d2d2.display.Sprite;
import com.ancevt.d2d2.display.Stage;

public class ContainerDemo extends D2D2Main {

    public static void main(String[] args) {
        D2D2.init(ContainerDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        // Initially, empty containers are invisible for user, so for convenience, let's create a rectangle
        // that will serve as a visual frame for our container
        BorderedRect borderedRect = new BorderedRect(500, 500, Color.NO_COLOR, Color.DARK_GRAY);

        // Create a container with an instant placement of the frame into it
        IContainer container = new Container(borderedRect);

        // Create two sprites
        Sprite sprite1 = new Sprite("flower.png");
        Sprite sprite2 = new Sprite("flower.png");

        // Place the sprites in the container specifying their positions relative to the container
        // The `add` method overload below allows setting the coordinates of the added display object
        // in the container directly, instead of calling setXY for each sprite separately
        container.add(sprite1, 50, 50);
        container.add(sprite2, 200, 200);

        // Rotate the entire container by 10 degrees
        // When rendered, all content of the container will also rotate along with the container
        container.rotate(10);

        // Add our container to the stage. In fact, Stage is also a container, since
        // it implements the IContainer interface
        stage.add(container, 100, 100);

        // However, accessing properties of objects placed inside the container
        // will remain unchanged
    }

}
