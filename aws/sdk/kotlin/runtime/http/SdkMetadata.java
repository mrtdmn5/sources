package aws.sdk.kotlin.runtime.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class SdkMetadata {
    public final String name;
    public final String version;

    public SdkMetadata(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = "kotlin";
        this.version = version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkMetadata)) {
            return false;
        }
        SdkMetadata sdkMetadata = (SdkMetadata) obj;
        if (Intrinsics.areEqual(this.name, sdkMetadata.name) && Intrinsics.areEqual(this.version, sdkMetadata.version)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.version.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "aws-sdk-" + this.name + '/' + this.version;
    }
}
