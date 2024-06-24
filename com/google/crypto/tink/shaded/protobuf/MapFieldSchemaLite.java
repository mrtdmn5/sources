package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MapFieldSchemaLite implements MapFieldSchema {
    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final MapFieldLite forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final void forMapMetadata(Object obj) {
        ((MapEntryLite) obj).getClass();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final MapFieldLite forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final int getSerializedSize(Object obj, int r3, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            Iterator it = mapFieldLite.entrySet().iterator();
            if (!it.hasNext()) {
                return 0;
            }
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            mapEntryLite.getClass();
            CodedOutputStream.computeTagSize(r3);
            throw null;
        }
        return 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).isMutable;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final MapFieldLite mergeFrom(Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable) {
                if (mapFieldLite.isEmpty()) {
                    mapFieldLite = new MapFieldLite();
                } else {
                    mapFieldLite = new MapFieldLite(mapFieldLite);
                }
            }
            mapFieldLite.ensureMutable();
            if (!mapFieldLite2.isEmpty()) {
                mapFieldLite.putAll(mapFieldLite2);
            }
        }
        return mapFieldLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final MapFieldLite newMapField() {
        MapFieldLite mapFieldLite = MapFieldLite.EMPTY_MAP_FIELD;
        if (mapFieldLite.isEmpty()) {
            return new MapFieldLite();
        }
        return new MapFieldLite(mapFieldLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Object toImmutable(Object obj) {
        ((MapFieldLite) obj).isMutable = false;
        return obj;
    }
}
