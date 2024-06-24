package com.animaconnected.secondo.provider.googlefit;

import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onStepsNow$1", f = "GoogleFitProvider.kt", l = {211}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitProvider$onStepsNow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $stepsToday;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitProvider$onStepsNow$1(GoogleFitProvider googleFitProvider, int r2, Continuation<? super GoogleFitProvider$onStepsNow$1> continuation) {
        super(2, continuation);
        this.this$0 = googleFitProvider;
        this.$stepsToday = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitProvider$onStepsNow$1 googleFitProvider$onStepsNow$1 = new GoogleFitProvider$onStepsNow$1(this.this$0, this.$stepsToday, continuation);
        googleFitProvider$onStepsNow$1.L$0 = obj;
        return googleFitProvider$onStepsNow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        GoogleFitApi googleFitApi;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e) {
                        exc = e;
                        coroutineScope = coroutineScope2;
                        LogKt.warn$default((Object) coroutineScope, "Step upload failed", (String) null, (Throwable) exc, false, 10, (Object) null);
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    this.this$0.isUploading = true;
                    googleFitApi = this.this$0.api;
                    int r4 = this.$stepsToday;
                    this.L$0 = coroutineScope3;
                    this.label = 1;
                    if (googleFitApi.uploadSteps(r4, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Exception e2) {
                    coroutineScope = coroutineScope3;
                    exc = e2;
                    LogKt.warn$default((Object) coroutineScope, "Step upload failed", (String) null, (Throwable) exc, false, 10, (Object) null);
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        } finally {
            this.this$0.isUploading = false;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitProvider$onStepsNow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
