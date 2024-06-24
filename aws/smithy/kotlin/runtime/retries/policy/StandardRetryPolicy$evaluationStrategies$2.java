package aws.smithy.kotlin.runtime.retries.policy;

import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.SdkBaseException;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardRetryPolicy.kt */
/* loaded from: classes.dex */
public /* synthetic */ class StandardRetryPolicy$evaluationStrategies$2 extends FunctionReferenceImpl implements Function1<SdkBaseException, RetryDirective> {
    public StandardRetryPolicy$evaluationStrategies$2(Object obj) {
        super(1, obj, StandardRetryPolicy.class, "evaluateBaseException", "evaluateBaseException(Laws/smithy/kotlin/runtime/SdkBaseException;)Laws/smithy/kotlin/runtime/retries/policy/RetryDirective;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RetryDirective invoke(SdkBaseException sdkBaseException) {
        boolean z;
        SdkBaseException p0 = sdkBaseException;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StandardRetryPolicy) this.receiver).getClass();
        Boolean bool = (Boolean) p0.getSdkErrorMetadata().attributes.getOrNull(ErrorMetadata.ThrottlingError);
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        if (z) {
            return new RetryDirective.RetryError(RetryErrorType.Throttling);
        }
        return null;
    }
}
