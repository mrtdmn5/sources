package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzv extends zzx {
    public final Callable zze;

    public /* synthetic */ zzv(zze zzeVar) {
        super(false, null, null);
        this.zze = zzeVar;
    }

    @Override // com.google.android.gms.common.zzx
    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
