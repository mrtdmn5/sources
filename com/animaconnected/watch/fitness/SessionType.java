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
@Serializable(with = SessionTypeSerializer.class)
/* loaded from: classes3.dex */
public final class SessionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final int id;
    public static final SessionType Running = new SessionType("Running", 0, 0);
    public static final SessionType Walking = new SessionType("Walking", 1, 1);
    public static final SessionType Bike = new SessionType("Bike", 2, 2);
    public static final SessionType Other = new SessionType("Other", 3, 3);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SessionType.$cachedSerializer$delegate.getValue();
        }

        public final SessionType fromId(final Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = SessionType.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((SessionType) obj).getId();
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
            SessionType sessionType = (SessionType) obj;
            if (sessionType == null) {
                final SessionType sessionType2 = SessionType.Other;
                LogKt.warn$default((Object) SessionType.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.SessionType$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid SessionType id: " + num + ", defaulting to " + sessionType2;
                    }
                }, 7, (Object) null);
                return sessionType2;
            }
            return sessionType;
        }

        public final KSerializer<SessionType> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SessionType[] $values() {
        return new SessionType[]{Running, Walking, Bike, Other};
    }

    static {
        SessionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.fitness.SessionType.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return SessionTypeSerializer.INSTANCE;
            }
        });
    }

    private SessionType(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<SessionType> getEntries() {
        return $ENTRIES;
    }

    public static SessionType valueOf(String str) {
        return (SessionType) Enum.valueOf(SessionType.class, str);
    }

    public static SessionType[] values() {
        return (SessionType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
