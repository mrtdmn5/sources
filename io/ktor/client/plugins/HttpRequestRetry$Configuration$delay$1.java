package io.ktor.client.plugins;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* compiled from: HttpRequestRetry.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$Configuration$delay$1", f = "HttpRequestRetry.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpRequestRetry$Configuration$delay$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    public /* synthetic */ long J$0;
    public int label;

    public HttpRequestRetry$Configuration$delay$1(Continuation<? super HttpRequestRetry$Configuration$delay$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HttpRequestRetry$Configuration$delay$1 httpRequestRetry$Configuration$delay$1 = new HttpRequestRetry$Configuration$delay$1(continuation);
        httpRequestRetry$Configuration$delay$1.J$0 = ((Number) obj).longValue();
        return httpRequestRetry$Configuration$delay$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Long l, Continuation<? super Unit> continuation) {
        return ((HttpRequestRetry$Configuration$delay$1) create(Long.valueOf(l.longValue()), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            long j = this.J$0;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
