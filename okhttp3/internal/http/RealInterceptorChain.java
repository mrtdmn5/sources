package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

/* compiled from: RealInterceptorChain.kt */
/* loaded from: classes4.dex */
public final class RealInterceptorChain {
    public final RealCall call;
    public int calls;
    public final int connectTimeoutMillis;
    public final Exchange exchange;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeoutMillis;
    public final Request request;
    public final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall call, List<? extends Interceptor> interceptors, int r4, Exchange exchange, Request request, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = r4;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = r7;
        this.readTimeoutMillis = r8;
        this.writeTimeoutMillis = r9;
    }

    public static RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int r10, Exchange exchange, Request request, int r13) {
        int r6;
        int r7;
        int r8;
        if ((r13 & 1) != 0) {
            r10 = realInterceptorChain.index;
        }
        int r3 = r10;
        if ((r13 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((r13 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((r13 & 8) != 0) {
            r6 = realInterceptorChain.connectTimeoutMillis;
        } else {
            r6 = 0;
        }
        if ((r13 & 16) != 0) {
            r7 = realInterceptorChain.readTimeoutMillis;
        } else {
            r7 = 0;
        }
        if ((r13 & 32) != 0) {
            r8 = realInterceptorChain.writeTimeoutMillis;
        } else {
            r8 = 0;
        }
        realInterceptorChain.getClass();
        Intrinsics.checkNotNullParameter(request2, "request");
        return new RealInterceptorChain(realInterceptorChain.call, realInterceptorChain.interceptors, r3, exchange2, request2, r6, r7, r8);
    }

    public final Response proceed(Request request) throws IOException {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(request, "request");
        List<Interceptor> list = this.interceptors;
        int size = list.size();
        boolean z3 = false;
        int r4 = this.index;
        if (r4 < size) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.calls++;
            Exchange exchange = this.exchange;
            if (exchange != null) {
                if (exchange.finder.getRoutePlanner().sameHostAndPort(request.url)) {
                    if (this.calls == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        throw new IllegalStateException(("network interceptor " + list.get(r4 - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + list.get(r4 - 1) + " must retain the same host and port").toString());
                }
            }
            int r7 = r4 + 1;
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, r7, null, request, 58);
            Interceptor interceptor = list.get(r4);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (exchange != null) {
                    if (r7 >= list.size() || copy$okhttp$default.calls == 1) {
                        z3 = true;
                    }
                    if (!z3) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                return intercept;
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
