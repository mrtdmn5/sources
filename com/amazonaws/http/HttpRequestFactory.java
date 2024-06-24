package com.amazonaws.http;

import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequestFactory {
    private static final String DEFAULT_ENCODING = "UTF-8";

    private void configureHeaders(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI endpoint = request.getEndpoint();
        String host = endpoint.getHost();
        if (HttpUtils.isUsingNonDefaultPort(endpoint)) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(host, ":");
            m.append(endpoint.getPort());
            host = m.toString();
        }
        map.put(HttpHeader.HOST, host);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("Content-Type") == null || map.get("Content-Type").isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + StringUtils.lowerCase("UTF-8"));
        }
        if (executionContext != null && executionContext.getContextUserAgent() != null) {
            map.put(HttpHeader.USER_AGENT, createUserAgentString(clientConfiguration, executionContext.getContextUserAgent()));
        }
    }

    private String createUserAgentString(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.getUserAgent().contains(str)) {
            return clientConfiguration.getUserAgent();
        }
        return clientConfiguration.getUserAgent() + " " + str;
    }

    public HttpRequest createHttpRequest(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        String appendUri;
        boolean z;
        boolean z2;
        URI endpoint = request.getEndpoint();
        boolean z3 = true;
        if (request.getEncodedUriResourcePath() != null) {
            appendUri = HttpUtils.appendUriEncoded(endpoint.toString(), request.getEncodedUriResourcePath());
        } else {
            appendUri = HttpUtils.appendUri(endpoint.toString(), request.getResourcePath(), true);
        }
        String encodeParameters = HttpUtils.encodeParameters(request);
        HttpMethodName httpMethod = request.getHttpMethod();
        if (request.getContent() != null) {
            z = true;
        } else {
            z = false;
        }
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if (httpMethod == httpMethodName) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && !z) {
            z3 = false;
        }
        if (encodeParameters != null && z3) {
            appendUri = AbstractResolvableFuture$$ExternalSyntheticOutline0.m(appendUri, "?", encodeParameters);
        }
        HashMap hashMap = new HashMap();
        configureHeaders(hashMap, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (httpMethod == httpMethodName2) {
            hashMap.put("X-HTTP-Method-Override", httpMethodName2.toString());
            httpMethod = httpMethodName;
        }
        if (httpMethod == httpMethodName && request.getContent() == null && encodeParameters != null) {
            byte[] bytes = encodeParameters.getBytes(StringUtils.UTF8);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            hashMap.put("Content-Length", String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (clientConfiguration.isEnableGzip() && hashMap.get("Accept-Encoding") == null) {
            hashMap.put("Accept-Encoding", "gzip");
        } else {
            hashMap.put("Accept-Encoding", "identity");
        }
        HttpRequest httpRequest = new HttpRequest(httpMethod.toString(), URI.create(appendUri), hashMap, content);
        httpRequest.setStreaming(request.isStreaming());
        return httpRequest;
    }
}
