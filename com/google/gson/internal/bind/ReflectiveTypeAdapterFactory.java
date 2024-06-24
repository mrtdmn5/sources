package com.google.gson.internal.bind;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final ConstructorConstructor constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingStrategy fieldNamingPolicy;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final List<ReflectionAccessFilter> reflectionFilters;

    /* loaded from: classes3.dex */
    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        public final Map<String, BoundField> boundFields;

        public Adapter(LinkedHashMap linkedHashMap) {
            this.boundFields = linkedHashMap;
        }

        public abstract A createAccumulator();

        public abstract T finalize(A a);

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            A createAccumulator = createAccumulator();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null && boundField.deserialized) {
                        readField(createAccumulator, jsonReader, boundField);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return finalize(createAccumulator);
            } catch (IllegalAccessException e) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        public abstract void readField(A a, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException;

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator<BoundField> it = this.boundFields.values().iterator();
                while (it.hasNext()) {
                    it.next().write(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class BoundField {
        public final boolean deserialized;
        public final Field field;
        public final String fieldName;
        public final String name;
        public final boolean serialized;

        public BoundField(String str, Field field, boolean z, boolean z2) {
            this.name = str;
            this.field = field;
            this.fieldName = field.getName();
            this.serialized = z;
            this.deserialized = z2;
        }

        public abstract void readIntoArray(JsonReader jsonReader, int r2, Object[] objArr) throws IOException, JsonParseException;

        public abstract void readIntoField(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    /* loaded from: classes3.dex */
    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        public static final HashMap PRIMITIVE_DEFAULTS;
        public final HashMap componentIndices;
        public final Constructor<T> constructor;
        public final Object[] constructorArgsDefaults;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            PRIMITIVE_DEFAULTS = hashMap;
        }

        public RecordAdapter(Class cls, LinkedHashMap linkedHashMap, boolean z) {
            super(linkedHashMap);
            this.componentIndices = new HashMap();
            ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.RECORD_HELPER;
            Constructor<T> canonicalRecordConstructor = recordHelper.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            if (z) {
                ReflectiveTypeAdapterFactory.access$000(null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = recordHelper.getRecordComponentNames(cls);
            for (int r6 = 0; r6 < recordComponentNames.length; r6++) {
                this.componentIndices.put(recordComponentNames[r6], Integer.valueOf(r6));
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int r5 = 0; r5 < parameterTypes.length; r5++) {
                this.constructorArgsDefaults[r5] = PRIMITIVE_DEFAULTS.get(parameterTypes[r5]);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object[] createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object finalize(Object[] objArr) {
            Object[] objArr2 = objArr;
            Constructor<T> constructor = this.constructor;
            try {
                return constructor.newInstance(objArr2);
            } catch (IllegalAccessException e) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr2), e);
            } catch (InstantiationException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr2), e);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr2), e4.getCause());
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void readField(Object[] objArr, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            Object[] objArr2 = objArr;
            HashMap hashMap = this.componentIndices;
            String str = boundField.fieldName;
            Integer num = (Integer) hashMap.get(str);
            if (num != null) {
                boundField.readIntoArray(jsonReader, num.intValue(), objArr2);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingPolicy fieldNamingPolicy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingPolicy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void access$000(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.AccessChecker.INSTANCE.canAccess(obj, accessibleObject)) {
        } else {
            throw new JsonIOException(ComposableInvoker$$ExternalSyntheticOutline0.m(ReflectionHelper.getAccessibleObjectDescription(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z;
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(rawType, this.reflectionFilters);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            if (ReflectionHelper.RECORD_HELPER.isRecord(rawType)) {
                return new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, z2, true), z2);
            }
            return new FieldReflectionAdapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, z2, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ea  */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.gson.internal.reflect.ReflectionHelper$RecordHelper] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.LinkedHashMap getBoundFields(final com.google.gson.Gson r36, com.google.gson.reflect.TypeToken r37, java.lang.Class r38, boolean r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):java.util.LinkedHashMap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:            if (r0 == false) goto L34;     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean includeField(java.lang.reflect.Field r10, boolean r11) {
        /*
            r9 = this;
            java.lang.Class r0 = r10.getType()
            com.google.gson.internal.Excluder r1 = r9.excluder
            boolean r2 = r1.excludeClassChecks(r0)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L17
            boolean r0 = r1.excludeClassInStrategy(r0, r11)
            if (r0 == 0) goto L15
            goto L17
        L15:
            r0 = r3
            goto L18
        L17:
            r0 = r4
        L18:
            if (r0 != 0) goto La3
            int r0 = r10.getModifiers()
            int r2 = r1.modifiers
            r0 = r0 & r2
            if (r0 == 0) goto L25
            goto L9d
        L25:
            double r5 = r1.version
            r7 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L44
            java.lang.Class<com.google.gson.annotations.Since> r0 = com.google.gson.annotations.Since.class
            java.lang.annotation.Annotation r0 = r10.getAnnotation(r0)
            com.google.gson.annotations.Since r0 = (com.google.gson.annotations.Since) r0
            java.lang.Class<com.google.gson.annotations.Until> r2 = com.google.gson.annotations.Until.class
            java.lang.annotation.Annotation r2 = r10.getAnnotation(r2)
            com.google.gson.annotations.Until r2 = (com.google.gson.annotations.Until) r2
            boolean r0 = r1.isValidVersion(r0, r2)
            if (r0 != 0) goto L44
            goto L9d
        L44:
            boolean r0 = r10.isSynthetic()
            if (r0 == 0) goto L4b
            goto L9d
        L4b:
            boolean r0 = r1.serializeInnerClasses
            if (r0 != 0) goto L6c
            java.lang.Class r0 = r10.getType()
            boolean r2 = r0.isMemberClass()
            if (r2 == 0) goto L68
            int r0 = r0.getModifiers()
            r0 = r0 & 8
            if (r0 == 0) goto L63
            r0 = r4
            goto L64
        L63:
            r0 = r3
        L64:
            if (r0 != 0) goto L68
            r0 = r4
            goto L69
        L68:
            r0 = r3
        L69:
            if (r0 == 0) goto L6c
            goto L9d
        L6c:
            java.lang.Class r0 = r10.getType()
            boolean r0 = com.google.gson.internal.Excluder.isAnonymousOrNonStaticLocal(r0)
            if (r0 == 0) goto L77
            goto L9d
        L77:
            if (r11 == 0) goto L7c
            java.util.List<com.google.gson.ExclusionStrategy> r11 = r1.serializationStrategies
            goto L7e
        L7c:
            java.util.List<com.google.gson.ExclusionStrategy> r11 = r1.deserializationStrategies
        L7e:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L9f
            java.util.Objects.requireNonNull(r10)
            java.util.Iterator r10 = r11.iterator()
        L8b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L9f
            java.lang.Object r11 = r10.next()
            com.google.gson.ExclusionStrategy r11 = (com.google.gson.ExclusionStrategy) r11
            boolean r11 = r11.shouldSkipField()
            if (r11 == 0) goto L8b
        L9d:
            r10 = r4
            goto La0
        L9f:
            r10 = r3
        La0:
            if (r10 != 0) goto La3
            r3 = r4
        La3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.includeField(java.lang.reflect.Field, boolean):boolean");
    }

    /* loaded from: classes3.dex */
    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        public final ObjectConstructor<T> constructor;

        public FieldReflectionAdapter(ObjectConstructor objectConstructor, LinkedHashMap linkedHashMap) {
            super(linkedHashMap);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final T createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void readField(T t, JsonReader jsonReader, BoundField boundField) throws IllegalAccessException, IOException {
            boundField.readIntoField(jsonReader, t);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final T finalize(T t) {
            return t;
        }
    }
}
