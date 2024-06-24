package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.InvalidSmsRoleTrustRelationshipException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InvalidSmsRoleTrustRelationshipExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.InvalidSmsRoleTrustRelationshipExceptionDeserializer", f = "InvalidSmsRoleTrustRelationshipExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class InvalidSmsRoleTrustRelationshipExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public InvalidSmsRoleTrustRelationshipException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InvalidSmsRoleTrustRelationshipExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidSmsRoleTrustRelationshipExceptionDeserializer$deserialize$1(InvalidSmsRoleTrustRelationshipExceptionDeserializer invalidSmsRoleTrustRelationshipExceptionDeserializer, Continuation<? super InvalidSmsRoleTrustRelationshipExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = invalidSmsRoleTrustRelationshipExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
