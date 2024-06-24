package aws.sdk.kotlin.services.cognitoidentity.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetCredentialsForIdentityOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.GetCredentialsForIdentityOperationDeserializerKt", f = "GetCredentialsForIdentityOperationDeserializer.kt", l = {48, 60, 61, 62, 63, 64, 65, 66, 67}, m = "throwGetCredentialsForIdentityError")
/* loaded from: classes.dex */
public final class GetCredentialsForIdentityOperationDeserializerKt$throwGetCredentialsForIdentityError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GetCredentialsForIdentityOperationDeserializerKt.access$throwGetCredentialsForIdentityError(null, null, this);
    }
}
