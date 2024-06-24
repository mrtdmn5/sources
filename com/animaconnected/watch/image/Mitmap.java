package com.animaconnected.watch.image;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.watch.image.pickers.MedianCutPalettePicker;
import com.animaconnected.watch.image.pickers.PalettePicker;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Graphics.kt */
/* loaded from: classes3.dex */
public final class Mitmap {
    private final boolean allowChromaKey;
    private final Lazy bytes$delegate;
    private final Lazy bytesHash$delegate;
    private final FormatType formatType;
    private final int height;
    private final PalettePicker palettePicker;
    private final int[] pixels;
    private String platformIdentifier;
    private final int width;

    public Mitmap(int r2, int r3, int[] pixels, FormatType formatType, PalettePicker palettePicker, boolean z, String str) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(palettePicker, "palettePicker");
        this.width = r2;
        this.height = r3;
        this.pixels = pixels;
        this.formatType = formatType;
        this.palettePicker = palettePicker;
        this.allowChromaKey = z;
        this.platformIdentifier = str;
        this.bytes$delegate = LazyKt__LazyJVMKt.lazy(new Function0<byte[]>() { // from class: com.animaconnected.watch.image.Mitmap$bytes$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final byte[] invoke() {
                return GraphicsKt.compress(Mitmap.this);
            }
        });
        this.bytesHash$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.animaconnected.watch.image.Mitmap$bytesHash$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return String.valueOf(Math.abs(Arrays.hashCode(Mitmap.this.getBytes()) / Constants.MAXIMUM_UPLOAD_PARTS));
            }
        });
    }

    public static /* synthetic */ Mitmap copy$default(Mitmap mitmap, int r6, int r7, int[] r8, FormatType formatType, PalettePicker palettePicker, boolean z, String str, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = mitmap.width;
        }
        if ((r13 & 2) != 0) {
            r7 = mitmap.height;
        }
        int r14 = r7;
        if ((r13 & 4) != 0) {
            r8 = mitmap.pixels;
        }
        int[] r0 = r8;
        if ((r13 & 8) != 0) {
            formatType = mitmap.formatType;
        }
        FormatType formatType2 = formatType;
        if ((r13 & 16) != 0) {
            palettePicker = mitmap.palettePicker;
        }
        PalettePicker palettePicker2 = palettePicker;
        if ((r13 & 32) != 0) {
            z = mitmap.allowChromaKey;
        }
        boolean z2 = z;
        if ((r13 & 64) != 0) {
            str = mitmap.platformIdentifier;
        }
        return mitmap.copy(r6, r14, r0, formatType2, palettePicker2, z2, str);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int[] component3() {
        return this.pixels;
    }

    public final FormatType component4() {
        return this.formatType;
    }

    public final PalettePicker component5() {
        return this.palettePicker;
    }

    public final boolean component6() {
        return this.allowChromaKey;
    }

    public final String component7() {
        return this.platformIdentifier;
    }

    public final Mitmap copy(int r10, int r11, int[] pixels, FormatType formatType, PalettePicker palettePicker, boolean z, String str) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(palettePicker, "palettePicker");
        return new Mitmap(r10, r11, pixels, formatType, palettePicker, z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Mitmap.class != obj.getClass()) {
            return false;
        }
        Mitmap mitmap = (Mitmap) obj;
        if (this.width == mitmap.width && this.height == mitmap.height && Arrays.equals(this.pixels, mitmap.pixels) && this.formatType == mitmap.formatType && Intrinsics.areEqual(this.palettePicker, mitmap.palettePicker) && this.allowChromaKey == mitmap.allowChromaKey) {
            return true;
        }
        return false;
    }

    public final boolean getAllowChromaKey() {
        return this.allowChromaKey;
    }

    public final byte[] getBytes() {
        return (byte[]) this.bytes$delegate.getValue();
    }

    public final String getBytesHash() {
        return (String) this.bytesHash$delegate.getValue();
    }

    public final FormatType getFormatType() {
        return this.formatType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final PalettePicker getPalettePicker() {
        return this.palettePicker;
    }

    public final int[] getPixels() {
        return this.pixels;
    }

    public final String getPlatformIdentifier() {
        return this.platformIdentifier;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Boolean.hashCode(this.allowChromaKey) + ((this.palettePicker.hashCode() + ((this.formatType.hashCode() + ((Arrays.hashCode(this.pixels) + (((this.width * 31) + this.height) * 31)) * 31)) * 31)) * 31);
    }

    public final void setPlatformIdentifier(String str) {
        this.platformIdentifier = str;
    }

    public String toString() {
        return "Mitmap(width=" + this.width + ", height=" + this.height + ", pixelCount: " + this.pixels.length + ", formatType=" + this.formatType + ", palettePicker=" + this.palettePicker + ')';
    }

    public /* synthetic */ Mitmap(int r10, int r11, int[] r12, FormatType formatType, PalettePicker palettePicker, boolean z, String str, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r10, r11, r12, (r17 & 8) != 0 ? FormatType.INDEXED_4BIT : formatType, (r17 & 16) != 0 ? MedianCutPalettePicker.INSTANCE : palettePicker, (r17 & 32) != 0 ? false : z, (r17 & 64) != 0 ? null : str);
    }
}
