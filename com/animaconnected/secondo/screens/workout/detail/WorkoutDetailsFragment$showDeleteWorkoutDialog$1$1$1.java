package com.animaconnected.secondo.screens.workout.detail;

import android.view.View;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.utils.Loading;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1", f = "WorkoutDetailsFragment.kt", l = {494, 495}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ Loading $loading;
    Object L$0;
    int label;
    final /* synthetic */ WorkoutDetailsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1(Loading loading, WorkoutDetailsFragment workoutDetailsFragment, BottomDialog bottomDialog, Continuation<? super WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1> continuation) {
        super(2, continuation);
        this.$loading = loading;
        this.this$0 = workoutDetailsFragment;
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1(this.$loading, this.this$0, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0070  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L21
            if (r1 == r4) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r0 = r5.L$0
            com.animaconnected.watch.utils.WatchLibResult r0 = (com.animaconnected.watch.utils.WatchLibResult) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5b
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L42
        L21:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.secondo.utils.Loading r6 = r5.$loading
            r6.invalidate(r4)
            com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment r6 = r5.this$0
            com.animaconnected.watch.fitness.Session r6 = com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment.access$getDetailedSession$p(r6)
            if (r6 == 0) goto L45
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.fitness.FitnessProvider r1 = r1.fitness()
            r5.label = r4
            java.lang.Object r6 = r1.deleteSession(r6, r5)
            if (r6 != r0) goto L42
            return r0
        L42:
            com.animaconnected.watch.utils.WatchLibResult r6 = (com.animaconnected.watch.utils.WatchLibResult) r6
            goto L46
        L45:
            r6 = r3
        L46:
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.fitness.FitnessProvider r1 = r1.fitness()
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = r1.hasValidSessions(r5)
            if (r1 != r0) goto L59
            return r0
        L59:
            r0 = r6
            r6 = r1
        L5b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            com.animaconnected.secondo.utils.Loading r1 = r5.$loading
            r2 = 0
            r1.invalidate(r2)
            com.animaconnected.secondo.screens.BottomDialog r1 = r5.$dialog
            r1.dismiss()
            boolean r1 = r0 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r1 == 0) goto L90
            if (r6 != 0) goto L86
            com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment r6 = r5.this$0
            boolean r6 = com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment.access$getInWorkoutHistory$p(r6)
            if (r6 == 0) goto L86
            com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment r6 = r5.this$0
            com.animaconnected.secondo.screens.MainController r6 = r6.getMainController()
            java.lang.String r0 = "HealthDashboardFragment"
            r6.popUntilFragment(r0)
            goto Lb0
        L86:
            com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment r6 = r5.this$0
            com.animaconnected.secondo.screens.MainController r6 = r6.getMainController()
            r6.goBack()
            goto Lb0
        L90:
            boolean r6 = r0 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r6 == 0) goto L95
            goto L99
        L95:
            if (r0 != 0) goto L98
            goto L99
        L98:
            r4 = r2
        L99:
            if (r4 == 0) goto Lb0
            com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment r6 = r5.this$0
            android.content.Context r6 = r6.requireContext()
            java.lang.String r0 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            com.animaconnected.secondo.provider.login.DialogMessage$Generic r0 = com.animaconnected.secondo.provider.login.DialogMessage.Generic.INSTANCE
            com.animaconnected.secondo.provider.login.DialogInfo r0 = com.animaconnected.secondo.provider.login.DialogMessageKt.getDialogInfo(r0)
            r1 = 4
            com.animaconnected.secondo.utils.AccountUtilsKt.showDialogInfo$default(r6, r0, r3, r1, r3)
        Lb0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
