package com.google.android.gms.internal.measurement;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjw {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final zzma zza = new zzma(16);
    public boolean zzc;

    static {
        new zzjw(0);
    }

    public zzjw() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void zzd(com.google.android.gms.internal.measurement.zzjv r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzne r0 = r2.zzb()
            java.nio.charset.Charset r1 = com.google.android.gms.internal.measurement.zzkn.zzb
            r3.getClass()
            com.google.android.gms.internal.measurement.zzne r1 = com.google.android.gms.internal.measurement.zzne.zza
            com.google.android.gms.internal.measurement.zznf r1 = com.google.android.gms.internal.measurement.zznf.INT
            com.google.android.gms.internal.measurement.zznf r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L3b;
                case 1: goto L38;
                case 2: goto L35;
                case 3: goto L32;
                case 4: goto L2f;
                case 5: goto L2c;
                case 6: goto L23;
                case 7: goto L1e;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L40
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzlm
            if (r0 == 0) goto L40
            goto L3f
        L1e:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 == 0) goto L40
            goto L3f
        L23:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzje
            if (r0 != 0) goto L3f
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L40
            goto L3f
        L2c:
            boolean r0 = r3 instanceof java.lang.String
            goto L3d
        L2f:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L3d
        L32:
            boolean r0 = r3 instanceof java.lang.Double
            goto L3d
        L35:
            boolean r0 = r3 instanceof java.lang.Float
            goto L3d
        L38:
            boolean r0 = r3 instanceof java.lang.Long
            goto L3d
        L3b:
            boolean r0 = r3 instanceof java.lang.Integer
        L3d:
            if (r0 == 0) goto L40
        L3f:
            return
        L40:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zzne r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zznf r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjw.zzd(com.google.android.gms.internal.measurement.zzjv, java.lang.Object):void");
    }

    public final Object clone() throws CloneNotSupportedException {
        zzma zzmaVar;
        Iterable<Map.Entry> entrySet;
        zzjw zzjwVar = new zzjw();
        int r1 = 0;
        while (true) {
            zzmaVar = this.zza;
            if (r1 >= zzmaVar.zzb()) {
                break;
            }
            Map.Entry entry = (Map.Entry) zzmaVar.zzb.get(r1);
            zzjwVar.zzc((zzjv) entry.getKey(), entry.getValue());
            r1++;
        }
        if (zzmaVar.zzc.isEmpty()) {
            entrySet = KtorSimpleLoggerJvmKt.zzb;
        } else {
            entrySet = zzmaVar.zzc.entrySet();
        }
        for (Map.Entry entry2 : entrySet) {
            zzjwVar.zzc((zzjv) entry2.getKey(), entry2.getValue());
        }
        return zzjwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjw)) {
            return false;
        }
        return this.zza.equals(((zzjw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            int r0 = 0;
            while (true) {
                zzma zzmaVar = this.zza;
                if (r0 < zzmaVar.zzb()) {
                    Map.Entry entry = (Map.Entry) zzmaVar.zzb.get(r0);
                    if (entry.getValue() instanceof zzkf) {
                        ((zzkf) entry.getValue()).zzbJ();
                    }
                    r0++;
                } else {
                    zzmaVar.zza();
                    this.zzc = true;
                    return;
                }
            }
        }
    }

    public final void zzc(zzjv zzjvVar, Object obj) {
        if (zzjvVar.zzc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int r1 = 0; r1 < size; r1++) {
                    zzd(zzjvVar, arrayList.get(r1));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzd(zzjvVar, obj);
        }
        this.zza.put(zzjvVar, obj);
    }

    public zzjw(int r2) {
        zzb();
        zzb();
    }
}
