package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.TooManyRequestsException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TooManyRequestsExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.TooManyRequestsExceptionDeserializer", f = "TooManyRequestsExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class TooManyRequestsExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public TooManyRequestsException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ TooManyRequestsExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooManyRequestsExceptionDeserializer$deserialize$1(TooManyRequestsExceptionDeserializer tooManyRequestsExceptionDeserializer, Continuation<? super TooManyRequestsExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = tooManyRequestsExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
