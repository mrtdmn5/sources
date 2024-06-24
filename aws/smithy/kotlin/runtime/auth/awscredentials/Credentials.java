package aws.smithy.kotlin.runtime.auth.awscredentials;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Credentials.kt */
/* loaded from: classes.dex */
public final class Credentials {
    public final String accessKeyId;
    public final Instant expiration;
    public final String providerName;
    public final String secretAccessKey;
    public final String sessionToken;

    public Credentials(String accessKeyId, String secretAccessKey, String str, Instant instant) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = str;
        this.expiration = instant;
        this.providerName = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if (Intrinsics.areEqual(this.accessKeyId, credentials.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, credentials.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, credentials.sessionToken) && Intrinsics.areEqual(this.expiration, credentials.expiration) && Intrinsics.areEqual(this.providerName, credentials.providerName)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.secretAccessKey, this.accessKeyId.hashCode() * 31, 31);
        int r1 = 0;
        String str = this.sessionToken;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Instant instant = this.expiration;
        if (instant == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = instant.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str2 = this.providerName;
        if (str2 != null) {
            r1 = str2.hashCode();
        }
        return r02 + r1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Credentials(accessKeyId=");
        sb.append(this.accessKeyId);
        sb.append(", secretAccessKey=");
        sb.append(this.secretAccessKey);
        sb.append(", sessionToken=");
        sb.append(this.sessionToken);
        sb.append(", expiration=");
        sb.append(this.expiration);
        sb.append(", providerName=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.providerName, ')');
    }
}
