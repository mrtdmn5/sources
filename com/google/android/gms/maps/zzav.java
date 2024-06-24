package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.zaa;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzav extends DeferredLifecycleHelper {
    public zaa zza;
    public final Fragment zzb;
    public Activity zzc;
    public final ArrayList zzd = new ArrayList();

    public zzav(Fragment fragment) {
        this.zzb = fragment;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void createDelegate(zaa zaaVar) {
        this.zza = zaaVar;
        zzc();
    }

    public final void zzc() {
        Activity activity = this.zzc;
        if (activity != null && this.zza != null && this.zaa == null) {
            try {
                try {
                    boolean z = MapsInitializer.zzb;
                    synchronized (MapsInitializer.class) {
                        MapsInitializer.initialize(activity);
                    }
                    IMapFragmentDelegate zzf = zzcb.zza(this.zzc).zzf(new ObjectWrapper(this.zzc));
                    if (zzf == null) {
                        return;
                    }
                    this.zza.onDelegateCreated(new zzau(this.zzb, zzf));
                    ArrayList arrayList = this.zzd;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        OnMapReadyCallback onMapReadyCallback = (OnMapReadyCallback) it.next();
                        zzau zzauVar = (zzau) this.zaa;
                        zzauVar.getClass();
                        try {
                            zzauVar.zzb.getMapAsync(new zzat(onMapReadyCallback));
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                    arrayList.clear();
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }
}
