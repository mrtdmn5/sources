package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public final class ValueElementSequence implements Sequence<ValueElement> {
    public final ArrayList elements = new ArrayList();

    @Override // kotlin.sequences.Sequence
    public final Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public final void set(Object obj, String str) {
        this.elements.add(new ValueElement(str, obj));
    }
}
