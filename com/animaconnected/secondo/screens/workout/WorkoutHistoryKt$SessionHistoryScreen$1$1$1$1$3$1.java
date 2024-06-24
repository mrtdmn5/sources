package com.animaconnected.secondo.screens.workout;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.DpSize;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.workout.SessionListItem;
import com.animaconnected.widget.ImageLoadingState;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: WorkoutHistory.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1", f = "WorkoutHistory.kt", l = {106, 103}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1 extends SuspendLambda implements Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> {
    final /* synthetic */ SessionListItem $sessionListItem;
    /* synthetic */ long J$0;
    /* synthetic */ long J$1;
    long J$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1(SessionListItem sessionListItem, Continuation<? super WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1> continuation) {
        super(3, continuation);
        this.$sessionListItem = sessionListItem;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(DpSize dpSize, Color color, Continuation<? super ImageLoadingState> continuation) {
        return m1013invokeeO5JflE(dpSize.packedValue, color.value, continuation);
    }

    /* renamed from: invoke-eO5JflE, reason: not valid java name */
    public final Object m1013invokeeO5JflE(long j, long j2, Continuation<? super ImageLoadingState> continuation) {
        WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1 workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1 = new WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1(this.$sessionListItem, continuation);
        workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1.J$0 = j;
        workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1.J$1 = j2;
        return workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1.invokeSuspend(Unit.INSTANCE);
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
            timestamp = this.$sessionListItem.getTimestamp();
            FitnessProvider fitness = ProviderFactory.getWatch().fitness();
            long timestamp2 = this.$sessionListItem.getTimestamp();
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
