package com.animaconnected.watch.fitness;

import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.animaconnected.logger.LogKt;
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
/* compiled from: FitnessData.kt */
@Serializable(with = PowerStateSerializer.class)
/* loaded from: classes3.dex */
public final class PowerState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PowerState[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final int id;
    public static final PowerState Invalid = new PowerState("Invalid", 0, 0);
    public static final PowerState Normal = new PowerState("Normal", 1, 1);
    public static final PowerState Warning = new PowerState("Warning", 2, 2);
    public static final PowerState Critical = new PowerState("Critical", 3, 3);
    public static final PowerState Off = new PowerState(BucketVersioningConfiguration.OFF, 4, 4);
    public static final PowerState Charging = new PowerState("Charging", 5, 5);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) PowerState.$cachedSerializer$delegate.getValue();
        }

        public final PowerState fromId(final int r10) {
            Object obj;
            boolean z;
            Iterator<E> it = PowerState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((PowerState) obj).getId() == r10) {
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
            PowerState powerState = (PowerState) obj;
            if (powerState == null) {
                final PowerState powerState2 = PowerState.Normal;
                LogKt.warn$default((Object) PowerState.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.PowerState$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid WristState id: " + r10 + ", defaulting to " + powerState2;
                    }
                }, 7, (Object) null);
                return powerState2;
            }
            return powerState;
        }

        public final KSerializer<PowerState> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PowerState[] $values() {
        return new PowerState[]{Invalid, Normal, Warning, Critical, Off, Charging};
    }

    static {
        PowerState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.fitness.PowerState.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return PowerStateSerializer.INSTANCE;
            }
        });
    }

    private PowerState(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<PowerState> getEntries() {
        return $ENTRIES;
    }

    public static PowerState valueOf(String str) {
        return (PowerState) Enum.valueOf(PowerState.class, str);
    }

    public static PowerState[] values() {
        return (PowerState[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
