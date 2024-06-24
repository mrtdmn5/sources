package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ReferentialEqualityPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import com.google.common.collect.Platform;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: RememberSaveable.kt */
/* loaded from: classes.dex */
public final class RememberSaveableKt {
    public static final Object rememberSaveable(Object[] objArr, SaverKt$Saver$1 saverKt$Saver$1, Function0 init, Composer composer, int r9) {
        Object consumeRestored;
        Intrinsics.checkNotNullParameter(init, "init");
        composer.startReplaceableGroup(441892779);
        if ((r9 & 2) != 0) {
            saverKt$Saver$1 = SaverKt.AutoSaver;
            Intrinsics.checkNotNull(saverKt$Saver$1, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1059366469);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
        CharsKt__CharKt.checkRadix(36);
        final String num = Integer.toString(currentCompositeKeyHash, 36);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        composer.endReplaceableGroup();
        Intrinsics.checkNotNull(saverKt$Saver$1, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (Object obj : copyOf) {
            z |= composer.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        Object obj2 = Composer.Companion.Empty;
        if (z || rememberedValue == obj2) {
            if (saveableStateRegistry != null && (consumeRestored = saveableStateRegistry.consumeRestored(num)) != null) {
                rememberedValue = saverKt$Saver$1.$restore.invoke(consumeRestored);
            } else {
                rememberedValue = null;
            }
            if (rememberedValue == null) {
                rememberedValue = init.invoke();
            }
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        if (saveableStateRegistry != null) {
            final MutableState rememberUpdatedState = Platform.rememberUpdatedState(saverKt$Saver$1, composer);
            final MutableState rememberUpdatedState2 = Platform.rememberUpdatedState(rememberedValue, composer);
            Function1<DisposableEffectScope, DisposableEffectResult> function1 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    String str;
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final State<Saver<Object, Object>> state = rememberUpdatedState;
                    final State<Object> state2 = rememberUpdatedState2;
                    final SaveableStateRegistry saveableStateRegistry2 = SaveableStateRegistry.this;
                    Function0<? extends Object> function0 = new Function0<Object>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Saver<Object, Object> value = state.getValue();
                            final SaveableStateRegistry saveableStateRegistry3 = saveableStateRegistry2;
                            return value.save(new SaverScope() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1
                                @Override // androidx.compose.runtime.saveable.SaverScope
                                public final boolean canBeSaved(Object obj3) {
                                    return SaveableStateRegistry.this.canBeSaved(obj3);
                                }
                            }, state2.getValue());
                        }
                    };
                    Object invoke = function0.invoke();
                    if (invoke != null && !saveableStateRegistry2.canBeSaved(invoke)) {
                        if (invoke instanceof SnapshotMutableState) {
                            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) invoke;
                            if (snapshotMutableState.getPolicy() != NeverEqualPolicy.INSTANCE && snapshotMutableState.getPolicy() != StructuralEqualityPolicy.INSTANCE && snapshotMutableState.getPolicy() != ReferentialEqualityPolicy.INSTANCE) {
                                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                            } else {
                                str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                            }
                        } else {
                            str = invoke + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
                        }
                        throw new IllegalArgumentException(str);
                    }
                    final SaveableStateRegistry.Entry registerProvider = saveableStateRegistry2.registerProvider(num, function0);
                    return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            SaveableStateRegistry.Entry.this.unregister();
                        }
                    };
                }
            };
            DisposableEffectScope disposableEffectScope = EffectsKt.InternalDisposableEffectScope;
            composer.startReplaceableGroup(1429097729);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(saveableStateRegistry) | composer.changed(num);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == obj2) {
                composer.updateRememberedValue(new DisposableEffectImpl(function1));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        return rememberedValue;
    }
}
