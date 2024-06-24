package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzep extends BroadcastReceiver {
    public final zzkt zzb;
    public boolean zzc;
    public boolean zzd;

    public zzep(zzkt zzktVar) {
        this.zzb = zzktVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzkt zzktVar = this.zzb;
        zzktVar.zzB$1();
        String action = intent.getAction();
        zzktVar.zzay().zzl.zzb(action, "NetworkBroadcastReceiver received action");
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            zzen zzenVar = zzktVar.zzd;
            zzkt.zzal(zzenVar);
            boolean zza = zzenVar.zza();
            if (this.zzd != zza) {
                this.zzd = zza;
                zzktVar.zzaz().zzp(new zzeo(this, zza));
                return;
            }
            return;
        }
        zzktVar.zzay().zzg.zzb(action, "NetworkBroadcastReceiver received unknown action");
    }

    public final void zzc() {
        zzkt zzktVar = this.zzb;
        zzktVar.zzB$1();
        zzktVar.zzaz().zzg();
        zzktVar.zzaz().zzg();
        if (this.zzc) {
            zzktVar.zzay().zzl.zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                zzktVar.zzn.zze.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzktVar.zzay().zzd.zzb(e, "Failed to unregister the network broadcast receiver");
            }
        }
    }
}
