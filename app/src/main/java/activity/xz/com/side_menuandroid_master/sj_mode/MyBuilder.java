package activity.xz.com.side_menuandroid_master.sj_mode;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/7/6.
 */
//Builder 模式
public class MyBuilder {
    private int id;
    private String num;

    public MyBuilder bulid() {
        MyData myData = new MyData();
        myData.setId(id);
        myData.setNum(num);
        return this;
    }

    public MyBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MyBuilder setNum(String num) {
        this.num = num;
        return this;
    }

    //    AlertDialog.Builder builder =new AlertDialog.Builder(context);
//    builder.setIcon(R.drawable.ic_launcher)
//            .setTitle("title")
//    .setMessage("message")
//    .setPositiveButton("Button1",
//                               new DialogInterface.OnClickListener(){
//        public void onClick(DialogInterface dialog, int whichButton){
//            setTitle("click");
//        }
//    })
//            .create()
//    .show();
    class MyData {
        private int id;
        private String num;

        public void Test() {

        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNum(String num) {
            this.num = num + "id";
        }

        Uri uri = Uri.parse("sdsa");
        Intent shardIntent = new Intent(Intent.ACTION_SENDTO, uri);
        Intent intent = (Intent) shardIntent.clone();
//    startActivity(intent);
/**
 * 工厂方法模式
 */
//        public Object getSystemService(String name) {
//            if (getBaseContext() == null) {
//                throw new IllegalStateException("System services not available to Activities before onCreate()");
//            }
//            //........
//            if (WINDOW_SERVICE.equals(name)) {
//                return mWindowManager;
//            } else if (SEARCH_SERVICE.equals(name)) {
//                ensureSearchManager();
//                return mSearchManager;
//            }
//            //.......
//            return super.getSystemService(name);
//        }
//    }

    }
}
