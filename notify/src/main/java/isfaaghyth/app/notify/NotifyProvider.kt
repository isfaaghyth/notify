package isfaaghyth.app.notify

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by isfaaghyth on 10/3/18.
 * github: @isfaaghyth
 */
class NotifyProvider : EventProvider {
    override fun mainThread(): Scheduler = Schedulers.trampoline()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun trampoline(): Scheduler = Schedulers.trampoline()
    override fun newThread(): Scheduler = Schedulers.newThread()
    override fun io(): Scheduler = Schedulers.io()
}