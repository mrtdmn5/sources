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
public final class ProgressBarCommand extends DrawCommand {
    private final int height;
    private final int width;
    private final int x;
    private final int y;

    public /* synthetic */ ProgressBarCommand(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r3, (r6 & 4) != 0 ? 0 : r4, (r6 & 8) != 0 ? 0 : r5);
    }

    public static /* synthetic */ ProgressBarCommand copy$default(ProgressBarCommand progressBarCommand, int r1, int r2, int r3, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = progressBarCommand.x;
        }
        if ((r5 & 2) != 0) {
            r2 = progressBarCommand.y;
        }
        if ((r5 & 4) != 0) {
            r3 = progressBarCommand.width;
        }
        if ((r5 & 8) != 0) {
            r4 = progressBarCommand.height;
        }
        return progressBarCommand.copy(r1, r2, r3, r4);
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

    public final ProgressBarCommand copy(int r2, int r3, int r4, int r5) {
        return new ProgressBarCommand(r2, r3, r4, r5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarCommand)) {
            return false;
        }
        ProgressBarCommand progressBarCommand = (ProgressBarCommand) obj;
        if (this.x == progressBarCommand.x && this.y == progressBarCommand.y && this.width == progressBarCommand.width && this.height == progressBarCommand.height) {
            return true;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
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
        return Integer.hashCode(this.height) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.width, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.y, Integer.hashCode(this.x) * 31, 31), 31);
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Progressbar), new Pair(Parameter.X, Integer.valueOf(this.x)), new Pair(Parameter.Y, Integer.valueOf(this.y)));
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
        StringBuilder sb = new StringBuilder("ProgressBarCommand(x=");
        sb.append(this.x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.height, ')');
    }

    public ProgressBarCommand(int r2, int r3, int r4, int r5) {
        super(null);
        this.x = r2;
        this.y = r3;
        this.width = r4;
        this.height = r5;
    }
}
