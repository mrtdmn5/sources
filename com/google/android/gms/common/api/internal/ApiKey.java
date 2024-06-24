package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class ApiKey<O extends Api.ApiOptions> {
    public final int zaa;
    public final Api zab;
    public final Api.ApiOptions zac;
    public final String zad;

    public ApiKey(Api api, Api.ApiOptions apiOptions, String str) {
        this.zab = api;
        this.zac = apiOptions;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{api, apiOptions, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!Objects.equal(this.zab, apiKey.zab) || !Objects.equal(this.zac, apiKey.zac) || !Objects.equal(this.zad, apiKey.zad)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }
}
