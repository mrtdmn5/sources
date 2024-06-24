package io.ktor.util.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ConcurrentMapJvm.kt */
/* loaded from: classes3.dex */
public final class ConcurrentMap$computeIfAbsent$1 extends Lambda implements Function1<Object, Object> {
    public final /* synthetic */ Function0<Object> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcurrentMap$computeIfAbsent$1(Function0<Object> function0) {
        super(1);
        this.$block = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return this.$block.invoke();
    }
}
