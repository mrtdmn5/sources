package org.slf4j.event;

import java.util.Queue;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes4.dex */
public final class EventRecordingLogger extends LegacyAbstractLogger {
    public final Queue<SubstituteLoggingEvent> eventQueue;
    public final SubstituteLogger logger;
    public final String name;

    public EventRecordingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.logger = substituteLogger;
        this.name = substituteLogger.name;
        this.eventQueue = queue;
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.name;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger
    public final void handleNormalizedLoggingCall(Object[] objArr) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        System.currentTimeMillis();
        substituteLoggingEvent.logger = this.logger;
        Thread.currentThread().getName();
        substituteLoggingEvent.argArray = objArr;
        this.eventQueue.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return true;
    }
}
