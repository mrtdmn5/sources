package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.ExternalServiceException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ExternalServiceExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer", f = "ExternalServiceExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class ExternalServiceExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public ExternalServiceException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ExternalServiceExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExternalServiceExceptionDeserializer$deserialize$1(ExternalServiceExceptionDeserializer externalServiceExceptionDeserializer, Continuation<? super ExternalServiceExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = externalServiceExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
