package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class SdkOperationExecutionKt$decorate$3 extends FunctionReferenceImpl implements Function3<ExecutionContext, HttpResponse, Continuation<Object>, Object> {
    public SdkOperationExecutionKt$decorate$3(HttpDeserialize httpDeserialize) {
        super(3, httpDeserialize, HttpDeserialize.class, "deserialize", "deserialize(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ExecutionContext executionContext, HttpResponse httpResponse, Continuation<Object> continuation) {
        return ((HttpDeserialize) this.receiver).deserialize(executionContext, httpResponse, continuation);
    }
}
