package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.zaa;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzah extends DeferredLifecycleHelper {
    public zaa zza;
    public final ViewGroup zzb;
    public final Context zzc;
    public final GoogleMapOptions zzd;
    public final ArrayList zze = new ArrayList();

    public zzah(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.zzb = viewGroup;
        this.zzc = context;
        this.zzd = googleMapOptions;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void createDelegate(zaa zaaVar) {
        this.zza = zaaVar;
        Context context = this.zzc;
        if (zaaVar != null && this.zaa == null) {
            try {
                try {
                    boolean z = MapsInitializer.zzb;
                    synchronized (MapsInitializer.class) {
                        MapsInitializer.initialize(context);
                    }
                    IMapViewDelegate zzg = zzcb.zza(context).zzg(new ObjectWrapper(context), this.zzd);
                    if (zzg != null) {
                        this.zza.onDelegateCreated(new zzag(this.zzb, zzg));
                        ArrayList arrayList = this.zze;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            OnMapReadyCallback onMapReadyCallback = (OnMapReadyCallback) it.next();
                            zzag zzagVar = (zzag) this.zaa;
                            zzagVar.getClass();
                            try {
                                zzagVar.zzb.getMapAsync(new zzaf(onMapReadyCallback));
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                        arrayList.clear();
                    }
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }
}
