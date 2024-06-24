package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import org.slf4j.Logger;

/* compiled from: HttpRedirect.kt */
/* loaded from: classes3.dex */
public final class HttpRedirectKt {
    public static final Set<HttpMethod> ALLOWED_FOR_REDIRECT;
    public static final Logger LOGGER;

    static {
        HttpMethod httpMethod = HttpMethod.Get;
        ALLOWED_FOR_REDIRECT = SetsKt__SetsKt.setOf((Object[]) new HttpMethod[]{HttpMethod.Get, HttpMethod.Head});
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
    }

    public static final boolean access$isRedirect(HttpStatusCode httpStatusCode) {
        boolean z;
        boolean z2;
        boolean z3;
        int r3 = httpStatusCode.value;
        if (r3 == HttpStatusCode.MovedPermanently.value || r3 == HttpStatusCode.Found.value) {
            z = true;
        } else {
            z = false;
        }
        if (z || r3 == HttpStatusCode.TemporaryRedirect.value) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || r3 == HttpStatusCode.PermanentRedirect.value) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && r3 != HttpStatusCode.SeeOther.value) {
            return false;
        }
        return true;
    }
}
