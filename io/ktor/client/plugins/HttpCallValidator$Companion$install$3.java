package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$3", f = "HttpCallValidator.kt", l = {R.styleable.AppTheme_stepsHistoryLegendColorActivity, R.styleable.AppTheme_stepsHistoryLegendColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpCallValidator$Companion$install$3 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    public final /* synthetic */ HttpCallValidator $plugin;
    public /* synthetic */ Object L$0;
    public /* synthetic */ HttpRequestBuilder L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$3(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$3> continuation) {
        super(3, continuation);
        this.$plugin = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpCallValidator$Companion$install$3 httpCallValidator$Companion$install$3 = new HttpCallValidator$Companion$install$3(this.$plugin, continuation);
        httpCallValidator$Companion$install$3.L$0 = sender;
        httpCallValidator$Companion$install$3.L$1 = httpRequestBuilder;
        return httpCallValidator$Companion$install$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    HttpClientCall httpClientCall = (HttpClientCall) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return httpClientCall;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            Sender sender = (Sender) this.L$0;
            HttpRequestBuilder httpRequestBuilder = this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = sender.execute(httpRequestBuilder, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        HttpClientCall httpClientCall2 = (HttpClientCall) obj;
        HttpResponse response = httpClientCall2.getResponse();
        this.L$0 = httpClientCall2;
        this.label = 2;
        if (HttpCallValidator.access$validateResponse(this.$plugin, response, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return httpClientCall2;
    }
}
