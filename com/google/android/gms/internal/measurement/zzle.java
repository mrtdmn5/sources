package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzle {
    public static final zzlc zza = new zzlc();
    public final zzld zzb;

    public zzle() {
        zzlk zzlkVar;
        zzlk[] zzlkVarArr = new zzlk[2];
        zzlkVarArr[0] = zzka.zza;
        try {
            zzlkVar = (zzlk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzlkVar = zza;
        }
        zzlkVarArr[1] = zzlkVar;
        zzld zzldVar = new zzld(zzlkVarArr);
        Charset charset = zzkn.zzb;
        this.zzb = zzldVar;
    }
}
