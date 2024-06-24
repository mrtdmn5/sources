package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zabo;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.internal.auth.zzbe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final Feature[] zze = new Feature[0];
    public volatile String zzA;
    public zzu zza;
    public final zzb zzb;
    public ConnectionProgressReportCallbacks zzc;
    public final Context zzl;
    public final GmsClientSupervisor zzn;
    public final GoogleApiAvailabilityLight zzo;
    public IGmsServiceBroker zzr;
    public IInterface zzs;
    public zze zzu;
    public final BaseConnectionCallbacks zzw;
    public final BaseOnConnectionFailedListener zzx;
    public final int zzy;
    public final String zzz;
    public volatile String zzk = null;
    public final Object zzp = new Object();
    public final Object zzq = new Object();
    public final ArrayList zzt = new ArrayList();
    public int zzv = 1;
    public ConnectionResult zzB = null;
    public boolean zzC = false;
    public volatile zzj zzD = null;
    public final AtomicInteger zzd = new AtomicInteger(0);

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface BaseConnectionCallbacks {
        void onConnected();

        void onConnectionSuspended(int r1);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            boolean isSuccess = connectionResult.isSuccess();
            BaseGmsClient baseGmsClient = BaseGmsClient.this;
            if (isSuccess) {
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
                return;
            }
            BaseOnConnectionFailedListener baseOnConnectionFailedListener = baseGmsClient.zzx;
            if (baseOnConnectionFailedListener != null) {
                baseOnConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public BaseGmsClient(Context context, Looper looper, zzr zzrVar, GoogleApiAvailabilityLight googleApiAvailabilityLight, int r7, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        if (context != null) {
            this.zzl = context;
            if (looper != null) {
                if (zzrVar != null) {
                    this.zzn = zzrVar;
                    Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
                    this.zzo = googleApiAvailabilityLight;
                    this.zzb = new zzb(this, looper);
                    this.zzy = r7;
                    this.zzw = baseConnectionCallbacks;
                    this.zzx = baseOnConnectionFailedListener;
                    this.zzz = str;
                    return;
                }
                throw new NullPointerException("Supervisor must not be null");
            }
            throw new NullPointerException("Looper must not be null");
        }
        throw new NullPointerException("Context must not be null");
    }

    public static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int r3, int r4, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            if (baseGmsClient.zzv != r3) {
                return false;
            }
            baseGmsClient.zzp(r4, iInterface);
            return true;
        }
    }

    public final void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zzp(1, null);
            this.zzc = new LegacyClientCallbackAdapter();
            int r1 = this.zzd.get();
            zzb zzbVar = this.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(3, r1, isGooglePlayServicesAvailable, null));
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    public final void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    public abstract T createServiceInterface(IBinder iBinder);

    public final void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int r2 = 0; r2 < size; r2++) {
                    zzc zzcVar = (zzc) this.zzt.get(r2);
                    synchronized (zzcVar) {
                        zzcVar.zza = null;
                    }
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzj zzjVar = this.zzD;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.zzb;
    }

    public final String getEndpointPackageName() {
        if (isConnected() && this.zza != null) {
            return "com.google.android.gms";
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public final String getLastDisconnectMessage() {
        return this.zzk;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int r5 = this.zzy;
        String str = this.zzA;
        int r6 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, r5, r6, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzj = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzj = getAccount();
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzo = true;
        }
        try {
            synchronized (this.zzq) {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zzb zzbVar = this.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(6, this.zzd.get(), 3));
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int r0 = this.zzd.get();
            zzf zzfVar = new zzf(this, 8, null, null);
            zzb zzbVar2 = this.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(1, r0, -1, zzfVar));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int r02 = this.zzd.get();
            zzf zzfVar2 = new zzf(this, 8, null, null);
            zzb zzbVar22 = this.zzb;
            zzbVar22.sendMessage(zzbVar22.obtainMessage(1, r02, -1, zzfVar2));
        }
    }

    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            try {
                if (this.zzv != 5) {
                    if (isConnected()) {
                        t = (T) this.zzs;
                        Preconditions.checkNotNull(t, "Client is connected but service is null");
                    } else {
                        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                    }
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public abstract String getServiceDescriptor();

    public abstract String getStartServiceAction();

    public boolean getUseDynamicLookup() {
        if (getMinApkVersion() >= 211700000) {
            return true;
        }
        return false;
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            if (this.zzv == 4) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int r1 = this.zzv;
            z = true;
            if (r1 != 2 && r1 != 3) {
                z = false;
            }
        }
        return z;
    }

    public void onConnectionSuspended() {
        System.currentTimeMillis();
    }

    public final void onUserSignOut(zabp zabpVar) {
        zabpVar.zaa.zaa.zat.post(new zabo(zabpVar));
    }

    public boolean requiresAccount() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public boolean usesClientTelemetry() {
        return this instanceof zzbe;
    }

    public final void zzp(int r18, IInterface iInterface) {
        boolean z;
        boolean z2;
        zzu zzuVar;
        boolean z3 = false;
        if (r18 != 4) {
            z = false;
        } else {
            z = true;
        }
        if (iInterface == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z == z2) {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        synchronized (this.zzp) {
            try {
                this.zzv = r18;
                this.zzs = iInterface;
                if (r18 != 1) {
                    if (r18 != 2 && r18 != 3) {
                        if (r18 == 4) {
                            Preconditions.checkNotNull(iInterface);
                            System.currentTimeMillis();
                        }
                    } else {
                        zze zzeVar = this.zzu;
                        if (zzeVar != null && (zzuVar = this.zza) != null) {
                            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzuVar.zza + " on com.google.android.gms");
                            GmsClientSupervisor gmsClientSupervisor = this.zzn;
                            String str = this.zza.zza;
                            Preconditions.checkNotNull(str);
                            this.zza.getClass();
                            if (this.zzz == null) {
                                this.zzl.getClass();
                            }
                            gmsClientSupervisor.zzb(str, "com.google.android.gms", 4225, zzeVar, this.zza.zzd);
                            this.zzd.incrementAndGet();
                        }
                        zze zzeVar2 = new zze(this, this.zzd.get());
                        this.zzu = zzeVar2;
                        String startServiceAction = getStartServiceAction();
                        Object obj = GmsClientSupervisor.zzc;
                        boolean useDynamicLookup = getUseDynamicLookup();
                        this.zza = new zzu(startServiceAction, useDynamicLookup);
                        if (useDynamicLookup && getMinApkVersion() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zza)));
                        }
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String str2 = this.zza.zza;
                        Preconditions.checkNotNull(str2);
                        this.zza.getClass();
                        String str3 = this.zzz;
                        if (str3 == null) {
                            str3 = this.zzl.getClass().getName();
                        }
                        boolean z4 = this.zza.zzd;
                        getBindServiceExecutor();
                        if (!gmsClientSupervisor2.zzc(new zzn(str2, 4225, "com.google.android.gms", z4), zzeVar2, str3, null)) {
                            Log.w("GmsClient", "unable to connect to service: " + this.zza.zza + " on com.google.android.gms");
                            int r0 = this.zzd.get();
                            zzg zzgVar = new zzg(this, 16);
                            zzb zzbVar = this.zzb;
                            zzbVar.sendMessage(zzbVar.obtainMessage(7, r0, -1, zzgVar));
                        }
                    }
                } else {
                    zze zzeVar3 = this.zzu;
                    if (zzeVar3 != null) {
                        GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                        String str4 = this.zza.zza;
                        Preconditions.checkNotNull(str4);
                        this.zza.getClass();
                        if (this.zzz == null) {
                            this.zzl.getClass();
                        }
                        gmsClientSupervisor3.zzb(str4, "com.google.android.gms", 4225, zzeVar3, this.zza.zzd);
                        this.zzu = null;
                    }
                }
            } finally {
            }
        }
    }

    public final void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void getBindServiceExecutor() {
    }
}
