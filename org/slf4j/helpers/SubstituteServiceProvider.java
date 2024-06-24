package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes4.dex */
public final class SubstituteServiceProvider implements SLF4JServiceProvider {
    public final SubstituteLoggerFactory loggerFactory = new SubstituteLoggerFactory();
    public final BasicMarkerFactory markerFactory = new BasicMarkerFactory();
    public final BasicMDCAdapter mdcAdapter = new BasicMDCAdapter();

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
        throw new UnsupportedOperationException();
    }

    @Override // org.slf4j.spi.SLF4JServiceProvider
    public final void initialize() {
    }
}
