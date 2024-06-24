package com.animaconnected.watch.account.strava;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientConfig$install$1;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpRequestRetry$Configuration$retryOnServerErrors$1;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.auth.Auth;
import io.ktor.client.plugins.auth.providers.BearerAuthConfig;
import io.ktor.client.plugins.auth.providers.BearerAuthProvider;
import io.ktor.client.plugins.auth.providers.BearerTokens;
import io.ktor.client.plugins.auth.providers.RefreshTokensParams;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.plugins.logging.LogLevel;
import io.ktor.client.plugins.logging.Logger;
import io.ktor.client.plugins.logging.Logging;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.request.forms.ChannelProvider;
import io.ktor.client.request.forms.FormBuilder;
import io.ktor.client.request.forms.FormPart;
import io.ktor.client.request.forms.InputProvider;
import io.ktor.client.request.forms.MultiPartFormDataContent;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.Input;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.TypesJVMKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;

/* compiled from: StravaHttpClient.kt */
/* loaded from: classes3.dex */
public final class StravaHttpClient {
    private final String baseUrlV3;
    private final HttpClient client;
    private final Function0<Boolean> isHttpLoggingEnabled;
    private final Function1<Continuation<? super BearerTokens>, Object> refreshBearerTokens;
    private final String scope;

    /* JADX WARN: Multi-variable type inference failed */
    public StravaHttpClient(Function1<? super Continuation<? super BearerTokens>, ? extends Object> refreshBearerTokens, Function0<Boolean> isHttpLoggingEnabled) {
        Intrinsics.checkNotNullParameter(refreshBearerTokens, "refreshBearerTokens");
        Intrinsics.checkNotNullParameter(isHttpLoggingEnabled, "isHttpLoggingEnabled");
        this.refreshBearerTokens = refreshBearerTokens;
        this.isHttpLoggingEnabled = isHttpLoggingEnabled;
        this.baseUrlV3 = "https://www.strava.com/api/v3";
        this.scope = "read,activity:write";
        this.client = HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.install(ContentNegotiation.Plugin, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1.1
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
                HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1.2
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
                Auth.Plugin plugin = Auth.Plugin;
                final StravaHttpClient stravaHttpClient = StravaHttpClient.this;
                HttpClient.install(plugin, new Function1<Auth, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Auth auth) {
                        invoke2(auth);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Auth install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        final StravaHttpClient stravaHttpClient2 = StravaHttpClient.this;
                        Function1<BearerAuthConfig, Unit> function1 = new Function1<BearerAuthConfig, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient.client.1.3.1

                            /* compiled from: StravaHttpClient.kt */
                            @DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaHttpClient$client$1$3$1$1", f = "StravaHttpClient.kt", l = {42}, m = "invokeSuspend")
                            /* renamed from: com.animaconnected.watch.account.strava.StravaHttpClient$client$1$3$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes3.dex */
                            public static final class C00741 extends SuspendLambda implements Function2<RefreshTokensParams, Continuation<? super BearerTokens>, Object> {
                                int label;
                                final /* synthetic */ StravaHttpClient this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C00741(StravaHttpClient stravaHttpClient, Continuation<? super C00741> continuation) {
                                    super(2, continuation);
                                    this.this$0 = stravaHttpClient;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00741(this.this$0, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(RefreshTokensParams refreshTokensParams, Continuation<? super BearerTokens> continuation) {
                                    return ((C00741) create(refreshTokensParams, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Function1 function1;
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    int r1 = this.label;
                                    if (r1 != 0) {
                                        if (r1 == 1) {
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                        function1 = this.this$0.refreshBearerTokens;
                                        this.label = 1;
                                        obj = function1.invoke(this);
                                        if (obj == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                    return obj;
                                }
                            }

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(BearerAuthConfig bearerAuthConfig) {
                                invoke2(bearerAuthConfig);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(BearerAuthConfig bearer) {
                                Intrinsics.checkNotNullParameter(bearer, "$this$bearer");
                                bearer._refreshTokens = new C00741(StravaHttpClient.this, null);
                            }
                        };
                        BearerAuthConfig bearerAuthConfig = new BearerAuthConfig();
                        function1.invoke(bearerAuthConfig);
                        install.providers.add(new BearerAuthProvider(bearerAuthConfig._refreshTokens, bearerAuthConfig._loadTokens, bearerAuthConfig._sendWithoutRequest));
                    }
                });
                HttpClient.install(HttpRequestRetry.Plugin, new Function1<HttpRequestRetry.Configuration, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1.4
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpRequestRetry.Configuration install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        HttpRequestRetry$Configuration$retryOnServerErrors$1 block = HttpRequestRetry$Configuration$retryOnServerErrors$1.INSTANCE;
                        Intrinsics.checkNotNullParameter(block, "block");
                        install.maxRetries = 5;
                        install.shouldRetry = block;
                        AnonymousClass1 block2 = new Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient.client.1.4.1
                            @Override // kotlin.jvm.functions.Function3
                            public final Boolean invoke(final HttpRequestRetry.ShouldRetryContext retryOnExceptionIf, HttpRequestBuilder httpRequestBuilder, final Throwable cause) {
                                Intrinsics.checkNotNullParameter(retryOnExceptionIf, "$this$retryOnExceptionIf");
                                Intrinsics.checkNotNullParameter(httpRequestBuilder, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                LogKt.debug$default((Object) retryOnExceptionIf, StravaClient.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient.client.1.4.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder("Retry ");
                                        sb.append(HttpRequestRetry.ShouldRetryContext.this.retryCount);
                                        sb.append(". Reason: ");
                                        sb.append(Reflection.getOrCreateKotlinClass(cause.getClass()).getSimpleName());
                                        sb.append(" - ");
                                        return CreateIdentityPoolRequestMarshaller$$ExternalSyntheticOutline0.m(cause, sb);
                                    }
                                }, 6, (Object) null);
                                return Boolean.valueOf(cause instanceof IOException);
                            }
                        };
                        Intrinsics.checkNotNullParameter(block2, "block");
                        install.maxRetries = 5;
                        install.shouldRetryOnException = block2;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpRequestRetry.Configuration configuration) {
                        invoke2(configuration);
                        return Unit.INSTANCE;
                    }
                });
                Logging.Companion companion = Logging.Companion;
                final StravaHttpClient stravaHttpClient2 = StravaHttpClient.this;
                HttpClient.install(companion, new Function1<Logging.Config, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Logging.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Logging.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        final StravaHttpClient stravaHttpClient3 = StravaHttpClient.this;
                        install._logger = new Logger() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient.client.1.5.1
                            @Override // io.ktor.client.plugins.logging.Logger
                            public void log(final String message) {
                                Function0 function0;
                                Intrinsics.checkNotNullParameter(message, "message");
                                function0 = StravaHttpClient.this.isHttpLoggingEnabled;
                                if (((Boolean) function0.invoke()).booleanValue()) {
                                    LogKt.debug$default((Object) this, StravaClient.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$client$1$5$1$log$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final String invoke() {
                                            return message;
                                        }
                                    }, 6, (Object) null);
                                }
                            }
                        };
                        LogLevel logLevel = LogLevel.ALL;
                        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
                        install.level = logLevel;
                    }
                });
                HttpClient.install(StravaRateLimiterKt.getStravaRateLimitPlugin(), HttpClientConfig$install$1.INSTANCE);
            }
        });
    }

    private final String buildOAuthUrl(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?client_id=");
        sb.append(str2);
        sb.append("&redirect_uri=festina-strava-auth://apps.festinagroup.com&response_type=code&approval_prompt=auto&scope=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.scope, "&state=authorize");
    }

    private final void setAuthHeader(HttpRequestBuilder httpRequestBuilder, String str) {
        HeadersBuilder headersBuilder = httpRequestBuilder.headers;
        List<String> list = HttpHeaders.UnsafeHeadersList;
        headersBuilder.append(HttpHeader.AUTHORIZATION, "Bearer " + str);
    }

    public final Object authenticate(String str, String str2, String str3, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrlV3, "/oauth/token");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, m);
        UtilsKt.parameter(httpRequestBuilder, "client_id", str2);
        UtilsKt.parameter(httpRequestBuilder, "client_secret", str3);
        UtilsKt.parameter(httpRequestBuilder, "grant_type", "authorization_code");
        UtilsKt.parameter(httpRequestBuilder, AnalyticsConstants.KEY_CODE, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object createActivity(StravaActivity stravaActivity, String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrlV3, "/activities");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, m);
        setAuthHeader(httpRequestBuilder, str);
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.Json);
        if (stravaActivity == null) {
            httpRequestBuilder.body = NullBody.INSTANCE;
            TypeReference typeOf = Reflection.typeOf(StravaActivity.class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(StravaActivity.class), typeOf));
        } else if (stravaActivity instanceof OutgoingContent) {
            httpRequestBuilder.body = stravaActivity;
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.body = stravaActivity;
            TypeReference typeOf2 = Reflection.typeOf(StravaActivity.class);
            httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(StravaActivity.class), typeOf2));
        }
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final String getAppOAuthUrl(String clientId) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return buildOAuthUrl("strava://oauth/mobile/authorize", clientId);
    }

    public final Object getAthlete(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrlV3, "/athlete");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, m);
        setAuthHeader(httpRequestBuilder, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Get);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final String getScope() {
        return this.scope;
    }

    public final Object getUploadById(Long l, String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String str2 = this.baseUrlV3 + "/uploads/" + l;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str2);
        setAuthHeader(httpRequestBuilder, str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Get);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final String getWebOAuthUrl(String clientId) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return buildOAuthUrl("https://www.strava.com/oauth/mobile/authorize", clientId);
    }

    public final Object revokeAccess(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, "https://www.strava.com/oauth/deauthorize");
        setAuthHeader(httpRequestBuilder, str);
        UtilsKt.parameter(httpRequestBuilder, "access_token ", str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object updateToken(String str, String str2, String str3, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrlV3, "/oauth/token");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, m);
        UtilsKt.parameter(httpRequestBuilder, "client_id", str2);
        UtilsKt.parameter(httpRequestBuilder, "client_secret", str3);
        UtilsKt.parameter(httpRequestBuilder, "grant_type", "refresh_token");
        UtilsKt.parameter(httpRequestBuilder, "refresh_token", str);
        HttpMethod httpMethod = HttpMethod.Get;
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object uploadActivity(final byte[] bArr, String str, final String str2, Continuation<? super HttpResponse> continuation) {
        PartData binaryItem;
        HttpClient httpClient = this.client;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.baseUrlV3, "/uploads");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, m);
        setAuthHeader(httpRequestBuilder, str);
        Function1<FormBuilder, Unit> function1 = new Function1<FormBuilder, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaHttpClient$uploadActivity$2$parts$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FormBuilder formBuilder) {
                invoke2(formBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FormBuilder formData) {
                Intrinsics.checkNotNullParameter(formData, "$this$formData");
                byte[] value = bArr;
                Headers.Companion companion = Headers.Companion;
                HeadersBuilder headersBuilder = new HeadersBuilder(0);
                List<String> list = HttpHeaders.UnsafeHeadersList;
                headersBuilder.append("Content-Disposition", "form-data; name=file; filename=my_workout.tcx.gz");
                ContentType contentType = new ContentType("application", "vnd.garmin.tcx+xml", EmptyList.INSTANCE);
                Set<Character> set = HeaderValueWithParametersKt.HeaderFieldValueSeparators;
                headersBuilder.append("Content-Type", contentType.toString());
                headersBuilder.append("Content-Encoding", "gzip");
                Unit unit = Unit.INSTANCE;
                HeadersImpl build = headersBuilder.build();
                Intrinsics.checkNotNullParameter(value, "value");
                formData.parts.add(new FormPart("file", value, build));
                FormBuilder.append$default(formData, "data_type", "tcx.gz");
                FormBuilder.append$default(formData, "activity_type", str2);
            }
        };
        FormBuilder formBuilder = new FormBuilder();
        function1.invoke(formBuilder);
        FormPart[] formPartArr = (FormPart[]) formBuilder.parts.toArray(new FormPart[0]);
        FormPart[] values = (FormPart[]) Arrays.copyOf(formPartArr, formPartArr.length);
        Intrinsics.checkNotNullParameter(values, "values");
        ArrayList arrayList = new ArrayList();
        for (FormPart formPart : values) {
            String str3 = formPart.key;
            HeadersBuilder headersBuilder = new HeadersBuilder(0);
            List<String> list = HttpHeaders.UnsafeHeadersList;
            Set<Character> set = HeaderValueWithParametersKt.HeaderFieldValueSeparators;
            Intrinsics.checkNotNullParameter(str3, "<this>");
            if (HeaderValueWithParametersKt.needQuotes(str3)) {
                str3 = HeaderValueWithParametersKt.quote(str3);
            }
            headersBuilder.append("Content-Disposition", "form-data; name=".concat(str3));
            headersBuilder.appendAll(formPart.headers);
            final Object obj = formPart.value;
            if (obj instanceof String) {
                binaryItem = new PartData.FormItem((String) obj, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$1
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (obj instanceof Number) {
                binaryItem = new PartData.FormItem(obj.toString(), new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$2
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (obj instanceof Boolean) {
                binaryItem = new PartData.FormItem(obj.toString(), new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$3
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (obj instanceof byte[]) {
                headersBuilder.append("Content-Length", String.valueOf(((byte[]) obj).length));
                binaryItem = new PartData.BinaryItem(new Function0<Input>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Input invoke() {
                        final byte[] bArr2 = (byte[]) obj;
                        ByteBuffer wrap = ByteBuffer.wrap(bArr2, 0, bArr2.length);
                        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
                        return ByteReadPacketExtensionsKt.ByteReadPacket(wrap, new Function1<ByteBuffer, Unit>(bArr2) { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ByteBuffer byteBuffer) {
                                ByteBuffer it = byteBuffer;
                                Intrinsics.checkNotNullParameter(it, "it");
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$5
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (obj instanceof ByteReadPacket) {
                headersBuilder.append("Content-Length", String.valueOf(((ByteReadPacket) obj).getRemaining()));
                binaryItem = new PartData.BinaryItem(new Function0<Input>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Input invoke() {
                        return ((ByteReadPacket) obj).copy();
                    }
                }, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        ((ByteReadPacket) obj).close();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else {
                if (!(obj instanceof InputProvider)) {
                    if (!(obj instanceof ChannelProvider)) {
                        if (obj instanceof Input) {
                            throw new IllegalStateException(("Can't use [Input] as part of form: " + obj + ". Consider using [InputProvider] instead.").toString());
                        }
                        throw new IllegalStateException(("Unknown form content type: " + obj).toString());
                    }
                    ((ChannelProvider) obj).getClass();
                    new PartData.BinaryChannelItem(headersBuilder.build());
                    throw null;
                }
                ((InputProvider) obj).getClass();
                new PartData.BinaryItem(null, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$8
                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
                throw null;
            }
            arrayList.add(binaryItem);
        }
        httpRequestBuilder.body = new MultiPartFormDataContent(arrayList);
        httpRequestBuilder.setBodyType(null);
        httpRequestBuilder.setMethod(HttpMethod.Post);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }
}
