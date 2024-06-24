package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
public final class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new AnonymousClass1();
    public final SimpleArrayMap<String, Bundle> extendableStates;

    /* renamed from: com.google.android.material.stateful.ExtendableSavedState$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new ExtendableSavedState[r1];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null);
        }
    }

    public ExtendableSavedState() {
        throw null;
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap<>(readInt);
        for (int r6 = 0; r6 < readInt; r6++) {
            this.extendableStates.put(strArr[r6], bundleArr[r6]);
        }
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r8) {
        parcel.writeParcelable(this.mSuperState, r8);
        SimpleArrayMap<String, Bundle> simpleArrayMap = this.extendableStates;
        int r0 = simpleArrayMap.mSize;
        parcel.writeInt(r0);
        String[] strArr = new String[r0];
        Bundle[] bundleArr = new Bundle[r0];
        for (int r4 = 0; r4 < r0; r4++) {
            strArr[r4] = simpleArrayMap.keyAt(r4);
            bundleArr[r4] = simpleArrayMap.valueAt(r4);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
