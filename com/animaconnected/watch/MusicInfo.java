package com.animaconnected.watch;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayWatch.kt */
/* loaded from: classes3.dex */
public final class MusicInfo {
    private final String album;
    private final String artist;
    private final int durationSeconds;
    private final String title;

    public MusicInfo(String str, String str2, String str3, int r10) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "artist", str2, DetailBottomDialog.keyTitle, str3, "album");
        this.artist = str;
        this.title = str2;
        this.album = str3;
        this.durationSeconds = r10;
    }

    public static /* synthetic */ MusicInfo copy$default(MusicInfo musicInfo, String str, String str2, String str3, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = musicInfo.artist;
        }
        if ((r5 & 2) != 0) {
            str2 = musicInfo.title;
        }
        if ((r5 & 4) != 0) {
            str3 = musicInfo.album;
        }
        if ((r5 & 8) != 0) {
            r4 = musicInfo.durationSeconds;
        }
        return musicInfo.copy(str, str2, str3, r4);
    }

    public final String component1() {
        return this.artist;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.album;
    }

    public final int component4() {
        return this.durationSeconds;
    }

    public final MusicInfo copy(String artist, String title, String album, int r5) {
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(album, "album");
        return new MusicInfo(artist, title, album, r5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicInfo)) {
            return false;
        }
        MusicInfo musicInfo = (MusicInfo) obj;
        if (Intrinsics.areEqual(this.artist, musicInfo.artist) && Intrinsics.areEqual(this.title, musicInfo.title) && Intrinsics.areEqual(this.album, musicInfo.album) && this.durationSeconds == musicInfo.durationSeconds) {
            return true;
        }
        return false;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.durationSeconds) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.album, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.title, this.artist.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MusicInfo(artist=");
        sb.append(this.artist);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", album=");
        sb.append(this.album);
        sb.append(", durationSeconds=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.durationSeconds, ')');
    }
}
