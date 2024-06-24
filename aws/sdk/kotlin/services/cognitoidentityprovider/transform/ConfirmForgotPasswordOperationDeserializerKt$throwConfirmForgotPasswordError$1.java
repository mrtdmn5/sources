package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfirmForgotPasswordOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmForgotPasswordOperationDeserializerKt", f = "ConfirmForgotPasswordOperationDeserializer.kt", l = {30, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57}, m = "throwConfirmForgotPasswordError")
/* loaded from: classes.dex */
public final class ConfirmForgotPasswordOperationDeserializerKt$throwConfirmForgotPasswordError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConfirmForgotPasswordOperationDeserializerKt.access$throwConfirmForgotPasswordError(null, null, this);
    }
}
