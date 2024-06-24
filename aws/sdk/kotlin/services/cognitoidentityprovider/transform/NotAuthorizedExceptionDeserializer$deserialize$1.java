package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.NotAuthorizedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NotAuthorizedExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.NotAuthorizedExceptionDeserializer", f = "NotAuthorizedExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class NotAuthorizedExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public NotAuthorizedException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NotAuthorizedExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotAuthorizedExceptionDeserializer$deserialize$1(NotAuthorizedExceptionDeserializer notAuthorizedExceptionDeserializer, Continuation<? super NotAuthorizedExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = notAuthorizedExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
