package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* compiled from: DeferredSocketAdapter.kt */
/* loaded from: classes4.dex */
public final class DeferredSocketAdapter implements SocketAdapter {
    public SocketAdapter delegate;
    public final Factory socketAdapterFactory;

    /* compiled from: DeferredSocketAdapter.kt */
    /* loaded from: classes4.dex */
    public interface Factory {
        SocketAdapter create(SSLSocket sSLSocket);

        boolean matchesSocket(SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(Factory factory) {
        this.socketAdapterFactory = factory;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> protocols) {
        SocketAdapter socketAdapter;
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        synchronized (this) {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
            socketAdapter = this.delegate;
        }
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        SocketAdapter socketAdapter;
        synchronized (this) {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
            socketAdapter = this.delegate;
        }
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.socketAdapterFactory.matchesSocket(sSLSocket);
    }
}
