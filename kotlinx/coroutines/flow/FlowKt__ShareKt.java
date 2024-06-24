package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.SharingStarted;

/* compiled from: Share.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ShareKt {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:            if (r5 == 0) goto L49;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> kotlinx.coroutines.flow.SharingConfig<T> configureSharing$FlowKt__ShareKt(kotlinx.coroutines.flow.Flow<? extends T> r6, int r7) {
        /*
            kotlinx.coroutines.channels.Channel$Factory r0 = kotlinx.coroutines.channels.Channel.Factory
            r0.getClass()
            int r0 = kotlinx.coroutines.channels.Channel.Factory.CHANNEL_DEFAULT_CAPACITY
            if (r7 >= r0) goto La
            goto Lb
        La:
            r0 = r7
        Lb:
            int r0 = r0 - r7
            boolean r1 = r6 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3b
            r1 = r6
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.Flow r2 = r1.dropChannelOperators()
            if (r2 == 0) goto L3b
            kotlinx.coroutines.flow.SharingConfig r6 = new kotlinx.coroutines.flow.SharingConfig
            r3 = -3
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.onBufferOverflow
            int r5 = r1.capacity
            if (r5 == r3) goto L29
            r3 = -2
            if (r5 == r3) goto L29
            if (r5 == 0) goto L29
            r0 = r5
            goto L35
        L29:
            kotlinx.coroutines.channels.BufferOverflow r3 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 != r3) goto L30
            if (r5 != 0) goto L35
            goto L34
        L30:
            if (r7 != 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            kotlin.coroutines.CoroutineContext r7 = r1.context
            r6.<init>(r0, r7, r4, r2)
            return r6
        L3b:
            kotlinx.coroutines.flow.SharingConfig r7 = new kotlinx.coroutines.flow.SharingConfig
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r7.<init>(r0, r2, r1, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(kotlinx.coroutines.flow.Flow, int):kotlinx.coroutines.flow.SharingConfig");
    }

    public static final StandaloneCoroutine launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow flow, MutableSharedFlow mutableSharedFlow, StartedWhileSubscribed startedWhileSubscribed, Object obj) {
        CoroutineStart coroutineStart;
        StandaloneCoroutine standaloneCoroutine;
        if (Intrinsics.areEqual(startedWhileSubscribed, SharingStarted.Companion.Eagerly)) {
            coroutineStart = CoroutineStart.DEFAULT;
        } else {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(startedWhileSubscribed, flow, mutableSharedFlow, obj, null);
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            standaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, flowKt__ShareKt$launchSharing$1);
        } else {
            standaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        coroutineStart.invoke(flowKt__ShareKt$launchSharing$1, standaloneCoroutine, standaloneCoroutine);
        return standaloneCoroutine;
    }
}
