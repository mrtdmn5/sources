package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.CodeMismatchException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CodeMismatchExceptionDeserializer.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.transform.CodeMismatchExceptionDeserializer", f = "CodeMismatchExceptionDeserializer.kt", l = {30}, m = "deserialize")
/* loaded from: classes.dex */
public final class CodeMismatchExceptionDeserializer$deserialize$1 extends ContinuationImpl {
    public CodeMismatchException.Builder L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CodeMismatchExceptionDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeMismatchExceptionDeserializer$deserialize$1(CodeMismatchExceptionDeserializer codeMismatchExceptionDeserializer, Continuation<? super CodeMismatchExceptionDeserializer$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = codeMismatchExceptionDeserializer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
