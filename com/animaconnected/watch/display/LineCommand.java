package com.animaconnected.watch.display;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class LineCommand extends DrawCommand {
    private final int color;
    private final int thickness;
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public /* synthetic */ LineCommand(int r8, int r9, int r10, int r11, int r12, int r13, int r14, DefaultConstructorMarker defaultConstructorMarker) {
        this(r8, r9, r10, r11, (r14 & 16) != 0 ? 1 : r12, (r14 & 32) != 0 ? -1 : r13);
    }

    public static /* synthetic */ LineCommand copy$default(LineCommand lineCommand, int r5, int r6, int r7, int r8, int r9, int r10, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            r5 = lineCommand.x1;
        }
        if ((r11 & 2) != 0) {
            r6 = lineCommand.y1;
        }
        int r12 = r6;
        if ((r11 & 4) != 0) {
            r7 = lineCommand.x2;
        }
        int r0 = r7;
        if ((r11 & 8) != 0) {
            r8 = lineCommand.y2;
        }
        int r1 = r8;
        if ((r11 & 16) != 0) {
            r9 = lineCommand.thickness;
        }
        int r2 = r9;
        if ((r11 & 32) != 0) {
            r10 = lineCommand.color;
        }
        return lineCommand.copy(r5, r12, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.x1;
    }

    public final int component2() {
        return this.y1;
    }

    public final int component3() {
        return this.x2;
    }

    public final int component4() {
        return this.y2;
    }

    public final int component5() {
        return this.thickness;
    }

    public final int component6() {
        return this.color;
    }

    public final LineCommand copy(int r9, int r10, int r11, int r12, int r13, int r14) {
        return new LineCommand(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineCommand)) {
            return false;
        }
        LineCommand lineCommand = (LineCommand) obj;
        if (this.x1 == lineCommand.x1 && this.y1 == lineCommand.y1 && this.x2 == lineCommand.x2 && this.y2 == lineCommand.y2 && this.thickness == lineCommand.thickness && this.color == lineCommand.color) {
            return true;
        }
        return false;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getThickness() {
        return this.thickness;
    }

    public final int getX1() {
        return this.x1;
    }

    public final int getX2() {
        return this.x2;
    }

    public final int getY1() {
        return this.y1;
    }

    public final int getY2() {
        return this.y2;
    }

    public int hashCode() {
        return Integer.hashCode(this.color) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.thickness, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y2, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.x2, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y1, Integer.hashCode(this.x1) * 31, 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Line), new Pair(Parameter.X, Integer.valueOf(this.x1)), new Pair(Parameter.Y, Integer.valueOf(this.y1)), new Pair(Parameter.X2, Integer.valueOf(this.x2)), new Pair(Parameter.Y2, Integer.valueOf(this.y2)));
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
        StringBuilder sb = new StringBuilder("LineCommand(x1=");
        sb.append(this.x1);
        sb.append(", y1=");
        sb.append(this.y1);
        sb.append(", x2=");
        sb.append(this.x2);
        sb.append(", y2=");
        sb.append(this.y2);
        sb.append(", thickness=");
        sb.append(this.thickness);
        sb.append(", color=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.color, ')');
    }

    public LineCommand(int r2, int r3, int r4, int r5, int r6, int r7) {
        super(null);
        this.x1 = r2;
        this.y1 = r3;
        this.x2 = r4;
        this.y2 = r5;
        this.thickness = r6;
        this.color = r7;
    }
}
