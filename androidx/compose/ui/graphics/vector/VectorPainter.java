package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPainter.kt */
/* loaded from: classes.dex */
public final class VectorPainter extends Painter {
    public Composition composition;
    public float currentAlpha;
    public ColorFilter currentColorFilter;
    public final ParcelableSnapshotMutableState isDirty$delegate;
    public final VectorComponent vector;
    public final ParcelableSnapshotMutableState size$delegate = Platform.mutableStateOf$default(new Size(Size.Zero));
    public final ParcelableSnapshotMutableState autoMirror$delegate = Platform.mutableStateOf$default(Boolean.FALSE);

    public VectorPainter() {
        VectorComponent vectorComponent = new VectorComponent();
        vectorComponent.invalidateCallback = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                VectorPainter.this.isDirty$delegate.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        };
        this.vector = vectorComponent;
        this.isDirty$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
        this.currentAlpha = 1.0f;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.graphics.vector.VectorPainter$composeVector$1, kotlin.jvm.internal.Lambda] */
    public final void RenderVector$ui_release(final String name, final float f, final float f2, final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer composer, final int r14) {
        boolean z;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1264894527);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        VectorComponent vectorComponent = this.vector;
        vectorComponent.getClass();
        GroupComponent groupComponent = vectorComponent.root;
        groupComponent.getClass();
        groupComponent.name = name;
        groupComponent.invalidate();
        boolean z2 = false;
        if (vectorComponent.viewportWidth == f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            vectorComponent.viewportWidth = f;
            vectorComponent.isDirty = true;
            vectorComponent.invalidateCallback.invoke();
        }
        if (vectorComponent.viewportHeight == f2) {
            z2 = true;
        }
        if (!z2) {
            vectorComponent.viewportHeight = f2;
            vectorComponent.isDirty = true;
            vectorComponent.invalidateCallback.invoke();
        }
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup);
        final Composition composition = this.composition;
        if (composition == null || composition.isDisposed()) {
            composition = CompositionKt.Composition(new VectorApplier(groupComponent), rememberCompositionContext);
        }
        this.composition = composition;
        composition.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$composeVector$1
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
                    VectorPainter vectorPainter = this;
                    content.invoke(Float.valueOf(vectorPainter.vector.viewportWidth), Float.valueOf(vectorPainter.vector.viewportHeight), composer3, 0);
                }
                return Unit.INSTANCE;
            }
        }, true));
        EffectsKt.DisposableEffect(composition, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DisposableEffectScope DisposableEffect = disposableEffectScope;
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final Composition composition2 = Composition.this;
                return new DisposableEffectResult() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        Composition.this.dispose();
                    }
                };
            }
        }, startRestartGroup);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    VectorPainter.this.RenderVector$ui_release(name, f, f2, content, composer2, Strings.updateChangedFlags(r14 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.currentAlpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo392getIntrinsicSizeNHjbRc() {
        return ((Size) this.size$delegate.getValue()).packedValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        ColorFilter colorFilter = this.currentColorFilter;
        VectorComponent vectorComponent = this.vector;
        if (colorFilter == null) {
            colorFilter = (ColorFilter) vectorComponent.intrinsicColorFilter$delegate.getValue();
        }
        if (((Boolean) this.autoMirror$delegate.getValue()).booleanValue() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long mo390getCenterF1C5BW0 = drawScope.mo390getCenterF1C5BW0();
            CanvasDrawScope$drawContext$1 drawContext = drawScope.getDrawContext();
            long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.transform.m375scale0AR0LA0(mo390getCenterF1C5BW0);
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            drawContext.getCanvas().restore();
            drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.isDirty$delegate;
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
        }
    }
}
