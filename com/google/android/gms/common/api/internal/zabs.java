package com.google.android.gms.common.api.internal;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (Objects.equal(this.zaa, zabsVar.zaa) && Objects.equal(this.zab, zabsVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.zaa, TransferTable.COLUMN_KEY);
        toStringHelper.add(this.zab, AnalyticsConstants.KEY_FEATURE);
        return toStringHelper.toString();
    }
}
