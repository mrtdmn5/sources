package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.time.Instant;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Token.kt */
/* loaded from: classes.dex */
public final class Token {
    public final Instant expires;
    public final byte[] value;

    public Token(byte[] bArr, Instant instant) {
        this.value = bArr;
        this.expires = instant;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Token.class != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if (Arrays.equals(this.value, token.value) && Intrinsics.areEqual(this.expires, token.expires)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.expires.hashCode() + (Arrays.hashCode(this.value) * 31);
    }

    public final String toString() {
        return "Token(value=" + Arrays.toString(this.value) + ", expires=" + this.expires + ')';
    }
}
