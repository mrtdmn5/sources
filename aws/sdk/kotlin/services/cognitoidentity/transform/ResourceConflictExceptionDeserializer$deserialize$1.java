package aws.sdk.kotlin.services.cognitoidentity.transform;

import aws.sdk.kotlin.services.cognitoidentity.model.ResourceConflictException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ResourceConflictExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.transform.ResourceConflictExceptionDeserializer", f = "ResourceConflictExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class ResourceConflictExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public ResourceConflictException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ResourceConflictExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceConflictExceptionDeserializer$deserialize$1(ResourceConflictExceptionDeserializer resourceConflictExceptionDeserializer, Continuation<? super ResourceConflictExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = resourceConflictExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
