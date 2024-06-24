package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes3.dex */
public final class RedirectResponseException extends ResponseException {
    public final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedirectResponseException(HttpResponse response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.message = "Unhandled redirect: " + response.getCall().getRequest().getMethod().value + ' ' + response.getCall().getRequest().getUrl() + ". Status: " + response.getStatus() + ". Text: \"" + cachedResponseText + '\"';
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
