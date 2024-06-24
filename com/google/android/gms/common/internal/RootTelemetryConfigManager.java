package com.google.android.gms.common.internal;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class RootTelemetryConfigManager {
    public static RootTelemetryConfigManager zza;
    public static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, 0, 0, false, false);
    public RootTelemetryConfiguration zzc;

    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            if (zza == null) {
                zza = new RootTelemetryConfigManager();
            }
            rootTelemetryConfigManager = zza;
        }
        return rootTelemetryConfigManager;
    }
}
