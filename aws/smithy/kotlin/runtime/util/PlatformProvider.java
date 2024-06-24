package aws.smithy.kotlin.runtime.util;

/* compiled from: Platform.kt */
/* loaded from: classes.dex */
public interface PlatformProvider extends PlatformEnvironProvider, Filesystem {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Platform.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final SystemDefaultProvider System = SystemDefaultProvider.INSTANCE;
    }

    OperatingSystem osInfo();
}
