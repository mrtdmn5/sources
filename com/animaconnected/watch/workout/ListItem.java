package com.animaconnected.watch.workout;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WorkoutDataClasses.kt */
@Serializable
/* loaded from: classes3.dex */
public abstract class ListItem {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.workout.ListItem.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.animaconnected.watch.workout.ListItem", Reflection.getOrCreateKotlinClass(ListItem.class), new KClass[]{Reflection.getOrCreateKotlinClass(SessionListItem.class)}, new KSerializer[]{SessionListItem$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* compiled from: WorkoutDataClasses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) ListItem.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ListItem> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WorkoutDataClasses.kt */
    /* loaded from: classes3.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DailyGoal = new Type("DailyGoal", 0);
        public static final Type Session = new Type("Session", 1);
        public static final Type Metric = new Type("Metric", 2);
        public static final Type ActivitySummary = new Type("ActivitySummary", 3);
        public static final Type Text = new Type("Text", 4);
        public static final Type DailyGoalSummary = new Type("DailyGoalSummary", 5);
        public static final Type DailyGoalsProgressItem = new Type("DailyGoalsProgressItem", 6);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DailyGoal, Session, Metric, ActivitySummary, Text, DailyGoalSummary, DailyGoalsProgressItem};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int r2) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Type getItemType();

    private ListItem() {
    }

    public /* synthetic */ ListItem(int r1, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ void write$Self(ListItem listItem, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
