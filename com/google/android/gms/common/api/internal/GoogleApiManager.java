package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.collection.ArraySet;
import androidx.collection.MapCollections;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public long zag;
    public boolean zah;
    public TelemetryData zai;
    public com.google.android.gms.common.internal.service.zao zaj;
    public final Context zak;
    public final GoogleApiAvailability zal;
    public final com.google.android.gms.common.internal.zal zam;
    public final AtomicInteger zan;
    public final AtomicInteger zao;
    public final ConcurrentHashMap zap;
    public final ArraySet zar;
    public final ArraySet zas;

    @NotOnlyInitialized
    public final zau zat;
    public volatile boolean zau;

    public GoogleApiManager(Context context, Looper looper) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zag = 10000L;
        this.zah = false;
        this.zan = new AtomicInteger(1);
        this.zao = new AtomicInteger(0);
        this.zap = new ConcurrentHashMap(5, 0.75f, 1);
        this.zar = new ArraySet();
        this.zas = new ArraySet();
        this.zau = true;
        this.zak = context;
        zau zauVar = new zau(looper, this);
        this.zat = zauVar;
        this.zal = googleApiAvailability;
        this.zam = new com.google.android.gms.common.internal.zal();
        PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.zzi == null) {
            DeviceProperties.zzi = Boolean.valueOf(PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (DeviceProperties.zzi.booleanValue()) {
            this.zau = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static Status zaH(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(1, 17, "API: " + apiKey.zab.zac + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult), connectionResult.zzc, connectionResult);
    }

    public static GoogleApiManager zam(Context context) {
        GoogleApiManager googleApiManager;
        HandlerThread handlerThread;
        synchronized (zac) {
            try {
                if (zad == null) {
                    synchronized (GmsClientSupervisor.zzc) {
                        handlerThread = GmsClientSupervisor.zza;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            GmsClientSupervisor.zza = handlerThread2;
                            handlerThread2.start();
                            handlerThread = GmsClientSupervisor.zza;
                        }
                    }
                    Looper looper = handlerThread.getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = GoogleApiAvailability.zaa;
                    zad = new GoogleApiManager(applicationContext, looper);
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Status status;
        Feature[] zab2;
        boolean z;
        int r0 = message.what;
        zau zauVar = this.zat;
        ConcurrentHashMap concurrentHashMap = this.zap;
        long j = 300000;
        zabq zabqVar = null;
        switch (r0) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zag = j;
                zauVar.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    zauVar.sendMessageDelayed(zauVar.obtainMessage(12, (ApiKey) it.next()), this.zag);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it2 = ((MapCollections.KeySet) zalVar.zaa.keySet()).iterator();
                while (true) {
                    MapCollections.ArrayIterator arrayIterator = (MapCollections.ArrayIterator) it2;
                    if (arrayIterator.hasNext()) {
                        ApiKey apiKey = (ApiKey) arrayIterator.next();
                        zabq zabqVar2 = (zabq) concurrentHashMap.get(apiKey);
                        if (zabqVar2 == null) {
                            zalVar.zac(apiKey, new ConnectionResult(13), null);
                        } else {
                            Api.Client client = zabqVar2.zac;
                            if (client.isConnected()) {
                                zalVar.zac(apiKey, ConnectionResult.RESULT_SUCCESS, client.getEndpointPackageName());
                            } else {
                                GoogleApiManager googleApiManager = zabqVar2.zaa;
                                Preconditions.checkHandlerThread(googleApiManager.zat);
                                ConnectionResult connectionResult = zabqVar2.zal;
                                if (connectionResult != null) {
                                    zalVar.zac(apiKey, connectionResult, null);
                                } else {
                                    Preconditions.checkHandlerThread(googleApiManager.zat);
                                    zabqVar2.zaf.add(zalVar);
                                    zabqVar2.zao();
                                }
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : concurrentHashMap.values()) {
                    Preconditions.checkHandlerThread(zabqVar3.zaa.zat);
                    zabqVar3.zal = null;
                    zabqVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVar4 = (zabq) concurrentHashMap.get(zachVar.zac.zaf);
                if (zabqVar4 == null) {
                    zabqVar4 = zaI(zachVar.zac);
                }
                boolean requiresSignIn = zabqVar4.zac.requiresSignIn();
                zai zaiVar = zachVar.zaa;
                if (requiresSignIn && this.zao.get() != zachVar.zab) {
                    zaiVar.zad(zaa);
                    zabqVar4.zav();
                } else {
                    zabqVar4.zap(zaiVar);
                }
                return true;
            case 5:
                int r02 = message.arg1;
                ConnectionResult connectionResult2 = (ConnectionResult) message.obj;
                Iterator it3 = concurrentHashMap.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        zabq zabqVar5 = (zabq) it3.next();
                        if (zabqVar5.zah == r02) {
                            zabqVar = zabqVar5;
                        }
                    }
                }
                if (zabqVar != null) {
                    if (connectionResult2.zzb == 13) {
                        this.zal.getClass();
                        AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
                        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Error resolution was canceled by the user, original error message: ", ConnectionResult.zza(connectionResult2.zzb), ": ");
                        m.append(connectionResult2.zzd);
                        zabqVar.zaD(new Status(17, m.toString()));
                    } else {
                        zabqVar.zaD(zaH(zabqVar.zad, connectionResult2));
                    }
                } else {
                    Log.wtf("GoogleApiManager", SuggestionsAdapter$$ExternalSyntheticOutline0.m("Could not find API instance ", r02, " while trying to fail enqueued calls.").toString(), new Exception());
                }
                return true;
            case 6:
                Context context = this.zak;
                if (context.getApplicationContext() instanceof Application) {
                    Application application = (Application) context.getApplicationContext();
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    synchronized (backgroundDetector) {
                        if (!backgroundDetector.zze) {
                            application.registerActivityLifecycleCallbacks(backgroundDetector);
                            application.registerComponentCallbacks(backgroundDetector);
                            backgroundDetector.zze = true;
                        }
                    }
                    zabl zablVar = new zabl(this);
                    backgroundDetector.getClass();
                    synchronized (backgroundDetector) {
                        backgroundDetector.zzd.add(zablVar);
                    }
                    AtomicBoolean atomicBoolean2 = backgroundDetector.zzc;
                    if (!atomicBoolean2.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean2.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            backgroundDetector.zzb.set(true);
                        }
                    }
                    if (!backgroundDetector.zzb.get()) {
                        this.zag = 300000L;
                    }
                }
                return true;
            case 7:
                zaI((GoogleApi) message.obj);
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    zabq zabqVar6 = (zabq) concurrentHashMap.get(message.obj);
                    Preconditions.checkHandlerThread(zabqVar6.zaa.zat);
                    if (zabqVar6.zaj) {
                        zabqVar6.zao();
                    }
                }
                return true;
            case 10:
                ArraySet arraySet = this.zas;
                Iterator it4 = arraySet.iterator();
                while (true) {
                    MapCollections.ArrayIterator arrayIterator2 = (MapCollections.ArrayIterator) it4;
                    if (arrayIterator2.hasNext()) {
                        zabq zabqVar7 = (zabq) concurrentHashMap.remove((ApiKey) arrayIterator2.next());
                        if (zabqVar7 != null) {
                            zabqVar7.zav();
                        }
                    } else {
                        arraySet.clear();
                        return true;
                    }
                }
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    zabq zabqVar8 = (zabq) concurrentHashMap.get(message.obj);
                    GoogleApiManager googleApiManager2 = zabqVar8.zaa;
                    Preconditions.checkHandlerThread(googleApiManager2.zat);
                    boolean z2 = zabqVar8.zaj;
                    if (z2) {
                        if (z2) {
                            GoogleApiManager googleApiManager3 = zabqVar8.zaa;
                            zau zauVar2 = googleApiManager3.zat;
                            ApiKey apiKey2 = zabqVar8.zad;
                            zauVar2.removeMessages(11, apiKey2);
                            googleApiManager3.zat.removeMessages(9, apiKey2);
                            zabqVar8.zaj = false;
                        }
                        if (googleApiManager2.zal.isGooglePlayServicesAvailable(googleApiManager2.zak, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 18) {
                            status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                        } else {
                            status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                        }
                        zabqVar8.zaD(status);
                        zabqVar8.zac.disconnect("Timing out connection while resuming.");
                    }
                }
                return true;
            case 12:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaN(true);
                }
                return true;
            case 14:
                ((zaaf) message.obj).getClass();
                if (!concurrentHashMap.containsKey(null)) {
                    throw null;
                }
                ((zabq) concurrentHashMap.get(null)).zaN(false);
                throw null;
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar.zaa)) {
                    zabq zabqVar9 = (zabq) concurrentHashMap.get(zabsVar.zaa);
                    if (zabqVar9.zak.contains(zabsVar) && !zabqVar9.zaj) {
                        if (!zabqVar9.zac.isConnected()) {
                            zabqVar9.zao();
                        } else {
                            zabqVar9.zaF();
                        }
                    }
                }
                return true;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar2.zaa)) {
                    zabq zabqVar10 = (zabq) concurrentHashMap.get(zabsVar2.zaa);
                    if (zabqVar10.zak.remove(zabsVar2)) {
                        GoogleApiManager googleApiManager4 = zabqVar10.zaa;
                        googleApiManager4.zat.removeMessages(15, zabsVar2);
                        googleApiManager4.zat.removeMessages(16, zabsVar2);
                        LinkedList linkedList = zabqVar10.zab;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        Iterator it5 = linkedList.iterator();
                        while (true) {
                            boolean hasNext = it5.hasNext();
                            Feature feature = zabsVar2.zab;
                            if (hasNext) {
                                zai zaiVar2 = (zai) it5.next();
                                if ((zaiVar2 instanceof zac) && (zab2 = ((zac) zaiVar2).zab(zabqVar10)) != null) {
                                    int length = zab2.length;
                                    int r9 = 0;
                                    while (true) {
                                        if (r9 < length) {
                                            if (Objects.equal(zab2[r9], feature)) {
                                                if (r9 >= 0) {
                                                    z = true;
                                                }
                                            } else {
                                                r9++;
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                        arrayList.add(zaiVar2);
                                    }
                                }
                            } else {
                                int size = arrayList.size();
                                for (int r8 = 0; r8 < size; r8++) {
                                    zai zaiVar3 = (zai) arrayList.get(r8);
                                    linkedList.remove(zaiVar3);
                                    zaiVar3.zae(new UnsupportedApiCallException(feature));
                                }
                            }
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.zai;
                if (telemetryData != null) {
                    if (telemetryData.zaa > 0 || zaF()) {
                        if (this.zaj == null) {
                            this.zaj = new com.google.android.gms.common.internal.service.zao(this.zak);
                        }
                        this.zaj.log(telemetryData);
                    }
                    this.zai = null;
                }
                return true;
            case 18:
                zace zaceVar = (zace) message.obj;
                long j2 = zaceVar.zac;
                MethodInvocation methodInvocation = zaceVar.zaa;
                int r3 = zaceVar.zab;
                if (j2 == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(r3, Arrays.asList(methodInvocation));
                    if (this.zaj == null) {
                        this.zaj = new com.google.android.gms.common.internal.service.zao(this.zak);
                    }
                    this.zaj.log(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.zai;
                    if (telemetryData3 != null) {
                        List list = telemetryData3.zab;
                        if (telemetryData3.zaa == r3 && (list == null || list.size() < zaceVar.zad)) {
                            TelemetryData telemetryData4 = this.zai;
                            if (telemetryData4.zab == null) {
                                telemetryData4.zab = new ArrayList();
                            }
                            telemetryData4.zab.add(methodInvocation);
                        } else {
                            zauVar.removeMessages(17);
                            TelemetryData telemetryData5 = this.zai;
                            if (telemetryData5 != null) {
                                if (telemetryData5.zaa > 0 || zaF()) {
                                    if (this.zaj == null) {
                                        this.zaj = new com.google.android.gms.common.internal.service.zao(this.zak);
                                    }
                                    this.zaj.log(telemetryData5);
                                }
                                this.zai = null;
                            }
                        }
                    }
                    if (this.zai == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(methodInvocation);
                        this.zai = new TelemetryData(r3, arrayList2);
                        zauVar.sendMessageDelayed(zauVar.obtainMessage(17), zaceVar.zac);
                    }
                }
                return true;
            case 19:
                this.zah = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + r0);
                return false;
        }
    }

    public final boolean zaF() {
        if (this.zah) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().zzc;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.zzb) {
            return false;
        }
        int r0 = this.zam.zaa.get(203400000, -1);
        if (r0 != -1 && r0 != 0) {
            return false;
        }
        return true;
    }

    public final boolean zaG(ConnectionResult connectionResult, int r9) {
        boolean z;
        PendingIntent pendingIntent;
        GoogleApiAvailability googleApiAvailability = this.zal;
        googleApiAvailability.getClass();
        Context context = this.zak;
        if (InstantApps.isInstantApp(context)) {
            return false;
        }
        int r2 = connectionResult.zzb;
        if (r2 != 0 && connectionResult.zzc != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            pendingIntent = connectionResult.zzc;
        } else {
            pendingIntent = null;
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(r2, context, null);
            if (errorResolutionIntent != null) {
                pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592);
            }
        }
        if (pendingIntent == null) {
            return false;
        }
        int r5 = GoogleApiActivity.$r8$clinit;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", r9);
        intent.putExtra("notify_manager", true);
        googleApiAvailability.zae(context, r2, PendingIntent.getActivity(context, 0, intent, com.google.android.gms.internal.base.zap.zaa | 134217728));
        return true;
    }

    public final zabq zaI(GoogleApi googleApi) {
        ApiKey apiKey = googleApi.zaf;
        ConcurrentHashMap concurrentHashMap = this.zap;
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zac.requiresSignIn()) {
            this.zas.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zaL(com.google.android.gms.tasks.TaskCompletionSource r9, int r10, com.google.android.gms.common.api.GoogleApi r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L7a
            com.google.android.gms.common.api.internal.ApiKey r3 = r11.zaf
            boolean r11 = r8.zaF()
            if (r11 != 0) goto Lb
            goto L41
        Lb:
            com.google.android.gms.common.internal.RootTelemetryConfigManager r11 = com.google.android.gms.common.internal.RootTelemetryConfigManager.getInstance()
            com.google.android.gms.common.internal.RootTelemetryConfiguration r11 = r11.zzc
            r0 = 1
            if (r11 == 0) goto L4d
            boolean r1 = r11.zzb
            if (r1 != 0) goto L19
            goto L41
        L19:
            java.util.concurrent.ConcurrentHashMap r1 = r8.zap
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.common.api.internal.zabq r1 = (com.google.android.gms.common.api.internal.zabq) r1
            if (r1 == 0) goto L4b
            com.google.android.gms.common.api.Api$Client r2 = r1.zac
            boolean r4 = r2 instanceof com.google.android.gms.common.internal.BaseGmsClient
            if (r4 != 0) goto L2a
            goto L41
        L2a:
            com.google.android.gms.common.internal.BaseGmsClient r2 = (com.google.android.gms.common.internal.BaseGmsClient) r2
            com.google.android.gms.common.internal.zzj r4 = r2.zzD
            if (r4 == 0) goto L32
            r4 = r0
            goto L33
        L32:
            r4 = 0
        L33:
            if (r4 == 0) goto L4b
            boolean r4 = r2.isConnecting()
            if (r4 != 0) goto L4b
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r11 = com.google.android.gms.common.api.internal.zacd.zab(r1, r2, r10)
            if (r11 != 0) goto L43
        L41:
            r10 = 0
            goto L69
        L43:
            int r2 = r1.zam
            int r2 = r2 + r0
            r1.zam = r2
            boolean r0 = r11.zzc
            goto L4d
        L4b:
            boolean r0 = r11.zzc
        L4d:
            com.google.android.gms.common.api.internal.zacd r11 = new com.google.android.gms.common.api.internal.zacd
            r1 = 0
            if (r0 == 0) goto L58
            long r4 = java.lang.System.currentTimeMillis()
            goto L59
        L58:
            r4 = r1
        L59:
            if (r0 == 0) goto L61
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6 = r0
            goto L62
        L61:
            r6 = r1
        L62:
            r0 = r11
            r1 = r8
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r6)
            r10 = r11
        L69:
            if (r10 == 0) goto L7a
            com.google.android.gms.tasks.zzw r9 = r9.zza
            com.google.android.gms.internal.base.zau r11 = r8.zat
            r11.getClass()
            com.google.android.gms.common.api.internal.zabk r0 = new com.google.android.gms.common.api.internal.zabk
            r0.<init>()
            r9.addOnCompleteListener(r0, r10)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.GoogleApiManager.zaL(com.google.android.gms.tasks.TaskCompletionSource, int, com.google.android.gms.common.api.GoogleApi):void");
    }

    public final void zaz(ConnectionResult connectionResult, int r5) {
        if (!zaG(connectionResult, r5)) {
            zau zauVar = this.zat;
            zauVar.sendMessage(zauVar.obtainMessage(5, r5, 0, connectionResult));
        }
    }
}
