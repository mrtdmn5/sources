package io.ktor.client.statement;

import java.nio.charset.CharsetDecoder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpResponse.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {97}, m = "bodyAsText")
/* loaded from: classes3.dex */
public final class HttpResponseKt$bodyAsText$1 extends ContinuationImpl {
    public CharsetDecoder L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpResponseKt.bodyAsText(null, null, this);
    }
}
