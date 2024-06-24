package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ResendConfirmationCodeResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResendConfirmationCodeOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ResendConfirmationCodeOperationDeserializer", f = "ResendConfirmationCodeOperationDeserializer.kt", l = {35, 39}, m = "deserialize")
/* loaded from: classes.dex */
public final class ResendConfirmationCodeOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public ResendConfirmationCodeResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ResendConfirmationCodeOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResendConfirmationCodeOperationDeserializer$deserialize$1(ResendConfirmationCodeOperationDeserializer resendConfirmationCodeOperationDeserializer, Continuation<? super ResendConfirmationCodeOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = resendConfirmationCodeOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
