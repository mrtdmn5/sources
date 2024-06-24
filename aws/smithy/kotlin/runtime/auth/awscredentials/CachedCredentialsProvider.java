package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.CachedValue;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: CachedCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class CachedCredentialsProvider implements CloseableCredentialsProvider {
    public static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(CachedCredentialsProvider.class, "closed");
    public final CachedValue<Credentials> cachedCredentials;
    public final Clock clock;
    public volatile /* synthetic */ int closed;
    public final CredentialsProvider source;

    public CachedCredentialsProvider(CredentialsProviderChain credentialsProviderChain) {
        int r0 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.SECONDS;
        DurationKt.toDuration(STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS, durationUnit);
        long duration = DurationKt.toDuration(10, durationUnit);
        Clock.System system = Clock.System.INSTANCE;
        this.source = credentialsProviderChain;
        this.clock = system;
        this.cachedCredentials = new CachedValue<>(duration, system);
        this.closed = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        this.cachedCredentials.close();
        MagicApiIntrinsics.closeIfCloseable(this.source);
    }
}
