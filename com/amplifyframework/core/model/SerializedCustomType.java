package com.amplifyframework.core.model;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class SerializedCustomType {
    private final CustomTypeSchema customTypeSchema;
    private final Map<String, Object> serializedData;

    /* loaded from: classes.dex */
    public static final class Builder implements BuilderSteps.SerializedDataStep, BuilderSteps.CustomTypeSchemaStep, BuilderSteps.BuildStep {
        private CustomTypeSchema customTypeSchema;
        private final Map<String, Object> serializedData;

        @Override // com.amplifyframework.core.model.SerializedCustomType.BuilderSteps.BuildStep
        public SerializedCustomType build() {
            return new SerializedCustomType(Immutable.of(this.serializedData), this.customTypeSchema);
        }

        @Override // com.amplifyframework.core.model.SerializedCustomType.BuilderSteps.CustomTypeSchemaStep
        public BuilderSteps.BuildStep customTypeSchema(CustomTypeSchema customTypeSchema) {
            this.customTypeSchema = customTypeSchema;
            return this;
        }

        @Override // com.amplifyframework.core.model.SerializedCustomType.BuilderSteps.SerializedDataStep
        public BuilderSteps.CustomTypeSchemaStep serializedData(Map<String, Object> map) {
            Map<String, Object> map2 = this.serializedData;
            Objects.requireNonNull(map);
            map2.putAll(map);
            return this;
        }

        private Builder() {
            this.serializedData = new HashMap();
        }
    }

    /* loaded from: classes.dex */
    public interface BuilderSteps {

        /* loaded from: classes.dex */
        public interface BuildStep {
            SerializedCustomType build();
        }

        /* loaded from: classes.dex */
        public interface CustomTypeSchemaStep {
            BuildStep customTypeSchema(CustomTypeSchema customTypeSchema);
        }

        /* loaded from: classes.dex */
        public interface SerializedDataStep {
            CustomTypeSchemaStep serializedData(Map<String, Object> map);
        }
    }

    public static BuilderSteps.SerializedDataStep builder() {
        return new Builder();
    }

    public static Map<String, Object> parseSerializedData(Map<String, Object> map, String str, SchemaRegistry schemaRegistry) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, CustomTypeField> entry : schemaRegistry.getCustomTypeSchemaForCustomTypeClass(str).getFields().entrySet()) {
            String key = entry.getKey();
            CustomTypeField value = entry.getValue();
            if (map.containsKey(key)) {
                Object obj = map.get(key);
                if (obj == null) {
                    hashMap.put(key, null);
                } else if (value.isCustomType()) {
                    schemaRegistry.getCustomTypeSchemaForCustomTypeClass(value.getTargetType());
                    if (value.isArray()) {
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList();
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(builder().serializedData(parseSerializedData((Map) it.next(), value.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(value.getTargetType())).build());
                            }
                        }
                        hashMap.put(key, arrayList);
                    } else {
                        hashMap.put(key, builder().serializedData(parseSerializedData((Map) obj, value.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(value.getTargetType())).build());
                    }
                } else {
                    hashMap.put(key, obj);
                }
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SerializedCustomType.class != obj.getClass()) {
            return false;
        }
        SerializedCustomType serializedCustomType = (SerializedCustomType) obj;
        if (ObjectsCompat$Api19Impl.equals(this.serializedData, serializedCustomType.serializedData) && ObjectsCompat$Api19Impl.equals(this.customTypeSchema, serializedCustomType.customTypeSchema)) {
            return true;
        }
        return false;
    }

    public String getCustomTypeName() {
        CustomTypeSchema customTypeSchema = this.customTypeSchema;
        if (customTypeSchema == null) {
            return null;
        }
        return customTypeSchema.getName();
    }

    public CustomTypeSchema getCustomTypeSchema() {
        return this.customTypeSchema;
    }

    public Map<String, Object> getSerializedData() {
        return this.serializedData;
    }

    public Object getValue(ModelField modelField) {
        return this.serializedData.get(modelField.getName());
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.serializedData, this.customTypeSchema);
    }

    public String toString() {
        return "SerializedCustomType{serializedData=" + this.serializedData + ", customTypeName=" + getCustomTypeSchema() + '}';
    }

    private SerializedCustomType(Map<String, Object> map, CustomTypeSchema customTypeSchema) {
        this.serializedData = map;
        this.customTypeSchema = customTypeSchema;
    }
}
