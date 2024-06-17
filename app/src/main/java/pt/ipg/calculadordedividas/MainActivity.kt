package pt.ipg.calculadordedividas

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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


@SuppressLint("UnrememberedMutableState")
@Composable
fun InserirNumeros(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                   value: MutableState<String>,
                   onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    /*var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

   // val mes = CalcularTempoMes(orcamento, JurosT, resto)
   // val semanas = CalcularTempoSemanas(orcamento, JurosT, resto)
   */


    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onValueChanged(it)
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun InserirNumeros2(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                    value: MutableState<String>,
                    onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    /*var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

   // val mes = CalcularTempoMes(orcamento, JurosT, resto)
   // val semanas = CalcularTempoSemanas(orcamento, JurosT, resto)
   */


    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onValueChanged(it)
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun InserirNumeros3(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                    value: MutableState<String>,
                    onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    /*var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

   // val mes = CalcularTempoMes(orcamento, JurosT, resto)
   // val semanas = CalcularTempoSemanas(orcamento, JurosT, resto)
   */


    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onValueChanged(it)
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun InserirNumeros4(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                    value: MutableState<String>,
                    onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    /*var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

   // val mes = CalcularTempoMes(orcamento, JurosT, resto)
   // val semanas = CalcularTempoSemanas(orcamento, JurosT, resto)
   */


    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onValueChanged(it)
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun InserirNumeros5(@StringRes label: Int,
                   keyboardOptions: KeyboardOptions,
                    value: MutableState<String>,
                    onValueChanged: (String) -> Unit,
                   modifier: Modifier = Modifier) {

    /*var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

   // val mes = CalcularTempoMes(orcamento, JurosT, resto)
   // val semanas = CalcularTempoSemanas(orcamento, JurosT, resto)
   */


    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onValueChanged(it)
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        modifier = modifier,
        keyboardOptions = keyboardOptions
    )
}




@SuppressLint("UnrememberedMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LayoutCalculadorDividas() {
    var DividaInp by remember {mutableStateOf("")}
    val Divida = DividaInp.toDoubleOrNull() ?: 0.0

    var EmprestimoInp by remember { mutableStateOf("") }
    val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0

    var JurosPerctInp by remember { mutableStateOf("") }
    val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0

    var ordenadoInp by remember { mutableStateOf("") }
    val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0

    var PercentOInp by remember { mutableStateOf("") }
    val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

    val juros_total = calcularJurosEmprestimo(Emprestimo, JurosPerct)
    val orcamento = calcularPercentagemOrdenado(ordenado, PercentO)
    val resto = calcularResto(Emprestimo, Divida)

    //Passar parametros para Double para facilitar a conta
    val jurosTD = NumberFormat.getCurrencyInstance().parse(juros_total)?.toDouble() ?: 0.0
    val orcamentoD = NumberFormat.getCurrencyInstance().parse(orcamento)?.toDouble() ?: 0.0
    val restoD = NumberFormat.getCurrencyInstance().parse(resto)?.toDouble() ?: 0.0

    //Atribuir aos valores meses e semanas os valores
    val mes = calcularTempoMes(orcamentoD, jurosTD, restoD)
    val semanas = calcularTempoSemanas(orcamentoD, jurosTD, restoD)


    val TamanhoText = TextStyle(
        fontSize = 26.sp
    )


    Column (modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

             Text(text = stringResource(R.string.calcula_div),modifier = Modifier
             .padding(bottom = 16.dp, top = 40.dp)
             .align(Alignment.CenterHorizontally), style = TamanhoText )

        //Inserir valor de Emprestimo
            InserirNumeros( label = R.string.emp,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                value = mutableStateOf(EmprestimoInp) ,
                onValueChanged = { EmprestimoInp = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())



        //Inserir valor de Divida
            InserirNumeros2( label = R.string.div,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                value =  mutableStateOf(DividaInp),
                onValueChanged = { DividaInp = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())


        //Inserir valor de Percentagem de juros sobre o emprestimo
            InserirNumeros3( label = R.string.empjuros,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                value = mutableStateOf(JurosPerctInp),
                onValueChanged = { JurosPerctInp = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

        //Inserir valor de Ordenado
            InserirNumeros4( label = R.string.ord,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                value = mutableStateOf(ordenadoInp),
                onValueChanged = { ordenadoInp = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())


        //Inserir valor usado do ordenado (Percentagem)
            InserirNumeros5( label = R.string.percentord,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                value = mutableStateOf(PercentOInp),
                onValueChanged = { PercentOInp = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())



        Text(text = stringResource(R.string.mesesdiv, mes),
            style = TamanhoText
        )

        Spacer(modifier = Modifier.height(45.dp))
        Text(text = stringResource(R.string.semanadiv, semanas),
            style = TamanhoText
        )

        Spacer(modifier = Modifier.height(150.dp))

    }
}

@Composable


private fun calcularPercentagemOrdenado(ordenado: Double, PercentO: Double = 15.0): String {
     val orcamento = (PercentO / 100) * ordenado
     return NumberFormat.getCurrencyInstance().format(orcamento)
}

private fun calcularJurosEmprestimo(Emprestimo: Double, JurosPerct: Double = 15.0): String {
    val juros = (JurosPerct / 100) * Emprestimo
    val jurosT = Emprestimo + juros
    return NumberFormat.getCurrencyInstance().format(jurosT)
}

private fun calcularResto(Emprestimo: Double, Divida: Double ): String {

    val resto = Emprestimo - Divida
    return NumberFormat.getCurrencyInstance().format(resto)
}
private fun calcularTempoMes(orcamento: Double, jurosT: Double ,resto: Double): Int {
    var mes = 0
    var DividaRestante = jurosT - resto

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - orcamento
        mes = mes + 1
    }
    return mes
}

private fun calcularTempoSemanas(orcamento: Double, jurosT: Double ,resto: Double): Int {
    var semanas = 0
    var DividaRestante = jurosT - resto

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - orcamento
        semanas = semanas + 1
    }
    return semanas * 4
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LayoutCalculadorDividasPreview() {
    CalculadorDeDividasTheme {
        LayoutCalculadorDividas()
    }
}