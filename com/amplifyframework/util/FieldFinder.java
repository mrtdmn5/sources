package com.amplifyframework.util;

import com.amplifyframework.core.model.SerializedModel;
import com.amplifyframework.core.model.annotations.ModelField;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public final class FieldFinder {
    private FieldFinder() {
    }

    public static Object extractFieldValue(Object obj, String str) throws NoSuchFieldException {
        if (obj instanceof SerializedModel) {
            return ((SerializedModel) obj).getSerializedData().get(str);
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            throw e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<Field> findModelFieldsIn(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(ModelField.class)) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        Collections.sort(arrayList, new FieldFinder$$ExternalSyntheticLambda1());
        return Immutable.of(arrayList);
    }

    public static List<Field> findNonTransientFieldsIn(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers())) {
                    arrayList.add(field);
                }
            }
            cls = cls.getSuperclass();
        }
        Collections.sort(arrayList, Comparator.comparing(new FieldFinder$$ExternalSyntheticLambda0()));
        return Immutable.of(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$findModelFieldsIn$0(Field field, Field field2) {
        return field.getName().compareTo(field2.getName());
    }
}
