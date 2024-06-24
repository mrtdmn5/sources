package aws.sdk.kotlin.runtime.config.profile;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsConfigLoader.kt */
/* loaded from: classes.dex */
public final class AwsConfigurationSource {
    public final String configPath;
    public final String credentialsPath;
    public final String profile;

    public AwsConfigurationSource(String str, String configPath, String credentialsPath) {
        Intrinsics.checkNotNullParameter(configPath, "configPath");
        Intrinsics.checkNotNullParameter(credentialsPath, "credentialsPath");
        this.profile = str;
        this.configPath = configPath;
        this.credentialsPath = credentialsPath;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AwsConfigurationSource)) {
            return false;
        }
        AwsConfigurationSource awsConfigurationSource = (AwsConfigurationSource) obj;
        if (Intrinsics.areEqual(this.profile, awsConfigurationSource.profile) && Intrinsics.areEqual(this.configPath, awsConfigurationSource.configPath) && Intrinsics.areEqual(this.credentialsPath, awsConfigurationSource.credentialsPath)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.credentialsPath.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.configPath, this.profile.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AwsConfigurationSource(profile=");
        sb.append(this.profile);
        sb.append(", configPath=");
        sb.append(this.configPath);
        sb.append(", credentialsPath=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.credentialsPath, ')');
    }
}
