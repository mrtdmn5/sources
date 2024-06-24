package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ResourcesCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    public static ColorStateList getColorStateList(Context context, int r9) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ResourcesCompat.ColorStateListCacheEntry colorStateListCacheEntry;
        Object obj = ContextCompat.sLock;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ResourcesCompat.ColorStateListCacheKey colorStateListCacheKey = new ResourcesCompat.ColorStateListCacheKey(resources, theme);
        synchronized (ResourcesCompat.sColorStateCacheLock) {
            SparseArray<ResourcesCompat.ColorStateListCacheEntry> sparseArray = ResourcesCompat.sColorStateCaches.get(colorStateListCacheKey);
            colorStateList = null;
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(r9)) != null) {
                if (colorStateListCacheEntry.mConfiguration.equals(resources.getConfiguration()) && ((theme == null && colorStateListCacheEntry.mThemeHash == 0) || (theme != null && colorStateListCacheEntry.mThemeHash == theme.hashCode()))) {
                    colorStateList2 = colorStateListCacheEntry.mValue;
                } else {
                    sparseArray.remove(r9);
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 == null) {
            ThreadLocal<TypedValue> threadLocal = ResourcesCompat.sTempTypedValue;
            TypedValue typedValue = threadLocal.get();
            if (typedValue == null) {
                typedValue = new TypedValue();
                threadLocal.set(typedValue);
            }
            boolean z = true;
            resources.getValue(r9, typedValue, true);
            int r3 = typedValue.type;
            if (r3 < 28 || r3 > 31) {
                z = false;
            }
            if (!z) {
                try {
                    colorStateList = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(r9), theme);
                } catch (Exception e) {
                    Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
                }
            }
            if (colorStateList != null) {
                synchronized (ResourcesCompat.sColorStateCacheLock) {
                    WeakHashMap<ResourcesCompat.ColorStateListCacheKey, SparseArray<ResourcesCompat.ColorStateListCacheEntry>> weakHashMap = ResourcesCompat.sColorStateCaches;
                    SparseArray<ResourcesCompat.ColorStateListCacheEntry> sparseArray2 = weakHashMap.get(colorStateListCacheKey);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray<>();
                        weakHashMap.put(colorStateListCacheKey, sparseArray2);
                    }
                    sparseArray2.append(r9, new ResourcesCompat.ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
                }
                return colorStateList;
            }
            return ResourcesCompat.Api23Impl.getColorStateList(resources, r9, theme);
        }
        return colorStateList2;
    }

    public static Drawable getDrawable(Context context, int r2) {
        return ResourceManagerInternal.get().getDrawable(context, r2);
    }
}
