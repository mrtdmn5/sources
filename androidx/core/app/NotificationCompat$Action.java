package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;

    @Deprecated
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final boolean mAuthenticationRequired;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mIsContextual;
    public final RemoteInput[] mRemoteInputs;
    public final int mSemanticAction;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    public NotificationCompat$Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int r9, boolean z2, boolean z3, boolean z4) {
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        if (iconCompat != null) {
            int r7 = iconCompat.mType;
            if ((r7 == -1 ? IconCompat.Api23Impl.getType(iconCompat.mObj1) : r7) == 2) {
                this.icon = iconCompat.getResId();
            }
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle == null ? new Bundle() : bundle;
        this.mRemoteInputs = remoteInputArr;
        this.mAllowGeneratedReplies = z;
        this.mSemanticAction = r9;
        this.mShowsUserInterface = z2;
        this.mIsContextual = z3;
        this.mAuthenticationRequired = z4;
    }
}
