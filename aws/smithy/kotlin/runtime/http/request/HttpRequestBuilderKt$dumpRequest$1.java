package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.io.SdkBuffer;
import com.animaconnected.secondo.R;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpRequestBuilder.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt", f = "HttpRequestBuilder.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail}, m = "dumpRequest")
/* loaded from: classes.dex */
public final class HttpRequestBuilderKt$dumpRequest$1 extends ContinuationImpl {
    public HttpRequestBuilder L$0;
    public SdkBuffer L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpRequestBuilderKt.dumpRequest(null, false, this);
    }
}
