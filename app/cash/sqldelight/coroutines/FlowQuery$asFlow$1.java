package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$asFlow$1", f = "FlowExtensions.kt", l = {47, 48}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FlowQuery$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Query<Object>>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Query<Object> $this_asFlow;
    public /* synthetic */ Object L$0;
    public Query.Listener L$1;
    public ChannelIterator L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$asFlow$1(Query<Object> query, Continuation<? super FlowQuery$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = query;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowQuery$asFlow$1 flowQuery$asFlow$1 = new FlowQuery$asFlow$1(this.$this_asFlow, continuation);
        flowQuery$asFlow$1.L$0 = obj;
        return flowQuery$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Query<Object>> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowQuery$asFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #1 {all -> 0x007d, blocks: (B:10:0x0052, B:14:0x0061, B:16:0x006b), top: B:9:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007a -> B:9:0x0052). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.L$2
            app.cash.sqldelight.Query$Listener r4 = r8.L$1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L85
            goto L51
        L18:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L20:
            kotlinx.coroutines.channels.ChannelIterator r1 = r8.L$2
            app.cash.sqldelight.Query$Listener r4 = r8.L$1
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L85
            r6 = r9
            r9 = r8
            goto L61
        L2e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r5 = r9
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r9 = 6
            r1 = 0
            r4 = -1
            kotlinx.coroutines.channels.BufferedChannel r9 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r4, r1, r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r9.mo1701trySendJP2dKIU(r1)
            app.cash.sqldelight.coroutines.FlowQuery$asFlow$1$$ExternalSyntheticLambda0 r4 = new app.cash.sqldelight.coroutines.FlowQuery$asFlow$1$$ExternalSyntheticLambda0
            r4.<init>()
            app.cash.sqldelight.Query<java.lang.Object> r1 = r8.$this_asFlow
            r1.addListener(r4)
            kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator r1 = new kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator     // Catch: java.lang.Throwable -> L85
            r1.<init>()     // Catch: java.lang.Throwable -> L85
        L51:
            r9 = r8
        L52:
            r9.L$0 = r5     // Catch: java.lang.Throwable -> L7d
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L7d
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L7d
            r9.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r6 = r1.hasNext(r9)     // Catch: java.lang.Throwable -> L7d
            if (r6 != r0) goto L61
            return r0
        L61:
            app.cash.sqldelight.Query<java.lang.Object> r7 = r9.$this_asFlow     // Catch: java.lang.Throwable -> L7d
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L7d
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L7d
            if (r6 == 0) goto L7f
            r1.next()     // Catch: java.lang.Throwable -> L7d
            r9.L$0 = r5     // Catch: java.lang.Throwable -> L7d
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L7d
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L7d
            r9.label = r2     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r6 = r5.emit(r7, r9)     // Catch: java.lang.Throwable -> L7d
            if (r6 != r0) goto L52
            return r0
        L7d:
            r0 = move-exception
            goto L88
        L7f:
            r7.removeListener(r4)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L85:
            r9 = move-exception
            r0 = r9
            r9 = r8
        L88:
            app.cash.sqldelight.Query<java.lang.Object> r9 = r9.$this_asFlow
            r9.removeListener(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
