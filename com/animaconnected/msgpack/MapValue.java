package com.animaconnected.msgpack;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class MapValue extends Value {
    private final Map<Value, Value> map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MapValue(Map<Value, ? extends Value> map) {
        super(null);
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapValue copy$default(MapValue mapValue, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = mapValue.map;
        }
        return mapValue.copy(map);
    }

    public final Map<Value, Value> component1() {
        return this.map;
    }

    public final MapValue copy(Map<Value, ? extends Value> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new MapValue(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof MapValue) && Intrinsics.areEqual(this.map, ((MapValue) obj).map)) {
            return true;
        }
        return false;
    }

    public final Map<Value, Value> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("MapValue(map="), this.map, ')');
    }
}
