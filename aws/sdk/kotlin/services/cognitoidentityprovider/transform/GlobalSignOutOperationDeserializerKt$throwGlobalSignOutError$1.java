package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import com.google.android.gms.measurement.internal.zzaz;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GlobalSignOutOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.GlobalSignOutOperationDeserializerKt", f = "GlobalSignOutOperationDeserializer.kt", l = {30, 42, 43, 44, 45, 46, 47, 48, 49}, m = "throwGlobalSignOutError")
/* loaded from: classes.dex */
public final class GlobalSignOutOperationDeserializerKt$throwGlobalSignOutError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return zzaz.access$throwGlobalSignOutError(null, null, this);
    }
}
