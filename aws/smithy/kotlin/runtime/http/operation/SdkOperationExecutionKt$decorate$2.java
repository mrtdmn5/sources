package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class SdkOperationExecutionKt$decorate$2 extends FunctionReferenceImpl implements Function3<ExecutionContext, Object, Continuation<? super HttpRequestBuilder>, Object> {
    public SdkOperationExecutionKt$decorate$2(HttpSerialize httpSerialize) {
        super(3, httpSerialize, HttpSerialize.class, "serialize", "serialize(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ExecutionContext executionContext, Object obj, Continuation<? super HttpRequestBuilder> continuation) {
        return ((HttpSerialize) this.receiver).serialize(obj);
    }
}
