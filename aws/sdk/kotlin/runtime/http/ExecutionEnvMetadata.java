package aws.sdk.kotlin.runtime.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class ExecutionEnvMetadata {
    public final String name;

    public ExecutionEnvMetadata(String str) {
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ExecutionEnvMetadata) && Intrinsics.areEqual(this.name, ((ExecutionEnvMetadata) obj).name)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return "exec-env/".concat(AwsUserAgentMetadataKt.access$encodeUaToken(this.name));
    }
}
