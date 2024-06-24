package io.ktor.client.plugins.logging;

import java.nio.charset.Charset;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LoggingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", l = {71}, m = "logResponseBody")
/* loaded from: classes3.dex */
public final class LoggingUtilsKt$logResponseBody$1 extends ContinuationImpl {
    public StringBuilder L$0;
    public Charset L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LoggingUtilsKt.logResponseBody(null, null, null, this);
    }
}
