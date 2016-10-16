package bid.woou.valuesrestest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] textIds = new int[] {
            R.string.c1, R.string.c2, R.string.c3,
            R.string.c4, R.string.c5, R.string.c6,
            R.string.c7, R.string.c8, R.string.c9
    };
    int[] colorIds = new int[] {
            R.color.c1, R.color.c2, R.color.c3,
            R.color.c4, R.color.c5, R.color.c6,
            R.color.c7, R.color.c8, R.color.c9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个BaseAdapter
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                //指定一共包含9个选项
                return textIds.length;
            }

            @Override
            public Object getItem(int i) {
                //返回指定位置的文本
                return getResources().getText(textIds[i]);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView text = new TextView(MainActivity.this);
                Resources res = MainActivity.this.getResources();
                // 使用尺寸资源设置文本框的高度、宽度
                text.setWidth((int) res.getDimension(R.dimen.cell_width));
                text.setHeight((int) res.getDimension(R.dimen.cell_height));
                // 使用字符串资源来设置文本框的内容
                text.setText(textIds[i]);
                // 使用颜色资源来设置文本框的背景色
                text.setBackgroundResource(colorIds[i]);
                text.setTextSize(20);
                text.setTextSize(getResources().getInteger(R.integer.font_size));
                return text;
            }
        };
        GridView grid = (GridView) findViewById(R.id.gri01);
        // 为GridView设置Adapter
        grid.setAdapter(ba);
    }
}
