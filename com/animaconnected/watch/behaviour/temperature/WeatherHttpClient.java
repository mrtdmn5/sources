package com.animaconnected.watch.behaviour.temperature;

import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;

/* compiled from: WeatherHttpClient.kt */
/* loaded from: classes3.dex */
public final class WeatherHttpClient {
    private final Function0<String> apiKey;
    private final Lazy client$delegate;

    public WeatherHttpClient(Function0<String> apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.client$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HttpClient>() { // from class: com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$client$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HttpClient invoke() {
                return HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$client$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                        invoke2(httpClientConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpClientConfig<?> HttpClient) {
                        Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                        HttpClient.install(ContentNegotiation.Plugin, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.animaconnected.watch.behaviour.temperature.WeatherHttpClient.client.2.1.1
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
                        HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.behaviour.temperature.WeatherHttpClient.client.2.1.2
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
        });
    }

    private final String currentWeatherUrl(Spot spot) {
        return "https://api.openweathermap.org/data/2.5/weather?lat=" + spot.latitude + "&lon=" + spot.longitude + "&units=metric&APPID=" + this.apiKey.invoke();
    }

    private final HttpClient getClient() {
        return (HttpClient) this.client$delegate.getValue();
    }

    private final String historicalWeatherUrl(Spot spot) {
        return "https://api.openweathermap.org/data/2.5/onecall?lat=" + spot.latitude + "&lon=" + spot.longitude + "&exclude=minutely,alerts&units=metric&appid=" + this.apiKey.invoke();
    }

    public final Object fetchCurrentWeather(Spot spot, Continuation<? super HttpResponse> continuation) {
        HttpClient client = getClient();
        String currentWeatherUrl = currentWeatherUrl(spot);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, currentWeatherUrl);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Get);
        return new HttpStatement(httpRequestBuilder, client).execute(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchHistoricalWeather(com.animaconnected.watch.location.Spot r7, kotlin.coroutines.Continuation<? super com.animaconnected.watch.behaviour.temperature.Weather> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$fetchHistoricalWeather$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$fetchHistoricalWeather$1 r0 = (com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$fetchHistoricalWeather$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$fetchHistoricalWeather$1 r0 = new com.animaconnected.watch.behaviour.temperature.WeatherHttpClient$fetchHistoricalWeather$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7e
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5c
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.HttpClient r8 = r6.getClient()
            java.lang.String r7 = r6.historicalWeatherUrl(r7)
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            io.ktor.client.request.HttpRequestKt.url(r2, r7)
            io.ktor.http.HttpMethod r7 = io.ktor.http.HttpMethod.Get
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r8)
            r0.label = r4
            java.lang.Object r8 = r7.execute(r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.client.call.HttpClientCall r7 = r8.getCall()
            java.lang.Class<com.animaconnected.watch.behaviour.temperature.Weather> r8 = com.animaconnected.watch.behaviour.temperature.Weather.class
            kotlin.jvm.internal.TypeReference r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r8)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r8, r2)
            r0.label = r3
            java.lang.Object r8 = r7.bodyNullable(r5, r0)
            if (r8 != r1) goto L7e
            return r1
        L7e:
            com.animaconnected.watch.behaviour.temperature.Weather r8 = (com.animaconnected.watch.behaviour.temperature.Weather) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.temperature.WeatherHttpClient.fetchHistoricalWeather(com.animaconnected.watch.location.Spot, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
