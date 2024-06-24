package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WindowRecomposer.android.kt */
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {115, 121}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Uri $animationScaleUri;
    public final /* synthetic */ Context $applicationContext;
    public final /* synthetic */ Channel<Unit> $channel;
    public final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 $contentObserver;
    public final /* synthetic */ ContentResolver $resolver;
    public /* synthetic */ Object L$0;
    public ChannelIterator L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
        this.$channel = channel;
        this.$applicationContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0088, TRY_LEAVE, TryCatch #1 {all -> 0x0088, blocks: (B:16:0x0058, B:18:0x0060), top: B:15:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0083 -> B:9:0x0045). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlinx.coroutines.channels.ChannelIterator r1 = r9.L$1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L99
            goto L44
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlinx.coroutines.channels.ChannelIterator r1 = r9.L$1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L99
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L58
        L2c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r4 = r10
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            android.content.ContentResolver r10 = r9.$resolver
            android.net.Uri r1 = r9.$animationScaleUri
            r5 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r6 = r9.$contentObserver
            r10.registerContentObserver(r1, r5, r6)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r10 = r9.$channel     // Catch: java.lang.Throwable -> L99
            kotlinx.coroutines.channels.ChannelIterator r1 = r10.iterator()     // Catch: java.lang.Throwable -> L99
        L44:
            r10 = r9
        L45:
            r10.L$0 = r4     // Catch: java.lang.Throwable -> L94
            r10.L$1 = r1     // Catch: java.lang.Throwable -> L94
            r10.label = r3     // Catch: java.lang.Throwable -> L94
            java.lang.Object r5 = r1.hasNext(r10)     // Catch: java.lang.Throwable -> L94
            if (r5 != r0) goto L52
            return r0
        L52:
            r8 = r0
            r0 = r10
            r10 = r5
            r5 = r4
            r4 = r1
            r1 = r8
        L58:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L88
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L88
            if (r10 == 0) goto L8a
            r4.next()     // Catch: java.lang.Throwable -> L88
            android.content.Context r10 = r0.$applicationContext     // Catch: java.lang.Throwable -> L88
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L88
            java.lang.String r6 = "animator_duration_scale"
            r7 = 1065353216(0x3f800000, float:1.0)
            float r10 = android.provider.Settings.Global.getFloat(r10, r6, r7)     // Catch: java.lang.Throwable -> L88
            java.lang.Float r6 = new java.lang.Float     // Catch: java.lang.Throwable -> L88
            r6.<init>(r10)     // Catch: java.lang.Throwable -> L88
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L88
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L88
            r0.label = r2     // Catch: java.lang.Throwable -> L88
            java.lang.Object r10 = r5.emit(r6, r0)     // Catch: java.lang.Throwable -> L88
            if (r10 != r1) goto L83
            return r1
        L83:
            r10 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            goto L45
        L88:
            r10 = move-exception
            goto L9b
        L8a:
            android.content.ContentResolver r10 = r0.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r0 = r0.$contentObserver
            r10.unregisterContentObserver(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L94:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L9b
        L99:
            r10 = move-exception
            r0 = r9
        L9b:
            android.content.ContentResolver r1 = r0.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r0 = r0.$contentObserver
            r1.unregisterContentObserver(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
