package com.j256.ormlite.logger;

/* loaded from: classes3.dex */
public final class NullLogBackend implements LogBackend {

    /* loaded from: classes3.dex */
    public static class NullLogBackendFactory implements LogBackendFactory {
        @Override // com.j256.ormlite.logger.LogBackendFactory
        public final LogBackend createLogBackend(String str) {
            return new NullLogBackend();
        }
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final boolean isLevelEnabled(Level level) {
        return false;
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str) {
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str, Exception exc) {
    }
}
