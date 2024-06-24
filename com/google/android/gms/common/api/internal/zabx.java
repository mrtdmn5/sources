package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabx extends BroadcastReceiver {
    public Context zaa;
    public final zan zab;

    public zabx(zan zanVar) {
        this.zab = zanVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if (!"com.google.android.gms".equals(str)) {
            return;
        }
        ((zao) this.zab.zab).getClass();
        throw null;
    }
}
