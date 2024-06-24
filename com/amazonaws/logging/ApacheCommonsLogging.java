package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

@Deprecated
/* loaded from: classes.dex */
public class ApacheCommonsLogging implements Log {
    private LogFactory.Level level = null;
    private Log log;
    private Class logClass;
    private String logString;

    public ApacheCommonsLogging(Class cls) {
        this.logClass = cls;
        this.log = LogFactory.getLog((Class<?>) cls);
    }

    private LogFactory.Level getLevel() {
        LogFactory.Level level = this.level;
        if (level != null) {
            return level;
        }
        return LogFactory.getLevel();
    }

    @Override // com.amazonaws.logging.Log
    public void debug(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void error(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void info(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean isDebugEnabled() {
        if (this.log.isDebugEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.logging.Log
    public boolean isErrorEnabled() {
        if (this.log.isErrorEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.logging.Log
    public boolean isInfoEnabled() {
        if (this.log.isInfoEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.logging.Log
    public boolean isTraceEnabled() {
        if (this.log.isTraceEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.logging.Log
    public boolean isWarnEnabled() {
        if (this.log.isWarnEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue())) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.logging.Log
    public void setLevel(LogFactory.Level level) {
        this.level = level;
    }

    @Override // com.amazonaws.logging.Log
    public void trace(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void warn(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void debug(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void error(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void info(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void trace(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void warn(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj, th);
        }
    }

    public ApacheCommonsLogging(String str) {
        this.logString = str;
        this.log = LogFactory.getLog(str);
    }
}
