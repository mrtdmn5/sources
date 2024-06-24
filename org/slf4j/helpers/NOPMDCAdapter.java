package org.slf4j.helpers;

import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes4.dex */
public final class NOPMDCAdapter implements MDCAdapter {
    @Override // org.slf4j.spi.MDCAdapter
    public Map getCopyOfContextMap() {
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void clear() {
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void setContextMap(Map map) {
    }
}
