package com.animaconnected.watch.display.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
@ElementMarker
/* loaded from: classes3.dex */
public abstract class Element {
    public static final Companion Companion = new Companion(null);
    public static final int RELATIVE_CURRENT = Integer.MIN_VALUE;
    private int height;
    private Position position;
    private int width;
    private int x;
    private int y;

    /* compiled from: DisplayDefinition.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Element() {
        this(0, 0, 0, 0, 15, null);
    }

    public int getHeight() {
        return this.height;
    }

    public final Position getPosition() {
        return this.position;
    }

    public int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public final void setPosition(Position position) {
        Intrinsics.checkNotNullParameter(position, "<set-?>");
        this.position = position;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }

    public final void setX(int r1) {
        this.x = r1;
    }

    public final void setY(int r1) {
        this.y = r1;
    }

    public Element(int r1, int r2, int r3, int r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
        this.position = Position.Coordinates;
    }

    public /* synthetic */ Element(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0 : r2, (r6 & 2) != 0 ? 0 : r3, (r6 & 4) != 0 ? 10 : r4, (r6 & 8) != 0 ? 10 : r5);
    }
}
