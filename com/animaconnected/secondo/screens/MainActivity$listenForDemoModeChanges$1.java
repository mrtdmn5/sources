package com.animaconnected.secondo.screens;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.provider.demo.DemoMode;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MainActivity$listenForDemoModeChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DemoModeProvider $demoModeProvider;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* compiled from: MainActivity.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$1", f = "MainActivity.kt", l = {414}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DemoModeProvider $demoModeProvider;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DemoModeProvider demoModeProvider, MainActivity mainActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$demoModeProvider = demoModeProvider;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$demoModeProvider, this.this$0, continuation);
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
                CommonFlow<Boolean> isEnabledFlow = this.$demoModeProvider.isEnabledFlow();
                final MainActivity mainActivity = this.this$0;
                FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.MainActivity.listenForDemoModeChanges.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        MainActivity.this.setDemoModeButtonEnabled(z);
                        MainActivity.this.reportTouchEventToDemoProvider = z;
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (isEnabledFlow.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: MainActivity.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2", f = "MainActivity.kt", l = {424}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DemoModeProvider $demoModeProvider;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* compiled from: MainActivity.kt */
        @DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$2", f = "MainActivity.kt", l = {429}, m = "invokeSuspend")
        /* renamed from: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$2, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00432 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            Object L$0;
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00432(MainActivity mainActivity, Continuation<? super C00432> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00432 c00432 = new C00432(this.this$0, continuation);
                c00432.Z$0 = ((Boolean) obj).booleanValue();
                return c00432;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 == r2) goto L11
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L11:
                    java.lang.Object r0 = r4.L$0
                    com.animaconnected.secondo.screens.BottomDialog r0 = (com.animaconnected.secondo.screens.BottomDialog) r0
                    kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L19
                    goto L35
                L19:
                    r5 = move-exception
                    goto L3f
                L1b:
                    kotlin.ResultKt.throwOnFailure(r5)
                    boolean r5 = r4.Z$0
                    if (r5 == 0) goto L45
                    r5 = 0
                    com.animaconnected.secondo.screens.MainActivity r1 = r4.this$0     // Catch: java.lang.Throwable -> L3b
                    com.animaconnected.secondo.screens.BottomDialog r5 = com.animaconnected.secondo.screens.demo.DemoModeProgressBottomDialogKt.showDemoModeProgressBottomDialog(r1)     // Catch: java.lang.Throwable -> L3b
                    r4.L$0 = r5     // Catch: java.lang.Throwable -> L3b
                    r4.label = r2     // Catch: java.lang.Throwable -> L3b
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlinx.coroutines.DelayKt.awaitCancellation(r4)     // Catch: java.lang.Throwable -> L3b
                    if (r1 != r0) goto L34
                    return r0
                L34:
                    r0 = r5
                L35:
                    kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L19
                    r5.<init>()     // Catch: java.lang.Throwable -> L19
                    throw r5     // Catch: java.lang.Throwable -> L19
                L3b:
                    r0 = move-exception
                    r3 = r0
                    r0 = r5
                    r5 = r3
                L3f:
                    if (r0 == 0) goto L44
                    r0.dismiss()
                L44:
                    throw r5
                L45:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1.AnonymousClass2.C00432.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                return ((C00432) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DemoModeProvider demoModeProvider, MainActivity mainActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$demoModeProvider = demoModeProvider;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$demoModeProvider, this.this$0, continuation);
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
                final SharedFlow<DemoMode> demoMode = this.$demoModeProvider.getDemoMode();
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    /* renamed from: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2", f = "MainActivity.kt", l = {223}, m = "emit")
                        /* renamed from: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes3.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L2f
                                if (r2 != r3) goto L27
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L45
                            L27:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L2f:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                com.animaconnected.watch.provider.demo.DemoMode r5 = (com.animaconnected.watch.provider.demo.DemoMode) r5
                                boolean r5 = r5 instanceof com.animaconnected.watch.provider.demo.DemoMode.Enabled.Processing
                                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity$listenForDemoModeChanges$1$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }
                });
                C00432 c00432 = new C00432(this.this$0, null);
                this.label = 1;
                if (FlowKt.collectLatest(distinctUntilChanged, c00432, this) == coroutineSingletons) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$listenForDemoModeChanges$1(DemoModeProvider demoModeProvider, MainActivity mainActivity, Continuation<? super MainActivity$listenForDemoModeChanges$1> continuation) {
        super(2, continuation);
        this.$demoModeProvider = demoModeProvider;
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivity$listenForDemoModeChanges$1 mainActivity$listenForDemoModeChanges$1 = new MainActivity$listenForDemoModeChanges$1(this.$demoModeProvider, this.this$0, continuation);
        mainActivity$listenForDemoModeChanges$1.L$0 = obj;
        return mainActivity$listenForDemoModeChanges$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$demoModeProvider, this.this$0, null), 3);
            BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$demoModeProvider, this.this$0, null), 3);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$listenForDemoModeChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
