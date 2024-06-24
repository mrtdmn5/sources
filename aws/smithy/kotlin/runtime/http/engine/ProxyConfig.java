package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.Url;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProxyConfig.kt */
/* loaded from: classes.dex */
public abstract class ProxyConfig {

    /* compiled from: ProxyConfig.kt */
    /* loaded from: classes.dex */
    public static final class Direct extends ProxyConfig {
        public static final Direct INSTANCE = new Direct();
    }

    /* compiled from: ProxyConfig.kt */
    /* loaded from: classes.dex */
    public static final class Http extends ProxyConfig {
        public final Url url;

        public Http(Url url) {
            this.url = url;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Http) && Intrinsics.areEqual(this.url, ((Http) obj).url)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.url.hashCode();
        }

        public final String toString() {
            return "Http(url=" + this.url + ')';
        }
    }
}
