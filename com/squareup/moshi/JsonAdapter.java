package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class JsonAdapter<T> {

    /* renamed from: com.squareup.moshi.JsonAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends JsonAdapter<Object> {
        public AnonymousClass1() {
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            return JsonAdapter.this.fromJson(jsonReader);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            boolean z = jsonWriter.serializeNulls;
            jsonWriter.serializeNulls = true;
            try {
                JsonAdapter.this.toJson(jsonWriter, obj);
            } finally {
                jsonWriter.serializeNulls = z;
            }
        }

        public final String toString() {
            return JsonAdapter.this + ".serializeNulls()";
        }
    }

    /* renamed from: com.squareup.moshi.JsonAdapter$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 extends JsonAdapter<Object> {
        public AnonymousClass2() {
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonReader.Token.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return JsonAdapter.this.fromJson(jsonReader);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                JsonAdapter.this.toJson(jsonWriter, obj);
            }
        }

        public final String toString() {
            return JsonAdapter.this + ".nullSafe()";
        }
    }

    /* renamed from: com.squareup.moshi.JsonAdapter$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 extends JsonAdapter<Object> {
        public AnonymousClass4() {
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            boolean z = jsonReader.lenient;
            jsonReader.lenient = true;
            try {
                return JsonAdapter.this.fromJson(jsonReader);
            } finally {
                jsonReader.lenient = z;
            }
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            boolean z = jsonWriter.lenient;
            jsonWriter.lenient = true;
            try {
                JsonAdapter.this.toJson(jsonWriter, obj);
            } finally {
                jsonWriter.lenient = z;
            }
        }

        public final String toString() {
            return JsonAdapter.this + ".lenient()";
        }
    }

    /* renamed from: com.squareup.moshi.JsonAdapter$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass5 extends JsonAdapter<Object> {
        public AnonymousClass5() {
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final Object fromJson(JsonReader jsonReader) throws IOException {
            boolean z = jsonReader.failOnUnknown;
            jsonReader.failOnUnknown = true;
            try {
                return JsonAdapter.this.fromJson(jsonReader);
            } finally {
                jsonReader.failOnUnknown = z;
            }
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            JsonAdapter.this.toJson(jsonWriter, obj);
        }

        public final String toString() {
            return JsonAdapter.this + ".failOnUnknown()";
        }
    }

    /* loaded from: classes3.dex */
    public interface Factory {
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public final AnonymousClass2 nullSafe() {
        return new AnonymousClass2();
    }

    public abstract void toJson(JsonWriter jsonWriter, T t) throws IOException;
}
