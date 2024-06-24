package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.ExceptionsKt;
import okhttp3.internal.connection.RoutePlanner;

/* compiled from: SequentialExchangeFinder.kt */
/* loaded from: classes4.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {
    public final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RealRoutePlanner realRoutePlanner) {
        this.routePlanner = realRoutePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public final RealConnection find() {
        RoutePlanner.Plan plan;
        boolean z;
        IOException iOException = null;
        while (true) {
            RoutePlanner routePlanner = this.routePlanner;
            if (!routePlanner.isCanceled()) {
                try {
                    plan = routePlanner.plan();
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    } else {
                        ExceptionsKt.addSuppressed(iOException, e);
                    }
                    if (!routePlanner.hasNext(null)) {
                        throw iOException;
                    }
                }
                if (plan.isReady()) {
                    break;
                }
                RoutePlanner.ConnectResult connectTcp = plan.connectTcp();
                if (connectTcp.nextPlan == null && connectTcp.throwable == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    connectTcp = plan.connectTlsEtc();
                }
                RoutePlanner.Plan plan2 = connectTcp.nextPlan;
                Throwable th = connectTcp.throwable;
                if (th == null) {
                    if (plan2 == null) {
                        break;
                    }
                    routePlanner.getDeferredPlans().addFirst(plan2);
                } else {
                    throw th;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        return plan.handleSuccess();
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public final RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
