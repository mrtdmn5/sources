package com.amplifyframework.statemachine.codegen.data;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AuthChallenge.kt */
@Serializable
/* loaded from: classes.dex */
public final class AuthChallenge {
    public static final Companion Companion = new Companion(null);
    private final String challengeName;
    private final Map<String, String> parameters;
    private final String session;
    private final String username;

    /* compiled from: AuthChallenge.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AuthChallenge> serializer() {
            return AuthChallenge$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AuthChallenge(int r3, String str, String str2, String str3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (13 != (r3 & 13)) {
            zzac.throwMissingFieldException(r3, 13, AuthChallenge$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.challengeName = str;
        if ((r3 & 2) == 0) {
            this.username = null;
        } else {
            this.username = str2;
        }
        this.session = str3;
        this.parameters = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthChallenge copy$default(AuthChallenge authChallenge, String str, String str2, String str3, Map map, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = authChallenge.challengeName;
        }
        if ((r5 & 2) != 0) {
            str2 = authChallenge.username;
        }
        if ((r5 & 4) != 0) {
            str3 = authChallenge.session;
        }
        if ((r5 & 8) != 0) {
            map = authChallenge.parameters;
        }
        return authChallenge.copy(str, str2, str3, map);
    }

    public static final void write$Self(AuthChallenge self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        boolean z = false;
        output.encodeStringElement(serialDesc, 0, self.challengeName);
        if (output.shouldEncodeElementDefault(serialDesc) || self.username != null) {
            z = true;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.username);
        }
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.session);
        output.encodeNullableSerializableElement(serialDesc, 3, new LinkedHashMapSerializer(stringSerializer, stringSerializer), self.parameters);
    }

    public final String component1() {
        return this.challengeName;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.session;
    }

    public final Map<String, String> component4() {
        return this.parameters;
    }

    public final AuthChallenge copy(String challengeName, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(challengeName, "challengeName");
        return new AuthChallenge(challengeName, str, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthChallenge)) {
            return false;
        }
        AuthChallenge authChallenge = (AuthChallenge) obj;
        if (Intrinsics.areEqual(this.challengeName, authChallenge.challengeName) && Intrinsics.areEqual(this.username, authChallenge.username) && Intrinsics.areEqual(this.session, authChallenge.session) && Intrinsics.areEqual(this.parameters, authChallenge.parameters)) {
            return true;
        }
        return false;
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.challengeName.hashCode() * 31;
        String str = this.username;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (hashCode3 + hashCode) * 31;
        String str2 = this.session;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Map<String, String> map = this.parameters;
        if (map != null) {
            r2 = map.hashCode();
        }
        return r02 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthChallenge(challengeName=");
        sb.append(this.challengeName);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", session=");
        sb.append(this.session);
        sb.append(", parameters=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.parameters, ')');
    }

    public AuthChallenge(String challengeName, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(challengeName, "challengeName");
        this.challengeName = challengeName;
        this.username = str;
        this.session = str2;
        this.parameters = map;
    }

    public /* synthetic */ AuthChallenge(String str, String str2, String str3, Map map, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r5 & 2) != 0 ? null : str2, str3, map);
    }
}
