package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;

/* compiled from: SRPActions.kt */
/* loaded from: classes.dex */
public interface SRPActions {
    Action initiateSRPAuthAction(SRPEvent.EventType.InitiateSRP initiateSRP);

    Action initiateSRPWithCustomAuthAction(SRPEvent.EventType.InitiateSRPWithCustom initiateSRPWithCustom);

    Action verifyPasswordSRPAction(SRPEvent.EventType.RespondPasswordVerifier respondPasswordVerifier);
}
