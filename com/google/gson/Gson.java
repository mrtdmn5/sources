package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes3.dex */
public final class Gson {
    public final List<TypeAdapterFactory> builderFactories;
    public final List<TypeAdapterFactory> builderHierarchyFactories;
    public final ConstructorConstructor constructorConstructor;
    public final List<TypeAdapterFactory> factories;
    public final boolean htmlSafe;
    public final Map<Type, InstanceCreator<?>> instanceCreators;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final List<ReflectionAccessFilter> reflectionFilters;
    public final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    public final ConcurrentHashMap typeTokenCache;
    public static final FieldNamingPolicy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    public static final ToNumberPolicy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    public static final ToNumberPolicy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* renamed from: com.google.gson.Gson$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends TypeAdapter<Number> {
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
                return;
            }
            double doubleValue = number2.doubleValue();
            Gson.checkValidFloatingPoint(doubleValue);
            jsonWriter.value(doubleValue);
        }
    }

    /* renamed from: com.google.gson.Gson$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 extends TypeAdapter<Number> {
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
            float floatValue = number2.floatValue();
            Gson.checkValidFloatingPoint(floatValue);
            if (!(number2 instanceof Float)) {
                number2 = Float.valueOf(floatValue);
            }
            jsonWriter.value(number2);
        }
    }

    /* renamed from: com.google.gson.Gson$4 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 extends TypeAdapter<AtomicLong> {
        public AnonymousClass4() {
        }

        @Override // com.google.gson.TypeAdapter
        public final AtomicLong read(JsonReader jsonReader) throws IOException {
            return new AtomicLong(((Number) TypeAdapter.this.read(jsonReader)).longValue());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
            TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: com.google.gson.Gson$5 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 extends TypeAdapter<AtomicLongArray> {
        public AnonymousClass5() {
        }

        @Override // com.google.gson.TypeAdapter
        public final AtomicLongArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int r2 = 0; r2 < size; r2++) {
                atomicLongArray.set(r2, ((Long) arrayList.get(r2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
            AtomicLongArray atomicLongArray2 = atomicLongArray;
            jsonWriter.beginArray();
            int length = atomicLongArray2.length();
            for (int r1 = 0; r1 < length; r1++) {
                TypeAdapter.this.write(jsonWriter, Long.valueOf(atomicLongArray2.get(r1)));
            }
            jsonWriter.endArray();
        }
    }

    /* loaded from: classes3.dex */
    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        public TypeAdapter<T> delegate = null;

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public final TypeAdapter<T> getSerializationDelegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                typeAdapter.write(jsonWriter, t);
                return;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    public Gson() {
        ObjectTypeAdapter.AnonymousClass1 anonymousClass1;
        NumberTypeAdapter.AnonymousClass1 anonymousClass12;
        Excluder excluder = Excluder.DEFAULT;
        FieldNamingPolicy fieldNamingPolicy = DEFAULT_FIELD_NAMING_STRATEGY;
        Map<Type, InstanceCreator<?>> emptyMap = Collections.emptyMap();
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        List<TypeAdapterFactory> emptyList = Collections.emptyList();
        List<TypeAdapterFactory> emptyList2 = Collections.emptyList();
        List emptyList3 = Collections.emptyList();
        List<ReflectionAccessFilter> emptyList4 = Collections.emptyList();
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.instanceCreators = emptyMap;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(emptyList4, emptyMap);
        this.constructorConstructor = constructorConstructor;
        this.htmlSafe = true;
        this.builderFactories = emptyList;
        this.builderHierarchyFactories = emptyList2;
        this.reflectionFilters = emptyList4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        ObjectTypeAdapter.AnonymousClass1 anonymousClass13 = ObjectTypeAdapter.DOUBLE_FACTORY;
        ToNumberPolicy toNumberPolicy = ToNumberPolicy.DOUBLE;
        ToNumberPolicy toNumberPolicy2 = DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        if (toNumberPolicy2 == toNumberPolicy) {
            anonymousClass1 = ObjectTypeAdapter.DOUBLE_FACTORY;
        } else {
            anonymousClass1 = new ObjectTypeAdapter.AnonymousClass1(toNumberPolicy2);
        }
        arrayList.add(anonymousClass1);
        arrayList.add(excluder);
        arrayList.addAll(emptyList3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapters.AnonymousClass11 anonymousClass11 = TypeAdapters.LONG;
        arrayList.add(new TypeAdapters.AnonymousClass32(Long.TYPE, Long.class, anonymousClass11));
        arrayList.add(new TypeAdapters.AnonymousClass32(Double.TYPE, Double.class, new AnonymousClass1()));
        arrayList.add(new TypeAdapters.AnonymousClass32(Float.TYPE, Float.class, new AnonymousClass2()));
        NumberTypeAdapter.AnonymousClass1 anonymousClass14 = NumberTypeAdapter.LAZILY_PARSED_NUMBER_FACTORY;
        ToNumberPolicy toNumberPolicy3 = ToNumberPolicy.LAZILY_PARSED_NUMBER;
        ToNumberPolicy toNumberPolicy4 = DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        if (toNumberPolicy4 == toNumberPolicy3) {
            anonymousClass12 = NumberTypeAdapter.LAZILY_PARSED_NUMBER_FACTORY;
        } else {
            anonymousClass12 = new NumberTypeAdapter.AnonymousClass1();
        }
        arrayList.add(anonymousClass12);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(new TypeAdapters.AnonymousClass31(AtomicLong.class, new TypeAdapter.AnonymousClass1()));
        arrayList.add(new TypeAdapters.AnonymousClass31(AtomicLongArray.class, new TypeAdapter.AnonymousClass1()));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(new TypeAdapters.AnonymousClass31(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(new TypeAdapters.AnonymousClass31(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(new TypeAdapters.AnonymousClass31(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(SqlTypesSupport.TIME_FACTORY);
            arrayList.add(SqlTypesSupport.DATE_FACTORY);
            arrayList.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingPolicy, excluder, jsonAdapterAnnotationTypeAdapterFactory, emptyList4));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public static void checkValidFloatingPoint(double d) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            return;
        }
        throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T fromJson(java.io.Reader r5, com.google.gson.reflect.TypeToken<T> r6) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        /*
            r4 = this;
            com.google.gson.stream.JsonReader r0 = new com.google.gson.stream.JsonReader
            r0.<init>(r5)
            java.lang.String r5 = "AssertionError (GSON 2.10.1): "
            r1 = 1
            r0.lenient = r1
            r2 = 0
            r0.peek()     // Catch: java.lang.AssertionError -> L1c java.io.IOException -> L33 java.lang.Throwable -> L3a java.lang.IllegalStateException -> L3c java.io.EOFException -> L43
            com.google.gson.TypeAdapter r6 = r4.getAdapter(r6)     // Catch: java.io.EOFException -> L19 java.lang.AssertionError -> L1c java.io.IOException -> L33 java.lang.Throwable -> L3a java.lang.IllegalStateException -> L3c
            java.lang.Object r5 = r6.read(r0)     // Catch: java.io.EOFException -> L19 java.lang.AssertionError -> L1c java.io.IOException -> L33 java.lang.Throwable -> L3a java.lang.IllegalStateException -> L3c
            r0.lenient = r2
            goto L49
        L19:
            r5 = move-exception
            r1 = r2
            goto L44
        L1c:
            r6 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r6.getMessage()     // Catch: java.lang.Throwable -> L3a
            r3.append(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L3a
            throw r1     // Catch: java.lang.Throwable -> L3a
        L33:
            r5 = move-exception
            com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L3a
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            throw r6     // Catch: java.lang.Throwable -> L3a
        L3a:
            r5 = move-exception
            goto L71
        L3c:
            r5 = move-exception
            com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L3a
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            throw r6     // Catch: java.lang.Throwable -> L3a
        L43:
            r5 = move-exception
        L44:
            if (r1 == 0) goto L6b
            r0.lenient = r2
            r5 = 0
        L49:
            if (r5 == 0) goto L6a
            com.google.gson.stream.JsonToken r6 = r0.peek()     // Catch: java.io.IOException -> L5c com.google.gson.stream.MalformedJsonException -> L63
            com.google.gson.stream.JsonToken r0 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L5c com.google.gson.stream.MalformedJsonException -> L63
            if (r6 != r0) goto L54
            goto L6a
        L54:
            com.google.gson.JsonSyntaxException r5 = new com.google.gson.JsonSyntaxException     // Catch: java.io.IOException -> L5c com.google.gson.stream.MalformedJsonException -> L63
            java.lang.String r6 = "JSON document was not fully consumed."
            r5.<init>(r6)     // Catch: java.io.IOException -> L5c com.google.gson.stream.MalformedJsonException -> L63
            throw r5     // Catch: java.io.IOException -> L5c com.google.gson.stream.MalformedJsonException -> L63
        L5c:
            r5 = move-exception
            com.google.gson.JsonIOException r6 = new com.google.gson.JsonIOException
            r6.<init>(r5)
            throw r6
        L63:
            r5 = move-exception
            com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException
            r6.<init>(r5)
            throw r6
        L6a:
            return r5
        L6b:
            com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L3a
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            throw r6     // Catch: java.lang.Throwable -> L3a
        L71:
            r0.lenient = r2
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.fromJson(java.io.Reader, com.google.gson.reflect.TypeToken):java.lang.Object");
    }

    public final <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.typeTokenCache;
        TypeAdapter<T> typeAdapter = (TypeAdapter) concurrentHashMap.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocal = this.threadLocalAdapterResults;
        Map<TypeToken<?>, TypeAdapter<?>> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
            z = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            TypeAdapter<T> typeAdapter3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapter3 = it.next().create(this, typeToken);
                if (typeAdapter3 != null) {
                    if (futureTypeAdapter.delegate == null) {
                        futureTypeAdapter.delegate = typeAdapter3;
                        map.put(typeToken, typeAdapter3);
                    } else {
                        throw new AssertionError("Delegate is already set");
                    }
                }
            }
            if (typeAdapter3 != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } finally {
            if (z) {
                threadLocal.remove();
            }
        }
    }

    public final <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        List<TypeAdapterFactory> list = this.factories;
        if (!list.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : list) {
            if (!z) {
                if (typeAdapterFactory2 == typeAdapterFactory) {
                    z = true;
                }
            } else {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public final JsonWriter newJsonWriter(Writer writer) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.htmlSafe = this.htmlSafe;
        jsonWriter.lenient = false;
        jsonWriter.serializeNulls = false;
        return jsonWriter;
    }

    public final void toJson(JsonNull jsonNull, JsonWriter jsonWriter) throws JsonIOException {
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = false;
        try {
            try {
                TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonNull);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public final String toJson(Object obj) {
        if (obj == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            StringWriter stringWriter = new StringWriter();
            try {
                toJson(jsonNull, newJsonWriter(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            toJson(obj, cls, newJsonWriter(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.wrap(cls).cast(str == null ? null : fromJson(new StringReader(str), TypeToken.get((Class) cls)));
    }

    public final <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        TypeToken<?> typeToken = TypeToken.get(type);
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), typeToken);
    }

    public final void toJson(Object obj, Class cls, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = getAdapter(TypeToken.get((Type) cls));
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = false;
        try {
            try {
                try {
                    adapter.write(jsonWriter, obj);
                } catch (AssertionError e) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);
                }
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
        }
    }
}
