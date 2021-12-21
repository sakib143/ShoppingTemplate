package com.innomalist.taxi.shoppingapp.base;

import android.net.Uri;

import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.data.rest.ApiInterface;

import java.io.File;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public abstract class BaseModel<T> implements ModelInterface {
    protected ApiInterface apiInterface = BaseApplication.getApiInterface();
    CompositeDisposable disposable = new CompositeDisposable();

    public DisposableSingleObserver<T> addRequest(Single<T> single, DisposableSingleObserver<T> disposableSingleObserver) {
        this.disposable.add((Disposable) single.subscribeOn(Schedulers.m130io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(disposableSingleObserver));
        return disposableSingleObserver;
    }

    public void close() {
        this.disposable.dispose();
    }

    /* access modifiers changed from: protected */
    public RequestBody formData(String str) {
        if (str == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse("multipart/form-data"), str);
    }

    /* access modifiers changed from: protected */
    public MultipartBody.Part image(String str, Uri uri) {
        if (uri == null) {
            return null;
        }
        File file = new File(uri.getPath());
        return MultipartBody.Part.createFormData(str, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
    }
}
