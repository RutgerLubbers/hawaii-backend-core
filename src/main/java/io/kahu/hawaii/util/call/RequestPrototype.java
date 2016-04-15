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
package io.kahu.hawaii.util.call;

import io.kahu.hawaii.util.call.configuration.RequestConfiguration;
import io.kahu.hawaii.util.call.dispatch.RequestDispatcher;
import io.kahu.hawaii.util.call.log.CallLogger;

public class RequestPrototype<F, T>  {
    private final RequestDispatcher requestDispatcher;
    private ResponseHandler<F, T> responseHandler;
    private final CallLogger<T> logger;

    private RequestConfiguration<T> configuration;

    public RequestPrototype(RequestDispatcher requestDispatcher, RequestConfiguration<T> configuration, ResponseHandler<F, T> responseHandler, CallLogger<T> logger) {
        this.requestDispatcher = requestDispatcher;
        this.configuration = configuration;
        this.responseHandler = responseHandler;
        this.logger = logger;

    }

    public RequestPrototype(RequestPrototype<F, T> prototype) {
        this(prototype.requestDispatcher, prototype.configuration, prototype.responseHandler, prototype.logger);
    }

    public RequestDispatcher getRequestDispatcher() {
        return requestDispatcher;
    }

    public void setResponseHandler(ResponseHandler<F, T> responseHandler) {
        this.responseHandler = responseHandler;
    }

    public ResponseHandler<F, T> getResponseHandler() {
        return responseHandler;
    }

    public RequestConfiguration<T> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(RequestConfiguration<T> configuration) {
        this.configuration = configuration;
    }

    public CallLogger<T> getLogger() {
        return logger;
    }
}
