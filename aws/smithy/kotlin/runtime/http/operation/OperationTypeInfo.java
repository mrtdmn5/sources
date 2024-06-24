package aws.smithy.kotlin.runtime.http.operation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: SdkHttpOperation.kt */
/* loaded from: classes.dex */
public final class OperationTypeInfo {
    public final KClass<?> inputType;
    public final KClass<?> outputType;

    public OperationTypeInfo(KClass<?> inputType, KClass<?> outputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(outputType, "outputType");
        this.inputType = inputType;
        this.outputType = outputType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperationTypeInfo)) {
            return false;
        }
        OperationTypeInfo operationTypeInfo = (OperationTypeInfo) obj;
        if (Intrinsics.areEqual(this.inputType, operationTypeInfo.inputType) && Intrinsics.areEqual(this.outputType, operationTypeInfo.outputType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.outputType.hashCode() + (this.inputType.hashCode() * 31);
    }

    public final String toString() {
        return "OperationTypeInfo(inputType=" + this.inputType + ", outputType=" + this.outputType + ')';
    }
}
