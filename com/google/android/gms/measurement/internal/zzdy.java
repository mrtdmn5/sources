package com.google.android.gms.measurement.internal;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdy extends zzf {
    public String zza;
    public String zzb;
    public int zzc;
    public String zzd;
    public long zzf;
    public final long zzg;
    public List zzh;
    public String zzi;
    public int zzj;
    public String zzk;
    public String zzl;
    public String zzm;
    public long zzn;
    public String zzo;

    public zzdy(zzfr zzfrVar, long j) {
        super(zzfrVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0129 A[Catch: IllegalStateException -> 0x014b, TryCatch #4 {IllegalStateException -> 0x014b, blocks: (B:17:0x0116, B:20:0x0121, B:22:0x0129, B:25:0x013b, B:28:0x0146, B:29:0x014e, B:32:0x0137, B:34:0x0152, B:36:0x0163, B:37:0x0168, B:39:0x0166), top: B:16:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0152 A[Catch: IllegalStateException -> 0x014b, TryCatch #4 {IllegalStateException -> 0x014b, blocks: (B:17:0x0116, B:20:0x0121, B:22:0x0129, B:25:0x013b, B:28:0x0146, B:29:0x014e, B:32:0x0137, B:34:0x0152, B:36:0x0163, B:37:0x0168, B:39:0x0166), top: B:16:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0103  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzd():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return true;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final void zzo() {
        String format;
        String str;
        zzg();
        zzfr zzfrVar = this.zzt;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        boolean zzi = zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE);
        zzeh zzehVar = zzfrVar.zzm;
        if (!zzi) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzlb zzlbVar = zzfrVar.zzp;
            zzfr.zzP(zzlbVar);
            zzlbVar.zzG().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzfr.zzR(zzehVar);
        Object[] objArr = new Object[1];
        if (format == null) {
            str = Constants.NULL_VERSION_ID;
        } else {
            str = "not null";
        }
        objArr[0] = str;
        zzehVar.zzk.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = format;
        zzfrVar.zzr.getClass();
        this.zzn = System.currentTimeMillis();
    }
}
