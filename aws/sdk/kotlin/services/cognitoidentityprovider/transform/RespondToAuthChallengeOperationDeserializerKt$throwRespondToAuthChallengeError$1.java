package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RespondToAuthChallengeOperationDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.RespondToAuthChallengeOperationDeserializerKt", f = "RespondToAuthChallengeOperationDeserializer.kt", l = {50, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82}, m = "throwRespondToAuthChallengeError")
/* loaded from: classes.dex */
public final class RespondToAuthChallengeOperationDeserializerKt$throwRespondToAuthChallengeError$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RespondToAuthChallengeOperationDeserializerKt.access$throwRespondToAuthChallengeError(null, null, this);
    }
}
