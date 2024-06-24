package com.animaconnected.watch.display;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class TextCommand extends DrawCommand {
    private final int color;
    private final Integer containerId;
    private final Font font;
    private final Integer height;
    private final String linkName;
    private final String text;
    private final Integer width;
    private final int x;
    private final int y;

    public /* synthetic */ TextCommand(String str, int r14, int r15, int r16, Font font, Integer num, Integer num2, Integer num3, String str2, int r22, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r14, r15, (r22 & 8) != 0 ? -1 : r16, (r22 & 16) != 0 ? null : font, (r22 & 32) != 0 ? null : num, (r22 & 64) != 0 ? null : num2, (r22 & 128) != 0 ? null : num3, (r22 & 256) != 0 ? null : str2);
    }

    public static /* synthetic */ TextCommand copy$default(TextCommand textCommand, String str, int r12, int r13, int r14, Font font, Integer num, Integer num2, Integer num3, String str2, int r20, Object obj) {
        String str3;
        int r3;
        int r4;
        int r5;
        Font font2;
        Integer num4;
        Integer num5;
        Integer num6;
        String str4;
        if ((r20 & 1) != 0) {
            str3 = textCommand.text;
        } else {
            str3 = str;
        }
        if ((r20 & 2) != 0) {
            r3 = textCommand.x;
        } else {
            r3 = r12;
        }
        if ((r20 & 4) != 0) {
            r4 = textCommand.y;
        } else {
            r4 = r13;
        }
        if ((r20 & 8) != 0) {
            r5 = textCommand.color;
        } else {
            r5 = r14;
        }
        if ((r20 & 16) != 0) {
            font2 = textCommand.font;
        } else {
            font2 = font;
        }
        if ((r20 & 32) != 0) {
            num4 = textCommand.containerId;
        } else {
            num4 = num;
        }
        if ((r20 & 64) != 0) {
            num5 = textCommand.width;
        } else {
            num5 = num2;
        }
        if ((r20 & 128) != 0) {
            num6 = textCommand.height;
        } else {
            num6 = num3;
        }
        if ((r20 & 256) != 0) {
            str4 = textCommand.linkName;
        } else {
            str4 = str2;
        }
        return textCommand.copy(str3, r3, r4, r5, font2, num4, num5, num6, str4);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.x;
    }

    public final int component3() {
        return this.y;
    }

    public final int component4() {
        return this.color;
    }

    public final Font component5() {
        return this.font;
    }

    public final Integer component6() {
        return this.containerId;
    }

    public final Integer component7() {
        return this.width;
    }

    public final Integer component8() {
        return this.height;
    }

    public final String component9() {
        return this.linkName;
    }

    public final TextCommand copy(String text, int r13, int r14, int r15, Font font, Integer num, Integer num2, Integer num3, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextCommand(text, r13, r14, r15, font, num, num2, num3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextCommand)) {
            return false;
        }
        TextCommand textCommand = (TextCommand) obj;
        if (Intrinsics.areEqual(this.text, textCommand.text) && this.x == textCommand.x && this.y == textCommand.y && this.color == textCommand.color && Intrinsics.areEqual(this.font, textCommand.font) && Intrinsics.areEqual(this.containerId, textCommand.containerId) && Intrinsics.areEqual(this.width, textCommand.width) && Intrinsics.areEqual(this.height, textCommand.height) && Intrinsics.areEqual(this.linkName, textCommand.linkName)) {
            return true;
        }
        return false;
    }

    public final int getColor() {
        return this.color;
    }

    public final Integer getContainerId() {
        return this.containerId;
    }

    public final Font getFont() {
        return this.font;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getLinkName() {
        return this.linkName;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.color, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.x, this.text.hashCode() * 31, 31), 31), 31);
        Font font = this.font;
        int r2 = 0;
        if (font == null) {
            hashCode = 0;
        } else {
            hashCode = font.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Integer num = this.containerId;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Integer num2 = this.width;
        if (num2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num2.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Integer num3 = this.height;
        if (num3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        String str = this.linkName;
        if (str != null) {
            r2 = str.hashCode();
        }
        return r04 + r2;
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        String str;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = new Pair(Parameter.Type, CommandType.Text);
        pairArr[1] = new Pair(Parameter.X, Integer.valueOf(this.x));
        pairArr[2] = new Pair(Parameter.Y, Integer.valueOf(this.y));
        Parameter parameter = Parameter.Data;
        if (this.linkName != null) {
            str = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("$"), this.linkName, ".txt");
        } else {
            str = this.text;
        }
        pairArr[3] = new Pair(parameter, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        int r1 = this.color;
        if (r1 != -1) {
            mutableMapOf.put(Parameter.Color, Integer.valueOf(r1));
        }
        Font font = this.font;
        if (font != null) {
            mutableMapOf.put(Parameter.Font, Integer.valueOf(font.getFontType().getId()));
        }
        Integer num = this.containerId;
        if (num != null) {
            mutableMapOf.put(Parameter.Id, num);
        }
        Integer num2 = this.width;
        if (num2 != null) {
            mutableMapOf.put(Parameter.Width, num2);
        }
        Integer num3 = this.height;
        if (num3 != null) {
            mutableMapOf.put(Parameter.Height, num3);
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextCommand(text=");
        sb.append(this.text);
        sb.append(", x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", color=");
        sb.append(this.color);
        sb.append(", font=");
        sb.append(this.font);
        sb.append(", containerId=");
        sb.append(this.containerId);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", linkName=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.linkName, ')');
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextCommand(String text, int r3, int r4, int r5, Font font, Integer num, Integer num2, Integer num3, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.x = r3;
        this.y = r4;
        this.color = r5;
        this.font = font;
        this.containerId = num;
        this.width = num2;
        this.height = num3;
        this.linkName = str;
    }
}
