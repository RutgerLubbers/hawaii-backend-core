package io.kahu.hawaii.util.call;

import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class RequestName {
    private final String system;
    private final String method;

    public RequestName(String system, String method) {
        this.system = system;
        this.method = method;
    }

    public String getSystem() {
        return system;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return system + "." + method;
    }
}
