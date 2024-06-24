package com.google.android.gms.internal.measurement;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzic {
    public static final ArrayMap zza = new ArrayMap();

    public static synchronized void zzc() {
        synchronized (zzic.class) {
            ArrayMap arrayMap = zza;
            Iterator it = ((MapCollections.ValuesCollection) arrayMap.values()).iterator();
            if (!it.hasNext()) {
                arrayMap.clear();
            } else {
                ((zzic) it.next()).getClass();
                throw null;
            }
        }
    }
}
