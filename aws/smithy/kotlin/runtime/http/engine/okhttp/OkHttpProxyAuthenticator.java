package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.http.engine.ProxySelector;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.net.UserInfo;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okio.ByteString;

/* compiled from: OkHttpUtils.kt */
/* loaded from: classes.dex */
public final class OkHttpProxyAuthenticator implements Authenticator {
    public final ProxySelector selector;

    public OkHttpProxyAuthenticator(EnvironmentProxySelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @Override // okhttp3.Authenticator
    public final Request authenticate(Route route, Response response) {
        UserInfo userInfo;
        Request request = response.request;
        if (request.headers.get("Proxy-Authorization") != null) {
            return null;
        }
        HttpUrl httpUrl = request.url;
        ProxyConfig select = this.selector.select(new Url(new Scheme(httpUrl.scheme, httpUrl.port), Host.Companion.parse(httpUrl.host), httpUrl.port, null, null, null, null, false, 504));
        if (select instanceof ProxyConfig.Http) {
            userInfo = ((ProxyConfig.Http) select).url.userInfo;
        } else {
            userInfo = null;
        }
        if (userInfo == null) {
            return null;
        }
        for (Challenge challenge : response.challenges()) {
            String lowerCase = challenge.scheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(lowerCase, "okhttp-preemptive") || Intrinsics.areEqual(challenge.scheme, "Basic")) {
                Request.Builder builder = new Request.Builder(request);
                Charset charset = Charsets.ISO_8859_1;
                String username = userInfo.username;
                Intrinsics.checkNotNullParameter(username, "username");
                String password = userInfo.password;
                Intrinsics.checkNotNullParameter(password, "password");
                Intrinsics.checkNotNullParameter(charset, "charset");
                String str = username + ':' + password;
                ByteString byteString = ByteString.EMPTY;
                Intrinsics.checkNotNullParameter(str, "<this>");
                byte[] bytes = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                builder.header("Proxy-Authorization", "Basic ".concat(new ByteString(bytes).base64()));
                return new Request(builder);
            }
        }
        return null;
    }
}
