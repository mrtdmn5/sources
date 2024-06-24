package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Protocol.kt */
/* loaded from: classes4.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic"),
    HTTP_3("h3");

    public static final Companion Companion = new Companion();
    private final String protocol;

    /* compiled from: Protocol.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static Protocol get(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                                protocol2 = Protocol.QUIC;
                                if (!Intrinsics.areEqual(protocol, protocol2.protocol)) {
                                    protocol2 = Protocol.HTTP_3;
                                    if (!StringsKt__StringsJVMKt.startsWith(protocol, protocol2.protocol, false)) {
                                        throw new IOException("Unexpected protocol: ".concat(protocol));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        Companion.getClass();
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
