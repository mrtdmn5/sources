package com.amplifyframework.core.model;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelField;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.HasOne;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.Indexes;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.util.FieldFinder;
import com.amplifyframework.util.Immutable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class ModelSchema {
    private final Map<String, ModelAssociation> associations;
    private final List<AuthRule> authRules;
    private final Map<String, ModelField> fields;
    private final Map<String, ModelIndex> indexes;
    private final String listPluralName;
    private final Class<? extends Model> modelClass;
    private final int modelSchemaVersion;
    private final Model.Type modelType;
    private final String name;
    private final String pluralName;
    private final String syncPluralName;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String listPluralName;
        private Class<? extends Model> modelClass;
        private int modelSchemaVersion;
        private String name;
        private String pluralName;
        private String syncPluralName;
        private Model.Type type;
        private final List<AuthRule> authRules = new ArrayList();
        private final Map<String, ModelField> fields = new TreeMap();
        private final Map<String, ModelAssociation> associations = new TreeMap();
        private final Map<String, ModelIndex> indexes = new TreeMap();

        public Builder associations(Map<String, ModelAssociation> map) {
            Objects.requireNonNull(map);
            this.associations.clear();
            this.associations.putAll(map);
            return this;
        }

        public Builder authRules(List<AuthRule> list) {
            Objects.requireNonNull(list);
            this.authRules.clear();
            this.authRules.addAll(list);
            return this;
        }

        @SuppressLint({"SyntheticAccessor"})
        public ModelSchema build() {
            Objects.requireNonNull(this.name);
            return new ModelSchema(this);
        }

        public Builder fields(Map<String, ModelField> map) {
            Objects.requireNonNull(map);
            this.fields.clear();
            this.fields.putAll(map);
            return this;
        }

        public Builder indexes(Map<String, ModelIndex> map) {
            Objects.requireNonNull(map);
            this.indexes.clear();
            this.indexes.putAll(map);
            return this;
        }

        public Builder listPluralName(String str) {
            this.listPluralName = str;
            return this;
        }

        public Builder modelClass(Class<? extends Model> cls) {
            this.modelClass = cls;
            return this;
        }

        public Builder modelType(Model.Type type) {
            this.type = type;
            return this;
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder pluralName(String str) {
            this.pluralName = str;
            return this;
        }

        public Builder syncPluralName(String str) {
            this.syncPluralName = str;
            return this;
        }

        public Builder version(int r1) {
            this.modelSchemaVersion = r1;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static ModelAssociation createModelAssociation(Field field) {
        if (field.isAnnotationPresent(BelongsTo.class)) {
            BelongsTo belongsTo = (BelongsTo) field.getAnnotation(BelongsTo.class);
            Objects.requireNonNull(belongsTo);
            BelongsTo belongsTo2 = belongsTo;
            return ModelAssociation.builder().name("BelongsTo").targetName(belongsTo2.targetName()).targetNames(belongsTo2.targetNames()).associatedType(belongsTo2.type().getSimpleName()).associatedName(field.getName()).build();
        }
        if (field.isAnnotationPresent(HasOne.class)) {
            HasOne hasOne = (HasOne) field.getAnnotation(HasOne.class);
            Objects.requireNonNull(hasOne);
            HasOne hasOne2 = hasOne;
            return ModelAssociation.builder().name("HasOne").associatedName(hasOne2.associatedWith()).associatedType(hasOne2.type().getSimpleName()).build();
        }
        if (field.isAnnotationPresent(HasMany.class)) {
            HasMany hasMany = (HasMany) field.getAnnotation(HasMany.class);
            Objects.requireNonNull(hasMany);
            HasMany hasMany2 = hasMany;
            return ModelAssociation.builder().name("HasMany").associatedName(hasMany2.associatedWith()).associatedType(hasMany2.type().getSimpleName()).build();
        }
        return null;
    }

    private static ModelField createModelField(Field field) {
        com.amplifyframework.core.model.annotations.ModelField modelField = (com.amplifyframework.core.model.annotations.ModelField) field.getAnnotation(com.amplifyframework.core.model.annotations.ModelField.class);
        if (modelField != null) {
            String name = field.getName();
            Class<?> type = field.getType();
            String targetType = modelField.targetType();
            ArrayList arrayList = new ArrayList();
            for (com.amplifyframework.core.model.annotations.AuthRule authRule : modelField.authRules()) {
                arrayList.add(new AuthRule(authRule));
            }
            ModelField.ModelFieldBuilder javaClassForValue = ModelField.builder().name(name).javaClassForValue(type);
            if (targetType.isEmpty()) {
                targetType = type.getSimpleName();
            }
            return javaClassForValue.targetType(targetType).isReadOnly(modelField.isReadOnly()).isRequired(modelField.isRequired()).isArray(Collection.class.isAssignableFrom(field.getType())).isEnum(Enum.class.isAssignableFrom(field.getType())).isModel(Model.class.isAssignableFrom(field.getType())).authRules(arrayList).build();
        }
        return null;
    }

    private static ModelIndex createModelIndex(Index index) {
        return ModelIndex.builder().indexName(index.name()).indexFieldNames(Arrays.asList(index.fields())).build();
    }

    public static ModelSchema fromModelClass(Class<? extends Model> cls) throws AmplifyException {
        String str;
        Model.Type type;
        String str2;
        int r13;
        try {
            List<Field> findModelFieldsIn = FieldFinder.findModelFieldsIn(cls);
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            TreeMap treeMap3 = new TreeMap();
            ArrayList arrayList = new ArrayList();
            ModelConfig modelConfig = (ModelConfig) cls.getAnnotation(ModelConfig.class);
            String simpleName = cls.getSimpleName();
            String str3 = null;
            if (modelConfig != null && !modelConfig.pluralName().isEmpty()) {
                str = modelConfig.pluralName();
            } else {
                str = null;
            }
            if (modelConfig != null) {
                type = modelConfig.type();
            } else {
                type = Model.Type.USER;
            }
            if (modelConfig != null && !modelConfig.listPluralName().isEmpty()) {
                str2 = modelConfig.listPluralName();
            } else {
                str2 = null;
            }
            if (modelConfig != null && !modelConfig.syncPluralName().isEmpty()) {
                str3 = modelConfig.syncPluralName();
            }
            if (modelConfig != null) {
                r13 = modelConfig.version();
            } else {
                r13 = 0;
            }
            if (modelConfig != null) {
                com.amplifyframework.core.model.annotations.AuthRule[] authRules = modelConfig.authRules();
                int length = authRules.length;
                int r15 = 0;
                while (r15 < length) {
                    arrayList.add(new AuthRule(authRules[r15]));
                    r15++;
                    authRules = authRules;
                }
            }
            Annotation[] annotations = cls.getAnnotations();
            int length2 = annotations.length;
            int r14 = 0;
            while (r14 < length2) {
                Annotation annotation = annotations[r14];
                Annotation[] annotationArr = annotations;
                int r17 = length2;
                if (annotation.annotationType().isAssignableFrom(Indexes.class)) {
                    Index[] value = ((Indexes) annotation).value();
                    int length3 = value.length;
                    int r152 = 0;
                    while (r152 < length3) {
                        Index[] indexArr = value;
                        ModelIndex createModelIndex = createModelIndex(value[r152]);
                        treeMap3.put(createModelIndex.getIndexName(), createModelIndex);
                        r152++;
                        length3 = length3;
                        value = indexArr;
                    }
                } else if (annotation.annotationType().isAssignableFrom(Index.class)) {
                    ModelIndex createModelIndex2 = createModelIndex((Index) annotation);
                    treeMap3.put(createModelIndex2.getIndexName(), createModelIndex2);
                }
                r14++;
                annotations = annotationArr;
                length2 = r17;
            }
            for (Field field : findModelFieldsIn) {
                ModelField createModelField = createModelField(field);
                if (createModelField != null) {
                    treeMap.put(field.getName(), createModelField);
                }
                ModelAssociation createModelAssociation = createModelAssociation(field);
                if (createModelAssociation != null) {
                    treeMap2.put(field.getName(), createModelAssociation);
                }
            }
            return builder().name(simpleName).pluralName(str).listPluralName(str2).syncPluralName(str3).authRules(arrayList).fields(treeMap).associations(treeMap2).indexes(treeMap3).modelClass(cls).modelType(type).version(r13).build();
        } catch (Exception e) {
            throw new AmplifyException("Error in constructing a ModelSchema.", e, "Sorry, we don't have a suggested fix for this error yet.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelSchema.class != obj.getClass()) {
            return false;
        }
        ModelSchema modelSchema = (ModelSchema) obj;
        if (ObjectsCompat$Api19Impl.equals(getName(), modelSchema.getName()) && ObjectsCompat$Api19Impl.equals(getPluralName(), modelSchema.getPluralName()) && ObjectsCompat$Api19Impl.equals(getListPluralName(), modelSchema.getListPluralName()) && ObjectsCompat$Api19Impl.equals(getSyncPluralName(), modelSchema.getSyncPluralName()) && ObjectsCompat$Api19Impl.equals(getAuthRules(), modelSchema.getAuthRules()) && ObjectsCompat$Api19Impl.equals(getFields(), modelSchema.getFields()) && ObjectsCompat$Api19Impl.equals(getAssociations(), modelSchema.getAssociations()) && ObjectsCompat$Api19Impl.equals(getIndexes(), modelSchema.getIndexes()) && ObjectsCompat$Api19Impl.equals(getModelClass(), modelSchema.getModelClass())) {
            return true;
        }
        return false;
    }

    public Map<String, ModelAssociation> getAssociations() {
        return Immutable.of(this.associations);
    }

    public List<AuthRule> getAuthRules() {
        return this.authRules;
    }

    public Map<String, ModelField> getFields() {
        return this.fields;
    }

    public Map<String, ModelIndex> getIndexes() {
        return this.indexes;
    }

    public String getListPluralName() {
        return this.listPluralName;
    }

    public Class<? extends Model> getModelClass() {
        return this.modelClass;
    }

    public Model.Type getModelType() {
        return this.modelType;
    }

    public String getName() {
        return this.name;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public List<String> getPrimaryIndexFields() {
        ModelIndex modelIndex = this.indexes.get("undefined");
        if (modelIndex != null && modelIndex.getIndexFieldNames().size() >= 1) {
            return modelIndex.getIndexFieldNames();
        }
        return Arrays.asList(PrimaryKey.fieldName());
    }

    public String getPrimaryKeyName() {
        return getPrimaryIndexFields().get(0);
    }

    public String getSyncPluralName() {
        return this.syncPluralName;
    }

    public int getVersion() {
        return this.modelSchemaVersion;
    }

    public boolean hasModelLevelRules() {
        if (this.authRules.size() > 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getName(), getPluralName(), getListPluralName(), getSyncPluralName(), getAuthRules(), getFields(), getAssociations(), getIndexes(), getModelClass(), Integer.valueOf(getVersion()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelSchema{name='");
        sb.append(this.name);
        sb.append("', pluralName='");
        sb.append(this.pluralName);
        sb.append("', listPluralName='");
        sb.append(this.listPluralName);
        sb.append("', syncPluralName='");
        sb.append(this.syncPluralName);
        sb.append("', authRules=");
        sb.append(this.authRules);
        sb.append(", fields=");
        sb.append(this.fields);
        sb.append(", associations=");
        sb.append(this.associations);
        sb.append(", indexes=");
        sb.append(this.indexes);
        sb.append(", modelClass=");
        sb.append(this.modelClass);
        sb.append(", modelSchemaVersion=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.modelSchemaVersion, '}');
    }

    private ModelSchema(Builder builder) {
        this.name = builder.name;
        this.pluralName = builder.pluralName;
        this.listPluralName = builder.listPluralName;
        this.syncPluralName = builder.syncPluralName;
        this.authRules = builder.authRules;
        this.fields = builder.fields;
        this.associations = builder.associations;
        this.indexes = builder.indexes;
        this.modelClass = builder.modelClass;
        this.modelType = builder.type;
        this.modelSchemaVersion = builder.modelSchemaVersion;
    }
}
