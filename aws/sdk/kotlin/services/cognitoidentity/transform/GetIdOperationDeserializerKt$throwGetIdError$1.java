package aws.sdk.kotlin.services.cognitoidentity.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetIdOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.GetIdOperationDeserializerKt", f = "GetIdOperationDeserializer.kt", l = {47, 59, 60, 61, 62, 63, 64, 65, 66}, m = "throwGetIdError")
/* loaded from: classes.dex */
public final class GetIdOperationDeserializerKt$throwGetIdError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GetIdOperationDeserializerKt.access$throwGetIdError(null, null, this);
    }
}
