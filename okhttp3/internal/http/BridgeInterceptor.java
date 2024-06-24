package okhttp3.internal.http;

import com.amazonaws.http.HttpHeader;
import java.io.IOException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._MediaTypeCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.GzipSource;
import okio.Okio;

/* compiled from: BridgeInterceptor.kt */
/* loaded from: classes4.dex */
public final class BridgeInterceptor implements Interceptor {
    public final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        boolean z;
        ResponseBody responseBody;
        Request request = realInterceptorChain.request;
        request.getClass();
        Request.Builder builder = new Request.Builder(request);
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
                builder.header("Content-Type", contentType.mediaType);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                builder.header("Content-Length", String.valueOf(contentLength));
                builder.headers.removeAll("Transfer-Encoding");
            } else {
                builder.header("Transfer-Encoding", "chunked");
                builder.headers.removeAll("Content-Length");
            }
        }
        Headers headers = request.headers;
        String str = headers.get(HttpHeader.HOST);
        int r9 = 0;
        HttpUrl httpUrl = request.url;
        if (str == null) {
            builder.header(HttpHeader.HOST, _UtilJvmKt.toHostHeader(httpUrl, false));
        }
        if (headers.get(com.amazonaws.services.s3.Headers.CONNECTION) == null) {
            builder.header(com.amazonaws.services.s3.Headers.CONNECTION, "Keep-Alive");
        }
        if (headers.get("Accept-Encoding") == null && headers.get(com.amazonaws.services.s3.Headers.RANGE) == null) {
            builder.header("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        CookieJar cookieJar = this.cookieJar;
        cookieJar.loadForRequest(httpUrl);
        if (!true) {
            StringBuilder sb = new StringBuilder();
            EmptyIterator emptyIterator = EmptyIterator.INSTANCE;
            while (emptyIterator.hasNext()) {
                E next = emptyIterator.next();
                int r13 = r9 + 1;
                if (r9 >= 0) {
                    Cookie cookie = (Cookie) next;
                    if (r9 > 0) {
                        sb.append("; ");
                    }
                    sb.append(cookie.name);
                    sb.append('=');
                    sb.append(cookie.value);
                    r9 = r13;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            builder.header("Cookie", sb2);
        }
        if (headers.get(HttpHeader.USER_AGENT) == null) {
            builder.header(HttpHeader.USER_AGENT, "okhttp/5.0.0-alpha.11");
        }
        Request request2 = new Request(builder);
        Response proceed = realInterceptorChain.proceed(request2);
        HttpUrl httpUrl2 = request2.url;
        Headers headers2 = proceed.headers;
        HttpHeaders.receiveHeaders(cookieJar, httpUrl2, headers2);
        Response.Builder builder2 = new Response.Builder(proceed);
        builder2.request = request2;
        if (z && StringsKt__StringsJVMKt.equals("gzip", Response.header$default(proceed, "Content-Encoding")) && HttpHeaders.promisesBody(proceed) && (responseBody = proceed.body) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.source());
            Headers.Builder newBuilder = headers2.newBuilder();
            newBuilder.removeAll("Content-Encoding");
            newBuilder.removeAll("Content-Length");
            builder2.headers = newBuilder.build().newBuilder();
            builder2.body = new RealResponseBody(Response.header$default(proceed, "Content-Type"), -1L, Okio.buffer(gzipSource));
        }
        return builder2.build();
    }
}
