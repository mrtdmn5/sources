package aws.sdk.kotlin.runtime.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class FrameworkMetadata {
    public final String name;
    public final String version;

    public FrameworkMetadata(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrameworkMetadata)) {
            return false;
        }
        FrameworkMetadata frameworkMetadata = (FrameworkMetadata) obj;
        if (Intrinsics.areEqual(this.name, frameworkMetadata.name) && Intrinsics.areEqual(this.version, frameworkMetadata.version)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.version.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "lib/" + this.name + '/' + this.version;
    }
}
