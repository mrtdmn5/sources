package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.unit.IntSize;
import com.google.common.collect.Platform;

/* compiled from: AnimatedVisibility.kt */
/* loaded from: classes.dex */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    public final ParcelableSnapshotMutableState targetSize = Platform.mutableStateOf$default(new IntSize(0));

    public AnimatedVisibilityScopeImpl(Transition<EnterExitState> transition) {
    }
}
