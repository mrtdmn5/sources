package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WindowRecomposer.android.kt */
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {394}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Recomposer $recomposer;
    public final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 $self;
    public final /* synthetic */ LifecycleOwner $source;
    public final /* synthetic */ Ref$ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    public final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref$ObjectRef<MotionDurationScaleImpl> ref$ObjectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = ref$ObjectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r2 = r10.$self
            androidx.lifecycle.LifecycleOwner r3 = r10.$source
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L22
            if (r1 != r4) goto L1a
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L17
            goto L8e
        L17:
            r11 = move-exception
            goto La4
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r1 = r10.$systemDurationScaleSettingConsumer     // Catch: java.lang.Throwable -> La2
            T r1 = r1.element     // Catch: java.lang.Throwable -> La2
            androidx.compose.ui.platform.MotionDurationScaleImpl r1 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r1     // Catch: java.lang.Throwable -> La2
            if (r1 == 0) goto L5e
            android.view.View r6 = r10.$this_createLifecycleAwareWindowRecomposer     // Catch: java.lang.Throwable -> La2
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> La2
            android.content.Context r6 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> La2
            java.lang.String r7 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: java.lang.Throwable -> La2
            kotlinx.coroutines.flow.StateFlow r6 = androidx.compose.ui.platform.WindowRecomposer_androidKt.access$getAnimationScaleFlowFor(r6)     // Catch: java.lang.Throwable -> La2
            java.lang.Object r7 = r6.getValue()     // Catch: java.lang.Throwable -> La2
            java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> La2
            float r7 = r7.floatValue()     // Catch: java.lang.Throwable -> La2
            androidx.compose.runtime.ParcelableSnapshotMutableFloatState r8 = r1.scaleFactor$delegate     // Catch: java.lang.Throwable -> La2
            r8.setFloatValue(r7)     // Catch: java.lang.Throwable -> La2
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r7 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch: java.lang.Throwable -> La2
            r7.<init>(r6, r1, r5)     // Catch: java.lang.Throwable -> La2
            r1 = 3
            kotlinx.coroutines.StandaloneCoroutine r11 = kotlinx.coroutines.BuildersKt.launch$default(r11, r5, r5, r7, r1)     // Catch: java.lang.Throwable -> La2
            goto L5f
        L5e:
            r11 = r5
        L5f:
            androidx.compose.runtime.Recomposer r1 = r10.$recomposer     // Catch: java.lang.Throwable -> L9d
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L9d
            r10.label = r4     // Catch: java.lang.Throwable -> L9d
            r1.getClass()     // Catch: java.lang.Throwable -> L9d
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2 r4 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2     // Catch: java.lang.Throwable -> L9d
            r4.<init>(r1, r5)     // Catch: java.lang.Throwable -> L9d
            kotlin.coroutines.CoroutineContext r6 = r10.getContext()     // Catch: java.lang.Throwable -> L9d
            androidx.compose.runtime.MonotonicFrameClock r6 = androidx.compose.runtime.MonotonicFrameClockKt.getMonotonicFrameClock(r6)     // Catch: java.lang.Throwable -> L9d
            androidx.compose.runtime.Recomposer$recompositionRunner$2 r7 = new androidx.compose.runtime.Recomposer$recompositionRunner$2     // Catch: java.lang.Throwable -> L9d
            r7.<init>(r1, r4, r6, r5)     // Catch: java.lang.Throwable -> L9d
            androidx.compose.runtime.BroadcastFrameClock r1 = r1.broadcastFrameClock     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r7, r10)     // Catch: java.lang.Throwable -> L9d
            if (r1 != r0) goto L83
            goto L85
        L83:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9d
        L85:
            if (r1 != r0) goto L88
            goto L8a
        L88:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L9d
        L8a:
            if (r1 != r0) goto L8d
            return r0
        L8d:
            r0 = r11
        L8e:
            if (r0 == 0) goto L93
            r0.cancel(r5)
        L93:
            androidx.lifecycle.Lifecycle r11 = r3.getLifecycle()
            r11.removeObserver(r2)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L9d:
            r0 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto La4
        La2:
            r11 = move-exception
            r0 = r5
        La4:
            if (r0 == 0) goto La9
            r0.cancel(r5)
        La9:
            androidx.lifecycle.Lifecycle r0 = r3.getLifecycle()
            r0.removeObserver(r2)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
