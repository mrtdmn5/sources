package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlu {
    public static final zzlu zza = new zzlu();
    public final ConcurrentHashMap zzc = new ConcurrentHashMap();
    public final zzle zzb = new zzle();

    public final zzlx zzb(Class cls) {
        zzlq zzlqVar;
        Class cls2;
        Charset charset = zzkn.zzb;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.zzc;
            zzlx zzlxVar = (zzlx) concurrentHashMap.get(cls);
            if (zzlxVar == null) {
                zzle zzleVar = this.zzb;
                zzleVar.getClass();
                Class cls3 = zzlz.zza;
                if (!zzkf.class.isAssignableFrom(cls) && (cls2 = zzlz.zza) != null && !cls2.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                }
                zzlj zzb = zzleVar.zzb.zzb(cls);
                if (zzb.zzb()) {
                    if (zzkf.class.isAssignableFrom(cls)) {
                        zzlqVar = new zzlq(zzlz.zzd, zzju.zza, zzb.zza());
                    } else {
                        zzmo zzmoVar = zzlz.zzb;
                        zzjs zzjsVar = zzju.zzb;
                        if (zzjsVar != null) {
                            zzlqVar = new zzlq(zzmoVar, zzjsVar, zzb.zza());
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    }
                    zzlxVar = zzlqVar;
                } else {
                    boolean z = false;
                    if (zzkf.class.isAssignableFrom(cls)) {
                        if (zzb.zzc() == 1) {
                            z = true;
                        }
                        if (z) {
                            int r2 = zzls.$r8$clinit;
                            zzlxVar = zzlp.zzl(zzb, zzla.zzb, zzlz.zzd, zzju.zza, zzli.zzb);
                        } else {
                            int r22 = zzls.$r8$clinit;
                            zzlxVar = zzlp.zzl(zzb, zzla.zzb, zzlz.zzd, null, zzli.zzb);
                        }
                    } else {
                        if (zzb.zzc() == 1) {
                            z = true;
                        }
                        if (z) {
                            int r23 = zzls.$r8$clinit;
                            zzkw zzkwVar = zzla.zza;
                            zzmo zzmoVar2 = zzlz.zzb;
                            zzjs zzjsVar2 = zzju.zzb;
                            if (zzjsVar2 != null) {
                                zzlxVar = zzlp.zzl(zzb, zzkwVar, zzmoVar2, zzjsVar2, zzli.zza);
                            } else {
                                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                            }
                        } else {
                            int r24 = zzls.$r8$clinit;
                            zzlxVar = zzlp.zzl(zzb, zzla.zza, zzlz.zzc, null, zzli.zza);
                        }
                    }
                }
                zzlx zzlxVar2 = (zzlx) concurrentHashMap.putIfAbsent(cls, zzlxVar);
                if (zzlxVar2 != null) {
                    return zzlxVar2;
                }
            }
            return zzlxVar;
        }
        throw new NullPointerException("messageType");
    }
}
