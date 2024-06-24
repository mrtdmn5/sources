package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetUserAttributeVerificationCodeOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializer", f = "GetUserAttributeVerificationCodeOperationDeserializer.kt", l = {35, 39}, m = "deserialize")
/* loaded from: classes.dex */
public final class GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public GetUserAttributeVerificationCodeResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GetUserAttributeVerificationCodeOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1(GetUserAttributeVerificationCodeOperationDeserializer getUserAttributeVerificationCodeOperationDeserializer, Continuation<? super GetUserAttributeVerificationCodeOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = getUserAttributeVerificationCodeOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
