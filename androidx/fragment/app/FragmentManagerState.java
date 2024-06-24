package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new AnonymousClass1();
    public ArrayList<FragmentState> mActive;
    public ArrayList<String> mAdded;
    public BackStackState[] mBackStack;
    public int mBackStackIndex;
    public ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    public String mPrimaryNavActiveWho;
    public final ArrayList<String> mResultKeys;
    public final ArrayList<Bundle> mResults;

    /* renamed from: androidx.fragment.app.FragmentManagerState$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState[] newArray(int r1) {
            return new FragmentManagerState[r1];
        }
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList<>();
        this.mResults = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r3) {
        parcel.writeTypedList(this.mActive);
        parcel.writeStringList(this.mAdded);
        parcel.writeTypedArray(this.mBackStack, r3);
        parcel.writeInt(this.mBackStackIndex);
        parcel.writeString(this.mPrimaryNavActiveWho);
        parcel.writeStringList(this.mResultKeys);
        parcel.writeTypedList(this.mResults);
        parcel.writeTypedList(this.mLaunchedFragments);
    }

    public FragmentManagerState(Parcel parcel) {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList<>();
        this.mResults = new ArrayList<>();
        this.mActive = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = parcel.createStringArrayList();
        this.mBackStack = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.mBackStackIndex = parcel.readInt();
        this.mPrimaryNavActiveWho = parcel.readString();
        this.mResultKeys = parcel.createStringArrayList();
        this.mResults = parcel.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
