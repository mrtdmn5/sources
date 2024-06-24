package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.GetIdResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetIdOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.GetIdOperationDeserializer", f = "GetIdOperationDeserializer.kt", l = {34, 38}, m = "deserialize")
/* loaded from: classes.dex */
public final class GetIdOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public GetIdResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ GetIdOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetIdOperationDeserializer$deserialize$1(GetIdOperationDeserializer getIdOperationDeserializer, Continuation<? super GetIdOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = getIdOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
