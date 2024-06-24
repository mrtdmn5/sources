package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ChannelResult<T> {
    public static final Failed failed = new Failed();
    public final Object holder;

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Closed) {
                if (Intrinsics.areEqual(this.cause, ((Closed) obj).cause)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public final String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ChannelResult)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.holder, ((ChannelResult) obj).holder)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.holder;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.holder;
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
