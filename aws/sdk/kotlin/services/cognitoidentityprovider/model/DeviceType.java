package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.time.Instant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceType.kt */
/* loaded from: classes.dex */
public final class DeviceType {
    public final List<AttributeType> deviceAttributes;
    public final Instant deviceCreateDate;
    public final String deviceKey;
    public final Instant deviceLastAuthenticatedDate;
    public final Instant deviceLastModifiedDate;

    /* compiled from: DeviceType.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public List<AttributeType> deviceAttributes;
        public Instant deviceCreateDate;
        public String deviceKey;
        public Instant deviceLastAuthenticatedDate;
        public Instant deviceLastModifiedDate;
    }

    public DeviceType(Builder builder) {
        this.deviceAttributes = builder.deviceAttributes;
        this.deviceCreateDate = builder.deviceCreateDate;
        this.deviceKey = builder.deviceKey;
        this.deviceLastAuthenticatedDate = builder.deviceLastAuthenticatedDate;
        this.deviceLastModifiedDate = builder.deviceLastModifiedDate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DeviceType.class != obj.getClass()) {
            return false;
        }
        DeviceType deviceType = (DeviceType) obj;
        if (Intrinsics.areEqual(this.deviceAttributes, deviceType.deviceAttributes) && Intrinsics.areEqual(this.deviceCreateDate, deviceType.deviceCreateDate) && Intrinsics.areEqual(this.deviceKey, deviceType.deviceKey) && Intrinsics.areEqual(this.deviceLastAuthenticatedDate, deviceType.deviceLastAuthenticatedDate) && Intrinsics.areEqual(this.deviceLastModifiedDate, deviceType.deviceLastModifiedDate)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r0 = 0;
        List<AttributeType> list = this.deviceAttributes;
        if (list != null) {
            r1 = list.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        Instant instant = this.deviceCreateDate;
        if (instant != null) {
            r2 = instant.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        String str = this.deviceKey;
        if (str != null) {
            r22 = str.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        Instant instant2 = this.deviceLastAuthenticatedDate;
        if (instant2 != null) {
            r23 = instant2.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        Instant instant3 = this.deviceLastModifiedDate;
        if (instant3 != null) {
            r0 = instant3.hashCode();
        }
        return r15 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceType(");
        sb.append("deviceAttributes=" + this.deviceAttributes + ',');
        sb.append("deviceCreateDate=" + this.deviceCreateDate + ',');
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("deviceKey="), this.deviceKey, ',', sb, "deviceLastAuthenticatedDate=");
        m.append(this.deviceLastAuthenticatedDate);
        m.append(',');
        sb.append(m.toString());
        sb.append("deviceLastModifiedDate=" + this.deviceLastModifiedDate);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
