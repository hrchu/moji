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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class AbstractDataFolder implements DataFolder {
    static final String FILE_SEPARATOR_REPLACEMENT;
    static final String PACKAGE_DELIMITER_PATTERN;
    File folder;

    AbstractDataFolder() {
    }

    public File getFolder() throws IOException {
        if (!this.folder.exists()) {
            throw new FileNotFoundException(this.folder.getAbsolutePath());
        } else if (!this.folder.canRead()) {
            throw new IOException("Cannot read '" + this.folder.getAbsolutePath() + "'");
        } else if (!this.folder.isDirectory()) {
            throw new IOException("Path is not a directory '" + this.folder.getAbsolutePath() + "'");
        } else {
            return this.folder;
        }
    }

    public File getFile(String relativePath) throws IOException {
        return new File(this.getFolder(), relativePath);
    }

    public String getAbsolutePath(String relativePath) throws IOException {
        return this.internalGetAbsolutePath(relativePath);
    }

    public URI getUri(String relativePath) throws IOException {
        try {
            return new URI("file://" + this.internalGetAbsolutePath(relativePath));
        } catch (URISyntaxException var3) {
            URISyntaxException e = var3;
            throw new IOException(e);
        }
    }

    private String internalGetAbsolutePath(String relativePath) throws IOException {
        return (new File(this.getFolder(), relativePath)).getAbsolutePath();
    }

    static {
        FILE_SEPARATOR_REPLACEMENT = Matcher.quoteReplacement(File.separator);
        PACKAGE_DELIMITER_PATTERN = Pattern.quote(".");
    }
}

