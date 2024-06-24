package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ConstraintLayoutStates {
    public final SparseArray<State> mStateList = new SparseArray<>();
    public final SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class State {
        public final int mConstraintID;
        public final int mId;
        public final ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlResourceParser xmlResourceParser) {
            this.mConstraintID = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r1 = 0; r1 < indexCount; r1++) {
                int index = obtainStyledAttributes.getIndex(r1);
                if (index == 0) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == 1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    this.mConstraintID = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        new ConstraintSet().clone((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Variant {
        public final int mConstraintID;
        public final float mMaxHeight;
        public final float mMaxWidth;
        public final float mMinHeight;
        public final float mMinWidth;

        public Variant(Context context, XmlResourceParser xmlResourceParser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r1 = 0; r1 < indexCount; r1++) {
                int index = obtainStyledAttributes.getIndex(r1);
                if (index == 0) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    this.mConstraintID = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        new ConstraintSet().clone((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                } else if (index == 1) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == 2) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == 3) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == 4) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public ConstraintLayoutStates(Context context, int r9) {
        char c;
        XmlResourceParser xml = context.getResources().getXml(r9);
        try {
            State state = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        if (c != 0 && c != 1) {
                            if (c != 2) {
                                if (c != 3) {
                                    if (c != 4) {
                                        Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                    } else {
                                        parseConstraintSet(context, xml);
                                    }
                                } else {
                                    Variant variant = new Variant(context, xml);
                                    if (state != null) {
                                        state.mVariants.add(variant);
                                    }
                                }
                            } else {
                                State state2 = new State(context, xml);
                                this.mStateList.put(state2.mId, state2);
                                state = state2;
                            }
                        }
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

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ce, code lost:            continue;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:42:0x00ea. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseConstraintSet(android.content.Context r13, android.content.res.XmlResourceParser r14) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.parseConstraintSet(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
