package androidx.core.graphics;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.compose.ui.geometry.GeometryUtilsKt;
import androidx.core.content.res.ResourcesCompat;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class TypefaceCompat {
    public static final LruCache<String, Typeface> sTypefaceCache;
    public static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    /* loaded from: classes.dex */
    public static class ResourcesCallbackAdapter extends GeometryUtilsKt {
        public final ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }
    }

    static {
        boolean z;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (r0 >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (r0 >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else {
            Method method = TypefaceCompatApi24Impl.sAddFontWeightStyle;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
            } else {
                sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
            }
        }
        sTypefaceCache = new LruCache<>(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:            if (r0.equals(r4) == false) goto L98;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context r7, androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry r8, android.content.res.Resources r9, int r10, java.lang.String r11, int r12, int r13, androidx.core.content.res.ResourcesCompat.FontCallback r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(android.content.Context, androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry, android.content.res.Resources, int, java.lang.String, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, boolean):android.graphics.Typeface");
    }

    public static String createResourceUid(Resources resources, int r2, String str, int r4, int r5) {
        return resources.getResourcePackageName(r2) + '-' + str + '-' + r4 + '-' + r2 + '-' + r5;
    }
}
