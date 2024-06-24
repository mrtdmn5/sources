package okhttp3.internal.connection;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;

/* compiled from: RouteSelector.kt */
/* loaded from: classes4.dex */
public final class RouteSelector {
    public final Address address;
    public final Call call;
    public final EventListener eventListener;
    public final boolean fastFallback;
    public List<? extends InetSocketAddress> inetSocketAddresses;
    public int nextProxyIndex;
    public final ArrayList postponedRoutes;
    public List<? extends Proxy> proxies;
    public final RouteDatabase routeDatabase;

    /* compiled from: RouteSelector.kt */
    /* loaded from: classes4.dex */
    public static final class Selection {
        public int nextRouteIndex;
        public final List<Route> routes;

        public Selection(ArrayList arrayList) {
            this.routes = arrayList;
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, RealCall call, boolean z, EventListener eventListener) {
        boolean z2;
        List<Proxy> immutableList;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.fastFallback = z;
        this.eventListener = eventListener;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.proxies = emptyList;
        this.inetSocketAddresses = emptyList;
        this.postponedRoutes = new ArrayList();
        HttpUrl httpUrl = address.url;
        eventListener.proxySelectStart(call, httpUrl);
        Proxy proxy = address.proxy;
        if (proxy != null) {
            immutableList = CollectionsKt__CollectionsKt.listOf(proxy);
        } else {
            URI uri = httpUrl.uri();
            if (uri.getHost() == null) {
                immutableList = _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
            } else {
                List<Proxy> proxiesOrNull = address.proxySelector.select(uri);
                List<Proxy> list = proxiesOrNull;
                if (list != null && !list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    immutableList = _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
                } else {
                    Intrinsics.checkNotNullExpressionValue(proxiesOrNull, "proxiesOrNull");
                    immutableList = _UtilJvmKt.toImmutableList(proxiesOrNull);
                }
            }
        }
        this.proxies = immutableList;
        this.nextProxyIndex = 0;
        eventListener.proxySelectEnd(call, httpUrl, immutableList);
    }

    public final boolean hasNext() {
        boolean z;
        if (this.nextProxyIndex < this.proxies.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z || (!this.postponedRoutes.isEmpty())) {
            return true;
        }
        return false;
    }
}
