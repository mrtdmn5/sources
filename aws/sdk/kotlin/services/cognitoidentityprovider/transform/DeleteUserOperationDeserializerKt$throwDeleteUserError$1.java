package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DeleteUserOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.DeleteUserOperationDeserializerKt", f = "DeleteUserOperationDeserializer.kt", l = {30, 42, 43, 44, 45, 46, 47, 48, 49, 50}, m = "throwDeleteUserError")
/* loaded from: classes.dex */
public final class DeleteUserOperationDeserializerKt$throwDeleteUserError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeleteUserOperationDeserializerKt.access$throwDeleteUserError(null, null, this);
    }
}
