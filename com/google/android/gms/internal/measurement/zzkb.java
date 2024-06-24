package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public class zzkb<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    public zzkf zza;
    public final zzkf zzb;

    public zzkb(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzbO()) {
            this.zza = (zzkf) messagetype.zzl(4);
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final void zzaB(byte[] bArr, int r10, zzjr zzjrVar) throws zzkp {
        if (!this.zza.zzbO()) {
            zzkf zzkfVar = (zzkf) this.zzb.zzl(4);
            zzlu.zza.zzb(zzkfVar.getClass()).zzg(zzkfVar, this.zza);
            this.zza = zzkfVar;
        }
        try {
            zzlu.zza.zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, r10, new zzir(zzjrVar));
        } catch (zzkp e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkp.zzf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:            if (r1 != false) goto L8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final MessageType zzaC() {
        /*
            r3 = this;
            com.google.android.gms.internal.measurement.zzkf r0 = r3.zzaD()
            r1 = 1
            java.lang.Object r2 = r0.zzl(r1)
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            if (r2 != r1) goto L12
            goto L28
        L12:
            if (r2 == 0) goto L29
            com.google.android.gms.internal.measurement.zzlu r1 = com.google.android.gms.internal.measurement.zzlu.zza
            java.lang.Class r2 = r0.getClass()
            com.google.android.gms.internal.measurement.zzlx r1 = r1.zzb(r2)
            boolean r1 = r1.zzk(r0)
            r2 = 2
            r0.zzl(r2)
            if (r1 == 0) goto L29
        L28:
            return r0
        L29:
            com.google.android.gms.internal.measurement.zzmn r0 = new com.google.android.gms.internal.measurement.zzmn
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkb.zzaC():com.google.android.gms.internal.measurement.zzkf");
    }

    public final MessageType zzaD() {
        if (!this.zza.zzbO()) {
            return (MessageType) this.zza;
        }
        this.zza.zzbJ();
        return (MessageType) this.zza;
    }

    public final void zzaG() {
        if (!this.zza.zzbO()) {
            zzkf zzkfVar = (zzkf) this.zzb.zzl(4);
            zzlu.zza.zzb(zzkfVar.getClass()).zzg(zzkfVar, this.zza);
            this.zza = zzkfVar;
        }
    }

    /* renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public final zzkb clone() {
        zzkb zzkbVar = (zzkb) this.zzb.zzl(5);
        zzkbVar.zza = zzaD();
        return zzkbVar;
    }
}
