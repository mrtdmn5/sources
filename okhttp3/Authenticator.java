package okhttp3;

import java.io.IOException;

/* compiled from: Authenticator.kt */
/* loaded from: classes4.dex */
public interface Authenticator {
    public static final Authenticator$Companion$AuthenticatorNone NONE = new Authenticator$Companion$AuthenticatorNone();

    Request authenticate(Route route, Response response) throws IOException;
}
