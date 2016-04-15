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
package io.kahu.hawaii.util.call.http;

import io.kahu.hawaii.util.call.RequestPrototype;
import io.kahu.hawaii.util.call.ResponseHandler;
import io.kahu.hawaii.util.call.configuration.RequestConfiguration;
import io.kahu.hawaii.util.call.dispatch.RequestDispatcher;
import io.kahu.hawaii.util.call.log.CallLogger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.net.URI;

public class GetRequest<T> extends AbortableHttpRequest<T> {

    public GetRequest(RequestDispatcher requestDispatcher, RequestConfiguration<T> configuration, URI uri, ResponseHandler<HttpResponse, T> responseHandler,
                      CallLogger<T> logger) {
        super(requestDispatcher, configuration, responseHandler, new HttpGet(uri), logger);
    }

    public GetRequest(RequestPrototype prototype, URI uri) {
        super(prototype, new HttpGet(uri));
    }
}
