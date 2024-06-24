package com.animaconnected.watch.provider.demo;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: DemoDataGenerator.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoDataGenerator$generate$1", f = "DemoDataGenerator.kt", l = {31, 37, 44, 48, 63, 80, 93, 94, 95}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoDataGenerator$generate$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Object>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DemoDataGenerator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoDataGenerator$generate$1(DemoDataGenerator demoDataGenerator, Continuation<? super DemoDataGenerator$generate$1> continuation) {
        super(2, continuation);
        this.this$0 = demoDataGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DemoDataGenerator$generate$1 demoDataGenerator$generate$1 = new DemoDataGenerator$generate$1(this.this$0, continuation);
        demoDataGenerator$generate$1.L$0 = obj;
        return demoDataGenerator$generate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Object> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<Object>) sequenceScope, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x019a, code lost:            r2 = r2 + r9;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x027e A[LOOP:0: B:22:0x027a->B:24:0x027e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x033d A[LOOP:3: B:49:0x0339->B:51:0x033d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0402 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x041d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0443 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019c  */
    /* JADX WARN: Type inference failed for: r0v23, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    /* JADX WARN: Type inference failed for: r0v33, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0444 -> B:7:0x0447). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0211 -> B:77:0x018a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoDataGenerator$generate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<Object> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DemoDataGenerator$generate$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
