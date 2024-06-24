package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.PasswordResetRequiredException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PasswordResetRequiredExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.PasswordResetRequiredExceptionDeserializer", f = "PasswordResetRequiredExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class PasswordResetRequiredExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public PasswordResetRequiredException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PasswordResetRequiredExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordResetRequiredExceptionDeserializer$deserialize$1(PasswordResetRequiredExceptionDeserializer passwordResetRequiredExceptionDeserializer, Continuation<? super PasswordResetRequiredExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = passwordResetRequiredExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
