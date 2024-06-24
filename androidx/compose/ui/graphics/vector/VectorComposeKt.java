package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import com.google.common.base.Strings;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: VectorCompose.kt */
/* loaded from: classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Group(java.lang.String r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r27, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m395Path9cdaXJ4(final List<? extends PathNode> pathData, int r23, String str, Brush brush, float f, Brush brush2, float f2, float f3, int r30, int r31, float f4, float f5, float f6, float f7, Composer composer, final int r37, final int r38, final int r39) {
        final int r2;
        int r13;
        int r14;
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1478270750);
        if ((r39 & 2) != 0) {
            int r22 = VectorKt.$r8$clinit;
            r2 = 0;
        } else {
            r2 = r23;
        }
        String str2 = (r39 & 4) != 0 ? "" : str;
        Brush brush3 = (r39 & 8) != 0 ? null : brush;
        float f8 = (r39 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (r39 & 32) != 0 ? null : brush2;
        float f9 = (r39 & 64) != 0 ? 1.0f : f2;
        float f10 = (r39 & 128) != 0 ? 0.0f : f3;
        if ((r39 & 256) != 0) {
            int r132 = VectorKt.$r8$clinit;
            r13 = 0;
        } else {
            r13 = r30;
        }
        if ((r39 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            int r142 = VectorKt.$r8$clinit;
            r14 = 0;
        } else {
            r14 = r31;
        }
        float f11 = (r39 & 1024) != 0 ? 4.0f : f4;
        float f12 = (r39 & 2048) != 0 ? 0.0f : f5;
        float f13 = (r39 & 4096) != 0 ? 1.0f : f6;
        float f14 = (r39 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? 0.0f : f7;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(1886828752);
        if (startRestartGroup.applier instanceof VectorApplier) {
            startRestartGroup.startNode();
            if (startRestartGroup.inserting) {
                final VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
                    @Override // kotlin.jvm.functions.Function0
                    public final PathComponent invoke() {
                        return new PathComponent();
                    }
                };
                startRestartGroup.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, androidx.compose.ui.graphics.vector.PathComponent] */
                    @Override // kotlin.jvm.functions.Function0
                    public final PathComponent invoke() {
                        return vectorComposeKt$Path$1.invoke();
                    }
                });
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, str2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, String str3) {
                    PathComponent set = pathComponent;
                    String it = str3;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, pathData, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, List<? extends PathNode> list) {
                    PathComponent set = pathComponent;
                    List<? extends PathNode> it = list;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.pathData = it;
                    set.isPathDirty = true;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, new PathFillType(r2), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                    PathComponent set = pathComponent;
                    int r3 = pathFillType.value;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.renderPath.mo306setFillTypeoQ8Xj4U(r3);
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Brush brush5) {
                    PathComponent set = pathComponent;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.fill = brush5;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.fillAlpha = floatValue;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Brush brush5) {
                    PathComponent set = pathComponent;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.stroke = brush5;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f9), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.strokeAlpha = floatValue;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.strokeLineWidth = floatValue;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, new StrokeJoin(r14), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                    PathComponent set = pathComponent;
                    int r3 = strokeJoin.value;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.strokeLineJoin = r3;
                    set.isStrokeDirty = true;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, new StrokeCap(r13), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                    PathComponent set = pathComponent;
                    int r3 = strokeCap.value;
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.strokeLineCap = r3;
                    set.isStrokeDirty = true;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.strokeLineMiter = floatValue;
                    set.isStrokeDirty = true;
                    set.invalidate();
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f12), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    boolean z;
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    if (set.trimPathStart == floatValue) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        set.trimPathStart = floatValue;
                        set.isTrimPathDirty = true;
                        set.invalidate();
                    }
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f13), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    boolean z;
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    if (set.trimPathEnd == floatValue) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        set.trimPathEnd = floatValue;
                        set.isTrimPathDirty = true;
                        set.invalidate();
                    }
                    return Unit.INSTANCE;
                }
            });
            Updater.m228setimpl(startRestartGroup, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(PathComponent pathComponent, Float f15) {
                    boolean z;
                    PathComponent set = pathComponent;
                    float floatValue = f15.floatValue();
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    if (set.trimPathOffset == floatValue) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        set.trimPathOffset = floatValue;
                        set.isTrimPathDirty = true;
                        set.invalidate();
                    }
                    return Unit.INSTANCE;
                }
            });
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final String str3 = str2;
            final Brush brush5 = brush3;
            final float f15 = f8;
            final Brush brush6 = brush4;
            final float f16 = f9;
            final float f17 = f10;
            final int r9 = r13;
            final int r10 = r14;
            final float f18 = f11;
            final float f19 = f12;
            final float f20 = f13;
            final float f21 = f14;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    VectorComposeKt.m395Path9cdaXJ4(pathData, r2, str3, brush5, f15, brush6, f16, f17, r9, r10, f18, f19, f20, f21, composer2, Strings.updateChangedFlags(r37 | 1), Strings.updateChangedFlags(r38), r39);
                    return Unit.INSTANCE;
                }
            };
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }
}
