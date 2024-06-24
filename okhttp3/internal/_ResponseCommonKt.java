package okhttp3.internal;

import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: -ResponseCommon.kt */
/* loaded from: classes4.dex */
public final class _ResponseCommonKt {
    public static final void checkSupportResponse(String str, Response response) {
        boolean z;
        boolean z2;
        if (response != null) {
            boolean z3 = true;
            if (response.networkResponse == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (response.cacheResponse == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (response.priorResponse != null) {
                        z3 = false;
                    }
                    if (!z3) {
                        throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
        }
    }

    public static final Response stripBody(Response response) {
        Response.Builder builder = new Response.Builder(response);
        ResponseBody responseBody = response.body;
        builder.body = new UnreadableResponseBody(responseBody.contentType(), responseBody.contentLength());
        return builder.build();
    }
}
