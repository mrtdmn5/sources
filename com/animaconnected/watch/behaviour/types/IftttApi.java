package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.location.Spot;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Ifttt.kt */
/* loaded from: classes3.dex */
public interface IftttApi {
    void sendIftttTrigger(ButtonAction buttonAction, Spot spot, Function3<? super Boolean, ? super String, ? super String, Unit> function3);

    void setup(Function1<? super String, Unit> function1);
}
