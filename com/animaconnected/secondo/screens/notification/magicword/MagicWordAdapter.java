package com.animaconnected.secondo.screens.notification.magicword;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MagicWordAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<KeyWord> mKeyWords = new ArrayList();
    private OnKeyWordClickedListener mOnKeyWordClickedListener;

    /* loaded from: classes3.dex */
    public interface OnKeyWordClickedListener {
        void onKeyWordDeletedClick(int r1);
    }

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mDeleteKeyWord;
        final TextView mKeyWord;

        public ViewHolder(View view) {
            super(view);
            this.mKeyWord = (TextView) this.itemView.findViewById(R.id.keyword_text);
            this.mDeleteKeyWord = (ImageView) this.itemView.findViewById(R.id.keyword_clear);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$0(ViewHolder viewHolder, View view) {
        int bindingAdapterPosition;
        if (this.mOnKeyWordClickedListener != null && (bindingAdapterPosition = viewHolder.getBindingAdapterPosition()) != -1) {
            this.mOnKeyWordClickedListener.onKeyWordDeletedClick(bindingAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mKeyWords.size();
    }

    public void onKeyWordAdded(int r1, List<KeyWord> list) {
        this.mKeyWords = list;
        notifyItemInserted(r1);
    }

    public void onKeyWordRemoved(int r1, List<KeyWord> list) {
        this.mKeyWords = list;
        if (list.isEmpty()) {
            notifyItemChanged(0);
        }
        notifyItemRemoved(r1);
    }

    public void setClickedListener(OnKeyWordClickedListener onKeyWordClickedListener) {
        this.mOnKeyWordClickedListener = onKeyWordClickedListener;
    }

    public void setKeyWords(List<KeyWord> list) {
        this.mKeyWords = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int r3) {
        viewHolder.mKeyWord.setText(this.mKeyWords.get(r3).keyword);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r4) {
        final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_key_word, viewGroup, false));
        viewHolder.mDeleteKeyWord.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.magicword.MagicWordAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicWordAdapter.this.lambda$onCreateViewHolder$0(viewHolder, view);
            }
        });
        return viewHolder;
    }
}
