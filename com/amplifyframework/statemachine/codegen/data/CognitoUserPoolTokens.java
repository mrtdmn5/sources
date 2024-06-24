package com.amplifyframework.statemachine.codegen.data;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AmplifyCredential.kt */
@Serializable
/* loaded from: classes.dex */
public final class CognitoUserPoolTokens {
    public static final Companion Companion = new Companion(null);
    private final String accessToken;
    private final Long expiration;
    private final String idToken;
    private final String refreshToken;

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CognitoUserPoolTokens> serializer() {
            return CognitoUserPoolTokens$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CognitoUserPoolTokens(int r2, String str, String str2, String str3, Long l, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, CognitoUserPoolTokens$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.idToken = str;
        this.accessToken = str2;
        this.refreshToken = str3;
        this.expiration = l;
    }

    public static /* synthetic */ CognitoUserPoolTokens copy$default(CognitoUserPoolTokens cognitoUserPoolTokens, String str, String str2, String str3, Long l, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = cognitoUserPoolTokens.idToken;
        }
        if ((r5 & 2) != 0) {
            str2 = cognitoUserPoolTokens.accessToken;
        }
        if ((r5 & 4) != 0) {
            str3 = cognitoUserPoolTokens.refreshToken;
        }
        if ((r5 & 8) != 0) {
            l = cognitoUserPoolTokens.expiration;
        }
        return cognitoUserPoolTokens.copy(str, str2, str3, l);
    }

    public static final void write$Self(CognitoUserPoolTokens self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.idToken);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.accessToken);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.refreshToken);
        output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.expiration);
    }

    public final String component1() {
        return this.idToken;
    }

    public final String component2() {
        return this.accessToken;
    }

    public final String component3() {
        return this.refreshToken;
    }

    public final Long component4() {
        return this.expiration;
    }

    public final CognitoUserPoolTokens copy(String str, String str2, String str3, Long l) {
        return new CognitoUserPoolTokens(str, str2, str3, l);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && Intrinsics.areEqual(CognitoUserPoolTokens.class, obj.getClass()) && (obj instanceof CognitoUserPoolTokens)) {
            CognitoUserPoolTokens cognitoUserPoolTokens = (CognitoUserPoolTokens) obj;
            if (Intrinsics.areEqual(this.idToken, cognitoUserPoolTokens.idToken) && Intrinsics.areEqual(this.accessToken, cognitoUserPoolTokens.accessToken) && Intrinsics.areEqual(this.refreshToken, cognitoUserPoolTokens.refreshToken)) {
                return true;
            }
        }
        return false;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Long getExpiration() {
        return this.expiration;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.idToken;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        String str2 = this.accessToken;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str3 = this.refreshToken;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Long l = this.expiration;
        if (l != null) {
            r1 = l.hashCode();
        }
        return r03 + r1;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("CognitoUserPoolTokens(idToken = ");
        String str3 = this.idToken;
        String str4 = null;
        if (str3 != null) {
            str = StringsKt__StringsKt.substring(str3, new IntRange(0, 4));
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("***, accessToken = ");
        String str5 = this.accessToken;
        if (str5 != null) {
            str2 = StringsKt__StringsKt.substring(str5, new IntRange(0, 4));
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append("***, refreshToken = ");
        String str6 = this.refreshToken;
        if (str6 != null) {
            str4 = StringsKt__StringsKt.substring(str6, new IntRange(0, 4));
        }
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str4, "***)");
    }

    public CognitoUserPoolTokens(String str, String str2, String str3, Long l) {
        this.idToken = str;
        this.accessToken = str2;
        this.refreshToken = str3;
        this.expiration = l;
    }
}
