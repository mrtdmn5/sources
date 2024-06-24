package com.animaconnected.secondo.screens.workout.detail;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.account.strava.StravaClient;
import com.animaconnected.watch.fitness.Session;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$8$1$1", f = "WorkoutDetailsFragment.kt", l = {227}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$onCreateView$1$5$8$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Session $session;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$onCreateView$1$5$8$1$1(Session session, Continuation<? super WorkoutDetailsFragment$onCreateView$1$5$8$1$1> continuation) {
        super(2, continuation);
        this.$session = session;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$onCreateView$1$5$8$1$1(this.$session, continuation);
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
            StravaClient stravaClient = ProviderFactory.getWatch().getWatchManager().getStravaClient();
            Session session = this.$session;
            this.label = 1;
            if (stravaClient.uploadSession(session, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$onCreateView$1$5$8$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
