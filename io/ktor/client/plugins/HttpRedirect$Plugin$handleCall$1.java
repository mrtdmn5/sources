package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocol;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: HttpRedirect.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin", f = "HttpRedirect.kt", l = {113}, m = "handleCall")
/* loaded from: classes3.dex */
public final class HttpRedirect$Plugin$handleCall$1 extends ContinuationImpl {
    public HttpRedirect.Plugin L$0;
    public Sender L$1;
    public HttpRequestBuilder L$2;
    public HttpClient L$3;
    public Ref$ObjectRef L$4;
    public Ref$ObjectRef L$5;
    public URLProtocol L$6;
    public String L$7;
    public Ref$ObjectRef L$8;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpRedirect.Plugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$handleCall$1(HttpRedirect.Plugin plugin, Continuation<? super HttpRedirect$Plugin$handleCall$1> continuation) {
        super(continuation);
        this.this$0 = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpRedirect.Plugin.access$handleCall(this.this$0, null, null, null, false, null, this);
    }
}
