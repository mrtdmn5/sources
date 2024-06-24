package androidx.compose.material;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.R;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Slider.kt */
/* loaded from: classes.dex */
public final class SliderKt {
    public static final float ThumbRadius = 10;
    public static final float ThumbRippleRadius = 24;
    public static final float ThumbDefaultElevation = 1;
    public static final float ThumbPressedElevation = 6;
    public static final float TrackHeight = 4;
    public static final Modifier DefaultSliderConstraints = SizeKt.m85heightInVpY3zN4$default(SizeKt.m95widthInVpY3zN4$default(Modifier.Companion.$$INSTANCE, R.styleable.AppTheme_stepsHistoryGoalLineColorDetail, 0.0f, 2), 0.0f, 48, 1);
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0190  */
    /* JADX WARN: Type inference failed for: r0v36, types: [kotlin.collections.EmptyList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Slider(final float r41, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r42, androidx.compose.ui.Modifier r43, boolean r44, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r45, int r46, kotlin.jvm.functions.Function0<kotlin.Unit> r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.material.SliderColors r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 890
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m201SliderThumbPcYyNuk(final BoxScope boxScope, final Modifier modifier, final float f, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z, final float f2, Composer composer, final int r24) {
        int r3;
        float f3;
        int r10;
        int r102;
        int r103;
        int r104;
        int r105;
        int r9;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(428907178);
        if ((r24 & 14) == 0) {
            if (startRestartGroup.changed(boxScope)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r24;
        } else {
            r3 = r24;
        }
        if ((r24 & 112) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r9 = 32;
            } else {
                r9 = 16;
            }
            r3 |= r9;
        }
        if ((r24 & 896) == 0) {
            if (startRestartGroup.changed(f)) {
                r105 = 256;
            } else {
                r105 = 128;
            }
            r3 |= r105;
        }
        if ((r24 & 7168) == 0) {
            if (startRestartGroup.changed(mutableInteractionSource)) {
                r104 = 2048;
            } else {
                r104 = 1024;
            }
            r3 |= r104;
        }
        if ((57344 & r24) == 0) {
            if (startRestartGroup.changed(sliderColors)) {
                r103 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r103 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r3 |= r103;
        }
        if ((458752 & r24) == 0) {
            if (startRestartGroup.changed(z)) {
                r102 = 131072;
            } else {
                r102 = 65536;
            }
            r3 |= r102;
        }
        if ((3670016 & r24) == 0) {
            if (startRestartGroup.changed(f2)) {
                r10 = Constants.MB;
            } else {
                r10 = 524288;
            }
            r3 |= r10;
        }
        if ((r3 & 2995931) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier align = boxScope.align(PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, f, 0.0f, 0.0f, 0.0f, 14), Alignment.Companion.CenterStart);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(align);
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
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-492369756);
                Object nextSlot = startRestartGroup.nextSlot();
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                if (nextSlot == composer$Companion$Empty$1) {
                    nextSlot = new SnapshotStateList();
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                SnapshotStateList snapshotStateList = (SnapshotStateList) nextSlot;
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed = startRestartGroup.changed(mutableInteractionSource) | startRestartGroup.changed(snapshotStateList);
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (changed || nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                    startRestartGroup.updateValue(nextSlot2);
                }
                startRestartGroup.end(false);
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2) nextSlot2, startRestartGroup);
                if (!snapshotStateList.isEmpty()) {
                    f3 = ThumbPressedElevation;
                } else {
                    f3 = ThumbDefaultElevation;
                }
                Modifier hoverable = HoverableKt.hoverable(mutableInteractionSource, IndicationKt.indication(SizeKt.m92sizeVpY3zN4(modifier, f2, f2), mutableInteractionSource, RippleKt.m226rememberRipple9IZ8Weo(false, ThumbRippleRadius, startRestartGroup, 54, 4)), true);
                if (!z) {
                    f3 = 0;
                }
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                SpacerKt.Spacer(BackgroundKt.m21backgroundbw27NRU(ShadowKt.m235shadows4CzXII$default(hoverable, f3, roundedCornerShape), ((Color) sliderColors.thumbColor(z, startRestartGroup).getValue()).value, roundedCornerShape), startRestartGroup, 0);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderThumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SliderKt.m201SliderThumbPcYyNuk(BoxScope.this, modifier, f, mutableInteractionSource, sliderColors, z, f2, composer2, Strings.updateChangedFlags(r24 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void Track(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f2, final List<Float> list, final float f3, final float f4, Composer composer, final int r23) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1833126050);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final MutableState trackColor = sliderColors.trackColor(z, false, startRestartGroup);
        final MutableState trackColor2 = sliderColors.trackColor(z, true, startRestartGroup);
        final MutableState tickColor = sliderColors.tickColor(z, false, startRestartGroup);
        final MutableState tickColor2 = sliderColors.tickColor(z, true, startRestartGroup);
        CanvasKt.Canvas(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SliderKt$Track$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(DrawScope drawScope) {
                boolean z2;
                long j;
                long j2;
                State<Color> state;
                boolean z3;
                DrawScope Canvas = drawScope;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                if (Canvas.getLayoutDirection() == LayoutDirection.Rtl) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                float m260getYimpl = Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0());
                float f5 = f3;
                long Offset = OffsetKt.Offset(f5, m260getYimpl);
                long Offset2 = OffsetKt.Offset(Size.m276getWidthimpl(Canvas.mo391getSizeNHjbRc()) - f5, Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0()));
                if (z2) {
                    j = Offset2;
                } else {
                    j = Offset;
                }
                if (z2) {
                    j2 = Offset;
                } else {
                    j2 = Offset2;
                }
                long j3 = j2;
                DrawScope.m382drawLineNGM6Ib0$default(Canvas, trackColor.getValue().value, j, j2, f4, 1, 480);
                float m259getXimpl = Offset.m259getXimpl(j);
                float m259getXimpl2 = Offset.m259getXimpl(j3) - Offset.m259getXimpl(j);
                float f6 = f2;
                long Offset3 = OffsetKt.Offset((m259getXimpl2 * f6) + m259getXimpl, Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0()));
                float m259getXimpl3 = Offset.m259getXimpl(j);
                float m259getXimpl4 = Offset.m259getXimpl(j3) - Offset.m259getXimpl(j);
                float f7 = f;
                DrawScope.m382drawLineNGM6Ib0$default(Canvas, trackColor2.getValue().value, OffsetKt.Offset((m259getXimpl4 * f7) + m259getXimpl3, Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0())), Offset3, f4, 1, 480);
                List<Float> list2 = list;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : list2) {
                    float floatValue = ((Number) obj).floatValue();
                    if (floatValue <= f6 && floatValue >= f7) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z3);
                    Object obj2 = linkedHashMap.get(valueOf);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(valueOf, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                float f8 = f4;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list3 = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list3, 10));
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Offset(OffsetKt.Offset(Offset.m259getXimpl(OffsetKt.m267lerpWko1d7g(j, j3, ((Number) it.next()).floatValue())), Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0()))));
                    }
                    long j4 = j3;
                    if (booleanValue) {
                        state = tickColor;
                    } else {
                        state = tickColor2;
                    }
                    Canvas.mo365drawPointsF8ZwMP8(arrayList, state.getValue().value, f8, 1, null, 1.0f, null, 3);
                    j3 = j4;
                }
                return Unit.INSTANCE;
            }
        }, startRestartGroup, r23 & 14);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$Track$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SliderKt.Track(Modifier.this, sliderColors, z, f, f2, list, f3, f4, composer2, Strings.updateChangedFlags(r23 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$CorrectValueSideEffect(final Function1 function1, final ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final MutableState mutableState, final float f, Composer composer, final int r15) {
        int r0;
        int r1;
        int r12;
        int r13;
        int r14;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-743965752);
        if ((r15 & 14) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r15;
        } else {
            r0 = r15;
        }
        if ((r15 & 112) == 0) {
            if (startRestartGroup.changed(closedFloatingPointRange)) {
                r14 = 32;
            } else {
                r14 = 16;
            }
            r0 |= r14;
        }
        if ((r15 & 896) == 0) {
            if (startRestartGroup.changed(closedFloatingPointRange2)) {
                r13 = 256;
            } else {
                r13 = 128;
            }
            r0 |= r13;
        }
        if ((r15 & 7168) == 0) {
            if (startRestartGroup.changed(mutableState)) {
                r12 = 2048;
            } else {
                r12 = 1024;
            }
            r0 |= r12;
        }
        if ((57344 & r15) == 0) {
            if (startRestartGroup.changed(f)) {
                r1 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r1 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r0 |= r1;
        }
        if ((r0 & 46811) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Object[] objArr = {closedFloatingPointRange, function1, Float.valueOf(f), mutableState, closedFloatingPointRange2};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z = false;
            for (int r2 = 0; r2 < 5; r2++) {
                z |= startRestartGroup.changed(objArr[r2]);
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRange;
                        float floatValue = (closedFloatingPointRange3.getEndInclusive().floatValue() - closedFloatingPointRange3.getStart().floatValue()) / 1000;
                        float floatValue2 = function1.invoke(Float.valueOf(f)).floatValue();
                        MutableState<Float> mutableState2 = mutableState;
                        if (Math.abs(floatValue2 - mutableState2.getValue().floatValue()) > floatValue) {
                            if (closedFloatingPointRange2.contains(mutableState2.getValue())) {
                                mutableState2.setValue(Float.valueOf(floatValue2));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            EffectsKt.SideEffect((Function0) nextSlot, startRestartGroup);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$CorrectValueSideEffect$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SliderKt.access$CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer2, Strings.updateChangedFlags(r15 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$SliderImpl(final boolean z, final float f, final List list, final SliderColors sliderColors, final float f2, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int r27) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1679682785);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier then = modifier.then(DefaultSliderConstraints);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.LocalDensity);
            float mo49toPx0680j_4 = density.mo49toPx0680j_4(TrackHeight);
            float f3 = ThumbRadius;
            float mo49toPx0680j_42 = density.mo49toPx0680j_4(f3);
            float mo45toDpu2uoSUM = density.mo45toDpu2uoSUM(f2) * f;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int r10 = r27 >> 6;
            Track(SizeKt.fillMaxSize$default(companion), sliderColors, z, 0.0f, f, list, mo49toPx0680j_42, mo49toPx0680j_4, startRestartGroup, (r10 & 112) | 265222 | ((r27 << 6) & 896) | ((r27 << 9) & 57344));
            m201SliderThumbPcYyNuk(boxScopeInstance, companion, mo45toDpu2uoSUM, mutableInteractionSource, sliderColors, z, f3 * 2, startRestartGroup, (r10 & 7168) | 1572918 | ((r27 << 3) & 57344) | ((r27 << 15) & 458752));
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SliderKt$SliderImpl$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        SliderKt.access$SliderImpl(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, composer2, Strings.updateChangedFlags(r27 | 1));
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
}
