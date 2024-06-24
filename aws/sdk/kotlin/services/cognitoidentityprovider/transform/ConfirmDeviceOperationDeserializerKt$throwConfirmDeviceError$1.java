package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfirmDeviceOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmDeviceOperationDeserializerKt", f = "ConfirmDeviceOperationDeserializer.kt", l = {47, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71}, m = "throwConfirmDeviceError")
/* loaded from: classes.dex */
public final class ConfirmDeviceOperationDeserializerKt$throwConfirmDeviceError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConfirmDeviceOperationDeserializerKt.access$throwConfirmDeviceError(null, null, this);
    }
}
