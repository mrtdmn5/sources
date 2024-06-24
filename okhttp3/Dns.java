package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.kt */
/* loaded from: classes4.dex */
public interface Dns {
    public static final Dns$Companion$DnsSystem SYSTEM = new Dns$Companion$DnsSystem();

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
