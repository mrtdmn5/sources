package com.animaconnected.watch.display.view;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class ListView extends Rectangle {
    private Orientation orientation;

    public ListView(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.orientation = Orientation.Vertical;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }
}
