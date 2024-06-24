package com.animaconnected.watch.display.view;

import com.animaconnected.watch.image.Mitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Image extends Element {
    private int height;
    private final String link;
    private final Mitmap mitmap;
    private int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Image(int r9, int r10, Mitmap mitmap, String str) {
        super(r9, r10, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        this.mitmap = mitmap;
        this.link = str;
        this.height = mitmap.getHeight();
        this.width = mitmap.getWidth();
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getHeight() {
        return this.height;
    }

    public final String getLink() {
        return this.link;
    }

    public final Mitmap getMitmap() {
        return this.mitmap;
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

    public /* synthetic */ Image(int r1, int r2, Mitmap mitmap, String str, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, mitmap, (r5 & 8) != 0 ? null : str);
    }
}
