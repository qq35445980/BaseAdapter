package baseadapter.astest.com.baseadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final ListView lv = findViewById(R.id.lv);
        lv.setAdapter(new base(init(),this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(lv.getItemIdAtPosition(position) + "", "---click");
            }
        });

    }

    /**
     * 取选项
     */
    private List init() {
        List<String> lt = new ArrayList<String>();
        for (int i = 1; i < 30; i++) {
            lt.add("item" + i);
            // Log.d(lt.get(i-1), "-----");
        }
        return lt;
    }

    class base extends BaseAdapter {
        private List mlt;
        private Context mcontext;

        public base(List lt, Context context) {
            this.mlt = lt;
            this.mcontext=context;
        }


        @Override
        public int getCount() {
            return mlt.size();
        }

        @Override
        public Object getItem(int position) {
            return mlt.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView= LayoutInflater.from(mcontext).inflate(R.layout.item,null );
                TextView tv= convertView.findViewById(R.id.item_text);
                tv.setText(mlt.get(position).toString());
                tv.setTextSize(1,40 );
                convertView.setTag(tv);
            }else {
                TextView tv = (TextView) convertView.getTag();
                tv.setText(mlt.get(position).toString());
            }

            return convertView;
        }
    }

}
