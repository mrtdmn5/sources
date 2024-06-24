package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.DeviceSRPSignInEvent;

/* compiled from: DeviceSRPSignInActions.kt */
/* loaded from: classes.dex */
public interface DeviceSRPSignInActions {
    Action respondDevicePasswordVerifier(DeviceSRPSignInEvent.EventType.RespondDevicePasswordVerifier respondDevicePasswordVerifier);

    Action respondDeviceSRP(DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge respondDeviceSRPChallenge);
}
