package com.cn.version3.base;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public interface IBasePresenter<V extends IBaseView> {
    /**
     * 绑定View层
     * @param view IBaseView的子类
     */
    void attachView(V view);

    /**
     * 接触绑定View层
     */
    void detachView();
}
