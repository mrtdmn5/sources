package androidx.work.impl.constraints;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(List<String> workSpecIds);

    void onAllConstraintsNotMet(ArrayList workSpecIds);
}
