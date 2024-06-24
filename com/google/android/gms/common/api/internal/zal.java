package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zal {
    public int zad;
    public final ArrayMap zab = new ArrayMap();
    public final TaskCompletionSource zac = new TaskCompletionSource();
    public boolean zae = false;
    public final ArrayMap zaa = new ArrayMap();

    public zal(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zaa.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.zad = ((MapCollections.KeySet) this.zaa.keySet()).size();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, String str) {
        ArrayMap arrayMap = this.zaa;
        arrayMap.put(apiKey, connectionResult);
        ArrayMap arrayMap2 = this.zab;
        arrayMap2.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad == 0) {
            boolean z = this.zae;
            TaskCompletionSource taskCompletionSource = this.zac;
            if (z) {
                taskCompletionSource.setException(new AvailabilityException(arrayMap));
            } else {
                taskCompletionSource.setResult(arrayMap2);
            }
        }
    }
}
