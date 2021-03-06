/**
 * Copyright 2015 Q24
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.kahu.hawaii.sso.util;

import com.nimbusds.jose.jwk.JWKSet;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

public class FileJsonWebKeySetRepository implements JsonWebKeySetRepository {
    private JWKSet jsonWebKeySet;

    public FileJsonWebKeySetRepository(String file) throws IOException, ParseException {
        this(new File(file));
    }

    public FileJsonWebKeySetRepository(URL url) throws URISyntaxException, IOException, ParseException {
        this(new File(url.toURI()));
    }

    public FileJsonWebKeySetRepository(File file) throws IOException, ParseException {
        String jwks = FileUtils.readFileToString(file);
        this.jsonWebKeySet = JWKSet.parse(jwks);
    }

    @Override
    public JWKSet get(String iss, String kid) {
        return jsonWebKeySet;
    }
}
