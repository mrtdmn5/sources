package androidx.compose.foundation.text;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: CoreTextField.kt */
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0513, code lost:            if (r8.fontFamilyResolver == r2) goto L288;     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0608, code lost:            if (r11 > ((r3 != null ? r3.longValue() : 0) + 5000)) goto L328;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07fa  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0360 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x038e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03bf A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v47, types: [androidx.compose.ui.Modifier] */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.runtime.Composer, androidx.compose.runtime.ComposerImpl] */
    /* JADX WARN: Type inference failed for: r12v21, types: [androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1] */
    /* JADX WARN: Type inference failed for: r3v65, types: [androidx.compose.ui.Modifier] */
    /* JADX WARN: Type inference failed for: r9v26, types: [androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r54, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r55, androidx.compose.ui.Modifier r56, androidx.compose.ui.text.TextStyle r57, androidx.compose.ui.text.input.VisualTransformation r58, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r59, androidx.compose.foundation.interaction.MutableInteractionSource r60, androidx.compose.ui.graphics.Brush r61, boolean r62, int r63, int r64, androidx.compose.ui.text.input.ImeOptions r65, androidx.compose.foundation.text.KeyboardActions r66, boolean r67, boolean r68, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, androidx.compose.runtime.Composer r70, final int r71, final int r72, final int r73) {
        /*
            Method dump skipped, instructions count: 2360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int r12) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, true, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int r0 = ((((((r12 & 14) | 384) << 3) & 112) << 9) & 7168) | 6;
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r0 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            startRestartGroup.startReplaceableGroup(-1985516685);
            function2.invoke(startRestartGroup, Integer.valueOf(((((r12 >> 3) & 112) | 8) >> 3) & 14));
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            startRestartGroup.end(false);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        int updateChangedFlags = Strings.updateChangedFlags(r12 | 1);
                        TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, textFieldSelectionManager2, function22, composer2, updateChangedFlags);
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:            if (((java.lang.Boolean) r0.showCursorHandle$delegate.getValue()).booleanValue() == true) goto L8;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextFieldCursorHandle(final androidx.compose.foundation.text.selection.TextFieldSelectionManager r9, androidx.compose.runtime.Composer r10, final int r11) {
        /*
            java.lang.String r0 = "manager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1436003720(0xffffffffaa685278, float:-2.0634351E-13)
            androidx.compose.runtime.ComposerImpl r10 = r10.startRestartGroup(r0)
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r0 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            androidx.compose.foundation.text.TextFieldState r0 = r9.state
            r1 = 0
            if (r0 == 0) goto L23
            androidx.compose.runtime.ParcelableSnapshotMutableState r0 = r0.showCursorHandle$delegate
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            if (r0 != r2) goto L23
            goto L24
        L23:
            r2 = r1
        L24:
            if (r2 == 0) goto Ld1
            r0 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r0)
            boolean r2 = r10.changed(r9)
            java.lang.Object r3 = r10.nextSlot()
            androidx.compose.runtime.Composer$Companion$Empty$1 r4 = androidx.compose.runtime.Composer.Companion.Empty
            if (r2 != 0) goto L3a
            if (r3 != r4) goto L42
        L3a:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1 r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            r3.<init>()
            r10.updateValue(r3)
        L42:
            r10.end(r1)
            androidx.compose.foundation.text.TextDragObserver r3 = (androidx.compose.foundation.text.TextDragObserver) r3
            androidx.compose.runtime.StaticProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.LocalDensity
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            java.lang.String r5 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            androidx.compose.ui.text.input.OffsetMapping r5 = r9.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r6 = r9.getValue$foundation_release()
            long r6 = r6.selection
            int r8 = androidx.compose.ui.text.TextRange.$r8$clinit
            r8 = 32
            long r6 = r6 >> r8
            int r6 = (int) r6
            int r5 = r5.originalToTransformed(r6)
            androidx.compose.foundation.text.TextFieldState r6 = r9.state
            r7 = 0
            if (r6 == 0) goto L70
            androidx.compose.foundation.text.TextLayoutResultProxy r6 = r6.getLayoutResult()
            goto L71
        L70:
            r6 = r7
        L71:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.compose.ui.text.TextLayoutResult r6 = r6.value
            androidx.compose.ui.text.TextLayoutInput r8 = r6.layoutInput
            androidx.compose.ui.text.AnnotatedString r8 = r8.text
            int r8 = r8.length()
            int r5 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r5, r1, r8)
            androidx.compose.ui.geometry.Rect r5 = r6.getCursorRect(r5)
            float r6 = androidx.compose.foundation.text.TextFieldCursorKt.DefaultCursorThickness
            float r2 = r2.mo49toPx0680j_4(r6)
            r6 = 2
            float r6 = (float) r6
            float r2 = r2 / r6
            float r6 = r5.left
            float r2 = r2 + r6
            float r5 = r5.bottom
            long r5 = androidx.compose.ui.geometry.OffsetKt.Offset(r2, r5)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1
            r8.<init>(r3, r7)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r2, r3, r8)
            androidx.compose.ui.geometry.Offset r3 = new androidx.compose.ui.geometry.Offset
            r3.<init>(r5)
            r10.startReplaceableGroup(r0)
            boolean r0 = r10.changed(r3)
            java.lang.Object r3 = r10.nextSlot()
            if (r0 != 0) goto Lb7
            if (r3 != r4) goto Lbf
        Lb7:
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
            r3.<init>()
            r10.updateValue(r3)
        Lbf:
            r10.end(r1)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r2, r1, r3)
            r4 = 0
            r0 = 384(0x180, float:5.38E-43)
            r1 = r5
            r5 = r10
            r6 = r0
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt.m113CursorHandleULxng0E(r1, r3, r4, r5, r6)
        Ld1:
            androidx.compose.runtime.RecomposeScopeImpl r10 = r10.endRestartGroup()
            if (r10 != 0) goto Ld8
            goto Ldf
        Ld8:
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3
            r0.<init>()
            r10.block = r0
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:            if ((!r2) != false) goto L18;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void access$SelectionToolbarAndHandles(final androidx.compose.foundation.text.selection.TextFieldSelectionManager r7, final boolean r8, androidx.compose.runtime.Composer r9, final int r10) {
        /*
            r0 = 626339208(0x25552d88, float:1.8490232E-16)
            androidx.compose.runtime.ComposerImpl r9 = r9.startRestartGroup(r0)
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r0 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            if (r8 == 0) goto Ld1
            androidx.compose.foundation.text.TextFieldState r0 = r7.state
            r1 = 1
            if (r0 == 0) goto L26
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 == 0) goto L26
            androidx.compose.ui.text.TextLayoutResult r0 = r0.value
            if (r0 == 0) goto L26
            androidx.compose.foundation.text.TextFieldState r2 = r7.state
            if (r2 == 0) goto L21
            boolean r2 = r2.isLayoutResultStale
            goto L22
        L21:
            r2 = r1
        L22:
            r2 = r2 ^ r1
            if (r2 == 0) goto L26
            goto L27
        L26:
            r0 = 0
        L27:
            if (r0 != 0) goto L2b
            goto Ld4
        L2b:
            androidx.compose.ui.text.input.TextFieldValue r2 = r7.getValue$foundation_release()
            long r2 = r2.selection
            boolean r2 = androidx.compose.ui.text.TextRange.m522getCollapsedimpl(r2)
            r3 = 0
            if (r2 != 0) goto La4
            androidx.compose.ui.text.input.OffsetMapping r2 = r7.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r4 = r7.getValue$foundation_release()
            long r4 = r4.selection
            r6 = 32
            long r4 = r4 >> r6
            int r4 = (int) r4
            int r2 = r2.originalToTransformed(r4)
            androidx.compose.ui.text.input.OffsetMapping r4 = r7.offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r5 = r7.getValue$foundation_release()
            long r5 = r5.selection
            int r5 = androidx.compose.ui.text.TextRange.m523getEndimpl(r5)
            int r4 = r4.originalToTransformed(r5)
            androidx.compose.ui.text.style.ResolvedTextDirection r2 = r0.getBidiRunDirection(r2)
            int r4 = r4 - r1
            int r4 = java.lang.Math.max(r4, r3)
            androidx.compose.ui.text.style.ResolvedTextDirection r0 = r0.getBidiRunDirection(r4)
            r4 = -498388703(0xffffffffe24b3121, float:-9.370573E20)
            r9.startReplaceableGroup(r4)
            androidx.compose.foundation.text.TextFieldState r4 = r7.state
            if (r4 == 0) goto L7f
            androidx.compose.runtime.ParcelableSnapshotMutableState r4 = r4.showSelectionHandleStart$delegate
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != r1) goto L7f
            r4 = r1
            goto L80
        L7f:
            r4 = r3
        L80:
            r5 = 518(0x206, float:7.26E-43)
            if (r4 == 0) goto L87
            androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.TextFieldSelectionHandle(r1, r2, r7, r9, r5)
        L87:
            r9.end(r3)
            androidx.compose.foundation.text.TextFieldState r2 = r7.state
            if (r2 == 0) goto L9e
            androidx.compose.runtime.ParcelableSnapshotMutableState r2 = r2.showSelectionHandleEnd$delegate
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != r1) goto L9e
            r2 = r1
            goto L9f
        L9e:
            r2 = r3
        L9f:
            if (r2 == 0) goto La4
            androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.TextFieldSelectionHandle(r3, r0, r7, r9, r5)
        La4:
            androidx.compose.foundation.text.TextFieldState r0 = r7.state
            if (r0 == 0) goto Ld4
            androidx.compose.ui.text.input.TextFieldValue r2 = r7.oldValue
            androidx.compose.ui.text.AnnotatedString r2 = r2.annotatedString
            java.lang.String r2 = r2.text
            androidx.compose.ui.text.input.TextFieldValue r4 = r7.getValue$foundation_release()
            androidx.compose.ui.text.AnnotatedString r4 = r4.annotatedString
            java.lang.String r4 = r4.text
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            r1 = r1 ^ r2
            if (r1 == 0) goto Lbf
            r0.showFloatingToolbar = r3
        Lbf:
            boolean r1 = r0.getHasFocus()
            if (r1 == 0) goto Ld4
            boolean r0 = r0.showFloatingToolbar
            if (r0 == 0) goto Lcd
            r7.showSelectionToolbar$foundation_release()
            goto Ld4
        Lcd:
            r7.hideSelectionToolbar$foundation_release()
            goto Ld4
        Ld1:
            r7.hideSelectionToolbar$foundation_release()
        Ld4:
            androidx.compose.runtime.RecomposeScopeImpl r9 = r9.endRestartGroup()
            if (r9 != 0) goto Ldb
            goto Le2
        Ldb:
            androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
            r0.<init>()
            r9.block = r0
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.access$SelectionToolbarAndHandles(androidx.compose.foundation.text.selection.TextFieldSelectionManager, boolean, androidx.compose.runtime.Composer, int):void");
    }

    public static final void access$endInputSession(TextFieldState textFieldState) {
        boolean z;
        TextInputSession textInputSession = textFieldState.inputSession;
        if (textInputSession != null) {
            EditProcessor editProcessor = textFieldState.processor;
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            TextFieldState$onValueChange$1 onValueChange = textFieldState.onValueChange;
            Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
            onValueChange.invoke(TextFieldValue.m545copy3r_uNRQ$default(editProcessor.mBufferState, null, 0L, 3));
            TextInputService textInputService = textInputSession.textInputService;
            textInputService.getClass();
            AtomicReference<TextInputSession> atomicReference = textInputService._currentInputSession;
            while (true) {
                if (atomicReference.compareAndSet(textInputSession, null)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != textInputSession) {
                    z = false;
                    break;
                }
            }
            if (z) {
                textInputService.platformTextInputService.stopInput();
            }
        }
        textFieldState.inputSession = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object, androidx.compose.ui.text.input.TextInputSession] */
    public static final void access$startInputSession(TextFieldState textFieldState, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldValue value, TextInputService textInputService) {
        EditProcessor editProcessor = textFieldState.processor;
        Intrinsics.checkNotNullParameter(textInputService, "textInputService");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        TextFieldState$onValueChange$1 onValueChange = textFieldState.onValueChange;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        TextFieldState$onImeActionPerformed$1 onImeActionPerformed = textFieldState.onImeActionPerformed;
        Intrinsics.checkNotNullParameter(onImeActionPerformed, "onImeActionPerformed");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TextFieldDelegate$Companion$restartInput$1 textFieldDelegate$Companion$restartInput$1 = new TextFieldDelegate$Companion$restartInput$1(editProcessor, onValueChange, ref$ObjectRef);
        PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
        platformTextInputService.startInput(value, imeOptions, textFieldDelegate$Companion$restartInput$1, onImeActionPerformed);
        ?? textInputSession = new TextInputSession(textInputService, platformTextInputService);
        textInputService._currentInputSession.set(textInputSession);
        ref$ObjectRef.element = textInputSession;
        textFieldState.inputSession = textInputSession;
        notifyFocusedRect(textFieldState, value, offsetMapping);
    }

    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(SnapshotKt.threadSnapshot.get(), null, false);
        try {
            Snapshot makeCurrent = createTransparentSnapshotWithNoParentReadObserver.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession textInputSession = textFieldState.inputSession;
                if (textInputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = textFieldState.layoutCoordinates;
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate$Companion.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.textDelegate, layoutResult.value, layoutCoordinates, textInputSession, textFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                Snapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createTransparentSnapshotWithNoParentReadObserver.dispose();
        }
    }
}
