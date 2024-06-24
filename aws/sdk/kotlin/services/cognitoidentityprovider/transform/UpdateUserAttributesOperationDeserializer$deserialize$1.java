package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.UpdateUserAttributesResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UpdateUserAttributesOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationDeserializer", f = "UpdateUserAttributesOperationDeserializer.kt", l = {36, 40}, m = "deserialize")
/* loaded from: classes.dex */
public final class UpdateUserAttributesOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public UpdateUserAttributesResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UpdateUserAttributesOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateUserAttributesOperationDeserializer$deserialize$1(UpdateUserAttributesOperationDeserializer updateUserAttributesOperationDeserializer, Continuation<? super UpdateUserAttributesOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = updateUserAttributesOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
