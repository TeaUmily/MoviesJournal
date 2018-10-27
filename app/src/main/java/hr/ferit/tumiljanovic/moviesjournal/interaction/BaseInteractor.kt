package hr.ferit.tumiljanovic.moviesjournal.interaction

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import hr.ferit.tumiljanovic.moviesjournal.listener.NetworkResponseListener
import io.reactivex.observers.DisposableObserver

open class BaseInteractor {

    lateinit var disposableObserver: DisposableObserver<InteractorWrapper>

    fun provideDisposableObserver(listener: NetworkResponseListener): DisposableObserver<InteractorWrapper> {
        disposableObserver = object : DisposableObserver<InteractorWrapper>() {

            override fun onNext(data: InteractorWrapper) {
                   listener.onSuccess(data)
            }

            override fun onError(e: Throwable) {
                listener.onFailure(e)
            }

            override fun onComplete() {

            }
        }
        return disposableObserver
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun dispose() {
        disposableObserver.dispose()
    }


}