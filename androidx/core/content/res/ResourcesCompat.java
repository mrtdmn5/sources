package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ResourcesCompat {
    public static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    public static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    public static final Object sColorStateCacheLock = new Object();

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static Drawable getDrawable(Resources resources, int r1, Resources.Theme theme) {
            return resources.getDrawable(r1, theme);
        }

        public static Drawable getDrawableForDensity(Resources resources, int r1, int r2, Resources.Theme theme) {
            return resources.getDrawableForDensity(r1, r2, theme);
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static int getColor(Resources resources, int r1, Resources.Theme theme) {
            return resources.getColor(r1, theme);
        }

        public static ColorStateList getColorStateList(Resources resources, int r1, Resources.Theme theme) {
            return resources.getColorStateList(r1, theme);
        }
    }

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        public final Configuration mConfiguration;
        public final int mThemeHash;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int hashCode;
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            if (theme == null) {
                hashCode = 0;
            } else {
                hashCode = theme.hashCode();
            }
            this.mThemeHash = hashCode;
        }
    }

    /* loaded from: classes.dex */
    public static final class ColorStateListCacheKey {
        public final Resources mResources;
        public final Resources.Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat$Api19Impl.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ObjectsCompat$Api19Impl.hash(this.mResources, this.mTheme);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        public final void callbackFailAsync(final int r3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.onFontRetrievalFailed(r3);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int r1);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static Typeface getFont(Context context, int r8) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, r8, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bb A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface loadFont(android.content.Context r15, int r16, android.util.TypedValue r17, int r18, androidx.core.content.res.ResourcesCompat.FontCallback r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, int, android.util.TypedValue, int, androidx.core.content.res.ResourcesCompat$FontCallback, boolean, boolean):android.graphics.Typeface");
    }
}
