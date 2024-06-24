package com.animaconnected.watch.account.strava;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: StravaToken.kt */
@Serializable
/* loaded from: classes3.dex */
public final class StravaToken {
    public static final Companion Companion = new Companion(null);
    private final String accessToken;
    private final long expiresAt;
    private final int expiresIn;
    private final String refreshToken;
    private final String tokenType;

    /* compiled from: StravaToken.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StravaToken> serializer() {
            return StravaToken$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public StravaToken(String str, long j, int r10, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "tokenType", str2, "refreshToken", str3, "accessToken");
        this.tokenType = str;
        this.expiresAt = j;
        this.expiresIn = r10;
        this.refreshToken = str2;
        this.accessToken = str3;
    }

    public static /* synthetic */ StravaToken copy$default(StravaToken stravaToken, String str, long j, int r8, String str2, String str3, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            str = stravaToken.tokenType;
        }
        if ((r11 & 2) != 0) {
            j = stravaToken.expiresAt;
        }
        long j2 = j;
        if ((r11 & 4) != 0) {
            r8 = stravaToken.expiresIn;
        }
        int r12 = r8;
        if ((r11 & 8) != 0) {
            str2 = stravaToken.refreshToken;
        }
        String str4 = str2;
        if ((r11 & 16) != 0) {
            str3 = stravaToken.accessToken;
        }
        return stravaToken.copy(str, j2, r12, str4, str3);
    }

    public static final /* synthetic */ void write$Self$watch_release(StravaToken stravaToken, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, stravaToken.tokenType);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, stravaToken.expiresAt);
        compositeEncoder.encodeIntElement(2, stravaToken.expiresIn, serialDescriptor);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, stravaToken.refreshToken);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, stravaToken.accessToken);
    }

    public final String component1() {
        return this.tokenType;
    }

    public final long component2() {
        return this.expiresAt;
    }

    public final int component3() {
        return this.expiresIn;
    }

    public final String component4() {
        return this.refreshToken;
    }

    public final String component5() {
        return this.accessToken;
    }

    public final StravaToken copy(String tokenType, long j, int r12, String refreshToken, String accessToken) {
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new StravaToken(tokenType, j, r12, refreshToken, accessToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StravaToken)) {
            return false;
        }
        StravaToken stravaToken = (StravaToken) obj;
        if (Intrinsics.areEqual(this.tokenType, stravaToken.tokenType) && this.expiresAt == stravaToken.expiresAt && this.expiresIn == stravaToken.expiresIn && Intrinsics.areEqual(this.refreshToken, stravaToken.refreshToken) && Intrinsics.areEqual(this.accessToken, stravaToken.accessToken)) {
            return true;
        }
        return false;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    public final int getExpiresIn() {
        return this.expiresIn;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        return this.accessToken.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.refreshToken, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.expiresIn, Scale$$ExternalSyntheticOutline0.m(this.expiresAt, this.tokenType.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StravaToken(tokenType=");
        sb.append(this.tokenType);
        sb.append(", expiresAt=");
        sb.append(this.expiresAt);
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(", accessToken=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.accessToken, ')');
    }

    public static /* synthetic */ void getAccessToken$annotations() {
    }

    public static /* synthetic */ void getExpiresAt$annotations() {
    }

    public static /* synthetic */ void getExpiresIn$annotations() {
    }

    public static /* synthetic */ void getRefreshToken$annotations() {
    }

    public static /* synthetic */ void getTokenType$annotations() {
    }

    public /* synthetic */ StravaToken(int r2, String str, long j, int r6, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (r2 & 31)) {
            zzac.throwMissingFieldException(r2, 31, StravaToken$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.tokenType = str;
        this.expiresAt = j;
        this.expiresIn = r6;
        this.refreshToken = str2;
        this.accessToken = str3;
    }
}
