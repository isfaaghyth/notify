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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.txtHelo)
        getNotify()
        textView.setOnClickListener {
            Notify.send(Person("Muh Isfhani", 21))
        }
    }

    private fun getNotify() {
        composite.add(Notify.listen(Person::class.java, NotifyProvider(), Consumer {
            person -> textView.text = person.name
        }))
    }

    override fun onDestroy() {
        super.onDestroy()
        //or with...
        composite.clear()
    }

}
