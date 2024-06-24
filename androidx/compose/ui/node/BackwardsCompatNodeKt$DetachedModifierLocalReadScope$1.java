package androidx.compose.ui.node;

import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 implements ModifierLocalReadScope {
    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    public final Object getCurrent(ProvidableModifierLocal providableModifierLocal) {
        Intrinsics.checkNotNullParameter(providableModifierLocal, "<this>");
        return providableModifierLocal.defaultFactory.invoke();
    }
}
