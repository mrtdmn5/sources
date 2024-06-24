package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.ProcessUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzee implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Object zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ zzeh zzf;

    public zzee(zzeh zzehVar, int r2, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzehVar;
        this.zza = r2;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzew zzewVar = this.zzf.zzt.zzl;
        zzfr.zzP(zzewVar);
        if (zzewVar.zza) {
            zzeh zzehVar = this.zzf;
            if (zzehVar.zza == 0) {
                zzag zzagVar = zzehVar.zzt.zzk;
                if (zzagVar.zzc == null) {
                    synchronized (zzagVar) {
                        if (zzagVar.zzc == null) {
                            ApplicationInfo applicationInfo = zzagVar.zzt.zze.getApplicationInfo();
                            String myProcessName = ProcessUtils.getMyProcessName();
                            if (applicationInfo != null) {
                                String str = applicationInfo.processName;
                                if (str != null && str.equals(myProcessName)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                zzagVar.zzc = Boolean.valueOf(z);
                            }
                            if (zzagVar.zzc == null) {
                                zzagVar.zzc = Boolean.TRUE;
                                zzeh zzehVar2 = zzagVar.zzt.zzm;
                                zzfr.zzR(zzehVar2);
                                zzehVar2.zzd.zza("My process not in the list of running processes");
                            }
                        }
                    }
                }
                if (zzagVar.zzc.booleanValue()) {
                    zzeh zzehVar3 = this.zzf;
                    zzehVar3.zzt.getClass();
                    zzehVar3.zza = 'C';
                } else {
                    zzeh zzehVar4 = this.zzf;
                    zzehVar4.zzt.getClass();
                    zzehVar4.zza = 'c';
                }
            }
            zzeh zzehVar5 = this.zzf;
            if (zzehVar5.zzb < 0) {
                zzehVar5.zzt.zzk.zzh();
                zzehVar5.zzb = 74029L;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeh zzehVar6 = this.zzf;
            char c = zzehVar6.zza;
            long j = zzehVar6.zzb;
            String zzo = zzeh.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder("2");
            sb.append(charAt);
            sb.append(c);
            sb.append(j);
            String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, ":", zzo);
            if (m.length() > 1024) {
                m = this.zzb.substring(0, 1024);
            }
            zzeu zzeuVar = zzewVar.zzb;
            if (zzeuVar != null) {
                zzew zzewVar2 = zzeuVar.zzb;
                zzewVar2.zzg();
                if (zzeuVar.zzb.zza().getLong(zzeuVar.zza, 0L) == 0) {
                    zzeuVar.zzd();
                }
                if (m == null) {
                    m = "";
                }
                SharedPreferences zza = zzewVar2.zza();
                String str2 = zzeuVar.zzc;
                long j2 = zza.getLong(str2, 0L);
                String str3 = zzeuVar.zzd;
                if (j2 <= 0) {
                    SharedPreferences.Editor edit = zzewVar2.zza().edit();
                    edit.putString(str3, m);
                    edit.putLong(str2, 1L);
                    edit.apply();
                    return;
                }
                zzlb zzlbVar = zzewVar2.zzt.zzp;
                zzfr.zzP(zzlbVar);
                long nextLong = zzlbVar.zzG().nextLong();
                long j3 = j2 + 1;
                long j4 = Long.MAX_VALUE / j3;
                SharedPreferences.Editor edit2 = zzewVar2.zza().edit();
                if ((Long.MAX_VALUE & nextLong) < j4) {
                    edit2.putString(str3, m);
                }
                edit2.putLong(str2, j3);
                edit2.apply();
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
