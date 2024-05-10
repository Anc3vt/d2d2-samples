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
import com.ancevt.d2d2.display.Container;
import com.ancevt.d2d2.display.IContainer;
import com.ancevt.d2d2.display.Sprite;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.event.Event;

public class ContainerCenterRotateDemo implements D2D2Main {

    public static void main(String[] args) {
        D2D2.init(ContainerCenterRotateDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        IContainer container = new Container();

        Sprite sprite = new Sprite("flower.png");

        container.add(sprite, -sprite.getWidth()/2, -sprite.getHeight()/2);

        container.addEventListener(Event.LOOP_UPDATE, event -> {
            container.rotate(-5);
        });

        stage.add(container, 400, 300);
    }
}
