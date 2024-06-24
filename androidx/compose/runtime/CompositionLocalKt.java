package androidx.compose.runtime;

import com.google.common.base.Strings;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public final class CompositionLocalKt {
    public static final void CompositionLocalProvider(final ProvidedValue<?>[] values, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r4) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1390796515);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startProviders(values);
        content.invoke(startRestartGroup, Integer.valueOf((r4 >> 3) & 14));
        startRestartGroup.endProviders();
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    ProvidedValue<?>[] providedValueArr = values;
                    ProvidedValue[] providedValueArr2 = (ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length);
                    int updateChangedFlags = Strings.updateChangedFlags(r4 | 1);
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr2, content, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static DynamicProvidableCompositionLocal compositionLocalOf$default(Function0 defaultFactory) {
        StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        return new DynamicProvidableCompositionLocal(structuralEqualityPolicy, defaultFactory);
    }

    public static final StaticProvidableCompositionLocal staticCompositionLocalOf(Function0 defaultFactory) {
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        return new StaticProvidableCompositionLocal(defaultFactory);
    }
}
