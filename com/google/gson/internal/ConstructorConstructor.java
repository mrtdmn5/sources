package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes3.dex */
public final class ConstructorConstructor {
    public final Map<Type, InstanceCreator<?>> instanceCreators;
    public final List<ReflectionAccessFilter> reflectionFilters;
    public final boolean useJdkUnsafe = true;

    /* renamed from: com.google.gson.internal.ConstructorConstructor$12, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass12 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object construct() {
            return new ArrayDeque();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$14, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass14 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object construct() {
            return new ConcurrentSkipListMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$16, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass16 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object construct() {
            return new TreeMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$17, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass17 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object construct() {
            return new LinkedHashMap();
        }
    }

    public ConstructorConstructor(List list, Map map) {
        this.instanceCreators = map;
        this.reflectionFilters = list;
    }

    public static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> com.google.gson.internal.ObjectConstructor<T> get(com.google.gson.reflect.TypeToken<T> r9) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.get(com.google.gson.reflect.TypeToken):com.google.gson.internal.ObjectConstructor");
    }

    public final String toString() {
        return this.instanceCreators.toString();
    }
}
