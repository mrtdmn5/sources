package aws.smithy.kotlin.runtime.io;

/* compiled from: SdkManaged.kt */
/* loaded from: classes.dex */
public abstract class SdkManagedBase implements SdkManaged {
    public final SdkManagedBase$state$1 state = new SdkManagedBase$state$1();

    @Override // aws.smithy.kotlin.runtime.io.SdkManaged
    public final void share() {
        synchronized (this.state) {
            SdkManagedBase$state$1 sdkManagedBase$state$1 = this.state;
            if (!sdkManagedBase$state$1.isUnshared) {
                sdkManagedBase$state$1.shareCount++;
            } else {
                throw new IllegalStateException("caller attempted to share() a fully unshared object".toString());
            }
        }
    }
}
