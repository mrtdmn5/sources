package com.google.gson.internal.bind;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes3.dex */
public final class TypeAdapters {
    public static final AnonymousClass31 ATOMIC_BOOLEAN_FACTORY;
    public static final AnonymousClass31 ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final AnonymousClass31 ATOMIC_INTEGER_FACTORY;
    public static final AnonymousClass16 BIG_DECIMAL;
    public static final AnonymousClass17 BIG_INTEGER;
    public static final AnonymousClass4 BOOLEAN_AS_STRING;
    public static final AnonymousClass32 BOOLEAN_FACTORY;
    public static final AnonymousClass32 BYTE_FACTORY;
    public static final AnonymousClass33 CALENDAR_FACTORY;
    public static final AnonymousClass32 CHARACTER_FACTORY;
    public static final AnonymousClass31 CURRENCY_FACTORY;
    public static final AnonymousClass29 ENUM_FACTORY;
    public static final AnonymousClass34 INET_ADDRESS_FACTORY;
    public static final AnonymousClass32 INTEGER_FACTORY;
    public static final AnonymousClass28 JSON_ELEMENT;
    public static final AnonymousClass34 JSON_ELEMENT_FACTORY;
    public static final AnonymousClass18 LAZILY_PARSED_NUMBER;
    public static final AnonymousClass31 LOCALE_FACTORY;
    public static final AnonymousClass11 LONG;
    public static final AnonymousClass32 SHORT_FACTORY;
    public static final AnonymousClass31 STRING_BUFFER_FACTORY;
    public static final AnonymousClass31 STRING_BUILDER_FACTORY;
    public static final AnonymousClass31 STRING_FACTORY;
    public static final AnonymousClass31 URI_FACTORY;
    public static final AnonymousClass31 URL_FACTORY;
    public static final AnonymousClass31 UUID_FACTORY;
    public static final AnonymousClass31 CLASS_FACTORY = new AnonymousClass31(Class.class, new TypeAdapter.AnonymousClass1());
    public static final AnonymousClass31 BIT_SET_FACTORY = new AnonymousClass31(BitSet.class, new TypeAdapter.AnonymousClass1());

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends TypeAdapter<Class> {
        @Override // com.google.gson.TypeAdapter
        public final Class read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10 */
    /* loaded from: classes3.dex */
    public class AnonymousClass10 extends TypeAdapter<AtomicIntegerArray> {
        @Override // com.google.gson.TypeAdapter
        public final AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int r2 = 0; r2 < size; r2++) {
                atomicIntegerArray.set(r2, ((Integer) arrayList.get(r2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int r1 = 0; r1 < length; r1++) {
                jsonWriter.value(r6.get(r1));
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11 */
    /* loaded from: classes3.dex */
    public class AnonymousClass11 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            Number number2 = number;
            if (number2 == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number2.longValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12 */
    /* loaded from: classes3.dex */
    public class AnonymousClass12 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            Number number2 = number;
            if (number2 == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!(number2 instanceof Float)) {
                number2 = Float.valueOf(number2.floatValue());
            }
            jsonWriter.value(number2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13 */
    /* loaded from: classes3.dex */
    public class AnonymousClass13 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            Number number2 = number;
            if (number2 == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number2.doubleValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14 */
    /* loaded from: classes3.dex */
    public class AnonymousClass14 extends TypeAdapter<Character> {
        @Override // com.google.gson.TypeAdapter
        public final Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Expecting character, got: ", nextString, "; at ");
            m.append(jsonReader.getPreviousPath());
            throw new JsonSyntaxException(m.toString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Character ch) throws IOException {
            String valueOf;
            Character ch2 = ch;
            if (ch2 == null) {
                valueOf = null;
            } else {
                valueOf = String.valueOf(ch2);
            }
            jsonWriter.value(valueOf);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15 */
    /* loaded from: classes3.dex */
    public class AnonymousClass15 extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        public final String read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16 */
    /* loaded from: classes3.dex */
    public class AnonymousClass16 extends TypeAdapter<BigDecimal> {
        @Override // com.google.gson.TypeAdapter
        public final BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as BigDecimal; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17 */
    /* loaded from: classes3.dex */
    public class AnonymousClass17 extends TypeAdapter<BigInteger> {
        @Override // com.google.gson.TypeAdapter
        public final BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigInteger(nextString);
            } catch (NumberFormatException e) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as BigInteger; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18 */
    /* loaded from: classes3.dex */
    public class AnonymousClass18 extends TypeAdapter<LazilyParsedNumber> {
        @Override // com.google.gson.TypeAdapter
        public final LazilyParsedNumber read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new LazilyParsedNumber(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            jsonWriter.value(lazilyParsedNumber);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19 */
    /* loaded from: classes3.dex */
    public class AnonymousClass19 extends TypeAdapter<StringBuilder> {
        @Override // com.google.gson.TypeAdapter
        public final StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            String sb2;
            StringBuilder sb3 = sb;
            if (sb3 == null) {
                sb2 = null;
            } else {
                sb2 = sb3.toString();
            }
            jsonWriter.value(sb2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2 */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 extends TypeAdapter<BitSet> {
        @Override // com.google.gson.TypeAdapter
        public final BitSet read(JsonReader jsonReader) throws IOException {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int r3 = 0;
            while (peek != JsonToken.END_ARRAY) {
                int r4 = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
                boolean z = true;
                if (r4 != 1 && r4 != 2) {
                    if (r4 == 3) {
                        z = jsonReader.nextBoolean();
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + peek + "; at path " + jsonReader.getPath());
                    }
                } else {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt == 0) {
                        z = false;
                    } else if (nextInt != 1) {
                        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Invalid bitset value ", nextInt, ", expected 0 or 1; at path ");
                        m.append(jsonReader.getPreviousPath());
                        throw new JsonSyntaxException(m.toString());
                    }
                }
                if (z) {
                    bitSet.set(r3);
                }
                r3++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            BitSet bitSet2 = bitSet;
            jsonWriter.beginArray();
            int length = bitSet2.length();
            for (int r1 = 0; r1 < length; r1++) {
                jsonWriter.value(bitSet2.get(r1) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20 */
    /* loaded from: classes3.dex */
    public class AnonymousClass20 extends TypeAdapter<StringBuffer> {
        @Override // com.google.gson.TypeAdapter
        public final StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            String stringBuffer2;
            StringBuffer stringBuffer3 = stringBuffer;
            if (stringBuffer3 == null) {
                stringBuffer2 = null;
            } else {
                stringBuffer2 = stringBuffer3.toString();
            }
            jsonWriter.value(stringBuffer2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21 */
    /* loaded from: classes3.dex */
    public class AnonymousClass21 extends TypeAdapter<URL> {
        @Override // com.google.gson.TypeAdapter
        public final URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (Constants.NULL_VERSION_ID.equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, URL url) throws IOException {
            String externalForm;
            URL url2 = url;
            if (url2 == null) {
                externalForm = null;
            } else {
                externalForm = url2.toExternalForm();
            }
            jsonWriter.value(externalForm);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22 */
    /* loaded from: classes3.dex */
    public class AnonymousClass22 extends TypeAdapter<URI> {
        @Override // com.google.gson.TypeAdapter
        public final URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
            } else {
                try {
                    String nextString = jsonReader.nextString();
                    if (!Constants.NULL_VERSION_ID.equals(nextString)) {
                        return new URI(nextString);
                    }
                } catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, URI r2) throws IOException {
            String aSCIIString;
            URI r22 = r2;
            if (r22 == null) {
                aSCIIString = null;
            } else {
                aSCIIString = r22.toASCIIString();
            }
            jsonWriter.value(aSCIIString);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23 */
    /* loaded from: classes3.dex */
    public class AnonymousClass23 extends TypeAdapter<InetAddress> {
        @Override // com.google.gson.TypeAdapter
        public final InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return InetAddress.getByName(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            String hostAddress;
            InetAddress inetAddress2 = inetAddress;
            if (inetAddress2 == null) {
                hostAddress = null;
            } else {
                hostAddress = inetAddress2.getHostAddress();
            }
            jsonWriter.value(hostAddress);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24 */
    /* loaded from: classes3.dex */
    public class AnonymousClass24 extends TypeAdapter<UUID> {
        @Override // com.google.gson.TypeAdapter
        public final UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return UUID.fromString(nextString);
            } catch (IllegalArgumentException e) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as UUID; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, UUID r2) throws IOException {
            String str;
            UUID r22 = r2;
            if (r22 == null) {
                str = null;
            } else {
                str = r22.toString();
            }
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25 */
    /* loaded from: classes3.dex */
    public class AnonymousClass25 extends TypeAdapter<Currency> {
        @Override // com.google.gson.TypeAdapter
        public final Currency read(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as Currency; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26 */
    /* loaded from: classes3.dex */
    public class AnonymousClass26 extends TypeAdapter<Calendar> {
        @Override // com.google.gson.TypeAdapter
        public final Calendar read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
            int r6 = 0;
            int r7 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    r2 = nextInt;
                } else if ("month".equals(nextName)) {
                    r3 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    r4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    r5 = nextInt;
                } else if ("minute".equals(nextName)) {
                    r6 = nextInt;
                } else if ("second".equals(nextName)) {
                    r7 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(r2, r3, r4, r5, r6, r7);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(r4.get(1));
            jsonWriter.name("month");
            jsonWriter.value(r4.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(r4.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(r4.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(r4.get(12));
            jsonWriter.name("second");
            jsonWriter.value(r4.get(13));
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27 */
    /* loaded from: classes3.dex */
    public class AnonymousClass27 extends TypeAdapter<Locale> {
        @Override // com.google.gson.TypeAdapter
        public final Locale read(JsonReader jsonReader) throws IOException {
            String str;
            String str2;
            String str3 = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            String locale2;
            Locale locale3 = locale;
            if (locale3 == null) {
                locale2 = null;
            } else {
                locale2 = locale3.toString();
            }
            jsonWriter.value(locale2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    /* loaded from: classes3.dex */
    public class AnonymousClass29 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (Enum.class.isAssignableFrom(rawType) && rawType != Enum.class) {
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3 */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        public final Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            }
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass31 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$type;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public final String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass32 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$boxed;
        public final /* synthetic */ TypeAdapter val$typeAdapter;
        public final /* synthetic */ Class val$unboxed;

        public AnonymousClass32(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType != this.val$unboxed && rawType != this.val$boxed) {
                return null;
            }
            return this.val$typeAdapter;
        }

        public final String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$33 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass33 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$base = Calendar.class;
        public final /* synthetic */ Class val$sub = GregorianCalendar.class;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public AnonymousClass33(AnonymousClass26 anonymousClass26) {
            r2 = anonymousClass26;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType != this.val$base && rawType != this.val$sub) {
                return null;
            }
            return r2;
        }

        public final String toString() {
            return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + r2 + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$34 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass34 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$clazz;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$1 */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 extends TypeAdapter<Object> {
            public final /* synthetic */ Class val$requestedType;

            public AnonymousClass1(Class cls) {
                r2 = cls;
            }

            @Override // com.google.gson.TypeAdapter
            public final Object read(JsonReader jsonReader) throws IOException {
                Object read = r2.read(jsonReader);
                if (read != null) {
                    Class cls = r2;
                    if (!cls.isInstance(read)) {
                        throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                    }
                }
                return read;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                r2.write(jsonWriter, obj);
            }
        }

        public AnonymousClass34(Class cls, TypeAdapter typeAdapter) {
            r1 = cls;
            r2 = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> rawType = typeToken.getRawType();
            if (!r1.isAssignableFrom(rawType)) {
                return null;
            }
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                public final /* synthetic */ Class val$requestedType;

                public AnonymousClass1(Class rawType2) {
                    r2 = rawType2;
                }

                @Override // com.google.gson.TypeAdapter
                public final Object read(JsonReader jsonReader) throws IOException {
                    Object read = r2.read(jsonReader);
                    if (read != null) {
                        Class cls = r2;
                        if (!cls.isInstance(read)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                        }
                    }
                    return read;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    r2.write(jsonWriter, obj);
                }
            };
        }

        public final String toString() {
            return "Factory[typeHierarchy=" + r1.getName() + ",adapter=" + r2 + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$35 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass35 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            try {
                r0[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4 */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        public final Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            String bool2;
            Boolean bool3 = bool;
            if (bool3 == null) {
                bool2 = Constants.NULL_VERSION_ID;
            } else {
                bool2 = bool3.toString();
            }
            jsonWriter.value(bool2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5 */
    /* loaded from: classes3.dex */
    public class AnonymousClass5 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 255 && nextInt >= -128) {
                    return Byte.valueOf((byte) nextInt);
                }
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Lossy conversion from ", nextInt, " to byte; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(r4.byteValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6 */
    /* loaded from: classes3.dex */
    public class AnonymousClass6 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 65535 && nextInt >= -32768) {
                    return Short.valueOf((short) nextInt);
                }
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Lossy conversion from ", nextInt, " to short; at path ");
                m.append(jsonReader.getPreviousPath());
                throw new JsonSyntaxException(m.toString());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(r4.shortValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7 */
    /* loaded from: classes3.dex */
    public class AnonymousClass7 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(r4.intValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8 */
    /* loaded from: classes3.dex */
    public class AnonymousClass8 extends TypeAdapter<AtomicInteger> {
        @Override // com.google.gson.TypeAdapter
        public final AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9 */
    /* loaded from: classes3.dex */
    public class AnonymousClass9 extends TypeAdapter<AtomicBoolean> {
        @Override // com.google.gson.TypeAdapter
        public final AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        public final HashMap nameToConstant = new HashMap();
        public final HashMap stringToConstant = new HashMap();
        public final HashMap constantToName = new HashMap();

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter$1 */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements PrivilegedAction<Field[]> {
            public final /* synthetic */ Class val$classOfT;

            public AnonymousClass1(Class cls) {
                r1 = cls;
            }

            @Override // java.security.PrivilegedAction
            public final Field[] run() {
                Field[] declaredFields = r1.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new PrivilegedAction<Field[]>() { // from class: com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter.1
                    public final /* synthetic */ Class val$classOfT;

                    public AnonymousClass1(Class cls2) {
                        r1 = cls2;
                    }

                    @Override // java.security.PrivilegedAction
                    public final Field[] run() {
                        Field[] declaredFields = r1.getDeclaredFields();
                        ArrayList arrayList = new ArrayList(declaredFields.length);
                        for (Field field2 : declaredFields) {
                            if (field2.isEnumConstant()) {
                                arrayList.add(field2);
                            }
                        }
                        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                        AccessibleObject.setAccessible(fieldArr, true);
                        return fieldArr;
                    }
                })) {
                    Enum r4 = (Enum) field.get(null);
                    String name = r4.name();
                    String str = r4.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                        for (String str2 : serializedName.alternate()) {
                            this.nameToConstant.put(str2, r4);
                        }
                    }
                    this.nameToConstant.put(name, r4);
                    this.stringToConstant.put(str, r4);
                    this.constantToName.put(r4, name);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            Enum r0 = (Enum) this.nameToConstant.get(nextString);
            if (r0 == null) {
                return (Enum) this.stringToConstant.get(nextString);
            }
            return r0;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String str;
            Enum r3 = (Enum) obj;
            if (r3 == null) {
                str = null;
            } else {
                str = (String) this.constantToName.get(r3);
            }
            jsonWriter.value(str);
        }
    }

    static {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = new AnonymousClass32(Boolean.TYPE, Boolean.class, anonymousClass3);
        BYTE_FACTORY = new AnonymousClass32(Byte.TYPE, Byte.class, new AnonymousClass5());
        SHORT_FACTORY = new AnonymousClass32(Short.TYPE, Short.class, new AnonymousClass6());
        INTEGER_FACTORY = new AnonymousClass32(Integer.TYPE, Integer.class, new AnonymousClass7());
        ATOMIC_INTEGER_FACTORY = new AnonymousClass31(AtomicInteger.class, new TypeAdapter.AnonymousClass1());
        ATOMIC_BOOLEAN_FACTORY = new AnonymousClass31(AtomicBoolean.class, new TypeAdapter.AnonymousClass1());
        ATOMIC_INTEGER_ARRAY_FACTORY = new AnonymousClass31(AtomicIntegerArray.class, new TypeAdapter.AnonymousClass1());
        LONG = new AnonymousClass11();
        new AnonymousClass12();
        new AnonymousClass13();
        CHARACTER_FACTORY = new AnonymousClass32(Character.TYPE, Character.class, new AnonymousClass14());
        AnonymousClass15 anonymousClass15 = new AnonymousClass15();
        BIG_DECIMAL = new AnonymousClass16();
        BIG_INTEGER = new AnonymousClass17();
        LAZILY_PARSED_NUMBER = new AnonymousClass18();
        STRING_FACTORY = new AnonymousClass31(String.class, anonymousClass15);
        STRING_BUILDER_FACTORY = new AnonymousClass31(StringBuilder.class, new AnonymousClass19());
        STRING_BUFFER_FACTORY = new AnonymousClass31(StringBuffer.class, new AnonymousClass20());
        URL_FACTORY = new AnonymousClass31(URL.class, new AnonymousClass21());
        URI_FACTORY = new AnonymousClass31(URI.class, new AnonymousClass22());
        INET_ADDRESS_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            public final /* synthetic */ Class val$clazz;
            public final /* synthetic */ TypeAdapter val$typeAdapter;

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$1 */
            /* loaded from: classes3.dex */
            public class AnonymousClass1 extends TypeAdapter<Object> {
                public final /* synthetic */ Class val$requestedType;

                public AnonymousClass1(Class rawType2) {
                    r2 = rawType2;
                }

                @Override // com.google.gson.TypeAdapter
                public final Object read(JsonReader jsonReader) throws IOException {
                    Object read = r2.read(jsonReader);
                    if (read != null) {
                        Class cls = r2;
                        if (!cls.isInstance(read)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                        }
                    }
                    return read;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    r2.write(jsonWriter, obj);
                }
            }

            public AnonymousClass34(Class cls, TypeAdapter typeAdapter) {
                r1 = cls;
                r2 = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public final <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                Class rawType2 = typeToken.getRawType();
                if (!r1.isAssignableFrom(rawType2)) {
                    return null;
                }
                return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                    public final /* synthetic */ Class val$requestedType;

                    public AnonymousClass1(Class rawType22) {
                        r2 = rawType22;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final Object read(JsonReader jsonReader) throws IOException {
                        Object read = r2.read(jsonReader);
                        if (read != null) {
                            Class cls = r2;
                            if (!cls.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                            }
                        }
                        return read;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                        r2.write(jsonWriter, obj);
                    }
                };
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + r1.getName() + ",adapter=" + r2 + "]";
            }
        };
        UUID_FACTORY = new AnonymousClass31(UUID.class, new AnonymousClass24());
        CURRENCY_FACTORY = new AnonymousClass31(Currency.class, new TypeAdapter.AnonymousClass1());
        CALENDAR_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            public final /* synthetic */ Class val$base = Calendar.class;
            public final /* synthetic */ Class val$sub = GregorianCalendar.class;
            public final /* synthetic */ TypeAdapter val$typeAdapter;

            public AnonymousClass33(AnonymousClass26 anonymousClass26) {
                r2 = anonymousClass26;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType != this.val$base && rawType != this.val$sub) {
                    return null;
                }
                return r2;
            }

            public final String toString() {
                return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + r2 + "]";
            }
        };
        LOCALE_FACTORY = new AnonymousClass31(Locale.class, new AnonymousClass27());
        AnonymousClass28 anonymousClass28 = new AnonymousClass28();
        JSON_ELEMENT = anonymousClass28;
        JSON_ELEMENT_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            public final /* synthetic */ Class val$clazz;
            public final /* synthetic */ TypeAdapter val$typeAdapter;

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$34$1 */
            /* loaded from: classes3.dex */
            public class AnonymousClass1 extends TypeAdapter<Object> {
                public final /* synthetic */ Class val$requestedType;

                public AnonymousClass1(Class rawType22) {
                    r2 = rawType22;
                }

                @Override // com.google.gson.TypeAdapter
                public final Object read(JsonReader jsonReader) throws IOException {
                    Object read = r2.read(jsonReader);
                    if (read != null) {
                        Class cls = r2;
                        if (!cls.isInstance(read)) {
                            throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                        }
                    }
                    return read;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    r2.write(jsonWriter, obj);
                }
            }

            public AnonymousClass34(Class cls, TypeAdapter anonymousClass282) {
                r1 = cls;
                r2 = anonymousClass282;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public final <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                Class rawType22 = typeToken.getRawType();
                if (!r1.isAssignableFrom(rawType22)) {
                    return null;
                }
                return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                    public final /* synthetic */ Class val$requestedType;

                    public AnonymousClass1(Class rawType222) {
                        r2 = rawType222;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final Object read(JsonReader jsonReader) throws IOException {
                        Object read = r2.read(jsonReader);
                        if (read != null) {
                            Class cls = r2;
                            if (!cls.isInstance(read)) {
                                throw new JsonSyntaxException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                            }
                        }
                        return read;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                        r2.write(jsonWriter, obj);
                    }
                };
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + r1.getName() + ",adapter=" + r2 + "]";
            }
        };
        ENUM_FACTORY = new AnonymousClass29();
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    /* loaded from: classes3.dex */
    public class AnonymousClass28 extends TypeAdapter<JsonElement> {
        public static JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int r0 = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        if (r0 == 6) {
                            jsonReader.nextNull();
                            return JsonNull.INSTANCE;
                        }
                        throw new IllegalStateException("Unexpected token: " + jsonToken);
                    }
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                }
                return new JsonPrimitive(jsonReader.nextString());
            }
            return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
        }

        public static JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int r2 = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (r2 != 4) {
                if (r2 != 5) {
                    return null;
                }
                jsonReader.beginObject();
                return new JsonObject();
            }
            jsonReader.beginArray();
            return new JsonArray();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
            if (jsonElement != null && !(jsonElement instanceof JsonNull)) {
                boolean z = jsonElement instanceof JsonPrimitive;
                if (z) {
                    if (z) {
                        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
                        Serializable serializable = jsonPrimitive.value;
                        if (serializable instanceof Number) {
                            jsonWriter.value(jsonPrimitive.getAsNumber());
                            return;
                        } else if (serializable instanceof Boolean) {
                            jsonWriter.value(jsonPrimitive.getAsBoolean());
                            return;
                        } else {
                            jsonWriter.value(jsonPrimitive.getAsString());
                            return;
                        }
                    }
                    throw new IllegalStateException("Not a JSON Primitive: " + jsonElement);
                }
                boolean z2 = jsonElement instanceof JsonArray;
                if (z2) {
                    jsonWriter.beginArray();
                    if (z2) {
                        Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
                        while (it.hasNext()) {
                            write(it.next(), jsonWriter);
                        }
                        jsonWriter.endArray();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                }
                boolean z3 = jsonElement instanceof JsonObject;
                if (z3) {
                    jsonWriter.beginObject();
                    if (z3) {
                        LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                        LinkedTreeMap.Node node = linkedTreeMap.header.next;
                        int r1 = linkedTreeMap.modCount;
                        while (true) {
                            LinkedTreeMap.Node node2 = linkedTreeMap.header;
                            if (!(node != node2)) {
                                jsonWriter.endObject();
                                return;
                            }
                            if (node != node2) {
                                if (linkedTreeMap.modCount == r1) {
                                    LinkedTreeMap.Node node3 = node.next;
                                    jsonWriter.name((String) node.key);
                                    write((JsonElement) node.value, jsonWriter);
                                    node = node3;
                                } else {
                                    throw new ConcurrentModificationException();
                                }
                            } else {
                                throw new NoSuchElementException();
                            }
                        }
                    } else {
                        throw new IllegalStateException("Not a JSON Object: " + jsonElement);
                    }
                } else {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
            } else {
                jsonWriter.nullValue();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final JsonElement read(JsonReader jsonReader) throws IOException {
            String str;
            boolean z;
            JsonElement jsonElement;
            JsonElement jsonElement2;
            if (jsonReader instanceof JsonTreeReader) {
                JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                JsonToken peek = jsonTreeReader.peek();
                if (peek != JsonToken.NAME && peek != JsonToken.END_ARRAY && peek != JsonToken.END_OBJECT && peek != JsonToken.END_DOCUMENT) {
                    JsonElement jsonElement3 = (JsonElement) jsonTreeReader.peekStack();
                    jsonTreeReader.skipValue();
                    return jsonElement3;
                }
                throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
            }
            JsonToken peek2 = jsonReader.peek();
            JsonElement tryBeginNesting = tryBeginNesting(jsonReader, peek2);
            if (tryBeginNesting == null) {
                return readTerminal(jsonReader, peek2);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    if (tryBeginNesting instanceof JsonObject) {
                        str = jsonReader.nextName();
                    } else {
                        str = null;
                    }
                    JsonToken peek3 = jsonReader.peek();
                    JsonElement tryBeginNesting2 = tryBeginNesting(jsonReader, peek3);
                    if (tryBeginNesting2 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (tryBeginNesting2 == null) {
                        tryBeginNesting2 = readTerminal(jsonReader, peek3);
                    }
                    if (tryBeginNesting instanceof JsonArray) {
                        JsonArray jsonArray = (JsonArray) tryBeginNesting;
                        if (tryBeginNesting2 == null) {
                            jsonArray.getClass();
                            jsonElement2 = JsonNull.INSTANCE;
                        } else {
                            jsonElement2 = tryBeginNesting2;
                        }
                        jsonArray.elements.add(jsonElement2);
                    } else {
                        JsonObject jsonObject = (JsonObject) tryBeginNesting;
                        if (tryBeginNesting2 == null) {
                            jsonObject.getClass();
                            jsonElement = JsonNull.INSTANCE;
                        } else {
                            jsonElement = tryBeginNesting2;
                        }
                        jsonObject.members.put(str, jsonElement);
                    }
                    if (z) {
                        arrayDeque.addLast(tryBeginNesting);
                        tryBeginNesting = tryBeginNesting2;
                    }
                } else {
                    if (tryBeginNesting instanceof JsonArray) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return tryBeginNesting;
                    }
                    tryBeginNesting = (JsonElement) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            write(jsonElement, jsonWriter);
        }
    }
}
