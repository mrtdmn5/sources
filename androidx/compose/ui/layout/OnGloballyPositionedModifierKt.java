package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnGloballyPositionedModifier.kt */
/* loaded from: classes.dex */
public final class OnGloballyPositionedModifierKt {
    public static final Modifier onGloballyPositioned(Modifier modifier, Function1<? super LayoutCoordinates, Unit> onGloballyPositioned) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        return modifier.then(new OnGloballyPositionedElement(onGloballyPositioned));
    }
}
