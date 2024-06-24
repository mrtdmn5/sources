package com.animaconnected.secondo.provider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeProviderBase.kt */
/* loaded from: classes3.dex */
public abstract class ThemeProviderBase {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: ThemeProviderBase.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getBoolean(Context context, int r3) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{r3});
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z;
        }

        public final int getColor(Context context, int r3) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{r3});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return color;
        }

        public final int getResourceId(Context context, int r3) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{r3});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            return resourceId;
        }

        public final String getString(Context context, int r4) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(r4, typedValue, true);
            CharSequence charSequence = typedValue.string;
            Intrinsics.checkNotNull(charSequence, "null cannot be cast to non-null type kotlin.String");
            return (String) charSequence;
        }

        private Companion() {
        }
    }

    public static final boolean getBoolean(Context context, int r2) {
        return Companion.getBoolean(context, r2);
    }

    public static final int getColor(Context context, int r2) {
        return Companion.getColor(context, r2);
    }

    public static final int getResourceId(Context context, int r2) {
        return Companion.getResourceId(context, r2);
    }

    public static final String getString(Context context, int r2) {
        return Companion.getString(context, r2);
    }

    public abstract int getBackgroundColor();

    public abstract float getBackgroundGradientOpacity();

    public abstract int getBackgroundResource();

    public abstract ChartColors getChartColors();

    public abstract ChartFonts getChartFonts();

    public final float getFloat(Context context, int r3) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{r3});
            float f = typedArray.getFloat(0, 0.0f);
            typedArray.recycle();
            return f;
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public abstract int getGradientBackgroundColor();

    public abstract int getThemeFromAssetVersion();

    public abstract float getWatchShadowOpacity();
}
