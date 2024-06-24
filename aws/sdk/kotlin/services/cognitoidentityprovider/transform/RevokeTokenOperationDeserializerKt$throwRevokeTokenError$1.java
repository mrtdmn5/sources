package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import io.reactivex.internal.util.Pow2;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RevokeTokenOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.RevokeTokenOperationDeserializerKt", f = "RevokeTokenOperationDeserializer.kt", l = {30, 42, 43, 44, 45, 46, 47, 48}, m = "throwRevokeTokenError")
/* loaded from: classes.dex */
public final class RevokeTokenOperationDeserializerKt$throwRevokeTokenError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Pow2.access$throwRevokeTokenError(null, null, this);
    }
}
