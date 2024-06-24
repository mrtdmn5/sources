package aws.smithy.kotlin.runtime.serde.json;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonLexer.kt */
/* loaded from: classes.dex */
public final class StateManager {
    public final List<Function1<List<LexerState>, Unit>> pendingMutations;
    public final List<LexerState> state;

    public StateManager() {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StateManager)) {
            return false;
        }
        StateManager stateManager = (StateManager) obj;
        if (Intrinsics.areEqual(this.state, stateManager.state) && Intrinsics.areEqual(this.pendingMutations, stateManager.pendingMutations)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.pendingMutations.hashCode() + (this.state.hashCode() * 31);
    }

    public final void mutate(Function1<? super List<LexerState>, Unit> mutation) {
        Intrinsics.checkNotNullParameter(mutation, "mutation");
        this.pendingMutations.add(mutation);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StateManager(state=");
        sb.append(this.state);
        sb.append(", pendingMutations=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.pendingMutations, ')');
    }

    public StateManager(Object obj) {
        ArrayList mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(LexerState.Initial);
        ArrayList arrayList = new ArrayList();
        this.state = mutableListOf;
        this.pendingMutations = arrayList;
    }
}
