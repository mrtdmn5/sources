package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements StyleExtractor<FontsContractCompat$FontInfo> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final int getWeight(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
            return fontsContractCompat$FontInfo.mWeight;
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public final boolean isItalic(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
            return fontsContractCompat$FontInfo.mItalic;
        }
    }

    /* loaded from: classes.dex */
    public interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    public TypefaceCompatBaseImpl() {
        new ConcurrentHashMap();
    }

    public static <T> T findBestFont(T[] tArr, int r11, StyleExtractor<T> styleExtractor) {
        int r0;
        boolean z;
        int r9;
        if ((r11 & 1) == 0) {
            r0 = 400;
        } else {
            r0 = TipsAndTricksConstants.FIND_PHONE_PRIORITY;
        }
        if ((r11 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        T t = null;
        int r5 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = Math.abs(styleExtractor.getWeight(t2) - r0) * 2;
            if (styleExtractor.isItalic(t2) == z) {
                r9 = 0;
            } else {
                r9 = 1;
            }
            int r8 = abs + r9;
            if (t == null || r5 > r8) {
                t = t2;
                r5 = r8;
            }
        }
        return t;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int r4) {
        throw null;
    }

    public Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int r3) {
        throw null;
    }

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(inputStream, tempFile)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int r3, String str, int r5) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, r3)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public FontsContractCompat$FontInfo findBestInfo(int r2, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        return (FontsContractCompat$FontInfo) findBestFont(fontsContractCompat$FontInfoArr, r2, new AnonymousClass1());
    }
}
