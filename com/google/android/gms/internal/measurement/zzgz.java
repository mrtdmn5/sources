package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgz extends ContentObserver {
    public zzgz() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzha.zzk.set(true);
    }
}
