package aws.smithy.kotlin.runtime.awsprotocol;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtocolErrors.kt */
/* loaded from: classes.dex */
public final class ErrorDetails {
    public final String code;
    public final String message;
    public final String requestId = null;

    public ErrorDetails(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) obj;
        if (Intrinsics.areEqual(this.code, errorDetails.code) && Intrinsics.areEqual(this.message, errorDetails.message) && Intrinsics.areEqual(this.requestId, errorDetails.requestId)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int r0 = 0;
        String str = this.code;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r1 = hashCode * 31;
        String str2 = this.message;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        String str3 = this.requestId;
        if (str3 != null) {
            r0 = str3.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ErrorDetails(code=");
        sb.append(this.code);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", requestId=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.requestId, ')');
    }
}
