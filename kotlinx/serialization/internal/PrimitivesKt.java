package kotlinx.serialization.internal;

import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;

/* compiled from: Primitives.kt */
/* loaded from: classes4.dex */
public final class PrimitivesKt {
    public static final Map<KClass<? extends Object>, KSerializer<? extends Object>> BUILTIN_SERIALIZERS;

    static {
        Pair pair = new Pair(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
        Pair pair2 = new Pair(Reflection.getOrCreateKotlinClass(Character.TYPE), CharSerializer.INSTANCE);
        Pair pair3 = new Pair(Reflection.getOrCreateKotlinClass(char[].class), CharArraySerializer.INSTANCE);
        Pair pair4 = new Pair(Reflection.getOrCreateKotlinClass(Double.TYPE), DoubleSerializer.INSTANCE);
        Pair pair5 = new Pair(Reflection.getOrCreateKotlinClass(double[].class), DoubleArraySerializer.INSTANCE);
        Pair pair6 = new Pair(Reflection.getOrCreateKotlinClass(Float.TYPE), FloatSerializer.INSTANCE);
        Pair pair7 = new Pair(Reflection.getOrCreateKotlinClass(float[].class), FloatArraySerializer.INSTANCE);
        Pair pair8 = new Pair(Reflection.getOrCreateKotlinClass(Long.TYPE), LongSerializer.INSTANCE);
        Pair pair9 = new Pair(Reflection.getOrCreateKotlinClass(long[].class), LongArraySerializer.INSTANCE);
        Pair pair10 = new Pair(Reflection.getOrCreateKotlinClass(ULong.class), ULongSerializer.INSTANCE);
        Pair pair11 = new Pair(Reflection.getOrCreateKotlinClass(ULongArray.class), ULongArraySerializer.INSTANCE);
        Pair pair12 = new Pair(Reflection.getOrCreateKotlinClass(Integer.TYPE), IntSerializer.INSTANCE);
        Pair pair13 = new Pair(Reflection.getOrCreateKotlinClass(int[].class), IntArraySerializer.INSTANCE);
        Pair pair14 = new Pair(Reflection.getOrCreateKotlinClass(UInt.class), UIntSerializer.INSTANCE);
        Pair pair15 = new Pair(Reflection.getOrCreateKotlinClass(UIntArray.class), UIntArraySerializer.INSTANCE);
        Pair pair16 = new Pair(Reflection.getOrCreateKotlinClass(Short.TYPE), ShortSerializer.INSTANCE);
        Pair pair17 = new Pair(Reflection.getOrCreateKotlinClass(short[].class), ShortArraySerializer.INSTANCE);
        Pair pair18 = new Pair(Reflection.getOrCreateKotlinClass(UShort.class), UShortSerializer.INSTANCE);
        Pair pair19 = new Pair(Reflection.getOrCreateKotlinClass(UShortArray.class), UShortArraySerializer.INSTANCE);
        Pair pair20 = new Pair(Reflection.getOrCreateKotlinClass(Byte.TYPE), ByteSerializer.INSTANCE);
        Pair pair21 = new Pair(Reflection.getOrCreateKotlinClass(byte[].class), ByteArraySerializer.INSTANCE);
        Pair pair22 = new Pair(Reflection.getOrCreateKotlinClass(UByte.class), UByteSerializer.INSTANCE);
        Pair pair23 = new Pair(Reflection.getOrCreateKotlinClass(UByteArray.class), UByteArraySerializer.INSTANCE);
        Pair pair24 = new Pair(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BooleanSerializer.INSTANCE);
        Pair pair25 = new Pair(Reflection.getOrCreateKotlinClass(boolean[].class), BooleanArraySerializer.INSTANCE);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        Intrinsics.checkNotNullParameter(Unit.INSTANCE, "<this>");
        Pair pair26 = new Pair(orCreateKotlinClass, UnitSerializer.INSTANCE);
        Pair pair27 = new Pair(Reflection.getOrCreateKotlinClass(Void.class), NothingSerializer.INSTANCE);
        ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
        int r1 = Duration.$r8$clinit;
        BUILTIN_SERIALIZERS = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, pair20, pair21, pair22, pair23, pair24, pair25, pair26, pair27, new Pair(orCreateKotlinClass2, DurationSerializer.INSTANCE));
    }

    public static final String capitalize(String str) {
        boolean z;
        String valueOf;
        if (str.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                String valueOf2 = String.valueOf(charAt);
                Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type java.lang.String");
                Locale locale = Locale.ROOT;
                valueOf = valueOf2.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(valueOf, "toUpperCase(...)");
                if (valueOf.length() > 1) {
                    if (charAt != 329) {
                        char charAt2 = valueOf.charAt(0);
                        String substring = valueOf.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        String lowerCase = substring.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        valueOf = charAt2 + lowerCase;
                    }
                } else {
                    valueOf = String.valueOf(Character.toTitleCase(charAt));
                }
            } else {
                valueOf = String.valueOf(charAt);
            }
            sb.append((Object) valueOf);
            String substring2 = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        return str;
    }
}
