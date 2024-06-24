package com.amplifyframework.core.model;

import com.amplifyframework.AmplifyException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public interface ModelProvider {
    default Set<String> customTypeNames() {
        return new HashSet();
    }

    default Map<String, CustomTypeSchema> customTypeSchemas() {
        return new HashMap();
    }

    default Set<String> modelNames() {
        HashSet hashSet = new HashSet();
        if (models() == null) {
            return hashSet;
        }
        Iterator<Class<? extends Model>> it = models().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getSimpleName());
        }
        return hashSet;
    }

    default Map<String, ModelSchema> modelSchemas() {
        HashMap hashMap = new HashMap();
        if (models() == null) {
            return hashMap;
        }
        for (Class<? extends Model> cls : models()) {
            try {
                hashMap.put(cls.getSimpleName(), ModelSchema.fromModelClass(cls));
            } catch (AmplifyException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    Set<Class<? extends Model>> models();

    String version();
}
