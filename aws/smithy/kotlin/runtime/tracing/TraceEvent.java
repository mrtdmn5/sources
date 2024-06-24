package aws.smithy.kotlin.runtime.tracing;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.tracing.TraceEventData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceEvent.kt */
/* loaded from: classes.dex */
public final class TraceEvent {
    public final TraceEventData data;
    public final EventLevel level;
    public final String sourceComponent;
    public final String threadId;
    public final Instant timestamp;

    public TraceEvent(EventLevel level, String sourceComponent, Instant instant, TraceEventData.Message message) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(sourceComponent, "sourceComponent");
        this.level = level;
        this.sourceComponent = sourceComponent;
        this.timestamp = instant;
        this.threadId = "thread-id";
        this.data = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceEvent)) {
            return false;
        }
        TraceEvent traceEvent = (TraceEvent) obj;
        if (this.level == traceEvent.level && Intrinsics.areEqual(this.sourceComponent, traceEvent.sourceComponent) && Intrinsics.areEqual(this.timestamp, traceEvent.timestamp) && Intrinsics.areEqual(this.threadId, traceEvent.threadId) && Intrinsics.areEqual(this.data, traceEvent.data)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.data.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.threadId, (this.timestamp.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.sourceComponent, this.level.hashCode() * 31, 31)) * 31, 31);
    }

    public final String toString() {
        return "TraceEvent(level=" + this.level + ", sourceComponent=" + this.sourceComponent + ", timestamp=" + this.timestamp + ", threadId=" + this.threadId + ", data=" + this.data + ')';
    }
}
