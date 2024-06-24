package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes.dex */
public final class MergePathsContent implements PathContent, GreedyContent {
    public final MergePaths mergePaths;
    public final Path firstPath = new Path();
    public final Path remainderPath = new Path();
    public final Path path = new Path();
    public final ArrayList pathContents = new ArrayList();

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode;

        static {
            int[] r0 = new int[MergePaths.MergePathsMode.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = r0;
            try {
                r0[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        mergePaths.getClass();
        this.mergePaths = mergePaths;
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.pathContents.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
        Path path = this.path;
        path.reset();
        MergePaths mergePaths = this.mergePaths;
        if (mergePaths.hidden) {
            return path;
        }
        int r1 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[mergePaths.mode.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    if (r1 != 4) {
                        if (r1 == 5) {
                            opFirstPathWithRest(Path.Op.XOR);
                        }
                    } else {
                        opFirstPathWithRest(Path.Op.INTERSECT);
                    }
                } else {
                    opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                opFirstPathWithRest(Path.Op.UNION);
            }
        } else {
            int r12 = 0;
            while (true) {
                ArrayList arrayList = this.pathContents;
                if (r12 >= arrayList.size()) {
                    break;
                }
                path.addPath(((PathContent) arrayList.get(r12)).getPath());
                r12++;
            }
        }
        return path;
    }

    @TargetApi(19)
    public final void opFirstPathWithRest(Path.Op op) {
        Matrix matrix;
        Matrix matrix2;
        Path path = this.remainderPath;
        path.reset();
        Path path2 = this.firstPath;
        path2.reset();
        ArrayList arrayList = this.pathContents;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            PathContent pathContent = (PathContent) arrayList.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                ArrayList arrayList2 = (ArrayList) contentGroup.getPathList();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path path3 = ((PathContent) arrayList2.get(size2)).getPath();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.transformAnimation;
                    if (transformKeyframeAnimation != null) {
                        matrix2 = transformKeyframeAnimation.getMatrix();
                    } else {
                        matrix2 = contentGroup.matrix;
                        matrix2.reset();
                    }
                    path3.transform(matrix2);
                    path.addPath(path3);
                }
            } else {
                path.addPath(pathContent.getPath());
            }
        }
        int r3 = 0;
        PathContent pathContent2 = (PathContent) arrayList.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> pathList = contentGroup2.getPathList();
            while (true) {
                ArrayList arrayList3 = (ArrayList) pathList;
                if (r3 >= arrayList3.size()) {
                    break;
                }
                Path path4 = ((PathContent) arrayList3.get(r3)).getPath();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.transformAnimation;
                if (transformKeyframeAnimation2 != null) {
                    matrix = transformKeyframeAnimation2.getMatrix();
                } else {
                    matrix = contentGroup2.matrix;
                    matrix.reset();
                }
                path4.transform(matrix);
                path2.addPath(path4);
                r3++;
            }
        } else {
            path2.set(pathContent2.getPath());
        }
        this.path.op(path2, path, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.pathContents;
            if (r0 < arrayList.size()) {
                ((PathContent) arrayList.get(r0)).setContents(list, list2);
                r0++;
            } else {
                return;
            }
        }
    }
}
