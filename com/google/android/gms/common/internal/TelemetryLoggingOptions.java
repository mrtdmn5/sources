package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class TelemetryLoggingOptions implements Api.ApiOptions {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions();
    public final String zab = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zab});
    }
}
