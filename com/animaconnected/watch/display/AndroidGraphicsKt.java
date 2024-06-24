package com.animaconnected.watch.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.animaconnected.watch.image.Mitmap;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGraphics.kt */
/* loaded from: classes3.dex */
public final class AndroidGraphicsKt {
    public static final int[] getPixels(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        int[] r0 = new int[bitmap.getHeight() * bitmap.getWidth()];
        bitmap.getPixels(r0, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return r0;
    }

    public static final Bitmap readBitmap(Context context, String assetName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        InputStream open = context.getResources().getAssets().open(assetName);
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        byte[] readBytes = ByteStreamsKt.readBytes(open);
        return BitmapFactory.decodeByteArray(readBytes, 0, readBytes.length);
    }

    public static final Bitmap toBitmap(Mitmap mitmap, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(mitmap, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Bitmap createBitmap = Bitmap.createBitmap(metrics, mitmap.getPixels(), mitmap.getWidth(), mitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Mitmap mitmap, DisplayMetrics displayMetrics, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            displayMetrics = Resources.getSystem().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        }
        return toBitmap(mitmap, displayMetrics);
    }

    public static final Mitmap toMitmap(Bitmap bitmap, MitmapCompressionSettings compressionSettings) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(compressionSettings, "compressionSettings");
        return new Mitmap(bitmap.getWidth(), bitmap.getHeight(), getPixels(bitmap), compressionSettings.getFormatType(), compressionSettings.getPalettePicker(), compressionSettings.getAllowChromaKey(), null, 64, null);
    }

    public static /* synthetic */ Mitmap toMitmap$default(Bitmap bitmap, MitmapCompressionSettings mitmapCompressionSettings, int r8, Object obj) {
        if ((r8 & 1) != 0) {
            mitmapCompressionSettings = new MitmapCompressionSettings(null, null, false, 7, null);
        }
        return toMitmap(bitmap, mitmapCompressionSettings);
    }
}
