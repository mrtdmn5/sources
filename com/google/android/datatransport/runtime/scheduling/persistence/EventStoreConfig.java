package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class EventStoreConfig {
    public static final AutoValue_EventStoreConfig DEFAULT;

    static {
        String str;
        Long l = 10485760L;
        Integer num = 200;
        Integer valueOf = Integer.valueOf(Constants.MAXIMUM_UPLOAD_PARTS);
        Long l2 = 604800000L;
        Integer num2 = 81920;
        if (l == null) {
            str = " maxStorageSizeInBytes";
        } else {
            str = "";
        }
        if (num == null) {
            str = str.concat(" loadBatchSize");
        }
        if (valueOf == null) {
            str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " eventCleanUpAge");
        }
        if (num2 == null) {
            str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " maxBlobByteSizePerRow");
        }
        if (str.isEmpty()) {
            DEFAULT = new AutoValue_EventStoreConfig(l.longValue(), num.intValue(), valueOf.intValue(), l2.longValue(), num2.intValue());
            return;
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public abstract int getCriticalSectionEnterTimeoutMs();

    public abstract long getEventCleanUpAge();

    public abstract int getLoadBatchSize();

    public abstract int getMaxBlobByteSizePerRow();

    public abstract long getMaxStorageSizeInBytes();
}
