package io.ktor.client.engine.android;

import io.ktor.client.request.HttpRequestData;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidURLConnectionUtils.kt */
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidURLConnectionUtilsKt", f = "AndroidURLConnectionUtils.kt", l = {60}, m = "timeoutAwareConnection")
/* loaded from: classes3.dex */
public final class AndroidURLConnectionUtilsKt$timeoutAwareConnection$1<T> extends ContinuationImpl {
    public HttpRequestData L$0;
    public Throwable L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidURLConnectionUtilsKt.timeoutAwareConnection(null, null, null, this);
    }
}
