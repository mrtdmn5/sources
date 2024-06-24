package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* compiled from: Composition.kt */
/* loaded from: classes.dex */
public interface ControlledComposition extends Composition {
    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(ComposableLambdaImpl composableLambdaImpl);

    <R> R delegateInvalidations(ControlledComposition controlledComposition, int r2, Function0<? extends R> function0);

    void disposeUnusedMovableContent(MovableContentState movableContentState);

    void insertMovableContent(ArrayList arrayList);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(IdentityArraySet identityArraySet);

    void prepareCompose(Recomposer$performRecompose$1$1 recomposer$performRecompose$1$1);

    boolean recompose();

    void recordModificationsOf(IdentityArraySet identityArraySet);

    void recordReadOf(Object obj);

    void recordWriteOf(Object obj);
}
