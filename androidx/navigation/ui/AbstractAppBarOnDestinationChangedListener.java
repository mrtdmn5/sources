package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    public ObjectAnimator mAnimator;
    public DrawerArrowDrawable mArrowDrawable;
    public final Context mContext;
    public final WeakReference<Openable> mOpenableLayoutWeakReference = null;
    public final Set<Integer> mTopLevelDestinations;

    public AbstractAppBarOnDestinationChangedListener(Context context, AppBarConfiguration appBarConfiguration) {
        this.mContext = context;
        this.mTopLevelDestinations = appBarConfiguration.mTopLevelDestinations;
    }
}
