package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;

/* loaded from: classes.dex */
public final class RemoteInput {

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static int getEditChoicesBeforeSending(Object obj) {
            return ((android.app.RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int r1) {
            return builder.setEditChoicesBeforeSending(r1);
        }
    }

    public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        remoteInput.getClass();
        RemoteInput.Builder addExtras = new RemoteInput.Builder(null).setLabel(null).setChoices(null).setAllowFreeFormInput(false).addExtras(null);
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setEditChoicesBeforeSending(addExtras, 0);
        }
        return addExtras.build();
    }
}
