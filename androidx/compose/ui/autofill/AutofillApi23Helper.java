package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAutofill.android.kt */
/* loaded from: classes.dex */
public final class AutofillApi23Helper {
    public static final AutofillApi23Helper INSTANCE = new AutofillApi23Helper();

    public final int addChildCount(ViewStructure structure, int r3) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        return structure.addChildCount(r3);
    }

    public final ViewStructure newChild(ViewStructure structure, int r3) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        return structure.newChild(r3);
    }

    public final void setDimens(ViewStructure structure, int r3, int r4, int r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.setDimens(r3, r4, r5, r6, r7, r8);
    }

    public final void setId(ViewStructure structure, int r3, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.setId(r3, str, str2, str3);
    }
}
