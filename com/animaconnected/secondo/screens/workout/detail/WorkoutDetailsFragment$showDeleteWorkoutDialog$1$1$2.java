package com.animaconnected.secondo.screens.workout.detail;

import android.view.View;
import com.animaconnected.secondo.screens.BottomDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2", f = "WorkoutDetailsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2(BottomDialog bottomDialog, Continuation<? super WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2> continuation) {
        super(2, continuation);
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2(this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$showDeleteWorkoutDialog$1$1$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$dialog.dismiss();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
