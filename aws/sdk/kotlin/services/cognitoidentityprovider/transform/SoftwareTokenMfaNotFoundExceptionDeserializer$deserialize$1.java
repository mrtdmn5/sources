package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.SoftwareTokenMfaNotFoundException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SoftwareTokenMfaNotFoundExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.SoftwareTokenMfaNotFoundExceptionDeserializer", f = "SoftwareTokenMfaNotFoundExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class SoftwareTokenMfaNotFoundExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public SoftwareTokenMfaNotFoundException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SoftwareTokenMfaNotFoundExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoftwareTokenMfaNotFoundExceptionDeserializer$deserialize$1(SoftwareTokenMfaNotFoundExceptionDeserializer softwareTokenMfaNotFoundExceptionDeserializer, Continuation<? super SoftwareTokenMfaNotFoundExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = softwareTokenMfaNotFoundExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
