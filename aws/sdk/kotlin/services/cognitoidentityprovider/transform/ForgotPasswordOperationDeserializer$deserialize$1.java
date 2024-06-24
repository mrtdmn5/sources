package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForgotPasswordResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ForgotPasswordOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ForgotPasswordOperationDeserializer", f = "ForgotPasswordOperationDeserializer.kt", l = {35, 39}, m = "deserialize")
/* loaded from: classes.dex */
public final class ForgotPasswordOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public ForgotPasswordResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ForgotPasswordOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgotPasswordOperationDeserializer$deserialize$1(ForgotPasswordOperationDeserializer forgotPasswordOperationDeserializer, Continuation<? super ForgotPasswordOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = forgotPasswordOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
