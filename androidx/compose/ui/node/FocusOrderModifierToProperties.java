package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
/* loaded from: classes.dex */
public final class FocusOrderModifierToProperties implements Function1<FocusProperties, Unit> {
    public final FocusOrderModifier modifier;

    public FocusOrderModifierToProperties(FocusOrderModifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.modifier = modifier;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(FocusProperties focusProperties) {
        FocusProperties focusProperties2 = focusProperties;
        Intrinsics.checkNotNullParameter(focusProperties2, "focusProperties");
        this.modifier.populateFocusOrder();
        return Unit.INSTANCE;
    }
}
