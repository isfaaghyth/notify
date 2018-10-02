package isfaaghyth.app.notify

import android.util.Log
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Created by isfaaghyth on 10/3/18.
 * github: @isfaaghyth
 */
object Notify {

    private val TAG = "Notify"
    private val subject: Subject<Any> = PublishSubject.create()

    fun <T> listen(tClass: Class<T>, subscriber: EventProvider,
                   onNext: Consumer<T>, onError: Consumer<Throwable>): Disposable {
        Log.d(TAG, tClass.name)
        return subject
                .subscribeOn(subscriber.io())
                .observeOn(subscriber.mainThread())
                .filter { o -> o.javaClass == tClass }
                .map { o -> o as T }
                .subscribe(onNext, onError)
    }

    fun <T> listen(tClass: Class<T>, subscriber: EventProvider,
                   onNext: Consumer<T>): Disposable {
        Log.d(TAG, tClass.name)
        return subject
                .subscribeOn(subscriber.io())
                .observeOn(subscriber.mainThread())
                .filter { o -> o.javaClass == tClass }
                .map { o -> o as T }
                .subscribe(onNext)
    }

    /**
     * unused @TODO(backup)
     */
    fun unlisten(disposable: Disposable) = disposable.dispose()

    fun send(event: Any) = subject.onNext(event)

}