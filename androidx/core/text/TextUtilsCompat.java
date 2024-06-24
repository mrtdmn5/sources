package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextUtilsCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        new Locale("", "");
    }
}
