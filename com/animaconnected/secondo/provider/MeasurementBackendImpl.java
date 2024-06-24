package com.animaconnected.secondo.provider;

import com.animaconnected.logger.MeasurementBackend;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasurementBackend.kt */
/* loaded from: classes3.dex */
public final class MeasurementBackendImpl implements MeasurementBackend {
    public static final int $stable = 0;

    @Override // com.animaconnected.logger.MeasurementBackend
    public String begin(String tag, String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return "";
    }

    @Override // com.animaconnected.logger.MeasurementBackend
    public void end(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
    }
}
