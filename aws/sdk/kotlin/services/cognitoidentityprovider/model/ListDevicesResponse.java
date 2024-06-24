package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListDevicesResponse.kt */
/* loaded from: classes.dex */
public final class ListDevicesResponse {
    public final List<DeviceType> devices;
    public final String paginationToken;

    /* compiled from: ListDevicesResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public List<DeviceType> devices;
        public String paginationToken;
    }

    public ListDevicesResponse(Builder builder) {
        this.devices = builder.devices;
        this.paginationToken = builder.paginationToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ListDevicesResponse.class != obj.getClass()) {
            return false;
        }
        ListDevicesResponse listDevicesResponse = (ListDevicesResponse) obj;
        if (Intrinsics.areEqual(this.devices, listDevicesResponse.devices) && Intrinsics.areEqual(this.paginationToken, listDevicesResponse.paginationToken)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        List<DeviceType> list = this.devices;
        if (list != null) {
            r1 = list.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str = this.paginationToken;
        if (str != null) {
            r0 = str.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ListDevicesResponse(");
        sb.append("devices=" + this.devices + ',');
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("paginationToken="), this.paginationToken, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
