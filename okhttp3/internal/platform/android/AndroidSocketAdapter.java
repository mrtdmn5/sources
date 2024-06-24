package okhttp3.internal.platform.android;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

/* compiled from: AndroidSocketAdapter.kt */
/* loaded from: classes4.dex */
public class AndroidSocketAdapter implements SocketAdapter {
    public static final AndroidSocketAdapter$Companion$factory$1 playProviderFactory = new DeferredSocketAdapter.Factory() { // from class: okhttp3.internal.platform.android.AndroidSocketAdapter$Companion$factory$1
        public final /* synthetic */ String $packageName = "com.google.android.gms.org.conscrypt";

        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public final SocketAdapter create(SSLSocket sSLSocket) {
            Class<?> cls = sSLSocket.getClass();
            Class<?> cls2 = cls;
            while (!Intrinsics.areEqual(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            return new AndroidSocketAdapter(cls2);
        }

        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public final boolean matchesSocket(SSLSocket sSLSocket) {
            return StringsKt__StringsJVMKt.startsWith(sSLSocket.getClass().getName(), this.$packageName + '.', false);
        }
    };
    public final Method getAlpnSelectedProtocol;
    public final Method setAlpnProtocols;
    public final Method setHostname;
    public final Method setUseSessionTickets;
    public final Class<? super SSLSocket> sslSocketClass;

    public AndroidSocketAdapter(Class<? super SSLSocket> cls) {
        this.sslSocketClass = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = cls.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.setHostname.invoke(sSLSocket, str);
                }
                Method method = this.setAlpnProtocols;
                Platform platform = Platform.platform;
                method.invoke(sSLSocket, Platform.Companion.concatLengthPrefixed(protocols));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        if (!this.sslSocketClass.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, Charsets.UTF_8);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if ((cause instanceof NullPointerException) && Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e2);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean isSupported() {
        boolean z = AndroidPlatform.isSupported;
        return AndroidPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public final boolean matchesSocket(SSLSocket sSLSocket) {
        return this.sslSocketClass.isInstance(sSLSocket);
    }
}
