package aws.smithy.kotlin.runtime.http.operation;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: SdkHttpOperation.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$roundTrip$2", f = "SdkHttpOperation.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SdkHttpOperationKt$roundTrip$2 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {
    public /* synthetic */ Object L$0;

    public SdkHttpOperationKt$roundTrip$2(Continuation<? super SdkHttpOperationKt$roundTrip$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SdkHttpOperationKt$roundTrip$2 sdkHttpOperationKt$roundTrip$2 = new SdkHttpOperationKt$roundTrip$2(continuation);
        sdkHttpOperationKt$roundTrip$2.L$0 = obj;
        return sdkHttpOperationKt$roundTrip$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<Object> continuation) {
        return ((SdkHttpOperationKt$roundTrip$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return this.L$0;
    }
}
