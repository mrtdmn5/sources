package androidx.compose.ui.tooling.preview;

import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: PreviewParameter.kt */
/* loaded from: classes.dex */
public interface PreviewParameterProvider<T> {
    default int getCount() {
        return SequencesKt___SequencesKt.count(getValues());
    }

    Sequence<T> getValues();
}
