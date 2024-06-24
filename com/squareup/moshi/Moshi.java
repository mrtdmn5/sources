package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Moshi {
    public static final ArrayList BUILT_IN_FACTORIES;
    public final List<JsonAdapter.Factory> factories;
    public final ThreadLocal<LookupChain> lookupChainThreadLocal = new ThreadLocal<>();
    public final LinkedHashMap adapterCache = new LinkedHashMap();

    /* loaded from: classes3.dex */
    public static final class Builder {
        public final ArrayList factories = new ArrayList();
    }

    /* loaded from: classes3.dex */
    public static final class Lookup<T> extends JsonAdapter<T> {
        public JsonAdapter<T> adapter;
        public final Object cacheKey;
        public final String fieldName;
        public final Type type;

        public Lookup(Type type, String str, Object obj) {
            this.type = type;
            this.fieldName = str;
            this.cacheKey = obj;
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final T fromJson(JsonReader jsonReader) throws IOException {
            JsonAdapter<T> jsonAdapter = this.adapter;
            if (jsonAdapter != null) {
                return jsonAdapter.fromJson(jsonReader);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override // com.squareup.moshi.JsonAdapter
        public final void toJson(JsonWriter jsonWriter, T t) throws IOException {
            JsonAdapter<T> jsonAdapter = this.adapter;
            if (jsonAdapter != null) {
                jsonAdapter.toJson(jsonWriter, t);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public final String toString() {
            JsonAdapter<T> jsonAdapter = this.adapter;
            if (jsonAdapter != null) {
                return jsonAdapter.toString();
            }
            return super.toString();
        }
    }

    /* loaded from: classes3.dex */
    public final class LookupChain {
        public boolean exceptionAnnotated;
        public final ArrayList callLookups = new ArrayList();
        public final ArrayDeque stack = new ArrayDeque();

        public LookupChain() {
        }

        public final IllegalArgumentException exceptionWithLookupStack(IllegalArgumentException illegalArgumentException) {
            if (this.exceptionAnnotated) {
                return illegalArgumentException;
            }
            this.exceptionAnnotated = true;
            ArrayDeque arrayDeque = this.stack;
            if (arrayDeque.size() == 1 && ((Lookup) arrayDeque.getFirst()).fieldName == null) {
                return illegalArgumentException;
            }
            StringBuilder sb = new StringBuilder(illegalArgumentException.getMessage());
            Iterator descendingIterator = arrayDeque.descendingIterator();
            while (descendingIterator.hasNext()) {
                Lookup lookup = (Lookup) descendingIterator.next();
                sb.append("\nfor ");
                sb.append(lookup.type);
                String str = lookup.fieldName;
                if (str != null) {
                    sb.append(' ');
                    sb.append(str);
                }
            }
            return new IllegalArgumentException(sb.toString(), illegalArgumentException);
        }

        public final void pop(boolean z) {
            this.stack.removeLast();
            if (!this.stack.isEmpty()) {
                return;
            }
            Moshi.this.lookupChainThreadLocal.remove();
            if (z) {
                synchronized (Moshi.this.adapterCache) {
                    int size = this.callLookups.size();
                    for (int r1 = 0; r1 < size; r1++) {
                        Lookup lookup = (Lookup) this.callLookups.get(r1);
                        JsonAdapter<T> jsonAdapter = (JsonAdapter) Moshi.this.adapterCache.put(lookup.cacheKey, lookup.adapter);
                        if (jsonAdapter != 0) {
                            lookup.adapter = jsonAdapter;
                            Moshi.this.adapterCache.put(lookup.cacheKey, jsonAdapter);
                        }
                    }
                }
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        BUILT_IN_FACTORIES = arrayList;
        arrayList.add(StandardJsonAdapters.FACTORY);
        arrayList.add(CollectionJsonAdapter.FACTORY);
        arrayList.add(MapJsonAdapter.FACTORY);
        arrayList.add(ArrayJsonAdapter.FACTORY);
        arrayList.add(ClassJsonAdapter.FACTORY);
    }

    public Moshi(Builder builder) {
        ArrayList arrayList = builder.factories;
        int size = arrayList.size();
        ArrayList arrayList2 = BUILT_IN_FACTORIES;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size);
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        this.factories = Collections.unmodifiableList(arrayList3);
    }

    public final <T> JsonAdapter<T> adapter(Type type, Set<? extends Annotation> set, String str) {
        Object asList;
        Lookup lookup;
        if (type != null) {
            if (set != null) {
                Type canonicalize = Util.canonicalize(type);
                if (set.isEmpty()) {
                    asList = canonicalize;
                } else {
                    asList = Arrays.asList(canonicalize, set);
                }
                synchronized (this.adapterCache) {
                    JsonAdapter<T> jsonAdapter = (JsonAdapter) this.adapterCache.get(asList);
                    if (jsonAdapter != null) {
                        return jsonAdapter;
                    }
                    LookupChain lookupChain = this.lookupChainThreadLocal.get();
                    if (lookupChain == null) {
                        lookupChain = new LookupChain();
                        this.lookupChainThreadLocal.set(lookupChain);
                    }
                    ArrayList arrayList = lookupChain.callLookups;
                    int size = arrayList.size();
                    int r5 = 0;
                    while (true) {
                        ArrayDeque arrayDeque = lookupChain.stack;
                        if (r5 < size) {
                            lookup = (Lookup) arrayList.get(r5);
                            if (lookup.cacheKey.equals(asList)) {
                                arrayDeque.add(lookup);
                                JsonAdapter<T> jsonAdapter2 = lookup.adapter;
                                if (jsonAdapter2 != null) {
                                    lookup = jsonAdapter2;
                                }
                            } else {
                                r5++;
                            }
                        } else {
                            Lookup lookup2 = new Lookup(canonicalize, str, asList);
                            arrayList.add(lookup2);
                            arrayDeque.add(lookup2);
                            lookup = null;
                            break;
                        }
                    }
                    try {
                        if (lookup != null) {
                            return lookup;
                        }
                        try {
                            int size2 = this.factories.size();
                            for (int r0 = 0; r0 < size2; r0++) {
                                JsonAdapter<T> jsonAdapter3 = (JsonAdapter<T>) this.factories.get(r0).create(canonicalize, set, this);
                                if (jsonAdapter3 != null) {
                                    ((Lookup) lookupChain.stack.getLast()).adapter = jsonAdapter3;
                                    lookupChain.pop(true);
                                    return jsonAdapter3;
                                }
                            }
                            throw new IllegalArgumentException("No JsonAdapter for " + Util.typeAnnotatedWithAnnotations(canonicalize, set));
                        } catch (IllegalArgumentException e) {
                            throw lookupChain.exceptionWithLookupStack(e);
                        }
                    } finally {
                        lookupChain.pop(false);
                    }
                }
            }
            throw new NullPointerException("annotations == null");
        }
        throw new NullPointerException("type == null");
    }
}
