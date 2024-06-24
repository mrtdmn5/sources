package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import androidx.navigation.Navigator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Navigator.Name("activity")
/* loaded from: classes.dex */
public final class ActivityNavigator extends Navigator<Destination> {
    public final Context mContext;
    public final Activity mHostActivity;

    /* loaded from: classes.dex */
    public static class Destination extends NavDestination {
        public String mDataPattern;
        public Intent mIntent;

        @Override // androidx.navigation.NavDestination
        public final void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.ActivityNavigator);
            String string = obtainAttributes.getString(4);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setPackage(string);
            String string2 = obtainAttributes.getString(0);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                ComponentName componentName = new ComponentName(context, string2);
                if (this.mIntent == null) {
                    this.mIntent = new Intent();
                }
                this.mIntent.setComponent(componentName);
            }
            String string3 = obtainAttributes.getString(1);
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setAction(string3);
            String string4 = obtainAttributes.getString(2);
            if (string4 != null) {
                Uri parse = Uri.parse(string4);
                if (this.mIntent == null) {
                    this.mIntent = new Intent();
                }
                this.mIntent.setData(parse);
            }
            this.mDataPattern = obtainAttributes.getString(3);
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        public final String toString() {
            ComponentName component;
            Intent intent = this.mIntent;
            String str = null;
            if (intent == null) {
                component = null;
            } else {
                component = intent.getComponent();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                Intent intent2 = this.mIntent;
                if (intent2 != null) {
                    str = intent2.getAction();
                }
                if (str != null) {
                    sb.append(" action=");
                    sb.append(str);
                }
            }
            return sb.toString();
        }
    }

    public ActivityNavigator(Context context) {
        this.mContext = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.mHostActivity = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Override // androidx.navigation.Navigator
    public final Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        Intent intent;
        int intExtra;
        Destination destination = (Destination) navDestination;
        if (destination.mIntent != null) {
            Intent intent2 = new Intent(destination.mIntent);
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str = destination.mDataPattern;
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.mSingleTop) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.mHostActivity;
            if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.mId);
            Resources resources = context.getResources();
            if (navOptions != null) {
                int r7 = navOptions.mPopEnterAnim;
                int r8 = navOptions.mPopExitAnim;
                if ((r7 > 0 && resources.getResourceTypeName(r7).equals("animator")) || (r8 > 0 && resources.getResourceTypeName(r8).equals("animator"))) {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(r7) + " and popExit resource " + resources.getResourceName(r8) + "when launching " + destination);
                } else {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", r7);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", r8);
                }
            }
            context.startActivity(intent2);
            if (navOptions != null && activity != null) {
                int r13 = navOptions.mEnterAnim;
                int r14 = navOptions.mExitAnim;
                if ((r13 > 0 && resources.getResourceTypeName(r13).equals("animator")) || (r14 > 0 && resources.getResourceTypeName(r14).equals("animator"))) {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(r13) + " and exit resource " + resources.getResourceName(r14) + "when launching " + destination);
                    return null;
                }
                if (r13 >= 0 || r14 >= 0) {
                    activity.overridePendingTransition(Math.max(r13, 0), Math.max(r14, 0));
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new IllegalStateException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("Destination "), destination.mId, " does not have an Intent set."));
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        Activity activity = this.mHostActivity;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }
}
