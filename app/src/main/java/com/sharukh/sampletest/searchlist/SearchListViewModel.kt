package com.sharukh.sampletest.searchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sharukh.sampletest.models.Doc
import com.sharukh.sampletest.state.Err
import com.sharukh.sampletest.state.ViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Error

class SearchListViewModel : ViewModel() {

    private val searchListModel = SearchListModel()

    private val compositeDisposable = CompositeDisposable()

    // todo abstract this with livedata and hide mutability inside
    val listData = MutableLiveData<List<Doc>>()

    // todo abstract this with livedata and hide mutability inside
    val errorStat = MutableLiveData<Err>()

    init {
        compositeDisposable.add(
            searchListModel
                .getArticleList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    listData.value = it
                }, {
                    errorStat.value = Err(it.message)
                    it.printStackTrace()
                })
        )


    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}