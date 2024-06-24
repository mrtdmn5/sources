package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SaveableStateHolder.kt */
/* loaded from: classes.dex */
public interface SaveableStateHolder {
    void SaveableStateProvider(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int r4);

    void removeState(Object obj);
}
