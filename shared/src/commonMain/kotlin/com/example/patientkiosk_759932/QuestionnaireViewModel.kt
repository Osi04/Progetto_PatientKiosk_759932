package com.example.patientkiosk_759932

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyMap

class QuestionnaireViewModel(private val struct: QuestionnaireStruct) {
    val questions = struct.getQuestions()

    private val _selectedAnswer = MutableStateFlow<Map<String, Any>>(emptyMap())
    val selectedAnswer: StateFlow<Map<String, Any>> = _selectedAnswer.asStateFlow()

    fun selectAnswer(questionId: String, answer: Any){
        _selectedAnswer.value= _selectedAnswer.value.toMutableMap().apply { put(questionId,answer) }
    }
}