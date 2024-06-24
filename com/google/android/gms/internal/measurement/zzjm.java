package com.google.android.gms.internal.measurement;

import io.ktor.http.content.NullBody;
import java.io.IOException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzjm extends NullBody {
    public static final Logger zzb = Logger.getLogger(zzjm.class.getName());
    public static final boolean zzc = zzmy.zzh;
    public zzjn zza;

    public zzjm() {
    }

    public /* synthetic */ zzjm(int r1) {
    }

    public static int zzA(int r1) {
        if ((r1 & (-128)) == 0) {
            return 1;
        }
        if ((r1 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & r1) == 0) {
            return 3;
        }
        if ((r1 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzB(long j) {
        int r0;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            r0 = 6;
        } else {
            r0 = 2;
        }
        if (((-2097152) & j) != 0) {
            r0 += 2;
            j >>>= 14;
        }
        if ((j & (-16384)) != 0) {
            return r0 + 1;
        }
        return r0;
    }

    @Deprecated
    public static int zzu(int r0, zzlm zzlmVar, zzlx zzlxVar) {
        int zzA = zzA(r0 << 3);
        return ((zzio) zzlmVar).zzbr(zzlxVar) + zzA + zzA;
    }

    public static int zzv(int r0) {
        if (r0 >= 0) {
            return zzA(r0);
        }
        return 10;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zznd.zzc(str);
        } catch (zznc unused) {
            length = str.getBytes(zzkn.zzb).length;
        }
        return zzA(length) + length;
    }

    public static int zzz(int r0) {
        return zzA(r0 << 3);
    }

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int r1, boolean z) throws IOException;

    public abstract void zze(int r1, zzje zzjeVar) throws IOException;

    public abstract void zzf(int r1, int r2) throws IOException;

    public abstract void zzg(int r1) throws IOException;

    public abstract void zzh(int r1, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int r1, int r2) throws IOException;

    public abstract void zzk(int r1) throws IOException;

    public abstract void zzm(int r1, String str) throws IOException;

    public abstract void zzo(int r1, int r2) throws IOException;

    public abstract void zzp(int r1, int r2) throws IOException;

    public abstract void zzq(int r1) throws IOException;

    public abstract void zzr(int r1, long j) throws IOException;

    public abstract void zzs(long j) throws IOException;
}
