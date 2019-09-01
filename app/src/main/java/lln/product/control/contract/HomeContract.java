package lln.product.control.contract;

import java.util.List;

import lln.product.control.model.TroppoItem;

public interface HomeContract {

    interface View {

        void setTroppoItem(List<TroppoItem> troppoItems);

        void configScroll();
    }

    interface Presenter {

        void setTroppoItem();

        void onSuccessAddItem(List<TroppoItem> troppoItems);

        void onErrorItem();

    }

    interface Interactor {

        void setTroppoItem();

    }
}
