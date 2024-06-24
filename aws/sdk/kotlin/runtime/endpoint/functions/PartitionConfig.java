package aws.sdk.kotlin.runtime.endpoint.functions;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Functions.kt */
/* loaded from: classes.dex */
public final class PartitionConfig {
    public final String dnsSuffix;
    public final String dualStackDnsSuffix;
    public final String name;
    public final Boolean supportsDualStack;
    public final Boolean supportsFIPS;

    public PartitionConfig() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartitionConfig)) {
            return false;
        }
        PartitionConfig partitionConfig = (PartitionConfig) obj;
        if (Intrinsics.areEqual(this.name, partitionConfig.name) && Intrinsics.areEqual(this.dnsSuffix, partitionConfig.dnsSuffix) && Intrinsics.areEqual(this.dualStackDnsSuffix, partitionConfig.dualStackDnsSuffix) && Intrinsics.areEqual(this.supportsFIPS, partitionConfig.supportsFIPS) && Intrinsics.areEqual(this.supportsDualStack, partitionConfig.supportsDualStack)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int r0 = 0;
        String str = this.name;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r1 = hashCode * 31;
        String str2 = this.dnsSuffix;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        String str3 = this.dualStackDnsSuffix;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int r13 = (r12 + hashCode3) * 31;
        Boolean bool = this.supportsFIPS;
        if (bool == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool.hashCode();
        }
        int r14 = (r13 + hashCode4) * 31;
        Boolean bool2 = this.supportsDualStack;
        if (bool2 != null) {
            r0 = bool2.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        return "PartitionConfig(name=" + this.name + ", dnsSuffix=" + this.dnsSuffix + ", dualStackDnsSuffix=" + this.dualStackDnsSuffix + ", supportsFIPS=" + this.supportsFIPS + ", supportsDualStack=" + this.supportsDualStack + ')';
    }

    public PartitionConfig(String str, String str2, String str3, Boolean bool, Boolean bool2) {
        this.name = str;
        this.dnsSuffix = str2;
        this.dualStackDnsSuffix = str3;
        this.supportsFIPS = bool;
        this.supportsDualStack = bool2;
    }

    public /* synthetic */ PartitionConfig(int r7) {
        this(null, null, null, null, null);
    }
}
