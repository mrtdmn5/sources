package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompletionState.kt */
/* loaded from: classes4.dex */
public final class CompletedWithCancellation {
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.result = obj;
        this.onCancellation = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        if (Intrinsics.areEqual(this.result, completedWithCancellation.result) && Intrinsics.areEqual(this.onCancellation, completedWithCancellation.onCancellation)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        Object obj = this.result;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return this.onCancellation.hashCode() + (hashCode * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.onCancellation + ')';
    }
}
