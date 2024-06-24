package okhttp3;

import java.util.List;

/* compiled from: CookieJar.kt */
/* loaded from: classes4.dex */
public interface CookieJar {
    public static final CookieJar$Companion$NoCookies NO_COOKIES = new CookieJar$Companion$NoCookies();

    void loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
