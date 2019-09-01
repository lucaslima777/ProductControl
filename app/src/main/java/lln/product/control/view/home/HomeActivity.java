package lln.product.control.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

import lln.product.control.R;
import lln.product.control.contract.HomeContract;
import lln.product.control.custom.TroppoView;
import lln.product.control.model.TroppoItem;
import lln.product.control.presenter.HomePresenter;
import lln.product.control.view.home.adapter.HomeAdapter;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    private TroppoView troppoView;
    private List<TroppoItem> troppoItem;
    private DiscreteScrollView troppoScroll;
    private int position;

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewById();

        presenter = new HomePresenter(this);
        presenter.setTroppoItem();

        setTroppoView();
        configScroll();
    }

    private void viewById() {
        troppoView = (TroppoView) findViewById(R.id.troppoView);
        troppoScroll = (DiscreteScrollView) findViewById(R.id.troppoScroll);
    }

    @Override
    public void setTroppoItem(List<TroppoItem> troppoItems) {
        troppoItem = troppoItems;
    }

    private void setTroppoView() {
        for (int i = 0; i < troppoItem.size(); i++) {
            troppoView.setItem(troppoItem.get(i));
        }
        troppoView.setItem(troppoItem.get(getPositionItem()));
    }

    @Override
    public void configScroll() {
        troppoScroll.setSlideOnFling(true);
        troppoScroll.setAdapter(new HomeAdapter(troppoItem));
        troppoScroll.addOnItemChangedListener(new ScrollListener());
        troppoScroll.addScrollStateChangeListener(new ScrollListener());
        troppoScroll.scrollToPosition(2);
        troppoScroll.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.8f).build());
    }

    private class ScrollListener implements
            DiscreteScrollView.ScrollStateChangeListener<HomeAdapter.HomeHolder>,
            DiscreteScrollView.OnItemChangedListener<HomeAdapter.HomeHolder> {

        @Override
        public void onCurrentItemChanged(@Nullable HomeAdapter.HomeHolder homeHolder, int position) {
            if (homeHolder != null) {
                troppoView.setItem(troppoItem.get(position));
                setPositionItem(position);
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

    private int getPositionItem() {
        return position;
    }

    private void setPositionItem(int position) {
        this.position = position;
    }
}
