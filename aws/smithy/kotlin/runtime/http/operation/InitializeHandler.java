package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class InitializeHandler<Input, Output> implements Handler<Input, Output> {
    public final Handler<Input, Output> inner;

    public InitializeHandler(SerializeHandler serializeHandler) {
        this.inner = serializeHandler;
    }

    @Override // aws.smithy.kotlin.runtime.io.Handler
    public final Object call(Input r2, Continuation<? super Output> continuation) {
        return this.inner.call(r2, continuation);
    }
}
