package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods$Builder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zaci;
import com.google.android.gms.common.api.internal.zack;
import com.google.android.gms.common.api.internal.zacl;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.api.internal.zaf;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzbp extends GoogleApi implements FusedLocationProviderClient {
    public static final Api zzb = new Api("LocationServices.API", new zzbm(), new Api.ClientKey());

    public zzbp(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final zzw getLastLocation() {
        TaskApiCall.Builder builder = new TaskApiCall.Builder();
        builder.zaa = zzbe.zza;
        builder.zad = 2414;
        return zae(0, new zacv(builder, builder.zac, builder.zab, builder.zad));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        Preconditions.checkNotEmpty("Listener type must not be empty", "LocationCallback");
        return doUnregisterEventListener(new ListenerHolder.ListenerKey(locationCallback), 2418).continueWith(zzbk.zza, zzbc.zza);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final zzw requestLocationUpdates(final LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        ListenerHolder listenerHolder = new ListenerHolder(looper, locationCallback);
        final zzbo zzboVar = new zzbo(this, listenerHolder);
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.internal.location.zzay
            /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: all -> 0x00db, TryCatch #1 {, blocks: (B:9:0x0025, B:13:0x0033, B:14:0x0037, B:20:0x0042, B:22:0x0054, B:24:0x0072, B:27:0x007f, B:28:0x00d9, B:32:0x0094, B:34:0x00a5, B:35:0x00a7, B:37:0x0047, B:38:0x0048, B:39:0x0049, B:16:0x0038, B:18:0x003c), top: B:8:0x0025, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0094 A[Catch: all -> 0x00db, TryCatch #1 {, blocks: (B:9:0x0025, B:13:0x0033, B:14:0x0037, B:20:0x0042, B:22:0x0054, B:24:0x0072, B:27:0x007f, B:28:0x00d9, B:32:0x0094, B:34:0x00a5, B:35:0x00a7, B:37:0x0047, B:38:0x0048, B:39:0x0049, B:16:0x0038, B:18:0x003c), top: B:8:0x0025, inners: #0 }] */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void accept(com.google.android.gms.common.api.Api.Client r31, java.lang.Object r32) {
                /*
                    Method dump skipped, instructions count: 226
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzay.accept(com.google.android.gms.common.api.Api$Client, java.lang.Object):void");
            }
        };
        RegistrationMethods$Builder registrationMethods$Builder = new RegistrationMethods$Builder();
        registrationMethods$Builder.zaa = remoteCall;
        registrationMethods$Builder.zab = zzboVar;
        registrationMethods$Builder.zad = listenerHolder;
        registrationMethods$Builder.zag = 2436;
        ListenerHolder.ListenerKey listenerKey = registrationMethods$Builder.zad.zac;
        Preconditions.checkNotNull(listenerKey, "Key must not be null");
        ListenerHolder listenerHolder2 = registrationMethods$Builder.zad;
        int r1 = registrationMethods$Builder.zag;
        zack zackVar = new zack(registrationMethods$Builder, listenerHolder2, r1);
        zacl zaclVar = new zacl(registrationMethods$Builder, listenerKey);
        Preconditions.checkNotNull(listenerHolder2.zac, "Listener has already been released.");
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        googleApiManager.zaL(taskCompletionSource, r1, this);
        zaf zafVar = new zaf(new zaci(zackVar, zaclVar), taskCompletionSource);
        zau zauVar = googleApiManager.zat;
        zauVar.sendMessage(zauVar.obtainMessage(8, new zach(zafVar, googleApiManager.zao.get(), this)));
        return taskCompletionSource.zza;
    }
}
