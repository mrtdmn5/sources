package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugBleStatus {
    public static final int $stable = 0;
    private final ConnectionState connectionState;
    private final boolean isAssociated;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DebugUiState.kt */
    /* loaded from: classes3.dex */
    public static final class ConnectionState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConnectionState[] $VALUES;
        public static final ConnectionState CONNECTED = new ConnectionState("CONNECTED", 0, "Connected");
        public static final ConnectionState DFU = new ConnectionState("DFU", 1, "DFU needed");
        public static final ConnectionState DISCONNECTED = new ConnectionState("DISCONNECTED", 2, "Disconnected");
        private final String description;

        private static final /* synthetic */ ConnectionState[] $values() {
            return new ConnectionState[]{CONNECTED, DFU, DISCONNECTED};
        }

        static {
            ConnectionState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ConnectionState(String str, int r2, String str2) {
            this.description = str2;
        }

        public static EnumEntries<ConnectionState> getEntries() {
            return $ENTRIES;
        }

        public static ConnectionState valueOf(String str) {
            return (ConnectionState) Enum.valueOf(ConnectionState.class, str);
        }

        public static ConnectionState[] values() {
            return (ConnectionState[]) $VALUES.clone();
        }

        public final String getDescription() {
            return this.description;
        }
    }

    public DebugBleStatus() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DebugBleStatus copy$default(DebugBleStatus debugBleStatus, ConnectionState connectionState, boolean z, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            connectionState = debugBleStatus.connectionState;
        }
        if ((r3 & 2) != 0) {
            z = debugBleStatus.isAssociated;
        }
        return debugBleStatus.copy(connectionState, z);
    }

    public final ConnectionState component1() {
        return this.connectionState;
    }

    public final boolean component2() {
        return this.isAssociated;
    }

    public final DebugBleStatus copy(ConnectionState connectionState, boolean z) {
        Intrinsics.checkNotNullParameter(connectionState, "connectionState");
        return new DebugBleStatus(connectionState, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugBleStatus)) {
            return false;
        }
        DebugBleStatus debugBleStatus = (DebugBleStatus) obj;
        if (this.connectionState == debugBleStatus.connectionState && this.isAssociated == debugBleStatus.isAssociated) {
            return true;
        }
        return false;
    }

    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isAssociated) + (this.connectionState.hashCode() * 31);
    }

    public final boolean isAssociated() {
        return this.isAssociated;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugBleStatus(connectionState=");
        sb.append(this.connectionState);
        sb.append(", isAssociated=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isAssociated, ')');
    }

    public DebugBleStatus(ConnectionState connectionState, boolean z) {
        Intrinsics.checkNotNullParameter(connectionState, "connectionState");
        this.connectionState = connectionState;
        this.isAssociated = z;
    }

    public /* synthetic */ DebugBleStatus(ConnectionState connectionState, boolean z, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? ConnectionState.DISCONNECTED : connectionState, (r3 & 2) != 0 ? false : z);
    }
}
