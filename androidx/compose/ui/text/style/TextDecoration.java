package androidx.compose.ui.text.style;

import androidx.compose.ui.text.TempListUtilsKt;
import java.util.ArrayList;

/* compiled from: TextDecoration.kt */
/* loaded from: classes.dex */
public final class TextDecoration {
    public final int mask;
    public static final TextDecoration None = new TextDecoration(0);
    public static final TextDecoration Underline = new TextDecoration(1);
    public static final TextDecoration LineThrough = new TextDecoration(2);

    public TextDecoration(int r1) {
        this.mask = r1;
    }

    public final boolean contains(TextDecoration textDecoration) {
        int r2 = textDecoration.mask;
        int r0 = this.mask;
        if ((r2 | r0) == r0) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextDecoration)) {
            return false;
        }
        if (this.mask == ((TextDecoration) obj).mask) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.mask;
    }

    public final String toString() {
        int r0 = this.mask;
        if (r0 == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((r0 & 1) != 0) {
            arrayList.add("Underline");
        }
        if ((r0 & 2) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + TempListUtilsKt.fastJoinToString$default(arrayList, ", ", null, 62) + ']';
    }
}
