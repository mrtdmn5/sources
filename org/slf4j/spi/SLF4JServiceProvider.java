package org.slf4j.spi;

import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.BasicMarkerFactory;

/* loaded from: classes4.dex */
public interface SLF4JServiceProvider {
    ILoggerFactory getLoggerFactory();

    MDCAdapter getMDCAdapter();

    BasicMarkerFactory getMarkerFactory();

    String getRequestedApiVersion();

    void initialize();
}
