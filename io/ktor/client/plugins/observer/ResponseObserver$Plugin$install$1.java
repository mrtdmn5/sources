package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt$split$1;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.slf4j.MDCContext;

/* compiled from: ResponseObserver.kt */
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", l = {68, 80}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ResponseObserver $plugin;
    public final /* synthetic */ HttpClient $scope;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ HttpResponse L$1;
    public HttpResponse L$2;
    public HttpClient L$3;
    public int label;

    /* compiled from: ResponseObserver.kt */
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1", f = "ResponseObserver.kt", l = {70, 76}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ResponseObserver $plugin;
        public final /* synthetic */ HttpResponse $sideResponse;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ResponseObserver responseObserver, HttpResponse httpResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$plugin = responseObserver;
            this.$sideResponse = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$plugin, this.$sideResponse, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            HttpResponse httpResponse = this.$sideResponse;
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Function2<HttpResponse, Continuation<? super Unit>, Object> function2 = this.$plugin.responseHandler;
                this.label = 1;
                if (function2.invoke(httpResponse, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            ByteReadChannel content = httpResponse.getContent();
            if (!content.isClosedForRead()) {
                this.label = 2;
                if (content.discard(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation<? super ResponseObserver$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = responseObserver;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.$plugin, this.$scope, continuation);
        responseObserver$Plugin$install$1.L$0 = pipelineContext;
        responseObserver$Plugin$install$1.L$1 = httpResponse;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        boolean z;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        HttpClient httpClient;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        ResponseObserver responseObserver = this.$plugin;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            httpClient = this.L$3;
            httpResponse = this.L$2;
            httpResponse2 = this.L$1;
            pipelineContext = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            pipelineContext = this.L$0;
            HttpResponse httpResponse3 = this.L$1;
            Function1<HttpClientCall, Boolean> function1 = responseObserver.filter;
            if (function1 != null && !function1.invoke(httpResponse3.getCall()).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return Unit.INSTANCE;
            }
            ByteReadChannel content = httpResponse3.getContent();
            Intrinsics.checkNotNullParameter(content, "<this>");
            final ByteBufferChannel byteBufferChannel = new ByteBufferChannel(true);
            final ByteBufferChannel byteBufferChannel2 = new ByteBufferChannel(true);
            BuildersKt.launch$default(httpResponse3, null, null, new ByteChannelsKt$split$1(content, byteBufferChannel, byteBufferChannel2, null), 3).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$split$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    Throwable th2 = th;
                    if (th2 != null) {
                        byteBufferChannel.cancel(th2);
                        byteBufferChannel2.cancel(th2);
                    }
                    return Unit.INSTANCE;
                }
            });
            HttpResponse response = ProgressionUtilKt.wrapWithContent(httpResponse3.getCall(), byteBufferChannel2).getResponse();
            HttpResponse response2 = ProgressionUtilKt.wrapWithContent(httpResponse3.getCall(), byteBufferChannel).getResponse();
            this.L$0 = pipelineContext;
            this.L$1 = response;
            this.L$2 = response2;
            HttpClient httpClient2 = this.$scope;
            this.L$3 = httpClient2;
            this.label = 1;
            Object obj2 = (MDCContext) getContext().get(MDCContext.Key);
            if (obj2 == null) {
                obj2 = EmptyCoroutineContext.INSTANCE;
            }
            if (obj2 == coroutineSingletons) {
                return coroutineSingletons;
            }
            Object obj3 = obj2;
            httpResponse = response2;
            obj = obj3;
            httpResponse2 = response;
            httpClient = httpClient2;
        }
        BuildersKt.launch$default(httpClient, (CoroutineContext) obj, null, new AnonymousClass1(responseObserver, httpResponse, null), 2);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpResponse2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
