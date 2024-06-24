package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class RunGroup {
    public final WidgetRun firstRun;
    public final ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun) {
        this.firstRun = null;
        this.firstRun = widgetRun;
    }

    public static long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        ArrayList arrayList = dependencyNode.dependencies;
        int size = arrayList.size();
        long j2 = j;
        for (int r3 = 0; r3 < size; r3++) {
            Dependency dependency = (Dependency) arrayList.get(r3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = widgetRun.getWrapDimension();
            long j3 = j - wrapDimension;
            return Math.min(Math.min(j2, traverseEnd(widgetRun.start, j3)), j3 - r9.margin);
        }
        return j2;
    }

    public static long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        ArrayList arrayList = dependencyNode.dependencies;
        int size = arrayList.size();
        long j2 = j;
        for (int r3 = 0; r3 < size; r3++) {
            Dependency dependency = (Dependency) arrayList.get(r3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j2 = Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.margin + j));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = widgetRun.getWrapDimension();
            long j3 = j + wrapDimension;
            return Math.max(Math.max(j2, traverseStart(widgetRun.end, j3)), j3 - r9.margin);
        }
        return j2;
    }
}
