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
import org.apache.http.annotation.NotThreadSafe;

import java.util.concurrent.TimeUnit;

@NotThreadSafe
public class RequestConfiguration<T> {
    private RequestName requestName;
    private T rejected;
    private T aborted;
    private String executorName;
    private TimeOut defaultTimeOut = new TimeOut(10, TimeUnit.SECONDS);
    private TimeOut timeOut = null;

    public RequestConfiguration(RequestName requestName) {
        this.requestName = requestName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public TimeOut getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(TimeOut timeOut) {
        this.timeOut = timeOut;
    }

    public TimeOut getTimeOutOrDefaultIfUnset() {
        if (timeOut == null) {
            return defaultTimeOut;
        }
        return timeOut;
    }

    public RequestName getRequestName() {
        return requestName;
    }

    public T getRejectResponse() {
        return rejected;
    }

    public void setRejectResponse(T rejected) {
        this.rejected = rejected;
    }

    public T getTimeOutResponse() {
        return aborted;
    }

    public void setTimeOutResponse(T aborted) {
        this.aborted = aborted;
    }

    public void updateFrom(RequestConfiguration<T> configuration) {
        this.setTimeOut(configuration.getTimeOut());
        this.setExecutorName(configuration.getExecutorName());
        this.setTimeOutResponse(configuration.getTimeOutResponse());
        this.setRejectResponse(configuration.getRejectResponse());
    }

}
