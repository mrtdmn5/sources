package androidx.compose.ui.text;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;

/* compiled from: Placeholder.kt */
/* loaded from: classes.dex */
public final class Placeholder {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        placeholder.getClass();
        if (!TextUnit.m596equalsimpl0(0L, 0L)) {
            return false;
        }
        placeholder.getClass();
        if (!TextUnit.m596equalsimpl0(0L, 0L)) {
            return false;
        }
        placeholder.getClass();
        return true;
    }

    public final int hashCode() {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        return Integer.hashCode(0) + Scale$$ExternalSyntheticOutline0.m(0L, Long.hashCode(0L) * 31, 31);
    }

    public final String toString() {
        return "Placeholder(width=" + ((Object) TextUnit.m599toStringimpl(0L)) + ", height=" + ((Object) TextUnit.m599toStringimpl(0L)) + ", placeholderVerticalAlign=" + ((Object) "Invalid") + ')';
    }
}
