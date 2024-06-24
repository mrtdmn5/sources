package okhttp3.internal.connection;

import okhttp3.internal.connection.RoutePlanner;

/* compiled from: ReusePlan.kt */
/* loaded from: classes4.dex */
public final class ReusePlan implements RoutePlanner.Plan {
    public final RealConnection connection;
    public final boolean isReady = true;

    public ReusePlan(RealConnection realConnection) {
        this.connection = realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.ConnectResult connectTcp() {
        throw new IllegalStateException("already connected".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.ConnectResult connectTlsEtc() {
        throw new IllegalStateException("already connected".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RealConnection handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final boolean isReady() {
        return this.isReady;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.Plan retry() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
