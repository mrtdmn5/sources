package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: RepeatOnLifecycle.kt */
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    public final /* synthetic */ Lifecycle.State $state;
    public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    public /* synthetic */ Object L$0;
    public int label;

    /* compiled from: RepeatOnLifecycle.kt */
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {R.styleable.AppTheme_tabTextSelectedColor}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
        public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        public final /* synthetic */ Lifecycle.State $state;
        public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        public Ref$ObjectRef L$0;
        public Ref$ObjectRef L$1;
        public CoroutineScope L$4;
        public Function2 L$5;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, CoroutineScope coroutineScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = coroutineScope;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
        /* JADX WARN: Type inference failed for: r15v0, types: [androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, T, androidx.lifecycle.LifecycleObserver] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r1.label
                r3 = 0
                androidx.lifecycle.Lifecycle r4 = r1.$this_repeatOnLifecycle
                r5 = 1
                if (r2 == 0) goto L21
                if (r2 != r5) goto L19
                kotlin.jvm.internal.Ref$ObjectRef r2 = r1.L$1
                kotlin.jvm.internal.Ref$ObjectRef r5 = r1.L$0
                kotlin.ResultKt.throwOnFailure(r17)     // Catch: java.lang.Throwable -> L16
                goto L7d
            L16:
                r0 = move-exception
                goto L95
            L19:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L21:
                kotlin.ResultKt.throwOnFailure(r17)
                androidx.lifecycle.Lifecycle$State r2 = r4.getCurrentState()
                androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r2 != r6) goto L2f
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L2f:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
                r13.<init>()
                androidx.lifecycle.Lifecycle$State r6 = r1.$state     // Catch: java.lang.Throwable -> L92
                kotlinx.coroutines.CoroutineScope r8 = r1.$$this$coroutineScope     // Catch: java.lang.Throwable -> L92
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r12 = r1.$block     // Catch: java.lang.Throwable -> L92
                r1.L$0 = r2     // Catch: java.lang.Throwable -> L92
                r1.L$1 = r13     // Catch: java.lang.Throwable -> L92
                r1.L$4 = r8     // Catch: java.lang.Throwable -> L92
                r1.L$5 = r12     // Catch: java.lang.Throwable -> L92
                r1.label = r5     // Catch: java.lang.Throwable -> L92
                kotlinx.coroutines.CancellableContinuationImpl r14 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L92
                kotlin.coroutines.Continuation r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r16)     // Catch: java.lang.Throwable -> L92
                r14.<init>(r5, r7)     // Catch: java.lang.Throwable -> L92
                r14.initCancellability()     // Catch: java.lang.Throwable -> L92
                androidx.lifecycle.Lifecycle$Event$Companion r5 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> L92
                r5.getClass()     // Catch: java.lang.Throwable -> L92
                androidx.lifecycle.Lifecycle$Event r7 = androidx.lifecycle.Lifecycle.Event.Companion.upTo(r6)     // Catch: java.lang.Throwable -> L92
                androidx.lifecycle.Lifecycle$Event r9 = androidx.lifecycle.Lifecycle.Event.Companion.downFrom(r6)     // Catch: java.lang.Throwable -> L92
                kotlinx.coroutines.sync.MutexImpl r11 = kotlinx.coroutines.sync.MutexKt.Mutex$default()     // Catch: java.lang.Throwable -> L92
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r15 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> L92
                r5 = r15
                r6 = r7
                r7 = r2
                r10 = r14
                r5.<init>()     // Catch: java.lang.Throwable -> L92
                r13.element = r15     // Catch: java.lang.Throwable -> L92
                r4.addObserver(r15)     // Catch: java.lang.Throwable -> L92
                java.lang.Object r5 = r14.getResult()     // Catch: java.lang.Throwable -> L92
                if (r5 != r0) goto L7b
                return r0
            L7b:
                r5 = r2
                r2 = r13
            L7d:
                T r0 = r5.element
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto L86
                r0.cancel(r3)
            L86:
                T r0 = r2.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L8f
                r4.removeObserver(r0)
            L8f:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L92:
                r0 = move-exception
                r5 = r2
                r2 = r13
            L95:
                T r5 = r5.element
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                if (r5 == 0) goto L9e
                r5.cancel(r3)
            L9e:
                T r2 = r2.element
                androidx.lifecycle.LifecycleEventObserver r2 = (androidx.lifecycle.LifecycleEventObserver) r2
                if (r2 == 0) goto La7
                r4.removeObserver(r2)
            La7:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            MainCoroutineDispatcher immediate = MainDispatcherLoader.dispatcher.getImmediate();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, coroutineScope, this.$block, null);
            this.label = 1;
            if (BuildersKt.withContext(immediate, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
