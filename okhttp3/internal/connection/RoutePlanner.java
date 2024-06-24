package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.HttpUrl;

/* compiled from: RoutePlanner.kt */
/* loaded from: classes4.dex */
public interface RoutePlanner {

    /* compiled from: RoutePlanner.kt */
    /* loaded from: classes4.dex */
    public static final class ConnectResult {
        public final Plan nextPlan;
        public final Plan plan;
        public final Throwable throwable;

        public /* synthetic */ ConnectResult(Plan plan, ConnectPlan connectPlan, Throwable th, int r6) {
            this(plan, (r6 & 2) != 0 ? null : connectPlan, (r6 & 4) != 0 ? null : th);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) obj;
            if (Intrinsics.areEqual(this.plan, connectResult.plan) && Intrinsics.areEqual(this.nextPlan, connectResult.nextPlan) && Intrinsics.areEqual(this.throwable, connectResult.throwable)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2 = this.plan.hashCode() * 31;
            int r1 = 0;
            Plan plan = this.nextPlan;
            if (plan == null) {
                hashCode = 0;
            } else {
                hashCode = plan.hashCode();
            }
            int r0 = (hashCode2 + hashCode) * 31;
            Throwable th = this.throwable;
            if (th != null) {
                r1 = th.hashCode();
            }
            return r0 + r1;
        }

        public final String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public ConnectResult(Plan plan, Plan plan2, Throwable th) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            this.plan = plan;
            this.nextPlan = plan2;
            this.throwable = th;
        }
    }

    /* compiled from: RoutePlanner.kt */
    /* loaded from: classes4.dex */
    public interface Plan {
        void cancel();

        ConnectResult connectTcp();

        ConnectResult connectTlsEtc();

        RealConnection handleSuccess();

        boolean isReady();

        Plan retry();
    }

    Address getAddress();

    ArrayDeque<Plan> getDeferredPlans();

    boolean hasNext(RealConnection realConnection);

    boolean isCanceled();

    Plan plan() throws IOException;

    boolean sameHostAndPort(HttpUrl httpUrl);
}
