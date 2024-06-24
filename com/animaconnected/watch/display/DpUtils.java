package com.animaconnected.watch.display;

import android.content.Context;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: DpUtils.kt */
/* loaded from: classes3.dex */
public final class DpUtils {
    public static final DpUtils INSTANCE = new DpUtils();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DpUtils.kt */
    /* loaded from: classes3.dex */
    public static final class PARAMETER {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PARAMETER[] $VALUES;
        public static final PARAMETER HEIGHT = new PARAMETER("HEIGHT", 0);
        public static final PARAMETER WIDTH = new PARAMETER("WIDTH", 1);
        public static final PARAMETER PADDING_RIGHT = new PARAMETER("PADDING_RIGHT", 2);

        private static final /* synthetic */ PARAMETER[] $values() {
            return new PARAMETER[]{HEIGHT, WIDTH, PADDING_RIGHT};
        }

        static {
            PARAMETER[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private PARAMETER(String str, int r2) {
        }

        public static EnumEntries<PARAMETER> getEntries() {
            return $ENTRIES;
        }

        public static PARAMETER valueOf(String str) {
            return (PARAMETER) Enum.valueOf(PARAMETER.class, str);
        }

        public static PARAMETER[] values() {
            return (PARAMETER[]) $VALUES.clone();
        }
    }

    private DpUtils() {
    }

    public final int dpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt__MathJVMKt.roundToInt(f * context.getResources().getDisplayMetrics().density);
    }

    public final int pxToDp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt__MathJVMKt.roundToInt(f / context.getResources().getDisplayMetrics().density);
    }

    public final int pxToSp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt__MathJVMKt.roundToInt(f / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public final int spToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt__MathJVMKt.roundToInt(f * context.getResources().getDisplayMetrics().scaledDensity);
    }
}
