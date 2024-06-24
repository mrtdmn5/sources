package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: WatchManager.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class WatchManager$createWatch$2 extends AdaptedFunctionReference implements Function1<Continuation<? super Unit>, Object> {
    public WatchManager$createWatch$2(Object obj) {
        super(1, obj, WatchManager.class, "sync", "sync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object createWatch$sync$13;
        createWatch$sync$13 = WatchManager.createWatch$sync$13((WatchManager) this.receiver, continuation);
        return createWatch$sync$13;
    }
}
