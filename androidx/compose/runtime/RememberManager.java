package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public interface RememberManager {
    void deactivating(ComposeNodeLifecycleCallback composeNodeLifecycleCallback);

    void forgetting(RememberObserver rememberObserver);

    void releasing(ComposeNodeLifecycleCallback composeNodeLifecycleCallback);

    void remembering(RememberObserver rememberObserver);

    void sideEffect(Function0<Unit> function0);
}
