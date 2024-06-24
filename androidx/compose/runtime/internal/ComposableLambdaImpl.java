package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import com.google.common.base.Strings;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ComposableLambda.jvm.kt */
/* loaded from: classes.dex */
public final class ComposableLambdaImpl implements Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21 {
    public Object _block;
    public final int key;
    public RecomposeScope scope;
    public ArrayList scopes;
    public final boolean tracked;

    public ComposableLambdaImpl(int r1, boolean z) {
        this.key = r1;
        this.tracked = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int bitsForSlot;
        Composer c = (Composer) obj;
        int intValue = ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 0);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 0);
        }
        int r5 = intValue | bitsForSlot;
        Object obj3 = this._block;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj3);
        Object invoke = ((Function2) obj3).invoke(startRestartGroup, Integer.valueOf(r5));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, this);
            endRestartGroup.block = this;
        }
        return invoke;
    }

    public final void trackRead(Composer composer) {
        RecomposeScopeImpl recomposeScope;
        if (this.tracked && (recomposeScope = composer.getRecomposeScope()) != null) {
            composer.recordUsed(recomposeScope);
            if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
                this.scope = recomposeScope;
                return;
            }
            ArrayList arrayList = this.scopes;
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                this.scopes = arrayList2;
                arrayList2.add(recomposeScope);
                return;
            }
            int size = arrayList.size();
            for (int r2 = 0; r2 < size; r2++) {
                if (ComposableLambdaKt.replacableWith((RecomposeScope) arrayList.get(r2), recomposeScope)) {
                    arrayList.set(r2, recomposeScope);
                    return;
                }
            }
            arrayList.add(recomposeScope);
        }
    }

    public final void update(Lambda block) {
        boolean z;
        Intrinsics.checkNotNullParameter(block, "block");
        if (!Intrinsics.areEqual(this._block, block)) {
            if (this._block == null) {
                z = true;
            } else {
                z = false;
            }
            this._block = block;
            if (!z && this.tracked) {
                RecomposeScope recomposeScope = this.scope;
                if (recomposeScope != null) {
                    recomposeScope.invalidate();
                    this.scope = null;
                }
                ArrayList arrayList = this.scopes;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int r1 = 0; r1 < size; r1++) {
                        ((RecomposeScope) arrayList.get(r1)).invalidate();
                    }
                    arrayList.clear();
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
    }

    @Override // kotlin.jvm.functions.Function6
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
    }

    @Override // kotlin.jvm.functions.Function7
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return invoke(obj, obj2, obj3, obj4, obj5, (Composer) obj6, ((Number) obj7).intValue());
    }

    @Override // kotlin.jvm.functions.Function8
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, (Composer) obj7, ((Number) obj8).intValue());
    }

    @Override // kotlin.jvm.functions.Function9
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, (Composer) obj8, ((Number) obj9).intValue());
    }

    @Override // kotlin.jvm.functions.Function10
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, (Composer) obj9, ((Number) obj10).intValue());
    }

    @Override // kotlin.jvm.functions.Function14
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, (Composer) obj12, ((Number) obj13).intValue(), ((Number) obj14).intValue());
    }

    @Override // kotlin.jvm.functions.Function18
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, (Composer) obj16, ((Number) obj17).intValue(), ((Number) obj18).intValue());
    }

    public final Object invoke(final Object obj, Composer c, final int r6) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 1);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 1);
        }
        Object obj2 = this._block;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, obj2);
        Object invoke = ((Function3) obj2).invoke(obj, startRestartGroup, Integer.valueOf(bitsForSlot | r6));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, nc, Strings.updateChangedFlags(r6) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, Composer c, final int r7) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 2);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 2);
        }
        Object obj3 = this._block;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(4, obj3);
        Object invoke = ((Function4) obj3).invoke(obj, obj2, startRestartGroup, Integer.valueOf(bitsForSlot | r7));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    int updateChangedFlags = Strings.updateChangedFlags(r7) | 1;
                    ComposableLambdaImpl.this.invoke(obj, obj2, nc, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, Composer c, final int r13) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 3);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 3);
        }
        Object obj4 = this._block;
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(5, obj4);
        Object invoke = ((Function5) obj4).invoke(obj, obj2, obj3, startRestartGroup, Integer.valueOf(bitsForSlot | r13));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, nc, Strings.updateChangedFlags(r13) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, Composer c, final int r15) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 4);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 4);
        }
        Object obj5 = this._block;
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(6, obj5);
        Object invoke = ((Function6) obj5).invoke(obj, obj2, obj3, obj4, startRestartGroup, Integer.valueOf(bitsForSlot | r15));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, nc, Strings.updateChangedFlags(r15) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, Composer c, final int r24) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 5);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 5);
        }
        Object obj6 = this._block;
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(7, obj6);
        Object invoke = ((Function7) obj6).invoke(obj, obj2, obj3, obj4, obj5, startRestartGroup, Integer.valueOf(r24 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, nc, Strings.updateChangedFlags(r24) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, Composer c, final int r27) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 6);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 6);
        }
        Object obj7 = this._block;
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Function8<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(8, obj7);
        Object invoke = ((Function8) obj7).invoke(obj, obj2, obj3, obj4, obj5, obj6, startRestartGroup, Integer.valueOf(r27 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, obj6, nc, Strings.updateChangedFlags(r27) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, Composer c, final int r30) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 7);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 7);
        }
        Object obj8 = this._block;
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Function9<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'param7')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(9, obj8);
        Object invoke = ((Function9) obj8).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, startRestartGroup, Integer.valueOf(r30 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, nc, Strings.updateChangedFlags(r30) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, Composer c, final int r33) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 8);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 8);
        }
        Object obj9 = this._block;
        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Function10<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'param7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(10, obj9);
        Object invoke = ((Function10) obj9).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, startRestartGroup, Integer.valueOf(r33 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, nc, Strings.updateChangedFlags(r33) | 1);
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, Composer c, final int r45, final int r46) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 11);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 11);
        }
        Object obj12 = this._block;
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Function14<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'param7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(14, obj12);
        Object invoke = ((Function14) obj12).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, startRestartGroup, Integer.valueOf(r45), Integer.valueOf(r46 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, nc, Strings.updateChangedFlags(r45) | 1, Strings.updateChangedFlags(r46));
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }

    public final Object invoke(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, final Object obj15, Composer c, final int r54, final int r55) {
        int bitsForSlot;
        Intrinsics.checkNotNullParameter(c, "c");
        ComposerImpl startRestartGroup = c.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        if (startRestartGroup.changed(this)) {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(2, 15);
        } else {
            bitsForSlot = ComposableLambdaKt.bitsForSlot(1, 15);
        }
        Object obj16 = this._block;
        Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type kotlin.Function18<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'p6')] kotlin.Any?, @[ParameterName(name = 'param7')] kotlin.Any?, @[ParameterName(name = 'p8')] kotlin.Any?, @[ParameterName(name = 'p9')] kotlin.Any?, @[ParameterName(name = 'p10')] kotlin.Any?, @[ParameterName(name = 'p11')] kotlin.Any?, @[ParameterName(name = 'p12')] kotlin.Any?, @[ParameterName(name = 'p13')] kotlin.Any?, @[ParameterName(name = 'p14')] kotlin.Any?, @[ParameterName(name = 'p15')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, @[ParameterName(name = 'changed1')] kotlin.Int, kotlin.Any?>");
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(18, obj16);
        Object invoke = ((Function18) obj16).invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, startRestartGroup, Integer.valueOf(r54), Integer.valueOf(r55 | bitsForSlot));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$15
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer, Integer num) {
                    Composer nc = composer;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    ComposableLambdaImpl.this.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, nc, Strings.updateChangedFlags(r54) | 1, Strings.updateChangedFlags(r55));
                    return Unit.INSTANCE;
                }
            };
        }
        return invoke;
    }
}
