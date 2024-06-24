package com.animaconnected.msgpack;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class MsgPackValuesKt {
    public static final byte asByte(Value value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        if (value instanceof FixIntValue) {
            return ((FixIntValue) value).getByte();
        }
        if (value instanceof UByteValue) {
            return ((UByteValue) value).m757getUbytew2LRezQ();
        }
        if (value instanceof ByteValue) {
            return ((ByteValue) value).getByte();
        }
        throw new IllegalArgumentException(value + " can't be casted to Byte");
    }

    public static final float asFloat(Value value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        if (value instanceof FloatValue) {
            return ((FloatValue) value).getFloat();
        }
        if (value instanceof DoubleValue) {
            return (float) ((DoubleValue) value).getDouble();
        }
        throw new IllegalArgumentException(value + " can't be casted to Float");
    }

    public static final int asInt(Value value) {
        long j;
        Intrinsics.checkNotNullParameter(value, "<this>");
        if (value instanceof FixIntValue) {
            return ((FixIntValue) value).getByte();
        }
        if (value instanceof UByteValue) {
            return ((UByteValue) value).m757getUbytew2LRezQ() & 255;
        }
        if (value instanceof UShortValue) {
            return ((UShortValue) value).m769getUshortMh2AYeg() & 65535;
        }
        if (value instanceof UIntegerValue) {
            return ((UIntegerValue) value).m761getUintegerpVg5ArA();
        }
        if (value instanceof ULongValue) {
            j = ((ULongValue) value).m765getUlongsVKNKU();
        } else {
            if (value instanceof ByteValue) {
                return ((ByteValue) value).getByte();
            }
            if (value instanceof ShortValue) {
                return ((ShortValue) value).getShort();
            }
            if (value instanceof IntegerValue) {
                return ((IntegerValue) value).getInteger();
            }
            if (value instanceof LongValue) {
                j = ((LongValue) value).getLong();
            } else {
                if (value instanceof FloatValue) {
                    return (int) ((FloatValue) value).getFloat();
                }
                if (value instanceof DoubleValue) {
                    return (int) ((DoubleValue) value).getDouble();
                }
                throw new IllegalArgumentException(value + " can't be casted to Int");
            }
        }
        return (int) j;
    }

    public static final long asLong(Value value) {
        int integer;
        long m761getUintegerpVg5ArA;
        long j;
        Intrinsics.checkNotNullParameter(value, "<this>");
        if (value instanceof FixIntValue) {
            integer = ((FixIntValue) value).getByte();
        } else {
            if (value instanceof UByteValue) {
                m761getUintegerpVg5ArA = ((UByteValue) value).m757getUbytew2LRezQ();
                j = 255;
            } else if (value instanceof UShortValue) {
                m761getUintegerpVg5ArA = ((UShortValue) value).m769getUshortMh2AYeg();
                j = 65535;
            } else if (value instanceof UIntegerValue) {
                m761getUintegerpVg5ArA = ((UIntegerValue) value).m761getUintegerpVg5ArA();
                j = 4294967295L;
            } else {
                if (value instanceof ULongValue) {
                    return ((ULongValue) value).m765getUlongsVKNKU();
                }
                if (value instanceof ByteValue) {
                    integer = ((ByteValue) value).getByte();
                } else if (value instanceof ShortValue) {
                    integer = ((ShortValue) value).getShort();
                } else if (value instanceof IntegerValue) {
                    integer = ((IntegerValue) value).getInteger();
                } else {
                    if (value instanceof LongValue) {
                        return ((LongValue) value).getLong();
                    }
                    if (value instanceof FloatValue) {
                        return ((FloatValue) value).getFloat();
                    }
                    if (value instanceof DoubleValue) {
                        return (long) ((DoubleValue) value).getDouble();
                    }
                    throw new IllegalArgumentException(value + " can't be casted to Long");
                }
            }
            return m761getUintegerpVg5ArA & j;
        }
        return integer;
    }

    public static final ByteArrayValue byteArrayValueOf(byte... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new ByteArrayValue(elements);
    }

    public static final Value compressInt(int r3) {
        if (r3 > 0) {
            int r0 = Integer.MIN_VALUE ^ r3;
            if (Integer.compare(r0, -2147418113) > 0) {
                return new IntegerValue(r3);
            }
            if (r3 > 32767) {
                return new UShortValue((short) r3, null);
            }
            if (Integer.compare(r0, -2147483393) > 0) {
                return new ShortValue((short) r3);
            }
            if (r3 > 127) {
                return new UByteValue((byte) r3, null);
            }
            return new FixIntValue((byte) r3);
        }
        if (r3 < -32768) {
            return new IntegerValue(r3);
        }
        if (r3 < -128) {
            return new ShortValue((short) r3);
        }
        if (r3 < -32) {
            return new ByteValue((byte) r3);
        }
        return new FixIntValue((byte) r3);
    }

    public static final ByteArrayValue emptyByteArrayValue() {
        return new ByteArrayValue(new byte[0]);
    }

    public static final byte[] pack(Value value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null);
        MsgPackEncoderKt.encode(value, bytePacketBuilder);
        return StringsKt.readBytes$default(bytePacketBuilder.build());
    }

    /* renamed from: ubyteArrayValueOf-GBYM_sE, reason: not valid java name */
    public static final ByteArrayValue m753ubyteArrayValueOfGBYM_sE(byte... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        byte[] copyOf = Arrays.copyOf(elements, elements.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return new ByteArrayValue(copyOf);
    }

    public static final Value unpack(final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return MsgPackDecoderKt.decoder(ByteReadPacketExtensionsKt.ByteReadPacket(wrap, new Function1<ByteBuffer, Unit>() { // from class: com.animaconnected.msgpack.MsgPackValuesKt$unpack$$inlined$ByteReadPacket$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ByteBuffer it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                invoke2(byteBuffer);
                return Unit.INSTANCE;
            }
        }));
    }
}
