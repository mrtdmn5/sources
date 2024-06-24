package com.animaconnected.watch.fitness;

import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
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
public final class SessionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionState[] $VALUES;
    public static final Companion Companion;
    public static final SessionState Off = new SessionState(BucketVersioningConfiguration.OFF, 0, 0);
    public static final SessionState On = new SessionState("On", 1, 1);
    public static final SessionState Paused = new SessionState("Paused", 2, 2);
    private final int id;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionState fromId(final Integer num) {
            Object obj;
            boolean z;
            Iterator<E> it = SessionState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int id = ((SessionState) obj).getId();
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
            SessionState sessionState = (SessionState) obj;
            if (sessionState == null) {
                final SessionState sessionState2 = SessionState.Off;
                LogKt.warn$default((Object) SessionState.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.SessionState$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid SessionState id: " + num + ", defaulting to " + sessionState2;
                    }
                }, 7, (Object) null);
                return sessionState2;
            }
            return sessionState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SessionState[] $values() {
        return new SessionState[]{Off, On, Paused};
    }

    static {
        SessionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private SessionState(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<SessionState> getEntries() {
        return $ENTRIES;
    }

    public static SessionState valueOf(String str) {
        return (SessionState) Enum.valueOf(SessionState.class, str);
    }

    public static SessionState[] values() {
        return (SessionState[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
