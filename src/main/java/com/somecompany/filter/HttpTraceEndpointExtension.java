package com.somecompany.filter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.trace.http.HttpTraceEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EndpointWebExtension(endpoint = HttpTraceEndpoint.class)
@ConditionalOnProperty(prefix = "management.trace.http", name = "enabled", matchIfMissing = true)
public class HttpTraceEndpointExtension {

    private CustomHttpTraceRepository repository;

    public HttpTraceEndpointExtension(@Qualifier("CustomHttpTraceRepository") CustomHttpTraceRepository repository) {
        super();
        this.repository = repository;
    }

    @ReadOperation
    public ContentTraceDescriptor contents() {
        List<ContentTrace> traces = repository.findAllWithContent();
        return new ContentTraceDescriptor(traces);
    }
}
