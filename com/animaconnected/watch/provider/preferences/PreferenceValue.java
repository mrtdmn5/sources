package com.animaconnected.watch.provider.preferences;

import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackKotlin;
import com.animaconnected.watch.device.MsgPackKt;
import com.google.android.gms.tasks.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysJvmKt$asList$3;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PreferenceData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class PreferenceValue {
    public static final Companion Companion = new Companion(null);
    private final int id;
    private final int[] value;

    /* compiled from: PreferenceData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PreferenceValue decodeValue(int r2, MsgPack msgPack) {
            List<Integer> tryIntList = MsgPackKt.tryIntList(msgPack);
            if (tryIntList == null) {
                tryIntList = CollectionsKt__CollectionsKt.listOf(Integer.valueOf(msgPack.asInt()));
            }
            return new PreferenceValue(r2, CollectionsKt___CollectionsKt.toIntArray(tryIntList));
        }

        private final MsgPack encodeValue(PreferenceValue preferenceValue) {
            boolean z = true;
            if (preferenceValue.getValue().length > 1) {
                MsgPackKotlin.Companion companion = MsgPackKotlin.Companion;
                int[] value = preferenceValue.getValue();
                Intrinsics.checkNotNullParameter(value, "<this>");
                return companion.newArray(new ArraysKt___ArraysJvmKt$asList$3(value));
            }
            MsgPackKotlin.Companion companion2 = MsgPackKotlin.Companion;
            int[] value2 = preferenceValue.getValue();
            Intrinsics.checkNotNullParameter(value2, "<this>");
            if (value2.length != 0) {
                z = false;
            }
            if (!z) {
                return companion2.newInt(value2[0]);
            }
            throw new NoSuchElementException("Array is empty.");
        }

        public final List<PreferenceValue> decodeFromMsgpack(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Map<Integer, MsgPack> map = MsgPackKotlin.Companion.fromBytes(bytes).getMap();
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Integer, MsgPack> entry : map.entrySet()) {
                arrayList.add(PreferenceValue.Companion.decodeValue(entry.getKey().intValue(), entry.getValue()));
            }
            return arrayList;
        }

        public final PreferenceValue decodeValueFromMsgpack(int r2, byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return decodeValue(r2, MsgPackKotlin.Companion.fromBytes(bytes));
        }

        public final byte[] encodeToMsgpack(List<PreferenceValue> values) {
            Intrinsics.checkNotNullParameter(values, "values");
            List<PreferenceValue> list = values;
            int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            if (mapCapacity < 16) {
                mapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (PreferenceValue preferenceValue : list) {
                linkedHashMap.put(Integer.valueOf(preferenceValue.getId()), PreferenceValue.Companion.encodeValue(preferenceValue));
            }
            return MsgPackKotlin.Companion.newIntMap(linkedHashMap).toMsgPackBytes();
        }

        public final byte[] encodeValueToMsgpack(PreferenceValue pref) {
            Intrinsics.checkNotNullParameter(pref, "pref");
            return encodeValue(pref).toMsgPackBytes();
        }

        public final KSerializer<PreferenceValue> serializer() {
            return PreferenceValue$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PreferenceValue(int r2, int r3, int[] r4, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, PreferenceValue$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.id = r3;
        this.value = r4;
    }

    public static /* synthetic */ PreferenceValue copy$default(PreferenceValue preferenceValue, int r1, int[] r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = preferenceValue.id;
        }
        if ((r3 & 2) != 0) {
            r2 = preferenceValue.value;
        }
        return preferenceValue.copy(r1, r2);
    }

    public static final /* synthetic */ void write$Self$watch_release(PreferenceValue preferenceValue, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeIntElement(0, preferenceValue.id, serialDescriptor);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, IntArraySerializer.INSTANCE, preferenceValue.value);
    }

    public final int component1() {
        return this.id;
    }

    public final int[] component2() {
        return this.value;
    }

    public final PreferenceValue copy(int r2, int[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new PreferenceValue(r2, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreferenceValue.class != obj.getClass()) {
            return false;
        }
        PreferenceValue preferenceValue = (PreferenceValue) obj;
        if (this.id != preferenceValue.id) {
            return false;
        }
        return Arrays.equals(this.value, preferenceValue.value);
    }

    public final int getId() {
        return this.id;
    }

    public final int[] getValue() {
        return this.value;
    }

    public int hashCode() {
        return Arrays.hashCode(this.value) + (this.id * 31);
    }

    public String toString() {
        return "PreferenceValue(id=" + this.id + ", value=" + Arrays.toString(this.value) + ')';
    }

    public PreferenceValue(int r2, int[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.id = r2;
        this.value = value;
    }
}
