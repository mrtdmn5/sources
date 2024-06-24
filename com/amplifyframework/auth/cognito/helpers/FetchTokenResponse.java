package com.amplifyframework.auth.cognito.helpers;

import aws.smithy.kotlin.runtime.time.Instant;
import com.google.android.gms.tasks.zzac;
import j$.time.format.DateTimeFormatter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: HostedUIHttpHelper.kt */
@Serializable
/* loaded from: classes.dex */
public final class FetchTokenResponse {
    public static final Companion Companion = new Companion(null);
    private final String accessToken;
    private final String error;
    private final Long expiration;
    private final Integer expiresIn;
    private final String idToken;
    private final String refreshToken;

    /* compiled from: HostedUIHttpHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FetchTokenResponse> serializer() {
            return FetchTokenResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public FetchTokenResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r3) == false) goto L56;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void write$Self(com.amplifyframework.auth.cognito.helpers.FetchTokenResponse r7, kotlinx.serialization.encoding.CompositeEncoder r8, kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            goto L1c
        L18:
            java.lang.String r0 = r7.accessToken
            if (r0 == 0) goto L1e
        L1c:
            r0 = r2
            goto L1f
        L1e:
            r0 = r1
        L1f:
            if (r0 == 0) goto L28
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r7.accessToken
            r8.encodeNullableSerializableElement(r9, r1, r0, r3)
        L28:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L2f
            goto L33
        L2f:
            java.lang.String r0 = r7.idToken
            if (r0 == 0) goto L35
        L33:
            r0 = r2
            goto L36
        L35:
            r0 = r1
        L36:
            if (r0 == 0) goto L3f
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r7.idToken
            r8.encodeNullableSerializableElement(r9, r2, r0, r3)
        L3f:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L46
            goto L4a
        L46:
            java.lang.String r0 = r7.refreshToken
            if (r0 == 0) goto L4c
        L4a:
            r0 = r2
            goto L4d
        L4c:
            r0 = r1
        L4d:
            if (r0 == 0) goto L57
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r7.refreshToken
            r4 = 2
            r8.encodeNullableSerializableElement(r9, r4, r0, r3)
        L57:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L5e
            goto L62
        L5e:
            java.lang.Integer r0 = r7.expiresIn
            if (r0 == 0) goto L64
        L62:
            r0 = r2
            goto L65
        L64:
            r0 = r1
        L65:
            if (r0 == 0) goto L6f
            kotlinx.serialization.internal.IntSerializer r0 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            java.lang.Integer r3 = r7.expiresIn
            r4 = 3
            r8.encodeNullableSerializableElement(r9, r4, r0, r3)
        L6f:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L76
            goto L7a
        L76:
            java.lang.String r0 = r7.error
            if (r0 == 0) goto L7c
        L7a:
            r0 = r2
            goto L7d
        L7c:
            r0 = r1
        L7d:
            if (r0 == 0) goto L87
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r7.error
            r4 = 4
            r8.encodeNullableSerializableElement(r9, r4, r0, r3)
        L87:
            boolean r0 = r8.shouldEncodeElementDefault(r9)
            if (r0 == 0) goto L8e
            goto Lba
        L8e:
            java.lang.Long r0 = r7.expiration
            java.lang.Integer r3 = r7.expiresIn
            if (r3 == 0) goto Lb3
            int r3 = r3.intValue()
            j$.time.format.DateTimeFormatter r4 = aws.smithy.kotlin.runtime.time.Instant.RFC_5322_FIXED_DATE_TIME
            aws.smithy.kotlin.runtime.time.Instant r4 = aws.smithy.kotlin.runtime.time.Instant.Companion.now()
            int r5 = kotlin.time.Duration.$r8$clinit
            kotlin.time.DurationUnit r5 = kotlin.time.DurationUnit.SECONDS
            long r5 = kotlin.time.DurationKt.toDuration(r3, r5)
            aws.smithy.kotlin.runtime.time.Instant r3 = r4.m621plusLRDsOJo(r5)
            long r3 = r3.getEpochSeconds()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            goto Lb4
        Lb3:
            r3 = 0
        Lb4:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 != 0) goto Lbb
        Lba:
            r1 = r2
        Lbb:
            if (r1 == 0) goto Lc5
            kotlinx.serialization.internal.LongSerializer r0 = kotlinx.serialization.internal.LongSerializer.INSTANCE
            java.lang.Long r7 = r7.expiration
            r1 = 5
            r8.encodeNullableSerializableElement(r9, r1, r0, r7)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.helpers.FetchTokenResponse.write$Self(com.amplifyframework.auth.cognito.helpers.FetchTokenResponse, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getError() {
        return this.error;
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

    public /* synthetic */ FetchTokenResponse(int r2, String str, String str2, String str3, Integer num, String str4, Long l, SerializationConstructorMarker serializationConstructorMarker) {
        Long l2 = null;
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, FetchTokenResponse$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r2 & 1) == 0) {
            this.accessToken = null;
        } else {
            this.accessToken = str;
        }
        if ((r2 & 2) == 0) {
            this.idToken = null;
        } else {
            this.idToken = str2;
        }
        if ((r2 & 4) == 0) {
            this.refreshToken = null;
        } else {
            this.refreshToken = str3;
        }
        if ((r2 & 8) == 0) {
            this.expiresIn = null;
        } else {
            this.expiresIn = num;
        }
        if ((r2 & 16) == 0) {
            this.error = null;
        } else {
            this.error = str4;
        }
        if ((r2 & 32) != 0) {
            this.expiration = l;
            return;
        }
        Integer num2 = this.expiresIn;
        if (num2 != null) {
            int intValue = num2.intValue();
            DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
            Instant now = Instant.Companion.now();
            int r4 = Duration.$r8$clinit;
            l2 = Long.valueOf(now.m621plusLRDsOJo(DurationKt.toDuration(intValue, DurationUnit.SECONDS)).getEpochSeconds());
        }
        this.expiration = l2;
    }

    public FetchTokenResponse(String str, String str2, String str3, Integer num, String str4) {
        Long l;
        this.accessToken = str;
        this.idToken = str2;
        this.refreshToken = str3;
        this.expiresIn = num;
        this.error = str4;
        if (num != null) {
            int intValue = num.intValue();
            DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
            Instant now = Instant.Companion.now();
            int r3 = Duration.$r8$clinit;
            l = Long.valueOf(now.m621plusLRDsOJo(DurationKt.toDuration(intValue, DurationUnit.SECONDS)).getEpochSeconds());
        } else {
            l = null;
        }
        this.expiration = l;
    }

    public /* synthetic */ FetchTokenResponse(String str, String str2, String str3, Integer num, String str4, int r10, DefaultConstructorMarker defaultConstructorMarker) {
        this((r10 & 1) != 0 ? null : str, (r10 & 2) != 0 ? null : str2, (r10 & 4) != 0 ? null : str3, (r10 & 8) != 0 ? null : num, (r10 & 16) != 0 ? null : str4);
    }

    public static /* synthetic */ void getAccessToken$annotations() {
    }

    public static /* synthetic */ void getError$annotations() {
    }

    private static /* synthetic */ void getExpiresIn$annotations() {
    }

    public static /* synthetic */ void getIdToken$annotations() {
    }

    public static /* synthetic */ void getRefreshToken$annotations() {
    }
}
