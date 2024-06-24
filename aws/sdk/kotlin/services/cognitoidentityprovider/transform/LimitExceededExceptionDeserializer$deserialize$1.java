package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.LimitExceededException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LimitExceededExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.LimitExceededExceptionDeserializer", f = "LimitExceededExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class LimitExceededExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public LimitExceededException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LimitExceededExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitExceededExceptionDeserializer$deserialize$1(LimitExceededExceptionDeserializer limitExceededExceptionDeserializer, Continuation<? super LimitExceededExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = limitExceededExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
