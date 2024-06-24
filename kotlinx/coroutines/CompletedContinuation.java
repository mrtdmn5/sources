package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes4.dex */
public final class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Throwable] */
    public static CompletedContinuation copy$default(CompletedContinuation completedContinuation, CancelHandler cancelHandler, CancellationException cancellationException, int r11) {
        Object obj;
        Function1<Throwable, Unit> function1;
        Object obj2 = null;
        if ((r11 & 1) != 0) {
            obj = completedContinuation.result;
        } else {
            obj = null;
        }
        if ((r11 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((r11 & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        } else {
            function1 = null;
        }
        if ((r11 & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj3 = obj2;
        CancellationException cancellationException2 = cancellationException;
        if ((r11 & 16) != 0) {
            cancellationException2 = completedContinuation.cancelCause;
        }
        completedContinuation.getClass();
        return new CompletedContinuation(obj, cancelHandler2, function1, obj3, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        if (Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r0 = 0;
        Object obj = this.result;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int r1 = hashCode * 31;
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = cancelHandler.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = function1.hashCode();
        }
        int r13 = (r12 + hashCode3) * 31;
        Object obj2 = this.idempotentResume;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int r14 = (r13 + hashCode4) * 31;
        Throwable th = this.cancelCause;
        if (th != null) {
            r0 = th.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, CancellationException cancellationException, int r13) {
        this(obj, (r13 & 2) != 0 ? null : cancelHandler, (Function1<? super Throwable, Unit>) ((r13 & 4) != 0 ? null : function1), (Object) null, (r13 & 16) != 0 ? null : cancellationException);
    }
}
