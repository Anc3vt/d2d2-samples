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

import com.ancevt.commons.string.ConvertableString;
import com.ancevt.d2d2.D2D2;
import com.ancevt.d2d2.components.dev.Console;
import com.ancevt.d2d2.debug.FpsMeter;
import com.ancevt.d2d2.display.Color;
import com.ancevt.d2d2.display.SimpleContainer;
import com.ancevt.d2d2.display.Container;
import com.ancevt.d2d2.display.DisplayObject;
import com.ancevt.d2d2.display.SimpleSprite;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.event.Event;
import com.ancevt.d2d2.event.InteractiveEvent;
import com.ancevt.d2d2.input.Mouse;
import com.ancevt.d2d2.lifecycle.D2D2Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;

public class SpriteNumberStressTestDemo implements D2D2Application {

    public static void main(String[] args) {
        D2D2.init(SpriteNumberStressTestDemo.class, args);
    }

    private final List<DisplayObject> objects = new ArrayList<>();


    @Override
    public void onCreate(Stage stage) {
        D2D2.engine().setSmoothMode(true);

        stage.setBackgroundColor(0x000011);

        Console console = new Console();

        Container container = new SimpleContainer();

        IntConsumer fn = num -> {
            container.removeChildren(objects);
            for (int i = 0; i < num; i++) {
                DSprite o = new DSprite();
                container.addChild(o);
                objects.add(o);
            }
        };

        console.addVariableListener("num", "1024", (varName, value) -> fn.accept(value.toIntOrDefault(1000)));

        stage.addChild(container);
        stage.addChild(console, 10, 10);
        stage.addChild(new FpsMeter());

        stage.addEventListener(InteractiveEvent.DOWN, e -> {
            fn.accept(ConvertableString.convert(console.getContext().get("num")).toIntOrDefault(1000));
        });
    }

    public static class DSprite extends SimpleContainer {

        private static final Random random = new Random();

        public DSprite() {
            float x = random.nextFloat(D2D2.stage().getWidth());
            float y = random.nextFloat(D2D2.stage().getHeight());
            float speed = random.nextFloat(0.01f, 0.25f);
            setXY(x, y);
            setScale(0.01f, 0.01f);

            SimpleSprite sprite = new SimpleSprite("d2d2-samples-tileset.png", 256, 176, 48, 48);
            sprite.setColor(Color.createRandomColor());
            sprite.setAlpha(random.nextFloat());
            sprite.setScale(random.nextFloat(0.1f, 3));

            sprite.addEventListener(Event.LOOP_UPDATE, event -> {
                if (Mouse.getX() < getX()) {
                    moveX(-speed * Math.abs(Mouse.getX() - getX()) / 10);
                } else {
                    moveX(speed * Math.abs(Mouse.getX() - getX()) / 10);
                }
                if (Mouse.getY() < getY()) {
                    moveY(-speed * Math.abs(Mouse.getY() - getY()) / 10);
                } else {
                    moveY(speed * Math.abs(Mouse.getY() - getY()) / 10);
                }
                if (getScaleX() < 1f) {
                    scale(1.1f, 1.1f);
                }
            });

            addChild(sprite, -sprite.getWidth() / 2, -sprite.getHeight() / 2);
        }

        @Override
        public void onLoopUpdate() {
            rotate(1f);
        }
    }
}
