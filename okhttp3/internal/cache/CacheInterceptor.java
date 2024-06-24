package okhttp3.internal.cache;

import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.CacheControl;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.RealInterceptorChain;

/* compiled from: CacheInterceptor.kt */
/* loaded from: classes4.dex */
public final class CacheInterceptor implements Interceptor {

    /* compiled from: CacheInterceptor.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static boolean isEndToEnd(String str) {
            if (!StringsKt__StringsJVMKt.equals(Headers.CONNECTION, str) && !StringsKt__StringsJVMKt.equals("Keep-Alive", str) && !StringsKt__StringsJVMKt.equals("Proxy-Authenticate", str) && !StringsKt__StringsJVMKt.equals("Proxy-Authorization", str) && !StringsKt__StringsJVMKt.equals("TE", str) && !StringsKt__StringsJVMKt.equals("Trailers", str) && !StringsKt__StringsJVMKt.equals("Transfer-Encoding", str) && !StringsKt__StringsJVMKt.equals("Upgrade", str)) {
                return true;
            }
            return false;
        }
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        RealCall realCall;
        EventListener eventListener;
        boolean z;
        okhttp3.Headers headers;
        boolean z2;
        okhttp3.Headers headers2;
        boolean z3;
        boolean z4;
        System.currentTimeMillis();
        Request request = realInterceptorChain.request;
        Intrinsics.checkNotNullParameter(request, "request");
        Response response = null;
        CacheStrategy cacheStrategy = new CacheStrategy(request, null);
        CacheControl cacheControl = request.lazyCacheControl;
        if (cacheControl == null) {
            int r5 = CacheControl.$r8$clinit;
            cacheControl = CacheControl.Companion.parse(request.headers);
            request.lazyCacheControl = cacheControl;
        }
        if (cacheControl.onlyIfCached) {
            cacheStrategy = new CacheStrategy(null, null);
        }
        RealCall realCall2 = realInterceptorChain.call;
        if (realCall2 instanceof RealCall) {
            realCall = realCall2;
        } else {
            realCall = null;
        }
        if (realCall == null || (eventListener = realCall.eventListener) == null) {
            eventListener = EventListener.NONE;
        }
        Request request2 = cacheStrategy.networkRequest;
        Response response2 = cacheStrategy.cacheResponse;
        if (request2 == null && response2 == null) {
            Response.Builder builder = new Response.Builder();
            Intrinsics.checkNotNullParameter(request, "request");
            builder.request = request;
            Protocol protocol = Protocol.HTTP_1_1;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            builder.protocol = protocol;
            builder.code = 504;
            builder.message = "Unsatisfiable Request (only-if-cached)";
            builder.sentRequestAtMillis = -1L;
            builder.receivedResponseAtMillis = System.currentTimeMillis();
            Response build = builder.build();
            eventListener.satisfactionFailure(realCall2, build);
            return build;
        }
        if (request2 == null) {
            Intrinsics.checkNotNull(response2);
            Response.Builder builder2 = new Response.Builder(response2);
            Response stripBody = _ResponseCommonKt.stripBody(response2);
            _ResponseCommonKt.checkSupportResponse("cacheResponse", stripBody);
            builder2.cacheResponse = stripBody;
            Response build2 = builder2.build();
            eventListener.cacheHit(realCall2, build2);
            return build2;
        }
        if (response2 != null) {
            eventListener.cacheConditionalHit(realCall2, response2);
        }
        Response proceed = realInterceptorChain.proceed(request2);
        if (response2 != null) {
            if (proceed.code == 304) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Response.Builder builder3 = new Response.Builder(response2);
                Headers.Builder builder4 = new Headers.Builder();
                okhttp3.Headers headers3 = response2.headers;
                int length = headers3.namesAndValues.length / 2;
                int r11 = 0;
                while (true) {
                    headers = proceed.headers;
                    if (r11 >= length) {
                        break;
                    }
                    String name = headers3.name(r11);
                    String value = headers3.value(r11);
                    if (StringsKt__StringsJVMKt.equals("Warning", name)) {
                        headers2 = headers3;
                        z3 = false;
                        if (StringsKt__StringsJVMKt.startsWith(value, "1", false)) {
                            r11++;
                            headers3 = headers2;
                        }
                    } else {
                        headers2 = headers3;
                        z3 = false;
                    }
                    if (!StringsKt__StringsJVMKt.equals("Content-Length", name) && !StringsKt__StringsJVMKt.equals("Content-Encoding", name) && !StringsKt__StringsJVMKt.equals("Content-Type", name)) {
                        z4 = z3;
                    } else {
                        z4 = true;
                    }
                    if (z4 || !Companion.isEndToEnd(name) || headers.get(name) == null) {
                        _HeadersCommonKt.commonAddLenient(builder4, name, value);
                    }
                    r11++;
                    headers3 = headers2;
                }
                int length2 = headers.namesAndValues.length / 2;
                for (int r7 = 0; r7 < length2; r7++) {
                    String name2 = headers.name(r7);
                    if (!StringsKt__StringsJVMKt.equals("Content-Length", name2) && !StringsKt__StringsJVMKt.equals("Content-Encoding", name2) && !StringsKt__StringsJVMKt.equals("Content-Type", name2)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2 && Companion.isEndToEnd(name2)) {
                        _HeadersCommonKt.commonAddLenient(builder4, name2, headers.value(r7));
                    }
                }
                builder3.headers = builder4.build().newBuilder();
                builder3.sentRequestAtMillis = proceed.sentRequestAtMillis;
                builder3.receivedResponseAtMillis = proceed.receivedResponseAtMillis;
                Response stripBody2 = _ResponseCommonKt.stripBody(response2);
                _ResponseCommonKt.checkSupportResponse("cacheResponse", stripBody2);
                builder3.cacheResponse = stripBody2;
                Response stripBody3 = _ResponseCommonKt.stripBody(proceed);
                _ResponseCommonKt.checkSupportResponse("networkResponse", stripBody3);
                builder3.networkResponse = stripBody3;
                builder3.build();
                proceed.body.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            _UtilCommonKt.closeQuietly(response2.body);
        }
        Response.Builder builder5 = new Response.Builder(proceed);
        if (response2 != null) {
            response = _ResponseCommonKt.stripBody(response2);
        }
        _ResponseCommonKt.checkSupportResponse("cacheResponse", response);
        builder5.cacheResponse = response;
        Response stripBody4 = _ResponseCommonKt.stripBody(proceed);
        _ResponseCommonKt.checkSupportResponse("networkResponse", stripBody4);
        builder5.networkResponse = stripBody4;
        return builder5.build();
    }
}
