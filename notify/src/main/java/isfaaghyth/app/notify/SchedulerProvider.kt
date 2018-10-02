package isfaaghyth.app.notify

import io.reactivex.Scheduler

/**
 * Created by isfaaghyth on 10/3/18.
 * github: @isfaaghyth
 */
interface SchedulerProvider {
    fun mainThread(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}