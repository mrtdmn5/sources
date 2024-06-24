package org.slf4j.helpers;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public final class BasicMarker implements Marker {
    public final String name;
    public final CopyOnWriteArrayList referenceList = new CopyOnWriteArrayList();

    public BasicMarker(String str) {
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        return this.name.equals(((Marker) obj).getName());
    }

    @Override // org.slf4j.Marker
    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        boolean z;
        CopyOnWriteArrayList copyOnWriteArrayList = this.referenceList;
        if (copyOnWriteArrayList.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        String str = this.name;
        if (!z) {
            return str;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        StringBuilder sb = new StringBuilder(str);
        sb.append(" [ ");
        while (it.hasNext()) {
            sb.append(((Marker) it.next()).getName());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
