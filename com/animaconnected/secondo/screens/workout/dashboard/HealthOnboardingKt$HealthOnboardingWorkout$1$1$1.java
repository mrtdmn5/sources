package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.DpSize;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.mock.LocationMock;
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

/* compiled from: HealthOnboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingWorkout$1$1$1", f = "HealthOnboarding.kt", l = {92}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HealthOnboardingKt$HealthOnboardingWorkout$1$1$1 extends SuspendLambda implements Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> {
    final /* synthetic */ SessionCardData $session;
    /* synthetic */ long J$0;
    /* synthetic */ long J$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthOnboardingKt$HealthOnboardingWorkout$1$1$1(SessionCardData sessionCardData, Continuation<? super HealthOnboardingKt$HealthOnboardingWorkout$1$1$1> continuation) {
        super(3, continuation);
        this.$session = sessionCardData;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(DpSize dpSize, Color color, Continuation<? super ImageLoadingState> continuation) {
        return m1019invokeeO5JflE(dpSize.packedValue, color.value, continuation);
    }

    /* renamed from: invoke-eO5JflE, reason: not valid java name */
    public final Object m1019invokeeO5JflE(long j, long j2, Continuation<? super ImageLoadingState> continuation) {
        HealthOnboardingKt$HealthOnboardingWorkout$1$1$1 healthOnboardingKt$HealthOnboardingWorkout$1$1$1 = new HealthOnboardingKt$HealthOnboardingWorkout$1$1$1(this.$session, continuation);
        healthOnboardingKt$HealthOnboardingWorkout$1$1$1.J$0 = j;
        healthOnboardingKt$HealthOnboardingWorkout$1$1$1.J$1 = j2;
        return healthOnboardingKt$HealthOnboardingWorkout$1$1$1.invokeSuspend(Unit.INSTANCE);
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
            long j2 = this.J$1;
            List<LocationEntry> runningRoute = LocationMock.INSTANCE.getRunningRoute();
            long timestamp = this.$session.getTimestamp();
            this.label = 1;
            obj = GoogleMapsGeneratorKt.m1034generateMapImageo3gnWtI$default(j, j2, runningRoute, timestamp, 0, this, 16, null);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
