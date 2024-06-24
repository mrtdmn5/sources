package com.amplifyframework.devmenu;

import android.view.View;
import com.animaconnected.secondo.behaviour.counter.CounterFragment;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DevMenuMainFragment$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DevMenuMainFragment$$ExternalSyntheticLambda1(int r1) {
        this.$r8$classId = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                DevMenuMainFragment.lambda$onCreateView$1(view);
                return;
            default:
                CounterFragment.lambda$onCreateView$1(view);
                return;
        }
    }
}
