package androidx.compose.ui.modifier;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.transition.PathMotion;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public final class SingleLocalMap extends PathMotion {
    public final ModifierLocal<?> key;
    public final ParcelableSnapshotMutableState value$delegate;

    public SingleLocalMap(ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.value$delegate = Platform.mutableStateOf$default(null);
    }

    @Override // androidx.transition.PathMotion
    public final boolean contains$ui_release(ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == this.key) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.PathMotion
    public final Object get$ui_release(ProvidableModifierLocal key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == this.key) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            T value = this.value$delegate.getValue();
            if (value == 0) {
                return null;
            }
            return value;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
