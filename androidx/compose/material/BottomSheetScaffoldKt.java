package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: BottomSheetScaffold.kt */
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    public static final float FabSpacing = 16;
    public static final float BottomSheetScaffoldPositionalThreshold = 56;
    public static final float BottomSheetScaffoldVelocityThreshold = 125;

    /* JADX WARN: Removed duplicated region for block: B:107:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026a  */
    /* JADX WARN: Type inference failed for: r12v9, types: [androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r14v1, types: [androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2, kotlin.jvm.internal.Lambda] */
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m156BottomSheetScaffoldbGncdBI(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, androidx.compose.material.BottomSheetScaffoldState r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, int r45, boolean r46, androidx.compose.ui.graphics.Shape r47, float r48, long r49, long r51, float r53, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, boolean r55, androidx.compose.ui.graphics.Shape r56, float r57, long r58, long r60, long r62, long r64, long r66, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, androidx.compose.runtime.Composer r69, final int r70, final int r71, final int r72, final int r73) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m156BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x004d  */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3, kotlin.jvm.internal.Lambda] */
    /* renamed from: access$BottomSheet-0cLKjW4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m157access$BottomSheet0cLKjW4(final androidx.compose.material.BottomSheetState r28, final boolean r29, final kotlin.jvm.functions.Function1 r30, final androidx.compose.ui.graphics.Shape r31, final float r32, final long r33, final long r35, androidx.compose.ui.Modifier r37, final kotlin.jvm.functions.Function3 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m157access$BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* renamed from: access$BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m158access$BottomSheetScaffoldLayoutKCBPh4w(final Function2 function2, final Function3 function3, final Function3 function32, final Function2 function22, final Function2 function23, final float f, final int r24, final Function0 function0, final BottomSheetState bottomSheetState, Composer composer, final int r28) {
        int r0;
        ?? r12;
        int r1;
        int r13;
        int r14;
        int r15;
        int r16;
        int r17;
        int r18;
        int r19;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1621720523);
        if ((r28 & 14) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r28;
        } else {
            r0 = r28;
        }
        if ((r28 & 112) == 0) {
            if (startRestartGroup.changedInstance(function3)) {
                r19 = 32;
            } else {
                r19 = 16;
            }
            r0 |= r19;
        }
        if ((r28 & 896) == 0) {
            if (startRestartGroup.changedInstance(function32)) {
                r18 = 256;
            } else {
                r18 = 128;
            }
            r0 |= r18;
        }
        if ((r28 & 7168) == 0) {
            if (startRestartGroup.changedInstance(function22)) {
                r17 = 2048;
            } else {
                r17 = 1024;
            }
            r0 |= r17;
        }
        if ((57344 & r28) == 0) {
            if (startRestartGroup.changedInstance(function23)) {
                r16 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r16 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r0 |= r16;
        }
        if ((458752 & r28) == 0) {
            if (startRestartGroup.changed(f)) {
                r15 = 131072;
            } else {
                r15 = 65536;
            }
            r0 |= r15;
        }
        if ((3670016 & r28) == 0) {
            if (startRestartGroup.changed(r24)) {
                r14 = Constants.MB;
            } else {
                r14 = 524288;
            }
            r0 |= r14;
        }
        if ((29360128 & r28) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r13 = 8388608;
            } else {
                r13 = 4194304;
            }
            r0 |= r13;
        }
        if ((234881024 & r28) == 0) {
            if (startRestartGroup.changed(bottomSheetState)) {
                r1 = 67108864;
            } else {
                r1 = 33554432;
            }
            r0 |= r1;
        }
        final int r162 = r0;
        if ((r162 & 191739611) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Object[] objArr = {function32, function0, function2, function3, new Dp(f), function22, new FabPosition(r24), function23, bottomSheetState};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z = false;
            for (int r110 = 0; r110 < 9; r110++) {
                z |= startRestartGroup.changed(objArr[r110]);
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (!z && nextSlot != Composer.Companion.Empty) {
                r12 = 0;
            } else {
                r12 = 0;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function24 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1

                    /* compiled from: BottomSheetScaffold.kt */
                    /* loaded from: classes.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] r0 = new int[BottomSheetValue.values().length];
                            try {
                                r0[BottomSheetValue.Collapsed.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                r0[BottomSheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = r0;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:105:0x01fb  */
                    /* JADX WARN: Removed duplicated region for block: B:106:0x01db  */
                    /* JADX WARN: Removed duplicated region for block: B:107:0x01d3  */
                    /* JADX WARN: Removed duplicated region for block: B:128:0x0158  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0119 A[LOOP:2: B:23:0x0113->B:25:0x0119, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:29:0x012b  */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x015b  */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x0192  */
                    /* JADX WARN: Removed duplicated region for block: B:51:0x01d1  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x01d7  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x01f1  */
                    /* JADX WARN: Removed duplicated region for block: B:61:0x021c A[LOOP:4: B:59:0x0216->B:61:0x021c, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:65:0x0230  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x025b  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x0265  */
                    /* JADX WARN: Removed duplicated region for block: B:74:0x0292  */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x02b0  */
                    /* JADX WARN: Removed duplicated region for block: B:84:0x02bb  */
                    /* JADX WARN: Removed duplicated region for block: B:85:0x0295  */
                    /* JADX WARN: Removed duplicated region for block: B:86:0x0267  */
                    /* JADX WARN: Removed duplicated region for block: B:95:0x025e  */
                    /* JADX WARN: Removed duplicated region for block: B:96:0x0232  */
                    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1, kotlin.jvm.internal.Lambda] */
                    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceables$1, kotlin.jvm.internal.Lambda] */
                    @Override // kotlin.jvm.functions.Function2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.ui.layout.MeasureResult invoke(androidx.compose.ui.layout.SubcomposeMeasureScope r24, androidx.compose.ui.unit.Constraints r25) {
                        /*
                            Method dump skipped, instructions count: 726
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                    }
                };
                startRestartGroup.updateValue(function24);
                nextSlot = function24;
            }
            startRestartGroup.end(r12);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) nextSlot, startRestartGroup, r12, 1);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    BottomSheetScaffoldKt.m158access$BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, f, r24, function0, bottomSheetState, composer2, Strings.updateChangedFlags(r28 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(Composer composer) {
        composer.startReplaceableGroup(-1353009744);
        DrawerState rememberDrawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, composer);
        final BottomSheetValue initialValue = BottomSheetValue.Collapsed;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        final SpringSpec<Float> springSpec = SwipeableDefaults.AnimationSpec;
        final BottomSheetScaffoldKt$rememberBottomSheetState$1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BottomSheetValue bottomSheetValue) {
                BottomSheetValue it = bottomSheetValue;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        };
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Density density = (Density) composer.consume(CompositionLocalsKt.LocalDensity);
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        Intrinsics.checkNotNullParameter(density, "density");
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{springSpec}, SaverKt.Saver(new Function2<SaverScope, BottomSheetState, BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$1
            @Override // kotlin.jvm.functions.Function2
            public final BottomSheetValue invoke(SaverScope saverScope, BottomSheetState bottomSheetState2) {
                SaverScope Saver = saverScope;
                BottomSheetState it = bottomSheetState2;
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                Intrinsics.checkNotNullParameter(it, "it");
                return it.anchoredDraggableState.getCurrentValue();
            }
        }, new Function1<BottomSheetValue, BottomSheetState>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetState invoke(BottomSheetValue bottomSheetValue) {
                BottomSheetValue it = bottomSheetValue;
                Intrinsics.checkNotNullParameter(it, "it");
                float f = BottomSheetScaffoldKt.FabSpacing;
                Density density2 = density;
                Intrinsics.checkNotNullParameter(density2, "density");
                AnimationSpec<Float> animationSpec = springSpec;
                Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
                Function1<BottomSheetValue, Boolean> confirmValueChange = confirmStateChange;
                Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
                BottomSheetState bottomSheetState2 = new BottomSheetState(it, animationSpec, confirmValueChange);
                bottomSheetState2.density = density2;
                return bottomSheetState2;
            }
        }), new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                BottomSheetValue initialValue2 = BottomSheetValue.this;
                Intrinsics.checkNotNullParameter(initialValue2, "initialValue");
                Density density2 = density;
                Intrinsics.checkNotNullParameter(density2, "density");
                AnimationSpec<Float> animationSpec = springSpec;
                Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
                Function1<BottomSheetValue, Boolean> confirmValueChange = confirmStateChange;
                Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
                BottomSheetState bottomSheetState2 = new BottomSheetState(initialValue2, animationSpec, confirmValueChange);
                bottomSheetState2.density = density2;
                return bottomSheetState2;
            }
        }, composer, 4);
        composer.endReplaceableGroup();
        Object obj = Composer.Companion.Empty;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == obj) {
            rememberedValue = new SnackbarHostState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SnackbarHostState snackbarHostState = (SnackbarHostState) rememberedValue;
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(rememberDrawerState) | composer.changed(bottomSheetState) | composer.changed(snackbarHostState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == obj) {
            rememberedValue2 = new BottomSheetScaffoldState(rememberDrawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }
}
