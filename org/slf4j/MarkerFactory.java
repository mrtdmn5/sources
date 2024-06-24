package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes4.dex */
public final class MarkerFactory {
    public static final BasicMarkerFactory MARKER_FACTORY;

    static {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MARKER_FACTORY = provider.getMarkerFactory();
            return;
        }
        Util.report("Failed to find provider");
        Util.report("Defaulting to BasicMarkerFactory.");
        MARKER_FACTORY = new BasicMarkerFactory();
    }
}
