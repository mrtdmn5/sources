package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new AnonymousClass1();
    public final MediaDescriptionCompat mDescription;
    public final int mFlags;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        @Override // android.os.Parcelable.Creator
        public final MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaBrowserCompat$MediaItem[] newArray(int r1) {
            return new MediaBrowserCompat$MediaItem[r1];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.mFlags = parcel.readInt();
        this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r3) {
        parcel.writeInt(this.mFlags);
        this.mDescription.writeToParcel(parcel, r3);
    }
}
