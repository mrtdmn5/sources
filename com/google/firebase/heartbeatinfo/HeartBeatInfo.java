package com.google.firebase.heartbeatinfo;

/* loaded from: classes3.dex */
public interface HeartBeatInfo {

    /* loaded from: classes3.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int r3) {
            this.code = r3;
        }

        public int getCode() {
            return this.code;
        }
    }

    HeartBeat getHeartBeatCode();
}
