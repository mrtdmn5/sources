package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.TempListUtilsKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: PlatformTypefaces.kt */
/* loaded from: classes.dex */
public final class PlatformTypefacesKt {
    public static final Typeface setFontVariationSettings(Typeface typeface, FontVariation$Settings variationSettings, Context context) {
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        if (Build.VERSION.SDK_INT >= 26) {
            ThreadLocal<Paint> threadLocal = TypefaceCompatApi26.threadLocalPaint;
            if (typeface == null) {
                return null;
            }
            ArrayList arrayList = variationSettings.settings;
            if (!arrayList.isEmpty()) {
                ThreadLocal<Paint> threadLocal2 = TypefaceCompatApi26.threadLocalPaint;
                Paint paint = threadLocal2.get();
                if (paint == null) {
                    paint = new Paint();
                    threadLocal2.set(paint);
                }
                paint.setTypeface(typeface);
                paint.setFontVariationSettings(TempListUtilsKt.fastJoinToString$default(arrayList, null, new TypefaceCompatApi26$toAndroidString$1(TimeZoneKt.Density(context)), 31));
                return paint.getTypeface();
            }
            return typeface;
        }
        return typeface;
    }
}
