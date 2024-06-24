package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicInteger;
import no.nordicsemi.android.error.SecureDfuError;
import okhttp3.Dns$Companion$DnsSystem;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfr implements zzgm {
    public static volatile zzfr zzd;
    public zzdy zzA;
    public Boolean zzC;
    public long zzD;
    public volatile Boolean zzE;
    public volatile boolean zzF;
    public int zzG;
    public final Boolean zza;
    public final Boolean zzb;
    public final long zzc;
    public final Context zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;
    public final boolean zzi;
    public final zzab zzj;
    public final zzag zzk;
    public final zzew zzl;
    public final zzeh zzm;
    public final zzfo zzn;
    public final zzkc zzo;
    public final zzlb zzp;
    public final zzec zzq;
    public final Dns$Companion$DnsSystem zzr;
    public final zzim zzs;
    public final zzhx zzt;
    public final zzd zzu;
    public final zzib zzv;
    public final String zzw;
    public zzea zzx;
    public zzjm zzy;
    public zzaq zzz;
    public boolean zzB = false;
    public final AtomicInteger zzH = new AtomicInteger(0);

    public zzfr(zzgu zzguVar) {
        long currentTimeMillis;
        Context context;
        Bundle bundle;
        Context context2 = zzguVar.zza;
        zzab zzabVar = new zzab();
        this.zzj = zzabVar;
        SecureDfuError.zza = zzabVar;
        this.zze = context2;
        this.zzf = zzguVar.zzb;
        this.zzg = zzguVar.zzc;
        this.zzh = zzguVar.zzd;
        this.zzi = zzguVar.zzh;
        this.zzE = zzguVar.zze;
        this.zzw = zzguVar.zzj;
        this.zzF = true;
        com.google.android.gms.internal.measurement.zzcl zzclVar = zzguVar.zzg;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        if (com.google.android.gms.internal.measurement.zzib.zze == null) {
            Object obj3 = com.google.android.gms.internal.measurement.zzib.zzd;
            synchronized (obj3) {
                if (com.google.android.gms.internal.measurement.zzib.zze == null) {
                    synchronized (obj3) {
                        com.google.android.gms.internal.measurement.zzhc zzhcVar = com.google.android.gms.internal.measurement.zzib.zze;
                        final Context applicationContext = context2.getApplicationContext();
                        if (applicationContext == null) {
                            applicationContext = context2;
                        }
                        if (zzhcVar == null || zzhcVar.zza != applicationContext) {
                            com.google.android.gms.internal.measurement.zzhf.zze();
                            com.google.android.gms.internal.measurement.zzic.zzc();
                            synchronized (com.google.android.gms.internal.measurement.zzhn.class) {
                                com.google.android.gms.internal.measurement.zzhn zzhnVar = com.google.android.gms.internal.measurement.zzhn.zza;
                                if (zzhnVar != null && (context = zzhnVar.zzb) != null && zzhnVar.zzc != null) {
                                    context.getContentResolver().unregisterContentObserver(com.google.android.gms.internal.measurement.zzhn.zza.zzc);
                                }
                                com.google.android.gms.internal.measurement.zzhn.zza = null;
                            }
                            com.google.android.gms.internal.measurement.zzib.zze = new com.google.android.gms.internal.measurement.zzhc(applicationContext, Pow2.zza(new com.google.android.gms.internal.measurement.zzii() { // from class: com.google.android.gms.internal.measurement.zzhs
                                /* JADX WARN: Can't wrap try/catch for region: R(12:(2:10|11)|21|22|23|24|25|26|(1:28)(1:78)|29|(10:31|32|33|34|35|36|(2:37|(3:39|(3:54|55|56)(7:41|42|(2:44|(1:47))|48|(1:50)|51|52)|53)(1:57))|58|59|60)(1:77)|61|11) */
                                /* JADX WARN: Code restructure failed: missing block: B:80:0x0063, code lost:            r4 = move-exception;     */
                                /* JADX WARN: Code restructure failed: missing block: B:81:0x0064, code lost:            android.util.Log.e("HermeticFileOverrides", "no data dir", r4);        r5 = com.google.android.gms.internal.measurement.zzie.zza;     */
                                @Override // com.google.android.gms.internal.measurement.zzii
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Object zza() {
                                    /*
                                        Method dump skipped, instructions count: 370
                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhs.zza():java.lang.Object");
                                }
                            }));
                            com.google.android.gms.internal.measurement.zzib.zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
        this.zzr = Dns$Companion$DnsSystem.zza;
        Long l = zzguVar.zzi;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        this.zzc = currentTimeMillis;
        this.zzk = new zzag(this);
        zzew zzewVar = new zzew(this);
        zzewVar.zzv();
        this.zzl = zzewVar;
        zzeh zzehVar = new zzeh(this);
        zzehVar.zzv();
        this.zzm = zzehVar;
        zzlb zzlbVar = new zzlb(this);
        zzlbVar.zzv();
        this.zzp = zzlbVar;
        this.zzq = new zzec(new zzgt(this));
        this.zzu = new zzd(this);
        zzim zzimVar = new zzim(this);
        zzimVar.zzb$1();
        this.zzs = zzimVar;
        zzhx zzhxVar = new zzhx(this);
        zzhxVar.zzb$1();
        this.zzt = zzhxVar;
        zzkc zzkcVar = new zzkc(this);
        zzkcVar.zzb$1();
        this.zzo = zzkcVar;
        zzib zzibVar = new zzib(this);
        zzibVar.zzv();
        this.zzv = zzibVar;
        zzfo zzfoVar = new zzfo(this);
        zzfoVar.zzv();
        this.zzn = zzfoVar;
        com.google.android.gms.internal.measurement.zzcl zzclVar2 = zzguVar.zzg;
        boolean z = zzclVar2 == null || zzclVar2.zzb == 0;
        if (context2.getApplicationContext() instanceof Application) {
            zzQ(zzhxVar);
            if (zzhxVar.zzt.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzhxVar.zzt.zze.getApplicationContext();
                if (zzhxVar.zza == null) {
                    zzhxVar.zza = new zzhw(zzhxVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzhxVar.zza);
                    application.registerActivityLifecycleCallbacks(zzhxVar.zza);
                    zzeh zzehVar2 = zzhxVar.zzt.zzm;
                    zzR(zzehVar2);
                    zzehVar2.zzl.zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzR(zzehVar);
            zzehVar.zzg.zza("Application context is not an Application");
        }
        zzfoVar.zzp(new zzfq(this, zzguVar));
    }

    public static final void zzP(zzgl zzglVar) {
        if (zzglVar != null) {
        } else {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void zzQ(zzf zzfVar) {
        if (zzfVar != null) {
            if (zzfVar.zza) {
                return;
            } else {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzfVar.getClass())));
            }
        }
        throw new IllegalStateException("Component not created");
    }

    public static final void zzR(zzgl zzglVar) {
        if (zzglVar != null) {
            if (zzglVar.zza) {
                return;
            } else {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzglVar.getClass())));
            }
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfr zzp(Context context, com.google.android.gms.internal.measurement.zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new com.google.android.gms.internal.measurement.zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfr.class) {
                if (zzd == null) {
                    zzd = new zzfr(new zzgu(context, zzclVar, l));
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    public final void zzB$1() {
        this.zzH.incrementAndGet();
    }

    public final boolean zzJ() {
        if (zza() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:            if (java.lang.Math.abs(android.os.SystemClock.elapsedRealtime() - r7.zzD) > 1000) goto L62;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:            if (r1 == false) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:            if (android.text.TextUtils.isEmpty(r0.zzl) == false) goto L91;     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzM() {
        /*
            r7 = this;
            boolean r0 = r7.zzB
            if (r0 == 0) goto Lce
            com.google.android.gms.measurement.internal.zzfo r0 = r7.zzn
            zzR(r0)
            r0.zzg()
            java.lang.Boolean r0 = r7.zzC
            okhttp3.Dns$Companion$DnsSystem r1 = r7.zzr
            if (r0 == 0) goto L34
            long r2 = r7.zzD
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L34
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lc7
            r1.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r7.zzD
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Lc7
        L34:
            r1.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r7.zzD = r0
            com.google.android.gms.measurement.internal.zzlb r0 = r7.zzp
            zzP(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.zzad(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L8d
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.zzad(r1)
            if (r1 == 0) goto L8d
            android.content.Context r1 = r7.zze
            com.google.android.gms.common.wrappers.PackageManagerWrapper r4 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)
            boolean r4 = r4.isCallerInstantApp()
            if (r4 != 0) goto L8b
            com.google.android.gms.measurement.internal.zzag r4 = r7.zzk
            boolean r4 = r4.zzx()
            if (r4 != 0) goto L8b
            boolean r4 = com.google.android.gms.measurement.internal.zzlb.zzaj(r1)
            if (r4 == 0) goto L8d
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurementJobService"
            android.content.pm.PackageManager r5 = r1.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88
            if (r5 != 0) goto L77
            goto L88
        L77:
            android.content.ComponentName r6 = new android.content.ComponentName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88
            r6.<init>(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.ServiceInfo r1 = r5.getServiceInfo(r6, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88
            if (r1 == 0) goto L88
            boolean r1 = r1.enabled     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88
            if (r1 == 0) goto L88
            r1 = r3
            goto L89
        L88:
            r1 = r2
        L89:
            if (r1 == 0) goto L8d
        L8b:
            r1 = r3
            goto L8e
        L8d:
            r1 = r2
        L8e:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r7.zzC = r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto Lc7
            com.google.android.gms.measurement.internal.zzdy r1 = r7.zzh()
            java.lang.String r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzdy r4 = r7.zzh()
            r4.zza()
            java.lang.String r4 = r4.zzl
            boolean r0 = r0.zzX(r1, r4)
            if (r0 != 0) goto Lc0
            com.google.android.gms.measurement.internal.zzdy r0 = r7.zzh()
            r0.zza()
            java.lang.String r0 = r0.zzl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lc1
        Lc0:
            r2 = r3
        Lc1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r7.zzC = r0
        Lc7:
            java.lang.Boolean r0 = r7.zzC
            boolean r0 = r0.booleanValue()
            return r0
        Lce:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfr.zzM():boolean");
    }

    public final int zza() {
        zzfo zzfoVar = this.zzn;
        zzR(zzfoVar);
        zzfoVar.zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzfo zzfoVar2 = this.zzn;
        zzR(zzfoVar2);
        zzfoVar2.zzg();
        if (!this.zzF) {
            return 8;
        }
        zzew zzewVar = this.zzl;
        zzP(zzewVar);
        Boolean zzd2 = zzewVar.zzd();
        if (zzd2 != null) {
            if (zzd2.booleanValue()) {
                return 0;
            }
            return 3;
        }
        zzag zzagVar = this.zzk;
        zzab zzabVar = zzagVar.zzt.zzj;
        Boolean zzk = zzagVar.zzk("firebase_analytics_collection_enabled");
        if (zzk != null) {
            if (zzk.booleanValue()) {
                return 0;
            }
            return 4;
        }
        Boolean bool2 = this.zza;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                return 0;
            }
            return 5;
        }
        if (this.zzE == null || this.zzE.booleanValue()) {
            return 0;
        }
        return 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final Context zzau() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final Clock zzav() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzab zzaw() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzeh zzay() {
        zzeh zzehVar = this.zzm;
        zzR(zzehVar);
        return zzehVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzfo zzaz() {
        zzfo zzfoVar = this.zzn;
        zzR(zzfoVar);
        return zzfoVar;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.zzk;
    }

    @Pure
    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzdy zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzea zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzec zzj() {
        return this.zzq;
    }

    @Pure
    public final zzjm zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }
}
