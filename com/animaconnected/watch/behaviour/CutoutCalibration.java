package com.animaconnected.watch.behaviour;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.behaviour.CutoutCalibration;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.Point;
import com.animaconnected.watch.display.RemoteAppImpl;
import com.animaconnected.watch.display.view.BottomPusher;
import com.animaconnected.watch.display.view.Button;
import com.animaconnected.watch.display.view.Display;
import com.animaconnected.watch.display.view.DisplayDefinitionKt;
import com.animaconnected.watch.display.view.Rectangle;
import com.animaconnected.watch.display.view.ScrollContainer;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.KeyString;
import com.animaconnected.watch.strings.Static;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CutoutCalibration.kt */
/* loaded from: classes3.dex */
public class CutoutCalibration extends RemoteAppImpl {
    private final Point _bl;
    private final Point _br;
    private final Point _ml;
    private final Point _mr;
    private final Point _tl;
    private final Point _tr;
    private final String analyticsName;
    private final Axis axis;
    private final int bottomPartWidth;
    private final int diagonalWidth;
    private final int fullDisplayHeight;
    private final int fullDisplayWidth;
    private final Mitmap icon;
    private final AppId id;
    private final boolean isHidden;
    private final int maxOffset;
    private final int maxX;
    private final int maxY;
    private final KeyString title;
    private final int topPartHeight;
    private final String type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CutoutCalibration.kt */
    /* loaded from: classes3.dex */
    public static final class Axis {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Axis[] $VALUES;
        public static final Axis HORIZONTAL = new Axis("HORIZONTAL", 0);
        public static final Axis VERTICAL = new Axis("VERTICAL", 1);

        private static final /* synthetic */ Axis[] $values() {
            return new Axis[]{HORIZONTAL, VERTICAL};
        }

        static {
            Axis[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Axis(String str, int r2) {
        }

        public static EnumEntries<Axis> getEntries() {
            return $ENTRIES;
        }

        public static Axis valueOf(String str) {
            return (Axis) Enum.valueOf(Axis.class, str);
        }

        public static Axis[] values() {
            return (Axis[]) $VALUES.clone();
        }
    }

    public CutoutCalibration(boolean z, int r4, Axis axis, KeyString typeName) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        this.isHidden = z;
        this.maxOffset = r4;
        this.axis = axis;
        this.type = typeName.english();
        this.analyticsName = typeName.english();
        this.id = AppId.DebugHorizontalScreenCalibration;
        this.title = typeName;
        this.icon = GraphicsKt.emptyMitmap();
        this.fullDisplayWidth = 348;
        int r42 = 348 - 1;
        this.maxX = r42;
        this.fullDisplayHeight = R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail;
        int r5 = R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail - 1;
        this.maxY = r5;
        this.topPartHeight = 59;
        this.bottomPartWidth = 196;
        int r6 = (r42 - 196) / 2;
        this.diagonalWidth = r6;
        this._tl = new Point(0, 0);
        this._tr = new Point(r42, 0);
        this._ml = new Point(0, 59);
        this._mr = new Point(r42, 59);
        this._bl = new Point(r6, r5);
        this._br = new Point(r42 - r6, r5);
    }

    private final List<Display> calibrationDisplay(CoroutineScope coroutineScope) {
        IntRange intRange = new IntRange(0, this.maxOffset * 2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(displayForOffset(offsetForIndex(((IntIterator) it).nextInt()), coroutineScope));
        }
        return arrayList;
    }

