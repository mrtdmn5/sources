package io.ktor.util.logging;

import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmc;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: KtorSimpleLoggerJvm.kt */
/* loaded from: classes3.dex */
public final class KtorSimpleLoggerJvmKt {
    public static final zzmb zza = new zzmb();
    public static final zzmc zzb = new zzmc();

    public static final Logger KtorSimpleLogger(String str) {
        Logger logger = LoggerFactory.getLogger(str);
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(name)");
        return logger;
    }
}
