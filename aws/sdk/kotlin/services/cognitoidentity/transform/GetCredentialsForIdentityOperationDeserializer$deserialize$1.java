package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.GetCredentialsForIdentityResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetCredentialsForIdentityOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.GetCredentialsForIdentityOperationDeserializer", f = "GetCredentialsForIdentityOperationDeserializer.kt", l = {35, 39}, m = "deserialize")
/* loaded from: classes.dex */
public final class GetCredentialsForIdentityOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public GetCredentialsForIdentityResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GetCredentialsForIdentityOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCredentialsForIdentityOperationDeserializer$deserialize$1(GetCredentialsForIdentityOperationDeserializer getCredentialsForIdentityOperationDeserializer, Continuation<? super GetCredentialsForIdentityOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = getCredentialsForIdentityOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
