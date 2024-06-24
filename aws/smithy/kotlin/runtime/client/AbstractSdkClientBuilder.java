package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder;

/* compiled from: AbstractSdkClientBuilder.kt */
/* loaded from: classes.dex */
public abstract class AbstractSdkClientBuilder<TConfig extends SdkClientConfig, TConfigBuilder extends SdkClientConfig.Builder<TConfig>, TClient extends SdkClient> implements SdkClient.Builder<TConfig, TConfigBuilder, TClient> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.util.Buildable
    public final Object build() {
        return newClient((SdkClientConfig) getConfig().build());
    }

    public abstract TClient newClient(TConfig tconfig);
}
