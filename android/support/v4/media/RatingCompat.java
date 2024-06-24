package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new AnonymousClass1();
    public final int mRatingStyle;
    public final float mRatingValue;

    /* renamed from: android.support.v4.media.RatingCompat$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public final RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readFloat(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final RatingCompat[] newArray(int r1) {
            return new RatingCompat[r1];
        }
    }

    public RatingCompat(float f, int r2) {
        this.mRatingStyle = r2;
        this.mRatingValue = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.mRatingStyle;
    }

    public final String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.mRatingStyle);
        sb.append(" rating=");
        float f = this.mRatingValue;
        if (f < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
