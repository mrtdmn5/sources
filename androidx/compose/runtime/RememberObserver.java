package androidx.compose.runtime;

/* compiled from: RememberObserver.kt */
/* loaded from: classes.dex */
public interface RememberObserver {
    void onAbandoned();

    void onForgotten();

    void onRemembered();
}
