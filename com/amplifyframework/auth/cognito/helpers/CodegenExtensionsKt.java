package com.amplifyframework.auth.cognito.helpers;

import com.amplifyframework.auth.AuthProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodegenExtensions.kt */
/* loaded from: classes.dex */
public final class CodegenExtensionsKt {
    public static final String getIdentityProviderName(AuthProvider authProvider) {
        Intrinsics.checkNotNullParameter(authProvider, "<this>");
        if (Intrinsics.areEqual(authProvider, AuthProvider.amazon())) {
            return "www.amazon.com";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.facebook())) {
            return "graph.facebook.com";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.google())) {
            return "accounts.google.com";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.apple())) {
            return "appleid.apple.com";
        }
        String providerKey = authProvider.getProviderKey();
        Intrinsics.checkNotNullExpressionValue(providerKey, "providerKey");
        return providerKey;
    }

    public static final String getUserPoolProviderName(AuthProvider authProvider) {
        Intrinsics.checkNotNullParameter(authProvider, "<this>");
        if (Intrinsics.areEqual(authProvider, AuthProvider.amazon())) {
            return "LoginWithAmazon";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.facebook())) {
            return "Facebook";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.google())) {
            return "Google";
        }
        if (Intrinsics.areEqual(authProvider, AuthProvider.apple())) {
            return "SignInWithApple";
        }
        String providerKey = authProvider.getProviderKey();
        Intrinsics.checkNotNullExpressionValue(providerKey, "providerKey");
        return providerKey;
    }
}
