package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class VersionedParcelParcel extends VersionedParcel {
    public int mCurrentField;
    public final int mEnd;
    public int mFieldId;
    public int mNextRead;
    public final int mOffset;
    public final Parcel mParcel;
    public final SparseIntArray mPositionLookup;
    public final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public final void closeField() {
        int r0 = this.mCurrentField;
        if (r0 >= 0) {
            int r02 = this.mPositionLookup.get(r0);
            Parcel parcel = this.mParcel;
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(r02);
            parcel.writeInt(dataPosition - r02);
            parcel.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcelParcel createSubParcel() {
        Parcel parcel = this.mParcel;
        int dataPosition = parcel.dataPosition();
        int r0 = this.mNextRead;
        if (r0 == this.mOffset) {
            r0 = this.mEnd;
        }
        return new VersionedParcelParcel(parcel, dataPosition, r0, ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.mPrefix, "  "), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readBoolean() {
        if (this.mParcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] readByteArray() {
        Parcel parcel = this.mParcel;
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean readField(int r5) {
        while (this.mNextRead < this.mEnd) {
            int r0 = this.mFieldId;
            if (r0 == r5) {
                return true;
            }
            if (String.valueOf(r0).compareTo(String.valueOf(r5)) > 0) {
                return false;
            }
            int r02 = this.mNextRead;
            Parcel parcel = this.mParcel;
            parcel.setDataPosition(r02);
            int readInt = parcel.readInt();
            this.mFieldId = parcel.readInt();
            this.mNextRead += readInt;
        }
        if (this.mFieldId == r5) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(VersionedParcelParcel.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void setOutputField(int r3) {
        closeField();
        this.mCurrentField = r3;
        this.mPositionLookup.put(r3, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(r3);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeBoolean(boolean z) {
        this.mParcel.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeByteArray(byte[] bArr) {
        Parcel parcel = this.mParcel;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        } else {
            parcel.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeInt(int r2) {
        this.mParcel.writeInt(r2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void writeString(String str) {
        this.mParcel.writeString(str);
    }

    public VersionedParcelParcel(Parcel parcel, int r2, int r3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = r2;
        this.mEnd = r3;
        this.mNextRead = r2;
        this.mPrefix = str;
    }
}
