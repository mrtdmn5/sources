package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteChannelCtorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
/* loaded from: classes3.dex */
public final class SavedHttpCall extends HttpClientCall {
    public final boolean allowDoubleReceive;
    public final byte[] responseBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient client, HttpRequest httpRequest, HttpResponse httpResponse, byte[] bArr) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        this.responseBody = bArr;
        this.request = new SavedHttpRequest(this, httpRequest);
        this.response = new SavedHttpResponse(this, bArr, httpResponse);
        this.allowDoubleReceive = true;
    }

    @Override // io.ktor.client.call.HttpClientCall
    public final boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }

    @Override // io.ktor.client.call.HttpClientCall
    public final Object getResponseContent() {
        return ByteChannelCtorKt.ByteReadChannel(this.responseBody);
    }
}
