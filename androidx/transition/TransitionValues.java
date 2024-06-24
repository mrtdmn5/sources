package androidx.transition;

import android.view.View;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class TransitionValues {
    public final View view;
    public final HashMap values = new HashMap();
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.view == transitionValues.view && this.values.equals(transitionValues.values)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        m.append(this.view);
        m.append("\n");
        String m2 = ComposableInvoker$$ExternalSyntheticOutline0.m(m.toString(), "    values:");
        HashMap hashMap = this.values;
        for (String str : hashMap.keySet()) {
            m2 = m2 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return m2;
    }

    public TransitionValues(View view) {
        this.view = view;
    }
}
