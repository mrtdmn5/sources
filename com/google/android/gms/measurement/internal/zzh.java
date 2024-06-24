package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.compose.ui.graphics.ShadowKt;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzh {
    public long zzA;
    public String zzB;
    public boolean zzC;
    public long zzD;
    public long zzE;
    public final zzfr zza;
    public final String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public long zzg;
    public long zzh;
    public long zzi;
    public String zzj;
    public long zzk;
    public String zzl;
    public long zzm;
    public long zzn;
    public boolean zzo;
    public boolean zzp;
    public String zzq;
    public Boolean zzr;
    public long zzs;
    public ArrayList zzt;
    public String zzu;
    public long zzv;
    public long zzw;
    public long zzx;
    public long zzy;
    public long zzz;

    public zzh(zzfr zzfrVar, String str) {
        Preconditions.checkNotNull(zzfrVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfrVar;
        this.zzb = str;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
    }

    public final void zzF(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ ShadowKt.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzH(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzI(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzJ(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzK(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzk != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzk = j;
    }

    public final void zzL(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzD != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzD = j;
    }

    public final void zzM(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzy != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzy = j;
    }

    public final void zzN(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzz != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzz = j;
    }

    public final void zzO(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzx != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzx = j;
    }

    public final void zzP(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzw != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzw = j;
    }

    public final void zzQ(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzA != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzA = j;
    }

    public final void zzR(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzv != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzv = j;
    }

    public final void zzS(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzn != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzn = j;
    }

    public final void zzT(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzs != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzs = j;
    }

    public final void zzV(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzW(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ ShadowKt.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzX(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzm != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzm = j;
    }

    public final void zzY(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zzB, str);
        this.zzB = str;
    }

    public final void zzZ(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzi != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzi = j;
    }

    public final void zzaa(long j) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z3 = this.zzC;
        if (this.zzg == j) {
            z2 = false;
        }
        this.zzC = z3 | z2;
        this.zzg = j;
    }

    public final void zzab(long j) {
        boolean z;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z2 = this.zzC;
        if (this.zzh != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzh = j;
    }

    public final void zzac(boolean z) {
        boolean z2;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        boolean z3 = this.zzC;
        if (this.zzo != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzC = z3 | z2;
        this.zzo = z;
    }

    public final void zzae(String str) {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        this.zzC |= !ShadowKt.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzaf(List list) {
        ArrayList arrayList;
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (!ShadowKt.zza(this.zzt, list)) {
            this.zzC = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.zzt = arrayList;
        }
    }

    public final boolean zzah() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzp;
    }

    public final long zzb() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzk;
    }

    public final long zzk() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzs;
    }

    public final String zzr() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzq;
    }

    public final String zzs() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        String str = this.zzB;
        zzY(null);
        return str;
    }

    public final String zzt() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzb;
    }

    public final String zzu() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzc;
    }

    public final String zzw() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzj;
    }

    public final String zzx() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzf;
    }

    public final String zzy() {
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        return this.zzd;
    }
}
