package com.amplifyframework.statemachine;

import java.util.Date;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateMachineEvent.kt */
/* loaded from: classes.dex */
public interface StateMachineEvent {

    /* compiled from: StateMachineEvent.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static String getId(StateMachineEvent stateMachineEvent) {
            String str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            return str;
        }

        public static Date getTime(StateMachineEvent stateMachineEvent) {
            return new Date();
        }
    }

    String getId();

    Date getTime();

    String getType();
}
