package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ComposedModifier.kt */
/* loaded from: classes.dex */
public final class ComposedModifierKt {
    public static final Modifier composed(Modifier modifier, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return modifier.then(new ComposedModifier(inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, Function3 function3) {
        return composed(modifier, InspectableValueKt.NoInspectorInfo, function3);
    }

    public static final Modifier materializeModifier(final Composer composer, Modifier modifier) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt$materialize$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Modifier.Element element) {
                Modifier.Element it = element;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!(it instanceof ComposedModifier));
            }
        })) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        int r0 = Modifier.$r8$clinit;
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion.$$INSTANCE, new Function2<Modifier, Modifier.Element, Modifier>() { // from class: androidx.compose.ui.ComposedModifierKt$materialize$result$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Modifier invoke(Modifier modifier3, Modifier.Element element) {
                Modifier acc = modifier3;
                Modifier.Element element2 = element;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element2, "element");
                if (element2 instanceof ComposedModifier) {
                    Function3<Modifier, Composer, Integer, Modifier> function3 = ((ComposedModifier) element2).factory;
                    Intrinsics.checkNotNull(function3, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Composer composer2 = Composer.this;
                    element2 = ComposedModifierKt.materializeModifier(composer2, function3.invoke(companion, composer2, 0));
                }
                return acc.then(element2);
            }
        });
        composer.endReplaceableGroup();
        return modifier2;
    }
}
