package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: OnBackPressedCallback.kt */
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    public final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    public Function0<Unit> enabledChangedCallback;
    public boolean isEnabled;

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    public abstract void handleOnBackPressed();
}
