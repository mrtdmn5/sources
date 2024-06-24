package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.DpSize;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.widget.ImageLoadingState;
import com.animaconnected.widget.SessionCardData;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HealthDashboardScreen.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardScreenKt$WorkoutSection$1$1", f = "HealthDashboardScreen.kt", l = {386, 383}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthDashboardScreenKt$WorkoutSection$1$1 extends SuspendLambda implements Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> {
    final /* synthetic */ SessionCardData $session;
    /* synthetic */ long J$0;
    /* synthetic */ long J$1;
    long J$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthDashboardScreenKt$WorkoutSection$1$1(SessionCardData sessionCardData, Continuation<? super HealthDashboardScreenKt$WorkoutSection$1$1> continuation) {
        super(3, continuation);
        this.$session = sessionCardData;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(DpSize dpSize, Color color, Continuation<? super ImageLoadingState> continuation) {
        return m1018invokeeO5JflE(dpSize.packedValue, color.value, continuation);
    }

    /* renamed from: invoke-eO5JflE, reason: not valid java name */
    public final Object m1018invokeeO5JflE(long j, long j2, Continuation<? super ImageLoadingState> continuation) {
        HealthDashboardScreenKt$WorkoutSection$1$1 healthDashboardScreenKt$WorkoutSection$1$1 = new HealthDashboardScreenKt$WorkoutSection$1$1(this.$session, continuation);
        healthDashboardScreenKt$WorkoutSection$1$1.J$0 = j;
        healthDashboardScreenKt$WorkoutSection$1$1.J$1 = j2;
        return healthDashboardScreenKt$WorkoutSection$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        long timestamp;
        Object locationForSession;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r0 = this.label;
        if (r0 != 0) {
            if (r0 != 1) {
                if (r0 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = this.J$2;
            long j4 = this.J$1;
            long j5 = this.J$0;
            ResultKt.throwOnFailure(obj);
            locationForSession = obj;
            j = j5;
            timestamp = j3;
            j2 = j4;
        } else {
            ResultKt.throwOnFailure(obj);
            j = this.J$0;
            j2 = this.J$1;
            timestamp = this.$session.getTimestamp();
            FitnessProvider fitness = ProviderFactory.getWatch().fitness();
            long timestamp2 = this.$session.getTimestamp();
            this.J$0 = j;
            this.J$1 = j2;
            this.J$2 = timestamp;
            this.label = 1;
            locationForSession = fitness.getLocationForSession(timestamp2, this);
            if (locationForSession == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.label = 2;
        Object m1034generateMapImageo3gnWtI$default = GoogleMapsGeneratorKt.m1034generateMapImageo3gnWtI$default(j, j2, (List) locationForSession, timestamp, 0, this, 16, null);
        if (m1034generateMapImageo3gnWtI$default == coroutineSingletons) {
            return coroutineSingletons;
        }
        return m1034generateMapImageo3gnWtI$default;
    }
}
