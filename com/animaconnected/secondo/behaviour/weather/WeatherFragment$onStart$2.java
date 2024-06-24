package com.animaconnected.secondo.behaviour.weather;

import android.view.View;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.provider.weather.WeatherViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeatherFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.weather.WeatherFragment$onStart$2", f = "WeatherFragment.kt", l = {80}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WeatherFragment$onStart$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WeatherFragment this$0;

    /* compiled from: WeatherFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.behaviour.weather.WeatherFragment$onStart$2$1", f = "WeatherFragment.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.behaviour.weather.WeatherFragment$onStart$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FitnessProvider.Profile.Temperature, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FitnessProvider.Profile.Temperature temperature, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(temperature, continuation)).invokeSuspend(Unit.INSTANCE);
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
                FitnessProvider.Profile.Temperature temperature = (FitnessProvider.Profile.Temperature) this.L$0;
                FitnessProvider.Profile profile = ProviderFactory.getWatch().fitness().getProfile();
                this.label = 1;
                if (profile.setTemperatureUnit(temperature, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherFragment$onStart$2(WeatherFragment weatherFragment, Continuation<? super WeatherFragment$onStart$2> continuation) {
        super(2, continuation);
        this.this$0 = weatherFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WeatherFragment$onStart$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WeatherFragment$onStart$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                if (weatherViewModel.changeMeasurement(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("weatherViewModel");
                throw null;
            }
        }
        return Unit.INSTANCE;
    }
}
