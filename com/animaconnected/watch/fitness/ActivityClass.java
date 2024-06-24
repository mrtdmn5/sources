package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class ActivityClass {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActivityClass[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final ActivityClass Rest = new ActivityClass("Rest", 0, 0);
    public static final ActivityClass Other = new ActivityClass("Other", 1, 1);
    public static final ActivityClass Walk = new ActivityClass("Walk", 2, 2);
    public static final ActivityClass Run = new ActivityClass("Run", 3, 3);
    public static final ActivityClass Swim = new ActivityClass("Swim", 4, 4);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActivityClass fromId(final Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = ActivityClass.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((ActivityClass) obj).getId();
                    if (num != null && id == num.intValue()) {
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
            ActivityClass activityClass = (ActivityClass) obj;
            if (activityClass == null) {
                final ActivityClass activityClass2 = ActivityClass.Other;
                LogKt.warn$default((Object) ActivityClass.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.ActivityClass$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid ActivityClass id: " + num + ", defaulting to " + activityClass2;
                    }
                }, 7, (Object) null);
                return activityClass2;
            }
            return activityClass;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ActivityClass[] $values() {
        return new ActivityClass[]{Rest, Other, Walk, Run, Swim};
    }

    static {
        ActivityClass[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private ActivityClass(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<ActivityClass> getEntries() {
        return $ENTRIES;
    }

    public static ActivityClass valueOf(String str) {
        return (ActivityClass) Enum.valueOf(ActivityClass.class, str);
    }

    public static ActivityClass[] values() {
        return (ActivityClass[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
