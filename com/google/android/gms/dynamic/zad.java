package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.zzav;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zad implements zah {
    public final /* synthetic */ FrameLayout zaa;
    public final /* synthetic */ LayoutInflater zab;
    public final /* synthetic */ ViewGroup zac;
    public final /* synthetic */ Bundle zad;
    public final /* synthetic */ DeferredLifecycleHelper zae;

    public zad(zzav zzavVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zae = zzavVar;
        this.zaa = frameLayout;
        this.zab = layoutInflater;
        this.zac = viewGroup;
        this.zad = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        FrameLayout frameLayout = this.zaa;
        frameLayout.removeAllViews();
        frameLayout.addView(this.zae.zaa.onCreateView(this.zab, this.zac, this.zad));
    }
}
