package com.amplifyframework.api.rest;

import androidx.core.util.ObjectsCompat$Api19Impl;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class RestOperationRequest {
    private final byte[] data;
    private final Map<String, String> headers;
    private final HttpMethod httpMethod;
    private final String path;
    private final Map<String, String> queryParameters;

    public RestOperationRequest(HttpMethod httpMethod, String str, byte[] bArr, Map<String, String> map, Map<String, String> map2) {
        this.httpMethod = httpMethod;
        this.path = str;
        this.headers = map == null ? Collections.emptyMap() : Immutable.of(map);
        this.data = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.queryParameters = map2 == null ? Collections.emptyMap() : Immutable.of(map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestOperationRequest.class != obj.getClass()) {
            return false;
        }
        RestOperationRequest restOperationRequest = (RestOperationRequest) obj;
        if (!ObjectsCompat$Api19Impl.equals(getHttpMethod(), restOperationRequest.getHttpMethod()) || !ObjectsCompat$Api19Impl.equals(getPath(), restOperationRequest.getPath()) || !ObjectsCompat$Api19Impl.equals(getData(), restOperationRequest.getData()) || !ObjectsCompat$Api19Impl.equals(getHeaders(), restOperationRequest.getHeaders())) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(getQueryParameters(), restOperationRequest.getQueryParameters());
    }

    public byte[] getData() {
        return this.data;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, String> getQueryParameters() {
        return this.queryParameters;
    }

    public int hashCode() {
        int r0;
        int r2;
        int r02;
        int r1 = 0;
        if (getHttpMethod() != null) {
            r0 = getHttpMethod().hashCode();
        } else {
            r0 = 0;
        }
        int r03 = r0 * 31;
        if (getPath() != null) {
            r2 = getPath().hashCode();
        } else {
            r2 = 0;
        }
        int hashCode = (Arrays.hashCode(getData()) + ((r03 + r2) * 31)) * 31;
        if (getHeaders() != null) {
            r02 = getHeaders().hashCode();
        } else {
            r02 = 0;
        }
        int r22 = (hashCode + r02) * 31;
        if (getQueryParameters() != null) {
            r1 = getQueryParameters().hashCode();
        }
        return r22 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RestOperationRequest{httpMethod=");
        sb.append(this.httpMethod);
        sb.append(", path='");
        sb.append(this.path);
        sb.append("', data=");
        sb.append(Arrays.toString(this.data));
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", queryParameters=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.queryParameters, '}');
    }

    public RestOperationRequest(HttpMethod httpMethod, String str, Map<String, String> map, Map<String, String> map2) {
        this(httpMethod, str, null, map, map2);
    }
}
