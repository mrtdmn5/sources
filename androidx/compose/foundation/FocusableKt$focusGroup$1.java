package androidx.compose.foundation;

import androidx.compose.ui.focus.FocusProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableKt$focusGroup$1 extends Lambda implements Function1<FocusProperties, Unit> {
    public static final FocusableKt$focusGroup$1 INSTANCE = new FocusableKt$focusGroup$1();

    public FocusableKt$focusGroup$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(FocusProperties focusProperties) {
        FocusProperties focusProperties2 = focusProperties;
        Intrinsics.checkNotNullParameter(focusProperties2, "$this$focusProperties");
        focusProperties2.setCanFocus(false);
        return Unit.INSTANCE;
    }
}
