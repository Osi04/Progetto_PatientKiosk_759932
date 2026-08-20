package com.example.patientkiosk_759932

interface QuestionnaireStruct {
    fun getQuestions(): List<Question>
}

class TestQuestionnaireStruct : QuestionnaireStruct{
    override fun getQuestions(): List<Question> {
        return listOf(
            Question("q1","Domanda numero 1")
        )
    }
}