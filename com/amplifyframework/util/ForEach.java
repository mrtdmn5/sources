package com.amplifyframework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class ForEach {

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface Mapping<I, O> {
        O apply(I r1);
    }

    private ForEach() {
    }

    public static <I, O> List<O> inArray(I[] r4, Mapping<I, O> mapping) {
        ArrayList arrayList = new ArrayList();
        for (I r0 : r4) {
            arrayList.add(mapping.apply(r0));
        }
        return Immutable.of(arrayList);
    }

    public static <I, O> List<O> inCollection(Collection<I> collection, Mapping<I, O> mapping) {
        ArrayList arrayList = new ArrayList();
        Iterator<I> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(mapping.apply(it.next()));
        }
        return Immutable.of(arrayList);
    }
}
