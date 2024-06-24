package com.animaconnected.secondo.provider;

import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.device.WatchStyleKt;
import com.animaconnected.watch.display.AndroidWatchPaint;
import com.animaconnected.watch.display.Font;
import com.animaconnected.watch.display.FontType;
import com.animaconnected.watch.display.WatchFonts;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: MainFonts.kt */
/* loaded from: classes3.dex */
public final class MainWatchFonts implements WatchFonts {
    public static final int $stable = 8;

    /* renamed from: default, reason: not valid java name */
    private final AndroidWatchPaint f23default = createTextPaint(FontType.Default, -1);
    private final AndroidWatchPaint small = createTextPaint(FontType.Small, -1);
    private final AndroidWatchPaint normal = createTextPaint(FontType.Normal, -1);
    private final AndroidWatchPaint subtitle = createTextPaint(FontType.Subtitle, -1);
    private final AndroidWatchPaint title = createTextPaint(FontType.Title, -1);
    private final AndroidWatchPaint numbers = createTextPaint(FontType.Numbers, -1);

    /* compiled from: MainFonts.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FontType.values().length];
            try {
                r0[FontType.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FontType.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FontType.Normal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FontType.Subtitle.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FontType.Title.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[FontType.Numbers.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final AndroidWatchPaint createTextPaint(FontType fontType, int r5) {
        Font watchFont = WatchStyleKt.toWatchFont(fontType);
        int r0 = WhenMappings.$EnumSwitchMapping$0[watchFont.getFontType().ordinal()];
        int r1 = R.font.inter_bold;
        switch (r0) {
            case 1:
            case 2:
            case 3:
            case 4:
                r1 = R.font.inter_semi_bold;
                break;
            case 5:
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(ResourcesCompat.getFont(KronabyApplication.Companion.getContext(), r1));
        textPaint.setTextSize(watchFont.getSize());
        textPaint.setColor(r5);
        AndroidWatchPaint androidWatchPaint = new AndroidWatchPaint(textPaint);
        androidWatchPaint.setFont(watchFont);
        return androidWatchPaint;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getDefault() {
        return this.f23default;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getNormal() {
        return this.normal;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getNumbers() {
        return this.numbers;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getSmall() {
        return this.small;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getSubtitle() {
        return this.subtitle;
    }

    @Override // com.animaconnected.watch.display.WatchFonts
    public AndroidWatchPaint getTitle() {
        return this.title;
    }
}
