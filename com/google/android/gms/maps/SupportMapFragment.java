package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zab;
import com.google.android.gms.dynamic.zac;
import com.google.android.gms.dynamic.zad;
import com.google.android.gms.dynamic.zaf;
import com.google.android.gms.dynamic.zag;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public class SupportMapFragment extends Fragment {
    public final zzav zza = new zzav(this);

    public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        Preconditions.checkMainThread("getMapAsync must be called on the main thread.");
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            try {
                ((zzau) lifecycleDelegate).zzb.getMapAsync(new zzat(onMapReadyCallback));
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        zzavVar.zzd.add(onMapReadyCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        zzav zzavVar = this.zza;
        zzavVar.zzc = activity;
        zzavVar.zzc();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onCreate(bundle);
            zzav zzavVar = this.zza;
            zzavVar.getClass();
            zzavVar.zaf(bundle, new zac(zzavVar, bundle));
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        zzav zzavVar = this.zza;
        zzavVar.getClass();
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zzavVar.zaf(bundle, new zad(zzavVar, frameLayout, layoutInflater, viewGroup, bundle));
        if (zzavVar.zaa == null) {
            DeferredLifecycleHelper.showGooglePlayUnavailableMessage(frameLayout);
        }
        frameLayout.setClickable(true);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            zzavVar.zae(1);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroyView();
        } else {
            zzavVar.zae(2);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        zzav zzavVar = this.zza;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzavVar.zzc = activity;
            zzavVar.zzc();
            GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", createFromAttributes);
            zzavVar.zaf(bundle, new zab(zzavVar, activity, bundle2, bundle));
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.zza.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            zzavVar.zae(5);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        zzav zzavVar = this.zza;
        zzavVar.getClass();
        zzavVar.zaf(null, new zag(zzavVar));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = zzavVar.zab;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        zzav zzavVar = this.zza;
        zzavVar.getClass();
        zzavVar.zaf(null, new zaf(zzavVar));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        zzav zzavVar = this.zza;
        LifecycleDelegate lifecycleDelegate = zzavVar.zaa;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
        } else {
            zzavVar.zae(4);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public final void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
