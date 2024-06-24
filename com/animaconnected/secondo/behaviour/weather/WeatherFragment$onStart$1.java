package com.animaconnected.secondo.behaviour.weather;

import com.animaconnected.watch.provider.weather.WeatherViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WeatherFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.weather.WeatherFragment$onStart$1", f = "WeatherFragment.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WeatherFragment$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WeatherFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherFragment$onStart$1(WeatherFragment weatherFragment, Continuation<? super WeatherFragment$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = weatherFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WeatherFragment$onStart$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WeatherViewModel weatherViewModel;
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
            weatherViewModel = this.this$0.weatherViewModel;
            if (weatherViewModel != null) {
                this.label = 1;
                if (weatherViewModel.loadData(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
                throw null;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WeatherFragment$onStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
