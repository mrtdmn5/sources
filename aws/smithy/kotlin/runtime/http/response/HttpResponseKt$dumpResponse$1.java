package aws.smithy.kotlin.runtime.http.response;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpResponse.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.response.HttpResponseKt", f = "HttpResponse.kt", l = {76}, m = "dumpResponse")
/* loaded from: classes.dex */
public final class HttpResponseKt$dumpResponse$1 extends ContinuationImpl {
    public HttpResponse L$0;
    public SdkBuffer L$1;
    public HttpResponse L$2;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpResponseKt.dumpResponse(null, false, this);
    }
}
