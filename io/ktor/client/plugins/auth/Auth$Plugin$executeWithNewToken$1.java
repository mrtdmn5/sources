package io.ktor.client.plugins.auth;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.Sender;
import io.ktor.client.plugins.auth.Auth;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Auth.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.Auth$Plugin", f = "Auth.kt", l = {R.styleable.AppTheme_stepsHistoryLegendColorActivity, R.styleable.AppTheme_stepsHistoryLineLegendColorActivity}, m = "executeWithNewToken")
/* loaded from: classes3.dex */
public final class Auth$Plugin$executeWithNewToken$1 extends ContinuationImpl {
    public Auth.Plugin L$0;
    public Sender L$1;
    public HttpClientCall L$2;
    public HttpRequestBuilder L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Auth.Plugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Auth$Plugin$executeWithNewToken$1(Auth.Plugin plugin, Continuation<? super Auth$Plugin$executeWithNewToken$1> continuation) {
        super(continuation);
        this.this$0 = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Auth.Plugin.access$executeWithNewToken(this.this$0, null, null, null, null, null, this);
    }
}
