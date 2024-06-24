package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalBottomSheet.kt */
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    public static final float ModalBottomSheetPositionalThreshold = 56;
    public static final float ModalBottomSheetVelocityThreshold = 125;
    public static final float MaxModalBottomSheetWidth = 640;

    /* JADX WARN: Removed duplicated region for block: B:100:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0278 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r8v12, types: [androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2, kotlin.jvm.internal.Lambda] */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m191ModalBottomSheetLayoutGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, androidx.compose.material.ModalBottomSheetState r37, boolean r38, androidx.compose.ui.graphics.Shape r39, float r40, long r41, long r43, long r45, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 771
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m191ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: access$Scrim-3J-VO9M, reason: not valid java name */
    public static final void m192access$Scrim3JVO9M(final long j, final Function0 function0, final boolean z, Composer composer, final int r22) {
        int r6;
        boolean z2;
        float f;
        Modifier modifier;
        int r7;
        int r72;
        int r62;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-526532668);
        if ((r22 & 14) == 0) {
            if (startRestartGroup.changed(j)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r22;
        } else {
            r6 = r22;
        }
        if ((r22 & 112) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r72 = 32;
            } else {
                r72 = 16;
            }
            r6 |= r72;
        }
        if ((r22 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r7 = 256;
            } else {
                r7 = 128;
            }
            r6 |= r7;
        }
        if ((r6 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            if (j != Color.Unspecified) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, new TweenSpec(0, 0, null, 7), null, null, startRestartGroup, 48, 28);
                final String m204getString4foXLRw = Strings_androidKt.m204getString4foXLRw(2, startRestartGroup);
                startRestartGroup.startReplaceableGroup(1010559499);
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                if (z) {
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(function0);
                    Object nextSlot = startRestartGroup.nextSlot();
                    if (changed || nextSlot == composer$Companion$Empty$1) {
                        nextSlot = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateValue(nextSlot);
                    }
                    startRestartGroup.end(false);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) nextSlot);
                    startRestartGroup.startReplaceableGroup(511388516);
                    boolean changed2 = startRestartGroup.changed(m204getString4foXLRw) | startRestartGroup.changed(function0);
                    Object nextSlot2 = startRestartGroup.nextSlot();
                    if (changed2 || nextSlot2 == composer$Companion$Empty$1) {
                        nextSlot2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.setContentDescription(semantics, m204getString4foXLRw);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return Boolean.TRUE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateValue(nextSlot2);
                    }
                    startRestartGroup.end(false);
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) nextSlot2);
                } else {
                    modifier = companion;
                }
                startRestartGroup.end(false);
                Modifier then = SizeKt.fillMaxSize$default(companion).then(modifier);
                Color color = new Color(j);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed3 = startRestartGroup.changed(color) | startRestartGroup.changed(animateFloatAsState);
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (changed3 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(DrawScope drawScope) {
                            DrawScope Canvas = drawScope;
                            Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                            DrawScope.m386drawRectnJ9OG0$default(Canvas, j, 0L, 0L, animateFloatAsState.getValue().floatValue(), 118);
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                CanvasKt.Canvas(then, (Function1) nextSlot3, startRestartGroup, 0);
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    ModalBottomSheetKt.m192access$Scrim3JVO9M(j, function0, z, composer2, Strings.updateChangedFlags(r22 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue initialValue, boolean z, Composer composer, int r11) {
        final SpringSpec<Float> animationSpec;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-126412120);
        ModalBottomSheetKt$rememberModalBottomSheetState$1 modalBottomSheetKt$rememberModalBottomSheetState$1 = null;
        if ((r11 & 2) != 0) {
            animationSpec = SwipeableDefaults.AnimationSpec;
        } else {
            animationSpec = null;
        }
        if ((r11 & 4) != 0) {
            modalBottomSheetKt$rememberModalBottomSheetState$1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
                    ModalBottomSheetValue it = modalBottomSheetValue;
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        final ModalBottomSheetKt$rememberModalBottomSheetState$1 confirmValueChange = modalBottomSheetKt$rememberModalBottomSheetState$1;
        if ((r11 & 8) != 0) {
            z = false;
        }
        final boolean z2 = z;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Density density = (Density) composer.consume(CompositionLocalsKt.LocalDensity);
        composer.startMovableGroup(170051607, initialValue);
        Object[] objArr = {initialValue, animationSpec, Boolean.valueOf(z2), confirmValueChange, density};
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        Intrinsics.checkNotNullParameter(density, "density");
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(objArr, SaverKt.Saver(new Function2<SaverScope, ModalBottomSheetState, ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$1
            @Override // kotlin.jvm.functions.Function2
            public final ModalBottomSheetValue invoke(SaverScope saverScope, ModalBottomSheetState modalBottomSheetState2) {
                SaverScope Saver = saverScope;
                ModalBottomSheetState it = modalBottomSheetState2;
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                Intrinsics.checkNotNullParameter(it, "it");
                return it.anchoredDraggableState.getCurrentValue();
            }
        }, new Function1<ModalBottomSheetValue, ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ModalBottomSheetState invoke(ModalBottomSheetValue modalBottomSheetValue) {
                ModalBottomSheetValue it = modalBottomSheetValue;
                Intrinsics.checkNotNullParameter(it, "it");
                float f = ModalBottomSheetKt.ModalBottomSheetPositionalThreshold;
                Density density2 = density;
                Intrinsics.checkNotNullParameter(density2, "density");
                AnimationSpec<Float> animationSpec2 = animationSpec;
                Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
                Function1<ModalBottomSheetValue, Boolean> confirmValueChange2 = confirmValueChange;
                Intrinsics.checkNotNullParameter(confirmValueChange2, "confirmValueChange");
                ModalBottomSheetState modalBottomSheetState2 = new ModalBottomSheetState(it, animationSpec2, z2, confirmValueChange2);
                modalBottomSheetState2.density = density2;
                return modalBottomSheetState2;
            }
        }), new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ModalBottomSheetState invoke() {
                ModalBottomSheetValue initialValue2 = ModalBottomSheetValue.this;
                Intrinsics.checkNotNullParameter(initialValue2, "initialValue");
                Density density2 = density;
                Intrinsics.checkNotNullParameter(density2, "density");
                AnimationSpec<Float> animationSpec2 = animationSpec;
                Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
                Function1<ModalBottomSheetValue, Boolean> confirmValueChange2 = confirmValueChange;
                Intrinsics.checkNotNullParameter(confirmValueChange2, "confirmValueChange");
                ModalBottomSheetState modalBottomSheetState2 = new ModalBottomSheetState(initialValue2, animationSpec2, z2, confirmValueChange2);
                modalBottomSheetState2.density = density2;
                return modalBottomSheetState2;
            }
        }, composer, 4);
        composer.endMovableGroup();
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }
}
