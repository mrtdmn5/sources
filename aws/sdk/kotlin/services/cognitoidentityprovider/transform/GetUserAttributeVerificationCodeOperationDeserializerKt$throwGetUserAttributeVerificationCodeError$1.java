package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetUserAttributeVerificationCodeOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserAttributeVerificationCodeOperationDeserializerKt", f = "GetUserAttributeVerificationCodeOperationDeserializer.kt", l = {48, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76}, m = "throwGetUserAttributeVerificationCodeError")
/* loaded from: classes.dex */
public final class GetUserAttributeVerificationCodeOperationDeserializerKt$throwGetUserAttributeVerificationCodeError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GetUserAttributeVerificationCodeOperationDeserializerKt.access$throwGetUserAttributeVerificationCodeError(null, null, this);
    }
}
