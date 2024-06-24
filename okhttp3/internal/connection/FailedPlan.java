package okhttp3.internal.connection;

import okhttp3.internal.connection.RoutePlanner;

/* compiled from: FailedPlan.kt */
/* loaded from: classes4.dex */
public final class FailedPlan implements RoutePlanner.Plan {
    public final RoutePlanner.ConnectResult result;

    public FailedPlan(Throwable th) {
        this.result = new RoutePlanner.ConnectResult(this, null, th, 2);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.ConnectResult connectTcp() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.ConnectResult connectTlsEtc() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RealConnection handleSuccess() {
        throw new IllegalStateException("unexpected call".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final boolean isReady() {
        return false;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public final RoutePlanner.Plan retry() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
