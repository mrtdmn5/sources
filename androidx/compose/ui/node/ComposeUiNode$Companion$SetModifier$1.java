package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetModifier$1 extends Lambda implements Function2<ComposeUiNode, Modifier, Unit> {
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE = new ComposeUiNode$Companion$SetModifier$1();

    public ComposeUiNode$Companion$SetModifier$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ComposeUiNode composeUiNode, Modifier modifier) {
        ComposeUiNode composeUiNode2 = composeUiNode;
        Modifier it = modifier;
        Intrinsics.checkNotNullParameter(composeUiNode2, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        composeUiNode2.setModifier(it);
        return Unit.INSTANCE;
    }
}
