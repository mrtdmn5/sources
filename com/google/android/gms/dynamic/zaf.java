package com.google.android.gms.dynamic;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zaf implements zah {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 4;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        this.zaa.zaa.onStart();
    }
}
