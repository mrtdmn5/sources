package io.ktor.client;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.BodyProgress;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1;
import io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2;
import io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainText;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.plugins.HttpRequestLifecycle;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.events.EventDefinition;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmBase;
import io.ktor.util.ConcurrentSafeAttributes;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import org.slf4j.Logger;

/* compiled from: HttpClient.kt */
/* loaded from: classes3.dex */
public final class HttpClient implements CoroutineScope, Closeable {
    public static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");
    public final AttributesJvmBase attributes;
    public final JobImpl clientJob;
    private volatile /* synthetic */ int closed;
    public final HttpClientConfig<HttpClientEngineConfig> config;
    public final CoroutineContext coroutineContext;
    public final HttpClientEngine engine;
    public final boolean manageEngine;
    public final Events monitor;
    public final HttpReceivePipeline receivePipeline;
    public final HttpRequestPipeline requestPipeline;
    public final HttpResponsePipeline responsePipeline;
    public final HttpSendPipeline sendPipeline;

    /* compiled from: HttpClient.kt */
    /* renamed from: io.ktor.client.HttpClient$1 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            if (th != null) {
                CoroutineScopeKt.cancel(HttpClient.this.engine, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HttpClient.kt */
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", l = {R.styleable.AppTheme_stepsHistoryGoalLineColorDetail, R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.HttpClient$2 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        public /* synthetic */ PipelineContext L$0;
        public /* synthetic */ Object L$1;
        public int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = obj;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            PipelineContext pipelineContext;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$1;
                pipelineContext = this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = this.L$0;
                obj2 = this.L$1;
                if (obj2 instanceof HttpClientCall) {
                    HttpReceivePipeline httpReceivePipeline = HttpClient.this.receivePipeline;
                    Unit unit = Unit.INSTANCE;
                    HttpResponse response = ((HttpClientCall) obj2).getResponse();
                    this.L$0 = pipelineContext2;
                    this.L$1 = obj2;
                    this.label = 1;
                    Object execute = httpReceivePipeline.execute(unit, response, this);
                    if (execute == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    pipelineContext = pipelineContext2;
                    obj = execute;
                } else {
                    throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj2 + '(' + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ").").toString());
                }
            }
            HttpResponse response2 = (HttpResponse) obj;
            HttpClientCall httpClientCall = (HttpClientCall) obj2;
            httpClientCall.getClass();
            Intrinsics.checkNotNullParameter(response2, "response");
            httpClientCall.response = response2;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (pipelineContext.proceedWith(obj2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HttpClient.kt */
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", l = {R.styleable.AppTheme_topPusherDropZoneNotSelected}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.HttpClient$4 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        public /* synthetic */ PipelineContext L$0;
        public int label;

        public AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = pipelineContext;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext;
            Throwable th;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    pipelineContext = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        Events events = HttpClient.this.monitor;
                        EventDefinition<Object> eventDefinition = ClientEventsKt.HttpResponseReceiveFailed;
                        ((HttpClientCall) pipelineContext.context).getResponse();
                        events.raise(eventDefinition);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = this.L$0;
                try {
                    this.L$0 = pipelineContext2;
                    this.label = 1;
                    if (pipelineContext2.proceed(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Throwable th3) {
                    pipelineContext = pipelineContext2;
                    th = th3;
                    Events events2 = HttpClient.this.monitor;
                    EventDefinition<Object> eventDefinition2 = ClientEventsKt.HttpResponseReceiveFailed;
                    ((HttpClientCall) pipelineContext.context).getResponse();
                    events2.raise(eventDefinition2);
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public HttpClient() {
        throw null;
    }

    public HttpClient(HttpClientEngine engine, HttpClientConfig httpClientConfig) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.engine = engine;
        this.closed = 0;
        JobImpl jobImpl = new JobImpl((Job) engine.getCoroutineContext().get(Job.Key.$$INSTANCE));
        this.clientJob = jobImpl;
        this.coroutineContext = engine.getCoroutineContext().plus(jobImpl);
        this.requestPipeline = new HttpRequestPipeline(httpClientConfig.developmentMode);
        this.responsePipeline = new HttpResponsePipeline(httpClientConfig.developmentMode);
        HttpSendPipeline httpSendPipeline = new HttpSendPipeline(httpClientConfig.developmentMode);
        this.sendPipeline = httpSendPipeline;
        this.receivePipeline = new HttpReceivePipeline(httpClientConfig.developmentMode);
        this.attributes = new ConcurrentSafeAttributes();
        engine.getConfig();
        this.monitor = new Events();
        final HttpClientConfig<HttpClientEngineConfig> httpClientConfig2 = new HttpClientConfig<>();
        this.config = httpClientConfig2;
        if (this.manageEngine) {
            jobImpl.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClient.1
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    if (th != null) {
                        CoroutineScopeKt.cancel(HttpClient.this.engine, null);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        engine.install(this);
        httpSendPipeline.intercept(HttpSendPipeline.Receive, new AnonymousClass2(null));
        HttpRequestLifecycle.Plugin plugin = HttpRequestLifecycle.Plugin;
        HttpClientConfig$install$1 httpClientConfig$install$1 = HttpClientConfig$install$1.INSTANCE;
        httpClientConfig2.install(plugin, httpClientConfig$install$1);
        httpClientConfig2.install(BodyProgress.Plugin, httpClientConfig$install$1);
        if (httpClientConfig.useDefaultTransformers) {
            HttpClient$3$1 block = new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClient$3$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(HttpClient httpClient) {
                    HttpClient install = httpClient;
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    Logger logger = DefaultTransformKt.LOGGER;
                    install.requestPipeline.intercept(HttpRequestPipeline.Render, new DefaultTransformKt$defaultTransformers$1(null));
                    PipelinePhase pipelinePhase = HttpResponsePipeline.Parse;
                    DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(null);
                    HttpResponsePipeline httpResponsePipeline = install.responsePipeline;
                    httpResponsePipeline.intercept(pipelinePhase, defaultTransformKt$defaultTransformers$2);
                    httpResponsePipeline.intercept(pipelinePhase, new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(null));
                    return Unit.INSTANCE;
                }
            };
            Intrinsics.checkNotNullParameter(block, "block");
            httpClientConfig2.customInterceptors.put("DefaultTransformers", block);
        }
        httpClientConfig2.install(HttpSend.Plugin, httpClientConfig$install$1);
        HttpCallValidator.Companion companion = HttpCallValidator.Companion;
        httpClientConfig2.install(companion, httpClientConfig$install$1);
        if (httpClientConfig.followRedirects) {
            httpClientConfig2.install(HttpRedirect.Plugin, httpClientConfig$install$1);
        }
        httpClientConfig2.followRedirects = httpClientConfig.followRedirects;
        httpClientConfig2.useDefaultTransformers = httpClientConfig.useDefaultTransformers;
        httpClientConfig2.expectSuccess = httpClientConfig.expectSuccess;
        httpClientConfig2.plugins.putAll(httpClientConfig.plugins);
        httpClientConfig2.pluginConfigurations.putAll(httpClientConfig.pluginConfigurations);
        httpClientConfig2.customInterceptors.putAll(httpClientConfig.customInterceptors);
        if (httpClientConfig.useDefaultTransformers) {
            httpClientConfig2.install(HttpPlainText.Plugin, httpClientConfig$install$1);
        }
        AttributeKey<Unit> attributeKey = DefaultResponseValidationKt.ValidateMark;
        Function1<HttpCallValidator.Config, Unit> function1 = new Function1<HttpCallValidator.Config, Unit>() { // from class: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1

            /* compiled from: DefaultResponseValidation.kt */
            @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {42, 48}, m = "invokeSuspend")
            /* renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                public int I$0;
                public /* synthetic */ Object L$0;
                public HttpResponse L$1;
                public int label;

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

                /* JADX WARN: Can't wrap try/catch for region: R(7:1|(1:(1:(9:5|6|7|8|9|(1:32)(1:12)|(3:14|(1:30)(1:17)|(2:(1:28)|(1:23)(1:27))(1:29))(1:31)|24|25)(2:36|37))(1:38))(2:47|(2:49|50)(2:51|(2:59|60)(2:55|(1:57)(1:58))))|39|40|41|(1:43)(8:44|8|9|(0)|32|(0)(0)|24|25)|(1:(0))) */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:            r0 = r1;        r3 = r5;        r1 = r11;     */
                /* JADX WARN: Removed duplicated region for block: B:11:0x00c7 A[ADDED_TO_REGION] */
                /* JADX WARN: Removed duplicated region for block: B:14:0x00ce  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        Method dump skipped, instructions count: 293
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(HttpCallValidator.Config config) {
                HttpCallValidator.Config HttpResponseValidator = config;
                Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.expectSuccess = httpClientConfig2.expectSuccess;
                HttpResponseValidator.responseValidators.add(new AnonymousClass1(null));
                return Unit.INSTANCE;
            }
        };
        Logger logger = HttpCallValidatorKt.LOGGER;
        httpClientConfig2.install(companion, function1);
        Iterator it = httpClientConfig2.plugins.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
        Iterator it2 = httpClientConfig2.customInterceptors.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(this);
        }
        this.responsePipeline.intercept(HttpResponsePipeline.Receive, new AnonymousClass4(null));
        this.manageEngine = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Attributes attributes = (Attributes) this.attributes.get(HttpClientPluginKt.PLUGIN_INSTALLED_LIST);
        Iterator<T> it = attributes.getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            Object obj = attributes.get(attributeKey);
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            }
        }
        this.clientJob.complete();
        if (this.manageEngine) {
            this.engine.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.HttpClient$execute$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.HttpClient$execute$1 r0 = (io.ktor.client.HttpClient$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.HttpClient$execute$1 r0 = new io.ktor.client.HttpClient$execute$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.events.EventDefinition<io.ktor.client.request.HttpRequestBuilder> r6 = io.ktor.client.utils.ClientEventsKt.HttpRequestCreated
            io.ktor.events.Events r2 = r4.monitor
            r2.raise(r6)
            java.lang.Object r6 = r5.body
            r0.label = r3
            io.ktor.client.request.HttpRequestPipeline r2 = r4.requestPipeline
            java.lang.Object r6 = r2.execute(r5, r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.lang.String r5 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.HttpClient.execute$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final String toString() {
        return "HttpClient[" + this.engine + ']';
    }
}
