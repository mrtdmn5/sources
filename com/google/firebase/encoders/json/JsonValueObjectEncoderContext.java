package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    public boolean active = true;
    public final ObjectEncoder<Object> fallbackEncoder;
    public final boolean ignoreNullValues;
    public final JsonWriter jsonWriter;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public JsonValueObjectEncoderContext(Writer writer, HashMap hashMap, HashMap hashMap2, JsonDataEncoderBuilder$$ExternalSyntheticLambda0 jsonDataEncoderBuilder$$ExternalSyntheticLambda0, boolean z) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = hashMap;
        this.valueEncoders = hashMap2;
        this.fallbackEncoder = jsonDataEncoderBuilder$$ExternalSyntheticLambda0;
        this.ignoreNullValues = z;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int r3) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(r3);
        return this;
    }

    public final void maybeUnNest() throws IOException {
        if (this.active) {
        } else {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return add(obj, fieldDescriptor.name);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(z);
        return this;
    }

    public final JsonValueObjectEncoderContext add(Object obj, String str) throws IOException {
        boolean z = this.ignoreNullValues;
        JsonWriter jsonWriter = this.jsonWriter;
        if (z) {
            if (obj == null) {
                return this;
            }
            maybeUnNest();
            jsonWriter.name(str);
            return add(obj);
        }
        maybeUnNest();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        return add(obj);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    public final JsonValueObjectEncoderContext add(Object obj) throws IOException {
        JsonWriter jsonWriter = this.jsonWriter;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                maybeUnNest();
                jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
                return this;
            }
            jsonWriter.beginArray();
            int r2 = 0;
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (r2 < length) {
                    jsonWriter.value(r6[r2]);
                    r2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (r2 < length2) {
                    long j = jArr[r2];
                    maybeUnNest();
                    jsonWriter.value(j);
                    r2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (r2 < length3) {
                    jsonWriter.value(dArr[r2]);
                    r2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (r2 < length4) {
                    jsonWriter.value(zArr[r2]);
                    r2++;
                }
            } else if (obj instanceof Number[]) {
                Number[] numberArr = (Number[]) obj;
                int length5 = numberArr.length;
                while (r2 < length5) {
                    add(numberArr[r2]);
                    r2++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length6 = objArr.length;
                while (r2 < length6) {
                    add(objArr[r2]);
                    r2++;
                }
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            jsonWriter.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add(entry.getValue(), (String) key);
                } catch (ClassCastException e) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                }
            }
            jsonWriter.endObject();
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            jsonWriter.beginObject();
            objectEncoder.encode(obj, this);
            jsonWriter.endObject();
            return this;
        }
        ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            valueEncoder.encode(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            String name = ((Enum) obj).name();
            maybeUnNest();
            jsonWriter.value(name);
            return this;
        }
        jsonWriter.beginObject();
        this.fallbackEncoder.encode(obj, this);
        jsonWriter.endObject();
        return this;
    }
}
