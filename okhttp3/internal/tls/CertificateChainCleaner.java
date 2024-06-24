package okhttp3.internal.tls;

import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificateChainCleaner.kt */
/* loaded from: classes4.dex */
public abstract class CertificateChainCleaner {
    public abstract List clean(String str, List list) throws SSLPeerUnverifiedException;
}
