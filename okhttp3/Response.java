package okhttp3;

import java.io.Closeable;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

/* compiled from: Response.kt */
/* loaded from: classes4.dex */
public final class Response implements Closeable {
    public final ResponseBody body;
    public final Response cacheResponse;
    public final int code;
    public final Exchange exchange;
    public final Handshake handshake;
    public final Headers headers;
    public final boolean isSuccessful;
    public final String message;
    public final Response networkResponse;
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;
    public final Function0<Headers> trailersFn;

    public Response(Request request, Protocol protocol, String str, int r10, Handshake handshake, Headers headers, ResponseBody body, Response response, Response response2, Response response3, long j, long j2, Exchange exchange, Function0<Headers> trailersFn) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = r10;
        this.handshake = handshake;
        this.headers = headers;
        this.body = body;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
        this.trailersFn = trailersFn;
        this.isSuccessful = 200 <= r10 && r10 < 300;
    }

    public static String header$default(Response response, String str) {
        response.getClass();
        String str2 = response.headers.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int r1 = this.code;
        if (r1 != 401) {
            if (r1 != 407) {
                return EmptyList.INSTANCE;
            }
            str = "Proxy-Authenticate";
        } else {
            str = "WWW-Authenticate";
        }
        ByteString byteString = HttpHeaders.QUOTED_STRING_DELIMITERS;
        Intrinsics.checkNotNullParameter(headers, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = headers.namesAndValues.length / 2;
        for (int r4 = 0; r4 < length; r4++) {
            if (StringsKt__StringsJVMKt.equals(str, headers.name(r4))) {
                Buffer buffer = new Buffer();
                buffer.m1738writeUtf8(headers.value(r4));
                try {
                    HttpHeaders.readChallengeHeader(buffer, arrayList);
                } catch (EOFException e) {
                    Platform platform = Platform.platform;
                    Platform.platform.getClass();
                    Platform.log(5, "Unable to parse challenge", e);
                }
            }
        }
        return arrayList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.body.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url + '}';
    }

    /* compiled from: Response.kt */
    /* loaded from: classes4.dex */
    public static class Builder {
        public ResponseBody body;
        public Response cacheResponse;
        public int code;
        public Exchange exchange;
        public Handshake handshake;
        public Headers.Builder headers;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;
        public Function0<Headers> trailersFn;

        public Builder() {
            this.code = -1;
            this.body = _UtilCommonKt.commonEmptyResponse;
            this.trailersFn = Response$Builder$trailersFn$1.INSTANCE;
            this.headers = new Headers.Builder();
        }

        public final Response build() {
            boolean z;
            int r5 = this.code;
            if (r5 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Request request = this.request;
                if (request != null) {
                    Protocol protocol = this.protocol;
                    if (protocol != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request, protocol, str, r5, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersFn);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        public Builder(Response response) {
            this.code = -1;
            this.body = _UtilCommonKt.commonEmptyResponse;
            this.trailersFn = Response$Builder$trailersFn$1.INSTANCE;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
            this.exchange = response.exchange;
            this.trailersFn = response.trailersFn;
        }
    }
}
