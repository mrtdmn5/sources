package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.util.Buildable;
import java.io.Closeable;

/* compiled from: SdkClient.kt */
/* loaded from: classes.dex */
public interface SdkClient extends Closeable {

    /* compiled from: SdkClient.kt */
    /* loaded from: classes.dex */
    public interface Builder<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient> extends Buildable<TClient> {
        TConfigBuilder getConfig();
    }
}
