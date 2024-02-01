package com.sharukh.sampletest.state

open class ViewState {
}

class Success<T> : ViewState()
class Err(val err: String?) : ViewState()
class Empty : ViewState()