package com.animaconnected.watch.account.profile;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.animaconnected.watch.account.HttpUtilsKt;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;

/* compiled from: ProfileHttpClient.kt */
/* loaded from: classes3.dex */
public final class ProfileHttpClient {
    private String baseUrl;
    private final HttpClient client;
    private final String tag = "ProfileHttpClient";
    private final String userProfilePath;

    public ProfileHttpClient(boolean z) {
        String str;
        if (z) {
            str = HttpUtilsKt.sandboxUrl;
        } else {
            str = HttpUtilsKt.liveUrl;
        }
        this.baseUrl = str;
        this.userProfilePath = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrl, "/v1/user/profile");
        this.client = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.account.profile.ProfileHttpClient$client$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.install(ContentNegotiation.Plugin, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.animaconnected.watch.account.profile.ProfileHttpClient$client$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentNegotiation.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        JsonSupportKt.json$default(install, DefaultJsonConfigKt.DefaultConfig(Json.Default), 2);
                    }
                });
                HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.account.profile.ProfileHttpClient$client$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                        invoke2(httpTimeoutCapabilityConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        int r0 = Duration.$r8$clinit;
                        install.setRequestTimeoutMillis(Long.valueOf(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(15, DurationUnit.SECONDS))));
                    }
                });
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getFitnessConfig(final java.lang.String r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<com.animaconnected.watch.fitness.FitnessConfig, com.animaconnected.watch.utils.WatchLibException>> r10) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileHttpClient.getFitnessConfig(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object putFitnessConfig(com.animaconnected.watch.fitness.FitnessConfig r9, final java.lang.String r10, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<kotlin.Unit, com.animaconnected.watch.utils.WatchLibException>> r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileHttpClient.putFitnessConfig(com.animaconnected.watch.fitness.FitnessConfig, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
