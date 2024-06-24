package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;

/* compiled from: TextSelectionColors.kt */
/* loaded from: classes.dex */
public final class TextSelectionColors {
    public final long backgroundColor;
    public final long handleColor;

    public TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        if (Color.m317equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m317equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.backgroundColor) + (Long.hashCode(this.handleColor) * 31);
    }

    public final String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m323toStringimpl(this.handleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m323toStringimpl(this.backgroundColor)) + ')';
    }
}
