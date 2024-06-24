package com.animaconnected.watch.fitness;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.device.WatchIODebug;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: CSEMLogs.kt */
/* loaded from: classes3.dex */
public final class CSEMLogs {
    private List<MsgPack> dataBuffer;
    private MutableSharedFlow<String> flow;
    private Job refreshJob;
    private final CoroutineScope scope;

    public CSEMLogs(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.dataBuffer = new ArrayList();
        this.flow = SharedFlowKt.MutableSharedFlow$default(0, 30, null, 4);
    }

    private final List<String> parseAccData(byte[] bArr) {
        ArrayList chunked = CollectionsKt___CollectionsKt.chunked(ArraysKt___ArraysJvmKt.asList(bArr), 2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked, 10));
        Iterator it = chunked.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(ByteUtils.decodeInt16LE$default(CollectionsKt___CollectionsKt.toByteArray((List) it.next()), 0, 1, null)));
        }
        return CollectionsKt___CollectionsKt.chunked(arrayList, 3, new Function1<List<? extends Short>, String>() { // from class: com.animaconnected.watch.fitness.CSEMLogs$parseAccData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(List<? extends Short> list) {
                return invoke2((List<Short>) list);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(List<Short> it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return CollectionsKt___CollectionsKt.joinToString$default(it2, null, null, null, null, 63);
            }
        });
    }

    private final String parseData(List<? extends MsgPack> list) {
        return CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, new Function1<MsgPack, CharSequence>() { // from class: com.animaconnected.watch.fitness.CSEMLogs$parseData$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MsgPack it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 31);
    }

    public final CommonFlow<String> data() {
        return FlowExtensionsKt.asCommonFlow(this.flow);
    }

    public final Object disable(WatchIODebug watchIODebug, Continuation<? super Unit> continuation) {
        Job job = this.refreshJob;
        if (job != null) {
            job.cancel(null);
        }
        this.refreshJob = null;
        Object enableCSEMLogs = watchIODebug.enableCSEMLogs(false, continuation);
        if (enableCSEMLogs == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return enableCSEMLogs;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enable(com.animaconnected.watch.device.WatchIODebug r8, kotlin.coroutines.Continuation<? super java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.fitness.CSEMLogs$enable$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.fitness.CSEMLogs$enable$1 r0 = (com.animaconnected.watch.fitness.CSEMLogs$enable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.CSEMLogs$enable$1 r0 = new com.animaconnected.watch.fitness.CSEMLogs$enable$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r8 = r0.L$1
            com.animaconnected.watch.device.WatchIODebug r8 = (com.animaconnected.watch.device.WatchIODebug) r8
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.fitness.CSEMLogs r0 = (com.animaconnected.watch.fitness.CSEMLogs) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L48
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r8.readCSEMLogsHeaders(r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            r0 = r7
        L48:
            r1 = r9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            r3 = 0
            r4 = 0
            com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1 r5 = new kotlin.jvm.functions.Function1<java.lang.String, java.lang.CharSequence>() { // from class: com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1
                static {
                    /*
                        com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1 r0 = new com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1) com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1.INSTANCE com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.CharSequence invoke(java.lang.String r1) {
                    /*
                        r0 = this;
                        java.lang.String r1 = (java.lang.String) r1
                        java.lang.CharSequence r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.CharSequence invoke(java.lang.String r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        java.lang.String r0 = "acc_buff"
                        boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
                        if (r0 == 0) goto Lf
                        java.lang.String r2 = "acc_buff_x, acc_buff_y, acc_buff_z"
                    Lf:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs$enable$headers$1.invoke(java.lang.String):java.lang.CharSequence");
                }
            }
            r6 = 31
            java.lang.String r9 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6)
            kotlinx.coroutines.Job r1 = r0.refreshJob
            if (r1 == 0) goto L5d
            java.lang.String r8 = ""
            return r8
        L5d:
            kotlinx.coroutines.CoroutineScope r1 = r0.scope
            com.animaconnected.watch.fitness.CSEMLogs$enable$2 r2 = new com.animaconnected.watch.fitness.CSEMLogs$enable$2
            r3 = 0
            r2.<init>(r8, r3)
            r8 = 3
            kotlinx.coroutines.StandaloneCoroutine r8 = kotlinx.coroutines.BuildersKt.launch$default(r1, r3, r3, r2, r8)
            r0.refreshJob = r8
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs.enable(com.animaconnected.watch.device.WatchIODebug, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0117 A[LOOP:1: B:22:0x0111->B:24:0x0117, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handle(final com.animaconnected.msgpack.MsgPack r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.CSEMLogs.handle(com.animaconnected.msgpack.MsgPack, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
