package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;

/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public interface ComposeUiNode {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ComposeUiNode.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final LayoutNode$Companion$Constructor$1 Constructor = LayoutNode.Constructor;
        public static final ComposeUiNode$Companion$SetModifier$1 SetModifier = ComposeUiNode$Companion$SetModifier$1.INSTANCE;
        public static final ComposeUiNode$Companion$SetResolvedCompositionLocals$1 SetResolvedCompositionLocals = ComposeUiNode$Companion$SetResolvedCompositionLocals$1.INSTANCE;
        public static final ComposeUiNode$Companion$SetMeasurePolicy$1 SetMeasurePolicy = ComposeUiNode$Companion$SetMeasurePolicy$1.INSTANCE;
        public static final ComposeUiNode$Companion$SetCompositeKeyHash$1 SetCompositeKeyHash = ComposeUiNode$Companion$SetCompositeKeyHash$1.INSTANCE;
    }

    void setCompositeKeyHash();

    void setCompositionLocalMap(CompositionLocalMap compositionLocalMap);

    void setMeasurePolicy(MeasurePolicy measurePolicy);

    void setModifier(Modifier modifier);
}
