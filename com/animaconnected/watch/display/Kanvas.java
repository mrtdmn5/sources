package com.animaconnected.watch.display;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.FontConfig;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public interface Kanvas {

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Anchor {
        private Position horizontal;
        private Position vertical;

        /* compiled from: Kanvas.kt */
        /* loaded from: classes3.dex */
        public static final class Position extends Enum<Position> {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Position[] $VALUES;
            public static final Position MIN = new Position("MIN", 0);
            public static final Position MAX = new Position("MAX", 1);
            public static final Position MID = new Position("MID", 2);

            private static final /* synthetic */ Position[] $values() {
                return new Position[]{MIN, MAX, MID};
            }

            static {
                Position[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            private Position(String str, int r2) {
                super(str, r2);
            }

            public static EnumEntries<Position> getEntries() {
                return $ENTRIES;
            }

            public static Position valueOf(String str) {
                return (Position) Enum.valueOf(Position.class, str);
            }

            public static Position[] values() {
                return (Position[]) $VALUES.clone();
            }
        }

        public Anchor(Position horizontal, Position vertical) {
            Intrinsics.checkNotNullParameter(horizontal, "horizontal");
            Intrinsics.checkNotNullParameter(vertical, "vertical");
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        public final Position getHorizontal() {
            return this.horizontal;
        }

        public final Position getVertical() {
            return this.vertical;
        }

        public final void setHorizontal(Position position) {
            Intrinsics.checkNotNullParameter(position, "<set-?>");
            this.horizontal = position;
        }

        public final void setVertical(Position position) {
            Intrinsics.checkNotNullParameter(position, "<set-?>");
            this.vertical = position;
        }
    }

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class DashedLine {
        private final float dashLength;
        private final float spaceLength;

        public DashedLine(float f, float f2) {
            this.dashLength = f;
            this.spaceLength = f2;
        }

        public static /* synthetic */ DashedLine copy$default(DashedLine dashedLine, float f, float f2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                f = dashedLine.dashLength;
            }
            if ((r3 & 2) != 0) {
                f2 = dashedLine.spaceLength;
            }
            return dashedLine.copy(f, f2);
        }

        public final float component1() {
            return this.dashLength;
        }

        public final float component2() {
            return this.spaceLength;
        }

        public final DashedLine copy(float f, float f2) {
            return new DashedLine(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DashedLine)) {
                return false;
            }
            DashedLine dashedLine = (DashedLine) obj;
            if (Float.compare(this.dashLength, dashedLine.dashLength) == 0 && Float.compare(this.spaceLength, dashedLine.spaceLength) == 0) {
                return true;
            }
            return false;
        }

        public final float getDashLength() {
            return this.dashLength;
        }

        public final float getSpaceLength() {
            return this.spaceLength;
        }

        public int hashCode() {
            return Float.hashCode(this.spaceLength) + (Float.hashCode(this.dashLength) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DashedLine(dashLength=");
            sb.append(this.dashLength);
            sb.append(", spaceLength=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.spaceLength, ')');
        }
    }

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Shadow {
        private final int color;
        private final float dx;
        private final float dy;
        private final float radius;

        public Shadow(float f, float f2, float f3, int r4) {
            this.radius = f;
            this.dx = f2;
            this.dy = f3;
            this.color = r4;
        }

        public static /* synthetic */ Shadow copy$default(Shadow shadow, float f, float f2, float f3, int r4, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                f = shadow.radius;
            }
            if ((r5 & 2) != 0) {
                f2 = shadow.dx;
            }
            if ((r5 & 4) != 0) {
                f3 = shadow.dy;
            }
            if ((r5 & 8) != 0) {
                r4 = shadow.color;
            }
            return shadow.copy(f, f2, f3, r4);
        }

        public final float component1() {
            return this.radius;
        }

        public final float component2() {
            return this.dx;
        }

        public final float component3() {
            return this.dy;
        }

        public final int component4() {
            return this.color;
        }

        public final Shadow copy(float f, float f2, float f3, int r5) {
            return new Shadow(f, f2, f3, r5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Shadow)) {
                return false;
            }
            Shadow shadow = (Shadow) obj;
            if (Float.compare(this.radius, shadow.radius) == 0 && Float.compare(this.dx, shadow.dx) == 0 && Float.compare(this.dy, shadow.dy) == 0 && this.color == shadow.color) {
                return true;
            }
            return false;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public final float getRadius() {
            return this.radius;
        }

        public int hashCode() {
            return Integer.hashCode(this.color) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dy, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dx, Float.hashCode(this.radius) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Shadow(radius=");
            sb.append(this.radius);
            sb.append(", dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            sb.append(this.dy);
            sb.append(", color=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.color, ')');
        }

        public /* synthetic */ Shadow(float f, float f2, float f3, int r4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, (r5 & 8) != 0 ? Kolors.black : r4);
        }
    }

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class TextAlignment extends Enum<TextAlignment> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TextAlignment[] $VALUES;
        public static final TextAlignment LEFT = new TextAlignment(AnimationFactoryKotlinKt.LEFT, 0);
        public static final TextAlignment CENTER = new TextAlignment("CENTER", 1);
        public static final TextAlignment RIGHT = new TextAlignment(AnimationFactoryKotlinKt.RIGHT, 2);

        private static final /* synthetic */ TextAlignment[] $values() {
            return new TextAlignment[]{LEFT, CENTER, RIGHT};
        }

        static {
            TextAlignment[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private TextAlignment(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<TextAlignment> getEntries() {
            return $ENTRIES;
        }

        public static TextAlignment valueOf(String str) {
            return (TextAlignment) Enum.valueOf(TextAlignment.class, str);
        }

        public static TextAlignment[] values() {
            return (TextAlignment[]) $VALUES.clone();
        }
    }

    static /* synthetic */ CanvasPaint createColorPaint$default(Kanvas kanvas, int r1, boolean z, float f, DashedLine dashedLine, int r5, Object obj) {
        if (obj == null) {
            if ((r5 & 1) != 0) {
                r1 = Kolors.black;
            }
            if ((r5 & 2) != 0) {
                z = false;
            }
            if ((r5 & 4) != 0) {
                f = 1.0f;
            }
            if ((r5 & 8) != 0) {
                dashedLine = null;
            }
            return kanvas.createColorPaint(r1, z, f, dashedLine);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createColorPaint");
    }

    static /* synthetic */ void drawImage$default(Kanvas kanvas, float f, float f2, float f3, float f4, Mitmap mitmap, CanvasPaint canvasPaint, int r14, Object obj) {
        if (obj == null) {
            if ((r14 & 32) != 0) {
                canvasPaint = null;
            }
            kanvas.drawImage(f, f2, f3, f4, mitmap, canvasPaint);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage");
    }

    static /* synthetic */ void drawText$default(Kanvas kanvas, String str, float f, float f2, float f3, Anchor anchor, CanvasPaint canvasPaint, int r14, Object obj) {
        if (obj == null) {
            if ((r14 & 8) != 0) {
                f3 = 0.0f;
            }
            float f4 = f3;
            if ((r14 & 16) != 0) {
                Anchor.Position position = Anchor.Position.MIN;
                anchor = new Anchor(position, position);
            }
            kanvas.drawText(str, f, f2, f4, anchor, canvasPaint);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawText");
    }

    CanvasPaint createColorPaint(int r1, boolean z, float f, DashedLine dashedLine);

    CanvasPath createPath();

    CanvasPaint createTextPaint(TextConfig textConfig);

    void drawCircle(float f, float f2, float f3, CanvasPaint canvasPaint);

    void drawImage(float f, float f2, float f3, float f4, Mitmap mitmap, CanvasPaint canvasPaint);

    void drawLine(float f, float f2, float f3, float f4, CanvasPaint canvasPaint);

    void drawPath(CanvasPath canvasPath, CanvasPaint canvasPaint);

    void drawRect(float f, float f2, float f3, float f4, CanvasPaint canvasPaint);

    void drawText(String str, float f, float f2, float f3, Anchor anchor, CanvasPaint canvasPaint);

    float getDisplayMultiplier();

    PointF pointRelativeToAnchor(Anchor anchor, Size size);

    void rotate(float f);

    void setDisplayMultiplier(float f);

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class TextConfig {
        private final boolean bold;
        private final FontConfig fontConfig;
        private final TextAlignment textAlignment;
        private final int textColor;
        private final Shadow textShadow;

        public TextConfig(FontConfig fontConfig, int r3, TextAlignment textAlignment, boolean z, Shadow shadow) {
            Intrinsics.checkNotNullParameter(fontConfig, "fontConfig");
            Intrinsics.checkNotNullParameter(textAlignment, "textAlignment");
            this.fontConfig = fontConfig;
            this.textColor = r3;
            this.textAlignment = textAlignment;
            this.bold = z;
            this.textShadow = shadow;
        }

        public static /* synthetic */ TextConfig copy$default(TextConfig textConfig, FontConfig fontConfig, int r5, TextAlignment textAlignment, boolean z, Shadow shadow, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                fontConfig = textConfig.fontConfig;
            }
            if ((r9 & 2) != 0) {
                r5 = textConfig.textColor;
            }
            int r10 = r5;
            if ((r9 & 4) != 0) {
                textAlignment = textConfig.textAlignment;
            }
            TextAlignment textAlignment2 = textAlignment;
            if ((r9 & 8) != 0) {
                z = textConfig.bold;
            }
            boolean z2 = z;
            if ((r9 & 16) != 0) {
                shadow = textConfig.textShadow;
            }
            return textConfig.copy(fontConfig, r10, textAlignment2, z2, shadow);
        }

        public final FontConfig component1() {
            return this.fontConfig;
        }

        public final int component2() {
            return this.textColor;
        }

        public final TextAlignment component3() {
            return this.textAlignment;
        }

        public final boolean component4() {
            return this.bold;
        }

        public final Shadow component5() {
            return this.textShadow;
        }

        public final TextConfig copy(FontConfig fontConfig, int r9, TextAlignment textAlignment, boolean z, Shadow shadow) {
            Intrinsics.checkNotNullParameter(fontConfig, "fontConfig");
            Intrinsics.checkNotNullParameter(textAlignment, "textAlignment");
            return new TextConfig(fontConfig, r9, textAlignment, z, shadow);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextConfig)) {
                return false;
            }
            TextConfig textConfig = (TextConfig) obj;
            if (Intrinsics.areEqual(this.fontConfig, textConfig.fontConfig) && this.textColor == textConfig.textColor && this.textAlignment == textConfig.textAlignment && this.bold == textConfig.bold && Intrinsics.areEqual(this.textShadow, textConfig.textShadow)) {
                return true;
            }
            return false;
        }

        public final boolean getBold() {
            return this.bold;
        }

        public final FontConfig getFontConfig() {
            return this.fontConfig;
        }

        public final TextAlignment getTextAlignment() {
            return this.textAlignment;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final Shadow getTextShadow() {
            return this.textShadow;
        }

        public int hashCode() {
            int hashCode;
            int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.bold, (this.textAlignment.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.textColor, this.fontConfig.hashCode() * 31, 31)) * 31, 31);
            Shadow shadow = this.textShadow;
            if (shadow == null) {
                hashCode = 0;
            } else {
                hashCode = shadow.hashCode();
            }
            return m + hashCode;
        }

        public String toString() {
            return "TextConfig(fontConfig=" + this.fontConfig + ", textColor=" + this.textColor + ", textAlignment=" + this.textAlignment + ", bold=" + this.bold + ", textShadow=" + this.textShadow + ')';
        }

        public /* synthetic */ TextConfig(FontConfig fontConfig, int r8, TextAlignment textAlignment, boolean z, Shadow shadow, int r12, DefaultConstructorMarker defaultConstructorMarker) {
            this(fontConfig, (r12 & 2) != 0 ? Kolors.black : r8, (r12 & 4) != 0 ? TextAlignment.LEFT : textAlignment, (r12 & 8) != 0 ? false : z, (r12 & 16) != 0 ? null : shadow);
        }
    }
}
