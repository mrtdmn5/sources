package com.animaconnected.watch.display;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class ExpiringString extends WatchString {
    private final Instant expiry;
    private final String fallbackString;
    private final String string;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpiringString(String string, String fallbackString, Instant expiry) {
        super(null);
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(fallbackString, "fallbackString");
        Intrinsics.checkNotNullParameter(expiry, "expiry");
        this.string = string;
        this.fallbackString = fallbackString;
        this.expiry = expiry;
    }

    public static /* synthetic */ ExpiringString copy$default(ExpiringString expiringString, String str, String str2, Instant instant, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = expiringString.string;
        }
        if ((r4 & 2) != 0) {
            str2 = expiringString.fallbackString;
        }
        if ((r4 & 4) != 0) {
            instant = expiringString.expiry;
        }
        return expiringString.copy(str, str2, instant);
    }

    public final String component1() {
        return this.string;
    }

    public final String component2() {
        return this.fallbackString;
    }

    public final Instant component3() {
        return this.expiry;
    }

    public final ExpiringString copy(String string, String fallbackString, Instant expiry) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(fallbackString, "fallbackString");
        Intrinsics.checkNotNullParameter(expiry, "expiry");
        return new ExpiringString(string, fallbackString, expiry);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiringString)) {
            return false;
        }
        ExpiringString expiringString = (ExpiringString) obj;
        if (Intrinsics.areEqual(this.string, expiringString.string) && Intrinsics.areEqual(this.fallbackString, expiringString.fallbackString) && Intrinsics.areEqual(this.expiry, expiringString.expiry)) {
            return true;
        }
        return false;
    }

    public final Instant getExpiry() {
        return this.expiry;
    }

    public final String getFallbackString() {
        return this.fallbackString;
    }

    @Override // com.animaconnected.watch.display.WatchString
    public String getString() {
        return this.string;
    }

    public int hashCode() {
        return this.expiry.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.fallbackString, this.string.hashCode() * 31, 31);
    }

    public String toString() {
        return "ExpiringString(string=" + this.string + ", fallbackString=" + this.fallbackString + ", expiry=" + this.expiry + ')';
    }
}
