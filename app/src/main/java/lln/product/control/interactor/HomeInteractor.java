package lln.product.control.interactor;

import java.util.Arrays;
import java.util.List;

import lln.product.control.R;
import lln.product.control.contract.HomeContract;
import lln.product.control.model.TroppoItem;
import lln.product.control.presenter.HomePresenter;
import lln.product.control.utils.TroppoType;

public class HomeInteractor implements HomeContract.Interactor {

    private HomePresenter presenter;
    private List<TroppoItem> troppoItems;

    public HomeInteractor(HomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setTroppoItem() {

        troppoItems = Arrays.asList(
                new TroppoItem("Amber", R.drawable.ic_jam_amber, TroppoType.JELLY_BLUE),
                new TroppoItem("Strawberry", R.drawable.ic_jam_strawberry, TroppoType.JELLY_GREEN),
                new TroppoItem("Banana", R.drawable.ic_jam_banana, TroppoType.JELLY_GREY),
                new TroppoItem("Limao", R.drawable.ic_jam_green, TroppoType.JELLY_ORANGE),
                new TroppoItem("Yellow", R.drawable.ic_jam_yellow, TroppoType.JELLY_PINK),
                new TroppoItem("Uva", R.drawable.ic_jam_grape, TroppoType.JELLY_PURPLE),
                new TroppoItem("Laranja", R.drawable.ic_jam_orange, TroppoType.JELLY_RED),
                new TroppoItem("Blue", R.drawable.ic_jam_blue, TroppoType.JELLY_YELLOW),
                new TroppoItem("Brown", R.drawable.ic_jam_brown, TroppoType.JELLY_AMBER)
        );

        presenter.onSuccessAddItem(troppoItems);

    }
}
