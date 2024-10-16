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

import org.junit.rules.TestRule;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface DataFolder extends TestRule {
    File getFolder() throws IOException;

    File getFile(String var1) throws IOException;

    String getAbsolutePath(String var1) throws IOException;

    URI getUri(String var1) throws IOException;
}

