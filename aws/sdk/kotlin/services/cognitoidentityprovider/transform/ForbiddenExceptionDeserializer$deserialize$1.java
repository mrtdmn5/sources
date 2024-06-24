package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ForbiddenException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ForbiddenExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.ForbiddenExceptionDeserializer", f = "ForbiddenExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class ForbiddenExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public ForbiddenException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ForbiddenExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbiddenExceptionDeserializer$deserialize$1(ForbiddenExceptionDeserializer forbiddenExceptionDeserializer, Continuation<? super ForbiddenExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = forbiddenExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
