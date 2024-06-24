package io.ktor.util.collections;

import java.util.function.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConcurrentMap$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Function1 f$0;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Function1 tmp0 = this.f$0;
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }
}
