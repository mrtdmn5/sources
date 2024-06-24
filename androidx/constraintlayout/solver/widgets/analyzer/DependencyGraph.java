package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class DependencyGraph {
    public final ConstraintWidgetContainer container;
    public final ConstraintWidgetContainer mContainer;
    public final ArrayList<RunGroup> mGroups;
    public final BasicMeasure.Measure mMeasure;
    public BasicMeasure.Measurer mMeasurer;
    public boolean mNeedBuildGraph = true;
    public boolean mNeedRedoMeasures = true;
    public final ArrayList<WidgetRun> mRuns = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new BasicMeasure.Measure();
        this.mGroups = new ArrayList<>();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    public final void applyGroup(DependencyNode dependencyNode, int r11, int r12, ArrayList arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun != constraintWidgetContainer.horizontalRun && widgetRun != constraintWidgetContainer.verticalRun) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun);
                    arrayList.add(runGroup);
                }
                widgetRun.runGroup = runGroup;
                runGroup.runs.add(widgetRun);
                DependencyNode dependencyNode2 = widgetRun.start;
                Iterator it = dependencyNode2.dependencies.iterator();
                while (it.hasNext()) {
                    Dependency dependency = (Dependency) it.next();
                    if (dependency instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency, r11, 0, arrayList, runGroup);
                    }
                }
                DependencyNode dependencyNode3 = widgetRun.end;
                Iterator it2 = dependencyNode3.dependencies.iterator();
                while (it2.hasNext()) {
                    Dependency dependency2 = (Dependency) it2.next();
                    if (dependency2 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency2, r11, 1, arrayList, runGroup);
                    }
                }
                if (r11 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    Iterator it3 = ((VerticalWidgetRun) widgetRun).baseline.dependencies.iterator();
                    while (it3.hasNext()) {
                        Dependency dependency3 = (Dependency) it3.next();
                        if (dependency3 instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency3, r11, 2, arrayList, runGroup);
                        }
                    }
                }
                Iterator it4 = dependencyNode2.targets.iterator();
                while (it4.hasNext()) {
                    applyGroup((DependencyNode) it4.next(), r11, 0, arrayList, runGroup);
                }
                Iterator it5 = dependencyNode3.targets.iterator();
                while (it5.hasNext()) {
                    applyGroup((DependencyNode) it5.next(), r11, 1, arrayList, runGroup);
                }
                if (r11 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    Iterator it6 = ((VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                    while (it6.hasNext()) {
                        applyGroup((DependencyNode) it6.next(), r11, 2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    public final void basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int r7;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int r9;
        DimensionDependency dimensionDependency;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        DimensionDependency dimensionDependency2;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr[1];
            if (next.mVisibility == 8) {
                next.measured = true;
            } else {
                float f = next.mMatchConstraintPercentWidth;
                if (f < 1.0f && dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                float f2 = next.mMatchConstraintPercentHeight;
                if (f2 < 1.0f && dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.mDimensionRatio > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour7 == dimensionBehaviour9 && (dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour8 == dimensionBehaviour9 && (dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour9 && dimensionBehaviour8 == dimensionBehaviour9) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                ConstraintAnchor constraintAnchor = next.mRight;
                ConstraintAnchor constraintAnchor2 = next.mLeft;
                if (dimensionBehaviour7 == dimensionBehaviour10 && next.mMatchConstraintDefaultWidth == 1 && (constraintAnchor2.mTarget == null || constraintAnchor.mTarget == null)) {
                    dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintAnchor constraintAnchor3 = next.mBottom;
                ConstraintAnchor constraintAnchor4 = next.mTop;
                if (dimensionBehaviour8 == dimensionBehaviour10 && next.mMatchConstraintDefaultHeight == 1 && (constraintAnchor4.mTarget == null || constraintAnchor3.mTarget == null)) {
                    dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviour8;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour7;
                int r10 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = r10;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour11;
                int r0 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = r0;
                Iterator<ConstraintWidget> it2 = it;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                DimensionDependency dimensionDependency3 = horizontalWidgetRun.dimension;
                DimensionDependency dimensionDependency4 = verticalWidgetRun.dimension;
                if ((dimensionBehaviour7 != dimensionBehaviour12 && dimensionBehaviour7 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour11 != dimensionBehaviour12 && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer2.mListDimensionBehaviors;
                    ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                    if (dimensionBehaviour7 == dimensionBehaviour10 && (dimensionBehaviour11 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour11 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (r10 == 3) {
                            if (dimensionBehaviour11 == dimensionBehaviour6) {
                                dimensionDependency2 = dimensionDependency3;
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            } else {
                                dimensionDependency2 = dimensionDependency3;
                            }
                            int height = next.getHeight();
                            int r72 = (int) ((height * next.mDimensionRatio) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour13, r72, dimensionBehaviour13, height);
                            dimensionDependency2.resolve(next.getWidth());
                            dimensionDependency4.resolve(next.getHeight());
                            next.measured = true;
                        } else {
                            dimensionDependency = dimensionDependency3;
                            if (r10 == 1) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour11, 0);
                                dimensionDependency.wrapValue = next.getWidth();
                            } else if (r10 == 2) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = dimensionBehaviourArr2[0];
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour14 == dimensionBehaviour15 || dimensionBehaviour14 == dimensionBehaviour12) {
                                    measure(next, dimensionBehaviour15, (int) ((f * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour11, next.getHeight());
                                    dimensionDependency.resolve(next.getWidth());
                                    dimensionDependency4.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            } else if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour11, 0);
                                dimensionDependency.resolve(next.getWidth());
                                dimensionDependency4.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                        it = it2;
                    } else {
                        dimensionDependency = dimensionDependency3;
                    }
                    if (dimensionBehaviour11 == dimensionBehaviour10 && (dimensionBehaviour7 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (r0 == 3) {
                            if (dimensionBehaviour7 == dimensionBehaviour5) {
                                measure(next, dimensionBehaviour5, 0, dimensionBehaviour5, 0);
                            }
                            int width = next.getWidth();
                            float f3 = next.mDimensionRatio;
                            if (next.mDimensionRatioSide == -1) {
                                f3 = 1.0f / f3;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour16, width, dimensionBehaviour16, (int) ((width * f3) + 0.5f));
                            dimensionDependency.resolve(next.getWidth());
                            dimensionDependency4.resolve(next.getHeight());
                            next.measured = true;
                        } else if (r0 == 1) {
                            measure(next, dimensionBehaviour7, 0, dimensionBehaviour5, 0);
                            dimensionDependency4.wrapValue = next.getHeight();
                        } else if (r0 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = dimensionBehaviourArr2[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour17 == dimensionBehaviour18 || dimensionBehaviour17 == dimensionBehaviour12) {
                                measure(next, dimensionBehaviour7, next.getWidth(), dimensionBehaviour18, (int) ((f2 * constraintWidgetContainer.getHeight()) + 0.5f));
                                dimensionDependency.resolve(next.getWidth());
                                dimensionDependency4.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else if (constraintAnchorArr[2].mTarget == null || constraintAnchorArr[3].mTarget == null) {
                            measure(next, dimensionBehaviour5, 0, dimensionBehaviour11, 0);
                            dimensionDependency.resolve(next.getWidth());
                            dimensionDependency4.resolve(next.getHeight());
                            next.measured = true;
                        }
                    }
                    if (dimensionBehaviour7 == dimensionBehaviour10 && dimensionBehaviour11 == dimensionBehaviour10) {
                        if (r10 != 1 && r0 != 1) {
                            if (r0 == 2 && r10 == 2 && (((dimensionBehaviour2 = dimensionBehaviourArr2[0]) == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED) || dimensionBehaviour2 == dimensionBehaviour3) && ((dimensionBehaviour4 = dimensionBehaviourArr2[1]) == dimensionBehaviour3 || dimensionBehaviour4 == dimensionBehaviour3))) {
                                measure(next, dimensionBehaviour3, (int) ((f * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour3, (int) ((f2 * constraintWidgetContainer.getHeight()) + 0.5f));
                                dimensionDependency.resolve(next.getWidth());
                                dimensionDependency4.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            measure(next, dimensionBehaviour19, 0, dimensionBehaviour19, 0);
                            dimensionDependency.wrapValue = next.getWidth();
                            dimensionDependency4.wrapValue = next.getHeight();
                        }
                    }
                } else {
                    int width2 = next.getWidth();
                    if (dimensionBehaviour7 == dimensionBehaviour12) {
                        r7 = (constraintWidgetContainer.getWidth() - constraintAnchor2.mMargin) - constraintAnchor.mMargin;
                        dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        r7 = width2;
                    }
                    int height2 = next.getHeight();
                    if (dimensionBehaviour11 == dimensionBehaviour12) {
                        r9 = (constraintWidgetContainer.getHeight() - constraintAnchor4.mMargin) - constraintAnchor3.mMargin;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        dimensionBehaviour = dimensionBehaviour11;
                        r9 = height2;
                    }
                    measure(next, dimensionBehaviour7, r7, dimensionBehaviour, r9);
                    dimensionDependency3.resolve(next.getWidth());
                    dimensionDependency4.resolve(next.getHeight());
                    next.measured = true;
                }
                constraintWidgetContainer2 = constraintWidgetContainer;
                it = it2;
            }
        }
    }

    public final void buildGraph() {
        ArrayList<WidgetRun> arrayList = this.mRuns;
        arrayList.clear();
        ConstraintWidgetContainer constraintWidgetContainer = this.mContainer;
        constraintWidgetContainer.horizontalRun.clear();
        VerticalWidgetRun verticalWidgetRun = constraintWidgetContainer.verticalRun;
        verticalWidgetRun.clear();
        arrayList.add(constraintWidgetContainer.horizontalRun);
        arrayList.add(verticalWidgetRun);
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.widget != constraintWidgetContainer) {
                next2.apply();
            }
        }
        ArrayList<RunGroup> arrayList2 = this.mGroups;
        arrayList2.clear();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
        findGroup(constraintWidgetContainer2.horizontalRun, 0, arrayList2);
        findGroup(constraintWidgetContainer2.verticalRun, 1, arrayList2);
        this.mNeedBuildGraph = false;
    }

    public final int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int r21) {
        long j;
        ArrayList<RunGroup> arrayList;
        int r18;
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long max;
        float f;
        long j2;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int r2 = r21;
        ArrayList<RunGroup> arrayList2 = this.mGroups;
        int size = arrayList2.size();
        int r5 = 0;
        long j3 = 0;
        while (r5 < size) {
            WidgetRun widgetRun3 = arrayList2.get(r5).firstRun;
            if (!(widgetRun3 instanceof ChainRun) ? !(r2 != 0 ? (widgetRun3 instanceof VerticalWidgetRun) : (widgetRun3 instanceof HorizontalWidgetRun)) : ((ChainRun) widgetRun3).orientation != r2) {
                j = 0;
                arrayList = arrayList2;
                r18 = size;
            } else {
                if (r2 == 0) {
                    widgetRun = constraintWidgetContainer2.horizontalRun;
                } else {
                    widgetRun = constraintWidgetContainer2.verticalRun;
                }
                DependencyNode dependencyNode = widgetRun.start;
                if (r2 == 0) {
                    widgetRun2 = constraintWidgetContainer2.horizontalRun;
                } else {
                    widgetRun2 = constraintWidgetContainer2.verticalRun;
                }
                DependencyNode dependencyNode2 = widgetRun2.end;
                boolean contains = widgetRun3.start.targets.contains(dependencyNode);
                DependencyNode dependencyNode3 = widgetRun3.end;
                boolean contains2 = dependencyNode3.targets.contains(dependencyNode2);
                long wrapDimension = widgetRun3.getWrapDimension();
                DependencyNode dependencyNode4 = widgetRun3.start;
                if (contains && contains2) {
                    long traverseStart = RunGroup.traverseStart(dependencyNode4, 0L);
                    long traverseEnd = RunGroup.traverseEnd(dependencyNode3, 0L);
                    long j4 = traverseStart - wrapDimension;
                    int r0 = dependencyNode3.margin;
                    arrayList = arrayList2;
                    r18 = size;
                    if (j4 >= (-r0)) {
                        j4 += r0;
                    }
                    long j5 = j4;
                    long j6 = (-traverseEnd) - wrapDimension;
                    long j7 = dependencyNode4.margin;
                    long j8 = j6 - j7;
                    if (j8 >= j7) {
                        j8 -= j7;
                    }
                    ConstraintWidget constraintWidget = widgetRun3.widget;
                    if (r2 == 0) {
                        f = constraintWidget.mHorizontalBiasPercent;
                    } else if (r2 == 1) {
                        f = constraintWidget.mVerticalBiasPercent;
                    } else {
                        constraintWidget.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j2 = (((float) j5) / (1.0f - f)) + (((float) j8) / f);
                    } else {
                        j2 = 0;
                    }
                    float f2 = (float) j2;
                    j = (dependencyNode4.margin + ((((f2 * f) + 0.5f) + wrapDimension) + DrawerArrowDrawable$$ExternalSyntheticOutline0.m(1.0f, f, f2, 0.5f))) - dependencyNode3.margin;
                } else {
                    arrayList = arrayList2;
                    r18 = size;
                    if (contains) {
                        max = Math.max(RunGroup.traverseStart(dependencyNode4, dependencyNode4.margin), dependencyNode4.margin + wrapDimension);
                    } else if (contains2) {
                        max = Math.max(-RunGroup.traverseEnd(dependencyNode3, dependencyNode3.margin), (-dependencyNode3.margin) + wrapDimension);
                    } else {
                        j = (widgetRun3.getWrapDimension() + dependencyNode4.margin) - dependencyNode3.margin;
                    }
                    j = max;
                }
            }
            j3 = Math.max(j3, j);
            r5++;
            constraintWidgetContainer2 = constraintWidgetContainer;
            r2 = r21;
            arrayList2 = arrayList;
            size = r18;
        }
        return (int) j3;
    }

    public final void findGroup(WidgetRun widgetRun, int r11, ArrayList<RunGroup> arrayList) {
        DependencyNode dependencyNode;
        Iterator it = widgetRun.start.dependencies.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            dependencyNode = widgetRun.end;
            if (!hasNext) {
                break;
            }
            Dependency dependency = (Dependency) it.next();
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, r11, 0, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, r11, 0, arrayList, null);
            }
        }
        Iterator it2 = dependencyNode.dependencies.iterator();
        while (it2.hasNext()) {
            Dependency dependency2 = (Dependency) it2.next();
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, r11, 1, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, r11, 1, arrayList, null);
            }
        }
        if (r11 == 1) {
            Iterator it3 = ((VerticalWidgetRun) widgetRun).baseline.dependencies.iterator();
            while (it3.hasNext()) {
                Dependency dependency3 = (Dependency) it3.next();
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, r11, 2, arrayList, null);
                }
            }
        }
    }

    public final void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int r4, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int r6) {
        boolean z;
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = r4;
        measure.verticalDimension = r6;
        ((ConstraintLayout.Measurer) this.mMeasurer).measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.hasBaseline = measure.measuredHasBaseline;
        int r3 = measure.measuredBaseline;
        constraintWidget.mBaselineDistance = r3;
        if (r3 > 0) {
            z = true;
        } else {
            z = false;
        }
        constraintWidget.hasBaseline = z;
    }

    public final void measureWidgets() {
        boolean z;
        BaselineDimensionDependency baselineDimensionDependency;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z2 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int r2 = next.mMatchConstraintDefaultWidth;
                int r4 = next.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour != dimensionBehaviour3 && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || r2 != 1)) {
                    z = false;
                } else {
                    z = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && r4 == 1)) {
                    z2 = true;
                }
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                DimensionDependency dimensionDependency = horizontalWidgetRun.dimension;
                boolean z3 = dimensionDependency.resolved;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                DimensionDependency dimensionDependency2 = verticalWidgetRun.dimension;
                boolean z4 = dimensionDependency2.resolved;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour4, dimensionDependency.value, dimensionBehaviour4, dimensionDependency2.value);
                    next.measured = true;
                } else if (z3 && z2) {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency.value, dimensionBehaviour3, dimensionDependency2.value);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    DimensionDependency dimensionDependency3 = verticalWidgetRun.dimension;
                    if (dimensionBehaviour2 == dimensionBehaviour5) {
                        dimensionDependency3.wrapValue = next.getHeight();
                    } else {
                        dimensionDependency3.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z) {
                    measure(next, dimensionBehaviour3, dimensionDependency.value, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.value);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    DimensionDependency dimensionDependency4 = horizontalWidgetRun.dimension;
                    if (dimensionBehaviour == dimensionBehaviour6) {
                        dimensionDependency4.wrapValue = next.getWidth();
                    } else {
                        dimensionDependency4.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (baselineDimensionDependency = verticalWidgetRun.baselineDimension) != null) {
                    baselineDimensionDependency.resolve(next.mBaselineDistance);
                }
            }
        }
    }
}
