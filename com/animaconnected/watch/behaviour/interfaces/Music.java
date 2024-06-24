package com.animaconnected.watch.behaviour.interfaces;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FindPhoneMusicPlayer.kt */
/* loaded from: classes3.dex */
public final class Music {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Music[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final Music Normal = new Music("Normal", 0, 0);
    public static final Music Loud = new Music("Loud", 1, 1);
    public static final Music Discrete = new Music("Discrete", 2, 2);
    public static final Music Upbeat = new Music("Upbeat", 3, 3);
    public static final Music Christmas = new Music("Christmas", 4, 4);
    public static final Music NotSet = new Music("NotSet", 5, -1);

    /* compiled from: FindPhoneMusicPlayer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Music fromId(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = Music.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((Music) obj).getId() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Music music = (Music) obj;
            if (music == null) {
                return Music.NotSet;
            }
            return music;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Music[] $values() {
        return new Music[]{Normal, Loud, Discrete, Upbeat, Christmas, NotSet};
    }

    static {
        Music[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private Music(String str, int r2, int r3) {
        this.id = r3;
    }

    public static final Music fromId(int r1) {
        return Companion.fromId(r1);
    }

    public static EnumEntries<Music> getEntries() {
        return $ENTRIES;
    }

    public static Music valueOf(String str) {
        return (Music) Enum.valueOf(Music.class, str);
    }

    public static Music[] values() {
        return (Music[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
