package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import kotlin.Unit;

/* compiled from: ActivityResultRegistry.kt */
/* loaded from: classes.dex */
public final class ActivityResultLauncherHolder<I> {
    public ActivityResultLauncher<I> launcher;

    public final void launch(Object obj) {
        Unit unit;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(obj);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null) {
        } else {
            throw new IllegalStateException("Launcher has not been initialized".toString());
        }
    }
}
