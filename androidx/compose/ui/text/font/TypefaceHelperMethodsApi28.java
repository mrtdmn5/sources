package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontUtils.android.kt */
/* loaded from: classes.dex */
public final class TypefaceHelperMethodsApi28 {
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    public final Typeface create(Typeface typeface, int r3, boolean z) {
        Typeface create;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        create = Typeface.create(typeface, r3, z);
        Intrinsics.checkNotNullExpressionValue(create, "create(typeface, finalFontWeight, finalFontStyle)");
        return create;
    }
}
