package com.amplifyframework.api.rest;

import androidx.core.util.ObjectsCompat$Api19Impl;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class RestOptions {
    private final byte[] data;
    private final Map<String, String> headers;
    private final String path;
    private final Map<String, String> queryParameters;

    /* loaded from: classes.dex */
    public static final class Builder {
        private byte[] data;
        private Map<String, String> headers;
        private String path;
        private Map<String, String> queryParameters;

        public Builder addBody(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.put(str, str2);
            return this;
        }

        public Builder addHeaders(Map<String, String> map) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            this.headers.putAll(map);
            return this;
        }

        public Builder addPath(String str) {
            this.path = str;
            return this;
        }

        public Builder addQueryParameters(Map<String, String> map) {
            if (this.queryParameters == null) {
                this.queryParameters = new HashMap();
            }
            this.queryParameters.putAll(map);
            return this;
        }

        public RestOptions build() {
            return new RestOptions(this.path, this.data, this.headers, this.queryParameters);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestOptions.class != obj.getClass()) {
            return false;
        }
        RestOptions restOptions = (RestOptions) obj;
        if (!ObjectsCompat$Api19Impl.equals(getPath(), restOptions.getPath()) || !ObjectsCompat$Api19Impl.equals(getData(), restOptions.getData()) || !ObjectsCompat$Api19Impl.equals(getHeaders(), restOptions.getHeaders())) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(getQueryParameters(), restOptions.getQueryParameters());
    }

    public byte[] getData() {
        return this.data;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, String> getQueryParameters() {
        return this.queryParameters;
    }

    public boolean hasData() {
        if (this.data != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r0;
        int r02;
        int r1 = 0;
        if (getPath() != null) {
            r0 = getPath().hashCode();
        } else {
            r0 = 0;
        }
        int hashCode = (Arrays.hashCode(getData()) + (r0 * 31)) * 31;
        if (getHeaders() != null) {
            r02 = getHeaders().hashCode();
        } else {
            r02 = 0;
        }
        int r2 = (hashCode + r02) * 31;
        if (getQueryParameters() != null) {
            r1 = getQueryParameters().hashCode();
        }
        return r2 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RestOptions{path='");
        sb.append(this.path);
        sb.append("', data=");
        sb.append(Arrays.toString(this.data));
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", queryParameters=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.queryParameters, '}');
    }

    private RestOptions(String str, byte[] bArr, Map<String, String> map, Map<String, String> map2) {
        this.path = str;
        this.data = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.headers = map == null ? Collections.emptyMap() : Immutable.of(map);
        this.queryParameters = map2 == null ? Collections.emptyMap() : Immutable.of(map2);
    }
}
