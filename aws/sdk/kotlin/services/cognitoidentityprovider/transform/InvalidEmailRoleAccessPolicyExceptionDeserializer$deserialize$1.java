package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidEmailRoleAccessPolicyException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InvalidEmailRoleAccessPolicyExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidEmailRoleAccessPolicyExceptionDeserializer", f = "InvalidEmailRoleAccessPolicyExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class InvalidEmailRoleAccessPolicyExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public InvalidEmailRoleAccessPolicyException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InvalidEmailRoleAccessPolicyExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidEmailRoleAccessPolicyExceptionDeserializer$deserialize$1(InvalidEmailRoleAccessPolicyExceptionDeserializer invalidEmailRoleAccessPolicyExceptionDeserializer, Continuation<? super InvalidEmailRoleAccessPolicyExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = invalidEmailRoleAccessPolicyExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
