package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1;
import java.io.Closeable;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public interface InstanceMetadataProvider extends Closeable {
    Object get(ImdsCredentialsProvider$loadProfile$1 imdsCredentialsProvider$loadProfile$1);
}
