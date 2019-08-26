package lln.product.control.view.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import lln.product.control.R;
import lln.product.control.model.TroppoItem;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    private RecyclerView parentRecycler;
    private List<TroppoItem> troppoItemList;

    public HomeAdapter(List<TroppoItem> troppoItemList) {
        this.troppoItemList = troppoItemList;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        parentRecycler = recyclerView;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_troppo_scrool, parent, false);
        return new HomeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        int iconTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.grey_400);
        TroppoItem troppoItem = troppoItemList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(troppoItem.getImage())
                .listener(new TintOnLoad(holder.imageJellyScrool, iconTint) {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.imageJellyScrool);
    }

    @Override
    public int getItemCount() {
        return troppoItemList.size();
    }

    public class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageJellyScrool;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            imageJellyScrool = (ImageView) itemView.findViewById(R.id.jelly_image);

            itemView.findViewById(R.id.container).setOnClickListener(this);
            itemView.setBackgroundColor(Color.TRANSPARENT);
        }

        @Override
        public void onClick(View view) {
            parentRecycler.smoothScrollToPosition(getAdapterPosition());
        }
    }

    private static abstract class TintOnLoad implements RequestListener<Drawable> {

        private ImageView imageView;
        private int tintColor;

        public TintOnLoad(ImageView view, int tintColor) {
            this.imageView = view;
            this.tintColor = tintColor;
        }


        public boolean onException(Exception e, Integer model, Target<Drawable> target, boolean isFirstResource) {
            return false;
        }


        public boolean onResourceReady(Drawable resource, Integer model, Target<Drawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            imageView.setColorFilter(tintColor);
            return false;
        }
    }

}
