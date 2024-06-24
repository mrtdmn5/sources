package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public interface MapFieldSchema {
    MapFieldLite forMapData(Object obj);

    void forMapMetadata(Object obj);

    MapFieldLite forMutableMapData(Object obj);

    int getSerializedSize(Object obj, int r2, Object obj2);

    boolean isImmutable(Object obj);

    MapFieldLite mergeFrom(Object obj, Object obj2);

    MapFieldLite newMapField();

    Object toImmutable(Object obj);
}
