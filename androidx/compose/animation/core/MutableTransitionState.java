package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class MutableTransitionState<S> {
    public final ParcelableSnapshotMutableState currentState$delegate;
    public final ParcelableSnapshotMutableState isRunning$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
    public final ParcelableSnapshotMutableState targetState$delegate;

    public MutableTransitionState(S s) {
        this.currentState$delegate = Platform.mutableStateOf$default(s);
        this.targetState$delegate = Platform.mutableStateOf$default(s);
    }
}
