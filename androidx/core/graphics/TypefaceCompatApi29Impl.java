package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    public static Font findBaseFont(FontFamily fontFamily, int r6) {
        int r1;
        int r62;
        if ((r6 & 1) != 0) {
            r1 = TipsAndTricksConstants.FIND_PHONE_PRIORITY;
        } else {
            r1 = 400;
        }
        if ((r6 & 2) != 0) {
            r62 = 1;
        } else {
            r62 = 0;
        }
        FontStyle fontStyle = new FontStyle(r1, r62);
        Font font = fontFamily.getFont(0);
        int matchScore = getMatchScore(fontStyle, font.getStyle());
        for (int r2 = 1; r2 < fontFamily.getSize(); r2++) {
            Font font2 = fontFamily.getFont(r2);
            int matchScore2 = getMatchScore(fontStyle, font2.getStyle());
            if (matchScore2 < matchScore) {
                font = font2;
                matchScore = matchScore2;
            }
        }
        return font;
    }

    public static int getMatchScore(FontStyle fontStyle, FontStyle fontStyle2) {
        int r2;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            r2 = 0;
        } else {
            r2 = 2;
        }
        return abs + r2;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int r11) {
        int r6;
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.mEntries) {
                try {
                    Font.Builder weight = new Font.Builder(resources, fontFileResourceEntry.mResourceId).setWeight(fontFileResourceEntry.mWeight);
                    if (fontFileResourceEntry.mItalic) {
                        r6 = 1;
                    } else {
                        r6 = 0;
                    }
                    Font build = weight.setSlant(r6).setTtcIndex(fontFileResourceEntry.mTtcIndex).setFontVariationSettings(fontFileResourceEntry.mVariationSettings).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(findBaseFont(build2, r11).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int r12) {
        ParcelFileDescriptor openFileDescriptor;
        int r8;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontsContractCompat$FontInfo.mUri, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor == null) {
                    }
                } else {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fontsContractCompat$FontInfo.mWeight);
                        if (fontsContractCompat$FontInfo.mItalic) {
                            r8 = 1;
                        } else {
                            r8 = 0;
                        }
                        Font build = weight.setSlant(r8).setTtcIndex(fontsContractCompat$FontInfo.mTtcIndex).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(findBaseFont(build2, r12).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface createFromResourcesFontFile(Context context, Resources resources, int r3, String str, int r5) {
        try {
            Font build = new Font.Builder(resources, r3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final FontsContractCompat$FontInfo findBestInfo(int r1, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
