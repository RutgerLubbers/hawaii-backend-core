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
package io.kahu.hawaii.util.call.configuration;

import io.kahu.hawaii.util.call.RequestName;
import io.kahu.hawaii.util.call.TimeOut;
import io.kahu.hawaii.util.call.http.HttpRequestConfiguration;
import org.jolokia.jmx.JsonMBean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@JsonMBean
public class RequestConfigurations {
    private final Map<RequestName, RequestConfiguration> configurations = new HashMap<>();

    public RequestConfiguration get(RequestName requestName) {
        return get(requestName, () -> new RequestConfiguration(requestName));

    }

    public <T extends RequestConfiguration> T get(RequestName requestName, Supplier<T> supplier) {
        T configuration = (T) configurations.get(requestName);
        if (configuration == null) {
            configuration = supplier.get();
            configurations.put(requestName, configuration);
        }
        return configuration;
    }

    public void setTimeOut(String system, String method, int timeOut) {
        get(new RequestName(system, method)).setTimeOut(new TimeOut(timeOut, TimeUnit.SECONDS));
    }

    public void setExecutorName(String system, String method, String queue) {
        get(new RequestName(system, method)).setExecutorName(queue);
    }

    public void changeUrl(String system, String method, String url) {
        HttpRequestConfiguration configuration = (HttpRequestConfiguration) get(new RequestName(system, method));
        configuration.setBaseUrl(url);
    }

}
