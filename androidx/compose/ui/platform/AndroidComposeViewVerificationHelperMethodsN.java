package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewVerificationHelperMethodsN {
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    public final void setPointerIcon(View view, PointerIcon pointerIcon) {
        android.view.PointerIcon systemIcon;
        Intrinsics.checkNotNullParameter(view, "view");
        if (pointerIcon instanceof AndroidPointerIcon) {
            ((AndroidPointerIcon) pointerIcon).getClass();
            systemIcon = null;
        } else if (pointerIcon instanceof AndroidPointerIconType) {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), ((AndroidPointerIconType) pointerIcon).type);
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(view.context, icon.type)");
        } else {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), 1000);
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(\n         …DEFAULT\n                )");
        }
        if (!Intrinsics.areEqual(view.getPointerIcon(), systemIcon)) {
            view.setPointerIcon(systemIcon);
        }
    }
}
