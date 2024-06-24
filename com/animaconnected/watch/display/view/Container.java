package com.animaconnected.watch.display.view;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public abstract class Container extends Element {
    private final List<Element> children;

    public /* synthetic */ Container(int r1, int r2, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r4);
    }

    public final List<Element> getChildren() {
        return this.children;
    }

    private Container(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.children = new ArrayList();
    }

    public /* synthetic */ Container(int r8, int r9, int r10, int r11, int r12, DefaultConstructorMarker defaultConstructorMarker) {
        this((r12 & 1) != 0 ? 0 : r8, (r12 & 2) != 0 ? 0 : r9, r10, r11, null);
    }
}
