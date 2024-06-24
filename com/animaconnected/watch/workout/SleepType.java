package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.SleepTypeSerializer;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataClasses.kt */
@Serializable(with = SleepTypeSerializer.class)
/* loaded from: classes3.dex */
public final class SleepType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SleepType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final int value;
    public static final SleepType AWAKE = new SleepType("AWAKE", 0, 0);
    public static final SleepType LIGHT = new SleepType("LIGHT", 1, 1);
    public static final SleepType DEEP = new SleepType("DEEP", 2, 2);

    /* compiled from: WorkoutDataClasses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SleepType.$cachedSerializer$delegate.getValue();
        }

        public final SleepType parse(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = SleepType.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SleepType) obj).getValue() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (SleepType) obj;
        }

        public final KSerializer<SleepType> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SleepType[] $values() {
        return new SleepType[]{AWAKE, LIGHT, DEEP};
    }

    static {
        SleepType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.workout.SleepType.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return SleepTypeSerializer.INSTANCE;
            }
        });
    }

    private SleepType(String str, int r2, int r3) {
        this.value = r3;
    }

    public static EnumEntries<SleepType> getEntries() {
        return $ENTRIES;
    }

    public static SleepType valueOf(String str) {
        return (SleepType) Enum.valueOf(SleepType.class, str);
    }

    public static SleepType[] values() {
        return (SleepType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
