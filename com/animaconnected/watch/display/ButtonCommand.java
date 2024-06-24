package com.animaconnected.watch.display;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class ButtonCommand extends DrawCommand {
    private final Integer animation;
    private final int color;
    private final int contID;
    private final Font font;
    private final List<HidCommand> hidCommands;
    private final Integer navCommand;
    private final String text;

    public /* synthetic */ ButtonCommand(String str, int r11, int r12, Font font, List list, Integer num, Integer num2, int r17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r11, (r17 & 4) != 0 ? -1 : r12, (r17 & 8) != 0 ? null : font, (r17 & 16) != 0 ? null : list, (r17 & 32) != 0 ? null : num, (r17 & 64) != 0 ? null : num2);
    }

    public static /* synthetic */ ButtonCommand copy$default(ButtonCommand buttonCommand, String str, int r7, int r8, Font font, List list, Integer num, Integer num2, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            str = buttonCommand.text;
        }
        if ((r13 & 2) != 0) {
            r7 = buttonCommand.contID;
        }
        int r14 = r7;
        if ((r13 & 4) != 0) {
            r8 = buttonCommand.color;
        }
        int r0 = r8;
        if ((r13 & 8) != 0) {
            font = buttonCommand.font;
        }
        Font font2 = font;
        if ((r13 & 16) != 0) {
            list = buttonCommand.hidCommands;
        }
        List list2 = list;
        if ((r13 & 32) != 0) {
            num = buttonCommand.navCommand;
        }
        Integer num3 = num;
        if ((r13 & 64) != 0) {
            num2 = buttonCommand.animation;
        }
        return buttonCommand.copy(str, r14, r0, font2, list2, num3, num2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.contID;
    }

    public final int component3() {
        return this.color;
    }

    public final Font component4() {
        return this.font;
    }

    public final List<HidCommand> component5() {
        return this.hidCommands;
    }

    public final Integer component6() {
        return this.navCommand;
    }

    public final Integer component7() {
        return this.animation;
    }

    public final ButtonCommand copy(String text, int r11, int r12, Font font, List<? extends HidCommand> list, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new ButtonCommand(text, r11, r12, font, list, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonCommand)) {
            return false;
        }
        ButtonCommand buttonCommand = (ButtonCommand) obj;
        if (Intrinsics.areEqual(this.text, buttonCommand.text) && this.contID == buttonCommand.contID && this.color == buttonCommand.color && Intrinsics.areEqual(this.font, buttonCommand.font) && Intrinsics.areEqual(this.hidCommands, buttonCommand.hidCommands) && Intrinsics.areEqual(this.navCommand, buttonCommand.navCommand) && Intrinsics.areEqual(this.animation, buttonCommand.animation)) {
            return true;
        }
        return false;
    }

    public final Integer getAnimation() {
        return this.animation;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getContID() {
        return this.contID;
    }

    public final Font getFont() {
        return this.font;
    }

    public final List<HidCommand> getHidCommands() {
        return this.hidCommands;
    }

    public final Integer getNavCommand() {
        return this.navCommand;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.color, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.contID, this.text.hashCode() * 31, 31), 31);
        Font font = this.font;
        int r2 = 0;
        if (font == null) {
            hashCode = 0;
        } else {
            hashCode = font.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        List<HidCommand> list = this.hidCommands;
        if (list == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Integer num = this.navCommand;
        if (num == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Integer num2 = this.animation;
        if (num2 != null) {
            r2 = num2.hashCode();
        }
        return r03 + r2;
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        boolean z;
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Button), new Pair(Parameter.Id, Integer.valueOf(this.contID)), new Pair(Parameter.Data, this.text));
        int r1 = this.color;
        if (r1 != -1) {
            mutableMapOf.put(Parameter.Color, Integer.valueOf(r1));
        }
        Font font = this.font;
        if (font != null) {
            mutableMapOf.put(Parameter.Font, Integer.valueOf(font.getFontType().getId()));
        }
        Integer num = this.navCommand;
        if (num != null) {
            mutableMapOf.put(Parameter.Navigation, num);
        }
        Integer num2 = this.animation;
        if (num2 != null) {
            mutableMapOf.put(Parameter.Animation, num2);
        }
        List<HidCommand> list = this.hidCommands;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Parameter parameter = Parameter.HID;
            List<HidCommand> list2 = this.hidCommands;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((HidCommand) it.next()).getCommand()));
            }
            mutableMapOf.put(parameter, arrayList.toArray(new Integer[0]));
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ButtonCommand(text=");
        sb.append(this.text);
        sb.append(", contID=");
        sb.append(this.contID);
        sb.append(", color=");
        sb.append(this.color);
        sb.append(", font=");
        sb.append(this.font);
        sb.append(", hidCommands=");
        sb.append(this.hidCommands);
        sb.append(", navCommand=");
        sb.append(this.navCommand);
        sb.append(", animation=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.animation, ')');
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ButtonCommand(String text, int r3, int r4, Font font, List<? extends HidCommand> list, Integer num, Integer num2) {
        super(null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.contID = r3;
        this.color = r4;
        this.font = font;
        this.hidCommands = list;
        this.navCommand = num;
        this.animation = num2;
    }
}
