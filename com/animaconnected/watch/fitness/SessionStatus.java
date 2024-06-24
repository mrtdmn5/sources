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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: FitnessData.kt */
@Serializable(with = SessionStatusSerializer.class)
/* loaded from: classes3.dex */
public final class SessionStatus extends Enum<SessionStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SessionStatus[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final Integer id;
    public static final SessionStatus None = new SessionStatus("None", 0, null);
    public static final SessionStatus Valid = new SessionStatus("Valid", 1, 0);
    public static final SessionStatus Deleted = new SessionStatus("Deleted", 2, 1);

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: FitnessData.kt */
        /* renamed from: com.animaconnected.watch.fitness.SessionStatus$Companion$1 */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends Lambda implements Function0<KSerializer<Object>> {
            public static final AnonymousClass1 INSTANCE = ;

            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return SessionStatusSerializer.INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SessionStatus.$cachedSerializer$delegate.getValue();
        }

        public final SessionStatus fromId(final Integer num) {
            Object obj;
            Iterator<E> it = SessionStatus.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SessionStatus) obj).getId(), num)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            SessionStatus sessionStatus = (SessionStatus) obj;
            if (sessionStatus == null) {
                final SessionStatus sessionStatus2 = SessionStatus.None;
                LogKt.warn$default((Object) SessionStatus.Companion, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.SessionStatus$Companion$fromId$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid SessionStatus id: " + num + ", defaulting to " + sessionStatus2;
                    }
                }, 7, (Object) null);
                return sessionStatus2;
            }
            return sessionStatus;
        }

        public final KSerializer<SessionStatus> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SessionStatus[] $values() {
        return new SessionStatus[]{None, Valid, Deleted};
    }

    static {
        SessionStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, Companion.AnonymousClass1.INSTANCE);
    }

    private SessionStatus(String str, int r2, Integer num) {
        super(str, r2);
        this.id = num;
    }

    public static EnumEntries<SessionStatus> getEntries() {
        return $ENTRIES;
    }

    public static SessionStatus valueOf(String str) {
        return (SessionStatus) Enum.valueOf(SessionStatus.class, str);
    }

    public static SessionStatus[] values() {
        return (SessionStatus[]) $VALUES.clone();
    }

    public final Integer getId() {
        return this.id;
    }
}
