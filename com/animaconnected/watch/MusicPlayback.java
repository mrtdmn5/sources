package com.animaconnected.watch;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: DisplayWatch.kt */
/* loaded from: classes3.dex */
public final class MusicPlayback {
    private final int androidStateInt;
    private final long positionMillis;
    private final int positionSeconds;
    private final State state;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DisplayWatch.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        private final int watchStateInt;
        public static final State NONE = new State("NONE", 0, -1);
        public static final State STOPPED = new State("STOPPED", 1, -1);
        public static final State PLAYING = new State("PLAYING", 2, 1);
        public static final State PAUSED = new State("PAUSED", 3, 0);
        public static final State FAST_FORWARDING = new State("FAST_FORWARDING", 4, 3);
        public static final State REWINDING = new State("REWINDING", 5, 2);
        public static final State BUFFERING = new State("BUFFERING", 6, -1);
        public static final State ERROR = new State("ERROR", 7, -1);
        public static final State CONNECTING = new State("CONNECTING", 8, -1);
        public static final State SKIPPING_TO_PREVIOUS = new State("SKIPPING_TO_PREVIOUS", 9, -1);
        public static final State SKIPPING_TO_NEXT = new State("SKIPPING_TO_NEXT", 10, -1);
        public static final State SKIPPING_TO_QUEUE_ITEM = new State("SKIPPING_TO_QUEUE_ITEM", 11, -1);

        private static final /* synthetic */ State[] $values() {
            return new State[]{NONE, STOPPED, PLAYING, PAUSED, FAST_FORWARDING, REWINDING, BUFFERING, ERROR, CONNECTING, SKIPPING_TO_PREVIOUS, SKIPPING_TO_NEXT, SKIPPING_TO_QUEUE_ITEM};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2, int r3) {
            this.watchStateInt = r3;
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final int getWatchStateInt() {
            return this.watchStateInt;
        }
    }

    public MusicPlayback(long j, int r5) {
        this.positionMillis = j;
        this.androidStateInt = r5;
        this.state = DisplayWatchJvm.access$getPlaybackState(r5);
        this.positionSeconds = (int) (j / 1000);
    }

    private final long component1() {
        return this.positionMillis;
    }

    public static /* synthetic */ MusicPlayback copy$default(MusicPlayback musicPlayback, long j, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = musicPlayback.positionMillis;
        }
        if ((r4 & 2) != 0) {
            r3 = musicPlayback.androidStateInt;
        }
        return musicPlayback.copy(j, r3);
    }

    public final int component2() {
        return this.androidStateInt;
    }

    public final MusicPlayback copy(long j, int r4) {
        return new MusicPlayback(j, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != MusicPlayback.class) {
            return false;
        }
        MusicPlayback musicPlayback = (MusicPlayback) obj;
        if (this.state == musicPlayback.state && this.positionSeconds == musicPlayback.positionSeconds) {
            return true;
        }
        return false;
    }

    public final int getAndroidStateInt() {
        return this.androidStateInt;
    }

    public final int getPositionSeconds() {
        return this.positionSeconds;
    }

    public final State getState() {
        return this.state;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + this.positionSeconds;
    }

    public String toString() {
        return "MusicPlayback(positionMillis=" + this.positionMillis + ", state=" + this.state + ')';
    }
}
