package com.animaconnected.watch.display.view;

import com.animaconnected.watch.display.CanvasPaint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Text extends Element {
    private final Boolean center;
    private int height;
    private final String link;
    private final boolean multiLines;
    private final CanvasPaint paint;
    private final String text;
    private int width;

    public /* synthetic */ Text(String str, CanvasPaint canvasPaint, boolean z, String str2, Boolean bool, int r12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, canvasPaint, (r12 & 4) != 0 ? true : z, (r12 & 8) != 0 ? null : str2, (r12 & 16) != 0 ? Boolean.TRUE : bool);
    }

    public final Boolean getCenter() {
        return this.center;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getHeight() {
        return this.height;
    }

    public final String getLink() {
        return this.link;
    }

    public final boolean getMultiLines() {
        return this.multiLines;
    }

    public final CanvasPaint getPaint() {
        return this.paint;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getWidth() {
        return this.width;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setHeight(int r1) {
        this.height = r1;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setWidth(int r1) {
        this.width = r1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Text(String text, CanvasPaint paint, boolean z, String str, Boolean bool) {
        super(0, 0, 0, 0, 15, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.text = text;
        this.paint = paint;
        this.multiLines = z;
        this.link = str;
        this.center = bool;
        this.width = (int) paint.measureWidth(text);
        this.height = (int) paint.measureHeight(text);
    }
}
