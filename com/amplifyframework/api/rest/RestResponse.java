package com.amplifyframework.api.rest;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.util.Immutable;
import com.amplifyframework.util.Range;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class RestResponse {
    private final Code code;
    private final Data data;
    private final Map<String, String> headers;

    /* loaded from: classes.dex */
    public static final class Code {
        private final int statusCode;
        private static final Range<Integer> ALL_VALID_CODES = new Range<>(100, 599);
        private static final Range<Integer> SERVICE_FAILURE_CODES = new Range<>(500, 599);
        private static final Range<Integer> CLIENT_ERROR_CODES = new Range<>(400, 499);
        private static final Range<Integer> SUCCESS_CODES = new Range<>(200, 299);

        public Code(int r1) {
            this.statusCode = validateValue(r1);
        }

        private int validateValue(int r3) {
            if (!ALL_VALID_CODES.contains(Integer.valueOf(r3))) {
                return -1;
            }
            return r3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Code.class == obj.getClass() && this.statusCode == ((Code) obj).statusCode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.statusCode;
        }

        public boolean isClientError() {
            return CLIENT_ERROR_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public boolean isServiceFailure() {
            return SERVICE_FAILURE_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public boolean isSuccessful() {
            return SUCCESS_CODES.contains(Integer.valueOf(this.statusCode));
        }

        public String toString() {
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("Code{statusCode="), this.statusCode, '}');
        }
    }

    /* loaded from: classes.dex */
    public static final class Data {
        private final byte[] rawBytes;

        public Data(byte[] bArr) {
            byte[] copyOf;
            if (bArr == null) {
                copyOf = null;
            } else {
                copyOf = Arrays.copyOf(bArr, bArr.length);
            }
            this.rawBytes = copyOf;
        }

        public JSONObject asJSONObject() throws JSONException {
            return new JSONObject(asString());
        }

        public String asString() {
            return new String(this.rawBytes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Data.class == obj.getClass()) {
                return ObjectsCompat$Api19Impl.equals(getRawBytes(), ((Data) obj).getRawBytes());
            }
            return false;
        }

        public byte[] getRawBytes() {
            return this.rawBytes;
        }

        public int hashCode() {
            return Arrays.hashCode(getRawBytes());
        }

        public String toString() {
            return "Data{rawBytes=" + Arrays.toString(this.rawBytes) + '}';
        }
    }

    public RestResponse(int r2, Map<String, String> map) {
        this(r2, map, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RestResponse.class != obj.getClass()) {
            return false;
        }
        RestResponse restResponse = (RestResponse) obj;
        if (!ObjectsCompat$Api19Impl.equals(getData(), restResponse.getData())) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(getCode(), restResponse.getCode());
    }

    public Code getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public Map<String, String> getHeaders() {
        return Immutable.of(this.headers);
    }

    public int hashCode() {
        int r0;
        int r1 = 0;
        if (getData() != null) {
            r0 = getData().hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        if (getCode() != null) {
            r1 = getCode().hashCode();
        }
        return r02 + r1;
    }

    public String toString() {
        return "RestResponse{data=" + this.data + ", code=" + this.code + '}';
    }

    public RestResponse(int r2, Map<String, String> map, byte[] bArr) {
        this.data = new Data(bArr);
        this.headers = map;
        this.code = new Code(r2);
    }
}
