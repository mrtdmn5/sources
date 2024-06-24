package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Drawer.kt */
/* loaded from: classes.dex */
public final class DrawerKt {
    public static final float DrawerPositionalThreshold;
    public static final float EndDrawerPadding;
    public static final float DrawerVelocityThreshold = 400;
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6);

    static {
        float f = 56;
        EndDrawerPadding = f;
        DrawerPositionalThreshold = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ab  */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.compose.material.DrawerKt$ModalDrawer$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: ModalDrawer-Gs3lGvM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m181ModalDrawerGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.Modifier r35, androidx.compose.material.DrawerState r36, boolean r37, androidx.compose.ui.graphics.Shape r38, float r39, long r40, long r42, long r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m181ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: access$Scrim-Bx497Mc */
    public static final void m182access$ScrimBx497Mc(final boolean z, final Function0 function0, final Function0 function02, final long j, Composer composer, final int r15) {
        int r0;
        Modifier modifier;
        int r1;
        int r12;
        int r13;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1983403750);
        if ((r15 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r15;
        } else {
            r0 = r15;
        }
        if ((r15 & 112) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r13 = 32;
            } else {
                r13 = 16;
            }
            r0 |= r13;
        }
        if ((r15 & 896) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r12 = 256;
            } else {
                r12 = 128;
            }
            r0 |= r12;
        }
        if ((r15 & 7168) == 0) {
            if (startRestartGroup.changed(j)) {
                r1 = 2048;
            } else {
                r1 = 1024;
            }
            r0 |= r1;
        }
        if ((r0 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final String m204getString4foXLRw = Strings_androidKt.m204getString4foXLRw(1, startRestartGroup);
            startRestartGroup.startReplaceableGroup(1010561092);
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (z) {
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed = startRestartGroup.changed(function0);
                Object nextSlot = startRestartGroup.nextSlot();
                if (changed || nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) nextSlot);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed2 = startRestartGroup.changed(m204getString4foXLRw) | startRestartGroup.changed(function0);
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (changed2 || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semantics, m204getString4foXLRw);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
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
            boolean changed3 = startRestartGroup.changed(color) | startRestartGroup.changed(function02);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (changed3 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(DrawScope drawScope) {
                        DrawScope Canvas = drawScope;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        DrawScope.m386drawRectnJ9OG0$default(Canvas, j, 0L, 0L, function02.invoke().floatValue(), 118);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            CanvasKt.Canvas(then, (Function1) nextSlot3, startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    DrawerKt.m182access$ScrimBx497Mc(z, function0, function02, j, composer2, Strings.updateChangedFlags(r15 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, Composer composer) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(-1435874229);
        final DrawerKt$rememberDrawerState$1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DrawerValue drawerValue) {
                DrawerValue it = drawerValue;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        };
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object[] objArr = new Object[0];
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        SaverKt$Saver$1 Saver = SaverKt.Saver(new Function2<SaverScope, DrawerState, DrawerValue>() { // from class: androidx.compose.material.DrawerState$Companion$Saver$1
            @Override // kotlin.jvm.functions.Function2
            public final DrawerValue invoke(SaverScope saverScope, DrawerState drawerState) {
                SaverScope Saver2 = saverScope;
                DrawerState it = drawerState;
                Intrinsics.checkNotNullParameter(Saver2, "$this$Saver");
                Intrinsics.checkNotNullParameter(it, "it");
                return it.anchoredDraggableState.getCurrentValue();
            }
        }, new Function1<DrawerValue, DrawerState>() { // from class: androidx.compose.material.DrawerState$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawerState invoke(DrawerValue drawerValue) {
                DrawerValue it = drawerValue;
                Intrinsics.checkNotNullParameter(it, "it");
                return new DrawerState(it, confirmStateChange);
            }
        });
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(initialValue) | composer.changed(confirmStateChange);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, confirmStateChange);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(objArr, Saver, (Function0) rememberedValue, composer, 4);
        composer.endReplaceableGroup();
        return drawerState;
    }
}
