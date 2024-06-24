package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public class AvailabilityException extends Exception {
    public final ArrayMap zaa;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = this.zaa;
        Iterator it = ((MapCollections.KeySet) arrayMap.keySet()).iterator();
        boolean z = true;
        while (true) {
            MapCollections.ArrayIterator arrayIterator = (MapCollections.ArrayIterator) it;
            if (!arrayIterator.hasNext()) {
                break;
            }
            ApiKey apiKey = (ApiKey) arrayIterator.next();
            ConnectionResult connectionResult = (ConnectionResult) arrayMap.getOrDefault(apiKey, null);
            Preconditions.checkNotNull(connectionResult);
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zab.zac + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}
