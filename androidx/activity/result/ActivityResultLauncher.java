package androidx.activity.result;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    public abstract void launch(@SuppressLint({"UnknownNullness"}) Object obj);

    public abstract void unregister();
}
