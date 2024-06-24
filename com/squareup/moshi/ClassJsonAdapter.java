package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final ClassFactory<T> classFactory;
    public final FieldBinding<?>[] fieldsArray;
    public final JsonReader.Options options;

    /* renamed from: com.squareup.moshi.ClassJsonAdapter$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements JsonAdapter.Factory {
        /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
        @Override // com.squareup.moshi.JsonAdapter.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.squareup.moshi.JsonAdapter<?> create(java.lang.reflect.Type r18, java.util.Set<? extends java.lang.annotation.Annotation> r19, com.squareup.moshi.Moshi r20) {
            /*
                Method dump skipped, instructions count: 627
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.ClassJsonAdapter.AnonymousClass1.create(java.lang.reflect.Type, java.util.Set, com.squareup.moshi.Moshi):com.squareup.moshi.JsonAdapter");
        }
    }

    /* loaded from: classes3.dex */
    public static class FieldBinding<T> {
        public final JsonAdapter<T> adapter;
        public final Field field;
        public final String name;

        public FieldBinding(String str, Field field, JsonAdapter<T> jsonAdapter) {
            this.name = str;
            this.field = field;
            this.adapter = jsonAdapter;
        }
    }

    public ClassJsonAdapter(ClassFactory classFactory, TreeMap treeMap) {
        this.classFactory = classFactory;
        this.fieldsArray = (FieldBinding[]) treeMap.values().toArray(new FieldBinding[treeMap.size()]);
        this.options = JsonReader.Options.of((String[]) treeMap.keySet().toArray(new String[treeMap.size()]));
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T newInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(this.options);
                    if (selectName == -1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        FieldBinding<?> fieldBinding = this.fieldsArray[selectName];
                        fieldBinding.field.set(newInstance, fieldBinding.adapter.fromJson(jsonReader));
                    }
                }
                jsonReader.endObject();
                return newInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            Util.rethrowCause(e2);
            throw null;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final void toJson(JsonWriter jsonWriter, T t) throws IOException {
        try {
            jsonWriter.beginObject();
            for (FieldBinding<?> fieldBinding : this.fieldsArray) {
                jsonWriter.name(fieldBinding.name);
                fieldBinding.adapter.toJson(jsonWriter, fieldBinding.field.get(t));
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public final String toString() {
        return "JsonAdapter(" + this.classFactory + ")";
    }
}
