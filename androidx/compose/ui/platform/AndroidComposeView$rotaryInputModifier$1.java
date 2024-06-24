package androidx.compose.ui.platform;

import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeView$rotaryInputModifier$1 extends Lambda implements Function1<RotaryScrollEvent, Boolean> {
    public static final AndroidComposeView$rotaryInputModifier$1 INSTANCE = new AndroidComposeView$rotaryInputModifier$1();

    public AndroidComposeView$rotaryInputModifier$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
        RotaryScrollEvent it = rotaryScrollEvent;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.FALSE;
    }
}
