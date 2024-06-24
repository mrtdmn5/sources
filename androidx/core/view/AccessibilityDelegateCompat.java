package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    public static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    public final AccessibilityDelegateAdapter mBridge;
    public final View.AccessibilityDelegate mOriginalDelegate;

    /* loaded from: classes.dex */
    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.mCompat = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.mProvider;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z;
            Object tag;
            boolean z2;
            boolean z3;
            Object tag2;
            boolean z4;
            boolean z5;
            Object tag3;
            Object tag4;
            int r12;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            boolean z6 = true;
            int r6 = 0;
            if (Build.VERSION.SDK_INT >= 28) {
                z = true;
            } else {
                z = false;
            }
            ClickableSpan[] clickableSpanArr = null;
            if (z) {
                tag = Boolean.valueOf(ViewCompat.Api28Impl.isScreenReaderFocusable(view));
            } else {
                tag = view.getTag(R.id.tag_screen_reader_focusable);
                if (!Boolean.class.isInstance(tag)) {
                    tag = null;
                }
            }
            Boolean bool = (Boolean) tag;
            if (bool != null && bool.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
            int r9 = Build.VERSION.SDK_INT;
            if (r9 >= 28) {
                accessibilityNodeInfo.setScreenReaderFocusable(z2);
            } else {
                accessibilityNodeInfoCompat.setBooleanProperty(1, z2);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                tag2 = Boolean.valueOf(ViewCompat.Api28Impl.isAccessibilityHeading(view));
            } else {
                tag2 = view.getTag(R.id.tag_accessibility_heading);
                if (!Boolean.class.isInstance(tag2)) {
                    tag2 = null;
                }
            }
            Boolean bool2 = (Boolean) tag2;
            if (bool2 != null && bool2.booleanValue()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (r9 >= 28) {
                accessibilityNodeInfo.setHeading(z4);
            } else {
                accessibilityNodeInfoCompat.setBooleanProperty(2, z4);
            }
            if (r9 >= 28) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                tag3 = ViewCompat.Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag3)) {
                    tag3 = null;
                }
            }
            CharSequence charSequence = (CharSequence) tag3;
            if (r9 >= 28) {
                accessibilityNodeInfo.setPaneTitle(charSequence);
            } else {
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
            }
            if (Build.VERSION.SDK_INT < 30) {
                z6 = false;
            }
            if (z6) {
                tag4 = ViewCompat.Api30Impl.getStateDescription(view);
            } else {
                tag4 = view.getTag(R.id.tag_state_description);
                if (!CharSequence.class.isInstance(tag4)) {
                    tag4 = null;
                }
            }
            CharSequence charSequence2 = (CharSequence) tag4;
            if (r9 >= 30) {
                AccessibilityNodeInfoCompat.Api30Impl.setStateDescription(accessibilityNodeInfo, charSequence2);
            } else {
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence2);
            }
            this.mCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            CharSequence text = accessibilityNodeInfo.getText();
            if (r9 < 26) {
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int r13 = 0; r13 < sparseArray.size(); r13++) {
                        if (((WeakReference) sparseArray.valueAt(r13)).get() == null) {
                            arrayList.add(Integer.valueOf(r13));
                        }
                    }
                    for (int r132 = 0; r132 < arrayList.size(); r132++) {
                        sparseArray.remove(((Integer) arrayList.get(r132)).intValue());
                    }
                }
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                }
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    AccessibilityNodeInfoCompat.Api19Impl.getExtras(accessibilityNodeInfoCompat.mInfo).putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                    }
                    int r1 = 0;
                    while (r1 < clickableSpanArr.length) {
                        ClickableSpan clickableSpan = clickableSpanArr[r1];
                        int r133 = r6;
                        while (true) {
                            if (r133 < sparseArray2.size()) {
                                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(r133)).get())) {
                                    r12 = sparseArray2.keyAt(r133);
                                    break;
                                }
                                r133++;
                            } else {
                                r12 = AccessibilityNodeInfoCompat.sClickableSpanId;
                                AccessibilityNodeInfoCompat.sClickableSpanId = r12 + 1;
                                break;
                            }
                        }
                        sparseArray2.put(r12, new WeakReference(clickableSpanArr[r1]));
                        ClickableSpan clickableSpan2 = clickableSpanArr[r1];
                        Spanned spanned = (Spanned) text;
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(r12));
                        r1++;
                        r6 = 0;
                    }
                }
            }
            List list = (List) view.getTag(R.id.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int r62 = 0; r62 < list.size(); r62++) {
                accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat) list.get(r62));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View view, int r3, Bundle bundle) {
            return this.mCompat.performAccessibilityAction(view, r3, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View view, int r3) {
            this.mCompat.sendAccessibilityEvent(view, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static AccessibilityNodeProvider getAccessibilityNodeProvider(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        public static boolean performAccessibilityAction(View.AccessibilityDelegate accessibilityDelegate, View view, int r2, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, r2, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = Api16Impl.getAccessibilityNodeProvider(this.mOriginalDelegate, view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int r7, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        ClickableSpan[] clickableSpanArr;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z3 = false;
        int r2 = 0;
        while (true) {
            if (r2 >= list.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) list.get(r2);
            if (accessibilityActionCompat.getId() == r7) {
                AccessibilityViewCommand accessibilityViewCommand = accessibilityActionCompat.mCommand;
                if (accessibilityViewCommand != null) {
                    Class<? extends AccessibilityViewCommand.CommandArguments> cls = accessibilityActionCompat.mViewCommandArgumentClass;
                    if (cls != null) {
                        try {
                            cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass();
                        } catch (Exception e) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e);
                        }
                    }
                    z = accessibilityViewCommand.perform(view);
                }
            } else {
                r2++;
            }
        }
        z = false;
        if (!z) {
            z = Api16Impl.performAccessibilityAction(this.mOriginalDelegate, view, r7, bundle);
        }
        if (!z && r7 == R.id.accessibility_action_clickable_span && bundle != null) {
            int r72 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(r72)) != null) {
                ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
                if (clickableSpan != null) {
                    CharSequence text = view.createAccessibilityNodeInfo().getText();
                    if (text instanceof Spanned) {
                        clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                    } else {
                        clickableSpanArr = null;
                    }
                    for (int r22 = 0; clickableSpanArr != null && r22 < clickableSpanArr.length; r22++) {
                        if (clickableSpan.equals(clickableSpanArr[r22])) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    clickableSpan.onClick(view);
                    z3 = true;
                }
            }
            return z3;
        }
        return z;
    }

    public void sendAccessibilityEvent(View view, int r3) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, r3);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
