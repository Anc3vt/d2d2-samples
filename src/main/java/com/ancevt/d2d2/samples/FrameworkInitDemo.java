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
import com.ancevt.d2d2.debug.FpsMeter;
import com.ancevt.d2d2.display.Stage;

// The main class of the D2D2 application must inherit from D2D2Main
public class FrameworkInitDemo implements D2D2Main {

    // The entry point of the Java application
    public static void main(String[] args) {
        // Framework initialization with properties defined in src/resources/application.properties
        D2D2.init(FrameworkInitDemo.class, args);
    }

    @Override
    public void onCreate(Stage stage) {
        // Stage is the root container for the entire application
        stage.setBackgroundColor(0x002233);

        // D2D2 application code goes here
        // ...

        // Adding an FPS meter to the Stage. Can be useful for debugging
        stage.add(new FpsMeter());
    }

    @Override
    public void onDispose() {
        // This method is automatically called when the application is closed by the operating system's standard means
        // or after calling D2D2.exit()
        // Here, you should program resource cleanup, saving various states, etc.
    }

}
