package com.animaconnected.bluetooth.gatt;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GattAuthFailError.kt */
/* loaded from: classes.dex */
public final class GattAuthFailError extends Throwable {
    private final Exception e;

    public GattAuthFailError(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.e = e;
    }

    public final Exception getE() {
        return this.e;
    }
}
