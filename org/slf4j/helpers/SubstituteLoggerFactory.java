package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes4.dex */
public final class SubstituteLoggerFactory implements ILoggerFactory {
    public volatile boolean postInitialization = false;
    public final ConcurrentHashMap loggers = new ConcurrentHashMap();
    public final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    public final synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = (SubstituteLogger) this.loggers.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.eventQueue, this.postInitialization);
            this.loggers.put(str, substituteLogger);
        }
        return substituteLogger;
    }
}
