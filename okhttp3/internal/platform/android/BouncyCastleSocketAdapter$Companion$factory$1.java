package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.bouncycastle.jsse.BCSSLSocket;

/* compiled from: BouncyCastleSocketAdapter.kt */
/* loaded from: classes4.dex */
public final class BouncyCastleSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final SocketAdapter create(SSLSocket sSLSocket) {
        return new BouncyCastleSocketAdapter();
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        boolean z = BouncyCastlePlatform.isSupported;
        if (BouncyCastlePlatform.Companion.isSupported() && (sSLSocket instanceof BCSSLSocket)) {
            return true;
        }
        return false;
    }
}
