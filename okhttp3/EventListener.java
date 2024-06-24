package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

/* compiled from: EventListener.kt */
/* loaded from: classes4.dex */
public abstract class EventListener {
    public static final EventListener$Companion$NONE$1 NONE = new EventListener$Companion$NONE$1();

    /* compiled from: EventListener.kt */
    /* loaded from: classes4.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectEnd(RealCall call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void connectFailed(RealCall call, InetSocketAddress inetSocketAddress, Proxy proxy, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void connectStart(RealCall call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    public void connectionAcquired(RealCall call, RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectionReleased(Call call, RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> list) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void requestBodyEnd(RealCall call, long j) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestBodyStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestFailed(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void requestHeadersEnd(RealCall call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void requestHeadersStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseBodyEnd(RealCall call, long j) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseBodyStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseFailed(RealCall call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    public void responseHeadersEnd(RealCall call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void responseHeadersStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void secureConnectEnd(RealCall call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void secureConnectStart(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }
}
