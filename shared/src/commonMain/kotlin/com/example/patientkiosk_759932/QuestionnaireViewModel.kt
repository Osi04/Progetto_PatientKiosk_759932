package com.example.patientkiosk_759932

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuestionnaireViewModel(private val struct: QuestionnaireStruct) {
    val questions = struct.getQuestions()

    private val _selectedAnswer = MutableStateFlow<String?>(null)
    val selectedAnswer: StateFlow<String?> = _selectedAnswer.asStateFlow()

    fun selectAnswer(answer: String){
        _selectedAnswer.value=answer
    }
}