/**
 * Copyright (C) 2012-2024 Last.fm & The "mogilefs-moji" committers
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
package fm.last.moji.integration;


import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.io.File;

public final class RootDataFolder extends AbstractDataFolder {


    public RootDataFolder(String... children) {
        StringBuilder path = new StringBuilder();
        path.append("src");
        path.append(File.separator);
        path.append("test");
        path.append(File.separator);
        path.append("data");
        String[] arr$ = children;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String child = arr$[i$];
            path.append(File.separator);
            path.append(child);
        }

        this.folder = new File(path.toString());
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return statement;
    }
}
