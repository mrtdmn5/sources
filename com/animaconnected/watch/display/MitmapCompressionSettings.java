package com.animaconnected.watch.display;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.pickers.MedianCutPalettePicker;
import com.animaconnected.watch.image.pickers.NotificationColorPalettePicker;
import com.animaconnected.watch.image.pickers.PalettePicker;
import com.animaconnected.watch.image.pickers.WatchIconPalettePicker;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonGraphics.kt */
/* loaded from: classes3.dex */
public final class MitmapCompressionSettings {
    public static final Companion Companion = new Companion(null);
    private final boolean allowChromaKey;
    private final FormatType formatType;
    private final PalettePicker palettePicker;

    /* compiled from: CommonGraphics.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MitmapCompressionSettings getNotificationIconSettings() {
            return new MitmapCompressionSettings(FormatType.INDEXED_4BIT, NotificationColorPalettePicker.INSTANCE, false, 4, null);
        }

        public final MitmapCompressionSettings getStandardSettings() {
            return new MitmapCompressionSettings(null, null, false, 7, null);
        }

        public final MitmapCompressionSettings getWatchIconSettings() {
            return new MitmapCompressionSettings(FormatType.INDEXED_4BIT, WatchIconPalettePicker.INSTANCE, false, 4, null);
        }

        private Companion() {
        }
    }

    public MitmapCompressionSettings() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ MitmapCompressionSettings copy$default(MitmapCompressionSettings mitmapCompressionSettings, FormatType formatType, PalettePicker palettePicker, boolean z, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            formatType = mitmapCompressionSettings.formatType;
        }
        if ((r4 & 2) != 0) {
            palettePicker = mitmapCompressionSettings.palettePicker;
        }
        if ((r4 & 4) != 0) {
            z = mitmapCompressionSettings.allowChromaKey;
        }
        return mitmapCompressionSettings.copy(formatType, palettePicker, z);
    }

    public final FormatType component1() {
        return this.formatType;
    }

    public final PalettePicker component2() {
        return this.palettePicker;
    }

    public final boolean component3() {
        return this.allowChromaKey;
    }

    public final MitmapCompressionSettings copy(FormatType formatType, PalettePicker palettePicker, boolean z) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(palettePicker, "palettePicker");
        return new MitmapCompressionSettings(formatType, palettePicker, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MitmapCompressionSettings)) {
            return false;
        }
        MitmapCompressionSettings mitmapCompressionSettings = (MitmapCompressionSettings) obj;
        if (this.formatType == mitmapCompressionSettings.formatType && Intrinsics.areEqual(this.palettePicker, mitmapCompressionSettings.palettePicker) && this.allowChromaKey == mitmapCompressionSettings.allowChromaKey) {
            return true;
        }
        return false;
    }

    public final boolean getAllowChromaKey() {
        return this.allowChromaKey;
    }

    public final FormatType getFormatType() {
        return this.formatType;
    }

    public final PalettePicker getPalettePicker() {
        return this.palettePicker;
    }

    public int hashCode() {
        return Boolean.hashCode(this.allowChromaKey) + ((this.palettePicker.hashCode() + (this.formatType.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MitmapCompressionSettings(formatType=");
        sb.append(this.formatType);
        sb.append(", palettePicker=");
        sb.append(this.palettePicker);
        sb.append(", allowChromaKey=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.allowChromaKey, ')');
    }

    public MitmapCompressionSettings(FormatType formatType, PalettePicker palettePicker, boolean z) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(palettePicker, "palettePicker");
        this.formatType = formatType;
        this.palettePicker = palettePicker;
        this.allowChromaKey = z;
    }

    public /* synthetic */ MitmapCompressionSettings(FormatType formatType, PalettePicker palettePicker, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? FormatType.INDEXED_4BIT : formatType, (r4 & 2) != 0 ? MedianCutPalettePicker.INSTANCE : palettePicker, (r4 & 4) != 0 ? false : z);
    }
}
