package com.animaconnected.secondo.screens.debugtesting;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseTestingPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onDepleteBatteriesClicked$2", f = "BaseTestingPresenter.kt", l = {47, 48}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseTestingPresenter$onDepleteBatteriesClicked$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleCoroutineScope $lifecycleScope;
    int label;
    final /* synthetic */ BaseTestingPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTestingPresenter$onDepleteBatteriesClicked$2(BaseTestingPresenter baseTestingPresenter, LifecycleCoroutineScope lifecycleCoroutineScope, Continuation<? super BaseTestingPresenter$onDepleteBatteriesClicked$2> continuation) {
        super(2, continuation);
        this.this$0 = baseTestingPresenter;
        this.$lifecycleScope = lifecycleCoroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseTestingPresenter$onDepleteBatteriesClicked$2(this.this$0, this.$lifecycleScope, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(1:2)|(1:(1:(1:6)(2:24|25))(9:26|27|15|(1:17)|8|9|(7:11|(1:13)|15|(0)|8|9|(0))|18|19))(2:28|29)|7|8|9|(0)|18|19|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:            r0 = r8;        r8 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:            r0 = r0.this$0.view;        r0.setVibratorStatus("Depleting batteries failed: " + r8.getLocalizedMessage());     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: Exception -> 0x0051, TryCatch #1 {Exception -> 0x0051, blocks: (B:9:0x002f, B:11:0x0037, B:15:0x0046), top: B:8:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:8:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L1d
            goto L2e
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L18:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L1d
            r8 = r7
            goto L46
        L1d:
            r8 = move-exception
            r0 = r7
            goto L55
        L20:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter r8 = r7.this$0     // Catch: java.lang.Exception -> L1d
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r8 = com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.access$getView$p(r8)     // Catch: java.lang.Exception -> L1d
            java.lang.String r1 = "Depleting batteries. Click to stop"
            r8.setVibratorStatus(r1)     // Catch: java.lang.Exception -> L1d
        L2e:
            r8 = r7
        L2f:
            androidx.lifecycle.LifecycleCoroutineScope r1 = r8.$lifecycleScope     // Catch: java.lang.Exception -> L51
            boolean r1 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)     // Catch: java.lang.Exception -> L51
            if (r1 == 0) goto L70
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter r1 = r8.this$0     // Catch: java.lang.Exception -> L51
            com.animaconnected.watch.device.WatchIODebug r1 = r1.getDebugFunctions()     // Catch: java.lang.Exception -> L51
            r8.label = r3     // Catch: java.lang.Exception -> L51
            java.lang.Object r1 = r1.writeStartVibratorWithBuiltinTestPattern(r8)     // Catch: java.lang.Exception -> L51
            if (r1 != r0) goto L46
            return r0
        L46:
            r8.label = r2     // Catch: java.lang.Exception -> L51
            r4 = 100
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r8)     // Catch: java.lang.Exception -> L51
            if (r1 != r0) goto L2f
            return r0
        L51:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L55:
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter r0 = r0.this$0
            com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$BaseTestingView r0 = com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter.access$getView$p(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Depleting batteries failed: "
            r1.<init>(r2)
            java.lang.String r8 = r8.getLocalizedMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.setVibratorStatus(r8)
        L70:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter$onDepleteBatteriesClicked$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseTestingPresenter$onDepleteBatteriesClicked$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
