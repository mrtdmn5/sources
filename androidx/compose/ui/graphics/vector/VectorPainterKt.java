package androidx.compose.ui.graphics.vector;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.VectorProperty;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.google.common.base.Strings;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPainter.kt */
/* loaded from: classes.dex */
public final class VectorPainterKt {
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.jvm.internal.Lambda, androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1] */
    public static final void RenderVectorGroup(final VectorGroup group, Map<String, ? extends VectorConfig> map, Composer composer, final int r26, final int r27) {
        int r4;
        int r42;
        Map<String, ? extends VectorConfig> map2;
        ComposerImpl composerImpl;
        final Map<String, ? extends VectorConfig> map3;
        ComposerImpl composerImpl2;
        final Map<String, ? extends VectorConfig> map4;
        Intrinsics.checkNotNullParameter(group, "group");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-446179233);
        if ((r27 & 1) != 0) {
            r4 = r26 | 6;
        } else if ((r26 & 14) == 0) {
            if (startRestartGroup.changed(group)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r26;
        } else {
            r4 = r26;
        }
        int r6 = r27 & 2;
        if (r6 != 0) {
            r4 |= 16;
        }
        if (r6 == 2 && (r4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            map3 = map;
            composerImpl = startRestartGroup;
        } else {
            if (r6 != 0) {
                map2 = EmptyMap.INSTANCE;
            } else {
                map2 = map;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            for (final VectorNode vectorNode : group.children) {
                if (vectorNode instanceof VectorPath) {
                    startRestartGroup.startReplaceableGroup(-326285735);
                    VectorPath vectorPath = (VectorPath) vectorNode;
                    map2.get(vectorPath.name);
                    VectorProperty.PathData property = VectorProperty.PathData.INSTANCE;
                    Intrinsics.checkNotNullParameter(property, "property");
                    List<PathNode> list = vectorPath.pathData;
                    int r7 = vectorPath.pathFillType;
                    String str = vectorPath.name;
                    VectorProperty.Fill property2 = VectorProperty.Fill.INSTANCE;
                    Brush brush = vectorPath.fill;
                    Intrinsics.checkNotNullParameter(property2, "property");
                    VectorProperty.FillAlpha property3 = VectorProperty.FillAlpha.INSTANCE;
                    Float valueOf = Float.valueOf(vectorPath.fillAlpha);
                    Intrinsics.checkNotNullParameter(property3, "property");
                    float floatValue = valueOf.floatValue();
                    VectorProperty.Stroke property4 = VectorProperty.Stroke.INSTANCE;
                    Brush brush2 = vectorPath.stroke;
                    Intrinsics.checkNotNullParameter(property4, "property");
                    VectorProperty.StrokeAlpha property5 = VectorProperty.StrokeAlpha.INSTANCE;
                    Float valueOf2 = Float.valueOf(vectorPath.strokeAlpha);
                    Intrinsics.checkNotNullParameter(property5, "property");
                    float floatValue2 = valueOf2.floatValue();
                    VectorProperty.StrokeLineWidth property6 = VectorProperty.StrokeLineWidth.INSTANCE;
                    Float valueOf3 = Float.valueOf(vectorPath.strokeLineWidth);
                    Intrinsics.checkNotNullParameter(property6, "property");
                    float floatValue3 = valueOf3.floatValue();
                    int r14 = vectorPath.strokeLineCap;
                    Map<String, ? extends VectorConfig> map5 = map2;
                    int r15 = vectorPath.strokeLineJoin;
                    float f = vectorPath.strokeLineMiter;
                    VectorProperty.TrimPathStart property7 = VectorProperty.TrimPathStart.INSTANCE;
                    Float valueOf4 = Float.valueOf(vectorPath.trimPathStart);
                    Intrinsics.checkNotNullParameter(property7, "property");
                    float floatValue4 = valueOf4.floatValue();
                    VectorProperty.TrimPathEnd property8 = VectorProperty.TrimPathEnd.INSTANCE;
                    ComposerImpl composerImpl3 = startRestartGroup;
                    Float valueOf5 = Float.valueOf(vectorPath.trimPathEnd);
                    Intrinsics.checkNotNullParameter(property8, "property");
                    float floatValue5 = valueOf5.floatValue();
                    VectorProperty.TrimPathOffset property9 = VectorProperty.TrimPathOffset.INSTANCE;
                    Float valueOf6 = Float.valueOf(vectorPath.trimPathOffset);
                    Intrinsics.checkNotNullParameter(property9, "property");
                    map4 = map5;
                    VectorComposeKt.m395Path9cdaXJ4(list, r7, str, brush, floatValue, brush2, floatValue2, floatValue3, r14, r15, f, floatValue4, floatValue5, valueOf6.floatValue(), composerImpl3, 8, 0, 0);
                    composerImpl2 = composerImpl3;
                    composerImpl2.end(false);
                } else {
                    composerImpl2 = startRestartGroup;
                    map4 = map2;
                    if (vectorNode instanceof VectorGroup) {
                        composerImpl2.startReplaceableGroup(-326283877);
                        VectorGroup vectorGroup = (VectorGroup) vectorNode;
                        map4.get(vectorGroup.name);
                        String str2 = vectorGroup.name;
                        VectorProperty.Rotation property10 = VectorProperty.Rotation.INSTANCE;
                        Float valueOf7 = Float.valueOf(vectorGroup.rotation);
                        Intrinsics.checkNotNullParameter(property10, "property");
                        float floatValue6 = valueOf7.floatValue();
                        VectorProperty.ScaleX property11 = VectorProperty.ScaleX.INSTANCE;
                        Float valueOf8 = Float.valueOf(vectorGroup.scaleX);
                        Intrinsics.checkNotNullParameter(property11, "property");
                        float floatValue7 = valueOf8.floatValue();
                        VectorProperty.ScaleY property12 = VectorProperty.ScaleY.INSTANCE;
                        Float valueOf9 = Float.valueOf(vectorGroup.scaleY);
                        Intrinsics.checkNotNullParameter(property12, "property");
                        float floatValue8 = valueOf9.floatValue();
                        VectorProperty.TranslateX property13 = VectorProperty.TranslateX.INSTANCE;
                        Float valueOf10 = Float.valueOf(vectorGroup.translationX);
                        Intrinsics.checkNotNullParameter(property13, "property");
                        float floatValue9 = valueOf10.floatValue();
                        VectorProperty.TranslateY property14 = VectorProperty.TranslateY.INSTANCE;
                        Float valueOf11 = Float.valueOf(vectorGroup.translationY);
                        Intrinsics.checkNotNullParameter(property14, "property");
                        float floatValue10 = valueOf11.floatValue();
                        VectorProperty.PivotX property15 = VectorProperty.PivotX.INSTANCE;
                        Float valueOf12 = Float.valueOf(vectorGroup.pivotX);
                        Intrinsics.checkNotNullParameter(property15, "property");
                        float floatValue11 = valueOf12.floatValue();
                        VectorProperty.PivotY property16 = VectorProperty.PivotY.INSTANCE;
                        Float valueOf13 = Float.valueOf(vectorGroup.pivotY);
                        Intrinsics.checkNotNullParameter(property16, "property");
                        float floatValue12 = valueOf13.floatValue();
                        VectorProperty.PathData property17 = VectorProperty.PathData.INSTANCE;
                        Intrinsics.checkNotNullParameter(property17, "property");
                        VectorComposeKt.Group(str2, floatValue6, floatValue11, floatValue12, floatValue7, floatValue8, floatValue9, floatValue10, vectorGroup.clipPathData, ComposableLambdaKt.composableLambda(composerImpl2, 1450046638, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                Composer composer3 = composer2;
                                if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    VectorPainterKt.RenderVectorGroup((VectorGroup) VectorNode.this, map4, composer3, 64, 0);
                                }
                                return Unit.INSTANCE;
                            }
                        }), composerImpl2, 939524096, 0);
                        composerImpl2.end(false);
                    } else {
                        composerImpl2.startReplaceableGroup(-326282407);
                        composerImpl2.end(false);
                    }
                }
                map2 = map4;
                startRestartGroup = composerImpl2;
            }
            composerImpl = startRestartGroup;
            map3 = map2;
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r26 | 1);
                    VectorPainterKt.RenderVectorGroup(VectorGroup.this, map3, composer2, updateChangedFlags, r27);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.internal.Lambda, androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$3] */
    public static final VectorPainter rememberVectorPainter(final ImageVector image, Composer composer) {
        ColorFilter porterDuffColorFilter;
        Intrinsics.checkNotNullParameter(image, "image");
        composer.startReplaceableGroup(1413834416);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        String str = image.name;
        ComposableLambdaImpl composableLambda = ComposableLambdaKt.composableLambda(composer, 1873274766, new Function4<Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$3
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(Float f, Float f2, Composer composer2, Integer num) {
                f.floatValue();
                f2.floatValue();
                Composer composer3 = composer2;
                if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    VectorPainterKt.RenderVectorGroup(ImageVector.this.root, null, composer3, 0, 2);
                }
                return Unit.INSTANCE;
            }
        });
        composer.startReplaceableGroup(1068590786);
        Density density = (Density) composer.consume(CompositionLocalsKt.LocalDensity);
        float mo49toPx0680j_4 = density.mo49toPx0680j_4(image.defaultWidth);
        float mo49toPx0680j_42 = density.mo49toPx0680j_4(image.defaultHeight);
        float f = image.viewportWidth;
        if (Float.isNaN(f)) {
            f = mo49toPx0680j_4;
        }
        float f2 = image.viewportHeight;
        if (Float.isNaN(f2)) {
            f2 = mo49toPx0680j_42;
        }
        long j = image.tintColor;
        Color color = new Color(j);
        int r10 = image.tintBlendMode;
        BlendMode blendMode = new BlendMode(r10);
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(color) | composer.changed(blendMode);
        Object rememberedValue = composer.rememberedValue();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (changed || rememberedValue == composer$Companion$Empty$1) {
            if (!Color.m317equalsimpl0(j, Color.Unspecified)) {
                if (Build.VERSION.SDK_INT >= 29) {
                    porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(j, r10);
                } else {
                    porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(j), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(r10));
                }
                rememberedValue = new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter);
            } else {
                rememberedValue = null;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        androidx.compose.ui.graphics.ColorFilter colorFilter = (androidx.compose.ui.graphics.ColorFilter) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == composer$Companion$Empty$1) {
            rememberedValue2 = new VectorPainter();
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue2;
        vectorPainter.size$delegate.setValue(new Size(SizeKt.Size(mo49toPx0680j_4, mo49toPx0680j_42)));
        vectorPainter.autoMirror$delegate.setValue(Boolean.valueOf(image.autoMirror));
        vectorPainter.vector.intrinsicColorFilter$delegate.setValue(colorFilter);
        vectorPainter.RenderVector$ui_release(str, f, f2, composableLambda, composer, 35840);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return vectorPainter;
    }
}
