package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhm extends ContentObserver {
    public zzhm() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzib.zzi.incrementAndGet();
    }
}
