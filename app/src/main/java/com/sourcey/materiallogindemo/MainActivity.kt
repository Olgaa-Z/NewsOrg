package com.sourcey.materiallogindemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.guardsquare.dexguard.rasp.callback.DetectionReport
import com.sourcey.materiallogindemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }



    companion object
    {
        /**
         * This is an optional DexGuard ThreatCast AUID getter method. This signature must match.
         *
         * Any strings used in the getAuid will be automatically encrypted.
         *
         * @return A String representing the App User ID (AUID).
         */

        @JvmStatic
        fun myCallback(detectionReport: DetectionReport) {
            Log.i("==== DetectionReport", "Threat detected")
            if (detectionReport.isAppTampered) {
                Log.i("==== DetectionReport", "Apk file tampered")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Apk file tampered " + detectionReport.debugInfo
                )

            } else if (detectionReport.isAppDebuggable) {
                Log.i("==== DetectionReport", "Application is debuggable")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Application is debuggable " + detectionReport.debugInfo
                )

            } else if (detectionReport.isApplicationHooked) {
                Log.i("==== DetectionReport", "Hook detected")
                Log.i("==== DetectionReport", "DebugInfo Hook " + detectionReport.debugInfo)

            } else if (detectionReport.isCertificateTampered) {
                Log.i("==== DetectionReport", "Certificate tampered")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Certificate tampered " + detectionReport.debugInfo
                )

            } else if (detectionReport.isDebuggerAttached) {
                Log.i("==== DetectionReport", "Debugger attached detected")
                Log.i("==== DetectionReport", "DebugInfo Debugger " + detectionReport.debugInfo)

            } else if (detectionReport.isDeviceRooted) {
                Log.i("==== DetectionReport", "Rooted device detected")
                Log.i("==== DetectionReport", "DebugInfo Rooted " + detectionReport.debugInfo)

            } else if (detectionReport.isFileTampered) {
                Log.i("==== DetectionReport", "File tamper detected")
                Log.i("==== DetectionReport", "DebugInfo File tamper " + detectionReport.debugInfo)

            } else if (detectionReport.isRunningInEmulator) {
                Log.i("==== DetectionReport", "Running in emulator detected")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Running in emulator " + detectionReport.debugInfo
                )

            } else if (detectionReport.isRunningInVirtualEnvironment) {
                Log.i("==== DetectionReport", "Running in virtual environment detected")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Running in virtual environment " + detectionReport.debugInfo
                )

            } else if (detectionReport.isSignedWithDebugKeys) {
                Log.i("==== DetectionReport", "Application is signed with debug keys")
                Log.i(
                    "==== DetectionReport",
                    "DebugInfo Application is signed with debug " + detectionReport.debugInfo
                )

            }
        }
    }






}

