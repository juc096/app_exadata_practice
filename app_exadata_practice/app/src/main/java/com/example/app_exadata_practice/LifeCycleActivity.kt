package com.example.app_exadata_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
private const val tag = "lifecycle"
class LifeCycleActivity : AppCompatActivity() {

    /*
        onCreate function initializes the activity to be started and creates resources necessary
        to do activity function

        Functions similarly to object constructors.

        Call scenarios:
            - User launching activity for the first time in the session
            - User resuming activity, but the activity process has been killed by the OS
                * Activity will need to be resumed from saved state
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //tag = "lifecycle"
        Log.i(tag, "create")
        setContentView(R.layout.activity_life_cycle)
    }

    /*
        onStart begins the activity process to do what it needs to do dictated by the user

        overriding onStart also implies something must be done before it can resume (onResume) process

        Call scenario:
            - after onCreate
            - after onRestart

     */
    override fun onStart(){
        Log.d(tag, "start")
        super.onStart()
    }

    /*
        onRestart is called to restart activity process after a process has been stopped (onStop)
        onRestart called before system calls onStart

        overriding onRestart implies something must be done before it can start again after an
        activity is no longer visible, but still alive
            * info validation?

        Call scenario:
            - after onStop
     */
    override fun onRestart() {
        Log.d(tag, "restart")
        super.onRestart()
    }

    /*
        onResume is called to resume/run activity necessary for activity functionality

        Call scenario:
            - after onStart
            - after onPause
     */
    override fun onResume() {
        Log.d("onResume", "resume")
        super.onResume()
    }

    /*
        onPause is called when activity is about to enter the background due to another
        activity coming into foreground.

        Think split screen, fragments, etc

        Use this to save state?

        Call scenario:
            - after onResume
     */
    override fun onPause() {
        Log.d(tag, "pause")
        super.onPause()
    }

    /*
        onStop is called when activity is no longer visible, but process is still alive for now

        can not rely on onStop to be called

        Call scenario :
            - after onPause

     */
    override fun onStop() {
        Log.d(tag, "stop")
        super.onStop()
    }

    /*
        onDestroy is called when activity is finishing or being destroyed
     */
    override fun onDestroy() {
        Log.d(tag, "destr")
        super.onDestroy()
    }
}