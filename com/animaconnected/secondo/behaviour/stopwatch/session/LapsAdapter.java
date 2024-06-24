package com.animaconnected.secondo.behaviour.stopwatch.session;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.stopwatch.DurationFormatter;
import com.animaconnected.secondo.provider.stopwatch.Lap;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LapsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context mContext;
    private List<Lap> mLaps = new ArrayList();

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mLap;
        public TextView mTime;

        public ViewHolder(View view) {
            super(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColor(int r2) {
            this.mLap.setTextColor(r2);
            this.mTime.setTextColor(r2);
        }

        public void findChilds() {
            this.mLap = (TextView) this.itemView.findViewById(R.id.lap_text);
            this.mTime = (TextView) this.itemView.findViewById(R.id.lap_time_text);
        }
    }

    public LapsAdapter(Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mLaps.size();
    }

    public void setLaps(List<Lap> list) {
        this.mLaps = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int r6) {
        Lap lap = this.mLaps.get(r6);
        viewHolder.mLap.setText(KronabyApplication.getContext().getResources().getString(R.string.stopwatch_lap_amount, String.valueOf(lap.mLap)));
        viewHolder.mTime.setText(DurationFormatter.millisecondsToString(lap.mLapTimeInMilliseconds));
        if (lap.mBest) {
            viewHolder.setColor(ThemeProviderBase.getColor(this.mContext, R.attr.detailStopwatchBestTimeColor));
        } else if (lap.mWorst) {
            viewHolder.setColor(ThemeProviderBase.getColor(this.mContext, R.attr.detailStopwatchWorstTimeColor));
        } else {
            viewHolder.setColor(ThemeProviderBase.getColor(this.mContext, R.attr.detailStopwatchNormalTimeColor));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r4) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_stopwatch_lap, viewGroup, false));
        viewHolder.findChilds();
        return viewHolder;
    }
}
