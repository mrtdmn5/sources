package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ForgotPasswordOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ForgotPasswordOperationDeserializerKt", f = "ForgotPasswordOperationDeserializer.kt", l = {48, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74}, m = "throwForgotPasswordError")
/* loaded from: classes.dex */
public final class ForgotPasswordOperationDeserializerKt$throwForgotPasswordError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ForgotPasswordOperationDeserializerKt.access$throwForgotPasswordError(null, null, this);
    }
}
