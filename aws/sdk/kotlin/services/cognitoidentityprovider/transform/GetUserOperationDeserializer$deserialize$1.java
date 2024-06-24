package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetUserOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserOperationDeserializer", f = "GetUserOperationDeserializer.kt", l = {37, 41}, m = "deserialize")
/* loaded from: classes.dex */
public final class GetUserOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public GetUserResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GetUserOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserOperationDeserializer$deserialize$1(GetUserOperationDeserializer getUserOperationDeserializer, Continuation<? super GetUserOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = getUserOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
