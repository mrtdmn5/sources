package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.plugins.HttpSend;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpSend.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail}, m = "execute")
/* loaded from: classes3.dex */
public final class HttpSend$DefaultSender$execute$1 extends ContinuationImpl {
    public HttpSend.DefaultSender L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpSend.DefaultSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$DefaultSender$execute$1(HttpSend.DefaultSender defaultSender, Continuation<? super HttpSend$DefaultSender$execute$1> continuation) {
        super(continuation);
        this.this$0 = defaultSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
