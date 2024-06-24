package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;

/* compiled from: CollectionInfo.kt */
/* loaded from: classes.dex */
public final class CollectionInfoKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    public static final boolean calculateIfHorizontallyStacked(ArrayList arrayList) {
        Collection collection;
        long j;
        if (arrayList.size() < 2) {
            return true;
        }
        if (arrayList.size() != 0 && arrayList.size() != 1) {
            collection = new ArrayList();
            Object obj = arrayList.get(0);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            int r5 = 0;
            while (r5 < lastIndex) {
                r5++;
                Object obj2 = arrayList.get(r5);
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                collection.add(new Offset(OffsetKt.Offset(Math.abs(Offset.m259getXimpl(semanticsNode2.getBoundsInRoot().m269getCenterF1C5BW0()) - Offset.m259getXimpl(semanticsNode.getBoundsInRoot().m269getCenterF1C5BW0())), Math.abs(Offset.m260getYimpl(semanticsNode2.getBoundsInRoot().m269getCenterF1C5BW0()) - Offset.m260getYimpl(semanticsNode.getBoundsInRoot().m269getCenterF1C5BW0())))));
                obj = obj2;
            }
        } else {
            collection = EmptyList.INSTANCE;
        }
        if (collection.size() == 1) {
            j = ((Offset) CollectionsKt___CollectionsKt.first((List) collection)).packedValue;
        } else if (!collection.isEmpty()) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) collection);
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(collection);
            if (1 <= lastIndex2) {
                int r4 = 1;
                while (true) {
                    first = new Offset(Offset.m262plusMKHz9U(((Offset) first).packedValue, ((Offset) collection.get(r4)).packedValue));
                    if (r4 == lastIndex2) {
                        break;
                    }
                    r4++;
                }
            }
            j = ((Offset) first).packedValue;
        } else {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        if (Offset.m260getYimpl(j) < Offset.m259getXimpl(j)) {
            return true;
        }
        return false;
    }

    public static final boolean hasCollectionInfo(SemanticsNode semanticsNode) {
        if (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.CollectionInfo) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.SelectableGroup) == null) {
            return false;
        }
        return true;
    }
}
