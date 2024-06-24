package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListDevicesRequest.kt */
/* loaded from: classes.dex */
public final class ListDevicesRequest {
    public final String accessToken;

    /* compiled from: ListDevicesRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public String accessToken;
    }

    public ListDevicesRequest(Builder builder) {
        this.accessToken = builder.accessToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ListDevicesRequest.class == obj.getClass() && Intrinsics.areEqual(this.accessToken, ((ListDevicesRequest) obj).accessToken) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        String str = this.accessToken;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        return (((r1 * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "ListDevicesRequest(accessToken=*** Sensitive Data Redacted ***,limit=null,paginationToken=null)";
    }
}
