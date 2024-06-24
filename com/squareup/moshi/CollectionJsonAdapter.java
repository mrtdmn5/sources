package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final JsonAdapter<T> elementAdapter;

    /* renamed from: com.squareup.moshi.CollectionJsonAdapter$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements JsonAdapter.Factory {
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (rawType != List.class && rawType != Collection.class) {
                if (rawType != Set.class) {
                    return null;
                }
                Type collectionElementType = Types.collectionElementType(type);
                moshi.getClass();
                return new JsonAdapter.AnonymousClass2();
            }
            Type collectionElementType2 = Types.collectionElementType(type);
            moshi.getClass();
            return new JsonAdapter.AnonymousClass2();
        }
    }

    /* renamed from: com.squareup.moshi.CollectionJsonAdapter$2 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 extends CollectionJsonAdapter<Collection<Object>, Object> {
        @Override // com.squareup.moshi.CollectionJsonAdapter
        public final Collection<Object> newCollection() {
            return new ArrayList();
        }
    }

    /* renamed from: com.squareup.moshi.CollectionJsonAdapter$3 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 extends CollectionJsonAdapter<Set<Object>, Object> {
        @Override // com.squareup.moshi.CollectionJsonAdapter
        public final Set<Object> newCollection() {
            return new LinkedHashSet();
        }

        @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
        public final /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            toJson(jsonWriter, (JsonWriter) obj);
        }
    }

    public CollectionJsonAdapter(JsonAdapter jsonAdapter) {
        this.elementAdapter = jsonAdapter;
    }

    public abstract C newCollection();

    public final String toString() {
        return this.elementAdapter + ".collection()";
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final C fromJson(JsonReader jsonReader) throws IOException {
        C newCollection = newCollection();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            newCollection.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        return newCollection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter
    public final void toJson(JsonWriter jsonWriter, C c) throws IOException {
        jsonWriter.beginArray();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            this.elementAdapter.toJson(jsonWriter, it.next());
        }
        jsonWriter.endArray();
    }
}
