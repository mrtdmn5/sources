package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: NullProxySelector.kt */
/* loaded from: classes4.dex */
public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = new NullProxySelector();

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI r2) {
        if (r2 != null) {
            return CollectionsKt__CollectionsKt.listOf(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI r1, SocketAddress socketAddress, IOException iOException) {
    }
}
