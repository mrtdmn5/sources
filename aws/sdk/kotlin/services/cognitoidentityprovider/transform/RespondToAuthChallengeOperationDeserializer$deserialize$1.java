package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.RespondToAuthChallengeResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RespondToAuthChallengeOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.RespondToAuthChallengeOperationDeserializer", f = "RespondToAuthChallengeOperationDeserializer.kt", l = {37, 41}, m = "deserialize")
/* loaded from: classes.dex */
public final class RespondToAuthChallengeOperationDeserializer$deserialize$1 extends ContinuationImpl {
    public RespondToAuthChallengeResponse.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RespondToAuthChallengeOperationDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RespondToAuthChallengeOperationDeserializer$deserialize$1(RespondToAuthChallengeOperationDeserializer respondToAuthChallengeOperationDeserializer, Continuation<? super RespondToAuthChallengeOperationDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = respondToAuthChallengeOperationDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
