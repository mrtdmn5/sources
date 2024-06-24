package com.animaconnected.watch.model;

import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HistoryDeviceId.kt */
/* loaded from: classes3.dex */
public final class HistoryDeviceIdColumnAdapter implements ColumnAdapter<HistoryDeviceId, String> {
    private final Function1<String, HistoryDeviceId> getHistoryDeviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public HistoryDeviceIdColumnAdapter(Function1<? super String, HistoryDeviceId> getHistoryDeviceId) {
        Intrinsics.checkNotNullParameter(getHistoryDeviceId, "getHistoryDeviceId");
        this.getHistoryDeviceId = getHistoryDeviceId;
    }

    @Override // app.cash.sqldelight.ColumnAdapter
    public /* bridge */ /* synthetic */ HistoryDeviceId decode(String str) {
        return HistoryDeviceId.m1556boximpl(m1565decode1z8L_Yw(str));
    }

    /* renamed from: decode-1z8L_Yw, reason: not valid java name */
    public String m1565decode1z8L_Yw(String databaseValue) {
        Intrinsics.checkNotNullParameter(databaseValue, "databaseValue");
        return HistoryDeviceId.m1557constructorimpl(databaseValue);
    }

    @Override // app.cash.sqldelight.ColumnAdapter
    public /* bridge */ /* synthetic */ String encode(HistoryDeviceId historyDeviceId) {
        return m1566encodeY1s2hH8(historyDeviceId.m1562unboximpl());
    }

    /* renamed from: encode-Y1s2hH8, reason: not valid java name */
    public String m1566encodeY1s2hH8(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!StringsKt__StringsJVMKt.startsWith(value, "A-", false)) {
            return this.getHistoryDeviceId.invoke(value).m1562unboximpl();
        }
        return value;
    }

    public final Function1<String, HistoryDeviceId> getGetHistoryDeviceId() {
        return this.getHistoryDeviceId;
    }
}
