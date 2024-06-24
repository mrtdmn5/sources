package com.animaconnected.secondo.provider.update;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DfuState.kt */
/* loaded from: classes3.dex */
public abstract class DfuState {
    public static final int $stable = 0;
    private final boolean allowDisconnection;

    /* compiled from: DfuState.kt */
    /* loaded from: classes3.dex */
    public static final class Failed extends DfuState {
        public static final int $stable = 0;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String message) {
            super(false, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = failed.message;
            }
            return failed.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Failed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Failed(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Failed) && Intrinsics.areEqual(this.message, ((Failed) obj).message)) {
                return true;
            }
            return false;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Failed(message="), this.message, ')');
        }
    }

    /* compiled from: DfuState.kt */
    /* loaded from: classes3.dex */
    public static final class Initiating extends DfuState {
        public static final int $stable = 0;
        public static final Initiating INSTANCE = new Initiating();

        private Initiating() {
            super(true, null);
        }
    }

    /* compiled from: DfuState.kt */
    /* loaded from: classes3.dex */
    public static final class NotStarted extends DfuState {
        public static final int $stable = 0;
        public static final NotStarted INSTANCE = new NotStarted();

        private NotStarted() {
            super(true, null);
        }
    }

    /* compiled from: DfuState.kt */
    /* loaded from: classes3.dex */
    public static final class Ongoing extends DfuState {
        public static final int $stable = 0;
        private final int progress;

        public Ongoing(int r3) {
            super(false, null);
            this.progress = r3;
        }

        public static /* synthetic */ Ongoing copy$default(Ongoing ongoing, int r1, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                r1 = ongoing.progress;
            }
            return ongoing.copy(r1);
        }

        public final int component1() {
            return this.progress;
        }

        public final Ongoing copy(int r2) {
            return new Ongoing(r2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Ongoing) && this.progress == ((Ongoing) obj).progress) {
                return true;
            }
            return false;
        }

        public final int getProgress() {
            return this.progress;
        }

        public int hashCode() {
            return Integer.hashCode(this.progress);
        }

        public String toString() {
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("Ongoing(progress="), this.progress, ')');
        }
    }

    /* compiled from: DfuState.kt */
    /* loaded from: classes3.dex */
    public static final class Successful extends DfuState {
        public static final int $stable = 0;
        public static final Successful INSTANCE = new Successful();

        private Successful() {
            super(true, null);
        }
    }

    public /* synthetic */ DfuState(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public final String analyticsString() {
        if (this instanceof NotStarted) {
            return "not_started";
        }
        if (this instanceof Initiating) {
            return "initiating";
        }
        if (this instanceof Ongoing) {
            return "ongoing";
        }
        if (this instanceof Successful) {
            return AnalyticsConstants.KEY_SUCCESSFUL;
        }
        if (this instanceof Failed) {
            return "failed";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getAllowDisconnection() {
        return this.allowDisconnection;
    }

    private DfuState(boolean z) {
        this.allowDisconnection = z;
    }
}
