package com.animaconnected.secondo.screens.debugsettings;

import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.CurrentSessionData;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DebugFitnessMainFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1", f = "DebugFitnessMainFragment.kt", l = {59}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugFitnessMainFragment this$0;

    /* compiled from: DebugFitnessMainFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1", f = "DebugFitnessMainFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DebugFitnessMainFragment this$0;

        /* compiled from: DebugFitnessMainFragment.kt */
        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$1", f = "DebugFitnessMainFragment.kt", l = {62}, m = "invokeSuspend")
        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DebugFitnessMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00471(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super C00471> continuation) {
                super(2, continuation);
                this.this$0 = debugFitnessMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00471(this.this$0, continuation);
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
                    CommonFlow<CurrentSessionData> debugFitnessDataFlow = fitnessProvider.debugFitnessDataFlow();
                    final DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                    FlowCollector<? super CurrentSessionData> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment.onCreate.1.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((CurrentSessionData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(CurrentSessionData currentSessionData, Continuation<? super Unit> continuation) {
                            TextView textView;
                            textView = DebugFitnessMainFragment.this.fitnessState;
                            if (textView != null) {
                                textView.setText("SessionData: " + currentSessionData);
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("fitnessState");
                            throw null;
                        }
                    };
                    this.label = 1;
                    if (debugFitnessDataFlow.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* compiled from: DebugFitnessMainFragment.kt */
        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$2", f = "DebugFitnessMainFragment.kt", l = {69}, m = "invokeSuspend")
        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DebugFitnessMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = debugFitnessMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
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
                    CommonFlow<List<Session>> sessionsOverview = fitnessProvider.getSessionsOverview(TimePeriod.Companion.none());
                    final DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                    FlowCollector<? super List<Session>> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment.onCreate.1.1.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<Session>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<Session> list, Continuation<? super Unit> continuation) {
                            TextView textView;
                            Session session = (Session) CollectionsKt___CollectionsKt.firstOrNull((List) list);
                            if (session == null) {
                                return Unit.INSTANCE;
                            }
                            textView = DebugFitnessMainFragment.this.lastSessionText;
                            if (textView != null) {
                                textView.setText(String.valueOf(session));
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("lastSessionText");
                            throw null;
                        }
                    };
                    this.label = 1;
                    if (sessionsOverview.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* compiled from: DebugFitnessMainFragment.kt */
        @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$3", f = "DebugFitnessMainFragment.kt", l = {77}, m = "invokeSuspend")
        /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment$onCreate$1$1$3, reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DebugFitnessMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = debugFitnessMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
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
                    CommonFlow<HeartrateMetricItem> heartrateLiveData = fitnessProvider.getHeartrateLiveData();
                    final DebugFitnessMainFragment debugFitnessMainFragment = this.this$0;
                    FlowCollector<? super HeartrateMetricItem> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugFitnessMainFragment.onCreate.1.1.3.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((HeartrateMetricItem) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(HeartrateMetricItem heartrateMetricItem, Continuation<? super Unit> continuation) {
                            TextView textView;
                            textView = DebugFitnessMainFragment.this.liveData;
                            if (textView != null) {
                                textView.setText("Heartrate: " + heartrateMetricItem.getHeartrateValue().getHeartrate() + ", Confidence: " + heartrateMetricItem.getHeartrateValue().getConfidence());
                                return Unit.INSTANCE;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("liveData");
                            throw null;
                        }
                    };
                    this.label = 1;
                    if (heartrateLiveData.collect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = debugFitnessMainFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt.launch$default(coroutineScope, null, null, new C00471(this.this$0, null), 3);
                BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, null), 3);
                BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass3(this.this$0, null), 3);
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
    public DebugFitnessMainFragment$onCreate$1(DebugFitnessMainFragment debugFitnessMainFragment, Continuation<? super DebugFitnessMainFragment$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = debugFitnessMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugFitnessMainFragment$onCreate$1(this.this$0, continuation);
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
            Lifecycle lifecycle = this.this$0.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugFitnessMainFragment$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
