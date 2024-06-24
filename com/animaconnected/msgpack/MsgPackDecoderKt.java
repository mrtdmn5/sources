package com.animaconnected.msgpack;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.secondo.R;
import io.ktor.utils.io.core.BufferKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MsgPackDecoder.kt */
/* loaded from: classes.dex */
public final class MsgPackDecoderKt {
    public static final Value decoder(Input stream) {
        byte b;
        byte b2;
        Value mapValue;
        Value stringValue;
        Intrinsics.checkNotNullParameter(stream, "stream");
        int r0 = stream.headPosition;
        int r1 = r0 + 1;
        int r2 = stream.headEndExclusive;
        if (r1 < r2) {
            stream.headPosition = r1;
            b2 = stream.headMemory.get(r0);
        } else {
            if (r0 < r2) {
                b = stream.headMemory.get(r0);
                stream.headPosition = r0;
                ChunkBuffer chunkBuffer = stream._head;
                if (r0 >= 0 && r0 <= chunkBuffer.writePosition) {
                    if (chunkBuffer.readPosition != r0) {
                        chunkBuffer.readPosition = r0;
                    }
                    stream.ensureNext(chunkBuffer);
                } else {
                    int r8 = chunkBuffer.readPosition;
                    BufferKt.discardFailed(r0 - r8, chunkBuffer.writePosition - r8);
                    throw null;
                }
            } else {
                ChunkBuffer prepareRead = stream.prepareRead();
                if (prepareRead != null) {
                    int r12 = prepareRead.readPosition;
                    if (r12 != prepareRead.writePosition) {
                        prepareRead.readPosition = r12 + 1;
                        b = prepareRead.memory.get(r12);
                        UnsafeKt.completeReadHead(stream, prepareRead);
                    } else {
                        throw new EOFException("No readable bytes available.");
                    }
                } else {
                    StringsKt.prematureEndOfStream(1);
                    throw null;
                }
            }
            b2 = b;
        }
        int r13 = 0;
        if (b2 == 0) {
            return new FixIntValue((byte) 0);
        }
        if (b2 == -64) {
            return NilValue.INSTANCE;
        }
        if (b2 == -62) {
            return new BooleanValue(false);
        }
        if (b2 == -61) {
            return new BooleanValue(true);
        }
        if (b2 == -52) {
            mapValue = new UByteValue(ByteUtils.decodeUInt8$default(MsgpackByteUtilsKt.readExactNBytes(stream, 1), 0, 1, null), null);
        } else if (b2 == -51) {
            mapValue = new UShortValue(ByteUtils.decodeUInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null), null);
        } else if (b2 == -50) {
            mapValue = new UIntegerValue(ByteUtils.decodeUInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null), null);
        } else if (b2 == -49) {
            mapValue = new ULongValue(ByteUtils.decodeUInt64$default(MsgpackByteUtilsKt.readExactNBytes(stream, 8), 0, 1, null), null);
        } else if (b2 == -48) {
            mapValue = new ByteValue(MsgpackByteUtilsKt.readExactNBytes(stream, 1)[0]);
        } else if (b2 == -47) {
            mapValue = new ShortValue(ByteUtils.decodeInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null));
        } else if (b2 == -46) {
            mapValue = new IntegerValue(ByteUtils.decodeInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null));
        } else if (b2 == -45) {
            mapValue = new LongValue(ByteUtils.decodeInt64$default(MsgpackByteUtilsKt.readExactNBytes(stream, 8), 0, 1, null));
        } else if (b2 == -54) {
            mapValue = new FloatValue(Float.intBitsToFloat(ByteUtils.decodeInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null)));
        } else if (b2 == -53) {
            mapValue = new DoubleValue(Double.longBitsToDouble(ByteUtils.decodeInt64$default(MsgpackByteUtilsKt.readExactNBytes(stream, 8), 0, 1, null)));
        } else {
            if (b2 == -39) {
                stringValue = new StringValue(StringsKt__StringsJVMKt.decodeToString(MsgpackByteUtilsKt.readExactNBytes(stream, MsgpackByteUtilsKt.readExactNBytes(stream, 1)[0] & 255)));
            } else if (b2 == -38) {
                stringValue = new StringValue(StringsKt__StringsJVMKt.decodeToString(MsgpackByteUtilsKt.readExactNBytes(stream, ByteUtils.decodeUInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null) & 65535)));
            } else if (b2 == -37) {
                stringValue = new StringValue(StringsKt__StringsJVMKt.decodeToString(MsgpackByteUtilsKt.readExactNBytes(stream, ByteUtils.decodeUInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null))));
            } else if (b2 == -60) {
                stringValue = new ByteArrayValue(MsgpackByteUtilsKt.readExactNBytes(stream, MsgpackByteUtilsKt.readExactNBytes(stream, 1)[0] & 255));
            } else if (b2 == -59) {
                stringValue = new ByteArrayValue(MsgpackByteUtilsKt.readExactNBytes(stream, ByteUtils.decodeUInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null) & 65535));
            } else if (b2 == -58) {
                stringValue = new ByteArrayValue(MsgpackByteUtilsKt.readExactNBytes(stream, ByteUtils.decodeUInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null)));
            } else if (b2 == -36) {
                int decodeUInt16$default = ByteUtils.decodeUInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null) & 65535;
                Value[] valueArr = new Value[decodeUInt16$default];
                while (r13 < decodeUInt16$default) {
                    valueArr[r13] = decoder(stream);
                    r13++;
                }
                mapValue = new ArrayValue(ArraysKt___ArraysKt.toList(valueArr));
            } else if (b2 == -35) {
                int decodeUInt32$default = ByteUtils.decodeUInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null);
                Value[] valueArr2 = new Value[decodeUInt32$default];
                while (r13 < decodeUInt32$default) {
                    valueArr2[r13] = decoder(stream);
                    r13++;
                }
                mapValue = new ArrayValue(ArraysKt___ArraysKt.toList(valueArr2));
            } else if (b2 == -34) {
                int decodeUInt16$default2 = (ByteUtils.decodeUInt16$default(MsgpackByteUtilsKt.readExactNBytes(stream, 2), 0, 1, null) & 65535) * 2;
                Value[] valueArr3 = new Value[decodeUInt16$default2];
                while (r13 < decodeUInt16$default2) {
                    valueArr3[r13] = decoder(stream);
                    r13++;
                }
                mapValue = new MapValue(MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.chunked(ArraysKt___ArraysKt.toList(valueArr3), 2, new Function1<List<? extends Value>, Pair<? extends Value, ? extends Value>>() { // from class: com.animaconnected.msgpack.MsgPackDecoderKt$decoder$4
                    @Override // kotlin.jvm.functions.Function1
                    public final Pair<Value, Value> invoke(List<? extends Value> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new Pair<>(it.get(0), it.get(1));
                    }
                })));
            } else if (b2 == -33) {
                int decodeUInt32$default2 = ByteUtils.decodeUInt32$default(MsgpackByteUtilsKt.readExactNBytes(stream, 4), 0, 1, null) * 2;
                Value[] valueArr4 = new Value[decodeUInt32$default2];
                while (r13 < decodeUInt32$default2) {
                    valueArr4[r13] = decoder(stream);
                    r13++;
                }
                mapValue = new MapValue(MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.chunked(ArraysKt___ArraysKt.toList(valueArr4), 2, new Function1<List<? extends Value>, Pair<? extends Value, ? extends Value>>() { // from class: com.animaconnected.msgpack.MsgPackDecoderKt$decoder$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Pair<Value, Value> invoke(List<? extends Value> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new Pair<>(it.get(0), it.get(1));
                    }
                })));
            } else {
                if (((byte) (b2 | Byte.MAX_VALUE)) == Byte.MAX_VALUE) {
                    return new FixIntValue(b2);
                }
                if (((byte) (b2 & (-32))) == -32) {
                    return new FixIntValue(b2);
                }
                if (((byte) (b2 & (-96))) == -96) {
                    stringValue = new StringValue(StringsKt__StringsJVMKt.decodeToString(MsgpackByteUtilsKt.readExactNBytes(stream, (b2 & 255) - (((byte) R.styleable.AppTheme_subComplicationDropZoneNotSelected) & 255))));
                } else if (((byte) (b2 & (-112))) == -112) {
                    int r02 = (b2 & 255) - (((byte) R.styleable.AppTheme_stepsHistoryGoalLineColorDetail) & 255);
                    Value[] valueArr5 = new Value[r02];
                    while (r13 < r02) {
                        valueArr5[r13] = decoder(stream);
                        r13++;
                    }
                    mapValue = new ArrayValue(ArraysKt___ArraysKt.toList(valueArr5));
                } else if (((byte) (b2 & Byte.MIN_VALUE)) == Byte.MIN_VALUE) {
                    int r03 = ((b2 & 255) - (((byte) 128) & 255)) * 2;
                    Value[] valueArr6 = new Value[r03];
                    while (r13 < r03) {
                        valueArr6[r13] = decoder(stream);
                        r13++;
                    }
                    mapValue = new MapValue(MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.chunked(ArraysKt___ArraysKt.toList(valueArr6), 2, new Function1<List<? extends Value>, Pair<? extends Value, ? extends Value>>() { // from class: com.animaconnected.msgpack.MsgPackDecoderKt$decoder$9
                        @Override // kotlin.jvm.functions.Function1
                        public final Pair<Value, Value> invoke(List<? extends Value> it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new Pair<>(it.get(0), it.get(1));
                        }
                    })));
                } else {
                    CharsKt__CharKt.checkRadix(16);
                    String num = Integer.toString(b2, 16);
                    Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                    throw new IllegalStateException("Unexpected byte ".concat(num));
                }
            }
            return stringValue;
        }
        return mapValue;
    }
}
