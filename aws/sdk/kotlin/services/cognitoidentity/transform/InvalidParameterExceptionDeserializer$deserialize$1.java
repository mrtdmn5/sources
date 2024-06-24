package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.InvalidParameterException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InvalidParameterExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.InvalidParameterExceptionDeserializer", f = "InvalidParameterExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class InvalidParameterExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public InvalidParameterException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InvalidParameterExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidParameterExceptionDeserializer$deserialize$1(InvalidParameterExceptionDeserializer invalidParameterExceptionDeserializer, Continuation<? super InvalidParameterExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = invalidParameterExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
