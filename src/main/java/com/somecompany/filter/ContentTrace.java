package com.somecompany.filter;

import lombok.Data;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContentTrace {

    protected HttpTrace httpTrace;

    protected String requestBody;

    protected String responseBody;

    protected Authentication principal;

    public ContentTrace() {
    }

    public void setHttpTrace(HttpTrace httpTrace) {
        this.httpTrace = httpTrace;
    }
}
