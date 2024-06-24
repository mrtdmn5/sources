package com.animaconnected.watch;

import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchProvider.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class WatchProvider$watchDatabase$1 extends FunctionReferenceImpl implements Function1<String, HistoryDeviceId> {
    public static final WatchProvider$watchDatabase$1 INSTANCE = new WatchProvider$watchDatabase$1();

    public WatchProvider$watchDatabase$1() {
        super(1, HistoryDeviceIdUtilsKt.class, "getHistoryDeviceId", "getHistoryDeviceId(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HistoryDeviceId invoke(String str) {
        return HistoryDeviceId.m1556boximpl(m1053invoke1z8L_Yw(str));
    }

    /* renamed from: invoke-1z8L_Yw, reason: not valid java name */
    public final String m1053invoke1z8L_Yw(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return HistoryDeviceIdUtilsKt.getHistoryDeviceId(p0);
    }
}
