package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ConfirmDeviceResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfirmDeviceOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmDeviceOperationDeserializer", f = "ConfirmDeviceOperationDeserializer.kt", l = {34, 38}, m = "deserialize")
/* loaded from: classes.dex */
public final class ConfirmDeviceOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public ConfirmDeviceResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ConfirmDeviceOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmDeviceOperationDeserializer$deserialize$1(ConfirmDeviceOperationDeserializer confirmDeviceOperationDeserializer, Continuation<? super ConfirmDeviceOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = confirmDeviceOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
