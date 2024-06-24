package kotlinx.coroutines.slf4j;

import java.util.Map;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

/* compiled from: MDCContext.kt */
/* loaded from: classes4.dex */
public final class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement<Map<String, ? extends String>> {
    public static final Key Key = new Key();
    public final Map<String, String> contextMap;

    /* compiled from: MDCContext.kt */
    /* loaded from: classes4.dex */
    public static final class Key implements CoroutineContext.Key<MDCContext> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MDCContext() {
        super(Key);
        MDCAdapter mDCAdapter = MDC.mdcAdapter;
        if (mDCAdapter != null) {
            Map<String, String> copyOfContextMap = mDCAdapter.getCopyOfContextMap();
            this.contextMap = copyOfContextMap;
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static void setCurrent(Map map) {
        if (map == null) {
            MDCAdapter mDCAdapter = MDC.mdcAdapter;
            if (mDCAdapter != null) {
                mDCAdapter.clear();
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDCAdapter mDCAdapter2 = MDC.mdcAdapter;
        if (mDCAdapter2 != null) {
            mDCAdapter2.setContextMap(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void restoreThreadContext(Object obj) {
        setCurrent((Map) obj);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Map<String, ? extends String> updateThreadContext(CoroutineContext coroutineContext) {
        MDCAdapter mDCAdapter = MDC.mdcAdapter;
        if (mDCAdapter != null) {
            Map<String, String> copyOfContextMap = mDCAdapter.getCopyOfContextMap();
            setCurrent(this.contextMap);
            return copyOfContextMap;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
