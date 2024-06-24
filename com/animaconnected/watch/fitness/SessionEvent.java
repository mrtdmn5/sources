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
@Serializable(with = SessionEventSerializer.class)
/* loaded from: classes3.dex */
public final class SessionEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionEvent[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final int id;
    public static final SessionEvent Unknown = new SessionEvent("Unknown", 0, 0);
    public static final SessionEvent Start = new SessionEvent("Start", 1, 1);
    public static final SessionEvent Pause = new SessionEvent("Pause", 2, 2);
    public static final SessionEvent Resume = new SessionEvent("Resume", 3, 3);
    public static final SessionEvent Stop = new SessionEvent("Stop", 4, 4);
    public static final SessionEvent Save = new SessionEvent("Save", 5, 5);
    public static final SessionEvent Discard = new SessionEvent("Discard", 6, 6);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SessionEvent.$cachedSerializer$delegate.getValue();
        }

        public final SessionEvent fromId(final int r10) {
            Object obj;
            boolean z;
            Iterator<E> it = SessionEvent.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SessionEvent) obj).getId() == r10) {
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
            SessionEvent sessionEvent = (SessionEvent) obj;
            if (sessionEvent == null) {
                final SessionEvent sessionEvent2 = SessionEvent.Unknown;
                LogKt.warn$default((Object) SessionEvent.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.SessionEvent$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid SessionEvent id: " + r10 + ", defaulting to " + sessionEvent2;
                    }
                }, 7, (Object) null);
                return sessionEvent2;
            }
            return sessionEvent;
        }

        public final KSerializer<SessionEvent> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SessionEvent[] $values() {
        return new SessionEvent[]{Unknown, Start, Pause, Resume, Stop, Save, Discard};
    }

    static {
        SessionEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: com.animaconnected.watch.fitness.SessionEvent.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return SessionEventSerializer.INSTANCE;
            }
        });
    }

    private SessionEvent(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<SessionEvent> getEntries() {
        return $ENTRIES;
    }

    public static SessionEvent valueOf(String str) {
        return (SessionEvent) Enum.valueOf(SessionEvent.class, str);
    }

    public static SessionEvent[] values() {
        return (SessionEvent[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
