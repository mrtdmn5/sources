package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: WatchManager.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class WatchManager$createWatch$1 extends AdaptedFunctionReference implements Function1<Continuation<? super Unit>, Object> {
    public WatchManager$createWatch$1(Object obj) {
        super(1, obj, WatchManager.class, "sync", "sync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object createWatch$sync;
        createWatch$sync = WatchManager.createWatch$sync((WatchManager) this.receiver, continuation);
        return createWatch$sync;
    }
}
