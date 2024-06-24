package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes4.dex */
public final class NOP_FallbackServiceProvider implements SLF4JServiceProvider {
    public final NOPLoggerFactory loggerFactory = new NOPLoggerFactory();
    public final BasicMarkerFactory markerFactory = new BasicMarkerFactory();
    public final NOPMDCAdapter mdcAdapter = new NOPMDCAdapter();

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final MDCAdapter getMDCAdapter() {
        return this.mdcAdapter;
    }

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final BasicMarkerFactory getMarkerFactory() {
        return this.markerFactory;
    }

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final String getRequestedApiVersion() {
        return "2.0.99";
    }

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final void initialize() {
    }
}
