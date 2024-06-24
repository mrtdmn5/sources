package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultRegistry.kt */
/* loaded from: classes.dex */
public final class ManagedActivityResultLauncher<I, O> extends ActivityResultLauncher<I> {
    public final State<ActivityResultContract<I, O>> contract;
    public final ActivityResultLauncherHolder<I> launcher;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder launcher, MutableState mutableState) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.launcher = launcher;
        this.contract = mutableState;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void launch(Object obj) {
        this.launcher.launch(obj);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void unregister() {
        throw new UnsupportedOperationException("Registration is automatically handled by rememberLauncherForActivityResult");
    }
}
