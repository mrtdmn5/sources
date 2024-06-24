package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.platform.AndroidComposeView$snapshotObserver$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OwnerSnapshotObserver.kt */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver {
    public final SnapshotStateObserver observer;
    public final OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1 onCommitAffectingLookaheadMeasure = OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingMeasure$1 onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingSemantics$1 onCommitAffectingSemantics = OwnerSnapshotObserver$onCommitAffectingSemantics$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingLayout$1 onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1 onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1 onCommitAffectingLayoutModifierInLookahead = OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1.INSTANCE;
    public final OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1 onCommitAffectingLookaheadLayout = OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1.INSTANCE;

    public OwnerSnapshotObserver(AndroidComposeView$snapshotObserver$1 androidComposeView$snapshotObserver$1) {
        this.observer = new SnapshotStateObserver(androidComposeView$snapshotObserver$1);
    }

    public final <T extends OwnerScope> void observeReads$ui_release(T target, Function1<? super T, Unit> onChanged, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.observer.observeReads(target, onChanged, function0);
    }
}
