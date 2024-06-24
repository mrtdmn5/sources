package androidx.lifecycle.compose;

import androidx.compose.runtime.ProduceStateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExt.kt */
@DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1", f = "FlowExt.kt", l = {R.styleable.AppTheme_themeBackgroundResource}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FlowExtKt$collectAsStateWithLifecycle$1 extends SuspendLambda implements Function2<ProduceStateScope<Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Lifecycle $lifecycle;
    public final /* synthetic */ Lifecycle.State $minActiveState;
    public final /* synthetic */ Flow<Object> $this_collectAsStateWithLifecycle;
    public /* synthetic */ Object L$0;
    public int label;

    /* compiled from: FlowExt.kt */
    @DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1", f = "FlowExt.kt", l = {R.styleable.AppTheme_themeGradientOpacity, R.styleable.AppTheme_themeShadowOpacity}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ProduceStateScope<Object> $$this$produceState;
        public final /* synthetic */ CoroutineContext $context;
        public final /* synthetic */ Flow<Object> $this_collectAsStateWithLifecycle;
        public int label;

        /* compiled from: FlowExt.kt */
        @DebugMetadata(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$2", f = "FlowExt.kt", l = {R.styleable.AppTheme_toolbarActionTextStyle}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ProduceStateScope<Object> $$this$produceState;
            public final /* synthetic */ Flow<Object> $this_collectAsStateWithLifecycle;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Flow<Object> flow, ProduceStateScope<Object> produceStateScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_collectAsStateWithLifecycle = flow;
                this.$$this$produceState = produceStateScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_collectAsStateWithLifecycle, this.$$this$produceState, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    final ProduceStateScope<Object> produceStateScope = this.$$this$produceState;
                    FlowCollector<? super Object> flowCollector = new FlowCollector<Object>() { // from class: androidx.lifecycle.compose.FlowExtKt.collectAsStateWithLifecycle.1.1.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation<? super Unit> continuation) {
                            produceStateScope.setValue(obj2);
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (this.$this_collectAsStateWithLifecycle.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineContext coroutineContext, Flow<Object> flow, ProduceStateScope<Object> produceStateScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = coroutineContext;
            this.$this_collectAsStateWithLifecycle = flow;
            this.$$this$produceState = produceStateScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$this_collectAsStateWithLifecycle, this.$$this$produceState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 != 1 && r1 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                CoroutineContext coroutineContext = this.$context;
                boolean areEqual = Intrinsics.areEqual(coroutineContext, emptyCoroutineContext);
                final ProduceStateScope<Object> produceStateScope = this.$$this$produceState;
                Flow<Object> flow = this.$this_collectAsStateWithLifecycle;
                if (areEqual) {
                    FlowCollector<? super Object> flowCollector = new FlowCollector<Object>() { // from class: androidx.lifecycle.compose.FlowExtKt.collectAsStateWithLifecycle.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj2, Continuation<? super Unit> continuation) {
                            produceStateScope.setValue(obj2);
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (flow.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(flow, produceStateScope, null);
                    this.label = 2;
                    if (BuildersKt.withContext(coroutineContext, anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$collectAsStateWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, CoroutineContext coroutineContext, Flow<Object> flow, Continuation<? super FlowExtKt$collectAsStateWithLifecycle$1> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$context = coroutineContext;
        this.$this_collectAsStateWithLifecycle = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtKt$collectAsStateWithLifecycle$1 flowExtKt$collectAsStateWithLifecycle$1 = new FlowExtKt$collectAsStateWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$context, this.$this_collectAsStateWithLifecycle, continuation);
        flowExtKt$collectAsStateWithLifecycle$1.L$0 = obj;
        return flowExtKt$collectAsStateWithLifecycle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<Object> produceStateScope, Continuation<? super Unit> continuation) {
        return ((FlowExtKt$collectAsStateWithLifecycle$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$this_collectAsStateWithLifecycle, produceStateScope, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, this.$minActiveState, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
