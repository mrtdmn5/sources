package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class ScaffoldKt {
    public static final StaticProvidableCompositionLocal LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ FabPlacement invoke() {
            return null;
        }
    });
    public static final float FabSpacing = 16;

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01bc, code lost:            if (r0.changed(r58) == false) goto L146;     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0237  */
    /* JADX WARN: Type inference failed for: r12v1, types: [androidx.compose.material.ScaffoldKt$Scaffold$child$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r6v26, types: [androidx.compose.material.ScaffoldKt$Scaffold$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m199Scaffold27mzLpw(androidx.compose.ui.Modifier r44, androidx.compose.material.ScaffoldState r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, int r50, boolean r51, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, boolean r53, androidx.compose.ui.graphics.Shape r54, float r55, long r56, long r58, long r60, long r62, long r64, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, androidx.compose.runtime.Composer r67, final int r68, final int r69, final int r70) {
        /*
            Method dump skipped, instructions count: 1260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m199Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* renamed from: access$ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m200access$ScaffoldLayoutMDYNRJg(final boolean z, final int r18, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final Function2 function24, Composer composer, final int r25) {
        int r0;
        ?? r10;
        int r2;
        int r22;
        int r1;
        int r12;
        int r13;
        int r14;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1401632215);
        if ((r25 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r25;
        } else {
            r0 = r25;
        }
        if ((r25 & 112) == 0) {
            if (startRestartGroup.changed(r18)) {
                r14 = 32;
            } else {
                r14 = 16;
            }
            r0 |= r14;
        }
        if ((r25 & 896) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r13 = 256;
            } else {
                r13 = 128;
            }
            r0 |= r13;
        }
        if ((r25 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function3)) {
                r12 = 2048;
            } else {
                r12 = 1024;
            }
            r0 |= r12;
        }
        if ((57344 & r25) == 0) {
            if (startRestartGroup.changedInstance(function22)) {
                r1 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r1 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r0 |= r1;
        }
        if ((458752 & r25) == 0) {
            if (startRestartGroup.changedInstance(function23)) {
                r22 = 131072;
            } else {
                r22 = 65536;
            }
            r0 |= r22;
        }
        if ((3670016 & r25) == 0) {
            if (startRestartGroup.changedInstance(function24)) {
                r2 = Constants.MB;
            } else {
                r2 = 524288;
            }
            r0 |= r2;
        }
        final int r16 = r0;
        if ((r16 & 2995931) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Object[] objArr = {function2, function22, function23, new FabPosition(r18), Boolean.valueOf(z), function24, function3};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z2 = false;
            for (int r23 = 0; r23 < 7; r23++) {
                z2 |= startRestartGroup.changed(objArr[r23]);
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (!z2 && nextSlot != Composer.Companion.Empty) {
                r10 = 0;
            } else {
                r10 = 0;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        final SubcomposeMeasureScope SubcomposeLayout = subcomposeMeasureScope;
                        long j = constraints.value;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                        final int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
                        final long m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 10);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int r6 = r18;
                        final boolean z3 = z;
                        final Function2<Composer, Integer, Unit> function29 = function24;
                        final int r7 = r16;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return SubcomposeLayout.layout(m565getMaxWidthimpl, m564getMaxHeightimpl, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            /* JADX WARN: Removed duplicated region for block: B:109:0x022a  */
                            /* JADX WARN: Removed duplicated region for block: B:114:0x021d  */
                            /* JADX WARN: Removed duplicated region for block: B:115:0x01fa  */
                            /* JADX WARN: Removed duplicated region for block: B:116:0x01cf  */
                            /* JADX WARN: Removed duplicated region for block: B:53:0x01b4 A[LOOP:3: B:52:0x01b2->B:53:0x01b4, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:57:0x01cd  */
                            /* JADX WARN: Removed duplicated region for block: B:60:0x01f7  */
                            /* JADX WARN: Removed duplicated region for block: B:62:0x01fd  */
                            /* JADX WARN: Removed duplicated region for block: B:68:0x0220  */
                            /* JADX WARN: Removed duplicated region for block: B:73:0x0258 A[LOOP:4: B:72:0x0256->B:73:0x0258, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:78:0x028a A[LOOP:5: B:76:0x0287->B:78:0x028a, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:82:0x029e A[LOOP:6: B:81:0x029c->B:82:0x029e, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:86:0x02b2 A[LOOP:7: B:85:0x02b0->B:86:0x02b2, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:90:0x02c8 A[LOOP:8: B:89:0x02c6->B:90:0x02c8, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:94:0x02df  */
                            /* JADX WARN: Type inference failed for: r11v15, types: [androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1, kotlin.jvm.internal.Lambda] */
                            /* JADX WARN: Type inference failed for: r15v8, types: [androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1, kotlin.jvm.internal.Lambda] */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final kotlin.Unit invoke(androidx.compose.ui.layout.Placeable.PlacementScope r28) {
                                /*
                                    Method dump skipped, instructions count: 766
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                            }
                        });
                    }
                };
                startRestartGroup.updateValue(function25);
                nextSlot = function25;
            }
            startRestartGroup.end(r10);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) nextSlot, startRestartGroup, r10, 1);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    ScaffoldKt.m200access$ScaffoldLayoutMDYNRJg(z, r18, function2, function3, function22, function23, function24, composer2, Strings.updateChangedFlags(r25 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
