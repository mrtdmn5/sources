package aws.sdk.kotlin.runtime.http;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class ApiMetadata {
    public final String serviceId;
    public final String version;

    public ApiMetadata(String str, String str2) {
        this.serviceId = str;
        this.version = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiMetadata)) {
            return false;
        }
        ApiMetadata apiMetadata = (ApiMetadata) obj;
        if (Intrinsics.areEqual(this.serviceId, apiMetadata.serviceId) && Intrinsics.areEqual(this.version, apiMetadata.version)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.version.hashCode() + (this.serviceId.hashCode() * 31);
    }

    public final String toString() {
        String lowerCase = StringsKt__StringsJVMKt.replace$default(this.serviceId, " ", "-").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return "api/" + lowerCase + '/' + AwsUserAgentMetadataKt.access$encodeUaToken(this.version);
    }
}
