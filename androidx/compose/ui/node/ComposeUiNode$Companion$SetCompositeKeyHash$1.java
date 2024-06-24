package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetCompositeKeyHash$1 extends Lambda implements Function2<ComposeUiNode, Integer, Unit> {
    public static final ComposeUiNode$Companion$SetCompositeKeyHash$1 INSTANCE = new ComposeUiNode$Companion$SetCompositeKeyHash$1();

    public ComposeUiNode$Companion$SetCompositeKeyHash$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ComposeUiNode composeUiNode, Integer num) {
        ComposeUiNode composeUiNode2 = composeUiNode;
        num.intValue();
        Intrinsics.checkNotNullParameter(composeUiNode2, "$this$null");
        composeUiNode2.setCompositeKeyHash();
        return Unit.INSTANCE;
    }
}
