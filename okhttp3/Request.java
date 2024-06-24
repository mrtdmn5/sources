package okhttp3;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okhttp3.Headers;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.HttpMethod;

/* compiled from: Request.kt */
/* loaded from: classes4.dex */
public final class Request {
    public final RequestBody body;
    public final Headers headers;
    public CacheControl lazyCacheControl;
    public final String method;
    public final Map<KClass<?>, Object> tags;
    public final HttpUrl url;

    public Request(Builder builder) {
        HttpUrl httpUrl = builder.url;
        if (httpUrl != null) {
            this.url = httpUrl;
            this.method = builder.method;
            this.headers = builder.headers.build();
            this.body = builder.body;
            this.tags = MapsKt__MapsKt.toMap(builder.tags);
            return;
        }
        throw new IllegalStateException("url == null".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        Headers headers = this.headers;
        if (headers.namesAndValues.length / 2 != 0) {
            sb.append(", headers=[");
            int r2 = 0;
            for (Pair<? extends String, ? extends String> pair : headers) {
                int r4 = r2 + 1;
                if (r2 >= 0) {
                    Pair<? extends String, ? extends String> pair2 = pair;
                    String str = (String) pair2.first;
                    String str2 = (String) pair2.second;
                    if (r2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(str);
                    sb.append(':');
                    if (_UtilCommonKt.isSensitiveHeader(str)) {
                        str2 = "██";
                    }
                    sb.append(str2);
                    r2 = r4;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            sb.append(']');
        }
        Map<KClass<?>, Object> map = this.tags;
        if (!map.isEmpty()) {
            sb.append(", tags=");
            sb.append(map);
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* compiled from: Request.kt */
    /* loaded from: classes4.dex */
    public static class Builder {
        public RequestBody body;
        public Headers.Builder headers;
        public String method;
        public Map<KClass<?>, ? extends Object> tags;
        public HttpUrl url;

        public Builder() {
            this.tags = EmptyMap.INSTANCE;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public final void header(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.Builder builder = this.headers;
            builder.getClass();
            _HeadersCommonKt.headersCheckName(str);
            _HeadersCommonKt.headersCheckValue(value, str);
            builder.removeAll(str);
            _HeadersCommonKt.commonAddLenient(builder, str, value);
        }

        public final void method(String method, RequestBody requestBody) {
            boolean z;
            Intrinsics.checkNotNullParameter(method, "method");
            boolean z2 = false;
            if (method.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (requestBody == null) {
                    if (Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, "PUT") || Intrinsics.areEqual(method, "PATCH") || Intrinsics.areEqual(method, "PROPPATCH") || Intrinsics.areEqual(method, "REPORT")) {
                        z2 = true;
                    }
                    if (!(!z2)) {
                        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("method ", method, " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(method)) {
                    throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("method ", method, " must not have a request body.").toString());
                }
                this.method = method;
                this.body = requestBody;
                return;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public Builder(Request request) {
            Map<KClass<?>, ? extends Object> map = EmptyMap.INSTANCE;
            this.tags = map;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            Map<KClass<?>, Object> map2 = request.tags;
            this.tags = map2.isEmpty() ? map : MapsKt__MapsKt.toMutableMap(map2);
            this.headers = request.headers.newBuilder();
        }
    }
}
