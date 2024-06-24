package okhttp3;

import com.google.android.gms.common.util.Clock;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Dns.kt */
/* loaded from: classes4.dex */
public final class Dns$Companion$DnsSystem implements Clock, Dns {
    public static final Dns$Companion$DnsSystem zza = new Dns$Companion$DnsSystem();

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // okhttp3.Dns
    public List lookup(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(hostname);
            Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
            return ArraysKt___ArraysKt.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostname));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
