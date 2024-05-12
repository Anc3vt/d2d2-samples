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
import com.ancevt.d2d2.lifecycle.D2D2Application;
import com.ancevt.util.args.Args;

public class DemoStarter {

    public static void main(String[] args) throws ClassNotFoundException {
        Args a = Args.of(args);
        String simpleClassName = a.hasNext() ? a.next() : "AnimatedDemo";
        Class<?> clazz = Class.forName(FrameworkInitDemo.class.getPackageName() + "." + simpleClassName);
        D2D2.init((Class<? extends D2D2Application>) clazz, args);
    }

}
