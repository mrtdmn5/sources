package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.Url;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation", f = "ContentNegotiation.kt", l = {230}, m = "convertResponse$ktor_client_content_negotiation")
/* loaded from: classes3.dex */
public final class ContentNegotiation$convertResponse$1 extends ContinuationImpl {
    public Url L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ContentNegotiation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$convertResponse$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$convertResponse$1> continuation) {
        super(continuation);
        this.this$0 = contentNegotiation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.convertResponse$ktor_client_content_negotiation(null, null, null, null, null, this);
    }
}
