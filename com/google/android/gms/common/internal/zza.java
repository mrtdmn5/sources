package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zza extends zzc {
    public final int zza;
    public final Bundle zzb;
    public final /* synthetic */ BaseGmsClient zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zza(BaseGmsClient baseGmsClient, int r3, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.zzc = baseGmsClient;
        this.zza = r3;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    public final /* bridge */ /* synthetic */ void zza() {
        BaseGmsClient baseGmsClient = this.zzc;
        PendingIntent pendingIntent = null;
        int r3 = this.zza;
        if (r3 == 0) {
            if (!zzd()) {
                baseGmsClient.zzp(1, null);
                zzb(new ConnectionResult(8, null));
                return;
            }
            return;
        }
        baseGmsClient.zzp(1, null);
        Bundle bundle = this.zzb;
        if (bundle != null) {
            pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
        }
        zzb(new ConnectionResult(r3, pendingIntent));
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();

    @Override // com.google.android.gms.common.internal.zzc
    public final void zzc() {
    }
}
