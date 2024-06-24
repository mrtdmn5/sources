package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ExpiredCodeException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ExpiredCodeExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ExpiredCodeExceptionDeserializer", f = "ExpiredCodeExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class ExpiredCodeExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public ExpiredCodeException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ExpiredCodeExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpiredCodeExceptionDeserializer$deserialize$1(ExpiredCodeExceptionDeserializer expiredCodeExceptionDeserializer, Continuation<? super ExpiredCodeExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = expiredCodeExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
