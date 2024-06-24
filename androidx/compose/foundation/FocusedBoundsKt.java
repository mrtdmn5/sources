package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
public final class FocusedBoundsKt {
    public static final ProvidableModifierLocal<Function1<LayoutCoordinates, Unit>> ModifierLocalFocusedBoundsObserver = ModifierLocalKt.modifierLocalOf(new Function0<Function1<? super LayoutCoordinates, ? extends Unit>>() { // from class: androidx.compose.foundation.FocusedBoundsKt$ModifierLocalFocusedBoundsObserver$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Function1<? super LayoutCoordinates, ? extends Unit> invoke() {
            return null;
        }
    });

    public static final Modifier onFocusedBoundsChanged(Modifier modifier, ContentInViewModifier$modifier$1 contentInViewModifier$modifier$1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new FocusedBoundsObserverElement(contentInViewModifier$modifier$1));
    }
}
