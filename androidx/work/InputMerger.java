package androidx.work;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class InputMerger {
    public static final String TAG = Logger.tagWithPrefix("InputMerger");

    public abstract Data merge(ArrayList inputs);
}
