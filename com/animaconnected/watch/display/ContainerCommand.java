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
public final class ContainerCommand extends DrawCommand {
    private final int height;
    private final int id;
    private final int width;
    private final int x;
    private final int y;

    public /* synthetic */ ContainerCommand(int r8, int r9, int r10, int r11, int r12, int r13, DefaultConstructorMarker defaultConstructorMarker) {
        this(r8, r9, r10, (r13 & 8) != 0 ? 0 : r11, (r13 & 16) != 0 ? 0 : r12);
    }

    public static /* synthetic */ ContainerCommand copy$default(ContainerCommand containerCommand, int r4, int r5, int r6, int r7, int r8, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            r4 = containerCommand.id;
        }
        if ((r9 & 2) != 0) {
            r5 = containerCommand.x;
        }
        int r10 = r5;
        if ((r9 & 4) != 0) {
            r6 = containerCommand.y;
        }
        int r0 = r6;
        if ((r9 & 8) != 0) {
            r7 = containerCommand.width;
        }
        int r1 = r7;
        if ((r9 & 16) != 0) {
            r8 = containerCommand.height;
        }
        return containerCommand.copy(r4, r10, r0, r1, r8);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.x;
    }

    public final int component3() {
        return this.y;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final ContainerCommand copy(int r8, int r9, int r10, int r11, int r12) {
        return new ContainerCommand(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContainerCommand)) {
            return false;
        }
        ContainerCommand containerCommand = (ContainerCommand) obj;
        if (this.id == containerCommand.id && this.x == containerCommand.x && this.y == containerCommand.y && this.width == containerCommand.width && this.height == containerCommand.height) {
            return true;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
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
        return Integer.hashCode(this.height) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.width, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.x, Integer.hashCode(this.id) * 31, 31), 31), 31);
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Container), new Pair(Parameter.Id, Integer.valueOf(this.id)), new Pair(Parameter.X, Integer.valueOf(this.x)), new Pair(Parameter.Y, Integer.valueOf(this.y)));
        int r1 = this.width;
        if (r1 != 0) {
            mutableMapOf.put(Parameter.Width, Integer.valueOf(r1));
        }
        int r12 = this.height;
        if (r12 != 0) {
            mutableMapOf.put(Parameter.Height, Integer.valueOf(r12));
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ContainerCommand(id=");
        sb.append(this.id);
        sb.append(", x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.height, ')');
    }

    public ContainerCommand(int r2, int r3, int r4, int r5, int r6) {
        super(null);
        this.id = r2;
        this.x = r3;
        this.y = r4;
        this.width = r5;
        this.height = r6;
    }
}
