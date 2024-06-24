package com.animaconnected.secondo.provider.analytics;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.Slot;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnalyticsConfigHelper.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1", f = "AnalyticsConfigHelper.kt", l = {38, 39, 40}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Slot $slot;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnalyticsConfigHelper this$0;

    /* compiled from: AnalyticsConfigHelper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Slot.values().length];
            try {
                r0[Slot.TopPusher.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Slot.BottomPusher.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Slot.MainComplication.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Slot.MainComplicationDouble.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Slot.SubComplication1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Slot.SubComplication2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[Slot.NotInitialized.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[Slot.Unknown.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1(Slot slot, AnalyticsConfigHelper analyticsConfigHelper, Continuation<? super AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1> continuation) {
        super(2, continuation);
        this.$slot = slot;
        this.this$0 = analyticsConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1 analyticsConfigHelper$sendCorrectAnalyticsConfig$1 = new AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1(this.$slot, this.this$0, continuation);
        analyticsConfigHelper$sendCorrectAnalyticsConfig$1.L$0 = obj;
        return analyticsConfigHelper$sendCorrectAnalyticsConfig$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendPusherAnalytics;
        Object sendComplicationAnalytics;
        Object sendSubComplicationAnalytics;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1 || r1 == 2 || r1 == 3) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            switch (WhenMappings.$EnumSwitchMapping$0[this.$slot.ordinal()]) {
                case 1:
                case 2:
                    AnalyticsConfigHelper analyticsConfigHelper = this.this$0;
                    this.label = 1;
                    sendPusherAnalytics = analyticsConfigHelper.sendPusherAnalytics(this);
                    if (sendPusherAnalytics == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    break;
                case 3:
                case 4:
                    AnalyticsConfigHelper analyticsConfigHelper2 = this.this$0;
                    this.label = 2;
                    sendComplicationAnalytics = analyticsConfigHelper2.sendComplicationAnalytics(this);
                    if (sendComplicationAnalytics == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    break;
                case 5:
                case 6:
                    AnalyticsConfigHelper analyticsConfigHelper3 = this.this$0;
                    this.label = 3;
                    sendSubComplicationAnalytics = analyticsConfigHelper3.sendSubComplicationAnalytics(this);
                    if (sendSubComplicationAnalytics == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    break;
                case 7:
                case 8:
                    break;
                default:
                    final Slot slot = this.$slot;
                    LogKt.debug$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.analytics.AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Experimental slot " + Slot.this + " used. Not sending analytics";
                        }
                    }, 7, (Object) null);
                    break;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnalyticsConfigHelper$sendCorrectAnalyticsConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
