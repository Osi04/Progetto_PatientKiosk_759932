package com.example.patientkiosk_759932

interface QuestionnaireStruct {
    fun getQuestions(): List<Question>
}

class TestQuestionnaireStruct : QuestionnaireStruct{
    override fun getQuestions(): List<Question> {
        return listOf(
            MultipleChoiceQuestion("q1","Domanda numero 1", listOf("Moltissimo", "Molto", "Un po'", "Poco", "Per nulla")),
            ScaleQuestion("q2","Domanda numero 2", 1, 10 )
        )
    }
}