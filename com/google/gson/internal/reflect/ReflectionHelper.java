package com.google.gson.internal.reflect;

import com.amplifyframework.core.model.ModelIdentifier;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class ReflectionHelper {
    public static final RecordHelper RECORD_HELPER;

    /* loaded from: classes3.dex */
    public static abstract class RecordHelper {
        public abstract Method getAccessor(Class<?> cls, Field field);

        public abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls);

        public abstract String[] getRecordComponentNames(Class<?> cls);

        public abstract boolean isRecord(Class<?> cls);
    }

    /* loaded from: classes3.dex */
    public static class RecordNotSupportedHelper extends RecordHelper {
        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final Method getAccessor(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final String[] getRecordComponentNames(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final boolean isRecord(Class<?> cls) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class RecordSupportedHelper extends RecordHelper {
        public final Method getName;
        public final Method getRecordComponents;
        public final Method getType;
        public final Method isRecord = Class.class.getMethod("isRecord", new Class[0]);

        public RecordSupportedHelper() throws NoSuchMethodException {
            Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.getRecordComponents = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.getName = componentType.getMethod("getName", new Class[0]);
            this.getType = componentType.getMethod("getType", new Class[0]);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final Method getAccessor(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int r3 = 0; r3 < objArr.length; r3++) {
                    clsArr[r3] = (Class) this.getType.invoke(objArr[r3], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final String[] getRecordComponentNames(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int r2 = 0; r2 < objArr.length; r2++) {
                    strArr[r2] = (String) this.getName.invoke(objArr[r2], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public final boolean isRecord(Class<?> cls) {
            try {
                return ((Boolean) this.isRecord.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            }
        }
    }

    static {
        RecordHelper recordNotSupportedHelper;
        try {
            recordNotSupportedHelper = new RecordSupportedHelper();
        } catch (NoSuchMethodException unused) {
            recordNotSupportedHelper = new RecordNotSupportedHelper();
        }
        RECORD_HELPER = recordNotSupportedHelper;
    }

    public static void appendExecutableParameters(AccessibleObject accessibleObject, StringBuilder sb) {
        Class<?>[] parameterTypes;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            parameterTypes = ((Method) accessibleObject).getParameterTypes();
        } else {
            parameterTypes = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int r0 = 0; r0 < parameterTypes.length; r0++) {
            if (r0 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[r0].getSimpleName());
        }
        sb.append(')');
    }

    public static String constructorToString(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        appendExecutableParameters(constructor, sb);
        return sb.toString();
    }

    public static String fieldToString(Field field) {
        return field.getDeclaringClass().getName() + ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER + field.getName();
    }

    public static String getAccessibleObjectDescription(AccessibleObject accessibleObject, boolean z) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + fieldToString((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            appendExecutableParameters(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + constructorToString((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (z && Character.isLowerCase(str.charAt(0))) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    public static void makeAccessible(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e) {
            throw new JsonIOException(zzav$$ExternalSyntheticOutline0.m("Failed making ", getAccessibleObjectDescription(accessibleObject, false), " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type."), e);
        }
    }
}
