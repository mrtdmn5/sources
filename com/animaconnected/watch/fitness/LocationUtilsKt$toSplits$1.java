package com.animaconnected.watch.fitness;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: LocationUtils.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.LocationUtilsKt$toSplits$1", f = "LocationUtils.kt", l = {219, 230}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LocationUtilsKt$toSplits$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Split>, Continuation<? super Unit>, Object> {
    final /* synthetic */ double $splitInMeters;
    final /* synthetic */ List<TimeDistance> $this_toSplits;
    double D$0;
    double D$1;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationUtilsKt$toSplits$1(List<TimeDistance> list, double d, Continuation<? super LocationUtilsKt$toSplits$1> continuation) {
        super(2, continuation);
        this.$this_toSplits = list;
        this.$splitInMeters = d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocationUtilsKt$toSplits$1 locationUtilsKt$toSplits$1 = new LocationUtilsKt$toSplits$1(this.$this_toSplits, this.$splitInMeters, continuation);
        locationUtilsKt$toSplits$1.L$0 = obj;
        return locationUtilsKt$toSplits$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b6 -> B:12:0x00c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0066 -> B:13:0x007e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.LocationUtilsKt$toSplits$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Split> sequenceScope, Continuation<? super Unit> continuation) {
        return ((LocationUtilsKt$toSplits$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
