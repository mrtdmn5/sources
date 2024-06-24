package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.InitiateAuthResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitiateAuthOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.InitiateAuthOperationDeserializer", f = "InitiateAuthOperationDeserializer.kt", l = {37, 41}, m = "deserialize")
/* loaded from: classes.dex */
public final class InitiateAuthOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public InitiateAuthResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InitiateAuthOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitiateAuthOperationDeserializer$deserialize$1(InitiateAuthOperationDeserializer initiateAuthOperationDeserializer, Continuation<? super InitiateAuthOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = initiateAuthOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
