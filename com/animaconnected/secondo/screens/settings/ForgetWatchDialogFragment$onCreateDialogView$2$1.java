package com.animaconnected.secondo.screens.settings;

import androidx.fragment.app.Fragment;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: ForgetWatchDialogFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$onCreateDialogView$2$1", f = "ForgetWatchDialogFragment.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ForgetWatchDialogFragment$onCreateDialogView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $parent;
    final /* synthetic */ WatchProvider $watch;
    int label;
    final /* synthetic */ ForgetWatchDialogFragment this$0;

    /* compiled from: ForgetWatchDialogFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$onCreateDialogView$2$1$1", f = "ForgetWatchDialogFragment.kt", l = {56, 63}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$onCreateDialogView$2$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Fragment $parent;
        final /* synthetic */ WatchProvider $watch;
        int label;
        final /* synthetic */ ForgetWatchDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WatchProvider watchProvider, ForgetWatchDialogFragment forgetWatchDialogFragment, Fragment fragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$watch = watchProvider;
            this.this$0 = forgetWatchDialogFragment;
            this.$parent = fragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$watch, this.this$0, this.$parent, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0087  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$onCreateDialogView$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgetWatchDialogFragment$onCreateDialogView$2$1(WatchProvider watchProvider, ForgetWatchDialogFragment forgetWatchDialogFragment, Fragment fragment, Continuation<? super ForgetWatchDialogFragment$onCreateDialogView$2$1> continuation) {
        super(2, continuation);
        this.$watch = watchProvider;
        this.this$0 = forgetWatchDialogFragment;
        this.$parent = fragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgetWatchDialogFragment$onCreateDialogView$2$1(this.$watch, this.this$0, this.$parent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            FitnessProvider fitness = this.$watch.fitness();
            this.label = 1;
            if (fitness.forceSyncFitnessDataToCloud(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$watch, this.this$0, this.$parent, null);
        this.label = 2;
        if (TimeoutKt.withTimeoutOrNull(15000L, anonymousClass1, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForgetWatchDialogFragment$onCreateDialogView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
