package com.example.diplomaapplication.ui.views.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), CoroutineScope {
    private val supervisorJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = supervisorJob + Dispatchers.IO
}