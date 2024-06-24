package com.animaconnected.watch.provider.demo;

import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* compiled from: DemoModeProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1", f = "DemoModeProvider.kt", l = {340, 125, R.styleable.AppTheme_stepsHistoryFontActivity, R.styleable.AppTheme_stepsHistoryHintColorActivity, R.styleable.AppTheme_stepsHistoryNoDataBackgroundActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoModeProvider$startJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DemoModeProvider this$0;

    /* compiled from: DemoModeProvider.kt */
    @DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$4", f = "DemoModeProvider.kt", l = {R.styleable.AppTheme_stepsHistoryHintColorActivity}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DemoModeProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DemoModeProvider demoModeProvider, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = demoModeProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Channel channel;
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
                channel = this.this$0.notifyRequest;
                this.label = 1;
                if (channel.receive(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoModeProvider$startJob$1(DemoModeProvider demoModeProvider, Continuation<? super DemoModeProvider$startJob$1> continuation) {
        super(2, continuation);
        this.this$0 = demoModeProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object invokeSuspend$initializeDemoMode(kotlinx.coroutines.CoroutineScope r11, com.animaconnected.watch.provider.demo.DemoModeProvider r12, kotlin.coroutines.Continuation<? super com.animaconnected.watch.provider.demo.DemoMode.Enabled> r13) {
        /*
            boolean r0 = r13 instanceof com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$1 r0 = (com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$1 r0 = new com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r11 = r0.L$0
            r12 = r11
            com.animaconnected.watch.provider.demo.DemoModeProvider r12 = (com.animaconnected.watch.provider.demo.DemoModeProvider) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L66
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r5 = "DemoModeProvider"
            r6 = 0
            r7 = 0
            com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2
                static {
                    /*
                        com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2 r0 = new com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2) com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2.INSTANCE com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Initializing demo mode"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1$initializeDemoMode$2.invoke():java.lang.Object");
                }
            }
            r9 = 6
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
            com.animaconnected.firebase.Analytics r11 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getAnalytics$p(r12)
            com.animaconnected.watch.provider.demo.DemoModeProvider.access$setAppModeUserProperty(r12, r11, r3)
            com.animaconnected.firebase.Analytics r11 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getAnalytics$p(r12)
            com.animaconnected.firebase.AppEvents r11 = r11.getAppEvents()
            java.lang.String r13 = "demo_mode_enabled"
            r11.sendAction(r13)
            com.animaconnected.watch.fitness.FitnessProvider r11 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getFitnessProvider$p(r12)
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r11 = r11.clearLocalFitnessData(r0)
            if (r11 != r1) goto L66
            return r1
        L66:
            com.animaconnected.watch.storage.WatchDb r11 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getWatchDb$p(r12)
            com.animaconnected.watch.WatchDatabase r11 = r11.getDb()
            com.animaconnected.watch.fitness.FitnessQueries r11 = r11.getFitnessQueries()
            r11.clearProfile()
            com.animaconnected.watch.storage.WatchDb r11 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getWatchDb$p(r12)
            com.animaconnected.watch.WatchDatabase r11 = r11.getDb()
            com.animaconnected.watch.fitness.FitnessQueries r11 = r11.getFitnessQueries()
            com.animaconnected.watch.provider.demo.DemoModeProvider.access$deleteAllFitnessData(r12, r11)
            com.animaconnected.watch.provider.demo.DemoModeProvider.access$setHealthOnboardingDone(r12)
            com.animaconnected.watch.provider.demo.DemoModeProvider.access$setResetAllRequested$p(r12, r3)
            com.animaconnected.watch.provider.demo.DemoMode$Enabled$Idle r11 = new com.animaconnected.watch.provider.demo.DemoMode$Enabled$Idle
            com.animaconnected.watch.provider.demo.WatchDemoMode r13 = com.animaconnected.watch.provider.demo.WatchDemoMode.Retail
            r11.<init>(r13)
            kotlinx.coroutines.flow.MutableStateFlow r13 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$get_demoMode$p(r12)
            r13.setValue(r11)
            com.animaconnected.watch.provider.demo.DemoModeStorage r12 = com.animaconnected.watch.provider.demo.DemoModeProvider.access$getStorage$p(r12)
            com.animaconnected.watch.provider.demo.WatchDemoMode r13 = r11.getWatchDemoMode()
            r12.setWatchDemoMode(r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1.invokeSuspend$initializeDemoMode(kotlinx.coroutines.CoroutineScope, com.animaconnected.watch.provider.demo.DemoModeProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DemoModeProvider$startJob$1 demoModeProvider$startJob$1 = new DemoModeProvider$startJob$1(this.this$0, continuation);
        demoModeProvider$startJob$1.L$0 = obj;
        return demoModeProvider$startJob$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x012b, code lost:            if (r10 != false) goto L52;     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01ed -> B:15:0x00e0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DemoModeProvider$startJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
