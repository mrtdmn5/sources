package com.animaconnected.watch;

import app.cash.sqldelight.Query;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "com.animaconnected.watch.FlowExtensionsKt$dynamicQueryAsFlow$1", f = "FlowExtensions.kt", l = {80, 83}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowExtensionsKt$dynamicQueryAsFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $fromTs;
    final /* synthetic */ Function1<Long, Query<T>> $query;
    final /* synthetic */ Function1<T, Long> $timestampFrom;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$dynamicQueryAsFlow$1(long j, Function1<? super Long, ? extends Query<? extends T>> function1, Function1<? super T, Long> function12, Continuation<? super FlowExtensionsKt$dynamicQueryAsFlow$1> continuation) {
        super(2, continuation);
        this.$fromTs = j;
        this.$query = function1;
        this.$timestampFrom = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(Channel channel) {
        channel.mo1701trySendJP2dKIU(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtensionsKt$dynamicQueryAsFlow$1 flowExtensionsKt$dynamicQueryAsFlow$1 = new FlowExtensionsKt$dynamicQueryAsFlow$1(this.$fromTs, this.$query, this.$timestampFrom, continuation);
        flowExtensionsKt$dynamicQueryAsFlow$1.L$0 = obj;
        return flowExtensionsKt$dynamicQueryAsFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00de A[Catch: all -> 0x0114, TryCatch #0 {all -> 0x0114, blocks: (B:11:0x00d8, B:13:0x00de, B:20:0x00f9, B:22:0x00ff), top: B:10:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4 A[Catch: all -> 0x011c, TRY_LEAVE, TryCatch #1 {all -> 0x011c, blocks: (B:7:0x0029, B:24:0x0092, B:28:0x00ac, B:30:0x00b4, B:42:0x0051, B:45:0x008c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0116  */
    /* JADX WARN: Type inference failed for: r1v13, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Type inference failed for: r6v14, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:9:0x00d8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.FlowExtensionsKt$dynamicQueryAsFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$dynamicQueryAsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