    private final Display displayForOffset(final int r10, final CoroutineScope coroutineScope) {
        final int r5;
        final int r6;
        Axis axis = this.axis;
        if (axis == Axis.HORIZONTAL) {
            r5 = r10;
        } else {
            r5 = 0;
        }
        if (axis == Axis.VERTICAL) {
            r6 = r10;
        } else {
            r6 = 0;
        }
        return DisplayDefinitionKt.display(new Function1<Display, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Display display) {
                invoke2(display);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Display display) {
                Point point;
                Point point2;
                Point point3;
                Point point4;
                Point point5;
                Point point6;
                Point point7;
                Point point8;
                Point point9;
                Point point10;
                Point point11;
                Point point12;
                int r1;
                int r12;
                final int indexForOffset;
                CutoutCalibration.Axis axis2;
                final int indexForOffset2;
                CutoutCalibration.Axis axis3;
                Intrinsics.checkNotNullParameter(display, "$this$display");
                point = CutoutCalibration.this._tl;
                int x = point.getX() + r5;
                point2 = CutoutCalibration.this._tl;
                Point point13 = new Point(x, point2.getY() + r6);
                point3 = CutoutCalibration.this._tr;
                int x2 = point3.getX() + r5;
                point4 = CutoutCalibration.this._tr;
                Point point14 = new Point(x2, point4.getY() + r6);
                point5 = CutoutCalibration.this._ml;
                int x3 = point5.getX() + r5;
                point6 = CutoutCalibration.this._ml;
                Point point15 = new Point(x3, point6.getY());
                point7 = CutoutCalibration.this._mr;
                int x4 = point7.getX() + r5;
                point8 = CutoutCalibration.this._mr;
                Point point16 = new Point(x4, point8.getY());
                point9 = CutoutCalibration.this._bl;
                int x5 = point9.getX() + r5;
                point10 = CutoutCalibration.this._bl;
                Point point17 = new Point(x5, point10.getY() + r6);
                point11 = CutoutCalibration.this._br;
                int x6 = point11.getX() + r5;
                point12 = CutoutCalibration.this._br;
                Point point18 = new Point(x6, point12.getY() + r6);
                DisplayDefinitionKt.line$default(display, point13, point14, null, 4, null);
                DisplayDefinitionKt.line$default(display, point14, point16, null, 4, null);
                DisplayDefinitionKt.line$default(display, point16, point18, null, 4, null);
                DisplayDefinitionKt.line$default(display, point18, point17, null, 4, null);
                DisplayDefinitionKt.line$default(display, point17, point15, null, 4, null);
                DisplayDefinitionKt.line$default(display, point15, point13, null, 4, null);
                final CutoutCalibration cutoutCalibration = CutoutCalibration.this;
                final int r2 = r10;
                DisplayDefinitionKt.subDisplaySafeArea(display, new Function1<Rectangle, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rectangle rectangle) {
                        invoke2(rectangle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rectangle subDisplaySafeArea) {
                        Intrinsics.checkNotNullParameter(subDisplaySafeArea, "$this$subDisplaySafeArea");
                        int width = subDisplaySafeArea.getWidth();
                        int height = subDisplaySafeArea.getHeight();
                        final CutoutCalibration cutoutCalibration2 = CutoutCalibration.this;
                        final int r4 = r2;
                        DisplayDefinitionKt.scrollContainer(subDisplaySafeArea, width, height, new Function1<ScrollContainer, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration.displayForOffset.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ScrollContainer scrollContainer) {
                                invoke2(scrollContainer);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ScrollContainer scrollContainer) {
                                int indexForOffset3;
                                CutoutCalibration.Axis axis4;
                                int r0;
                                Intrinsics.checkNotNullParameter(scrollContainer, "$this$scrollContainer");
                                indexForOffset3 = CutoutCalibration.this.indexForOffset(r4);
                                axis4 = CutoutCalibration.this.axis;
                                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(axis4 == CutoutCalibration.Axis.HORIZONTAL ? "h" : "v", "-offs: ");
                                m.append(r4);
                                m.append(" (d=");
                                m.append(indexForOffset3);
                                m.append(",m=");
                                r0 = CutoutCalibration.this.maxOffset;
                                m.append(r0);
                                m.append(')');
                                DisplayDefinitionKt.text$default(scrollContainer, StringsExtensionsKt.m1571static(m.toString()), CutoutCalibration.this.getPaint().getDefault(), false, null, null, 28, null);
                            }
                        });
                    }
                });
                int r0 = r10 + 1;
                r1 = CutoutCalibration.this.maxOffset;
                if (r0 <= r1) {
                    indexForOffset2 = CutoutCalibration.this.indexForOffset(r10 + 1);
                    axis3 = CutoutCalibration.this.axis;
                    Static m1571static = StringsExtensionsKt.m1571static(axis3 == CutoutCalibration.Axis.VERTICAL ? "Move down" : "Move right");
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final CutoutCalibration cutoutCalibration2 = CutoutCalibration.this;
                    DisplayDefinitionKt.button(display, m1571static, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                            invoke2(button);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Button button) {
                            Intrinsics.checkNotNullParameter(button, "$this$button");
                            final CoroutineScope coroutineScope3 = CoroutineScope.this;
                            final CutoutCalibration cutoutCalibration3 = cutoutCalibration2;
                            final int r3 = indexForOffset2;
                            button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration.displayForOffset.1.2.1

                                /* compiled from: CutoutCalibration.kt */
                                @DebugMetadata(c = "com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1$2$1$1", f = "CutoutCalibration.kt", l = {128}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes3.dex */
                                public static final class C00771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ int $nextIndex;
                                    int label;
                                    final /* synthetic */ CutoutCalibration this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C00771(CutoutCalibration cutoutCalibration, int r2, Continuation<? super C00771> continuation) {
                                        super(2, continuation);
                                        this.this$0 = cutoutCalibration;
                                        this.$nextIndex = r2;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00771(this.this$0, this.$nextIndex, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        int r1 = this.label;
                                        if (r1 != 0) {
                                            if (r1 == 1) {
                                                ResultKt.throwOnFailure(obj);
                                            } else {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        } else {
                                            ResultKt.throwOnFailure(obj);
                                            CutoutCalibration cutoutCalibration = this.this$0;
                                            int r8 = this.$nextIndex;
                                            this.label = 1;
                                            if (RemoteAppImpl.changeView$default(cutoutCalibration, r8, null, this, 2, null) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BuildersKt.launch$default(CoroutineScope.this, null, null, new C00771(cutoutCalibration3, r3, null), 3);
                                }
                            });
                        }
                    });
                }
                int abs = Math.abs(r10 - 1);
                r12 = CutoutCalibration.this.maxOffset;
                if (abs <= r12) {
                    indexForOffset = CutoutCalibration.this.indexForOffset(r10 - 1);
                    axis2 = CutoutCalibration.this.axis;
                    Static m1571static2 = StringsExtensionsKt.m1571static(axis2 == CutoutCalibration.Axis.VERTICAL ? "Move up" : "Move left");
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    final CutoutCalibration cutoutCalibration3 = CutoutCalibration.this;
                    DisplayDefinitionKt.button(display, m1571static2, new Function1<Button, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Button button) {
                            invoke2(button);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Button button) {
                            Intrinsics.checkNotNullParameter(button, "$this$button");
                            final CoroutineScope coroutineScope4 = CoroutineScope.this;
                            final CutoutCalibration cutoutCalibration4 = cutoutCalibration3;
                            final int r3 = indexForOffset;
                            button.setOnClick(new Function0<Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration.displayForOffset.1.3.1

                                /* compiled from: CutoutCalibration.kt */
                                @DebugMetadata(c = "com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1$3$1$1", f = "CutoutCalibration.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorDetail}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes3.dex */
                                public static final class C00781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ int $nextIndex;
                                    int label;
                                    final /* synthetic */ CutoutCalibration this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C00781(CutoutCalibration cutoutCalibration, int r2, Continuation<? super C00781> continuation) {
                                        super(2, continuation);
                                        this.this$0 = cutoutCalibration;
                                        this.$nextIndex = r2;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00781(this.this$0, this.$nextIndex, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        int r1 = this.label;
                                        if (r1 != 0) {
                                            if (r1 == 1) {
                                                ResultKt.throwOnFailure(obj);
                                            } else {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        } else {
                                            ResultKt.throwOnFailure(obj);
                                            CutoutCalibration cutoutCalibration = this.this$0;
                                            int r8 = this.$nextIndex;
                                            this.label = 1;
                                            if (RemoteAppImpl.changeView$default(cutoutCalibration, r8, null, this, 2, null) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BuildersKt.launch$default(CoroutineScope.this, null, null, new C00781(cutoutCalibration4, r3, null), 3);
                                }
                            });
                        }
                    });
                }
                DisplayDefinitionKt.bottomPusher(display, new Function1<BottomPusher, Unit>() { // from class: com.animaconnected.watch.behaviour.CutoutCalibration$displayForOffset$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomPusher bottomPusher) {
                        invoke2(bottomPusher);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomPusher bottomPusher) {
                        Intrinsics.checkNotNullParameter(bottomPusher, "$this$bottomPusher");
                        bottomPusher.setNavCommand(-1);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int indexForOffset(int r2) {
        if (r2 < 0) {
            return Math.abs(r2) + this.maxOffset;
        }
        return r2;
    }

    private final int offsetForIndex(int r2) {
        int r0 = this.maxOffset;
        if (r2 > r0) {
            return -(r2 - r0);
        }
        return r2;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.display.RemoteApp
    public List<Display> getDisplays() {
        return calibrationDisplay(ServiceLocator.INSTANCE.getScope());
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public Mitmap getIcon() {
        return this.icon;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public AppId getId() {
        return this.id;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public KeyString getTitle() {
        return this.title;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    public boolean isHidden() {
        return this.isHidden;
    }
}
