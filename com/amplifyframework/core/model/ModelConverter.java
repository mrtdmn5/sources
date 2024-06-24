package com.amplifyframework.core.model;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.amplifyframework.AmplifyException;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class ModelConverter {
    private ModelConverter() {
    }

    private static Map<String, Object> extractAssociateId(ModelField modelField, Model model, ModelSchema modelSchema) throws AmplifyException {
        Object extractFieldValue = extractFieldValue(modelField.getName(), model, modelSchema);
        if (modelField.isModel() && (extractFieldValue instanceof Model)) {
            Model model2 = (Model) extractFieldValue;
            ModelSchema modelSchemaForModelClass = SchemaRegistry.instance().getModelSchemaForModelClass(model2.getModelName());
            HashMap hashMap = new HashMap();
            if (modelSchemaForModelClass.getPrimaryIndexFields().size() > 1 && (model2.resolveIdentifier() instanceof ModelIdentifier)) {
                ModelIdentifier modelIdentifier = (ModelIdentifier) model2.resolveIdentifier();
                ListIterator<String> listIterator = modelSchemaForModelClass.getPrimaryIndexFields().listIterator();
                hashMap.put(listIterator.next(), modelIdentifier.key());
                ListIterator<? extends Serializable> listIterator2 = modelIdentifier.sortedKeys().listIterator();
                while (listIterator.hasNext()) {
                    hashMap.put(listIterator.next(), listIterator2.next());
                }
                return hashMap;
            }
            if (modelSchemaForModelClass.getPrimaryIndexFields().size() > 1 && (model2 instanceof SerializedModel)) {
                for (String str : modelSchemaForModelClass.getPrimaryIndexFields()) {
                    hashMap.put(str, ((SerializedModel) model2).getSerializedData().get(str));
                }
                return hashMap;
            }
            return Collections.singletonMap(modelSchemaForModelClass.getPrimaryIndexFields().get(0), model2.getPrimaryKeyString());
        }
        if (modelField.isModel() && (extractFieldValue instanceof Map)) {
            return Collections.singletonMap(ConfigurationItem.COLUMN_NAME_ID, ((Map) extractFieldValue).get(ConfigurationItem.COLUMN_NAME_ID));
        }
        if (modelField.isModel() && extractFieldValue == null) {
            return null;
        }
        throw new IllegalStateException("Associated data is not a Model or Map.");
    }

    private static Object extractFieldValue(String str, Model model, ModelSchema modelSchema) throws AmplifyException {
        if (model instanceof SerializedModel) {
            return ((SerializedModel) model).getSerializedData().get(str);
        }
        try {
            Field declaredField = model.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(model);
        } catch (Exception e) {
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("An invalid field was provided. ", str, " is not present in ");
            m.append(modelSchema.getName());
            throw new AmplifyException(m.toString(), e, "Check if this model schema is a correct representation of the fields in the provided Object");
        }
    }

    public static <T extends Model> Map<String, Object> toMap(T t, ModelSchema modelSchema) throws AmplifyException {
        SchemaRegistry instance = SchemaRegistry.instance();
        HashMap hashMap = new HashMap();
        for (ModelField modelField : modelSchema.getFields().values()) {
            String name = modelField.getName();
            String targetType = modelField.getTargetType();
            ModelAssociation modelAssociation = modelSchema.getAssociations().get(name);
            if (modelAssociation == null) {
                if (!(t instanceof SerializedModel) || ((SerializedModel) t).getSerializedData().containsKey(modelField.getName())) {
                    hashMap.put(name, extractFieldValue(modelField.getName(), t, modelSchema));
                }
            } else if (modelAssociation.isOwner()) {
                ModelSchema modelSchemaForModelClass = instance.getModelSchemaForModelClass(targetType);
                Map<String, Object> extractAssociateId = extractAssociateId(modelField, t, modelSchema);
                if (extractAssociateId != null) {
                    hashMap.put(name, SerializedModel.builder().modelSchema(modelSchemaForModelClass).serializedData(extractAssociateId).build());
                }
            }
        }
        return hashMap;
    }
}
