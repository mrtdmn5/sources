package io.ktor.client.plugins.auth.providers;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BearerAuthProvider.kt */
/* loaded from: classes3.dex */
public final class RefreshTokensParams {
    public RefreshTokensParams(HttpClient client, HttpResponse response) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(response, "response");
    }
}
