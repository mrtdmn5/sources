package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public interface SubcomposeMeasureScope extends MeasureScope {
    List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2);
}
