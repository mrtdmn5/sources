package androidx.compose.ui.node;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: OwnerSnapshotObserver.kt */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver$clearInvalidObservations$1 extends Lambda implements Function1<Object, Boolean> {
    public static final OwnerSnapshotObserver$clearInvalidObservations$1 INSTANCE = new OwnerSnapshotObserver$clearInvalidObservations$1();

    public OwnerSnapshotObserver$clearInvalidObservations$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!((OwnerScope) it).isValidOwnerScope());
    }
}
