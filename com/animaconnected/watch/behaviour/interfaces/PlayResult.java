package com.animaconnected.watch.behaviour.interfaces;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FindPhoneMusicPlayer.kt */
/* loaded from: classes3.dex */
public final class PlayResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayResult[] $VALUES;
    public static final PlayResult Finished = new PlayResult("Finished", 0);
    public static final PlayResult Failed = new PlayResult("Failed", 1);
    public static final PlayResult Stopped = new PlayResult("Stopped", 2);

    private static final /* synthetic */ PlayResult[] $values() {
        return new PlayResult[]{Finished, Failed, Stopped};
    }

    static {
        PlayResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private PlayResult(String str, int r2) {
    }

    public static EnumEntries<PlayResult> getEntries() {
        return $ENTRIES;
    }

    public static PlayResult valueOf(String str) {
        return (PlayResult) Enum.valueOf(PlayResult.class, str);
    }

    public static PlayResult[] values() {
        return (PlayResult[]) $VALUES.clone();
    }
}
