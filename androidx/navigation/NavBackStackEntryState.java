package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new AnonymousClass1();
    public final Bundle mArgs;
    public final int mDestinationId;
    public final Bundle mSavedState;
    public final UUID mUUID;

    /* renamed from: androidx.navigation.NavBackStackEntryState$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Parcelable.Creator<NavBackStackEntryState> {
        @Override // android.os.Parcelable.Creator
        public final NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NavBackStackEntryState[] newArray(int r1) {
            return new NavBackStackEntryState[r1];
        }
    }

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.mUUID = navBackStackEntry.mId;
        this.mDestinationId = navBackStackEntry.mDestination.mId;
        this.mArgs = navBackStackEntry.mArgs;
        Bundle bundle = new Bundle();
        this.mSavedState = bundle;
        navBackStackEntry.mSavedStateRegistryController.performSave(bundle);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        parcel.writeString(this.mUUID.toString());
        parcel.writeInt(this.mDestinationId);
        parcel.writeBundle(this.mArgs);
        parcel.writeBundle(this.mSavedState);
    }

    public NavBackStackEntryState(Parcel parcel) {
        this.mUUID = UUID.fromString(parcel.readString());
        this.mDestinationId = parcel.readInt();
        this.mArgs = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.mSavedState = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
