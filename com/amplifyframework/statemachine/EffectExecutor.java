package com.amplifyframework.statemachine;

import java.util.List;

/* compiled from: EffectExecutor.kt */
/* loaded from: classes.dex */
public interface EffectExecutor {
    void execute(List<? extends Action> list, EventDispatcher eventDispatcher, Environment environment);
}
