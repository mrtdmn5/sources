package aws.smithy.kotlin.runtime.tracing;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceEvent.kt */
/* loaded from: classes.dex */
public interface TraceEventData {

    /* compiled from: TraceEvent.kt */
    /* loaded from: classes.dex */
    public static final class Message implements TraceEventData {
        public final Function0<Object> content;
        public final Throwable exception;

        public Message(Throwable th, Function0<? extends Object> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.exception = th;
            this.content = content;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return false;
            }
            Message message = (Message) obj;
            if (Intrinsics.areEqual(this.exception, message.exception) && Intrinsics.areEqual(this.content, message.content)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode;
            Throwable th = this.exception;
            if (th == null) {
                hashCode = 0;
            } else {
                hashCode = th.hashCode();
            }
            return this.content.hashCode() + (hashCode * 31);
        }

        public final String toString() {
            return "Message(exception=" + this.exception + ", content=" + this.content + ')';
        }
    }
}
