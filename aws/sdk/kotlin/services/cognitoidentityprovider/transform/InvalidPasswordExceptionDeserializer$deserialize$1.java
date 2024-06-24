package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidPasswordException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InvalidPasswordExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidPasswordExceptionDeserializer", f = "InvalidPasswordExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class InvalidPasswordExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public InvalidPasswordException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InvalidPasswordExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidPasswordExceptionDeserializer$deserialize$1(InvalidPasswordExceptionDeserializer invalidPasswordExceptionDeserializer, Continuation<? super InvalidPasswordExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = invalidPasswordExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
