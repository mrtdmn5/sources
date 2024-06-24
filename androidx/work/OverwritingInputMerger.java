package androidx.work;

import androidx.work.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data merge(ArrayList inputs) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator it = inputs.iterator();
        while (it.hasNext()) {
            hashMap.putAll(Collections.unmodifiableMap(((Data) it.next()).mValues));
        }
        builder.putAll(hashMap);
        Data data = new Data(builder.mValues);
        Data.toByteArrayInternal(data);
        return data;
    }
}
