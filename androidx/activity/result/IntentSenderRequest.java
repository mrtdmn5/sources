package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentSenderRequest.kt */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    public final Intent fillInIntent;
    public final int flagsMask;
    public final int flagsValues;
    public final IntentSender intentSender;

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int r4, int r5) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        this.intentSender = intentSender;
        this.fillInIntent = intent;
        this.flagsMask = r4;
        this.flagsValues = r5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int r3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.intentSender, r3);
        dest.writeParcelable(this.fillInIntent, r3);
        dest.writeInt(this.flagsMask);
        dest.writeInt(this.flagsValues);
    }
}
