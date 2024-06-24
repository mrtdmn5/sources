package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AuthProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIProviderInfo.kt */
/* loaded from: classes.dex */
public final class HostedUIProviderInfo {
    private final AuthProvider authProvider;
    private final String idpIdentifier;

    public HostedUIProviderInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HostedUIProviderInfo copy$default(HostedUIProviderInfo hostedUIProviderInfo, AuthProvider authProvider, String str, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            authProvider = hostedUIProviderInfo.authProvider;
        }
        if ((r3 & 2) != 0) {
            str = hostedUIProviderInfo.idpIdentifier;
        }
        return hostedUIProviderInfo.copy(authProvider, str);
    }

    public final AuthProvider component1() {
        return this.authProvider;
    }

    public final String component2() {
        return this.idpIdentifier;
    }

    public final HostedUIProviderInfo copy(AuthProvider authProvider, String str) {
        return new HostedUIProviderInfo(authProvider, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostedUIProviderInfo)) {
            return false;
        }
        HostedUIProviderInfo hostedUIProviderInfo = (HostedUIProviderInfo) obj;
        if (Intrinsics.areEqual(this.authProvider, hostedUIProviderInfo.authProvider) && Intrinsics.areEqual(this.idpIdentifier, hostedUIProviderInfo.idpIdentifier)) {
            return true;
        }
        return false;
    }

    public final AuthProvider getAuthProvider() {
        return this.authProvider;
    }

    public final String getIdpIdentifier() {
        return this.idpIdentifier;
    }

    public int hashCode() {
        int hashCode;
        AuthProvider authProvider = this.authProvider;
        int r1 = 0;
        if (authProvider == null) {
            hashCode = 0;
        } else {
            hashCode = authProvider.hashCode();
        }
        int r0 = hashCode * 31;
        String str = this.idpIdentifier;
        if (str != null) {
            r1 = str.hashCode();
        }
        return r0 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HostedUIProviderInfo(authProvider=");
        sb.append(this.authProvider);
        sb.append(", idpIdentifier=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.idpIdentifier, ')');
    }

    public HostedUIProviderInfo(AuthProvider authProvider, String str) {
        this.authProvider = authProvider;
        this.idpIdentifier = str;
    }

    public /* synthetic */ HostedUIProviderInfo(AuthProvider authProvider, String str, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? null : authProvider, (r4 & 2) != 0 ? null : str);
    }
}
