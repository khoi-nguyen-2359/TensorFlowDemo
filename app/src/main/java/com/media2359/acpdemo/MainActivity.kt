package com.media2359.acpdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		sample_text.text = stringFromJNI()
	}

	external fun stringFromJNI(): String

	companion object {

		const val MINIMUM_CONFIDENCE_TF_OD_API = 0.6f

		const val TF_OD_API_INPUT_SIZE = 300
		const val TF_OD_API_MODEL_FILE = "file:///android_asset/ssd_mobilenet_v1_android_export.pb"
		const val TF_OD_API_LABELS_FILE = "file:///android_asset/coco_labels_list.txt"

		init {
			System.loadLibrary("acp_demo")
		}
	}
}
