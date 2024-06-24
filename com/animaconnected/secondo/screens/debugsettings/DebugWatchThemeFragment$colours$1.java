package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.watch.image.Kolor;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: DebugWatchThemeFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$colours$1", f = "DebugWatchThemeFragment.kt", l = {66}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugWatchThemeFragment$colours$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Kolor>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public DebugWatchThemeFragment$colours$1(Continuation<? super DebugWatchThemeFragment$colours$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugWatchThemeFragment$colours$1 debugWatchThemeFragment$colours$1 = new DebugWatchThemeFragment$colours$1(continuation);
        debugWatchThemeFragment$colours$1.L$0 = obj;
        return debugWatchThemeFragment$colours$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004b -> B:12:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0061 -> B:5:0x007d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 3
            r5 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r2 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$3
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$0
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.ResultKt.throwOnFailure(r23)
            r11 = r8
            r8 = r0
            r20 = r9
            r9 = r6
            r6 = r20
            goto L7d
        L2c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L34:
            kotlin.ResultKt.throwOnFailure(r23)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ranges.IntRange r6 = new kotlin.ranges.IntRange
            r6.<init>(r5, r4)
            kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
            r7 = r0
        L45:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto Lba
            r8 = r6
            kotlin.collections.IntIterator r8 = (kotlin.collections.IntIterator) r8
            int r8 = r8.nextInt()
            kotlin.ranges.IntRange r9 = new kotlin.ranges.IntRange
            r9.<init>(r5, r4)
            kotlin.ranges.IntProgressionIterator r9 = r9.iterator()
        L5b:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L45
            r10 = r9
            kotlin.collections.IntIterator r10 = (kotlin.collections.IntIterator) r10
            int r10 = r10.nextInt()
            kotlin.ranges.IntRange r11 = new kotlin.ranges.IntRange
            r11.<init>(r5, r4)
            kotlin.ranges.IntProgressionIterator r11 = r11.iterator()
            r20 = r10
            r10 = r2
            r2 = r20
            r21 = r8
            r8 = r7
            r7 = r11
            r11 = r9
            r9 = r21
        L7d:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto Lb5
            r12 = r7
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12
            int r12 = r12.nextInt()
            com.animaconnected.watch.image.Kolor$Companion r13 = com.animaconnected.watch.image.Kolor.Companion
            int r14 = r9 * 64
            int r15 = r2 * 64
            int r16 = r12 * 64
            r17 = 0
            r18 = 8
            r19 = 0
            int r12 = com.animaconnected.watch.image.Kolor.Companion.m1547fromArgbpWQ4cJ4$default(r13, r14, r15, r16, r17, r18, r19)
            com.animaconnected.watch.image.Kolor r12 = com.animaconnected.watch.image.Kolor.m1536boximpl(r12)
            r8.L$0 = r10
            r8.L$1 = r6
            r8.L$2 = r11
            r8.L$3 = r7
            r8.I$0 = r9
            r8.I$1 = r2
            r8.label = r3
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = r10.yield(r12, r8)
            if (r12 != r1) goto L7d
            return r1
        Lb5:
            r7 = r8
            r8 = r9
            r2 = r10
            r9 = r11
            goto L5b
        Lba:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$colours$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Kolor> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DebugWatchThemeFragment$colours$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
