package lln.product.control.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.Arrays;
import java.util.List;

import lln.product.control.R;
import lln.product.control.custom.TroppoView;
import lln.product.control.model.TroppoItem;
import lln.product.control.utils.TroppoType;
import lln.product.control.view.adapter.HomeAdapter;

public class HomeActivity extends AppCompatActivity implements
        DiscreteScrollView.ScrollStateChangeListener<HomeAdapter.HomeHolder>,
        DiscreteScrollView.OnItemChangedListener<HomeAdapter.HomeHolder>,
        View.OnClickListener {

    private TroppoView troppoView;
    private List<TroppoItem> troppoItem;
    private DiscreteScrollView troppoScroll;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewById();

        troppoView = new TroppoView(this);
        troppoItem = getTroppoItem();

        for (int i = 0; i < getTroppoItem().size(); i++) {
            troppoView.setItem(troppoItem.get(i));
        }

        troppoView.setItem(troppoItem.get(getPosition()));

        troppoScroll.setSlideOnFling(true);
        troppoScroll.setAdapter(new HomeAdapter(troppoItem));
        troppoScroll.addOnItemChangedListener(this);
        troppoScroll.addScrollStateChangeListener(this);
        troppoScroll.scrollToPosition(2);
        troppoScroll.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.8f).build());
    }

    private void viewById() {
        troppoView = (TroppoView) findViewById(R.id.troppoView);
        troppoScroll = (DiscreteScrollView) findViewById(R.id.troppoScroll);
    }

    private List<TroppoItem> getTroppoItem() {
        return Arrays.asList(
                new TroppoItem("Title 1", R.drawable.ic_launcher_foreground, TroppoType.JELLY_1),
                new TroppoItem("Title 1", R.drawable.ic_add, TroppoType.JELLY_1),
                new TroppoItem("Title 1", R.drawable.ic_launcher_background, TroppoType.JELLY_1),
                new TroppoItem("Title 1", R.drawable.ic_remove, TroppoType.JELLY_1)
        );
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCurrentItemChanged(@Nullable HomeAdapter.HomeHolder homeHolder, int i) {
        if (homeHolder != null) {
            troppoView.setItem(troppoItem.get(i));
            setPosition(i);
        }
    }

    @Override
    public void onScrollStart(@NonNull HomeAdapter.HomeHolder homeHolder, int i) {

    }

    @Override
    public void onScrollEnd(@NonNull HomeAdapter.HomeHolder homeHolder, int i) {

    }

    @Override
    public void onScroll(float position, int currentIndex, int newIndex, @Nullable HomeAdapter.HomeHolder homeHolder, @Nullable HomeAdapter.HomeHolder t1) {
        TroppoItem current = troppoItem.get(currentIndex);
        if (newIndex >= 0 && newIndex < troppoScroll.getAdapter().getItemCount()) {
            TroppoItem next = troppoItem.get(newIndex);
            troppoView.onScroll(1f - Math.abs(position), current, next);
        }
    }
}
