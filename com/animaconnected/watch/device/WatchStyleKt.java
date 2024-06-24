package com.animaconnected.watch.device;

import com.animaconnected.watch.display.Font;
import com.animaconnected.watch.display.FontType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchStyle.kt */
/* loaded from: classes3.dex */
public final class WatchStyleKt {

    /* compiled from: WatchStyle.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FontType.values().length];
            try {
                r0[FontType.Small.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FontType.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FontType.Subtitle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FontType.Title.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FontType.Numbers.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Font toWatchFont(FontType fontType) {
        Intrinsics.checkNotNullParameter(fontType, "<this>");
        int r2 = WhenMappings.$EnumSwitchMapping$0[fontType.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 != 4) {
                        if (r2 != 5) {
                            return new Font(FontType.Default, 22);
                        }
                        return new Font(FontType.Numbers, 48);
                    }
                    return new Font(FontType.Title, 30);
                }
                return new Font(FontType.Subtitle, 22);
            }
            return new Font(FontType.Normal, 22);
        }
        return new Font(FontType.Small, 22);
    }
}
