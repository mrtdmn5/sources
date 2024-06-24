package aws.smithy.kotlin.runtime.net;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Url.kt */
/* loaded from: classes.dex */
public final class UserInfo {
    public final String password;
    public final String username;

    public UserInfo(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (Intrinsics.areEqual(this.username, userInfo.username) && Intrinsics.areEqual(this.password, userInfo.password)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.password.hashCode() + (this.username.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserInfo(username=");
        sb.append(this.username);
        sb.append(", password=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.password, ')');
    }
}
