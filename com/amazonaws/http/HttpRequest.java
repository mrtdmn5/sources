package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest {
    private final InputStream content;
    private final Map<String, String> headers;
    private boolean isStreaming;
    private final String method;
    private URI uri;

    public HttpRequest(String str, URI r3) {
        this(str, r3, null, null);
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        String str;
        Map<String, String> map = this.headers;
        if (map == null || (str = map.get("Content-Length")) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean isStreaming() {
        return this.isStreaming;
    }

    public void setStreaming(boolean z) {
        this.isStreaming = z;
    }

    public void setUri(URI r1) {
        this.uri = r1;
    }

    public HttpRequest(String str, URI r2, Map<String, String> map, InputStream inputStream) {
        Map<String, String> unmodifiableMap;
        this.method = StringUtils.upperCase(str);
        this.uri = r2;
        if (map == null) {
            unmodifiableMap = Collections.EMPTY_MAP;
        } else {
            unmodifiableMap = Collections.unmodifiableMap(map);
        }
        this.headers = unmodifiableMap;
        this.content = inputStream;
    }
}
