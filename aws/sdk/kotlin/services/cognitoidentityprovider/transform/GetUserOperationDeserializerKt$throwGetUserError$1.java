package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetUserOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GetUserOperationDeserializerKt", f = "GetUserOperationDeserializer.kt", l = {50, 62, 63, 64, 65, 66, 67, 68, 69, 70}, m = "throwGetUserError")
/* loaded from: classes.dex */
public final class GetUserOperationDeserializerKt$throwGetUserError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GetUserOperationDeserializerKt.access$throwGetUserError(null, null, this);
    }
}
