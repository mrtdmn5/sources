package androidx.compose.foundation.lazy.layout;

/* compiled from: LazyLayoutBeyondBoundsState.kt */
/* loaded from: classes.dex */
public interface LazyLayoutBeyondBoundsState {
    int getFirstPlacedIndex();

    boolean getHasVisibleItems();

    int getItemCount();

    int getLastPlacedIndex();

    void remeasure();
}
