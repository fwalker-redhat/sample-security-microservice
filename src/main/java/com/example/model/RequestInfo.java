package com.example.model;

import java.util.List;
import java.util.Map;

public class RequestInfo {

    private final String path;
    private final String method;
    private final String requester;
    private final Map<String, List<String>> headers;
    private final String principalName;

    public RequestInfo(String path, String method, String requester, Map<String, List<String>> headers, String principalName) {
        this.path = path;
        this.method = method;
        this.requester = requester;
        this.headers = headers;
        this.principalName = principalName;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public String getRequester() {
        return requester;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getPrincipalName() {
        return principalName;
    }
}
