package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ConstraintSet {
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static final SparseIntArray mapToConstant;
    public final HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    public final boolean mForceId = true;
    public final HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    /* loaded from: classes.dex */
    public static class Constraint {
        public int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        public final void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(layout.endMargin);
            layoutParams.validate();
        }

        public final Object clone() throws CloneNotSupportedException {
            Constraint constraint = new Constraint();
            Layout layout = constraint.layout;
            layout.getClass();
            Layout layout2 = this.layout;
            layout.mIsGuideline = layout2.mIsGuideline;
            layout.mWidth = layout2.mWidth;
            layout.mHeight = layout2.mHeight;
            layout.guideBegin = layout2.guideBegin;
            layout.guideEnd = layout2.guideEnd;
            layout.guidePercent = layout2.guidePercent;
            layout.leftToLeft = layout2.leftToLeft;
            layout.leftToRight = layout2.leftToRight;
            layout.rightToLeft = layout2.rightToLeft;
            layout.rightToRight = layout2.rightToRight;
            layout.topToTop = layout2.topToTop;
            layout.topToBottom = layout2.topToBottom;
            layout.bottomToTop = layout2.bottomToTop;
            layout.bottomToBottom = layout2.bottomToBottom;
            layout.baselineToBaseline = layout2.baselineToBaseline;
            layout.startToEnd = layout2.startToEnd;
            layout.startToStart = layout2.startToStart;
            layout.endToStart = layout2.endToStart;
            layout.endToEnd = layout2.endToEnd;
            layout.horizontalBias = layout2.horizontalBias;
            layout.verticalBias = layout2.verticalBias;
            layout.dimensionRatio = layout2.dimensionRatio;
            layout.circleConstraint = layout2.circleConstraint;
            layout.circleRadius = layout2.circleRadius;
            layout.circleAngle = layout2.circleAngle;
            layout.editorAbsoluteX = layout2.editorAbsoluteX;
            layout.editorAbsoluteY = layout2.editorAbsoluteY;
            layout.orientation = layout2.orientation;
            layout.leftMargin = layout2.leftMargin;
            layout.rightMargin = layout2.rightMargin;
            layout.topMargin = layout2.topMargin;
            layout.bottomMargin = layout2.bottomMargin;
            layout.endMargin = layout2.endMargin;
            layout.startMargin = layout2.startMargin;
            layout.goneLeftMargin = layout2.goneLeftMargin;
            layout.goneTopMargin = layout2.goneTopMargin;
            layout.goneRightMargin = layout2.goneRightMargin;
            layout.goneBottomMargin = layout2.goneBottomMargin;
            layout.goneEndMargin = layout2.goneEndMargin;
            layout.goneStartMargin = layout2.goneStartMargin;
            layout.verticalWeight = layout2.verticalWeight;
            layout.horizontalWeight = layout2.horizontalWeight;
            layout.horizontalChainStyle = layout2.horizontalChainStyle;
            layout.verticalChainStyle = layout2.verticalChainStyle;
            layout.widthDefault = layout2.widthDefault;
            layout.heightDefault = layout2.heightDefault;
            layout.widthMax = layout2.widthMax;
            layout.heightMax = layout2.heightMax;
            layout.widthMin = layout2.widthMin;
            layout.heightMin = layout2.heightMin;
            layout.widthPercent = layout2.widthPercent;
            layout.heightPercent = layout2.heightPercent;
            layout.mBarrierDirection = layout2.mBarrierDirection;
            layout.mBarrierMargin = layout2.mBarrierMargin;
            layout.mHelperType = layout2.mHelperType;
            layout.mConstraintTag = layout2.mConstraintTag;
            int[] r3 = layout2.mReferenceIds;
            if (r3 != null) {
                layout.mReferenceIds = Arrays.copyOf(r3, r3.length);
            } else {
                layout.mReferenceIds = null;
            }
            layout.mReferenceIdString = layout2.mReferenceIdString;
            layout.constrainedWidth = layout2.constrainedWidth;
            layout.constrainedHeight = layout2.constrainedHeight;
            layout.mBarrierAllowsGoneWidgets = layout2.mBarrierAllowsGoneWidgets;
            Motion motion = constraint.motion;
            motion.getClass();
            Motion motion2 = this.motion;
            motion2.getClass();
            motion.mAnimateRelativeTo = motion2.mAnimateRelativeTo;
            motion.mPathMotionArc = motion2.mPathMotionArc;
            motion.mPathRotate = motion2.mPathRotate;
            motion.mMotionStagger = motion2.mMotionStagger;
            PropertySet propertySet = constraint.propertySet;
            propertySet.getClass();
            PropertySet propertySet2 = this.propertySet;
            propertySet2.getClass();
            propertySet.visibility = propertySet2.visibility;
            propertySet.alpha = propertySet2.alpha;
            propertySet.mProgress = propertySet2.mProgress;
            propertySet.mVisibilityMode = propertySet2.mVisibilityMode;
            Transform transform = constraint.transform;
            transform.getClass();
            Transform transform2 = this.transform;
            transform2.getClass();
            transform.rotation = transform2.rotation;
            transform.rotationX = transform2.rotationX;
            transform.rotationY = transform2.rotationY;
            transform.scaleX = transform2.scaleX;
            transform.scaleY = transform2.scaleY;
            transform.transformPivotX = transform2.transformPivotX;
            transform.transformPivotY = transform2.transformPivotY;
            transform.translationX = transform2.translationX;
            transform.translationY = transform2.translationY;
            transform.translationZ = transform2.translationZ;
            transform.applyElevation = transform2.applyElevation;
            transform.elevation = transform2.elevation;
            constraint.mViewId = this.mViewId;
            return constraint;
        }

        public final void fillFrom(int r2, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = r2;
            int r22 = layoutParams.leftToLeft;
            Layout layout = this.layout;
            layout.leftToLeft = r22;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.endMargin = layoutParams.getMarginEnd();
            layout.startMargin = layoutParams.getMarginStart();
        }

        public final void fillFromConstraints(int r2, Constraints.LayoutParams layoutParams) {
            fillFrom(r2, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            float f = layoutParams.rotation;
            Transform transform = this.transform;
            transform.rotation = f;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }
    }

    /* loaded from: classes.dex */
    public static class Layout {
        public static final SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = -1;
        public int rightMargin = -1;
        public int topMargin = -1;
        public int bottomMargin = -1;
        public int endMargin = -1;
        public int startMargin = -1;
        public int goneLeftMargin = -1;
        public int goneTopMargin = -1;
        public int goneRightMargin = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneStartMargin = -1;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = -1;
        public int heightMax = -1;
        public int widthMin = -1;
        public int heightMin = -1;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(38, 24);
            sparseIntArray.append(39, 25);
            sparseIntArray.append(41, 28);
            sparseIntArray.append(42, 29);
            sparseIntArray.append(47, 35);
            sparseIntArray.append(46, 34);
            sparseIntArray.append(20, 4);
            sparseIntArray.append(19, 3);
            sparseIntArray.append(17, 1);
            sparseIntArray.append(55, 6);
            sparseIntArray.append(56, 7);
            sparseIntArray.append(27, 17);
            sparseIntArray.append(28, 18);
            sparseIntArray.append(29, 19);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(43, 31);
            sparseIntArray.append(44, 32);
            sparseIntArray.append(26, 10);
            sparseIntArray.append(25, 9);
            sparseIntArray.append(59, 13);
            sparseIntArray.append(62, 16);
            sparseIntArray.append(60, 14);
            sparseIntArray.append(57, 11);
            sparseIntArray.append(61, 15);
            sparseIntArray.append(58, 12);
            sparseIntArray.append(50, 38);
            sparseIntArray.append(36, 37);
            sparseIntArray.append(35, 39);
            sparseIntArray.append(49, 40);
            sparseIntArray.append(34, 20);
            sparseIntArray.append(48, 36);
            sparseIntArray.append(24, 5);
            sparseIntArray.append(37, 76);
            sparseIntArray.append(45, 76);
            sparseIntArray.append(40, 76);
            sparseIntArray.append(18, 76);
            sparseIntArray.append(16, 76);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(21, 61);
            sparseIntArray.append(23, 62);
            sparseIntArray.append(22, 63);
            sparseIntArray.append(54, 69);
            sparseIntArray.append(33, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r0 = 0; r0 < indexCount; r0++) {
                int index = obtainStyledAttributes.getIndex(r0);
                SparseIntArray sparseIntArray = mapToConstant;
                int r3 = sparseIntArray.get(index);
                if (r3 != 80) {
                    if (r3 != 81) {
                        switch (r3) {
                            case 1:
                                this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                                break;
                            case 2:
                                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                                break;
                            case 3:
                                this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                                break;
                            case 4:
                                this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                                break;
                            case 5:
                                this.dimensionRatio = obtainStyledAttributes.getString(index);
                                break;
                            case 6:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 7:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 8:
                                this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                                break;
                            case 9:
                                this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                                break;
                            case 10:
                                this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                                break;
                            case 11:
                                this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                                break;
                            case 12:
                                this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                                break;
                            case 13:
                                this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                                break;
                            case 14:
                                this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                                break;
                            case 15:
                                this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                                break;
                            case 16:
                                this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                                break;
                            case 17:
                                this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                                break;
                            case 18:
                                this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                                break;
                            case 19:
                                this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                                break;
                            case 20:
                                this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                                break;
                            case 21:
                                this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                                break;
                            case 22:
                                this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                                break;
                            case 23:
                                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                                break;
                            case 24:
                                this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                                break;
                            case 25:
                                this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                                break;
                            case 26:
                                this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                                break;
                            case 27:
                                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                                break;
                            case 28:
                                this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                                break;
                            case 29:
                                this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                                break;
                            case 30:
                                this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                                break;
                            case 31:
                                this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                                break;
                            case 32:
                                this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                                break;
                            case 33:
                                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                                break;
                            case 34:
                                this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                                break;
                            case 35:
                                this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                                break;
                            case 36:
                                this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                                break;
                            case 37:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 38:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 39:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                                break;
                            case 40:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                                break;
                            default:
                                switch (r3) {
                                    case 54:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 55:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 56:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 57:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 58:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 59:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    default:
                                        switch (r3) {
                                            case 61:
                                                this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                                break;
                                            case 62:
                                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                                break;
                                            case 63:
                                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                                break;
                                            default:
                                                switch (r3) {
                                                    case 69:
                                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 70:
                                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 71:
                                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                        break;
                                                    case 72:
                                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                        break;
                                                    case 73:
                                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                        break;
                                                    case 74:
                                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                        break;
                                                    case 75:
                                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                        break;
                                                    case 76:
                                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                        break;
                                                    case 77:
                                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                        break;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                    }
                } else {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Motion {
        public static final SparseIntArray mapToConstant;
        public int mAnimateRelativeTo = -1;
        public int mPathMotionArc = -1;
        public float mMotionStagger = Float.NaN;
        public float mPathRotate = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(2, 1);
            sparseIntArray.append(4, 2);
            sparseIntArray.append(5, 3);
            sparseIntArray.append(1, 4);
            sparseIntArray.append(0, 5);
            sparseIntArray.append(3, 6);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r1 = 0; r1 < indexCount; r1++) {
                int index = obtainStyledAttributes.getIndex(r1);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r0 = 0; r0 < indexCount; r0++) {
                int index = obtainStyledAttributes.getIndex(r0);
                if (index == 1) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 0) {
                    int r1 = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = r1;
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[r1];
                } else if (index == 4) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == 3) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Transform {
        public static final SparseIntArray mapToConstant;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r0 = 0; r0 < indexCount; r0++) {
                int index = obtainStyledAttributes.getIndex(r0);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] convertReferenceString(Barrier barrier, String str) {
        int r7;
        HashMap<String, Integer> hashMap;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] r1 = new int[split.length];
        int r3 = 0;
        int r4 = 0;
        while (r3 < split.length) {
            String trim = split[r3].trim();
            Integer num = null;
            try {
                r7 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                r7 = 0;
            }
            if (r7 == 0) {
                r7 = context.getResources().getIdentifier(trim, ConfigurationItem.COLUMN_NAME_ID, context.getPackageName());
            }
            if (r7 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                constraintLayout.getClass();
                if ((trim instanceof String) && (hashMap = constraintLayout.mDesignIds) != null && hashMap.containsKey(trim)) {
                    num = constraintLayout.mDesignIds.get(trim);
                }
                if (num != null && (num instanceof Integer)) {
                    r7 = num.intValue();
                }
            }
            r1[r4] = r7;
            r3++;
            r4++;
        }
        if (r4 != split.length) {
            return Arrays.copyOf(r1, r4);
        }
        return r1;
    }

    public static Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Constraint);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int r2 = 0; r2 < indexCount; r2++) {
            int index = obtainStyledAttributes.getIndex(r2);
            PropertySet propertySet = constraint.propertySet;
            Motion motion = constraint.motion;
            Transform transform = constraint.transform;
            Layout layout = constraint.layout;
            if (index != 1 && 23 != index && 24 != index) {
                motion.getClass();
                layout.getClass();
                propertySet.getClass();
                transform.getClass();
            }
            SparseIntArray sparseIntArray = mapToConstant;
            switch (sparseIntArray.get(index)) {
                case 1:
                    layout.baselineToBaseline = lookupID(obtainStyledAttributes, index, layout.baselineToBaseline);
                    break;
                case 2:
                    layout.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.bottomMargin);
                    break;
                case 3:
                    layout.bottomToBottom = lookupID(obtainStyledAttributes, index, layout.bottomToBottom);
                    break;
                case 4:
                    layout.bottomToTop = lookupID(obtainStyledAttributes, index, layout.bottomToTop);
                    break;
                case 5:
                    layout.dimensionRatio = obtainStyledAttributes.getString(index);
                    break;
                case 6:
                    layout.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteX);
                    break;
                case 7:
                    layout.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteY);
                    break;
                case 8:
                    layout.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.endMargin);
                    break;
                case 9:
                    layout.endToEnd = lookupID(obtainStyledAttributes, index, layout.endToEnd);
                    break;
                case 10:
                    layout.endToStart = lookupID(obtainStyledAttributes, index, layout.endToStart);
                    break;
                case 11:
                    layout.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneBottomMargin);
                    break;
                case 12:
                    layout.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneEndMargin);
                    break;
                case 13:
                    layout.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneLeftMargin);
                    break;
                case 14:
                    layout.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneRightMargin);
                    break;
                case 15:
                    layout.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneStartMargin);
                    break;
                case 16:
                    layout.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.goneTopMargin);
                    break;
                case 17:
                    layout.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, layout.guideBegin);
                    break;
                case 18:
                    layout.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, layout.guideEnd);
                    break;
                case 19:
                    layout.guidePercent = obtainStyledAttributes.getFloat(index, layout.guidePercent);
                    break;
                case 20:
                    layout.horizontalBias = obtainStyledAttributes.getFloat(index, layout.horizontalBias);
                    break;
                case 21:
                    layout.mHeight = obtainStyledAttributes.getLayoutDimension(index, layout.mHeight);
                    break;
                case 22:
                    propertySet.visibility = VISIBILITY_FLAGS[obtainStyledAttributes.getInt(index, propertySet.visibility)];
                    break;
                case 23:
                    layout.mWidth = obtainStyledAttributes.getLayoutDimension(index, layout.mWidth);
                    break;
                case 24:
                    layout.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.leftMargin);
                    break;
                case 25:
                    layout.leftToLeft = lookupID(obtainStyledAttributes, index, layout.leftToLeft);
                    break;
                case 26:
                    layout.leftToRight = lookupID(obtainStyledAttributes, index, layout.leftToRight);
                    break;
                case 27:
                    layout.orientation = obtainStyledAttributes.getInt(index, layout.orientation);
                    break;
                case 28:
                    layout.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.rightMargin);
                    break;
                case 29:
                    layout.rightToLeft = lookupID(obtainStyledAttributes, index, layout.rightToLeft);
                    break;
                case 30:
                    layout.rightToRight = lookupID(obtainStyledAttributes, index, layout.rightToRight);
                    break;
                case 31:
                    layout.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.startMargin);
                    break;
                case 32:
                    layout.startToEnd = lookupID(obtainStyledAttributes, index, layout.startToEnd);
                    break;
                case 33:
                    layout.startToStart = lookupID(obtainStyledAttributes, index, layout.startToStart);
                    break;
                case 34:
                    layout.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.topMargin);
                    break;
                case 35:
                    layout.topToBottom = lookupID(obtainStyledAttributes, index, layout.topToBottom);
                    break;
                case 36:
                    layout.topToTop = lookupID(obtainStyledAttributes, index, layout.topToTop);
                    break;
                case 37:
                    layout.verticalBias = obtainStyledAttributes.getFloat(index, layout.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = obtainStyledAttributes.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    layout.horizontalWeight = obtainStyledAttributes.getFloat(index, layout.horizontalWeight);
                    break;
                case 40:
                    layout.verticalWeight = obtainStyledAttributes.getFloat(index, layout.verticalWeight);
                    break;
                case 41:
                    layout.horizontalChainStyle = obtainStyledAttributes.getInt(index, layout.horizontalChainStyle);
                    break;
                case 42:
                    layout.verticalChainStyle = obtainStyledAttributes.getInt(index, layout.verticalChainStyle);
                    break;
                case 43:
                    propertySet.alpha = obtainStyledAttributes.getFloat(index, propertySet.alpha);
                    break;
                case 44:
                    transform.applyElevation = true;
                    transform.elevation = obtainStyledAttributes.getDimension(index, transform.elevation);
                    break;
                case 45:
                    transform.rotationX = obtainStyledAttributes.getFloat(index, transform.rotationX);
                    break;
                case 46:
                    transform.rotationY = obtainStyledAttributes.getFloat(index, transform.rotationY);
                    break;
                case 47:
                    transform.scaleX = obtainStyledAttributes.getFloat(index, transform.scaleX);
                    break;
                case 48:
                    transform.scaleY = obtainStyledAttributes.getFloat(index, transform.scaleY);
                    break;
                case 49:
                    transform.transformPivotX = obtainStyledAttributes.getDimension(index, transform.transformPivotX);
                    break;
                case 50:
                    transform.transformPivotY = obtainStyledAttributes.getDimension(index, transform.transformPivotY);
                    break;
                case 51:
                    transform.translationX = obtainStyledAttributes.getDimension(index, transform.translationX);
                    break;
                case 52:
                    transform.translationY = obtainStyledAttributes.getDimension(index, transform.translationY);
                    break;
                case 53:
                    transform.translationZ = obtainStyledAttributes.getDimension(index, transform.translationZ);
                    break;
                case 54:
                    layout.widthDefault = obtainStyledAttributes.getInt(index, layout.widthDefault);
                    break;
                case 55:
                    layout.heightDefault = obtainStyledAttributes.getInt(index, layout.heightDefault);
                    break;
                case 56:
                    layout.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, layout.widthMax);
                    break;
                case 57:
                    layout.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, layout.heightMax);
                    break;
                case 58:
                    layout.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, layout.widthMin);
                    break;
                case 59:
                    layout.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, layout.heightMin);
                    break;
                case 60:
                    transform.rotation = obtainStyledAttributes.getFloat(index, transform.rotation);
                    break;
                case 61:
                    layout.circleConstraint = lookupID(obtainStyledAttributes, index, layout.circleConstraint);
                    break;
                case 62:
                    layout.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, layout.circleRadius);
                    break;
                case 63:
                    layout.circleAngle = obtainStyledAttributes.getFloat(index, layout.circleAngle);
                    break;
                case 64:
                    motion.mAnimateRelativeTo = lookupID(obtainStyledAttributes, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        motion.getClass();
                        break;
                    } else {
                        String str = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                        motion.getClass();
                        break;
                    }
                case 66:
                    obtainStyledAttributes.getInt(index, 0);
                    motion.getClass();
                    break;
                case 67:
                    motion.mPathRotate = obtainStyledAttributes.getFloat(index, motion.mPathRotate);
                    break;
                case 68:
                    propertySet.mProgress = obtainStyledAttributes.getFloat(index, propertySet.mProgress);
                    break;
                case 69:
                    layout.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    layout.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    layout.mBarrierDirection = obtainStyledAttributes.getInt(index, layout.mBarrierDirection);
                    break;
                case 73:
                    layout.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout.mBarrierMargin);
                    break;
                case 74:
                    layout.mReferenceIdString = obtainStyledAttributes.getString(index);
                    break;
                case 75:
                    layout.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, layout.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    motion.mPathMotionArc = obtainStyledAttributes.getInt(index, motion.mPathMotionArc);
                    break;
                case 77:
                    layout.mConstraintTag = obtainStyledAttributes.getString(index);
                    break;
                case 78:
                    propertySet.mVisibilityMode = obtainStyledAttributes.getInt(index, propertySet.mVisibilityMode);
                    break;
                case 79:
                    motion.mMotionStagger = obtainStyledAttributes.getFloat(index, motion.mMotionStagger);
                    break;
                case 80:
                    layout.constrainedWidth = obtainStyledAttributes.getBoolean(index, layout.constrainedWidth);
                    break;
                case 81:
                    layout.constrainedHeight = obtainStyledAttributes.getBoolean(index, layout.constrainedHeight);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public static int lookupID(TypedArray typedArray, int r2, int r3) {
        int resourceId = typedArray.getResourceId(r2, r3);
        if (resourceId == -1) {
            return typedArray.getInt(r2, -1);
        }
        return resourceId;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0107. Please report as an issue. */
    public final void applyToInternal(ConstraintLayout constraintLayout) {
        int r16;
        HashMap<String, ConstraintAttribute> hashMap;
        Iterator<String> it;
        String str;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, Constraint> hashMap2 = constraintSet.mConstraints;
        HashSet hashSet = new HashSet(hashMap2.keySet());
        int r6 = 0;
        while (r6 < childCount) {
            View childAt = constraintLayout.getChildAt(r6);
            int id = childAt.getId();
            if (!hashMap2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    str = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str = "UNKNOWN";
                }
                sb.append(str);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (constraintSet.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (hashMap2.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = hashMap2.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            constraint.layout.mHelperType = 1;
                        }
                        int r11 = constraint.layout.mHelperType;
                        if (r11 != -1 && r11 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            Layout layout = constraint.layout;
                            barrier.setType(layout.mBarrierDirection);
                            barrier.setMargin(layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(layout.mBarrierAllowsGoneWidgets);
                            int[] r9 = layout.mReferenceIds;
                            if (r9 != null) {
                                barrier.setReferencedIds(r9);
                            } else {
                                String str2 = layout.mReferenceIdString;
                                if (str2 != null) {
                                    int[] convertReferenceString = convertReferenceString(barrier, str2);
                                    layout.mReferenceIds = convertReferenceString;
                                    barrier.setReferencedIds(convertReferenceString);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        HashMap<String, ConstraintAttribute> hashMap3 = constraint.mCustomConstraints;
                        Class<?> cls = childAt.getClass();
                        Iterator<String> it2 = hashMap3.keySet().iterator();
                        while (it2.hasNext()) {
                            String next = it2.next();
                            ConstraintAttribute constraintAttribute = hashMap3.get(next);
                            int r162 = childCount;
                            String m = ConstraintSet$$ExternalSyntheticOutline0.m("set", next);
                            try {
                                hashMap = hashMap3;
                            } catch (IllegalAccessException e) {
                                e = e;
                                hashMap = hashMap3;
                            } catch (NoSuchMethodException e2) {
                                e = e2;
                                hashMap = hashMap3;
                            } catch (InvocationTargetException e3) {
                                e = e3;
                                hashMap = hashMap3;
                            }
                            try {
                                switch (ConstraintAttribute.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[constraintAttribute.mType.ordinal()]) {
                                    case 1:
                                        it = it2;
                                        cls.getMethod(m, Integer.TYPE).invoke(childAt, Integer.valueOf(constraintAttribute.mColorValue));
                                        break;
                                    case 2:
                                        it = it2;
                                        Method method = cls.getMethod(m, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(constraintAttribute.mColorValue);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 3:
                                        it = it2;
                                        cls.getMethod(m, Integer.TYPE).invoke(childAt, Integer.valueOf(constraintAttribute.mIntegerValue));
                                        break;
                                    case 4:
                                        it = it2;
                                        cls.getMethod(m, Float.TYPE).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        break;
                                    case 5:
                                        it = it2;
                                        cls.getMethod(m, CharSequence.class).invoke(childAt, constraintAttribute.mStringValue);
                                        break;
                                    case 6:
                                        it = it2;
                                        cls.getMethod(m, Boolean.TYPE).invoke(childAt, Boolean.valueOf(constraintAttribute.mBooleanValue));
                                        break;
                                    case 7:
                                        it = it2;
                                        try {
                                            cls.getMethod(m, Float.TYPE).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        } catch (IllegalAccessException e4) {
                                            e = e4;
                                            StringBuilder m2 = ActivityResultRegistry$$ExternalSyntheticOutline0.m(" Custom Attribute \"", next, "\" not found on ");
                                            m2.append(cls.getName());
                                            Log.e("TransitionLayout", m2.toString());
                                            e.printStackTrace();
                                            childCount = r162;
                                            it2 = it;
                                            hashMap3 = hashMap;
                                        } catch (NoSuchMethodException e5) {
                                            e = e5;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + m);
                                            childCount = r162;
                                            it2 = it;
                                            hashMap3 = hashMap;
                                        } catch (InvocationTargetException e6) {
                                            e = e6;
                                            StringBuilder m3 = ActivityResultRegistry$$ExternalSyntheticOutline0.m(" Custom Attribute \"", next, "\" not found on ");
                                            m3.append(cls.getName());
                                            Log.e("TransitionLayout", m3.toString());
                                            e.printStackTrace();
                                            childCount = r162;
                                            it2 = it;
                                            hashMap3 = hashMap;
                                        }
                                    default:
                                        it = it2;
                                        break;
                                }
                            } catch (IllegalAccessException e7) {
                                e = e7;
                                it = it2;
                                StringBuilder m22 = ActivityResultRegistry$$ExternalSyntheticOutline0.m(" Custom Attribute \"", next, "\" not found on ");
                                m22.append(cls.getName());
                                Log.e("TransitionLayout", m22.toString());
                                e.printStackTrace();
                                childCount = r162;
                                it2 = it;
                                hashMap3 = hashMap;
                            } catch (NoSuchMethodException e8) {
                                e = e8;
                                it = it2;
                                Log.e("TransitionLayout", e.getMessage());
                                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                Log.e("TransitionLayout", cls.getName() + " must have a method " + m);
                                childCount = r162;
                                it2 = it;
                                hashMap3 = hashMap;
                            } catch (InvocationTargetException e9) {
                                e = e9;
                                it = it2;
                                StringBuilder m32 = ActivityResultRegistry$$ExternalSyntheticOutline0.m(" Custom Attribute \"", next, "\" not found on ");
                                m32.append(cls.getName());
                                Log.e("TransitionLayout", m32.toString());
                                e.printStackTrace();
                                childCount = r162;
                                it2 = it;
                                hashMap3 = hashMap;
                            }
                            childCount = r162;
                            it2 = it;
                            hashMap3 = hashMap;
                        }
                        r16 = childCount;
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.propertySet;
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(propertySet.alpha);
                        Transform transform = constraint.transform;
                        childAt.setRotation(transform.rotation);
                        childAt.setRotationX(transform.rotationX);
                        childAt.setRotationY(transform.rotationY);
                        childAt.setScaleX(transform.scaleX);
                        childAt.setScaleY(transform.scaleY);
                        if (!Float.isNaN(transform.transformPivotX)) {
                            childAt.setPivotX(transform.transformPivotX);
                        }
                        if (!Float.isNaN(transform.transformPivotY)) {
                            childAt.setPivotY(transform.transformPivotY);
                        }
                        childAt.setTranslationX(transform.translationX);
                        childAt.setTranslationY(transform.translationY);
                        childAt.setTranslationZ(transform.translationZ);
                        if (transform.applyElevation) {
                            childAt.setElevation(transform.elevation);
                        }
                    } else {
                        r16 = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                    r6++;
                    constraintSet = this;
                    childCount = r16;
                }
            }
            r16 = childCount;
            r6++;
            constraintSet = this;
            childCount = r16;
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            Integer num = (Integer) it3.next();
            Constraint constraint2 = hashMap2.get(num);
            Layout layout2 = constraint2.layout;
            int r62 = layout2.mHelperType;
            if (r62 != -1 && r62 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] r8 = layout2.mReferenceIds;
                if (r8 != null) {
                    barrier2.setReferencedIds(r8);
                } else {
                    String str3 = layout2.mReferenceIdString;
                    if (str3 != null) {
                        int[] convertReferenceString2 = convertReferenceString(barrier2, str3);
                        layout2.mReferenceIds = convertReferenceString2;
                        barrier2.setReferencedIds(convertReferenceString2);
                    }
                }
                barrier2.setType(layout2.mBarrierDirection);
                barrier2.setMargin(layout2.mBarrierMargin);
                int r82 = ConstraintLayout.$r8$clinit;
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(layoutParams2);
                constraintLayout.addView(barrier2, layoutParams2);
            }
            if (layout2.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                int r1 = ConstraintLayout.$r8$clinit;
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams();
                constraint2.applyTo(layoutParams3);
                constraintLayout.addView(guideline, layoutParams3);
            }
        }
    }

    public final void clone(ConstraintLayout constraintLayout) {
        int r16;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, Constraint> hashMap = constraintSet.mConstraints;
        hashMap.clear();
        int r5 = 0;
        while (r5 < childCount) {
            View childAt = constraintLayout.getChildAt(r5);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (constraintSet.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = hashMap.get(Integer.valueOf(id));
            HashMap<String, ConstraintAttribute> hashMap2 = constraintSet.mSavedAttributes;
            HashMap<String, ConstraintAttribute> hashMap3 = new HashMap<>();
            Class<?> cls = childAt.getClass();
            for (String str : hashMap2.keySet()) {
                ConstraintAttribute constraintAttribute = hashMap2.get(str);
                try {
                } catch (IllegalAccessException e) {
                    e = e;
                    r16 = childCount;
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    r16 = childCount;
                } catch (InvocationTargetException e3) {
                    e = e3;
                    r16 = childCount;
                }
                if (str.equals("BackgroundColor")) {
                    hashMap3.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                } else {
                    r16 = childCount;
                    try {
                        hashMap3.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        e.printStackTrace();
                        childCount = r16;
                    } catch (NoSuchMethodException e5) {
                        e = e5;
                        e.printStackTrace();
                        childCount = r16;
                    } catch (InvocationTargetException e6) {
                        e = e6;
                        e.printStackTrace();
                        childCount = r16;
                    }
                    childCount = r16;
                }
            }
            int r162 = childCount;
            constraint.mCustomConstraints = hashMap3;
            constraint.fillFrom(id, layoutParams);
            int visibility = childAt.getVisibility();
            PropertySet propertySet = constraint.propertySet;
            propertySet.visibility = visibility;
            propertySet.alpha = childAt.getAlpha();
            float rotation = childAt.getRotation();
            Transform transform = constraint.transform;
            transform.rotation = rotation;
            transform.rotationX = childAt.getRotationX();
            transform.rotationY = childAt.getRotationY();
            transform.scaleX = childAt.getScaleX();
            transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                transform.transformPivotX = pivotX;
                transform.transformPivotY = pivotY;
            }
            transform.translationX = childAt.getTranslationX();
            transform.translationY = childAt.getTranslationY();
            transform.translationZ = childAt.getTranslationZ();
            if (transform.applyElevation) {
                transform.elevation = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                boolean z = barrier.mBarrier.mAllowsGoneWidget;
                Layout layout = constraint.layout;
                layout.mBarrierAllowsGoneWidgets = z;
                layout.mReferenceIds = barrier.getReferencedIds();
                layout.mBarrierDirection = barrier.getType();
                layout.mBarrierMargin = barrier.getMargin();
            }
            r5++;
            constraintSet = this;
            childCount = r162;
        }
    }

    public final void load(Context context, int r6) {
        XmlResourceParser xml = context.getResources().getXml(r6);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            fillFromAttributeList.layout.mIsGuideline = true;
                        }
                        this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
