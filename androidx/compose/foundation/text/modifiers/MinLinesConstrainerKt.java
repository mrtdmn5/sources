package androidx.compose.foundation.text.modifiers;

import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MinLinesConstrainer.kt */
/* loaded from: classes.dex */
public final class MinLinesConstrainerKt {
    public static final String EmptyTextReplacement;
    public static final String TwoLineTextReplacement;

    static {
        String repeat = StringsKt__StringsJVMKt.repeat(10, "H");
        EmptyTextReplacement = repeat;
        TwoLineTextReplacement = repeat + '\n' + repeat;
    }
}
