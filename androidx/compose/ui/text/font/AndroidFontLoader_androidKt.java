package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontLoader.android.kt */
/* loaded from: classes.dex */
public final class AndroidFontLoader_androidKt {
    public static final Typeface access$load(Context context, ResourceFont resourceFont) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ResourceFontHelper.INSTANCE.load(context, resourceFont);
        }
        Typeface font = ResourcesCompat.getFont(context, resourceFont.resId);
        Intrinsics.checkNotNull(font);
        return font;
    }
}
