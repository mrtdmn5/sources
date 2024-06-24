package androidx.compose.ui.text.android;

import java.util.Comparator;
import kotlin.Pair;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LayoutIntrinsicsKt$$ExternalSyntheticLambda0 implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Pair pair = (Pair) obj;
        Pair pair2 = (Pair) obj2;
        return (((Number) pair.second).intValue() - ((Number) pair.first).intValue()) - (((Number) pair2.second).intValue() - ((Number) pair2.first).intValue());
    }
}
