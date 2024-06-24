package com.amplifyframework.statemachine;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateMachine.kt */
/* loaded from: classes.dex */
public final class StateChangeListenerToken {
    private final UUID uuid;

    private StateChangeListenerToken(UUID r1) {
        this.uuid = r1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof StateChangeListenerToken) && Intrinsics.areEqual(((StateChangeListenerToken) obj).uuid, this.uuid)) {
            return true;
        }
        return false;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StateChangeListenerToken() {
        /*
            r2 = this;
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r1 = "randomUUID()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.statemachine.StateChangeListenerToken.<init>():void");
    }
}
