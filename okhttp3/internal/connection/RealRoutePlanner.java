package okhttp3.internal.connection;

import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.RealInterceptorChain;

/* compiled from: RealRoutePlanner.kt */
/* loaded from: classes4.dex */
public final class RealRoutePlanner implements RoutePlanner {
    public final Address address;
    public final RealCall call;
    public final OkHttpClient client;
    public final ArrayDeque<RoutePlanner.Plan> deferredPlans;
    public final boolean doExtensiveHealthChecks;
    public Route nextRouteToTry;
    public RouteSelector.Selection routeSelection;
    public RouteSelector routeSelector;

    public RealRoutePlanner(OkHttpClient client, Address address, RealCall realCall, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.address = address;
        this.call = realCall;
        this.doExtensiveHealthChecks = !Intrinsics.areEqual(realInterceptorChain.request.method, "GET");
        this.deferredPlans = new ArrayDeque<>();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public final Address getAddress() {
        return this.address;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public final ArrayDeque<RoutePlanner.Plan> getDeferredPlans() {
        return this.deferredPlans;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public final boolean hasNext(RealConnection realConnection) {
        RouteSelector routeSelector;
        boolean z;
        Route route;
        if ((!this.deferredPlans.isEmpty()) || this.nextRouteToTry != null) {
            return true;
        }
        if (realConnection != null) {
            synchronized (realConnection) {
                if (realConnection.routeFailureCount == 0) {
                    if (realConnection.noNewExchanges) {
                        if (_UtilJvmKt.canReuseConnectionFor(realConnection.route.address.url, this.address.url)) {
                            route = realConnection.route;
                        }
                    }
                }
                route = null;
            }
            if (route != null) {
                this.nextRouteToTry = route;
                return true;
            }
        }
        RouteSelector.Selection selection = this.routeSelection;
        boolean z2 = false;
        if (selection != null) {
            if (selection.nextRouteIndex < selection.routes.size()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
            }
        }
        if (z2 || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public final boolean isCanceled() {
        return this.call.canceled;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    @Override // okhttp3.internal.connection.RoutePlanner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.RoutePlanner.Plan plan() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 862
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealRoutePlanner.plan():okhttp3.internal.connection.RoutePlanner$Plan");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.internal.connection.ConnectPlan planConnectToRoute$okhttp(okhttp3.Route r13, java.util.List<okhttp3.Route> r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealRoutePlanner.planConnectToRoute$okhttp(okhttp3.Route, java.util.List):okhttp3.internal.connection.ConnectPlan");
    }

    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan connectPlan, List<Route> list) {
        boolean z;
        RealConnection connection;
        boolean z2;
        boolean z3;
        Socket releaseConnectionNoEvents$okhttp;
        RealConnectionPool realConnectionPool = this.client.connectionPool.delegate;
        boolean z4 = this.doExtensiveHealthChecks;
        Address address = this.address;
        RealCall call = this.call;
        if (connectPlan != null && connectPlan.isReady()) {
            z = true;
        } else {
            z = false;
        }
        realConnectionPool.getClass();
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator<RealConnection> it = realConnectionPool.connections.iterator();
        while (true) {
            if (it.hasNext()) {
                connection = it.next();
                Intrinsics.checkNotNullExpressionValue(connection, "connection");
                synchronized (connection) {
                    if (z) {
                        if (connection.http2Connection != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            z3 = false;
                        }
                    }
                    if (connection.isEligible$okhttp(address, list)) {
                        call.acquireConnectionNoEvents(connection);
                        z3 = true;
                    }
                    z3 = false;
                }
                if (z3) {
                    if (connection.isHealthy(z4)) {
                        break;
                    }
                    synchronized (connection) {
                        connection.noNewExchanges = true;
                        releaseConnectionNoEvents$okhttp = call.releaseConnectionNoEvents$okhttp();
                    }
                    if (releaseConnectionNoEvents$okhttp != null) {
                        _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                    }
                }
            } else {
                connection = null;
                break;
            }
        }
        if (connection == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.route;
            Socket socket = connectPlan.socket;
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
        }
        RealCall realCall = this.call;
        realCall.eventListener.connectionAcquired(realCall, connection);
        return new ReusePlan(connection);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public final boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = this.address.url;
        if (url.port == httpUrl.port && Intrinsics.areEqual(url.host, httpUrl.host)) {
            return true;
        }
        return false;
    }
}
