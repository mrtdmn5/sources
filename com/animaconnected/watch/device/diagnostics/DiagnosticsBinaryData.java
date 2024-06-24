package com.animaconnected.watch.device.diagnostics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiagnosticsBaseItem.kt */
/* loaded from: classes3.dex */
public final class DiagnosticsBinaryData {
    private final byte[] data;
    private final String name;

    public DiagnosticsBinaryData(String name, byte[] data) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(data, "data");
        this.name = name;
        this.data = data;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getName() {
        return this.name;
    }
}
