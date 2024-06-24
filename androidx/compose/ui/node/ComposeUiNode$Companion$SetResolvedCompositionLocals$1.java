package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetResolvedCompositionLocals$1 extends Lambda implements Function2<ComposeUiNode, CompositionLocalMap, Unit> {
    public static final ComposeUiNode$Companion$SetResolvedCompositionLocals$1 INSTANCE = new ComposeUiNode$Companion$SetResolvedCompositionLocals$1();

    public ComposeUiNode$Companion$SetResolvedCompositionLocals$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ComposeUiNode composeUiNode, CompositionLocalMap compositionLocalMap) {
        ComposeUiNode composeUiNode2 = composeUiNode;
        CompositionLocalMap it = compositionLocalMap;
        Intrinsics.checkNotNullParameter(composeUiNode2, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        composeUiNode2.setCompositionLocalMap(it);
        return Unit.INSTANCE;
    }
}
