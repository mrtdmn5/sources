package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabn implements Runnable {
    public final /* synthetic */ int zaa;
    public final /* synthetic */ zabq zab;

    public zabn(zabq zabqVar, int r2) {
        this.zab = zabqVar;
        this.zaa = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaH(this.zaa);
    }
}
