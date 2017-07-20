package activity.xz.com.side_menuandroid_master.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.OperatorObserveOn;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ViewAcitivity extends AppCompatActivity{
     File[] folders;
    @BindView(R.id.imageview)
     ImageView imageview;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        ButterKnife.bind(this);
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable  = getTheme().getDrawable(R.drawable.btn_back);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(ViewAcitivity.this,"图片出现错误",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Drawable drawable) {
              imageview.setImageDrawable(drawable);
            }
        });
//        Observable<List<String>> tvShowObservable = Observable.from(new Callable<List<String>>() {
//
//            @Override
//            public List<String> call() {
//                return mRestClient.getFavoriteTvShows();
//            }
//        });
//        Observable  mTvShowSubscription = tvShowObservable .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<String>>() {
//
//                    @Override
//                    public void onCompleted() { }
//
//                    @Override
//                    public void onError(Throwable e) { }
//
//                    @Override
//                    public void onNext(List<String> tvShows){
////                        displayTvShows(tvShows);
//                    }
//                });
//        Observable.just("images/logo.png") // 输入类型 String
//                .map(new Func1<String, Bitmap>() {
//                    @Override
//                    public Bitmap call(String filePath) { // 参数类型 String
//                        return getBitmapFromPath(filePath); // 返回类型 Bitmap
//                    }
//                })
//                .subscribe(new Action1<Bitmap>() {
//                    @Override
//                    public void call(Bitmap bitmap) { // 参数类型 Bitmap
//                        showBitmap(bitmap);
//                    }
//                });
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                for (File folder : folders){
//                    File[] files = folder.listFiles();
//                    for (File file : files) {
//                         if(file.getName().endsWith(".png")){
////                             final Bitmap bitmap = getBitmapFromFile(file);
//                             ViewAcitivity.this.runOnUiThread(new Runnable() {
//                                 @Override
//                                 public void run() {
////                                     imageCollectorView.addImage(bitmap);
//                                 }
//                             });
//                         }
//                    }
//                }
//            }
//        };
//
//        //Rxjava
//        Observable.from(folders)
//                .flatMap(new Func1<File, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(File file) {
//                        return null;
//                    }
//                })
//                .filter(new Func1<Object, Boolean>() {
//                    @Override
//                    public Boolean call(Object o) {
//                        return null;
//                    }
//                })
//                .map(new Func1<Object, Object>() {
//                    @Override
//                    public Object call(Object o) {
//                        return null;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//                .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        });
//        Observer<String> server = new Observer<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        };
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        };
//
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>(){
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onNext("Aloha");
//                subscriber.onCompleted();
//            }
//        });
    }
}
