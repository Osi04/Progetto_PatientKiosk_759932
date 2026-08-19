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
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
data class Question(
    val id: String,
    val text: String
)
@Composable
@Preview
fun App() {
    MaterialTheme {
        //Domanda hardcoded
        val testQuestion = remember {Question(id = "q1", text = "Domanda numero 1")}
        //Possibili Risposte Hardcoded
        val testAnswers = listOf("Moltissimo", "Molto", "Un po'", "Poco", "Per nulla")
        //Rispsota selezionata (Stato) tra le possibili
        var selectedAnswer by remember { mutableStateOf<String?>(null) }


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

            Text(text=testQuestion.text,
                 fontSize = 18.sp)
            testAnswers.forEach { answers ->
                Row (
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {selectedAnswer=answers}
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    RadioButton(
                        selected = (selectedAnswer==answers),
                        onClick = {selectedAnswer=answers}
                    )
                    Text(text = answers)
                  }
            }
        }
    }
}