package com.animaconnected.watch.fitness;

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
@Serializable(with = WristStateSerializer.class)
/* loaded from: classes3.dex */
public final class WristState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WristState[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final int id;
    public static final WristState Unknown = new WristState("Unknown", 0, 0);
    public static final WristState Detecting = new WristState("Detecting", 1, 1);
    public static final WristState WornHr = new WristState("WornHr", 2, 2);
    public static final WristState WornIBI = new WristState("WornIBI", 3, 3);
    public static final WristState NotWorn = new WristState("NotWorn", 4, 4);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) WristState.$cachedSerializer$delegate.getValue();
        }

        public final WristState fromId(final int r10) {
            Object obj;
            boolean z;
            Iterator<E> it = WristState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((WristState) obj).getId() == r10) {
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
            WristState wristState = (WristState) obj;
            if (wristState == null) {
                final WristState wristState2 = WristState.Unknown;
                LogKt.warn$default((Object) WristState.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WristState$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid WristState id: " + r10 + ", defaulting to " + wristState2;
                    }
                }, 7, (Object) null);
                return wristState2;
            }
            return wristState;
        }

        public final KSerializer<WristState> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ WristState[] $values() {
        return new WristState[]{Unknown, Detecting, WornHr, WornIBI, NotWorn};
    }

    static {
        WristState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.fitness.WristState.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return WristStateSerializer.INSTANCE;
            }
        });
    }

    private WristState(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<WristState> getEntries() {
        return $ENTRIES;
    }

    public static WristState valueOf(String str) {
        return (WristState) Enum.valueOf(WristState.class, str);
    }

    public static WristState[] values() {
        return (WristState[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
