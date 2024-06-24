package com.animaconnected.secondo.utils;

import com.animaconnected.logger.LogKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ClickThrottle.kt */
/* loaded from: classes3.dex */
public final class ClickThrottle {
    public static final int $stable = 8;
    private boolean isInUse;
    private final CoroutineScope scope;

    public ClickThrottle(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    public final void handle(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.isInUse) {
            return;
        }
        LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.ClickThrottle$handle$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "click throttled";
            }
        }, 7, (Object) null);
        this.isInUse = true;
        block.invoke();
        BuildersKt.launch$default(this.scope, null, null, new ClickThrottle$handle$2(this, null), 3);
    }
}
