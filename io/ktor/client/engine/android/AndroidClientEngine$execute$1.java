package io.ktor.client.engine.android;

import io.ktor.util.date.GMTDate;
import java.net.HttpURLConnection;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngine", f = "AndroidClientEngine.kt", l = {43, 87, 90}, m = "execute")
/* loaded from: classes3.dex */
public final class AndroidClientEngine$execute$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public GMTDate L$2;
    public HttpURLConnection L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AndroidClientEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClientEngine$execute$1(AndroidClientEngine androidClientEngine, Continuation<? super AndroidClientEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = androidClientEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
