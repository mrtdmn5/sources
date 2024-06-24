package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.UnexpectedLambdaException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UnexpectedLambdaExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.UnexpectedLambdaExceptionDeserializer", f = "UnexpectedLambdaExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class UnexpectedLambdaExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public UnexpectedLambdaException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UnexpectedLambdaExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnexpectedLambdaExceptionDeserializer$deserialize$1(UnexpectedLambdaExceptionDeserializer unexpectedLambdaExceptionDeserializer, Continuation<? super UnexpectedLambdaExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = unexpectedLambdaExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
