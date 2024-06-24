package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ChangePasswordOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ChangePasswordOperationDeserializer", f = "ChangePasswordOperationDeserializer.kt", l = {21}, m = "deserialize")
/* loaded from: classes.dex */
public final class ChangePasswordOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ChangePasswordOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangePasswordOperationDeserializer$deserialize$1(ChangePasswordOperationDeserializer changePasswordOperationDeserializer, Continuation<? super ChangePasswordOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = changePasswordOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
