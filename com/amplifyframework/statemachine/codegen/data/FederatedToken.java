package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AmplifyCredential.kt */
@Serializable
/* loaded from: classes.dex */
public final class FederatedToken {
    public static final Companion Companion = new Companion(null);
    private final String providerName;
    private final String token;

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FederatedToken> serializer() {
            return FederatedToken$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FederatedToken(int r2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, FederatedToken$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.token = str;
        this.providerName = str2;
    }

    public static /* synthetic */ FederatedToken copy$default(FederatedToken federatedToken, String str, String str2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = federatedToken.token;
        }
        if ((r3 & 2) != 0) {
            str2 = federatedToken.providerName;
        }
        return federatedToken.copy(str, str2);
    }

    public static final void write$Self(FederatedToken self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.token);
        output.encodeStringElement(serialDesc, 1, self.providerName);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.providerName;
    }

    public final FederatedToken copy(String token, String providerName) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return new FederatedToken(token, providerName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FederatedToken)) {
            return false;
        }
        FederatedToken federatedToken = (FederatedToken) obj;
        if (Intrinsics.areEqual(this.token, federatedToken.token) && Intrinsics.areEqual(this.providerName, federatedToken.providerName)) {
            return true;
        }
        return false;
    }

    public final String getProviderName() {
        return this.providerName;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return this.providerName.hashCode() + (this.token.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FederatedToken(token = ");
        sb.append(StringsKt__StringsKt.substring(this.token, new IntRange(0, 4)));
        sb.append("***, providerName = ");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.providerName, ')');
    }

    public FederatedToken(String token, String providerName) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.token = token;
        this.providerName = providerName;
    }
}
