package lln.product.control.custom;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ArrayRes;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import lln.product.control.R;
import lln.product.control.model.TroppoItem;
import lln.product.control.utils.TroppoType;

public class TroppoView extends LinearLayout {

    private Paint gradientPaint;
    private int[] actualGradient;
    private ArgbEvaluator evaluator;

    private TextView title;
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnRemove;
    private ImageView imgProduct;

    public TroppoView(Context context) {
        super(context);
    }

    {
        evaluator = new ArgbEvaluator();

        gradientPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setWillNotDraw(false);

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        inflate(getContext(), R.layout.activity_model_troppo, this);

        title = (TextView) findViewById(R.id.textView_title);
        btnAdd = (FloatingActionButton) findViewById(R.id.floatingAction_add);
        btnRemove = (FloatingActionButton) findViewById(R.id.floatingAction_remove);
        imgProduct = findViewById(R.id.imageView_item);
    }

    private void initGradient() {
        float centerX = getWidth() * 0.5f;
        Shader gradient = new LinearGradient(
                centerX, 0, centerX, getHeight(),
                actualGradient, null,
                Shader.TileMode.MIRROR);
        gradientPaint.setShader(gradient);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (actualGradient != null) {
            initGradient();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), gradientPaint);
        super.onDraw(canvas);
    }

    public void setItem(TroppoItem item) {
        TroppoType jellyType = item.getJelly();
        actualGradient = jellyGradient(jellyType);

        if (getWidth() != 0 && getHeight() != 0) {
            initGradient();
        }

        title.setText(item.getTitle());
        invalidate();
    }

    private int[] mix(float fraction, int[] c1, int[] c2) {
        return new int[]{
                (Integer) evaluator.evaluate(fraction, c1[0], c2[0]),
                (Integer) evaluator.evaluate(fraction, c1[1], c2[1]),
                (Integer) evaluator.evaluate(fraction, c1[2], c2[2])
        };
    }

    private int[] jellyGradient(TroppoType jelly) {
        switch (jelly) {
            case JELLY_1:
                return colors(R.array.gradientTest);
            case JELLY_2:
                return colors(R.array.gradientTest);
            case JELLY_3:
                return colors(R.array.gradientTest);
            case JELLY_4:
                return colors(R.array.gradientTest);
            case JELLY_5:
                return colors(R.array.gradientTest);
            case JELLY_6:
                return colors(R.array.gradientTest);
            default:
                throw new IllegalArgumentException();
        }
    }

    private int jellyIcon(TroppoType jelly) {
        switch (jelly) {
            case JELLY_1:
                return R.drawable.ic_launcher_background;
            case JELLY_2:
                return R.drawable.ic_launcher_background;
            case JELLY_3:
                return R.drawable.ic_launcher_background;
            case JELLY_4:
                return R.drawable.ic_launcher_background;
            case JELLY_5:
                return R.drawable.ic_launcher_background;
            case JELLY_6:
                return R.drawable.ic_launcher_background;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int[] colors(@ArrayRes int res) {
        return getContext().getResources().getIntArray(res);
    }
}
