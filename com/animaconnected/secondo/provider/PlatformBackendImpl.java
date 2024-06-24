package com.animaconnected.secondo.provider;

import android.content.Context;
import android.os.Build;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.watch.device.PlatformBackend;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformBackendImpl.kt */
/* loaded from: classes3.dex */
public final class PlatformBackendImpl implements PlatformBackend {
    public static final int $stable = 8;
    private final Context context;

    public PlatformBackendImpl(Context context) {
        this.context = context;
    }

    @Override // com.animaconnected.watch.device.PlatformBackend
    public String getAppVersion() {
        String version = AppUtils.getVersion(this.context);
        Intrinsics.checkNotNullExpressionValue(version, "getVersion(...)");
        return version;
    }

    @Override // com.animaconnected.watch.device.PlatformBackend
    public String getDeviceDescriptor() {
        return Build.MANUFACTURER + ' ' + Build.DEVICE + ' ' + Build.MODEL;
    }

    @Override // com.animaconnected.watch.device.PlatformBackend
    public boolean isDebug() {
        return false;
    }
}
