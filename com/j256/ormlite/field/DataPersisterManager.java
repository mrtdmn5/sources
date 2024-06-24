package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class DataPersisterManager {
    public static final EnumStringType DEFAULT_ENUM_PERSISTER = EnumStringType.singleTon;
    public static final HashMap builtInMap = new HashMap();

    static {
        for (DataType dataType : DataType.values()) {
            DataPersister dataPersister = dataType.getDataPersister();
            if (dataPersister != null) {
                for (Class<?> cls : dataPersister.getAssociatedClasses()) {
                    builtInMap.put(cls.getName(), dataPersister);
                }
                if (dataPersister.getAssociatedClassNames() != null) {
                    for (String str : dataPersister.getAssociatedClassNames()) {
                        builtInMap.put(str, dataPersister);
                    }
                }
            }
        }
    }

    public static DataPersister lookupForField(Field field) {
        DataPersister dataPersister = (DataPersister) builtInMap.get(field.getType().getName());
        if (dataPersister != null) {
            return dataPersister;
        }
        if (field.getType().isEnum()) {
            return DEFAULT_ENUM_PERSISTER;
        }
        return null;
    }
}
