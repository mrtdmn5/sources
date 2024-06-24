package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlh {
    public static final void zza(Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        if (!zzlgVar.isEmpty()) {
            Iterator it = zzlgVar.entrySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }

    public static final zzlg zzb(Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        zzlg zzlgVar2 = (zzlg) obj2;
        if (!zzlgVar2.isEmpty()) {
            if (!zzlgVar.zzb) {
                zzlgVar = zzlgVar.zzb();
            }
            zzlgVar.zzg();
            if (!zzlgVar2.isEmpty()) {
                zzlgVar.putAll(zzlgVar2);
            }
        }
        return zzlgVar;
    }
}
