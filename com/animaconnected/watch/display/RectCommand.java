package com.animaconnected.watch.display;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class RectCommand extends DrawCommand {
    private final int color;
    private final boolean fill;
    private final int height;
    private final int thickness;
    private final int width;
    private final int x;
    private final int y;

    public /* synthetic */ RectCommand(int r10, int r11, int r12, int r13, boolean z, int r15, int r16, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r10, r11, r12, r13, (r17 & 16) != 0 ? false : z, (r17 & 32) != 0 ? 1 : r15, (r17 & 64) != 0 ? -1 : r16);
    }

    public static /* synthetic */ RectCommand copy$default(RectCommand rectCommand, int r6, int r7, int r8, int r9, boolean z, int r11, int r12, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            r6 = rectCommand.x;
        }
        if ((r13 & 2) != 0) {
            r7 = rectCommand.y;
        }
        int r14 = r7;
        if ((r13 & 4) != 0) {
            r8 = rectCommand.width;
        }
        int r0 = r8;
        if ((r13 & 8) != 0) {
            r9 = rectCommand.height;
        }
        int r1 = r9;
        if ((r13 & 16) != 0) {
            z = rectCommand.fill;
        }
        boolean z2 = z;
        if ((r13 & 32) != 0) {
            r11 = rectCommand.thickness;
        }
        int r3 = r11;
        if ((r13 & 64) != 0) {
            r12 = rectCommand.color;
        }
        return rectCommand.copy(r6, r14, r0, r1, z2, r3, r12);
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.y;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final boolean component5() {
        return this.fill;
    }

    public final int component6() {
        return this.thickness;
    }

    public final int component7() {
        return this.color;
    }

    public final RectCommand copy(int r10, int r11, int r12, int r13, boolean z, int r15, int r16) {
        return new RectCommand(r10, r11, r12, r13, z, r15, r16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RectCommand)) {
            return false;
        }
        RectCommand rectCommand = (RectCommand) obj;
        if (this.x == rectCommand.x && this.y == rectCommand.y && this.width == rectCommand.width && this.height == rectCommand.height && this.fill == rectCommand.fill && this.thickness == rectCommand.thickness && this.color == rectCommand.color) {
            return true;
        }
        return false;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getThickness() {
        return this.thickness;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return Integer.hashCode(this.color) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.thickness, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.fill, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.height, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.width, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y, Integer.hashCode(this.x) * 31, 31), 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Rectangle), new Pair(Parameter.X, Integer.valueOf(this.x)), new Pair(Parameter.Y, Integer.valueOf(this.y)), new Pair(Parameter.Width, Integer.valueOf(this.width)), new Pair(Parameter.Height, Integer.valueOf(this.height)));
        if (this.fill) {
            mutableMapOf.put(Parameter.Opacity, 255);
        }
        int r1 = this.thickness;
        if (r1 != 1) {
            mutableMapOf.put(Parameter.Thickness, Integer.valueOf(r1));
        }
        int r12 = this.color;
        if (r12 != -1) {
            mutableMapOf.put(Parameter.Color, Integer.valueOf(r12));
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RectCommand(x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", fill=");
        sb.append(this.fill);
        sb.append(", thickness=");
        sb.append(this.thickness);
        sb.append(", color=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.color, ')');
    }

    public RectCommand(int r2, int r3, int r4, int r5, boolean z, int r7, int r8) {
        super(null);
        this.x = r2;
        this.y = r3;
        this.width = r4;
        this.height = r5;
        this.fill = z;
        this.thickness = r7;
        this.color = r8;
    }
}
