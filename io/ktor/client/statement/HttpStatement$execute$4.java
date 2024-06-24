package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpStatement$execute$4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public HttpStatement$execute$4(Continuation<? super HttpStatement$execute$4> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HttpStatement$execute$4 httpStatement$execute$4 = new HttpStatement$execute$4(continuation);
        httpStatement$execute$4.L$0 = obj;
        return httpStatement$execute$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        return ((HttpStatement$execute$4) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
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
            HttpClientCall call = ((HttpResponse) this.L$0).getCall();
            this.label = 1;
            obj = SavedCallKt.save(call, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return ((HttpClientCall) obj).getResponse();
    }
}
