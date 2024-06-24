package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ObserverModifierNode.kt */
/* loaded from: classes.dex */
public final class ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 extends Lambda implements Function1<ObserverNodeOwnerScope, Unit> {
    public static final ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 INSTANCE = new ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1();

    public ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ObserverNodeOwnerScope observerNodeOwnerScope) {
        ObserverNodeOwnerScope it = observerNodeOwnerScope;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isValidOwnerScope()) {
            it.observerNode.onObservedReadsChanged();
        }
        return Unit.INSTANCE;
    }
}
