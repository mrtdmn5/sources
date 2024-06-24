package mu;

import kotlin.jvm.functions.Function0;
import org.slf4j.Logger;

/* compiled from: KLogger.kt */
/* loaded from: classes4.dex */
public interface KLogger extends Logger {
    void debug(Throwable th, Function0<? extends Object> function0);

    void debug(Function0<? extends Object> function0);

    void error(Throwable th, Function0<? extends Object> function0);

    void error(Function0<? extends Object> function0);

    void info(Throwable th, Function0<? extends Object> function0);

    void info(Function0<? extends Object> function0);

    void trace(Throwable th, Function0<? extends Object> function0);

    void trace(Function0<? extends Object> function0);

    void warn(Throwable th, Function0<? extends Object> function0);

    void warn(Function0<? extends Object> function0);
}
