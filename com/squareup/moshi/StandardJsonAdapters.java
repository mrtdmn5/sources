package com.squareup.moshi;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import com.amplifyframework.core.model.ModelIdentifier;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class StandardJsonAdapters {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public static final AnonymousClass2 BOOLEAN_JSON_ADAPTER = new AnonymousClass2();
    public static final AnonymousClass3 BYTE_JSON_ADAPTER = new AnonymousClass3();
    public static final AnonymousClass4 CHARACTER_JSON_ADAPTER = new AnonymousClass4();
    public static final AnonymousClass5 DOUBLE_JSON_ADAPTER = new AnonymousClass5();
    public static final AnonymousClass6 FLOAT_JSON_ADAPTER = new AnonymousClass6();
    public static final AnonymousClass7 INTEGER_JSON_ADAPTER = new AnonymousClass7();
    public static final AnonymousClass8 LONG_JSON_ADAPTER = new AnonymousClass8();
    public static final AnonymousClass9 SHORT_JSON_ADAPTER = new AnonymousClass9();
    public static final AnonymousClass10 STRING_JSON_ADAPTER = new AnonymousClass10();

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements JsonAdapter.Factory {
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            JsonAdapter.AnonymousClass2 anonymousClass2;
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return StandardJsonAdapters.BOOLEAN_JSON_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardJsonAdapters.BYTE_JSON_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardJsonAdapters.CHARACTER_JSON_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardJsonAdapters.DOUBLE_JSON_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardJsonAdapters.FLOAT_JSON_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardJsonAdapters.INTEGER_JSON_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardJsonAdapters.LONG_JSON_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardJsonAdapters.SHORT_JSON_ADAPTER;
            }
            if (type == Boolean.class) {
                AnonymousClass2 anonymousClass22 = StandardJsonAdapters.BOOLEAN_JSON_ADAPTER;
                anonymousClass22.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Byte.class) {
                AnonymousClass3 anonymousClass3 = StandardJsonAdapters.BYTE_JSON_ADAPTER;
                anonymousClass3.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Character.class) {
                AnonymousClass4 anonymousClass4 = StandardJsonAdapters.CHARACTER_JSON_ADAPTER;
                anonymousClass4.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Double.class) {
                AnonymousClass5 anonymousClass5 = StandardJsonAdapters.DOUBLE_JSON_ADAPTER;
                anonymousClass5.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Float.class) {
                AnonymousClass6 anonymousClass6 = StandardJsonAdapters.FLOAT_JSON_ADAPTER;
                anonymousClass6.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Integer.class) {
                AnonymousClass7 anonymousClass7 = StandardJsonAdapters.INTEGER_JSON_ADAPTER;
                anonymousClass7.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Long.class) {
                AnonymousClass8 anonymousClass8 = StandardJsonAdapters.LONG_JSON_ADAPTER;
                anonymousClass8.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Short.class) {
                AnonymousClass9 anonymousClass9 = StandardJsonAdapters.SHORT_JSON_ADAPTER;
                anonymousClass9.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == String.class) {
                AnonymousClass10 anonymousClass10 = StandardJsonAdapters.STRING_JSON_ADAPTER;
                anonymousClass10.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            if (type == Object.class) {
                return new JsonAdapter.AnonymousClass2();
            }
            Class<?> rawType = Types.getRawType(type);
            Set<Annotation> set2 = Util.NO_ANNOTATIONS;
            JsonClass jsonClass = (JsonClass) rawType.getAnnotation(JsonClass.class);
            if (jsonClass != null && jsonClass.generateAdapter()) {
                try {
                    Class<?> cls = Class.forName(rawType.getName().replace("$", "_") + "JsonAdapter", true, rawType.getClassLoader());
                    if (type instanceof ParameterizedType) {
                        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Moshi.class, Type[].class);
                        declaredConstructor.setAccessible(true);
                        anonymousClass2 = ((JsonAdapter) declaredConstructor.newInstance(moshi, ((ParameterizedType) type).getActualTypeArguments())).nullSafe();
                    } else {
                        Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Moshi.class);
                        declaredConstructor2.setAccessible(true);
                        anonymousClass2 = ((JsonAdapter) declaredConstructor2.newInstance(moshi)).nullSafe();
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Failed to find the generated JsonAdapter class for ", rawType), e);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Failed to access the generated JsonAdapter for ", rawType), e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Failed to instantiate the generated JsonAdapter for ", rawType), e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Failed to find the generated JsonAdapter constructor for ", rawType), e4);
                } catch (InvocationTargetException e5) {
                    Util.rethrowCause(e5);
                    throw null;
                }
            } else {
                anonymousClass2 = null;
            }
            if (anonymousClass2 != null) {
                return anonymousClass2;
            }
            if (!rawType.isEnum()) {
                return null;
            }
            return new JsonAdapter.AnonymousClass2();
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$10 */
    /* loaded from: classes3.dex */
    public class AnonymousClass10 extends JsonAdapter<String> {
        @Override // com.squareup.moshi.JsonAdapter
        public final String fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.nextString();
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }

        public final String toString() {
            return "JsonAdapter(String)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$11 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        static {
            int[] r0 = new int[JsonReader.Token.values().length];
            $SwitchMap$com$squareup$moshi$JsonReader$Token = r0;
            try {
                r0[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[JsonReader.Token.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$2 */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 extends JsonAdapter<Boolean> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Boolean fromJson(JsonReader jsonReader) throws IOException {
            JsonUtf8Reader jsonUtf8Reader = (JsonUtf8Reader) jsonReader;
            int r0 = jsonUtf8Reader.peeked;
            if (r0 == 0) {
                r0 = jsonUtf8Reader.doPeek();
            }
            boolean z = false;
            if (r0 == 5) {
                jsonUtf8Reader.peeked = 0;
                int[] r02 = jsonUtf8Reader.pathIndices;
                int r5 = jsonUtf8Reader.stackSize - 1;
                r02[r5] = r02[r5] + 1;
                z = true;
            } else if (r0 == 6) {
                jsonUtf8Reader.peeked = 0;
                int[] r03 = jsonUtf8Reader.pathIndices;
                int r52 = jsonUtf8Reader.stackSize - 1;
                r03[r52] = r03[r52] + 1;
            } else {
                throw new JsonDataException("Expected a boolean but was " + jsonUtf8Reader.peek() + " at path " + jsonUtf8Reader.getPath());
            }
            return Boolean.valueOf(z);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool.booleanValue());
        }

        public final String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$3 */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 extends JsonAdapter<Byte> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Byte fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a byte", -128, 255));
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Byte b) throws IOException {
            jsonWriter.value(b.intValue() & 255);
        }

        public final String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$4 */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 extends JsonAdapter<Character> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Character fromJson(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            if (nextString.length() <= 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", "a char", EndpointMode$Companion$$ExternalSyntheticOutline0.m(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, nextString, '\"'), jsonReader.getPath()));
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch.toString());
        }

        public final String toString() {
            return "JsonAdapter(Character)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$5 */
    /* loaded from: classes3.dex */
    public class AnonymousClass5 extends JsonAdapter<Double> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Double fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Double d) throws IOException {
            jsonWriter.value(d.doubleValue());
        }

        public final String toString() {
            return "JsonAdapter(Double)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$6 */
    /* loaded from: classes3.dex */
    public class AnonymousClass6 extends JsonAdapter<Float> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Float fromJson(JsonReader jsonReader) throws IOException {
            float nextDouble = (float) jsonReader.nextDouble();
            if (!jsonReader.lenient && Float.isInfinite(nextDouble)) {
                throw new JsonDataException("JSON forbids NaN and infinities: " + nextDouble + " at path " + jsonReader.getPath());
            }
            return Float.valueOf(nextDouble);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Float f) throws IOException {
            Float f2 = f;
            f2.getClass();
            jsonWriter.value(f2);
        }

        public final String toString() {
            return "JsonAdapter(Float)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$7 */
    /* loaded from: classes3.dex */
    public class AnonymousClass7 extends JsonAdapter<Integer> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Integer fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.nextInt());
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Integer num) throws IOException {
            jsonWriter.value(num.intValue());
        }

        public final String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$8 */
    /* loaded from: classes3.dex */
    public class AnonymousClass8 extends JsonAdapter<Long> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Long fromJson(JsonReader jsonReader) throws IOException {
            String nextQuotedValue;
            long parseLong;
            JsonUtf8Reader jsonUtf8Reader = (JsonUtf8Reader) jsonReader;
            int r0 = jsonUtf8Reader.peeked;
            if (r0 == 0) {
                r0 = jsonUtf8Reader.doPeek();
            }
            if (r0 == 16) {
                jsonUtf8Reader.peeked = 0;
                int[] r02 = jsonUtf8Reader.pathIndices;
                int r1 = jsonUtf8Reader.stackSize - 1;
                r02[r1] = r02[r1] + 1;
                parseLong = jsonUtf8Reader.peekedLong;
            } else {
                if (r0 == 17) {
                    jsonUtf8Reader.peekedString = jsonUtf8Reader.buffer.readUtf8(jsonUtf8Reader.peekedNumberLength);
                } else if (r0 != 9 && r0 != 8) {
                    if (r0 != 11) {
                        throw new JsonDataException("Expected a long but was " + jsonUtf8Reader.peek() + " at path " + jsonUtf8Reader.getPath());
                    }
                } else {
                    if (r0 == 9) {
                        nextQuotedValue = jsonUtf8Reader.nextQuotedValue(JsonUtf8Reader.DOUBLE_QUOTE_OR_SLASH);
                    } else {
                        nextQuotedValue = jsonUtf8Reader.nextQuotedValue(JsonUtf8Reader.SINGLE_QUOTE_OR_SLASH);
                    }
                    jsonUtf8Reader.peekedString = nextQuotedValue;
                    try {
                        parseLong = Long.parseLong(nextQuotedValue);
                        jsonUtf8Reader.peeked = 0;
                        int[] r6 = jsonUtf8Reader.pathIndices;
                        int r7 = jsonUtf8Reader.stackSize - 1;
                        r6[r7] = r6[r7] + 1;
                    } catch (NumberFormatException unused) {
                    }
                }
                jsonUtf8Reader.peeked = 11;
                try {
                    parseLong = new BigDecimal(jsonUtf8Reader.peekedString).longValueExact();
                    jsonUtf8Reader.peekedString = null;
                    jsonUtf8Reader.peeked = 0;
                    int[] r2 = jsonUtf8Reader.pathIndices;
                    int r10 = jsonUtf8Reader.stackSize - 1;
                    r2[r10] = r2[r10] + 1;
                } catch (ArithmeticException | NumberFormatException unused2) {
                    throw new JsonDataException("Expected a long but was " + jsonUtf8Reader.peekedString + " at path " + jsonUtf8Reader.getPath());
                }
            }
            return Long.valueOf(parseLong);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Long l) throws IOException {
            jsonWriter.value(l.longValue());
        }

        public final String toString() {
            return "JsonAdapter(Long)";
        }
    }

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$9 */
    /* loaded from: classes3.dex */
    public class AnonymousClass9 extends JsonAdapter<Short> {
        @Override // com.squareup.moshi.JsonAdapter
        public final Short fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) StandardJsonAdapters.rangeCheckNextInt(jsonReader, "a short", -32768, 32767));
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Short sh) throws IOException {
            jsonWriter.value(sh.intValue());
        }

        public final String toString() {
            return "JsonAdapter(Short)";
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
        public final T[] constants;
        public final Class<T> enumType;
        public final String[] nameStrings;
        public final JsonReader.Options options;

        public EnumJsonAdapter(Class<T> cls) {
            String name;
            this.enumType = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.constants = enumConstants;
                this.nameStrings = new String[enumConstants.length];
                int r0 = 0;
                while (true) {
                    T[] tArr = this.constants;
                    if (r0 < tArr.length) {
                        T t = tArr[r0];
                        Json json = (Json) cls.getField(t.name()).getAnnotation(Json.class);
                        if (json != null) {
                            name = json.name();
                        } else {
                            name = t.name();
                        }
                        this.nameStrings[r0] = name;
                        r0++;
                    } else {
                        this.options = JsonReader.Options.of(this.nameStrings);
                        return;
                    }
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError("Missing field in ".concat(cls.getName()), e);
            }
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            int r0;
            JsonUtf8Reader jsonUtf8Reader = (JsonUtf8Reader) jsonReader;
            int r1 = jsonUtf8Reader.peeked;
            if (r1 == 0) {
                r1 = jsonUtf8Reader.doPeek();
            }
            if (r1 >= 8 && r1 <= 11) {
                JsonReader.Options options = this.options;
                if (r1 == 11) {
                    r0 = jsonUtf8Reader.findString(jsonUtf8Reader.peekedString, options);
                } else {
                    int select = jsonUtf8Reader.source.select(options.doubleQuoteSuffix);
                    if (select != -1) {
                        jsonUtf8Reader.peeked = 0;
                        int[] r2 = jsonUtf8Reader.pathIndices;
                        int r02 = jsonUtf8Reader.stackSize - 1;
                        r2[r02] = r2[r02] + 1;
                        r0 = select;
                    } else {
                        String nextString = jsonUtf8Reader.nextString();
                        int findString = jsonUtf8Reader.findString(nextString, options);
                        if (findString == -1) {
                            jsonUtf8Reader.peeked = 11;
                            jsonUtf8Reader.peekedString = nextString;
                            jsonUtf8Reader.pathIndices[jsonUtf8Reader.stackSize - 1] = r1[r0] - 1;
                        }
                        r0 = findString;
                    }
                }
            } else {
                r0 = -1;
            }
            if (r0 != -1) {
                return this.constants[r0];
            }
            String path = jsonReader.getPath();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.nameStrings) + " but was " + jsonReader.nextString() + " at path " + path);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.value(this.nameStrings[((Enum) obj).ordinal()]);
        }

        public final String toString() {
            return "JsonAdapter(" + this.enumType.getName() + ")";
        }
    }

    /* loaded from: classes3.dex */
    public static final class ObjectJsonAdapter extends JsonAdapter<Object> {
        public final JsonAdapter<Boolean> booleanAdapter;
        public final JsonAdapter<Double> doubleAdapter;
        public final JsonAdapter<List> listJsonAdapter;
        public final JsonAdapter<Map> mapAdapter;
        public final Moshi moshi;
        public final JsonAdapter<String> stringAdapter;

        public ObjectJsonAdapter(Moshi moshi) {
            this.moshi = moshi;
            moshi.getClass();
            Set<Annotation> set = Util.NO_ANNOTATIONS;
            this.listJsonAdapter = moshi.adapter(List.class, set, null);
            this.mapAdapter = moshi.adapter(Map.class, set, null);
            this.stringAdapter = moshi.adapter(String.class, set, null);
            this.doubleAdapter = moshi.adapter(Double.class, set, null);
            this.booleanAdapter = moshi.adapter(Boolean.class, set, null);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass11.$SwitchMap$com$squareup$moshi$JsonReader$Token[jsonReader.peek().ordinal()]) {
                case 1:
                    return this.listJsonAdapter.fromJson(jsonReader);
                case 2:
                    return this.mapAdapter.fromJson(jsonReader);
                case 3:
                    return this.stringAdapter.fromJson(jsonReader);
                case 4:
                    return this.doubleAdapter.fromJson(jsonReader);
                case 5:
                    return this.booleanAdapter.fromJson(jsonReader);
                case 6:
                    jsonReader.nextNull();
                    return null;
                default:
                    throw new IllegalStateException("Expected a value but was " + jsonReader.peek() + " at path " + jsonReader.getPath());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:            if (r1.isAssignableFrom(r0) != false) goto L21;     */
        @Override // com.squareup.moshi.JsonAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void toJson(com.squareup.moshi.JsonWriter r5, java.lang.Object r6) throws java.io.IOException {
            /*
                r4 = this;
                java.lang.Class r0 = r6.getClass()
                java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                if (r0 != r1) goto Lf
                r5.beginObject()
                r5.endObject()
                goto L2e
            Lf:
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r2 = r1.isAssignableFrom(r0)
                if (r2 == 0) goto L19
            L17:
                r0 = r1
                goto L22
            L19:
                java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
                boolean r2 = r1.isAssignableFrom(r0)
                if (r2 == 0) goto L22
                goto L17
            L22:
                java.util.Set<java.lang.annotation.Annotation> r1 = com.squareup.moshi.internal.Util.NO_ANNOTATIONS
                r2 = 0
                com.squareup.moshi.Moshi r3 = r4.moshi
                com.squareup.moshi.JsonAdapter r0 = r3.adapter(r0, r1, r2)
                r0.toJson(r5, r6)
            L2e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.StandardJsonAdapters.ObjectJsonAdapter.toJson(com.squareup.moshi.JsonWriter, java.lang.Object):void");
        }

        public final String toString() {
            return "JsonAdapter(Object)";
        }
    }

    public static int rangeCheckNextInt(JsonReader jsonReader, String str, int r3, int r4) throws IOException {
        int nextInt = jsonReader.nextInt();
        if (nextInt >= r3 && nextInt <= r4) {
            return nextInt;
        }
        throw new JsonDataException(String.format("Expected %s but was %s at path %s", str, Integer.valueOf(nextInt), jsonReader.getPath()));
    }
}
