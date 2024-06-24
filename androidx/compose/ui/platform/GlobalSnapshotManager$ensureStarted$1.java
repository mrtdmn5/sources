package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: GlobalSnapshotManager.android.kt */
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Channel<Unit> $channel;
    public ReceiveChannel L$0;
    public ChannelIterator L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:9:0x003b, B:11:0x0043, B:12:0x004b, B:19:0x0061, B:21:0x0064, B:32:0x006d, B:33:0x006e, B:14:0x004c, B:16:0x0058), top: B:8:0x003b, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0035 -> B:8:0x003b). Please report as a decompilation issue!!! */
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
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            kotlinx.coroutines.channels.ChannelIterator r1 = r7.L$1
            kotlinx.coroutines.channels.ReceiveChannel r3 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L78
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r7
            goto L3b
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r3 = r7.$channel
            kotlinx.coroutines.channels.ChannelIterator r8 = r3.iterator()     // Catch: java.lang.Throwable -> L78
            r1 = r8
            r8 = r7
        L28:
            r8.L$0 = r3     // Catch: java.lang.Throwable -> L78
            r8.L$1 = r1     // Catch: java.lang.Throwable -> L78
            r8.label = r2     // Catch: java.lang.Throwable -> L78
            java.lang.Object r4 = r1.hasNext(r8)     // Catch: java.lang.Throwable -> L78
            if (r4 != r0) goto L35
            return r0
        L35:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r6
        L3b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L76
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L6f
            java.lang.Object r8 = r3.next()     // Catch: java.lang.Throwable -> L76
            kotlin.Unit r8 = (kotlin.Unit) r8     // Catch: java.lang.Throwable -> L76
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotKt.lock     // Catch: java.lang.Throwable -> L76
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.atomic.AtomicReference<androidx.compose.runtime.snapshots.GlobalSnapshot> r5 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r5 = r5.get()     // Catch: java.lang.Throwable -> L6c
            androidx.compose.runtime.snapshots.GlobalSnapshot r5 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r5     // Catch: java.lang.Throwable -> L6c
            androidx.compose.runtime.collection.IdentityArraySet<androidx.compose.runtime.snapshots.StateObject> r5 = r5.modified     // Catch: java.lang.Throwable -> L6c
            if (r5 == 0) goto L60
            boolean r5 = r5.isNotEmpty()     // Catch: java.lang.Throwable -> L6c
            if (r5 != r2) goto L60
            r5 = r2
            goto L61
        L60:
            r5 = 0
        L61:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L76
            if (r5 == 0) goto L67
            androidx.compose.runtime.snapshots.SnapshotKt.access$advanceGlobalSnapshot()     // Catch: java.lang.Throwable -> L76
        L67:
            r8 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L28
        L6c:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L76
            throw r0     // Catch: java.lang.Throwable -> L76
        L6f:
            r8 = 0
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L76:
            r8 = move-exception
            goto L7a
        L78:
            r8 = move-exception
            r4 = r3
        L7a:
            throw r8     // Catch: java.lang.Throwable -> L7b
        L7b:
            r0 = move-exception
            androidx.compose.ui.draw.AlphaKt.cancelConsumed(r4, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
