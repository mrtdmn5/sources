package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import java.util.Set;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionContext.kt */
/* loaded from: classes.dex */
public abstract class CompositionContext {
    public abstract void composeInitial$runtime_release(ControlledComposition controlledComposition, ComposableLambdaImpl composableLambdaImpl);

    public abstract void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference);

    public abstract boolean getCollectingParameterInformation$runtime_release();

    public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }

    public abstract int getCompoundHashKey$runtime_release();

    public abstract CoroutineContext getEffectCoroutineContext();

    public abstract void invalidate$runtime_release(ControlledComposition controlledComposition);

    public abstract void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState);

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        return null;
    }

    public abstract void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition);

    public void unregisterComposer$runtime_release(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(ControlledComposition controlledComposition);

    public void doneComposing$runtime_release() {
    }

    public void startComposing$runtime_release() {
    }

    public void recordInspectionTable$runtime_release(Set<Object> set) {
    }

    public void registerComposer$runtime_release(ComposerImpl composerImpl) {
    }
}
