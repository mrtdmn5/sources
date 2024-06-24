package com.animaconnected.watch.display.view;

import com.animaconnected.watch.display.VarType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Variable extends Element {
    private int color;
    private int height;
    private final VarType type;
    private int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Variable(VarType type) {
        super(0, 0, 0, 0, 15, null);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.width = 40;
        this.height = 14;
        this.color = -1;
    }

    public final int getColor() {
        return this.color;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getHeight() {
        return this.height;
    }

    public final VarType getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getWidth() {
        return this.width;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setHeight(int r1) {
        this.height = r1;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setWidth(int r1) {
        this.width = r1;
    }
}
