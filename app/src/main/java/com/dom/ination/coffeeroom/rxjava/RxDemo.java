package com.dom.ination.coffeeroom.rxjava;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by huoxiaobo on 2017/3/14.
 */

public class RxDemo {

    public static void main(String[] args) {
        Observable.interval(3l, TimeUnit.SECONDS, Schedulers.trampoline()).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long s) {
                System.out.println(s);
            }
        });
    }
}
