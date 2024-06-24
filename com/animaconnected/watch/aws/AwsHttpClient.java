package com.animaconnected.watch.aws;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.TypesJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: AwsHttpClient.kt */
/* loaded from: classes3.dex */
public final class AwsHttpClient {
    private final HttpClient client;
    private final String region;

    public AwsHttpClient(String region) {
        Intrinsics.checkNotNullParameter(region, "region");
        this.region = region;
        this.client = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.aws.AwsHttpClient$client$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.aws.AwsHttpClient$client$1.1
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

    public static /* synthetic */ Object getRequest$default(AwsHttpClient awsHttpClient, String str, String str2, String str3, String str4, String str5, Continuation continuation, int r14, Object obj) {
        if ((r14 & 16) != 0) {
            str5 = "execute-api";
        }
        return awsHttpClient.getRequest(str, str2, str3, str4, str5, continuation);
    }

    public static /* synthetic */ Object postRequest$default(AwsHttpClient awsHttpClient, String str, String str2, String str3, String str4, String str5, String str6, Continuation continuation, int r17, Object obj) {
        String str7;
        if ((r17 & 32) != 0) {
            str7 = "execute-api";
        } else {
            str7 = str6;
        }
        return awsHttpClient.postRequest(str, str2, str3, str4, str5, str7, continuation);
    }

    public final Object getRequest(String str, String str2, String str3, String str4, String str5, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestExtensionsKt.signed(httpRequestBuilder, str2, str3, str4, this.region, str5);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Get);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object postRequest(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.Json);
        if (str2 == null) {
            httpRequestBuilder.body = NullBody.INSTANCE;
            TypeReference typeOf = Reflection.typeOf(String.class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(String.class), typeOf));
        } else if (str2 instanceof OutgoingContent) {
            httpRequestBuilder.body = str2;
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.body = str2;
            TypeReference typeOf2 = Reflection.typeOf(String.class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(String.class), typeOf2));
        }
        HttpRequestExtensionsKt.signed(httpRequestBuilder, str3, str4, str5, this.region, str6);
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }
}
