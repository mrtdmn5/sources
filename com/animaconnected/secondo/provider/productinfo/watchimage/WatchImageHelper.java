package com.animaconnected.secondo.provider.productinfo.watchimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.animaconnected.watch.device.Capabilities;
import com.kronaby.watch.app.R;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchImageHelper.kt */
/* loaded from: classes3.dex */
public final class WatchImageHelper {
    public static final int $stable = 0;
    public static final WatchImageHelper INSTANCE = new WatchImageHelper();

    private WatchImageHelper() {
    }

    public static final Bitmap getBitmapFromResource(Context context, int r3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BitmapFactory.decodeResource(context.getResources(), r3, INSTANCE.getOptions(context));
    }

    private final int getDensity(Context context) {
        String string = context.getString(R.string.density);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != -745448715) {
            if (hashCode != 3197941) {
                if (hashCode == 114020461 && lowerCase.equals("xhdpi")) {
                    return 320;
                }
            } else if (lowerCase.equals("hdpi")) {
                return 240;
            }
        } else if (lowerCase.equals("xxhdpi")) {
            return 480;
        }
        return 0;
    }

    private final BitmapFactory.Options getOptions(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = INSTANCE.getDensity(context);
        options.inScreenDensity = context.getResources().getDisplayMetrics().densityDpi;
        return options;
    }

    public static final boolean validateImages(Capabilities capabilities, Map<WatchImageType, Bitmap> images) {
        boolean z;
        boolean containsKey;
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(images, "images");
        if (images.containsKey(WatchImageType.SKU) && images.containsKey(WatchImageType.THUMBNAIL) && images.containsKey(WatchImageType.MAIN_HOUR_HAND) && images.containsKey(WatchImageType.MAIN_MIN_HAND) && images.containsKey(WatchImageType.GLOW)) {
            z = true;
        } else {
            z = false;
        }
        if (!capabilities.hasWatchfaceLayout(2, 1) && !capabilities.hasWatchfaceLayout(2, 1, 1)) {
            if (capabilities.hasWatchfaceLayout(2, 2) && (!images.containsKey(WatchImageType.SUB_HOUR_HAND) || !images.containsKey(WatchImageType.SUB_MIN_HAND))) {
                containsKey = false;
            } else {
                containsKey = true;
            }
        } else {
            containsKey = images.containsKey(WatchImageType.SUB_MIN_HAND);
        }
        if (!z || !containsKey) {
            return false;
        }
        return true;
    }

    public final Bitmap getBitmapFromFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return BitmapFactory.decodeFile(file.getPath(), getOptions(context));
    }
}
