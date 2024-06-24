package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.NestedScrollView;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class AlertDialog extends AppCompatDialog implements DialogInterface {
    public final AlertController mAlert;

    /* loaded from: classes.dex */
    public static class Builder {
        public final AlertController.AlertParams P;
        public final int mTheme;

        public Builder(Context context) {
            int resolveDialogTheme = AlertDialog.resolveDialogTheme(context, 0);
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, resolveDialogTheme)));
            this.mTheme = resolveDialogTheme;
        }

        public final AlertDialog create() {
            int r6;
            AlertController.AlertParams alertParams = this.P;
            AlertDialog alertDialog = new AlertDialog(alertParams.mContext, this.mTheme);
            View view = alertParams.mCustomTitleView;
            AlertController alertController = alertDialog.mAlert;
            if (view != null) {
                alertController.mCustomTitleView = view;
            } else {
                CharSequence charSequence = alertParams.mTitle;
                if (charSequence != null) {
                    alertController.mTitle = charSequence;
                    TextView textView = alertController.mTitleView;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = alertParams.mIcon;
                if (drawable != null) {
                    alertController.mIcon = drawable;
                    alertController.mIconId = 0;
                    ImageView imageView = alertController.mIconView;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.mIconView.setImageDrawable(drawable);
                    }
                }
            }
            if (alertParams.mAdapter != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
                if (alertParams.mIsSingleChoice) {
                    r6 = alertController.mSingleChoiceItemLayout;
                } else {
                    r6 = alertController.mListItemLayout;
                }
                ListAdapter listAdapter = alertParams.mAdapter;
                if (listAdapter == null) {
                    listAdapter = new AlertController.CheckedItemAdapter(alertParams.mContext, r6);
                }
                alertController.mAdapter = listAdapter;
                alertController.mCheckedItem = alertParams.mCheckedItem;
                if (alertParams.mOnClickListener != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                        public final /* synthetic */ AlertController val$dialog;

                        public AnonymousClass3(AlertController alertController2) {
                            r2 = alertController2;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int r3, long j) {
                            AlertParams alertParams2 = AlertParams.this;
                            DialogInterface.OnClickListener onClickListener = alertParams2.mOnClickListener;
                            AlertController alertController2 = r2;
                            onClickListener.onClick(alertController2.mDialog, r3);
                            if (!alertParams2.mIsSingleChoice) {
                                alertController2.mDialog.dismiss();
                            }
                        }
                    });
                }
                if (alertParams.mIsSingleChoice) {
                    recycleListView.setChoiceMode(1);
                }
                alertController2.mListView = recycleListView;
            }
            alertDialog.setCancelable(true);
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = alertParams.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }
    }

    public AlertDialog(Context context, int r3) {
        super(context, resolveDialogTheme(context, r3));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public static int resolveDialogTheme(Context context, int r3) {
        if (((r3 >>> 24) & 255) >= 1) {
            return r3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int r12;
        boolean z;
        boolean z2;
        boolean z3;
        int r7;
        boolean z4;
        ListAdapter listAdapter;
        int r11;
        int r14;
        View view;
        View findViewById;
        super.onCreate(bundle);
        AlertController alertController = this.mAlert;
        alertController.mDialog.setContentView(alertController.mAlertDialogLayout);
        Window window = alertController.mWindow;
        View findViewById2 = window.findViewById(R.id.parentPanel);
        View findViewById3 = findViewById2.findViewById(R.id.topPanel);
        View findViewById4 = findViewById2.findViewById(R.id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        window.setFlags(131072, 131072);
        viewGroup.setVisibility(8);
        View findViewById6 = viewGroup.findViewById(R.id.topPanel);
        View findViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup resolvePanel = AlertController.resolvePanel(findViewById6, findViewById3);
        ViewGroup resolvePanel2 = AlertController.resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel3 = AlertController.resolvePanel(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        alertController.mScrollView = nestedScrollView;
        int r8 = 0;
        nestedScrollView.setFocusable(false);
        alertController.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) resolvePanel2.findViewById(android.R.id.message);
        alertController.mMessageView = textView;
        if (textView != null) {
            textView.setVisibility(8);
            alertController.mScrollView.removeView(alertController.mMessageView);
            if (alertController.mListView != null) {
                ViewGroup viewGroup2 = (ViewGroup) alertController.mScrollView.getParent();
                int indexOfChild = viewGroup2.indexOfChild(alertController.mScrollView);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(alertController.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                resolvePanel2.setVisibility(8);
            }
        }
        Button button = (Button) resolvePanel3.findViewById(android.R.id.button1);
        alertController.mButtonPositive = button;
        AlertController.AnonymousClass1 anonymousClass1 = alertController.mButtonHandler;
        button.setOnClickListener(anonymousClass1);
        if (TextUtils.isEmpty(null)) {
            alertController.mButtonPositive.setVisibility(8);
            r12 = 0;
        } else {
            alertController.mButtonPositive.setText((CharSequence) null);
            alertController.mButtonPositive.setVisibility(0);
            r12 = 1;
        }
        Button button2 = (Button) resolvePanel3.findViewById(android.R.id.button2);
        alertController.mButtonNegative = button2;
        button2.setOnClickListener(anonymousClass1);
        if (TextUtils.isEmpty(null)) {
            alertController.mButtonNegative.setVisibility(8);
        } else {
            alertController.mButtonNegative.setText((CharSequence) null);
            alertController.mButtonNegative.setVisibility(0);
            r12 |= 2;
        }
        Button button3 = (Button) resolvePanel3.findViewById(android.R.id.button3);
        alertController.mButtonNeutral = button3;
        button3.setOnClickListener(anonymousClass1);
        if (TextUtils.isEmpty(null)) {
            alertController.mButtonNeutral.setVisibility(8);
        } else {
            alertController.mButtonNeutral.setText((CharSequence) null);
            alertController.mButtonNeutral.setVisibility(0);
            r12 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        alertController.mContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r12 == 1) {
                AlertController.centerButton(alertController.mButtonPositive);
            } else if (r12 == 2) {
                AlertController.centerButton(alertController.mButtonNegative);
            } else if (r12 == 4) {
                AlertController.centerButton(alertController.mButtonNeutral);
            }
        }
        if (r12 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            resolvePanel3.setVisibility(8);
        }
        if (alertController.mCustomTitleView != null) {
            resolvePanel.addView(alertController.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            alertController.mIconView = (ImageView) window.findViewById(android.R.id.icon);
            if ((!TextUtils.isEmpty(alertController.mTitle)) && alertController.mShowTitle) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                alertController.mTitleView = textView2;
                textView2.setText(alertController.mTitle);
                int r112 = alertController.mIconId;
                if (r112 != 0) {
                    alertController.mIconView.setImageResource(r112);
                } else {
                    Drawable drawable = alertController.mIcon;
                    if (drawable != null) {
                        alertController.mIconView.setImageDrawable(drawable);
                    } else {
                        alertController.mTitleView.setPadding(alertController.mIconView.getPaddingLeft(), alertController.mIconView.getPaddingTop(), alertController.mIconView.getPaddingRight(), alertController.mIconView.getPaddingBottom());
                        alertController.mIconView.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                alertController.mIconView.setVisibility(8);
                resolvePanel.setVisibility(8);
            }
        }
        if (viewGroup.getVisibility() != 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (resolvePanel != null && resolvePanel.getVisibility() != 8) {
            r7 = 1;
        } else {
            r7 = 0;
        }
        if (resolvePanel3.getVisibility() != 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && (findViewById = resolvePanel2.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (r7 != 0) {
            NestedScrollView nestedScrollView2 = alertController.mScrollView;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (alertController.mListView != null) {
                view = resolvePanel.findViewById(R.id.titleDividerNoCustom);
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View findViewById9 = resolvePanel2.findViewById(R.id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.mListView;
        if (recycleListView instanceof AlertController.RecycleListView) {
            recycleListView.getClass();
            if (!z4 || r7 == 0) {
                int paddingLeft = recycleListView.getPaddingLeft();
                if (r7 != 0) {
                    r11 = recycleListView.getPaddingTop();
                } else {
                    r11 = recycleListView.mPaddingTopNoTitle;
                }
                int paddingRight = recycleListView.getPaddingRight();
                if (z4) {
                    r14 = recycleListView.getPaddingBottom();
                } else {
                    r14 = recycleListView.mPaddingBottomNoButtons;
                }
                recycleListView.setPadding(paddingLeft, r11, paddingRight, r14);
            }
        }
        if (!z3) {
            View view2 = alertController.mListView;
            if (view2 == null) {
                view2 = alertController.mScrollView;
            }
            if (view2 != null) {
                if (z4) {
                    r8 = 2;
                }
                int r4 = r7 | r8;
                View findViewById10 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById11 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api23Impl.setScrollIndicators(view2, r4, 3);
                if (findViewById10 != null) {
                    resolvePanel2.removeView(findViewById10);
                }
                if (findViewById11 != null) {
                    resolvePanel2.removeView(findViewById11);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.mListView;
        if (recycleListView2 != null && (listAdapter = alertController.mAdapter) != null) {
            recycleListView2.setAdapter(listAdapter);
            int r1 = alertController.mCheckedItem;
            if (r1 > -1) {
                recycleListView2.setItemChecked(r1, true);
                recycleListView2.setSelection(r1);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r3, KeyEvent keyEvent) {
        boolean z;
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(r3, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r3, KeyEvent keyEvent) {
        boolean z;
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(r3, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.mAlert;
        alertController.mTitle = charSequence;
        TextView textView = alertController.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
