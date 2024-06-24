package retrofit2;

import okhttp3.ResponseBody;
import okhttp3.internal._ResponseBodyCommonKt$commonAsResponseBody$1;

/* loaded from: classes4.dex */
public final class Response<T> {
    public final T body;
    public final ResponseBody errorBody;
    public final okhttp3.Response rawResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public Response(okhttp3.Response response, Object obj, _ResponseBodyCommonKt$commonAsResponseBody$1 _responsebodycommonkt_commonasresponsebody_1) {
        this.rawResponse = response;
        this.body = obj;
        this.errorBody = _responsebodycommonkt_commonasresponsebody_1;
    }

    public final String toString() {
        return this.rawResponse.toString();
    }
}
