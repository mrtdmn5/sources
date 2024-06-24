package com.animaconnected.watch.display.view;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class BottomPusher extends Element {
    public static final Companion Companion = new Companion(null);
    public static final int closeApp = -1;
    private Integer animation;
    private int navCommand;

    /* compiled from: DisplayDefinition.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BottomPusher() {
        this(0, 1, null);
    }

    public final Integer getAnimation() {
        return this.animation;
    }

    public final int getNavCommand() {
        return this.navCommand;
    }

    public final void setAnimation(Integer num) {
        this.animation = num;
    }

    public final void setNavCommand(int r1) {
        this.navCommand = r1;
    }

    public BottomPusher(int r8) {
        super(0, 0, 0, 0, 15, null);
        this.navCommand = r8;
    }

    public /* synthetic */ BottomPusher(int r1, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? -1 : r1);
    }
}
