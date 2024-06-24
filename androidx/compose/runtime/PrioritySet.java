package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class PrioritySet {
    public final List<Integer> list = new ArrayList();

    public PrioritySet(int r1) {
    }

    public final void add(int r5) {
        List<Integer> list = this.list;
        if ((!list.isEmpty()) && (list.get(0).intValue() == r5 || list.get(list.size() - 1).intValue() == r5)) {
            return;
        }
        int size = list.size();
        list.add(Integer.valueOf(r5));
        while (size > 0) {
            int r2 = ((size + 1) >>> 1) - 1;
            int intValue = list.get(r2).intValue();
            if (r5 <= intValue) {
                break;
            }
            list.set(size, Integer.valueOf(intValue));
            size = r2;
        }
        list.set(size, Integer.valueOf(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int takeMax() {
        boolean z;
        int intValue;
        List<Integer> list = this.list;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int intValue2 = ((Number) list.get(0)).intValue();
            while ((!list.isEmpty()) && ((Number) list.get(0)).intValue() == intValue2) {
                list.set(0, CollectionsKt___CollectionsKt.last(list));
                list.remove(list.size() - 1);
                int size = list.size();
                int size2 = list.size() >>> 1;
                int r6 = 0;
                while (r6 < size2) {
                    int intValue3 = ((Number) list.get(r6)).intValue();
                    int r8 = (r6 + 1) * 2;
                    int r9 = r8 - 1;
                    int intValue4 = ((Number) list.get(r9)).intValue();
                    if (r8 < size && (intValue = ((Number) list.get(r8)).intValue()) > intValue4) {
                        if (intValue > intValue3) {
                            list.set(r6, Integer.valueOf(intValue));
                            list.set(r8, Integer.valueOf(intValue3));
                            r6 = r8;
                        }
                    } else if (intValue4 > intValue3) {
                        list.set(r6, Integer.valueOf(intValue4));
                        list.set(r9, Integer.valueOf(intValue3));
                        r6 = r9;
                    }
                }
            }
            return intValue2;
        }
        ComposerKt.composeRuntimeError("Set is empty".toString());
        throw null;
    }
}
