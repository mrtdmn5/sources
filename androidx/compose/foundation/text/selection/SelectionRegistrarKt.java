package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: SelectionRegistrar.kt */
/* loaded from: classes.dex */
public final class SelectionRegistrarKt {
    public static final DynamicProvidableCompositionLocal LocalSelectionRegistrar = CompositionLocalKt.compositionLocalOf$default(new Function0<SelectionRegistrar>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarKt$LocalSelectionRegistrar$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ SelectionRegistrar invoke() {
            return null;
        }
    });

    public static final boolean hasSelection(SelectionRegistrar selectionRegistrar, long j) {
        Map<Long, Selection> subselections;
        if (selectionRegistrar != null && (subselections = selectionRegistrar.getSubselections()) != null) {
            return subselections.containsKey(Long.valueOf(j));
        }
        return false;
    }
}
