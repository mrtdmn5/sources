package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class SessionEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final SessionEvent event;
    private final Boolean gps;
    private String historyDeviceId;
    private final long sessionId;
    private long timestamp;
    private final SessionType type;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SessionEntry> serializer() {
            return SessionEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SessionEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, SessionEvent sessionEvent, SessionType sessionType, Boolean bool, long j2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, sessionEvent, sessionType, bool, j2, serializationConstructorMarker);
    }

    /* renamed from: copy-FGKXf14$default, reason: not valid java name */
    public static /* synthetic */ SessionEntry m1469copyFGKXf14$default(SessionEntry sessionEntry, String str, long j, SessionEvent sessionEvent, SessionType sessionType, Boolean bool, long j2, int r18, Object obj) {
        String str2;
        long j3;
        SessionEvent sessionEvent2;
        SessionType sessionType2;
        Boolean bool2;
        long j4;
        if ((r18 & 1) != 0) {
            str2 = sessionEntry.historyDeviceId;
        } else {
            str2 = str;
        }
        if ((r18 & 2) != 0) {
            j3 = sessionEntry.timestamp;
        } else {
            j3 = j;
        }
        if ((r18 & 4) != 0) {
            sessionEvent2 = sessionEntry.event;
        } else {
            sessionEvent2 = sessionEvent;
        }
        if ((r18 & 8) != 0) {
            sessionType2 = sessionEntry.type;
        } else {
            sessionType2 = sessionType;
        }
        if ((r18 & 16) != 0) {
            bool2 = sessionEntry.gps;
        } else {
            bool2 = bool;
        }
        if ((r18 & 32) != 0) {
            j4 = sessionEntry.sessionId;
        } else {
            j4 = j2;
        }
        return sessionEntry.m1472copyFGKXf14(str2, j3, sessionEvent2, sessionType2, bool2, j4);
    }

    public static final /* synthetic */ void write$Self$watch_release(SessionEntry sessionEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(sessionEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, sessionEntry.getTimestamp());
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, SessionEventSerializer.INSTANCE, sessionEntry.event);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, SessionTypeSerializer.INSTANCE, sessionEntry.type);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || sessionEntry.gps != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, sessionEntry.gps);
        }
        compositeEncoder.encodeLongElement(serialDescriptor, 5, sessionEntry.sessionId);
    }

    /* renamed from: component1-V9ZILtA, reason: not valid java name */
    public final String m1471component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final SessionEvent component3() {
        return this.event;
    }

    public final SessionType component4() {
        return this.type;
    }

    public final Boolean component5() {
        return this.gps;
    }

    public final long component6() {
        return this.sessionId;
    }

    /* renamed from: copy-FGKXf14, reason: not valid java name */
    public final SessionEntry m1472copyFGKXf14(String historyDeviceId, long j, SessionEvent event, SessionType type, Boolean bool, long j2) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SessionEntry(historyDeviceId, j, event, type, bool, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEntry)) {
            return false;
        }
        SessionEntry sessionEntry = (SessionEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, sessionEntry.historyDeviceId) && this.timestamp == sessionEntry.timestamp && this.event == sessionEntry.event && this.type == sessionEntry.type && Intrinsics.areEqual(this.gps, sessionEntry.gps) && this.sessionId == sessionEntry.sessionId) {
            return true;
        }
        return false;
    }

    public final SessionEvent getEvent() {
        return this.event;
    }

    public final Boolean getGps() {
        return this.gps;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final long getSessionId() {
        return this.sessionId;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public final SessionType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.type.hashCode() + ((this.event.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31)) * 31)) * 31;
        Boolean bool = this.gps;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        return Long.hashCode(this.sessionId) + ((hashCode2 + hashCode) * 31);
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: setHistoryDeviceId-Y1s2hH8 */
    public void mo1122setHistoryDeviceIdY1s2hH8(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.historyDeviceId = str;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", event=");
        sb.append(this.event);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", gps=");
        sb.append(this.gps);
        sb.append(", sessionId=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.sessionId, ')');
    }

    public /* synthetic */ SessionEntry(String str, long j, SessionEvent sessionEvent, SessionType sessionType, Boolean bool, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, sessionEvent, sessionType, bool, j2);
    }

    private SessionEntry(int r3, String str, long j, SessionEvent sessionEvent, SessionType sessionType, Boolean bool, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (r3 & 7)) {
            zzac.throwMissingFieldException(r3, 7, SessionEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.event = sessionEvent;
        if ((r3 & 8) == 0) {
            this.type = SessionType.Other;
        } else {
            this.type = sessionType;
        }
        if ((r3 & 16) == 0) {
            this.gps = null;
        } else {
            this.gps = bool;
        }
        if ((r3 & 32) == 0) {
            this.sessionId = -1L;
        } else {
            this.sessionId = j2;
        }
    }

    public /* synthetic */ SessionEntry(String str, long j, SessionEvent sessionEvent, SessionType sessionType, Boolean bool, long j2, int r20, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, sessionEvent, (r20 & 8) != 0 ? SessionType.Other : sessionType, (r20 & 16) != 0 ? null : bool, (r20 & 32) != 0 ? -1L : j2, null);
    }

    private SessionEntry(String historyDeviceId, long j, SessionEvent event, SessionType type, Boolean bool, long j2) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(type, "type");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.event = event;
        this.type = type;
        this.gps = bool;
        this.sessionId = j2;
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1470getHistoryDeviceIdV9ZILtA$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }
}
