package com.animaconnected.watch.display;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class Font {
    private final FontType fontType;
    private final int size;

    public Font(FontType fontType, int r3) {
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        this.fontType = fontType;
        this.size = r3;
    }

    public static /* synthetic */ Font copy$default(Font font, FontType fontType, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            fontType = font.fontType;
        }
        if ((r3 & 2) != 0) {
            r2 = font.size;
        }
        return font.copy(fontType, r2);
    }

    public final FontType component1() {
        return this.fontType;
    }

    public final int component2() {
        return this.size;
    }

    public final Font copy(FontType fontType, int r3) {
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        return new Font(fontType, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Font)) {
            return false;
        }
        Font font = (Font) obj;
        if (this.fontType == font.fontType && this.size == font.size) {
            return true;
        }
        return false;
    }

    public final FontType getFontType() {
        return this.fontType;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return Integer.hashCode(this.size) + (this.fontType.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Font(fontType=");
        sb.append(this.fontType);
        sb.append(", size=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.size, ')');
    }
}
