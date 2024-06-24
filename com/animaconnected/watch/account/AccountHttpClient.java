package com.animaconnected.watch.account;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.http.HttpHeader;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import com.animaconnected.watch.utils.WatchLibException;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.ClientRequestException;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.RequestExceptionHandlerWrapper;
import io.ktor.client.plugins.ResponseException;
import io.ktor.client.plugins.ServerResponseException;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.ranges.IntRange;
import kotlin.reflect.TypesJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;
import org.slf4j.Logger;

/* compiled from: AccountHttpClient.kt */
/* loaded from: classes3.dex */
public final class AccountHttpClient {
    private String baseUrl;
    private final HttpClient client;
    private final String deleteAccountPath;
    private final String downloadDataPath;

    public AccountHttpClient(boolean z) {
        String str;
        if (z) {
            str = HttpUtilsKt.sandboxUrl;
        } else {
            str = HttpUtilsKt.liveUrl;
        }
        this.baseUrl = str;
        this.deleteAccountPath = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrl, "/v1/user");
        this.downloadDataPath = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrl, "/v1/user/export");
        this.client = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.account.AccountHttpClient$client$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.install(ContentNegotiation.Plugin, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.animaconnected.watch.account.AccountHttpClient$client$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentNegotiation.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        Json DefaultConfig = DefaultJsonConfigKt.DefaultConfig(Json.Default);
                        ContentType contentType = ContentType.Any;
                        JsonSupportKt.json(install, DefaultConfig, ContentType.Any);
                        ContentType contentType2 = ContentType.Application.Json;
                        JsonSupportKt.json(install, DefaultConfig, ContentType.Application.Json);
                    }
                });
                HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.account.AccountHttpClient$client$1.2
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
                HttpClient.expectSuccess = false;
                AnonymousClass3 block = new Function1<HttpCallValidator.Config, Unit>() { // from class: com.animaconnected.watch.account.AccountHttpClient$client$1.3

                    /* compiled from: AccountHttpClient.kt */
                    @DebugMetadata(c = "com.animaconnected.watch.account.AccountHttpClient$client$1$3$1", f = "AccountHttpClient.kt", l = {}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.watch.account.AccountHttpClient$client$1$3$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                        /* synthetic */ Object L$0;
                        int label;

                        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            boolean z;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                HttpResponse httpResponse = (HttpResponse) this.L$0;
                                int r0 = httpResponse.getStatus().value;
                                IntRange intRange = HttpUtilsKt.getCLIENT_REQUEST_EXCEPTION_RANGE();
                                int r2 = intRange.first;
                                boolean z2 = true;
                                if (r0 <= intRange.last && r2 <= r0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    IntRange intRange2 = HttpUtilsKt.getSERVER_RESPONSE_EXCEPTION_RANGE();
                                    int r5 = intRange2.first;
                                    if (r0 > intRange2.last || r5 > r0) {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        if (httpResponse.getStatus().value < 600) {
                                            return Unit.INSTANCE;
                                        }
                                        throw new ResponseException(httpResponse, "");
                                    }
                                    throw new ServerResponseException(httpResponse, "");
                                }
                                throw new ClientRequestException(httpResponse, "");
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    /* compiled from: AccountHttpClient.kt */
                    @DebugMetadata(c = "com.animaconnected.watch.account.AccountHttpClient$client$1$3$2", f = "AccountHttpClient.kt", l = {104}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.watch.account.AccountHttpClient$client$1$3$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2 extends SuspendLambda implements Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> {
                        /* synthetic */ Object L$0;
                        int label;

                        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                            super(3, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            ErrorResponse defaultError;
                            Throwable th;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    th = (Throwable) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                Throwable th2 = (Throwable) this.L$0;
                                if (th2 instanceof ResponseException) {
                                    HttpClientCall call = ((ResponseException) th2).response.getCall();
                                    TypeReference typeOf = Reflection.typeOf(ErrorResponse.class);
                                    TypeInfo typeInfo = new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(ErrorResponse.class), typeOf);
                                    this.L$0 = th2;
                                    this.label = 1;
                                    Object bodyNullable = call.bodyNullable(typeInfo, this);
                                    if (bodyNullable == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    th = th2;
                                    obj = bodyNullable;
                                } else {
                                    defaultError = WatchLibException.Companion.getDefaultError(th2.getMessage());
                                    throw new WatchLibException(defaultError);
                                }
                            }
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.animaconnected.watch.account.ErrorResponse");
                            }
                            defaultError = (ErrorResponse) obj;
                            defaultError.setStatusCode(new Integer(((ResponseException) th).response.getStatus().value));
                            throw new WatchLibException(defaultError);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Throwable th, HttpRequest httpRequest, Continuation<? super Unit> continuation) {
                            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                            anonymousClass2.L$0 = th;
                            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpCallValidator.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpCallValidator.Config HttpResponseValidator) {
                        Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                        HttpResponseValidator.responseValidators.add(new AnonymousClass1(null));
                        HttpResponseValidator.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(new AnonymousClass2(null)));
                    }
                };
                Logger logger = HttpCallValidatorKt.LOGGER;
                Intrinsics.checkNotNullParameter(block, "block");
                HttpClient.install(HttpCallValidator.Companion, block);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkDownloadAccountDataStatus(java.lang.String r8, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.ResponseDownloadDataUrl> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.watch.account.AccountHttpClient$checkDownloadAccountDataStatus$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.watch.account.AccountHttpClient$checkDownloadAccountDataStatus$1 r0 = (com.animaconnected.watch.account.AccountHttpClient$checkDownloadAccountDataStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.AccountHttpClient$checkDownloadAccountDataStatus$1 r0 = new com.animaconnected.watch.account.AccountHttpClient$checkDownloadAccountDataStatus$1
            r0.<init>(r7, r9)
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
            goto L83
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L61
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            java.lang.String r2 = r7.downloadDataPath
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder
            r5.<init>()
            io.ktor.client.request.HttpRequestKt.url(r5, r2)
            java.util.List<java.lang.String> r2 = io.ktor.http.HttpHeaders.UnsafeHeadersList
            java.lang.String r2 = "Authorization"
            io.ktor.http.HeadersBuilder r6 = r5.headers
            r6.append(r2, r8)
            io.ktor.http.HttpMethod r8 = io.ktor.http.HttpMethod.Get
            r5.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r5, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L61
            return r1
        L61:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r8 = r9.getCall()
            java.lang.Class<com.animaconnected.watch.account.ResponseDownloadDataUrl> r9 = com.animaconnected.watch.account.ResponseDownloadDataUrl.class
            kotlin.jvm.internal.TypeReference r2 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.jvm.internal.ClassReference r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r9, r2)
            r0.label = r3
            java.lang.Object r9 = r8.bodyNullable(r5, r0)
            if (r9 != r1) goto L83
            return r1
        L83:
            if (r9 == 0) goto L88
            com.animaconnected.watch.account.ResponseDownloadDataUrl r9 = (com.animaconnected.watch.account.ResponseDownloadDataUrl) r9
            return r9
        L88:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type com.animaconnected.watch.account.ResponseDownloadDataUrl"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.AccountHttpClient.checkDownloadAccountDataStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object deleteAccount(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String str2 = this.deleteAccountPath;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str2);
        List<String> list = HttpHeaders.UnsafeHeadersList;
        httpRequestBuilder.headers.append(HttpHeader.AUTHORIZATION, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Delete);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object initiateDownloadAccountData(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String str2 = this.downloadDataPath;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str2);
        List<String> list = HttpHeaders.UnsafeHeadersList;
        httpRequestBuilder.headers.append(HttpHeader.AUTHORIZATION, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }
}
