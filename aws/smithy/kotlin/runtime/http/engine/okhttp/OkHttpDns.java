package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.net.DefaultHostResolver;
import aws.smithy.kotlin.runtime.net.HostResolver;
import java.net.InetAddress;
import java.util.List;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Dns;

/* compiled from: OkHttpUtils.kt */
/* loaded from: classes.dex */
public final class OkHttpDns implements Dns {
    public final HostResolver hr;

    public OkHttpDns(DefaultHostResolver hr) {
        Intrinsics.checkNotNullParameter(hr, "hr");
        this.hr = hr;
    }

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String hostname) {
        Object runBlocking;
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        runBlocking = BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new OkHttpDns$lookup$1(this, hostname, null));
        return (List) runBlocking;
    }
}
