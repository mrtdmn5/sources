package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.zzav;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zab implements zah {
    public final /* synthetic */ Activity zaa;
    public final /* synthetic */ Bundle zab;
    public final /* synthetic */ Bundle zac;
    public final /* synthetic */ DeferredLifecycleHelper zad;

    public zab(zzav zzavVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.zad = zzavVar;
        this.zaa = activity;
        this.zab = bundle;
        this.zac = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 0;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        this.zad.zaa.onInflate(this.zaa, this.zab, this.zac);
    }
}
