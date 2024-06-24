package com.amplifyframework.statemachine.codegen.data;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SignedOutData.kt */
@Serializable
/* loaded from: classes.dex */
public final class SignedOutData {
    public static final Companion Companion = new Companion(null);
    private final GlobalSignOutErrorData globalSignOutErrorData;
    private final boolean hasError;
    private final HostedUIErrorData hostedUIErrorData;
    private final String lastKnownUsername;
    private final RevokeTokenErrorData revokeTokenErrorData;

    /* compiled from: SignedOutData.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SignedOutData> serializer() {
            return SignedOutData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SignedOutData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SignedOutData copy$default(SignedOutData signedOutData, String str, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = signedOutData.lastKnownUsername;
        }
        if ((r5 & 2) != 0) {
            hostedUIErrorData = signedOutData.hostedUIErrorData;
        }
        if ((r5 & 4) != 0) {
            globalSignOutErrorData = signedOutData.globalSignOutErrorData;
        }
        if ((r5 & 8) != 0) {
            revokeTokenErrorData = signedOutData.revokeTokenErrorData;
        }
        return signedOutData.copy(str, hostedUIErrorData, globalSignOutErrorData, revokeTokenErrorData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:            if (r0 != r3) goto L53;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void write$Self(com.amplifyframework.statemachine.codegen.data.SignedOutData r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            java.lang.String r0 = "self"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "serialDesc"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r5.shouldEncodeElementDefault(r6)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            goto L1c
        L18:
            java.lang.String r0 = r4.lastKnownUsername
            if (r0 == 0) goto L1e
        L1c:
            r0 = r2
            goto L1f
        L1e:
            r0 = r1
        L1f:
            if (r0 == 0) goto L28
            kotlinx.serialization.internal.StringSerializer r0 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r4.lastKnownUsername
            r5.encodeNullableSerializableElement(r6, r1, r0, r3)
        L28:
            boolean r0 = r5.shouldEncodeElementDefault(r6)
            if (r0 == 0) goto L2f
            goto L43
        L2f:
            boolean r0 = r4.hasError
            com.amplifyframework.statemachine.codegen.data.HostedUIErrorData r3 = r4.hostedUIErrorData
            if (r3 != 0) goto L40
            com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData r3 = r4.globalSignOutErrorData
            if (r3 != 0) goto L40
            com.amplifyframework.statemachine.codegen.data.RevokeTokenErrorData r3 = r4.revokeTokenErrorData
            if (r3 == 0) goto L3e
            goto L40
        L3e:
            r3 = r1
            goto L41
        L40:
            r3 = r2
        L41:
            if (r0 == r3) goto L44
        L43:
            r1 = r2
        L44:
            if (r1 == 0) goto L4b
            boolean r4 = r4.hasError
            r5.encodeBooleanElement(r6, r2, r4)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.statemachine.codegen.data.SignedOutData.write$Self(com.amplifyframework.statemachine.codegen.data.SignedOutData, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public final String component1() {
        return this.lastKnownUsername;
    }

    public final HostedUIErrorData component2() {
        return this.hostedUIErrorData;
    }

    public final GlobalSignOutErrorData component3() {
        return this.globalSignOutErrorData;
    }

    public final RevokeTokenErrorData component4() {
        return this.revokeTokenErrorData;
    }

    public final SignedOutData copy(String str, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData) {
        return new SignedOutData(str, hostedUIErrorData, globalSignOutErrorData, revokeTokenErrorData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignedOutData)) {
            return false;
        }
        SignedOutData signedOutData = (SignedOutData) obj;
        if (Intrinsics.areEqual(this.lastKnownUsername, signedOutData.lastKnownUsername) && Intrinsics.areEqual(this.hostedUIErrorData, signedOutData.hostedUIErrorData) && Intrinsics.areEqual(this.globalSignOutErrorData, signedOutData.globalSignOutErrorData) && Intrinsics.areEqual(this.revokeTokenErrorData, signedOutData.revokeTokenErrorData)) {
            return true;
        }
        return false;
    }

    public final GlobalSignOutErrorData getGlobalSignOutErrorData() {
        return this.globalSignOutErrorData;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final HostedUIErrorData getHostedUIErrorData() {
        return this.hostedUIErrorData;
    }

    public final String getLastKnownUsername() {
        return this.lastKnownUsername;
    }

    public final RevokeTokenErrorData getRevokeTokenErrorData() {
        return this.revokeTokenErrorData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.lastKnownUsername;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        HostedUIErrorData hostedUIErrorData = this.hostedUIErrorData;
        if (hostedUIErrorData == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = hostedUIErrorData.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        GlobalSignOutErrorData globalSignOutErrorData = this.globalSignOutErrorData;
        if (globalSignOutErrorData == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = globalSignOutErrorData.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        RevokeTokenErrorData revokeTokenErrorData = this.revokeTokenErrorData;
        if (revokeTokenErrorData != null) {
            r1 = revokeTokenErrorData.hashCode();
        }
        return r03 + r1;
    }

    public String toString() {
        return "SignedOutData(lastKnownUsername=" + this.lastKnownUsername + ", hostedUIErrorData=" + this.hostedUIErrorData + ", globalSignOutErrorData=" + this.globalSignOutErrorData + ", revokeTokenErrorData=" + this.revokeTokenErrorData + ')';
    }

    public /* synthetic */ SignedOutData(int r3, String str, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r3 & 0) != 0) {
            zzac.throwMissingFieldException(r3, 0, SignedOutData$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r3 & 1) == 0) {
            this.lastKnownUsername = null;
        } else {
            this.lastKnownUsername = str;
        }
        this.hostedUIErrorData = null;
        this.globalSignOutErrorData = null;
        this.revokeTokenErrorData = null;
        if ((r3 & 2) == 0) {
            this.hasError = false;
        } else {
            this.hasError = z;
        }
    }

    public SignedOutData(String str, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData) {
        this.lastKnownUsername = str;
        this.hostedUIErrorData = hostedUIErrorData;
        this.globalSignOutErrorData = globalSignOutErrorData;
        this.revokeTokenErrorData = revokeTokenErrorData;
        this.hasError = (hostedUIErrorData == null && globalSignOutErrorData == null && revokeTokenErrorData == null) ? false : true;
    }

    public /* synthetic */ SignedOutData(String str, HostedUIErrorData hostedUIErrorData, GlobalSignOutErrorData globalSignOutErrorData, RevokeTokenErrorData revokeTokenErrorData, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? null : str, (r6 & 2) != 0 ? null : hostedUIErrorData, (r6 & 4) != 0 ? null : globalSignOutErrorData, (r6 & 8) != 0 ? null : revokeTokenErrorData);
    }

    public static /* synthetic */ void getGlobalSignOutErrorData$annotations() {
    }

    public static /* synthetic */ void getHostedUIErrorData$annotations() {
    }

    public static /* synthetic */ void getRevokeTokenErrorData$annotations() {
    }
}
