package com.animaconnected.watch.account.fitness;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.http.HttpHeader;
import com.animaconnected.watch.account.HttpUtilsKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
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

/* compiled from: FitnessHttpClient.kt */
/* loaded from: classes3.dex */
public final class FitnessHttpClient {
    private String baseUrl;
    private final HttpClient bucketClient;
    private final HttpClient client;
    private final String deletePath;
    private final String downloadPath;
    private final String uploadPath;

    public FitnessHttpClient(boolean z) {
        String str;
        if (z) {
            str = HttpUtilsKt.sandboxUrl;
        } else {
            str = HttpUtilsKt.liveUrl;
        }
        this.baseUrl = str;
        this.uploadPath = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrl, "/v1/user/fitness/upload?");
        this.downloadPath = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrl, "/v1/user/fitness/fetch?");
        this.deletePath = "https://api.domain-for-sandbox.com/v1/user/fitness/delete";
        this.client = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.account.fitness.FitnessHttpClient$client$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.install(ContentNegotiation.Plugin, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.animaconnected.watch.account.fitness.FitnessHttpClient$client$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentNegotiation.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        JsonSupportKt.json$default(install, null, 3);
                    }
                });
                HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.account.fitness.FitnessHttpClient$client$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                        invoke2(httpTimeoutCapabilityConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        int r0 = Duration.$r8$clinit;
                        install.setRequestTimeoutMillis(Long.valueOf(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.MINUTES))));
                    }
                });
            }
        });
        this.bucketClient = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: io.ktor.client.HttpClientJvmKt$HttpClient$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(HttpClientConfig<?> httpClientConfig) {
                Intrinsics.checkNotNullParameter(httpClientConfig, "$this$null");
                return Unit.INSTANCE;
            }
        });
    }

    public final Object deleteData(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String str2 = this.deletePath;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str2);
        List<String> list = HttpHeaders.UnsafeHeadersList;
        httpRequestBuilder.headers.append(HttpHeader.AUTHORIZATION, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object downloadData(java.lang.String r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.account.fitness.FitnessHttpClient$downloadData$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.account.fitness.FitnessHttpClient$downloadData$1 r0 = (com.animaconnected.watch.account.fitness.FitnessHttpClient$downloadData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.fitness.FitnessHttpClient$downloadData$1 r0 = new com.animaconnected.watch.account.fitness.FitnessHttpClient$downloadData$1
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
            goto L78
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.HttpClient r8 = r6.bucketClient
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            io.ktor.client.request.HttpRequestKt.url(r2, r7)
            io.ktor.http.HttpMethod r7 = io.ktor.http.HttpMethod.Get
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r8)
            r0.label = r4
            java.lang.Object r8 = r7.execute(r0)
            if (r8 != r1) goto L56
            return r1
        L56:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.client.call.HttpClientCall r7 = r8.getCall()
            java.lang.Class<byte[]> r8 = byte[].class
            kotlin.jvm.internal.TypeReference r2 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r8, r2)
            r0.label = r3
            java.lang.Object r8 = r7.bodyNullable(r5, r0)
            if (r8 != r1) goto L78
            return r1
        L78:
            if (r8 == 0) goto L7d
            byte[] r8 = (byte[]) r8
            return r8
        L7d:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.ByteArray"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessHttpClient.downloadData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchDownloadUrls(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.ResponseDownloadUrls> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchDownloadUrls$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchDownloadUrls$1 r0 = (com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchDownloadUrls$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchDownloadUrls$1 r0 = new com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchDownloadUrls$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8c
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6a
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r6.downloadPath
            java.lang.String r7 = androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0.m(r2, r5, r7)
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            io.ktor.client.request.HttpRequestKt.url(r2, r7)
            java.util.List<java.lang.String> r7 = io.ktor.http.HttpHeaders.UnsafeHeadersList
            java.lang.String r7 = "Authorization"
            io.ktor.http.HeadersBuilder r5 = r2.headers
            r5.append(r7, r8)
            io.ktor.http.HttpMethod r7 = io.ktor.http.HttpMethod.Get
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L6a
            return r1
        L6a:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<com.animaconnected.watch.account.fitness.ResponseDownloadUrls> r8 = com.animaconnected.watch.account.fitness.ResponseDownloadUrls.class
            kotlin.jvm.internal.TypeReference r9 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            io.ktor.util.reflect.TypeInfo r4 = new io.ktor.util.reflect.TypeInfo
            r4.<init>(r2, r8, r9)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r4, r0)
            if (r9 != r1) goto L8c
            return r1
        L8c:
            if (r9 == 0) goto L91
            com.animaconnected.watch.account.fitness.ResponseDownloadUrls r9 = (com.animaconnected.watch.account.fitness.ResponseDownloadUrls) r9
            return r9
        L91:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.animaconnected.watch.account.fitness.ResponseDownloadUrls"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessHttpClient.fetchDownloadUrls(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchUploadUrls(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.fitness.ResponseUploadUrls> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchUploadUrls$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchUploadUrls$1 r0 = (com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchUploadUrls$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchUploadUrls$1 r0 = new com.animaconnected.watch.account.fitness.FitnessHttpClient$fetchUploadUrls$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8c
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6a
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r6.uploadPath
            java.lang.String r7 = androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0.m(r2, r5, r7)
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            io.ktor.client.request.HttpRequestKt.url(r2, r7)
            java.util.List<java.lang.String> r7 = io.ktor.http.HttpHeaders.UnsafeHeadersList
            java.lang.String r7 = "Authorization"
            io.ktor.http.HeadersBuilder r5 = r2.headers
            r5.append(r7, r8)
            io.ktor.http.HttpMethod r7 = io.ktor.http.HttpMethod.Get
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L6a
            return r1
        L6a:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<com.animaconnected.watch.account.fitness.ResponseUploadUrls> r8 = com.animaconnected.watch.account.fitness.ResponseUploadUrls.class
            kotlin.jvm.internal.TypeReference r9 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            io.ktor.util.reflect.TypeInfo r4 = new io.ktor.util.reflect.TypeInfo
            r4.<init>(r2, r8, r9)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r4, r0)
            if (r9 != r1) goto L8c
            return r1
        L8c:
            if (r9 == 0) goto L91
            com.animaconnected.watch.account.fitness.ResponseUploadUrls r9 = (com.animaconnected.watch.account.fitness.ResponseUploadUrls) r9
            return r9
        L91:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.animaconnected.watch.account.fitness.ResponseUploadUrls"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessHttpClient.fetchUploadUrls(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object uploadData(String str, byte[] bArr, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.bucketClient;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.GZip);
        if (bArr == null) {
            httpRequestBuilder.body = NullBody.INSTANCE;
            TypeReference typeOf = Reflection.typeOf(byte[].class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(byte[].class), typeOf));
        } else if (bArr instanceof OutgoingContent) {
            httpRequestBuilder.body = bArr;
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.body = bArr;
            TypeReference typeOf2 = Reflection.typeOf(byte[].class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(byte[].class), typeOf2));
        }
        httpRequestBuilder.setMethod(HttpMethod.Put);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }
}
