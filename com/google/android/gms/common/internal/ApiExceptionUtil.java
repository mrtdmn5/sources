package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class ApiExceptionUtil {
    public static ApiException fromStatus(Status status) {
        boolean z;
        if (status.zze != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
