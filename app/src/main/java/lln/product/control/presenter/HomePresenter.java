package lln.product.control.presenter;

import java.util.List;

import lln.product.control.contract.HomeContract;
import lln.product.control.interactor.HomeInteractor;
import lln.product.control.model.TroppoItem;
import lln.product.control.view.HomeActivity;

public class HomePresenter implements HomeContract.Presenter {

    private HomeActivity activity;
    private HomeInteractor interactor;

    public HomePresenter(HomeActivity activity) {
        this.activity = activity;
        interactor = new HomeInteractor(this);
    }

    @Override
    public void setTroppoItem() {
        interactor.setTroppoItem();
    }

    @Override
    public void onSuccessAddItem(List<TroppoItem> troppoItems) {
        activity.setTroppoItem(troppoItems);
    }

    @Override
    public void onErrorItem() {

    }
}
