package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation", f = "ContentNegotiation.kt", l = {180}, m = "convertRequest$ktor_client_content_negotiation")
/* loaded from: classes3.dex */
public final class ContentNegotiation$convertRequest$1 extends ContinuationImpl {
    public HttpRequestBuilder L$0;
    public Object L$1;
    public ContentType L$2;
    public List L$3;
    public Iterator L$4;
    public ContentNegotiation.Config.ConverterRegistration L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ContentNegotiation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$convertRequest$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$convertRequest$1> continuation) {
        super(continuation);
        this.this$0 = contentNegotiation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.convertRequest$ktor_client_content_negotiation(null, null, this);
    }
}
