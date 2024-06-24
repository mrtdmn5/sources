package com.amplifyframework.storage;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransferState.kt */
/* loaded from: classes.dex */
public enum TransferState {
    WAITING,
    IN_PROGRESS,
    PAUSED,
    RESUMED_WAITING,
    COMPLETED,
    CANCELED,
    PENDING_FAILED,
    FAILED,
    PART_COMPLETED,
    PENDING_CANCEL,
    PENDING_PAUSE,
    UNKNOWN;

    public static final Companion Companion = new Companion(null);

    /* compiled from: TransferState.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferState getState(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            try {
                return TransferState.valueOf(state);
            } catch (IllegalArgumentException unused) {
                return TransferState.UNKNOWN;
            }
        }

        public final boolean isCancelled(TransferState transferState) {
            return CollectionsKt___CollectionsKt.contains(SetsKt__SetsKt.setOf((Object[]) new TransferState[]{TransferState.PENDING_CANCEL, TransferState.CANCELED}), transferState);
        }

        public final boolean isInTerminalState(TransferState transferState) {
            return CollectionsKt___CollectionsKt.contains(SetsKt__SetsKt.setOf((Object[]) new TransferState[]{TransferState.COMPLETED, TransferState.CANCELED, TransferState.FAILED, TransferState.PART_COMPLETED}), transferState);
        }

        public final boolean isPaused(TransferState transferState) {
            return CollectionsKt___CollectionsKt.contains(SetsKt__SetsKt.setOf((Object[]) new TransferState[]{TransferState.PENDING_PAUSE, TransferState.PAUSED}), transferState);
        }

        public final boolean isStarted(TransferState transferState) {
            return CollectionsKt___CollectionsKt.contains(SetsKt__SetsKt.setOf((Object[]) new TransferState[]{TransferState.WAITING, TransferState.IN_PROGRESS, TransferState.RESUMED_WAITING}), transferState);
        }

        private Companion() {
        }
    }

    public static final TransferState getState(String str) {
        return Companion.getState(str);
    }

    public static final boolean isCancelled(TransferState transferState) {
        return Companion.isCancelled(transferState);
    }

    public static final boolean isInTerminalState(TransferState transferState) {
        return Companion.isInTerminalState(transferState);
    }

    public static final boolean isPaused(TransferState transferState) {
        return Companion.isPaused(transferState);
    }

    public static final boolean isStarted(TransferState transferState) {
        return Companion.isStarted(transferState);
    }
}
