package io.ktor.client.plugins.auth.providers;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BearerAuthProvider.kt */
/* loaded from: classes3.dex */
public final class BearerTokens {
    public final String accessToken;

    public BearerTokens(String accessToken, String refreshToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        this.accessToken = accessToken;
    }
}
