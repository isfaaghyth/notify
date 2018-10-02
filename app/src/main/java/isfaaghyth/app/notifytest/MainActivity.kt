package isfaaghyth.app.notifytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import isfaaghyth.app.notify.EventProvider
import isfaaghyth.app.notify.Notify
import isfaaghyth.app.notify.NotifyProvider

class MainActivity : AppCompatActivity() {

    private var composite: CompositeDisposable = CompositeDisposable()
    private lateinit var textView: TextView
    private lateinit var listen: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.txtHelo)
        Notify.send(Person("Muh Isfhani", 21))
        getNotify()
    }

    private fun getNotify() {
        listen = Notify.listen(Person::class.java, NotifyProvider(), Consumer {
            person -> textView.text = person.name
        })

        composite.add(listen)
    }

    override fun onDestroy() {
        super.onDestroy()
        Notify.unlisten(listen)

        //or with...
        composite.clear()
    }

}
