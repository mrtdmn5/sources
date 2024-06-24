package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import android.widget.Toast;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$7", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$7 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_apply;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* compiled from: DebugFitnessMainFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$7$1", f = "DebugFitnessMainFragment.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundActivity}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$7$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $this_apply;
        int label;
        final /* synthetic */ DebugFitnessMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(View view, DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_apply = view;
            this.this$0 = debugFitnessMainFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_apply, this.this$0, continuation);
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
                Toast.makeText(this.$this_apply.getContext(), "Syncing to cloud...", 0).show();
                fitnessProvider = this.this$0.fitnessProvider;
                this.label = 1;
                if (fitnessProvider.forceSyncFitnessDataToCloud(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            Toast.makeText(this.$this_apply.getContext(), "Sync to cloud completed!", 0).show();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$7(View view, DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super DebugFitnessMainFragment$onCreateView$1$7> continuation) {
        super(2, continuation);
        this.$this_apply = view;
        this.this$0 = debugFitnessMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$7(this.$this_apply, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$7) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AnonymousClass1(this.$this_apply, this.this$0, null), 3);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
