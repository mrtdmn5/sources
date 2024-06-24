package com.amplifyframework.statemachine.codegen.data;

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
public final class AWSCredentials {
    public static final Companion Companion = new Companion(null);
    private static final AWSCredentials empty = new AWSCredentials(null, null, null, 0L);
    private final String accessKeyId;
    private final Long expiration;
    private final String secretAccessKey;
    private final String sessionToken;

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AWSCredentials getEmpty() {
            return AWSCredentials.empty;
        }

        public final KSerializer<AWSCredentials> serializer() {
            return AWSCredentials$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AWSCredentials(int r2, String str, String str2, String str3, Long l, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, AWSCredentials$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.accessKeyId = str;
        this.secretAccessKey = str2;
        this.sessionToken = str3;
        this.expiration = l;
    }

    public static /* synthetic */ AWSCredentials copy$default(AWSCredentials aWSCredentials, String str, String str2, String str3, Long l, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = aWSCredentials.accessKeyId;
        }
        if ((r5 & 2) != 0) {
            str2 = aWSCredentials.secretAccessKey;
        }
        if ((r5 & 4) != 0) {
            str3 = aWSCredentials.sessionToken;
        }
        if ((r5 & 8) != 0) {
            l = aWSCredentials.expiration;
        }
        return aWSCredentials.copy(str, str2, str3, l);
    }

    public static final void write$Self(AWSCredentials self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.accessKeyId);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.secretAccessKey);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.sessionToken);
        output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.expiration);
    }

    public final String component1() {
        return this.accessKeyId;
    }

    public final String component2() {
        return this.secretAccessKey;
    }

    public final String component3() {
        return this.sessionToken;
    }

    public final Long component4() {
        return this.expiration;
    }

    public final AWSCredentials copy(String str, String str2, String str3, Long l) {
        return new AWSCredentials(str, str2, str3, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSCredentials)) {
            return false;
        }
        AWSCredentials aWSCredentials = (AWSCredentials) obj;
        if (Intrinsics.areEqual(this.accessKeyId, aWSCredentials.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, aWSCredentials.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, aWSCredentials.sessionToken) && Intrinsics.areEqual(this.expiration, aWSCredentials.expiration)) {
            return true;
        }
        return false;
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final Long getExpiration() {
        return this.expiration;
    }

    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.accessKeyId;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        String str2 = this.secretAccessKey;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str3 = this.sessionToken;
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
        StringBuilder sb = new StringBuilder("AWSCredentials(accessKeyId = ");
        String str3 = this.accessKeyId;
        String str4 = null;
        if (str3 != null) {
            str = StringsKt__StringsKt.substring(str3, new IntRange(0, 4));
        } else {
            str = null;
        }
        sb.append(str);
        sb.append("***, secretAccessKey = ");
        String str5 = this.secretAccessKey;
        if (str5 != null) {
            str2 = StringsKt__StringsKt.substring(str5, new IntRange(0, 4));
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append("***, sessionToken = ");
        String str6 = this.sessionToken;
        if (str6 != null) {
            str4 = StringsKt__StringsKt.substring(str6, new IntRange(0, 4));
        }
        sb.append(str4);
        sb.append("***, expiration = ");
        sb.append(this.expiration);
        sb.append(')');
        return sb.toString();
    }

    public AWSCredentials(String str, String str2, String str3, Long l) {
        this.accessKeyId = str;
        this.secretAccessKey = str2;
        this.sessionToken = str3;
        this.expiration = l;
    }
}
