package com.j256.ormlite.db;

import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.converter.BooleanNumberFieldConverter;

/* loaded from: classes3.dex */
public abstract class BaseSqliteDatabaseType extends BaseDatabaseType {
    public static final BooleanNumberFieldConverter booleanConverter = new BooleanNumberFieldConverter();

    /* renamed from: com.j256.ormlite.db.BaseSqliteDatabaseType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] r0 = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = r0;
            try {
                r0[SqlType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
