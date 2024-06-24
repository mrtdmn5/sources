package org.slf4j.spi;

import java.util.Map;

/* loaded from: classes4.dex */
public interface MDCAdapter {
    void clear();

    Map<String, String> getCopyOfContextMap();

    void setContextMap(Map<String, String> map);
}
