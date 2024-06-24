package okhttp3.internal.cache;

import okhttp3.Request;
import okhttp3.Response;

/* compiled from: CacheStrategy.kt */
/* loaded from: classes4.dex */
public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }
}
