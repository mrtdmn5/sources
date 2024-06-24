package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: classes3.dex */
public final class LogEventDropped {
    public final long events_dropped_count_;
    public final Reason reason_;

    /* loaded from: classes3.dex */
    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        Reason(int r3) {
            this.number_ = r3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    static {
        Reason reason = Reason.REASON_UNKNOWN;
    }

    public LogEventDropped(long j, Reason reason) {
        this.events_dropped_count_ = j;
        this.reason_ = reason;
    }
}
