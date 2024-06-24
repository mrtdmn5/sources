package org.slf4j;

import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes4.dex */
public final class MDC {
    public static final MDCAdapter mdcAdapter;

    static {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            mdcAdapter = provider.getMDCAdapter();
            return;
        }
        Util.report("Failed to find provider.");
        Util.report("Defaulting to no-operation MDCAdapter implementation.");
        mdcAdapter = new NOPMDCAdapter();
    }
}
