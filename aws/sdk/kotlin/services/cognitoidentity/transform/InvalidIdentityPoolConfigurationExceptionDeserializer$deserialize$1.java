package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.InvalidIdentityPoolConfigurationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InvalidIdentityPoolConfigurationExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.InvalidIdentityPoolConfigurationExceptionDeserializer", f = "InvalidIdentityPoolConfigurationExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class InvalidIdentityPoolConfigurationExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public InvalidIdentityPoolConfigurationException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InvalidIdentityPoolConfigurationExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidIdentityPoolConfigurationExceptionDeserializer$deserialize$1(InvalidIdentityPoolConfigurationExceptionDeserializer invalidIdentityPoolConfigurationExceptionDeserializer, Continuation<? super InvalidIdentityPoolConfigurationExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = invalidIdentityPoolConfigurationExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
