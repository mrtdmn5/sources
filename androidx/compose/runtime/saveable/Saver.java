package androidx.compose.runtime.saveable;

/* compiled from: Saver.kt */
/* loaded from: classes.dex */
public interface Saver<Original, Saveable> {
    Saveable save(SaverScope saverScope, Original original);
}
