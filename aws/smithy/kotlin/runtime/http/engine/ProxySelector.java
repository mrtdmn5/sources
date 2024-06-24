package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.Url;

/* compiled from: ProxySelector.kt */
/* loaded from: classes.dex */
public interface ProxySelector {
    ProxyConfig select(Url url);
}
