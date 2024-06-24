package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfirmSignUpOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ConfirmSignUpOperationDeserializerKt", f = "ConfirmSignUpOperationDeserializer.kt", l = {30, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56}, m = "throwConfirmSignUpError")
/* loaded from: classes.dex */
public final class ConfirmSignUpOperationDeserializerKt$throwConfirmSignUpError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConfirmSignUpOperationDeserializerKt.access$throwConfirmSignUpError(null, null, this);
    }
}
