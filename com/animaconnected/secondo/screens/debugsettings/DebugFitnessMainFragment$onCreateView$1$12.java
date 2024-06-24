package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.animaconnected.watch.device.SharedPrefsStorageFactory;
import com.animaconnected.watch.workout.DashboardViewModel;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$12", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreateView$1$12 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_apply;
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* compiled from: DebugFitnessMainFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$12$1", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreateView$1$12$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $this_apply;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(View view, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_apply = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_apply, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.$this_apply.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                new SharedPrefsStorageFactory(context).createStorage(DashboardViewModel.ONBOARDING_STORAGE_NAME).put(DashboardViewModel.IS_ONBOARDING_KEY, true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugFitnessMainFragment$onCreateView$1$12(DebugFitnessMainFragment debugFitnessMainFragment, View view, Continuation<? super DebugFitnessMainFragment$onCreateView$1$12> continuation) {
        super(2, continuation);
        this.this$0 = debugFitnessMainFragment;
        this.$this_apply = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreateView$1$12(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreateView$1$12) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default(Hashing.getLifecycleScope(this.this$0), Dispatchers.IO, null, new AnonymousClass1(this.$this_apply, null), 2);
            Toast.makeText(this.$this_apply.getContext(), "Reset done.", 0).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
