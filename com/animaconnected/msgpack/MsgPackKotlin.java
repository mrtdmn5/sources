package com.animaconnected.msgpack;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.info.ByteUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: MsgPackKotlin.kt */
/* loaded from: classes.dex */
public final class MsgPackKotlin implements MsgPack {
    public static final Companion Companion = new Companion(null);
    private final boolean isArrayValue;
    private final boolean isBinaryValue;
    private final boolean isIntegerValue;
    private final boolean isMapValue;
    private final boolean isNilValue;
    private final boolean isStringValue;
    private final Value value;

    /* compiled from: MsgPackKotlin.kt */
    /* loaded from: classes.dex */
    public static final class Companion implements MsgPackCreator {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Value toValue(Object obj) {
            Value booleanValue;
            if (obj == null) {
                return NilValue.INSTANCE;
            }
            if (obj instanceof Integer) {
                return MsgPackValuesKt.compressInt(((Number) obj).intValue());
            }
            if (obj instanceof UByte) {
                booleanValue = new UByteValue(((UByte) obj).data, null);
            } else if (obj instanceof String) {
                booleanValue = new StringValue((String) obj);
            } else if (obj instanceof UByteArray) {
                byte[] bArr = ((UByteArray) obj).storage;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                booleanValue = new ByteArrayValue(copyOf);
            } else if (obj instanceof byte[]) {
                booleanValue = new ByteArrayValue((byte[]) obj);
            } else if (obj instanceof Boolean) {
                booleanValue = new BooleanValue(((Boolean) obj).booleanValue());
            } else {
                if (obj instanceof Value) {
                    return (Value) obj;
                }
                if (obj instanceof MsgPack) {
                    return ((MsgPackKotlin) obj).value;
                }
                if (obj instanceof Object[]) {
                    MsgPack newArray = newArray((Object[]) obj);
                    Intrinsics.checkNotNull(newArray, "null cannot be cast to non-null type com.animaconnected.msgpack.MsgPackKotlin");
                    return ((MsgPackKotlin) newArray).value;
                }
                if (obj instanceof List) {
                    MsgPack newArray2 = newArray((List<? extends Object>) obj);
                    Intrinsics.checkNotNull(newArray2, "null cannot be cast to non-null type com.animaconnected.msgpack.MsgPackKotlin");
                    return ((MsgPackKotlin) newArray2).value;
                }
                throw new IllegalArgumentException("Can't pack item " + obj + " of type " + Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName());
            }
            return booleanValue;
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack fromBytes(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return toMsgPack(MsgPackValuesKt.unpack(bytes));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newArray(List<? extends Object> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            List<? extends Object> list = value;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MsgPackKotlin.Companion.toValue(it.next()));
            }
            return toMsgPack(new ArrayValue(arrayList));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newBoolean(boolean z) {
            return toMsgPack(new BooleanValue(z));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newEmpty() {
            return toMsgPack(NilValue.INSTANCE);
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newInt(int r2) {
            return toMsgPack(new IntegerValue(r2));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newIntMap(Map<Integer, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Integer, ? extends Object> entry : map.entrySet()) {
                Companion companion = MsgPackKotlin.Companion;
                arrayList.add(new Pair(companion.toValue(entry.getKey()), companion.toValue(entry.getValue())));
            }
            return toMsgPack(new MapValue(MapsKt__MapsKt.toMap(arrayList)));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return toMsgPack(new StringValue(string));
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newStringMap(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Companion companion = MsgPackKotlin.Companion;
                arrayList.add(new Pair(companion.toValue(entry.getKey()), companion.toValue(entry.getValue())));
            }
            return toMsgPack(new MapValue(MapsKt__MapsKt.toMap(arrayList)));
        }

        public final MsgPack toMsgPack(Value value) {
            Intrinsics.checkNotNullParameter(value, "<this>");
            return new MsgPackKotlin(value);
        }

        private Companion() {
        }

        @Override // com.animaconnected.msgpack.MsgPackCreator
        public MsgPack newArray(Object[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = new ArrayList(value.length);
            for (Object obj : value) {
                arrayList.add(MsgPackKotlin.Companion.toValue(obj));
            }
            return toMsgPack(new ArrayValue(arrayList));
        }
    }

    public MsgPackKotlin(Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.isNilValue = value instanceof NilValue;
        this.isMapValue = value instanceof MapValue;
        this.isIntegerValue = value instanceof IntegerValue;
        this.isArrayValue = value instanceof ArrayValue;
        this.isBinaryValue = value instanceof ByteArrayValue;
        this.isStringValue = value instanceof StringValue;
    }

    public final String toReadableString(Value value) {
        if (value instanceof NilValue) {
            return "nil";
        }
        if (value instanceof BooleanValue) {
            return String.valueOf(((BooleanValue) value).getBoolean());
        }
        if (value instanceof StringValue) {
            return ((StringValue) value).getString();
        }
        if (value instanceof IntegerValue) {
            return String.valueOf(((IntegerValue) value).getInteger());
        }
        if (value instanceof LongValue) {
            return String.valueOf(((LongValue) value).getLong());
        }
        if (value instanceof DoubleValue) {
            return String.valueOf(((DoubleValue) value).getDouble());
        }
        if (value instanceof FloatValue) {
            return String.valueOf(((FloatValue) value).getFloat());
        }
        if (value instanceof ArrayValue) {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("["), CollectionsKt___CollectionsKt.joinToString$default(((ArrayValue) value).getList(), ",", null, null, new Function1<Value, CharSequence>() { // from class: com.animaconnected.msgpack.MsgPackKotlin$toReadableString$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(Value it) {
                    String readableString;
                    Intrinsics.checkNotNullParameter(it, "it");
                    readableString = MsgPackKotlin.this.toReadableString(it);
                    return readableString;
                }
            }, 30), ']');
        }
        if (value instanceof MapValue) {
            StringBuilder sb = new StringBuilder("{");
            Map<Value, Value> map = ((MapValue) value).getMap();
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Value, Value> entry : map.entrySet()) {
                arrayList.add(toReadableString(entry.getKey()) + ':' + toReadableString(entry.getValue()));
            }
            sb.append(arrayList);
            sb.append('}');
            return sb.toString();
        }
        if (value instanceof ByteArrayValue) {
            return ByteUtils.toHex(((ByteArrayValue) value).getByteArray());
        }
        if (value instanceof ByteValue) {
            return String.valueOf((int) ((ByteValue) value).getByte());
        }
        if (value instanceof ShortValue) {
            return String.valueOf((int) ((ShortValue) value).getShort());
        }
        if (value instanceof UByteValue) {
            return UByte.m1663toStringimpl(((UByteValue) value).m757getUbytew2LRezQ());
        }
        if (value instanceof UShortValue) {
            return UShort.m1665toStringimpl(((UShortValue) value).m769getUshortMh2AYeg());
        }
        if (value instanceof UIntegerValue) {
            return UInt.m1664toStringimpl(((UIntegerValue) value).m761getUintegerpVg5ArA());
        }
        if (value instanceof ULongValue) {
            return UnsignedKt.ulongToString(10, ((ULongValue) value).m765getUlongsVKNKU());
        }
        if (value instanceof FixIntValue) {
            return String.valueOf((int) ((FixIntValue) value).getByte());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean asBoolean() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.BooleanValue");
        return ((BooleanValue) value).getBoolean();
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public byte asByte() {
        return MsgPackValuesKt.asByte(this.value);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public byte[] asByteArray() {
        return mo752asUByteArrayTcUX1vc();
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public int asInt() {
        return MsgPackValuesKt.asInt(this.value);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public List<MsgPack> asList() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.ArrayValue");
        List<Value> list = ((ArrayValue) value).getList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Companion.toMsgPack((Value) it.next()));
        }
        return arrayList;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public long asLong() {
        return MsgPackValuesKt.asLong(this.value);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public String asReadableString() {
        return toReadableString(this.value);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public String asString() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.StringValue");
        return ((StringValue) value).getString();
    }

    @Override // com.animaconnected.msgpack.MsgPack
    /* renamed from: asUByteArray-TcUX1vc */
    public byte[] mo752asUByteArrayTcUX1vc() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.ByteArrayValue");
        byte[] byteArray = ((ByteArrayValue) value).getByteArray();
        byte[] copyOf = Arrays.copyOf(byteArray, byteArray.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public Map<Integer, MsgPack> getMap() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.MapValue");
        Map<Value, Value> map = ((MapValue) value).getMap();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Value, Value> entry : map.entrySet()) {
            arrayList.add(new Pair(Integer.valueOf(MsgPackValuesKt.asInt(entry.getKey())), Companion.toMsgPack(entry.getValue())));
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public Map<String, MsgPack> getStringMap() {
        Value value = this.value;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.animaconnected.msgpack.MapValue");
        Map<Value, Value> map = ((MapValue) value).getMap();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Value, Value> entry : map.entrySet()) {
            Value key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type com.animaconnected.msgpack.StringValue");
            arrayList.add(new Pair(((StringValue) key).getString(), Companion.toMsgPack(entry.getValue())));
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isArrayValue() {
        return this.isArrayValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isBinaryValue() {
        return this.isBinaryValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isIntegerValue() {
        return this.isIntegerValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isMapValue() {
        return this.isMapValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isNilValue() {
        return this.isNilValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public boolean isStringValue() {
        return this.isStringValue;
    }

    @Override // com.animaconnected.msgpack.MsgPack
    public byte[] toMsgPackBytes() {
        return MsgPackValuesKt.pack(this.value);
    }

    public String toString() {
        return toReadableString(this.value);
    }
}
