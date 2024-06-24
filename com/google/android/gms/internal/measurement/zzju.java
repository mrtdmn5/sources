package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzju {
    public static final zzjt zza = new zzjt();
    public static final zzjs zzb;

    static {
        zzjs zzjsVar;
        try {
            zzjsVar = (zzjs) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjsVar = null;
        }
        zzb = zzjsVar;
    }
}
