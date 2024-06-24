package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontLoader.android.kt */
/* loaded from: classes.dex */
public final class ResourceFontHelper {
    public static final ResourceFontHelper INSTANCE = new ResourceFontHelper();

    public final Typeface load(Context context, ResourceFont font) {
        Typeface font2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(font, "font");
        font2 = context.getResources().getFont(font.resId);
        Intrinsics.checkNotNullExpressionValue(font2, "context.resources.getFont(font.resId)");
        return font2;
    }
}
