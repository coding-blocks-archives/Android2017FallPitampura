package com.example.arnav.firebasedb.models

/**
 * Created by arnav on 10/22/2017.
 */

class Todo {
    var task: String = ""
    var isDone: Boolean = false
    var uid: String? = null

    constructor() {
    }

    constructor(task: String, done: Boolean) {
        this.task = task
        this.isDone = done
    }
}
