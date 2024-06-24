package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugFitnessMainFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DebugFitnessMainFragment$importDatabase$2 extends FunctionReferenceImpl implements Function1<String, HistoryDeviceId> {
    public static final DebugFitnessMainFragment$importDatabase$2 INSTANCE = new DebugFitnessMainFragment$importDatabase$2();

    public DebugFitnessMainFragment$importDatabase$2() {
        super(1, HistoryDeviceIdUtilsKt.class, "getHistoryDeviceId", "getHistoryDeviceId(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HistoryDeviceId invoke(String str) {
        return HistoryDeviceId.m1556boximpl(m886invoke1z8L_Yw(str));
    }

    /* renamed from: invoke-1z8L_Yw, reason: not valid java name */
    public final String m886invoke1z8L_Yw(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return HistoryDeviceIdUtilsKt.getHistoryDeviceId(p0);
    }
}
