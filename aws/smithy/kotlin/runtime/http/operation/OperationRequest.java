package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OperationRequest.kt */
/* loaded from: classes.dex */
public final class OperationRequest<T> {
    public final ExecutionContext context;
    public final T subject;

    public OperationRequest(ExecutionContext context, T t) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.subject = t;
    }

    public static OperationRequest copy$default(OperationRequest operationRequest, Object obj) {
        ExecutionContext context = operationRequest.context;
        operationRequest.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return new OperationRequest(context, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperationRequest)) {
            return false;
        }
        OperationRequest operationRequest = (OperationRequest) obj;
        if (Intrinsics.areEqual(this.context, operationRequest.context) && Intrinsics.areEqual(this.subject, operationRequest.subject)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.context.hashCode() * 31;
        T t = this.subject;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "OperationRequest(context=" + this.context + ", subject=" + this.subject + ')';
    }
}
