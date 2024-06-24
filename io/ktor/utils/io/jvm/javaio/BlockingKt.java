package io.ktor.utils.io.jvm.javaio;

import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public final class BlockingKt {
    public static final SynchronizedLazyImpl ADAPTER_LOGGER$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Logger>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt$ADAPTER_LOGGER$2
        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return LoggerFactory.getLogger((Class<?>) BlockingAdapter.class);
        }
    });
}
