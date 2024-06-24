package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;

/* compiled from: TextIndent.kt */
/* loaded from: classes.dex */
public final class TextIndent {
    public static final TextIndent None = new TextIndent(TextUnitKt.getSp(0), TextUnitKt.getSp(0));
    public final long firstLine;
    public final long restLine;

    public TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        if (TextUnit.m596equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m596equalsimpl0(this.restLine, textIndent.restLine)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        return Long.hashCode(this.restLine) + (Long.hashCode(this.firstLine) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m599toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m599toStringimpl(this.restLine)) + ')';
    }
}
