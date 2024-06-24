package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import com.animaconnected.secondo.R;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjm extends zzf {
    public final zzjl zza;
    public zzdx zzb;
    public volatile Boolean zzc;
    public final zziw zzd;
    public final zzkd zze;
    public final ArrayList zzf;
    public final zziy zzg;

    public zzjm(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = new ArrayList();
        this.zze = new zzkd(zzfrVar.zzr);
        this.zza = new zzjl(this);
        this.zzd = new zziw(this, zzfrVar);
        this.zzg = new zziy(this, zzfrVar);
    }

    public static void zzo(zzjm zzjmVar, ComponentName componentName) {
        zzjmVar.zzg();
        if (zzjmVar.zzb != null) {
            zzjmVar.zzb = null;
            zzeh zzehVar = zzjmVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zzb(componentName, "Disconnected from device MeasurementService");
            zzjmVar.zzg();
            zzjmVar.zzr();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0316 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x027a A[Catch: all -> 0x02e6, TRY_ENTER, TryCatch #8 {all -> 0x02e6, blocks: (B:32:0x00da, B:34:0x00e0, B:37:0x00ed, B:39:0x00f3, B:47:0x0109, B:49:0x010e, B:79:0x027a, B:81:0x0280, B:82:0x0283, B:69:0x02be, B:57:0x02a7, B:92:0x012c, B:93:0x012f, B:90:0x0127, B:101:0x0135, B:104:0x0149, B:106:0x0161, B:111:0x0165, B:112:0x0168, B:109:0x015b, B:115:0x016c, B:118:0x0180, B:120:0x0198, B:125:0x019d, B:126:0x01a0, B:123:0x0192, B:129:0x01a4, B:131:0x01b1, B:140:0x01cf, B:143:0x01db, B:147:0x01eb, B:148:0x01f7), top: B:31:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0299  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzD(com.google.android.gms.measurement.internal.zzdx r29, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r30, com.google.android.gms.measurement.internal.zzq r31) {
        /*
            Method dump skipped, instructions count: 897
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjm.zzD(com.google.android.gms.measurement.internal.zzdx, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzq):void");
    }

    public final void zzE(zzac zzacVar) {
        boolean zzq;
        zzg();
        zza();
        zzfr zzfrVar = this.zzt;
        zzfrVar.getClass();
        zzea zzi = zzfrVar.zzi();
        zzfr zzfrVar2 = zzi.zzt;
        zzlb zzlbVar = zzfrVar2.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.getClass();
        byte[] zzan = zzlb.zzan(zzacVar);
        if (zzan.length > 131072) {
            zzeh zzehVar = zzfrVar2.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zze.zza("Conditional user property too long for local database. Sending directly to service");
            zzq = false;
        } else {
            zzq = zzi.zzq(2, zzan);
        }
        zzR(new zzjc(this, zzO(true), zzq, new zzac(zzacVar)));
    }

    public final boolean zzL() {
        zzg();
        zza();
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN()) {
            return true;
        }
        zzlb zzlbVar = this.zzt.zzp;
        zzfr.zzP(zzlbVar);
        if (zzlbVar.zzm() >= ((Integer) zzdu.zzaf.zza(null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzN() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjm.zzN():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0215  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzq zzO(boolean r35) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjm.zzO(boolean):com.google.android.gms.measurement.internal.zzq");
    }

    public final void zzP$1() {
        zzg();
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        ArrayList arrayList = this.zzf;
        zzehVar.zzl.zzb(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.zzg.zzb();
    }

    public final void zzQ() {
        zzg();
        zzkd zzkdVar = this.zze;
        ((Dns$Companion$DnsSystem) zzkdVar.zza).getClass();
        zzkdVar.zzb = SystemClock.elapsedRealtime();
        this.zzt.getClass();
        this.zzd.zzd(((Long) zzdu.zzI.zza(null)).longValue());
    }

    public final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.zzf;
        int size = arrayList.size();
        zzfr zzfrVar = this.zzt;
        zzfrVar.getClass();
        if (size >= 1000) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.zzg.zzd(60000L);
            zzr();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final Boolean zzj() {
        return this.zzc;
    }

    public final void zzr() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (!zzN()) {
            if (!this.zzt.zzk.zzx()) {
                this.zzt.getClass();
                List<ResolveInfo> queryIntentServices = this.zzt.zze.getPackageManager().queryIntentServices(new Intent().setClassName(this.zzt.zze, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(this.zzt.zze, "com.google.android.gms.measurement.AppMeasurementService"));
                    zzjl zzjlVar = this.zza;
                    zzjlVar.zza.zzg();
                    Context context = zzjlVar.zza.zzt.zze;
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    synchronized (zzjlVar) {
                        if (zzjlVar.zzb) {
                            zzeh zzehVar = zzjlVar.zza.zzt.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzl.zza("Connection attempt already in progress");
                            return;
                        } else {
                            zzeh zzehVar2 = zzjlVar.zza.zzt.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzl.zza("Using local app measurement service");
                            zzjlVar.zzb = true;
                            connectionTracker.bindService(context, intent, zzjlVar.zza.zza, R.styleable.AppTheme_statusTopStripeImportant);
                            return;
                        }
                    }
                }
                zzeh zzehVar3 = this.zzt.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzd.zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            return;
        }
        zzjl zzjlVar2 = this.zza;
        zzjlVar2.zza.zzg();
        Context context2 = zzjlVar2.zza.zzt.zze;
        synchronized (zzjlVar2) {
            if (zzjlVar2.zzb) {
                zzeh zzehVar4 = zzjlVar2.zza.zzt.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzl.zza("Connection attempt already in progress");
            } else {
                if (zzjlVar2.zzc != null && (zzjlVar2.zzc.isConnecting() || zzjlVar2.zzc.isConnected())) {
                    zzeh zzehVar5 = zzjlVar2.zza.zzt.zzm;
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzl.zza("Already awaiting connection attempt");
                    return;
                }
                zzjlVar2.zzc = new zzed(context2, Looper.getMainLooper(), zzjlVar2, zzjlVar2);
                zzeh zzehVar6 = zzjlVar2.zza.zzt.zzm;
                zzfr.zzR(zzehVar6);
                zzehVar6.zzl.zza("Connecting to remote service");
                zzjlVar2.zzb = true;
                Preconditions.checkNotNull(zzjlVar2.zzc);
                zzjlVar2.zzc.checkAvailabilityAndConnect();
            }
        }
    }

    public final void zzs$2() {
        zzg();
        zza();
        zzjl zzjlVar = this.zza;
        if (zzjlVar.zzc != null && (zzjlVar.zzc.isConnected() || zzjlVar.zzc.isConnecting())) {
            zzjlVar.zzc.disconnect();
        }
        zzjlVar.zzc = null;
        try {
            ConnectionTracker.getInstance().unbindService(this.zzt.zze, this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzir(this, atomicReference, zzO(false)));
    }
}
