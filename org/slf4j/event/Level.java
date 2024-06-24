package org.slf4j.event;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;

/* loaded from: classes4.dex */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private final int levelInt;
    private final String levelStr;

    Level(int r3, String str) {
        this.levelInt = r3;
        this.levelStr = str;
    }

    public static Level intToLevel(int r3) {
        if (r3 != 0) {
            if (r3 != 10) {
                if (r3 != 20) {
                    if (r3 != 30) {
                        if (r3 == 40) {
                            return ERROR;
                        }
                        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Level integer [", r3, "] not recognized."));
                    }
                    return WARN;
                }
                return INFO;
            }
            return DEBUG;
        }
        return TRACE;
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
