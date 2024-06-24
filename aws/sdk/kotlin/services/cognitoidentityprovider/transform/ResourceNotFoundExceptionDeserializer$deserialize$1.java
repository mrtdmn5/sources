package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ResourceNotFoundException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResourceNotFoundExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ResourceNotFoundExceptionDeserializer", f = "ResourceNotFoundExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class ResourceNotFoundExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public ResourceNotFoundException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ResourceNotFoundExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceNotFoundExceptionDeserializer$deserialize$1(ResourceNotFoundExceptionDeserializer resourceNotFoundExceptionDeserializer, Continuation<? super ResourceNotFoundExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = resourceNotFoundExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
