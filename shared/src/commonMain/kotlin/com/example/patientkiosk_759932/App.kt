package com.example.patientkiosk_759932

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import patientkiosk_759932.shared.generated.resources.Res
import patientkiosk_759932.shared.generated.resources.compose_multiplatform

//Classi momentaneo
sealed class Question {
    abstract val id: String
    abstract val text: String
}

data class MultipleChoiceQuestion(
    override val id: String,
    override val text: String,
    val options: List<String>
) : Question()

data class ScaleQuestion(
    override val id: String,
    override val text: String,
    val min: Int,
    val max: Int
) : Question()

@Composable
@Preview
fun App() {
    MaterialTheme {
        //Domanda hardcoded
        val struct = remember { TestQuestionnaireStruct()}
        val viewModel = remember { QuestionnaireViewModel(struct) }
        //Possibili Risposte Hardcoded
        val testAnswers = listOf("Moltissimo", "Molto", "Un po'", "Poco", "Per nulla")
        //Rispsota selezionata (Stato) tra le possibili
        val selectedAnswer by viewModel.selectedAnswer.collectAsState()

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "PatientKiosk",
                 fontSize = 24.sp,
                 color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(24.dp))

            viewModel.questions.forEach { question ->
                Text(text = question.text)
                Spacer(modifier = Modifier.height(24.dp))

                when (question) {
                    is MultipleChoiceQuestion -> {
                        question.options.forEach { option ->
                            Row (
                                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                                modifier = Modifier
                                    .clickable {viewModel.selectAnswer(question.id,option)}
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            ) {
                                RadioButton(
                                    selected = (selectedAnswer[question.id]==option),
                                    onClick = {viewModel.selectAnswer(question.id,option)}
                                )
                                Text(text = option)
                        }
                    }
                }
                    is ScaleQuestion -> {
                        val currentValue = (selectedAnswer[question.id] as? Float) ?: question.min.toFloat()
                        Slider(
                            value = currentValue,
                            onValueChange = {viewModel.selectAnswer(question.id,it)},
                            valueRange = question.min.toFloat()..question.max.toFloat(),
                            steps = (question.max - question.min) - 1
                        )
                        Text("Valore: ${currentValue.toInt()}")
                    }
                }
            }
        }
    }
}