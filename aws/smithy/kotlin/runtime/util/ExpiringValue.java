package aws.smithy.kotlin.runtime.util;

import aws.sdk.kotlin.runtime.config.imds.Token;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CachedValue.kt */
/* loaded from: classes.dex */
public final class ExpiringValue<T> {
    public final Instant expiresAt;
    public final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpiringValue(Token token, Instant expiresAt) {
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        this.value = token;
        this.expiresAt = expiresAt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiringValue)) {
            return false;
        }
        ExpiringValue expiringValue = (ExpiringValue) obj;
        if (Intrinsics.areEqual(this.value, expiringValue.value) && Intrinsics.areEqual(this.expiresAt, expiringValue.expiresAt)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        T t = this.value;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        return this.expiresAt.hashCode() + (hashCode * 31);
    }

    public final String toString() {
        return "ExpiringValue(value=" + this.value + ", expiresAt=" + this.expiresAt + ')';
    }
}
