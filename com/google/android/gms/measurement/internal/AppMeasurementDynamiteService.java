package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.compose.ui.geometry.MutableRectKt;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
@DynamiteApi
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcb {
    public zzfr zza = null;
    public final ArrayMap zzb = new ArrayMap();

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(j, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzhq(zzhxVar, null));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zze(j, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void generateEventId(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        long zzq = zzlbVar.zzq();
        zzb();
        zzlb zzlbVar2 = this.zza.zzp;
        zzfr.zzP(zzlbVar2);
        zzlbVar2.zzU(zzcfVar, zzq);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getAppInstanceId(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzi(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCachedAppInstanceId(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzc(zzhxVar.zzo$1(), zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) throws RemoteException {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzm(this, zzcfVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenClass(zzcf zzcfVar) throws RemoteException {
        String str;
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzim zzimVar = zzhxVar.zzt.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        if (zzieVar != null) {
            str = zzieVar.zzb;
        } else {
            str = null;
        }
        zzc(str, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenName(zzcf zzcfVar) throws RemoteException {
        String str;
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzim zzimVar = zzhxVar.zzt.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVar = zzimVar.zzb;
        if (zzieVar != null) {
            str = zzieVar.zza;
        } else {
            str = null;
        }
        zzc(str, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getGmpAppId(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfr zzfrVar = zzhxVar.zzt;
        String str = zzfrVar.zzf;
        if (str == null) {
            try {
                str = MutableRectKt.zzc(zzfrVar.zze, zzfrVar.zzw);
            } catch (IllegalStateException e) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(e, "getGoogleAppId failed with exception");
                str = null;
            }
        }
        zzc(str, zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getMaxUserProperties(String str, zzcf zzcfVar) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        Preconditions.checkNotEmpty(str);
        zzhxVar.zzt.getClass();
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzT(zzcfVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getSessionId(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzhk(zzhxVar, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getTestFlag(zzcf zzcfVar, int r9) throws RemoteException {
        zzb();
        if (r9 != 0) {
            if (r9 != 1) {
                if (r9 != 2) {
                    if (r9 != 3) {
                        if (r9 != 4) {
                            return;
                        }
                        zzlb zzlbVar = this.zza.zzp;
                        zzfr.zzP(zzlbVar);
                        zzhx zzhxVar = this.zza.zzt;
                        zzfr.zzQ(zzhxVar);
                        AtomicReference atomicReference = new AtomicReference();
                        zzfo zzfoVar = zzhxVar.zzt.zzn;
                        zzfr.zzR(zzfoVar);
                        zzlbVar.zzP(zzcfVar, ((Boolean) zzfoVar.zzd(atomicReference, 15000L, "boolean test flag value", new zzhi(zzhxVar, atomicReference))).booleanValue());
                        return;
                    }
                    zzlb zzlbVar2 = this.zza.zzp;
                    zzfr.zzP(zzlbVar2);
                    zzhx zzhxVar2 = this.zza.zzt;
                    zzfr.zzQ(zzhxVar2);
                    AtomicReference atomicReference2 = new AtomicReference();
                    zzfo zzfoVar2 = zzhxVar2.zzt.zzn;
                    zzfr.zzR(zzfoVar2);
                    zzlbVar2.zzT(zzcfVar, ((Integer) zzfoVar2.zzd(atomicReference2, 15000L, "int test flag value", new zzho(zzhxVar2, atomicReference2))).intValue());
                    return;
                }
                zzlb zzlbVar3 = this.zza.zzp;
                zzfr.zzP(zzlbVar3);
                zzhx zzhxVar3 = this.zza.zzt;
                zzfr.zzQ(zzhxVar3);
                AtomicReference atomicReference3 = new AtomicReference();
                zzfo zzfoVar3 = zzhxVar3.zzt.zzn;
                zzfr.zzR(zzfoVar3);
                double doubleValue = ((Double) zzfoVar3.zzd(atomicReference3, 15000L, "double test flag value", new zzhp(zzhxVar3, atomicReference3))).doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    zzcfVar.zze(bundle);
                    return;
                } catch (RemoteException e) {
                    zzeh zzehVar = zzlbVar3.zzt.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zzb(e, "Error returning double value to wrapper");
                    return;
                }
            }
            zzlb zzlbVar4 = this.zza.zzp;
            zzfr.zzP(zzlbVar4);
            zzhx zzhxVar4 = this.zza.zzt;
            zzfr.zzQ(zzhxVar4);
            AtomicReference atomicReference4 = new AtomicReference();
            zzfo zzfoVar4 = zzhxVar4.zzt.zzn;
            zzfr.zzR(zzfoVar4);
            zzlbVar4.zzU(zzcfVar, ((Long) zzfoVar4.zzd(atomicReference4, 15000L, "long test flag value", new zzhn(zzhxVar4, atomicReference4))).longValue());
            return;
        }
        zzlb zzlbVar5 = this.zza.zzp;
        zzfr.zzP(zzlbVar5);
        zzhx zzhxVar5 = this.zza.zzt;
        zzfr.zzQ(zzhxVar5);
        AtomicReference atomicReference5 = new AtomicReference();
        zzfo zzfoVar5 = zzhxVar5.zzt.zzn;
        zzfr.zzR(zzfoVar5);
        zzlbVar5.zzV((String) zzfoVar5.zzd(atomicReference5, 15000L, "String test flag value", new zzhm(zzhxVar5, atomicReference5)), zzcfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getUserProperties(String str, String str2, boolean z, zzcf zzcfVar) throws RemoteException {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzk(this, zzcfVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcl zzclVar, long j) throws RemoteException {
        zzfr zzfrVar = this.zza;
        if (zzfrVar == null) {
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            Preconditions.checkNotNull(context);
            this.zza = zzfr.zzp(context, zzclVar, Long.valueOf(j));
        } else {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void isDataCollectionEnabled(zzcf zzcfVar) throws RemoteException {
        zzb();
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzn(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzE(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        zzaw zzawVar = new zzaw(str2, new zzau(bundle), "app", j);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzj(this, zzcfVar, zzawVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logHealthData(int r10, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object unwrap;
        Object unwrap2;
        zzb();
        Object obj = null;
        if (iObjectWrapper == null) {
            unwrap = null;
        } else {
            unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            unwrap2 = null;
        } else {
            unwrap2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        zzeh zzehVar = this.zza.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzt(r10, true, false, str, unwrap, unwrap2, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcfVar, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhw zzhwVar = zzhxVar.zza;
        Bundle bundle = new Bundle();
        if (zzhwVar != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
            zzhwVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = this.zza.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        if (zzhxVar.zza != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        if (zzhxVar.zza != null) {
            zzhx zzhxVar2 = this.zza.zzt;
            zzfr.zzQ(zzhxVar2);
            zzhxVar2.zzB$1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void performAction(Bundle bundle, zzcf zzcfVar, long j) throws RemoteException {
        zzb();
        zzcfVar.zze(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        Object obj;
        zzb();
        synchronized (this.zzb) {
            obj = (zzgs) this.zzb.getOrDefault(Integer.valueOf(zzciVar.zzd()), null);
            if (obj == null) {
                obj = new zzp(this, zzciVar);
                this.zzb.put(Integer.valueOf(zzciVar.zzd()), obj);
            }
        }
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        if (!zzhxVar.zze.add(obj)) {
            zzeh zzehVar = zzhxVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("OnEventListener already registered");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzg.set(null);
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzhe(zzhxVar, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            zzeh zzehVar = this.zza.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Conditional user property must not be null");
        } else {
            zzhx zzhxVar = this.zza.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzQ(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsent(final Bundle bundle, final long j) throws RemoteException {
        zzb();
        final zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgv
            @Override // java.lang.Runnable
            public final void run() {
                zzhx zzhxVar2 = zzhx.this;
                if (TextUtils.isEmpty(zzhxVar2.zzt.zzh().zzm())) {
                    zzhxVar2.zzR(bundle, 0, j);
                    return;
                }
                zzeh zzehVar = zzhxVar2.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzi.zza("Using developer consent only; google app id found");
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzR(bundle, -20, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:            if (r4.length() <= 100) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:            if (r5.length() <= 100) goto L33;     */
    @Override // com.google.android.gms.internal.measurement.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper r3, java.lang.String r4, java.lang.String r5, long r6) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzht(zzhxVar, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDefaultEventParameters(Bundle bundle) {
        final Bundle bundle2;
        zzb();
        final zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgw
            @Override // java.lang.Runnable
            public final void run() {
                zzhl zzhlVar;
                zzeh zzehVar;
                zzlb zzlbVar;
                zzhx zzhxVar2 = zzhx.this;
                zzfr zzfrVar = zzhxVar2.zzt;
                Bundle bundle3 = bundle2;
                if (bundle3 == null) {
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    zzewVar.zzs.zzb(new Bundle());
                    return;
                }
                zzew zzewVar2 = zzfrVar.zzl;
                zzfr.zzP(zzewVar2);
                Bundle zza = zzewVar2.zzs.zza();
                Iterator<String> it = bundle3.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    zzhlVar = zzhxVar2.zzn;
                    zzehVar = zzfrVar.zzm;
                    zzlbVar = zzfrVar.zzp;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    Object obj = bundle3.get(next);
                    if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                        zzfr.zzP(zzlbVar);
                        zzlbVar.getClass();
                        if (zzlb.zzaf(obj)) {
                            zzlb.zzN(zzhlVar, null, 27, null, null, 0);
                        }
                        zzfr.zzR(zzehVar);
                        zzehVar.zzi.zzc(next, obj, "Invalid default event parameter type. Name, value");
                    } else if (zzlb.zzah(next)) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzi.zzb(next, "Invalid default event parameter name. Name");
                    } else if (obj == null) {
                        zza.remove(next);
                    } else {
                        zzfr.zzP(zzlbVar);
                        if (zzlbVar.zzaa("param", next, 100, obj)) {
                            zzlbVar.zzO(zza, next, obj);
                        }
                    }
                }
                zzfr.zzP(zzlbVar);
                int zzc = zzfrVar.zzk.zzc();
                if (zza.size() > zzc) {
                    Iterator it2 = new TreeSet(zza.keySet()).iterator();
                    int r5 = 0;
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        r5++;
                        if (r5 > zzc) {
                            zza.remove(str);
                        }
                    }
                    zzfr.zzP(zzlbVar);
                    zzlbVar.getClass();
                    zzlb.zzN(zzhlVar, null, 26, null, null, 0);
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("Too many default event parameters set. Discarding beyond event parameter limit");
                }
                zzew zzewVar3 = zzfrVar.zzl;
                zzfr.zzP(zzewVar3);
                zzewVar3.zzs.zzb(zza);
                zzjm zzt = zzfrVar.zzt();
                zzt.zzg();
                zzt.zza();
                zzt.zzR(new zziv(zzt, zzt.zzO(false), zza));
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        boolean z;
        zzb();
        zzo zzoVar = new zzo(this, zzciVar);
        zzfo zzfoVar = this.zza.zzn;
        zzfr.zzR(zzfoVar);
        if (zzfoVar.zzs()) {
            zzhx zzhxVar = this.zza.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzg();
            zzhxVar.zza();
            zzo zzoVar2 = zzhxVar.zzd;
            if (zzoVar != zzoVar2) {
                if (zzoVar2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState("EventInterceptor already set.", z);
            }
            zzhxVar.zzd = zzoVar;
            return;
        }
        zzfo zzfoVar2 = this.zza.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzp(new zzl(this, zzoVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzck zzckVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        Boolean valueOf = Boolean.valueOf(z);
        zzhxVar.zza();
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzhq(zzhxVar, valueOf));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfo zzfoVar = zzhxVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzha(zzhxVar, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserId(final String str, long j) throws RemoteException {
        zzb();
        final zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzfr zzfrVar = zzhxVar.zzt;
        if (str != null && TextUtils.isEmpty(str)) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("User ID must be non-empty or null");
        } else {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgx
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    zzhx zzhxVar2 = zzhx.this;
                    zzdy zzh = zzhxVar2.zzt.zzh();
                    String str2 = zzh.zzo;
                    String str3 = str;
                    if (str2 != null && !str2.equals(str3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzh.zzo = str3;
                    if (z) {
                        zzhxVar2.zzt.zzh().zzo();
                    }
                }
            });
            zzhxVar.zzX(null, TransferTable.COLUMN_ID, str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zzX(str, str2, unwrap, z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        Object obj;
        zzb();
        synchronized (this.zzb) {
            obj = (zzgs) this.zzb.remove(Integer.valueOf(zzciVar.zzd()));
        }
        if (obj == null) {
            obj = new zzp(this, zzciVar);
        }
        zzhx zzhxVar = this.zza.zzt;
        zzfr.zzQ(zzhxVar);
        zzhxVar.zza();
        if (!zzhxVar.zze.remove(obj)) {
            zzeh zzehVar = zzhxVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("OnEventListener had not been registered");
        }
    }

    @EnsuresNonNull({"scion"})
    public final void zzb() {
        if (this.zza != null) {
        } else {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void zzc(String str, zzcf zzcfVar) {
        zzb();
        zzlb zzlbVar = this.zza.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzV(str, zzcfVar);
    }
}
