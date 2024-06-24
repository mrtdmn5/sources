package androidx.compose.runtime;

import androidx.compose.runtime.ComposerImpl;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public interface Composer {

    /* compiled from: Composer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final Composer$Companion$Empty$1 Empty = new Composer$Companion$Empty$1();
    }

    <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2);

    ComposerImpl.CompositionContextImpl buildContext();

    boolean changed(Object obj);

    default boolean changed(boolean z) {
        return changed(z);
    }

    default boolean changedInstance(Object obj) {
        return changed(obj);
    }

    void collectParameterInformation();

    Object consume(ProvidableCompositionLocal providableCompositionLocal);

    <T> void createNode(Function0<? extends T> function0);

    void deactivateToEndGroup(boolean z);

    void endMovableGroup();

    void endNode();

    void endReplaceableGroup();

    void endReusableGroup();

    Applier<?> getApplier();

    CoroutineContext getApplyCoroutineContext();

    SlotTable getCompositionData();

    int getCompoundKeyHash();

    PersistentCompositionLocalMap getCurrentCompositionLocalMap();

    boolean getInserting();

    RecomposeScopeImpl getRecomposeScope();

    boolean getSkipping();

    void recordSideEffect(Function0<Unit> function0);

    void recordUsed(RecomposeScope recomposeScope);

    Object rememberedValue();

    void skipToGroupEnd();

    void startMovableGroup(int r1, Object obj);

    void startReplaceableGroup(int r1);

    ComposerImpl startRestartGroup(int r1);

    void startReusableGroup(Object obj);

    void startReusableNode();

    void updateRememberedValue(Object obj);

    void useNode();

    default boolean changed(int r1) {
        return changed(r1);
    }

    default boolean changed(float f) {
        return changed(f);
    }

    default boolean changed(long j) {
        return changed(j);
    }
}
