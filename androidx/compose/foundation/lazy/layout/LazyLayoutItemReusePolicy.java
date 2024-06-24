package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayout.kt */
/* loaded from: classes.dex */
public final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {
    public final LinkedHashMap countPerType;
    public final LazyLayoutItemContentFactory factory;

    public LazyLayoutItemReusePolicy(LazyLayoutItemContentFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factory = factory;
        this.countPerType = new LinkedHashMap();
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public final boolean areCompatible(Object obj, Object obj2) {
        LazyLayoutItemContentFactory lazyLayoutItemContentFactory = this.factory;
        return Intrinsics.areEqual(lazyLayoutItemContentFactory.getContentType(obj), lazyLayoutItemContentFactory.getContentType(obj2));
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public final void getSlotsToRetain(SubcomposeSlotReusePolicy.SlotIdsSet slotIds) {
        int r2;
        Intrinsics.checkNotNullParameter(slotIds, "slotIds");
        LinkedHashMap linkedHashMap = this.countPerType;
        linkedHashMap.clear();
        Iterator<Object> it = slotIds.iterator();
        while (it.hasNext()) {
            Object contentType = this.factory.getContentType(it.next());
            Integer num = (Integer) linkedHashMap.get(contentType);
            if (num != null) {
                r2 = num.intValue();
            } else {
                r2 = 0;
            }
            if (r2 == 7) {
                it.remove();
            } else {
                linkedHashMap.put(contentType, Integer.valueOf(r2 + 1));
            }
        }
    }
}
