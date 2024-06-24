package com.animaconnected.msgpack;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.PascalDisplay;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MsgPackEncoder.kt */
/* loaded from: classes.dex */
public final class MsgPackEncoderKt {
    public static final void encode(Value value, Output stream) {
        byte[] plus;
        byte[] plus2;
        byte[] plus3;
        byte[] encodeToByteArray;
        byte[] plus4;
        int r9;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(stream, "stream");
        if (value instanceof NilValue) {
            OutputKt.writeFully(stream, r9, 0, MsgpackByteUtilsKt.bytes(192).length - 0);
            return;
        }
        if (value instanceof BooleanValue) {
            Object[] objArr = new Object[1];
            if (((BooleanValue) value).getBoolean()) {
                r9 = 195;
            } else {
                r9 = 194;
            }
            objArr[0] = Integer.valueOf(r9);
            OutputKt.writeFully(stream, r9, 0, MsgpackByteUtilsKt.bytes(objArr).length - 0);
            return;
        }
        if (value instanceof FixIntValue) {
            stream.writeByte(((FixIntValue) value).getByte());
            return;
        }
        if (value instanceof UByteValue) {
            OutputKt.writeFully(stream, r9, 0, MsgpackByteUtilsKt.bytes(204, Byte.valueOf(((UByteValue) value).m757getUbytew2LRezQ())).length - 0);
            return;
        }
        if (value instanceof UShortValue) {
            byte[] plus5 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(205), ByteUtils.m730encodeUInt16xj2QHRw(((UShortValue) value).m769getUshortMh2AYeg()));
            OutputKt.writeFully(stream, plus5, 0, plus5.length - 0);
            return;
        }
        if (value instanceof UIntegerValue) {
            byte[] plus6 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(206), ByteUtils.m735encodeUInt32WZ4Q5Ns(((UIntegerValue) value).m761getUintegerpVg5ArA()));
            OutputKt.writeFully(stream, plus6, 0, plus6.length - 0);
            return;
        }
        if (value instanceof ULongValue) {
            byte[] plus7 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(207), ByteUtils.m739encodeUInt64VKZWuLQ(((ULongValue) value).m765getUlongsVKNKU()));
            OutputKt.writeFully(stream, plus7, 0, plus7.length - 0);
            return;
        }
        if (value instanceof ByteValue) {
            OutputKt.writeFully(stream, r9, 0, MsgpackByteUtilsKt.bytes(208, Byte.valueOf(((ByteValue) value).getByte())).length - 0);
            return;
        }
        if (value instanceof ShortValue) {
            byte[] plus8 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(209), ByteUtils.encodeInt16(((ShortValue) value).getShort()));
            OutputKt.writeFully(stream, plus8, 0, plus8.length - 0);
            return;
        }
        if (value instanceof IntegerValue) {
            byte[] plus9 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(210), ByteUtils.encodeInt32(((IntegerValue) value).getInteger()));
            OutputKt.writeFully(stream, plus9, 0, plus9.length - 0);
            return;
        }
        if (value instanceof LongValue) {
            byte[] plus10 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(211), ByteUtils.encodeInt64(((LongValue) value).getLong()));
            OutputKt.writeFully(stream, plus10, 0, plus10.length - 0);
            return;
        }
        if (value instanceof FloatValue) {
            byte[] plus11 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(202), ByteUtils.encodeInt32(Float.floatToIntBits(((FloatValue) value).getFloat())));
            OutputKt.writeFully(stream, plus11, 0, plus11.length - 0);
            return;
        }
        if (value instanceof DoubleValue) {
            byte[] plus12 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(203), ByteUtils.encodeInt64(Double.doubleToLongBits(((DoubleValue) value).getDouble())));
            OutputKt.writeFully(stream, plus12, 0, plus12.length - 0);
            return;
        }
        if (value instanceof StringValue) {
            String string = ((StringValue) value).getString();
            Charset charset = Charsets.UTF_8;
            if (Intrinsics.areEqual(charset, charset)) {
                encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(string);
            } else {
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, string, string.length());
            }
            if (encodeToByteArray.length < 32) {
                plus4 = new byte[]{(byte) (encodeToByteArray.length + R.styleable.AppTheme_subComplicationDropZoneNotSelected)};
            } else if (encodeToByteArray.length < 256) {
                byte[] bytes = MsgpackByteUtilsKt.bytes(217);
                byte length = (byte) encodeToByteArray.length;
                Intrinsics.checkNotNullParameter(bytes, "<this>");
                int length2 = bytes.length;
                plus4 = Arrays.copyOf(bytes, length2 + 1);
                plus4[length2] = length;
            } else if (encodeToByteArray.length < 65536) {
                plus4 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(218), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(2, ByteUtils.encodeInt16((short) encodeToByteArray.length))));
            } else {
                plus4 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(219), ByteUtils.encodeInt32(encodeToByteArray.length));
            }
            OutputKt.writeFully(stream, plus4, 0, plus4.length - 0);
            OutputKt.writeFully(stream, encodeToByteArray, 0, encodeToByteArray.length - 0);
            return;
        }
        if (value instanceof ByteArrayValue) {
            ByteArrayValue byteArrayValue = (ByteArrayValue) value;
            if (byteArrayValue.getByteArray().length < 256) {
                byte[] bytes2 = MsgpackByteUtilsKt.bytes(196);
                byte length3 = (byte) byteArrayValue.getByteArray().length;
                Intrinsics.checkNotNullParameter(bytes2, "<this>");
                int length4 = bytes2.length;
                plus3 = Arrays.copyOf(bytes2, length4 + 1);
                plus3[length4] = length3;
            } else if (byteArrayValue.getByteArray().length < 65536) {
                plus3 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(197), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(2, ByteUtils.encodeInt16((short) byteArrayValue.getByteArray().length))));
            } else {
                plus3 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(198), ByteUtils.encodeInt32(byteArrayValue.getByteArray().length));
            }
            OutputKt.writeFully(stream, plus3, 0, plus3.length - 0);
            OutputKt.writeFully(stream, r9, 0, byteArrayValue.getByteArray().length - 0);
            return;
        }
        if (value instanceof ArrayValue) {
            ArrayValue arrayValue = (ArrayValue) value;
            int size = arrayValue.getList().size();
            if (size < 16) {
                plus2 = MsgpackByteUtilsKt.bytes(Integer.valueOf(size + R.styleable.AppTheme_stepsHistoryGoalLineColorDetail));
            } else if (size < 256) {
                plus2 = MsgpackByteUtilsKt.bytes(Integer.valueOf(PascalDisplay.marginTop), 0, Integer.valueOf(size));
            } else if (size < 65536) {
                plus2 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(Integer.valueOf(PascalDisplay.marginTop)), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(2, ByteUtils.encodeInt16((short) size))));
            } else if (size < 16777216) {
                plus2 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(221, 0), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(3, ByteUtils.encodeInt32(size))));
            } else {
                plus2 = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(221), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(4, ByteUtils.encodeInt32(size))));
            }
            OutputKt.writeFully(stream, plus2, 0, plus2.length - 0);
            Iterator<T> it = arrayValue.getList().iterator();
            while (it.hasNext()) {
                encode((Value) it.next(), stream);
            }
            return;
        }
        if (value instanceof MapValue) {
            MapValue mapValue = (MapValue) value;
            int size2 = mapValue.getMap().size();
            if (size2 < 16) {
                plus = MsgpackByteUtilsKt.bytes(Integer.valueOf(size2 + 128));
            } else if (size2 < 256) {
                plus = MsgpackByteUtilsKt.bytes(222, 0, Integer.valueOf(size2));
            } else if (size2 < 65536) {
                plus = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(222), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(2, ByteUtils.encodeInt16((short) size2))));
            } else if (size2 < 16777216) {
                plus = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(223, 0), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(3, ByteUtils.encodeInt32(size2))));
            } else {
                plus = ArraysKt___ArraysJvmKt.plus(MsgpackByteUtilsKt.bytes(223), CollectionsKt___CollectionsKt.toByteArray(ArraysKt___ArraysKt.take(4, ByteUtils.encodeInt32(size2))));
            }
            OutputKt.writeFully(stream, plus, 0, plus.length - 0);
            for (Map.Entry<Value, Value> entry : mapValue.getMap().entrySet()) {
                encode(entry.getKey(), stream);
                encode(entry.getValue(), stream);
            }
        }
    }
}
