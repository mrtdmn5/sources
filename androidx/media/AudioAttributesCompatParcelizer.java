package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        VersionedParcelable versionedParcelable = audioAttributesCompat.mImpl;
        if (versionedParcel.readField(1)) {
            versionedParcelable = versionedParcel.readVersionedParcelable();
        }
        audioAttributesCompat.mImpl = (AudioAttributesImpl) versionedParcelable;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.mImpl;
        versionedParcel.setOutputField(1);
        versionedParcel.writeVersionedParcelable$1(audioAttributesImpl);
    }
}
