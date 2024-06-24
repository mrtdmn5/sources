package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SignUpOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.SignUpOperationDeserializer", f = "SignUpOperationDeserializer.kt", l = {35, 39}, m = "deserialize")
/* loaded from: classes.dex */
public final class SignUpOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public SignUpResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SignUpOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignUpOperationDeserializer$deserialize$1(SignUpOperationDeserializer signUpOperationDeserializer, Continuation<? super SignUpOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = signUpOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
