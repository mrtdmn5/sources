package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UpdateUserAttributesOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.UpdateUserAttributesOperationDeserializerKt", f = "UpdateUserAttributesOperationDeserializer.kt", l = {49, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79}, m = "throwUpdateUserAttributesError")
/* loaded from: classes.dex */
public final class UpdateUserAttributesOperationDeserializerKt$throwUpdateUserAttributesError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UpdateUserAttributesOperationDeserializerKt.access$throwUpdateUserAttributesError(null, null, this);
    }
}
