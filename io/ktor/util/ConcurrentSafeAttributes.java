package io.ktor.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributesJvm.kt */
/* loaded from: classes3.dex */
public final class ConcurrentSafeAttributes extends AttributesJvmBase {
    public final ConcurrentHashMap<AttributeKey<?>, Object> map = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.Attributes
    public final <T> T computeIfAbsent(AttributeKey<T> key, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrentHashMap<AttributeKey<?>, Object> concurrentHashMap = this.map;
        T t = (T) concurrentHashMap.get(key);
        if (t != null) {
            return t;
        }
        T invoke = block.invoke();
        Object putIfAbsent = concurrentHashMap.putIfAbsent(key, invoke);
        if (putIfAbsent != 0) {
            invoke = putIfAbsent;
        }
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return invoke;
    }

    @Override // io.ktor.util.AttributesJvmBase
    public final Map getMap() {
        return this.map;
    }
}
