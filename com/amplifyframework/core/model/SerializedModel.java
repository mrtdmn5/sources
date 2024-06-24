package com.amplifyframework.core.model;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.ModelIdentifier;
import com.amplifyframework.util.Immutable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class SerializedModel implements Model {
    private final Serializable modelId;
    private final ModelSchema modelSchema;
    private final Map<String, Object> serializedData;

    /* loaded from: classes.dex */
    public static final class Builder implements BuilderSteps.SerializedDataStep, BuilderSteps.ModelSchemaStep, BuilderSteps.BuildStep {
        private String id;
        private ModelSchema modelSchema;
        private final Map<String, Object> serializedData;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.amplifyframework.core.model.SerializedModel.BuilderSteps.BuildStep
        public SerializedModel build() {
            return new SerializedModel(this.id, Immutable.of(this.serializedData), this.modelSchema);
        }

        @Override // com.amplifyframework.core.model.SerializedModel.BuilderSteps.ModelSchemaStep
        public BuilderSteps.SerializedDataStep modelSchema(ModelSchema modelSchema) {
            this.modelSchema = modelSchema;
            return this;
        }

        @Override // com.amplifyframework.core.model.SerializedModel.BuilderSteps.SerializedDataStep
        public BuilderSteps.BuildStep serializedData(Map<String, Object> map) {
            Map<String, Object> map2 = this.serializedData;
            Objects.requireNonNull(map);
            map2.putAll(map);
            this.id = ModelIdentifier.Helper.getUniqueKey(this.modelSchema, map);
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
            SerializedModel build();
        }

        /* loaded from: classes.dex */
        public interface ModelSchemaStep {
            SerializedDataStep modelSchema(ModelSchema modelSchema);
        }

        /* loaded from: classes.dex */
        public interface SerializedDataStep {
            BuildStep serializedData(Map<String, Object> map);
        }
    }

    public /* synthetic */ SerializedModel(Serializable serializable, Map map, ModelSchema modelSchema, AnonymousClass1 anonymousClass1) {
        this(serializable, map, modelSchema);
    }

    public static BuilderSteps.ModelSchemaStep builder() {
        return new Builder();
    }

    public static <T extends Model> SerializedModel create(T t, ModelSchema modelSchema) throws AmplifyException {
        return builder().modelSchema(modelSchema).serializedData(ModelConverter.toMap(t, modelSchema)).build();
    }

    public static <T extends Model> SerializedModel difference(T t, T t2, ModelSchema modelSchema) throws AmplifyException {
        if (t2 == null) {
            return create(t, modelSchema);
        }
        Map<String, Object> map = ModelConverter.toMap(t, modelSchema);
        Map<String, Object> map2 = ModelConverter.toMap(t2, modelSchema);
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            HashSet hashSet = new HashSet();
            hashSet.add(PrimaryKey.fieldName());
            hashSet.addAll(modelSchema.getPrimaryIndexFields());
            if (hashSet.contains(str) || !ObjectsCompat$Api19Impl.equals(map2.get(str), map.get(str))) {
                hashMap.put(str, map.get(str));
            }
        }
        return builder().modelSchema(modelSchema).serializedData(hashMap).build();
    }

    public static SerializedModel merge(SerializedModel serializedModel, SerializedModel serializedModel2, ModelSchema modelSchema) {
        HashMap hashMap = new HashMap(serializedModel.serializedData);
        for (String str : serializedModel2.getSerializedData().keySet()) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, serializedModel2.getSerializedData().get(str));
            }
        }
        return builder().modelSchema(modelSchema).serializedData(hashMap).build();
    }

    public static Map<String, Object> parseSerializedData(Map<String, Object> map, String str, SchemaRegistry schemaRegistry) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ModelField> entry : schemaRegistry.getModelSchemaForModelClass(str).getFields().entrySet()) {
            String key = entry.getKey();
            ModelField value = entry.getValue();
            if (map.containsKey(key)) {
                Object obj = map.get(key);
                if (obj == null) {
                    hashMap.put(key, null);
                } else if (value.isModel()) {
                    ModelSchema modelSchemaForModelClass = schemaRegistry.getModelSchemaForModelClass(value.getTargetType());
                    Map<String, Object> map2 = (Map) map.get(key);
                    if (map2 != null) {
                        hashMap.put(key, builder().modelSchema(modelSchemaForModelClass).serializedData(map2).build());
                    }
                } else if (value.isCustomType()) {
                    if (value.isArray()) {
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList();
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(SerializedCustomType.builder().serializedData(SerializedCustomType.parseSerializedData((Map) it.next(), value.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(value.getTargetType())).build());
                            }
                        }
                        hashMap.put(key, arrayList);
                    } else {
                        hashMap.put(key, SerializedCustomType.builder().serializedData(SerializedCustomType.parseSerializedData((Map) obj, value.getTargetType(), schemaRegistry)).customTypeSchema(schemaRegistry.getCustomTypeSchemaForCustomTypeClass(value.getTargetType())).build());
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
        if (obj == null || SerializedModel.class != obj.getClass()) {
            return false;
        }
        SerializedModel serializedModel = (SerializedModel) obj;
        if (ObjectsCompat$Api19Impl.equals(this.modelId, serializedModel.modelId) && ObjectsCompat$Api19Impl.equals(this.serializedData, serializedModel.serializedData) && ObjectsCompat$Api19Impl.equals(this.modelSchema, serializedModel.modelSchema)) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.core.model.Model
    public String getModelName() {
        ModelSchema modelSchema = this.modelSchema;
        if (modelSchema == null) {
            return null;
        }
        return modelSchema.getName();
    }

    public ModelSchema getModelSchema() {
        return this.modelSchema;
    }

    public Map<String, Object> getSerializedData() {
        return this.serializedData;
    }

    public Object getValue(ModelField modelField) {
        return this.serializedData.get(modelField.getName());
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.modelId, this.serializedData, this.modelSchema);
    }

    @Override // com.amplifyframework.core.model.Model
    public Serializable resolveIdentifier() {
        return this.modelId;
    }

    public String toString() {
        return "SerializedModel{id='" + this.modelId + "', serializedData=" + this.serializedData + ", modelName=" + getModelName() + '}';
    }

    private SerializedModel(Serializable serializable, Map<String, Object> map, ModelSchema modelSchema) {
        this.modelId = serializable;
        this.serializedData = map;
        this.modelSchema = modelSchema;
    }
}
