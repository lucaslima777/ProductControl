package lln.product.control.view.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.textfield.TextInputEditText;

import lln.product.control.R;

public class RegisterActivity extends AppCompatActivity {

    private AppCompatButton button;
    private TextInputEditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.btnJellyType);
        editName = findViewById(R.id.edit_input_add_name);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                makeDIalog(RegisterActivity.this, button);
            }
        });

    }

    @SuppressLint("RestrictedApi")
    public void makeDIalog(Context context, View view) {

        PopupMenu popupMenu = new PopupMenu(context, view);

        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {

            switch (item.getItemId()) {
                case R.id.jelly_blue:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_blue), null);
                    break;
                case R.id.jelly_amber:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_amber), null);
                    break;
                case R.id.jelly_brown:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_brown), null);
                    break;
                case R.id.jelly_green:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_green), null);
                    break;
                case R.id.jelly_grey:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_grey), null);
                    break;
                case R.id.jelly_orange:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_orange), null);
                    break;
                case R.id.jelly_pink:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_pink), null);
                    break;
                case R.id.jelly_purple:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_purple), null);
                    break;
                case R.id.jelly_red:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_red), null);
                    break;
                case R.id.jelly_yellow:
                    button.setCompoundDrawablesWithIntrinsicBounds(null,null, getResources().getDrawable(R.drawable.menu_ic_jam_yellow), null);
                    break;
            }
            return true;
        });

        MenuPopupHelper menuHelper = new MenuPopupHelper(context, (MenuBuilder) popupMenu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.setGravity(Gravity.END);
        menuHelper.show();
    }
}
