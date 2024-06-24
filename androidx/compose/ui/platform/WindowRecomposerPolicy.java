package androidx.compose.ui.platform;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: WindowRecomposer.android.kt */
/* loaded from: classes.dex */
public final class WindowRecomposerPolicy {
    public static final AtomicReference<WindowRecomposerFactory> factory;

    static {
        WindowRecomposerFactory.Companion.getClass();
        factory = new AtomicReference<>(WindowRecomposerFactory$Companion$LifecycleAware$1.INSTANCE);
    }
}
