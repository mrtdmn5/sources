package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ GoogleApiManager zaa;

    @NotOnlyInitialized
    public final Api.Client zac;
    public final ApiKey zad;
    public final zaad zae;
    public final int zah;
    public final zact zai;
    public boolean zaj;
    public final LinkedList zab = new LinkedList();
    public final HashSet zaf = new HashSet();
    public final HashMap zag = new HashMap();
    public final ArrayList zak = new ArrayList();
    public ConnectionResult zal = null;
    public int zam = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Looper looper = googleApiManager.zat.getLooper();
        ClientSettings.Builder createClientSettingsBuilder = googleApi.createClientSettingsBuilder();
        ClientSettings clientSettings = new ClientSettings(createClientSettingsBuilder.zaa, createClientSettingsBuilder.zab, createClientSettingsBuilder.zac, createClientSettingsBuilder.zad);
        Api.AbstractClientBuilder abstractClientBuilder = googleApi.zad.zaa;
        Preconditions.checkNotNull(abstractClientBuilder);
        Api.Client buildClient = abstractClientBuilder.buildClient(googleApi.zab, looper, clientSettings, googleApi.zae, (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        String str = googleApi.zac;
        if (str != null && (buildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) buildClient).zzA = str;
        }
        if (str != null && (buildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) buildClient).getClass();
        }
        this.zac = buildClient;
        this.zad = googleApi.zaf;
        this.zae = new zaad();
        this.zah = googleApi.zah;
        if (buildClient.requiresSignIn()) {
            Context context = googleApiManager.zak;
            zau zauVar = googleApiManager.zat;
            ClientSettings.Builder createClientSettingsBuilder2 = googleApi.createClientSettingsBuilder();
            this.zai = new zact(context, zauVar, new ClientSettings(createClientSettingsBuilder2.zaa, createClientSettingsBuilder2.zab, createClientSettingsBuilder2.zac, createClientSettingsBuilder2.zad));
            return;
        }
        this.zai = null;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected() {
        Looper myLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.zaa;
        if (myLooper == googleApiManager.zat.getLooper()) {
            zaG();
        } else {
            googleApiManager.zat.post(new zabm(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int r4) {
        Looper myLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.zaa;
        if (myLooper == googleApiManager.zat.getLooper()) {
            zaH(r4);
        } else {
            googleApiManager.zat.post(new zabn(this, r4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Feature zaB(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.zza, Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.getOrDefault(feature2.zza, null);
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void zaC(ConnectionResult connectionResult) {
        String str;
        HashSet hashSet = this.zaf;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            zal zalVar = (zal) it.next();
            if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                str = this.zac.getEndpointPackageName();
            } else {
                str = null;
            }
            zalVar.zac(this.zad, connectionResult, str);
        }
        hashSet.clear();
    }

    public final void zaD(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zaE(status, null, false);
    }

    public final void zaE(Status status, RuntimeException runtimeException, boolean z) {
        boolean z2;
        Preconditions.checkHandlerThread(this.zaa.zat);
        boolean z3 = false;
        if (status != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (runtimeException == null) {
            z3 = true;
        }
        if (z2 != z3) {
            Iterator it = this.zab.iterator();
            while (it.hasNext()) {
                zai zaiVar = (zai) it.next();
                if (!z || zaiVar.zac == 2) {
                    if (status != null) {
                        zaiVar.zad(status);
                    } else {
                        zaiVar.zae(runtimeException);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    public final void zaF() {
        LinkedList linkedList = this.zab;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            zai zaiVar = (zai) arrayList.get(r3);
            if (this.zac.isConnected()) {
                if (zaL(zaiVar)) {
                    linkedList.remove(zaiVar);
                }
            } else {
                return;
            }
        }
    }

    public final void zaG() {
        Api.Client client = this.zac;
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zat);
        this.zal = null;
        zaC(ConnectionResult.RESULT_SUCCESS);
        if (this.zaj) {
            zau zauVar = googleApiManager.zat;
            ApiKey apiKey = this.zad;
            zauVar.removeMessages(11, apiKey);
            googleApiManager.zat.removeMessages(9, apiKey);
            this.zaj = false;
        }
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (zaB(zaciVar.zaa.zab) != null) {
                it.remove();
            } else {
                try {
                    RegisterListenerMethod registerListenerMethod = zaciVar.zaa;
                    ((zack) registerListenerMethod).zaa.zaa.accept(client, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    client.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        zaF();
        zaI();
    }

    public final void zaH(int r7) {
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zat);
        this.zal = null;
        this.zaj = true;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        zaad zaadVar = this.zae;
        zaadVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (r7 == 1) {
            sb.append(" due to service disconnection.");
        } else if (r7 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        zaadVar.zah(true, new Status(20, sb.toString()));
        zau zauVar = googleApiManager.zat;
        ApiKey apiKey = this.zad;
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 9, apiKey), DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
        zau zauVar2 = googleApiManager.zat;
        zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 11, apiKey), 120000L);
        googleApiManager.zam.zaa.clear();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).zac.run();
        }
    }

    public final void zaI() {
        GoogleApiManager googleApiManager = this.zaa;
        zau zauVar = googleApiManager.zat;
        ApiKey apiKey = this.zad;
        zauVar.removeMessages(12, apiKey);
        zau zauVar2 = googleApiManager.zat;
        zauVar2.sendMessageDelayed(zauVar2.obtainMessage(12, apiKey), googleApiManager.zag);
    }

    public final boolean zaL(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            Api.Client client = this.zac;
            zaiVar.zag(this.zae, client.requiresSignIn());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                client.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature zaB = zaB(zacVar.zab(this));
        if (zaB == null) {
            Api.Client client2 = this.zac;
            zaiVar.zag(this.zae, client2.requiresSignIn());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                client2.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.zac.getClass().getName() + " could not execute call because it requires feature (" + zaB.zza + ", " + zaB.getVersion() + ").");
        if (this.zaa.zau && zacVar.zaa(this)) {
            zabs zabsVar = new zabs(this.zad, zaB);
            int indexOf = this.zak.indexOf(zabsVar);
            if (indexOf >= 0) {
                zabs zabsVar2 = (zabs) this.zak.get(indexOf);
                this.zaa.zat.removeMessages(15, zabsVar2);
                zau zauVar = this.zaa.zat;
                Message obtain = Message.obtain(zauVar, 15, zabsVar2);
                this.zaa.getClass();
                zauVar.sendMessageDelayed(obtain, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
                return false;
            }
            this.zak.add(zabsVar);
            zau zauVar2 = this.zaa.zat;
            Message obtain2 = Message.obtain(zauVar2, 15, zabsVar);
            this.zaa.getClass();
            zauVar2.sendMessageDelayed(obtain2, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
            zau zauVar3 = this.zaa.zat;
            Message obtain3 = Message.obtain(zauVar3, 16, zabsVar);
            this.zaa.getClass();
            zauVar3.sendMessageDelayed(obtain3, 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!zaM(connectionResult)) {
                this.zaa.zaG(connectionResult, this.zah);
                return false;
            }
            return false;
        }
        zacVar.zae(new UnsupportedApiCallException(zaB));
        return true;
    }

    public final boolean zaM(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
            this.zaa.getClass();
        }
        return false;
    }

    public final boolean zaN(boolean z) {
        boolean z2;
        Preconditions.checkHandlerThread(this.zaa.zat);
        Api.Client client = this.zac;
        if (!client.isConnected() || this.zag.size() != 0) {
            return false;
        }
        zaad zaadVar = this.zae;
        if (zaadVar.zaa.isEmpty() && zaadVar.zab.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (z) {
                zaI();
            }
            return false;
        }
        client.disconnect("Timing out service connection.");
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    public final void zao() {
        GoogleApiManager googleApiManager = this.zaa;
        Preconditions.checkHandlerThread(googleApiManager.zat);
        Api.Client client = this.zac;
        if (!client.isConnected() && !client.isConnecting()) {
            try {
                com.google.android.gms.common.internal.zal zalVar = googleApiManager.zam;
                Context context = googleApiManager.zak;
                zalVar.getClass();
                Preconditions.checkNotNull(context);
                int r6 = 0;
                if (client.requiresGooglePlayServices()) {
                    int minApkVersion = client.getMinApkVersion();
                    SparseIntArray sparseIntArray = zalVar.zaa;
                    int r9 = sparseIntArray.get(minApkVersion, -1);
                    if (r9 != -1) {
                        r6 = r9;
                    } else {
                        int r92 = 0;
                        while (true) {
                            if (r92 < sparseIntArray.size()) {
                                int keyAt = sparseIntArray.keyAt(r92);
                                if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                                    break;
                                } else {
                                    r92++;
                                }
                            } else {
                                r6 = -1;
                                break;
                            }
                        }
                        if (r6 == -1) {
                            r6 = zalVar.zab.isGooglePlayServicesAvailable(context, minApkVersion);
                        }
                        sparseIntArray.put(minApkVersion, r6);
                    }
                }
                if (r6 != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(r6, null);
                    Log.w("GoogleApiManager", "The service for " + client.getClass().getName() + " is not available: " + connectionResult.toString());
                    zar(connectionResult, null);
                    return;
                }
                zabu zabuVar = new zabu(googleApiManager, client, this.zad);
                if (client.requiresSignIn()) {
                    zact zactVar = this.zai;
                    Preconditions.checkNotNull(zactVar);
                    com.google.android.gms.signin.zae zaeVar = zactVar.zag;
                    if (zaeVar != null) {
                        zaeVar.disconnect();
                    }
                    Integer valueOf = Integer.valueOf(System.identityHashCode(zactVar));
                    ClientSettings clientSettings = zactVar.zaf;
                    clientSettings.zaj = valueOf;
                    zaa zaaVar = zactVar.zad;
                    Context context2 = zactVar.zab;
                    Handler handler = zactVar.zac;
                    zactVar.zag = zaaVar.buildClient(context2, handler.getLooper(), clientSettings, (Api.ApiOptions) clientSettings.zai, (GoogleApiClient.ConnectionCallbacks) zactVar, (GoogleApiClient.OnConnectionFailedListener) zactVar);
                    zactVar.zah = zabuVar;
                    Set set = zactVar.zae;
                    if (set != null && !set.isEmpty()) {
                        zactVar.zag.zab();
                    } else {
                        handler.post(new zacq(zactVar));
                    }
                }
                try {
                    client.connect(zabuVar);
                } catch (SecurityException e) {
                    zar(new ConnectionResult(10), e);
                }
            } catch (IllegalStateException e2) {
                zar(new ConnectionResult(10), e2);
            }
        }
    }

    public final void zap(zai zaiVar) {
        boolean z;
        Preconditions.checkHandlerThread(this.zaa.zat);
        boolean isConnected = this.zac.isConnected();
        LinkedList linkedList = this.zab;
        if (isConnected) {
            if (zaL(zaiVar)) {
                zaI();
                return;
            } else {
                linkedList.add(zaiVar);
                return;
            }
        }
        linkedList.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult != null) {
            if (connectionResult.zzb != 0 && connectionResult.zzc != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zar(connectionResult, null);
                return;
            }
        }
        zao();
    }

    public final void zar(ConnectionResult connectionResult, RuntimeException runtimeException) {
        com.google.android.gms.signin.zae zaeVar;
        Preconditions.checkHandlerThread(this.zaa.zat);
        zact zactVar = this.zai;
        if (zactVar != null && (zaeVar = zactVar.zag) != null) {
            zaeVar.disconnect();
        }
        Preconditions.checkHandlerThread(this.zaa.zat);
        this.zal = null;
        this.zaa.zam.zaa.clear();
        zaC(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zah = true;
            zau zauVar = googleApiManager.zat;
            zauVar.sendMessageDelayed(zauVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.zzb == 4) {
            zaD(GoogleApiManager.zab);
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (runtimeException != null) {
            Preconditions.checkHandlerThread(this.zaa.zat);
            zaE(null, runtimeException, false);
            return;
        }
        if (this.zaa.zau) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult), null, true);
            if (!this.zab.isEmpty() && !zaM(connectionResult) && !this.zaa.zaG(connectionResult, this.zah)) {
                if (connectionResult.zzb == 18) {
                    this.zaj = true;
                }
                if (this.zaj) {
                    zau zauVar2 = this.zaa.zat;
                    Message obtain = Message.obtain(zauVar2, 9, this.zad);
                    this.zaa.getClass();
                    zauVar2.sendMessageDelayed(obtain, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
                    return;
                }
                zaD(GoogleApiManager.zaH(this.zad, connectionResult));
                return;
            }
            return;
        }
        zaD(GoogleApiManager.zaH(this.zad, connectionResult));
    }

    public final void zav() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        Status status = GoogleApiManager.zaa;
        zaD(status);
        zaad zaadVar = this.zae;
        zaadVar.getClass();
        zaadVar.zah(false, status);
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaC(new ConnectionResult(4));
        Api.Client client = this.zac;
        if (client.isConnected()) {
            client.onUserSignOut(new zabp(this));
        }
    }
}
