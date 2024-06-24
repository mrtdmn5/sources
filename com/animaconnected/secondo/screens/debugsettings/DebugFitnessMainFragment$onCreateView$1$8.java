package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import android.widget.Toast;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$8", f = "DebugFitnessMainFragment.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$8 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_apply;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$8(DebugFitnessMainFragment debugFitnessMainFragment, View view, Continuation<? super DebugFitnessMainFragment$onCreateView$1$8> continuation) {
        super(2, continuation);
        this.this$0 = debugFitnessMainFragment;
        this.$this_apply = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$8(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$8) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitnessProvider;
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
            fitnessProvider = this.this$0.fitnessProvider;
            this.label = 1;
            if (fitnessProvider.deleteFitnessData(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        Toast.makeText(this.$this_apply.getContext(), "Delete on cloud", 0).show();
        return Unit.INSTANCE;
    }
}
