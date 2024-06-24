package androidx.compose.ui.focus;

import androidx.compose.foundation.FocusableKt$focusGroup$1;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public final class FocusPropertiesKt {
    public static final Modifier focusProperties(Modifier modifier, FocusableKt$focusGroup$1 scope) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return modifier.then(new FocusPropertiesElement(scope));
    }
}
