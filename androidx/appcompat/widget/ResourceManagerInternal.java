package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    public static ResourceManagerInternal INSTANCE;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public ResourceManagerHooks mHooks;
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    public TypedValue mTypedValue;
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache();

    /* loaded from: classes.dex */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache() {
            super(6);
        }
    }

    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (INSTANCE == null) {
                INSTANCE = new ResourceManagerInternal();
            }
            resourceManagerInternal = INSTANCE;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            colorFilterLruCache.getClass();
            int r2 = (r4 + 31) * 31;
            porterDuffColorFilter = colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + r2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(r4, mode);
                colorFilterLruCache.getClass();
                colorFilterLruCache.put(Integer.valueOf(mode.hashCode() + r2), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public final synchronized void addDrawableToCache(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray<>();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j, new WeakReference<>(constantState));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable createDrawableIfNeeded(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.util.TypedValue r0 = r7.mTypedValue
            if (r0 != 0) goto Lb
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r7.mTypedValue = r0
        Lb:
            android.util.TypedValue r0 = r7.mTypedValue
            android.content.res.Resources r1 = r8.getResources()
            r2 = 1
            r1.getValue(r9, r0, r2)
            int r1 = r0.assetCookie
            long r3 = (long) r1
            r1 = 32
            long r3 = r3 << r1
            int r1 = r0.data
            long r5 = (long) r1
            long r3 = r3 | r5
            android.graphics.drawable.Drawable r1 = r7.getCachedDrawable(r8, r3)
            if (r1 == 0) goto L26
            return r1
        L26:
            androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks r1 = r7.mHooks
            if (r1 != 0) goto L2b
            goto L73
        L2b:
            r1 = 2131230743(0x7f080017, float:1.8077547E38)
            if (r9 != r1) goto L4c
            android.graphics.drawable.LayerDrawable r9 = new android.graphics.drawable.LayerDrawable
            r1 = 2
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r1]
            r5 = 2131230742(0x7f080016, float:1.8077545E38)
            android.graphics.drawable.Drawable r5 = r7.getDrawable(r8, r5)
            r6 = 0
            r1[r6] = r5
            r5 = 2131230744(0x7f080018, float:1.807755E38)
            android.graphics.drawable.Drawable r5 = r7.getDrawable(r8, r5)
            r1[r2] = r5
            r9.<init>(r1)
            goto L74
        L4c:
            r1 = 2131230778(0x7f08003a, float:1.8077618E38)
            if (r9 != r1) goto L59
            r9 = 2131165243(0x7f07003b, float:1.7944698E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.getRatingBarLayerDrawable(r7, r8, r9)
            goto L74
        L59:
            r1 = 2131230777(0x7f080039, float:1.8077616E38)
            if (r9 != r1) goto L66
            r9 = 2131165244(0x7f07003c, float:1.79447E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.getRatingBarLayerDrawable(r7, r8, r9)
            goto L74
        L66:
            r1 = 2131230779(0x7f08003b, float:1.807762E38)
            if (r9 != r1) goto L73
            r9 = 2131165245(0x7f07003d, float:1.7944702E38)
            android.graphics.drawable.LayerDrawable r9 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.getRatingBarLayerDrawable(r7, r8, r9)
            goto L74
        L73:
            r9 = 0
        L74:
            if (r9 == 0) goto L7e
            int r0 = r0.changingConfigurations
            r9.setChangingConfigurations(r0)
            r7.addDrawableToCache(r8, r3, r9)
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.createDrawableIfNeeded(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public final synchronized Drawable getCachedDrawable(Context context, long j) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.get(j, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int binarySearch = ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, j);
            if (binarySearch >= 0) {
                Object[] objArr = longSparseArray.mValues;
                Object obj = objArr[binarySearch];
                Object obj2 = LongSparseArray.DELETED;
                if (obj != obj2) {
                    objArr[binarySearch] = obj2;
                    longSparseArray.mGarbage = true;
                }
            }
        }
        return null;
    }

    public final synchronized Drawable getDrawable(Context context, int r3) {
        return getDrawable(context, r3, false);
    }

    public final synchronized ColorStateList getTintList(Context context, int r5) {
        ColorStateList colorStateList;
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        try {
            WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
            ColorStateList colorStateList2 = null;
            if (weakHashMap != null && (sparseArrayCompat = weakHashMap.get(context)) != null) {
                colorStateList = (ColorStateList) sparseArrayCompat.get(r5, null);
            } else {
                colorStateList = null;
            }
            if (colorStateList == null) {
                ResourceManagerHooks resourceManagerHooks = this.mHooks;
                if (resourceManagerHooks != null) {
                    colorStateList2 = ((AppCompatDrawableManager.AnonymousClass1) resourceManagerHooks).getTintListForDrawableRes(context, r5);
                }
                if (colorStateList2 != null) {
                    if (this.mTintLists == null) {
                        this.mTintLists = new WeakHashMap<>();
                    }
                    SparseArrayCompat<ColorStateList> sparseArrayCompat2 = this.mTintLists.get(context);
                    if (sparseArrayCompat2 == null) {
                        sparseArrayCompat2 = new SparseArrayCompat<>();
                        this.mTintLists.put(context, sparseArrayCompat2);
                    }
                    sparseArrayCompat2.append(r5, colorStateList2);
                }
                colorStateList = colorStateList2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean tintDrawableUsingColorFilter(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks r0 = r6.mHooks
            r1 = 0
            if (r0 == 0) goto L74
            androidx.appcompat.widget.AppCompatDrawableManager$1 r0 = (androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1) r0
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE
            int[] r3 = r0.COLORFILTER_TINT_COLOR_CONTROL_NORMAL
            boolean r3 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.arrayContains(r3, r8)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L17
            r8 = 2130968811(0x7f0400eb, float:1.7546286E38)
            goto L4a
        L17:
            int[] r3 = r0.COLORFILTER_COLOR_CONTROL_ACTIVATED
            boolean r3 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.arrayContains(r3, r8)
            if (r3 == 0) goto L23
            r8 = 2130968809(0x7f0400e9, float:1.7546282E38)
            goto L4a
        L23:
            int[] r0 = r0.COLORFILTER_COLOR_BACKGROUND_MULTIPLY
            boolean r0 = androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.arrayContains(r0, r8)
            if (r0 == 0) goto L2e
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L47
        L2e:
            r0 = 2131230764(0x7f08002c, float:1.807759E38)
            if (r8 != r0) goto L42
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r2
            r2 = r0
            r0 = r8
            r8 = r4
            goto L52
        L42:
            r0 = 2131230746(0x7f08001a, float:1.8077553E38)
            if (r8 != r0) goto L4d
        L47:
            r8 = 16842801(0x1010031, float:2.3693695E-38)
        L4a:
            r0 = r8
            r8 = r4
            goto L4f
        L4d:
            r8 = r1
            r0 = r8
        L4f:
            r3 = r2
            r2 = r0
            r0 = r5
        L52:
            if (r8 == 0) goto L70
            boolean r8 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r9)
            if (r8 == 0) goto L5e
            android.graphics.drawable.Drawable r9 = r9.mutate()
        L5e:
            int r7 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r7, r2)
            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r7, r3)
            r9.setColorFilter(r7)
            if (r0 == r5) goto L6e
            r9.setAlpha(r0)
        L6e:
            r7 = r4
            goto L71
        L70:
            r7 = r1
        L71:
            if (r7 == 0) goto L74
            r1 = r4
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:            androidx.core.graphics.drawable.DrawableCompat$Api21Impl.setTintMode(r0, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002b, code lost:            if (r0 == false) goto L121;     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.graphics.drawable.Drawable getDrawable(android.content.Context r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getDrawable(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }
}
