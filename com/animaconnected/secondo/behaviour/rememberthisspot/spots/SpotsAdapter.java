package com.animaconnected.secondo.behaviour.rememberthisspot.spots;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.location.Spot;
import com.kronaby.watch.app.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes3.dex */
public class SpotsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int NBR_OF_HEADERS = 1;
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final int UNKNOWN_SPOT = -1;
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_SPOT = 1;
    private static final DateFormat sDateFormatter = new SimpleDateFormat("dd MMM yyyy", ProviderFactory.createConfigProvider().getTranslationCompatibleLocale());
    private static final DateFormat sNearTimeDateFormatter = new SimpleDateFormat("HH:mm", ProviderFactory.createConfigProvider().getTranslationCompatibleLocale());
    private boolean mIsAssignedToSlot;
    private boolean mIsInEditMode;
    private OnSpotClickedListener mOnSpotClickedListener;
    private List<Spot> mSpots = new ArrayList();
    private final InputMethodManager mInputMethodManager = (InputMethodManager) KronabyApplication.getContext().getSystemService("input_method");
    private final Calendar mCalendarToday = Calendar.getInstance();
    private int mCurrentRenameIndex = -1;

    /* loaded from: classes3.dex */
    public interface OnSpotClickedListener {
        void onSpotDeletedClick(int r1);

        void onSpotLongClick();

        void onSpotSaveClick(int r1, int r2);

        void onSpotSelectedClick(int r1);
    }

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mAddress;
        public ImageView mClearSpot;
        public TextView mDescriptonText;
        public EditText mEditName;
        public TextView mName;
        public ImageView mRenameSpot;
        public TextView mSpotTime;

        public ViewHolder(View view) {
            super(view);
        }

        public void findChilds() {
            this.mName = (TextView) this.itemView.findViewById(R.id.spot_custom_name);
            this.mAddress = (TextView) this.itemView.findViewById(R.id.spot_address);
            this.mSpotTime = (TextView) this.itemView.findViewById(R.id.spot_time);
            this.mClearSpot = (ImageView) this.itemView.findViewById(R.id.spot_clear);
            this.mRenameSpot = (ImageView) this.itemView.findViewById(R.id.spot_rename);
            this.mEditName = (EditText) this.itemView.findViewById(R.id.spot_edit);
        }

        public void findHeadChilds() {
            this.mDescriptonText = (TextView) this.itemView.findViewById(R.id.description_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateViewHolder$0(TextView textView, int r3, KeyEvent keyEvent) {
        if (r3 != 6) {
            return false;
        }
        saveCurrentRenameSpot();
        this.mCurrentRenameIndex = -1;
        toggleSoftKeyboard(textView, false);
        notifyItemRangeChanged(1, this.mSpots.size());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateViewHolder$1(ViewHolder viewHolder, View view) {
        if (!this.mIsInEditMode) {
            this.mIsInEditMode = true;
            this.mCurrentRenameIndex = viewHolder.getBindingAdapterPosition();
            notifyItemRangeChanged(1, this.mSpots.size());
            this.mOnSpotClickedListener.onSpotLongClick();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$2(ViewHolder viewHolder, View view) {
        int bindingAdapterPosition;
        if (this.mOnSpotClickedListener != null && (bindingAdapterPosition = viewHolder.getBindingAdapterPosition()) != -1) {
            if (this.mIsInEditMode) {
                if (view == viewHolder.mClearSpot) {
                    this.mOnSpotClickedListener.onSpotDeletedClick(bindingAdapterPosition - 1);
                    return;
                }
                if (view == viewHolder.mRenameSpot) {
                    saveCurrentRenameSpot();
                    if (this.mCurrentRenameIndex == bindingAdapterPosition) {
                        toggleSoftKeyboard(view, false);
                        this.mCurrentRenameIndex = -1;
                    } else {
                        this.mCurrentRenameIndex = bindingAdapterPosition;
                    }
                    notifyItemRangeChanged(1, this.mSpots.size());
                    return;
                }
                return;
            }
            this.mOnSpotClickedListener.onSpotSelectedClick(bindingAdapterPosition - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleSoftKeyboard$3(View view) {
        this.mInputMethodManager.showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleSoftKeyboard$4(View view, View view2, boolean z) {
        if (!z) {
            this.mInputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void saveCurrentRenameSpot() {
        int r0 = this.mCurrentRenameIndex;
        if (r0 != -1) {
            this.mOnSpotClickedListener.onSpotSaveClick(r0 - 1, r0);
        }
    }

    private void toggleSoftKeyboard(final View view, boolean z) {
        if (z) {
            view.requestFocus();
            view.postDelayed(new Runnable() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SpotsAdapter.this.lambda$toggleSoftKeyboard$3(view);
                }
            }, 50L);
            view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z2) {
                    SpotsAdapter.this.lambda$toggleSoftKeyboard$4(view, view2, z2);
                }
            });
            return;
        }
        this.mInputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mSpots.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        if (r1 == 0) {
            return 0;
        }
        return 1;
    }

    public int getSpotsCount() {
        return this.mSpots.size();
    }

    public boolean isInEditMode() {
        return this.mIsInEditMode;
    }

    public void onSpotAdded(int r4, List<Spot> list) {
        this.mSpots = list;
        int r0 = this.mCurrentRenameIndex;
        if (r0 != -1 && r0 >= r4 + 1) {
            this.mCurrentRenameIndex = r0 + 1;
        }
        if (list.size() == 1) {
            notifyItemChanged(0);
        }
        notifyItemInserted(r4 + 1);
    }

    public void onSpotNameUpdated(int r1, List<Spot> list) {
        this.mSpots = list;
        notifyItemChanged(r1);
    }

    public void onSpotRemoved(int r4, List<Spot> list) {
        this.mSpots = list;
        int r0 = this.mCurrentRenameIndex;
        if (r0 != -1 && r0 > r4 + 1) {
            this.mCurrentRenameIndex = r0 - 1;
        } else if (r0 == r4 + 1) {
            this.mCurrentRenameIndex = -1;
        }
        if (list.isEmpty()) {
            notifyItemChanged(0);
        }
        notifyItemRemoved(r4 + 1);
    }

    public void setAssignedToSlot(boolean z) {
        this.mIsAssignedToSlot = z;
    }

    public void setInEditMode(boolean z, View view) {
        boolean z2;
        if (z != this.mIsInEditMode) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.mIsInEditMode = z;
            if (!z) {
                saveCurrentRenameSpot();
                this.mCurrentRenameIndex = -1;
                toggleSoftKeyboard(view, false);
            }
            notifyItemRangeChanged(1, this.mSpots.size());
        }
    }

    public void setOnSpotsListener(OnSpotClickedListener onSpotClickedListener) {
        this.mOnSpotClickedListener = onSpotClickedListener;
    }

    public void setSpots(List<Spot> list) {
        this.mSpots = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int r7) {
        DateFormat dateFormat;
        if (r7 > 0) {
            Spot spot = this.mSpots.get(r7 - 1);
            String str = spot.name;
            if (str != null && !str.equals(spot.addressLine)) {
                viewHolder.mName.setText(spot.name);
                viewHolder.mEditName.setText(spot.name);
                viewHolder.mAddress.setVisibility(0);
            } else if (this.mCurrentRenameIndex == r7) {
                String str2 = spot.name;
                if (str2 == null || (str2 != null && str2.equals(spot.addressLine))) {
                    viewHolder.mEditName.setText("");
                }
                viewHolder.mAddress.setVisibility(0);
            } else {
                viewHolder.mName.setText(spot.addressLine);
                viewHolder.mAddress.setVisibility(8);
            }
            viewHolder.mAddress.setText(spot.addressLine);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(spot.timeStamp);
            if (this.mCalendarToday.get(6) == calendar.get(6) && this.mCalendarToday.get(1) == calendar.get(1)) {
                dateFormat = sNearTimeDateFormatter;
            } else {
                dateFormat = sDateFormatter;
            }
            viewHolder.mSpotTime.setText(dateFormat.format(calendar.getTime()));
            if (this.mIsInEditMode) {
                if (this.mCurrentRenameIndex == r7) {
                    ImageView imageView = viewHolder.mRenameSpot;
                    imageView.setImageDrawable(imageView.getContext().getDrawable(R.drawable.ic_check));
                    viewHolder.mEditName.setVisibility(0);
                    viewHolder.mName.setVisibility(4);
                    toggleSoftKeyboard(viewHolder.mEditName, true);
                } else {
                    ImageView imageView2 = viewHolder.mRenameSpot;
                    imageView2.setImageDrawable(imageView2.getContext().getDrawable(R.drawable.ic_edit));
                    viewHolder.mEditName.setVisibility(4);
                    viewHolder.mName.setVisibility(0);
                }
                ImageView imageView3 = viewHolder.mClearSpot;
                imageView3.setImageDrawable(imageView3.getContext().getDrawable(R.drawable.ic_close));
                viewHolder.mRenameSpot.setVisibility(0);
                return;
            }
            ImageView imageView4 = viewHolder.mClearSpot;
            imageView4.setImageDrawable(imageView4.getContext().getDrawable(R.drawable.ic_navigate));
            viewHolder.mEditName.setVisibility(4);
            viewHolder.mName.setVisibility(0);
            viewHolder.mRenameSpot.setVisibility(4);
            return;
        }
        if (this.mSpots.isEmpty()) {
            viewHolder.mDescriptonText.setVisibility(0);
            if (this.mIsAssignedToSlot) {
                viewHolder.mDescriptonText.setText(R.string.remember_this_spot_details_no_locations_marble_set);
                return;
            } else {
                viewHolder.mDescriptonText.setText(R.string.remember_this_spot_details_no_locations);
                return;
            }
        }
        viewHolder.mDescriptonText.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r4) {
        if (r4 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_spot, viewGroup, false);
            final ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.findChilds();
            viewHolder.mEditName.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter$$ExternalSyntheticLambda0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int r3, KeyEvent keyEvent) {
                    boolean lambda$onCreateViewHolder$0;
                    lambda$onCreateViewHolder$0 = SpotsAdapter.this.lambda$onCreateViewHolder$0(textView, r3, keyEvent);
                    return lambda$onCreateViewHolder$0;
                }
            });
            inflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean lambda$onCreateViewHolder$1;
                    lambda$onCreateViewHolder$1 = SpotsAdapter.this.lambda$onCreateViewHolder$1(viewHolder, view);
                    return lambda$onCreateViewHolder$1;
                }
            });
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.spots.SpotsAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpotsAdapter.this.lambda$onCreateViewHolder$2(viewHolder, view);
                }
            };
            inflate.setOnClickListener(onClickListener);
            viewHolder.mClearSpot.setOnClickListener(onClickListener);
            viewHolder.mRenameSpot.setOnClickListener(onClickListener);
            return viewHolder;
        }
        ViewHolder viewHolder2 = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_spots_header, viewGroup, false));
        viewHolder2.findHeadChilds();
        return viewHolder2;
    }
}
