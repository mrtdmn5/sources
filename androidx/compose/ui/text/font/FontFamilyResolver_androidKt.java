package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;

/* compiled from: FontFamilyResolver.android.kt */
/* loaded from: classes.dex */
public final class FontFamilyResolver_androidKt {
    public static final FontFamilyResolverImpl createFontFamilyResolver(Context context) {
        int r4;
        AndroidFontLoader androidFontLoader = new AndroidFontLoader(context);
        if (Build.VERSION.SDK_INT >= 31) {
            r4 = context.getResources().getConfiguration().fontWeightAdjustment;
        } else {
            r4 = 0;
        }
        return new FontFamilyResolverImpl(androidFontLoader, new AndroidFontResolveInterceptor(r4));
    }
}
