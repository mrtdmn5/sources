package aws.smithy.kotlin.runtime.io;

import java.io.Closeable;

/* compiled from: SdkManagedCloseable.kt */
/* loaded from: classes.dex */
public class SdkManagedCloseable extends SdkManagedBase {
    public final Closeable closeable;

    public SdkManagedCloseable(Closeable closeable) {
        this.closeable = closeable;
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkManaged
    public final boolean unshare() {
        boolean z;
        synchronized (this.state) {
            SdkManagedBase$state$1 sdkManagedBase$state$1 = this.state;
            z = false;
            if (!sdkManagedBase$state$1.isUnshared) {
                int r2 = sdkManagedBase$state$1.shareCount - 1;
                sdkManagedBase$state$1.shareCount = r2;
                if (r2 <= 0) {
                    z = true;
                    sdkManagedBase$state$1.isUnshared = true;
                }
            }
        }
        if (z) {
            this.closeable.close();
        }
        return z;
    }
}
