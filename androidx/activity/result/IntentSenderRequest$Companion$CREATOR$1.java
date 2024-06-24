package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentSenderRequest.kt */
/* loaded from: classes.dex */
public final class IntentSenderRequest$Companion$CREATOR$1 implements Parcelable.Creator<IntentSenderRequest> {
    @Override // android.os.Parcelable.Creator
    public final IntentSenderRequest createFromParcel(Parcel inParcel) {
        Intrinsics.checkNotNullParameter(inParcel, "inParcel");
        Parcelable readParcelable = inParcel.readParcelable(IntentSender.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        return new IntentSenderRequest((IntentSender) readParcelable, (Intent) inParcel.readParcelable(Intent.class.getClassLoader()), inParcel.readInt(), inParcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final IntentSenderRequest[] newArray(int r1) {
        return new IntentSenderRequest[r1];
    }
}
