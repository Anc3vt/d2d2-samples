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
import com.ancevt.d2d2.D2D2Main;
import com.ancevt.d2d2.engine.VideoMode;
import com.ancevt.d2d2.engine.VideoModeControl;
import com.ancevt.d2d2.components.Button;
import com.ancevt.d2d2.components.ComponentAssets;
import com.ancevt.d2d2.display.Container;
import com.ancevt.d2d2.display.IContainer;
import com.ancevt.d2d2.display.Stage;
import com.ancevt.d2d2.display.text.BitmapText;
import com.ancevt.d2d2.event.InputEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class VideoModeDemo extends D2D2Main {

    public static void main(String[] args) {
        D2D2.init(VideoModeDemo.class);
    }

    private final List<Button> buttons = new ArrayList<>();

    @Override
    public void onCreate(Stage stage) {
        ComponentAssets.init();

        BitmapText statusBitmapText = new BitmapText("");
        stage.add(statusBitmapText);

        VideoModeControl videoModeControl = D2D2.engine().getVideoModeControl();

        long primaryMonitorId = videoModeControl.getPrimaryMonitorId();
        int maxRefreshRate = videoModeControl.getMaxRefreshRate(primaryMonitorId);

        List<VideoMode> videoModes = videoModeControl.getVideoModes(primaryMonitorId);

        float x = 20;
        float y = 0;

        IContainer container = new Container();

        for (VideoMode videoMode : videoModes) {
            Button button = new Button(videoMode.getResolution() + " " + videoMode.getRefreshRate());
            button.setWidth(110);

            button.addEventListener(Button.ButtonEvent.BUTTON_PRESSED, event -> {
                container.setScale(1, 1);
                disableButtons();
                videoModeControl.setCurrentVideoMode(primaryMonitorId, videoMode);

                CompletableFuture.runAsync(() -> {
                    for (int i = 5; i >= 0; i--) {
                        try {
                            Thread.sleep(1000);
                            statusBitmapText.setText(i + "");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    videoModeControl.reset(primaryMonitorId);
                    enableButtons();
                    container.setScale(1, 1);
                    statusBitmapText.setText("");

                    D2D2.engine().setWindowXY(10, 10);
                    D2D2.engine().setWindowSize((int) D2D2.stage().getWidth(), (int) D2D2.stage().getHeight());
                });
            });

            container.add(button, x, y);

            buttons.add(button);

            y += button.getHeight();
            if (y >= 400) {
                y = 0;
                x += 100;
            }
        }

        Button resetButton = new Button("reset");
        buttons.add(resetButton);

        resetButton.addEventListener(Button.ButtonEvent.BUTTON_PRESSED, event -> {
            videoModeControl.reset(primaryMonitorId);
        });

        container.add(resetButton, x, y);

        stage.add(container);

        stage.addEventListener(InputEvent.MOUSE_WHEEL, event -> {
            InputEvent e = event.casted();

            if (e.getDelta() > 0) {
                container.toScale(1.1f, 1.1f);
            } else {
                container.toScale(0.9f, 0.9f);
            }

            if (container.getScaleX() < 0.5f) {
                container.setScale(0.5f, 0.5f);
            } else if (container.getScaleX() > 1.0f) {
                container.setScale(1.0f, 1.0f);
            }
        });
    }

    public void enableButtons() {
        buttons.forEach(b -> b.setEnabled(true));
    }

    public void disableButtons() {
        buttons.forEach(b -> b.setEnabled(false));
    }


}
