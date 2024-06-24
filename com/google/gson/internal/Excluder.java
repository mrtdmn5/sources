package com.google.gson.internal;

import com.animaconnected.secondo.R;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    public final double version = -1.0d;
    public final int modifiers = R.styleable.AppTheme_stepsHistoryColumnColorDetail;
    public final boolean serializeInnerClasses = true;
    public final List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    public final List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    public static boolean isAnonymousOrNonStaticLocal(Class cls) {
        boolean z;
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        if ((cls.getModifiers() & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        if (!cls.isAnonymousClass() && !cls.isLocalClass()) {
            return false;
        }
        return true;
    }

    public final Object clone() throws CloneNotSupportedException {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final boolean z;
        final boolean z2;
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, true)) {
            z = false;
        } else {
            z = true;
        }
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z && !z2) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            public TypeAdapter<T> delegate;

            @Override // com.google.gson.TypeAdapter
            public final T read(JsonReader jsonReader) throws IOException {
                if (z2) {
                    jsonReader.skipValue();
                    return null;
                }
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = typeAdapter;
                }
                return typeAdapter.read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, T t) throws IOException {
                if (z) {
                    jsonWriter.nullValue();
                    return;
                }
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = typeAdapter;
                }
                typeAdapter.write(jsonWriter, t);
            }
        };
    }

    public final boolean excludeClassChecks(Class<?> cls) {
        boolean z;
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses) {
            boolean z2 = false;
            if (cls.isMemberClass()) {
                if ((cls.getModifiers() & 8) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    z2 = true;
                }
            }
            if (z2) {
                return true;
            }
        }
        return isAnonymousOrNonStaticLocal(cls);
    }

    public final boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        List<ExclusionStrategy> list;
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isValidVersion(Since since, Until until) {
        boolean z;
        boolean z2;
        double d = this.version;
        if (since != null && d < since.value()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        if (until != null && d >= until.value()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return false;
        }
        return true;
    }
}
