package pt.ipg.calculadordedividas

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipg.calculadordedividas.ui.theme.CalculadorDeDividasTheme
import java.text.NumberFormat
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadorDeDividasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LayoutCalculadorDividas()
                }
            }
        }
    }
}


@Composable
fun InserirNumeros(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                   value: String,
                   onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    TextField(
        value = value,
        onValueChange = onValueChanged,
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            //cores da caixa de texto
            unfocusedContainerColor = colorResource(id = R.color.verde_ct),
            focusedContainerColor = colorResource(id = R.color.azul_ct),

            //cores do texto escrito na label
            unfocusedLabelColor = colorResource(id = R.color.verde_giro),
            focusedLabelColor = colorResource(id = R.color.azul_giro),

            //cor do cursor
            unfocusedIndicatorColor = colorResource(id = R.color.cinza_giro),
            focusedIndicatorColor = colorResource(id = R.color.cinza_giro),

            //cores de texto escrito na caixa
            focusedTextColor=colorResource(id=R.color.black))
    )
}

@Composable
fun LayoutCalculadorDividas() {
    var dividaInp by remember { mutableStateOf("") }
    val divida = dividaInp.toDoubleOrNull() ?: 0.0

    var emprestimoInp by remember { mutableStateOf("") }
    val emprestimo = emprestimoInp.toDoubleOrNull() ?: 0.0

    var jurosPerctInp by remember { mutableStateOf("") }
    val jurosPerct = jurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var percentOInp by remember { mutableStateOf("") }
    val percentO = percentOInp.toDoubleOrNull() ?: 0.0

    val jurosTotal = calcularJurosEmprestimo(emprestimo, jurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, percentO)
    val resto = calcularResto(emprestimo, divida)

    // Passar parâmetros para Double para facilitar a conta
    val jurosTD = NumberFormat.getCurrencyInstance().parse(jurosTotal)?.toDouble() ?: 0.0
    val orcamentoD = NumberFormat.getCurrencyInstance().parse(orcamento)?.toDouble() ?: 0.0
    val restoD = NumberFormat.getCurrencyInstance().parse(resto)?.toDouble() ?: 0.0

    // Atribuir aos valores meses e semanas os valores
    val mes = calcularTempoMes(orcamentoD, jurosTD, restoD)
    val semanas = calcularTempoSemanas(orcamentoD, jurosTD, restoD)

    val tamanhoText = TextStyle(fontSize = 26.sp)


    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {

        Text(text = stringResource(R.string.calcula_div), modifier = Modifier
            .padding(bottom = 16.dp, top = 40.dp)
            .align(Alignment.CenterHorizontally), style = tamanhoText)



        // Inserir valor de Emprestimo
        InserirNumeros(
            label = R.string.emp,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            value = emprestimoInp,
            onValueChanged = { emprestimoInp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        // Inserir valor de Ordenado
        InserirNumeros(
            label = R.string.ord,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            value = ordenadoInp,
            onValueChanged = { ordenadoInp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        // Inserir valor usado do ordenado (Percentagem)
        InserirNumeros(
            label = R.string.percentord,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            value = percentOInp,
            onValueChanged = { percentOInp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        // Inserir valor de Percentagem de juros sobre o emprestimo
        InserirNumeros(
            label = R.string.empjuros,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            value = jurosPerctInp,
            onValueChanged = { jurosPerctInp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        // Inserir valor de Divida
        InserirNumeros(
            label = R.string.div,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            value = dividaInp,
            onValueChanged = { dividaInp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )


        Text(text = stringResource(R.string.mesesdiv, mes),
            style = tamanhoText)

        Spacer(modifier = Modifier.height(45.dp))
        Text(text = stringResource(R.string.semanadiv, semanas),
            style = tamanhoText)

        Spacer(modifier = Modifier.height(150.dp))
    }
}

//calcula a parte do ordenado que vai ser retirada mensalmente ou "orcamento"
private fun calcularPercentagemOrdenado(ordenado: Double, percentO: Double = 50.0): String {
    val orcamento = (percentO / 100) * ordenado
    return NumberFormat.getCurrencyInstance().format(orcamento)
}
//calcula o valor total a pagar com o emprestimo e os juros
private fun calcularJurosEmprestimo(emprestimo: Double, jurosPerct: Double = 25.0): String {
    val juros = (jurosPerct / 100) * emprestimo
    val jurosT = emprestimo + juros
    return NumberFormat.getCurrencyInstance().format(jurosT)
}

//calcula o valor de sobra do emprestimo se houver
private fun calcularResto(emprestimo: Double = 700.0, divida: Double = 700.0): String {
    val resto = emprestimo - divida
    return NumberFormat.getCurrencyInstance().format(resto)
}

//função para calcular o tempo em meses
private fun calcularTempoMes(orcamento: Double, jurosT: Double, resto: Double): Int {
    var mes = 0
    var divRestante = jurosT - resto

    while (divRestante > 0) {
        divRestante -= orcamento
        mes += 1
    }
    return mes
}

//função para calcular o tempo em semanas
private fun calcularTempoSemanas(orcamento: Double, jurosT: Double, resto: Double): Int {
    var semanas = 0
    var divRestante = jurosT - resto
    var orcSem = orcamento/4

    while (divRestante > 0) {
        divRestante -= orcSem
        semanas += 1
    }
    return semanas
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LayoutCalculadorDividasPreview() {
    CalculadorDeDividasTheme {
        LayoutCalculadorDividas()
    }
}
