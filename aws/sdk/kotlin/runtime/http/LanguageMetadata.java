package aws.sdk.kotlin.runtime.http;

import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class LanguageMetadata {
    public final Map<String, String> extras;
    public final String version;

    public LanguageMetadata() {
        this(null, 3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageMetadata)) {
            return false;
        }
        LanguageMetadata languageMetadata = (LanguageMetadata) obj;
        if (Intrinsics.areEqual(this.version, languageMetadata.version) && Intrinsics.areEqual(this.extras, languageMetadata.extras)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.version.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lang/kotlin/" + this.version);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public LanguageMetadata(Map extras, int r3) {
        String version = (r3 & 1) != 0 ? KotlinVersion.CURRENT.toString() : null;
        extras = (r3 & 2) != 0 ? EmptyMap.INSTANCE : extras;
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.version = version;
        this.extras = extras;
    }
}
