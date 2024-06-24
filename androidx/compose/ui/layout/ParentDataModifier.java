package androidx.compose.ui.layout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;

/* compiled from: ParentDataModifier.kt */
/* loaded from: classes.dex */
public interface ParentDataModifier extends Modifier.Element {
    AnimatedContentTransitionScopeImpl.ChildData modifyParentData(Density density);
}
