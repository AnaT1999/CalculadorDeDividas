package pt.ipg.calculadordedividas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import pt.ipg.calculadordedividas.ui.theme.CalculadorDeDividasTheme
import java.text.NumberFormat


class MainActivity : ComponentActivity() {
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
fun LayoutCalculadorDividas() {
    var DividaInp by remember { mutableStateOf("") }
    var EmprestimoInp by remember { mutableStateOf("") }
    var JurosPerctInp by remember { mutableStateOf("") }
    var ordenadoInp by remember { mutableStateOf("") }
    var PercentOInp by remember { mutableStateOf("") }





    Column {
        Text("Calcula a tua divida")

        //Emprestimo
        TextField(
            value = EmprestimoInp,
            onValueChange = { EmprestimoInp = it },
            label = { Text("Emprestimo") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        //Divida
        TextField(
            value = DividaInp,
            onValueChange = { DividaInp = it },
            label = { Text("Divida ") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        //Percentagem de juros sobre o emprestimo
        TextField(
            value = JurosPerctInp,
            onValueChange = { JurosPerctInp = it },
            label = { Text("Percentagem de Juros") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        //Ordenado
        TextField(
            value = ordenadoInp,
            onValueChange = { ordenadoInp = it },
            label = { Text("Ordenado Mensal") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        //Valor usado do ordenado (Percentagem)
        TextField(
            value = PercentOInp,
            onValueChange = { PercentOInp = it },
            label = { Text("Percentagem para o Emprestimo") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (DividaInp.isNotEmpty() && EmprestimoInp.isNotEmpty() && JurosPerctInp.isNotEmpty() && ordenadoInp.isNotEmpty() && PercentOInp.isNotEmpty()) {
            val Divida = DividaInp.toDoubleOrNull() ?: 0.0
            val Emprestimo = EmprestimoInp.toDoubleOrNull() ?: 0.0
            val JurosPerct = JurosPerctInp.toDoubleOrNull() ?: 0.0
            val ordenado = ordenadoInp.toDoubleOrNull() ?: 0.0
            val PercentO = PercentOInp.toDoubleOrNull() ?: 0.0

            val EmprestimoEJuros = calcularJurosEmprestimo(Emprestimo, JurosPerct)
            val OrcamentoUsado = calcularPercentagemOrdenado(ordenado, PercentO)
            val RestoEnprestimo = calcularResto(Emprestimo, Divida)

        }

        Text(stringResource(id = ))

    }
}

@Composable
/*fun InserirNumeros() {

}

 */


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
private fun calcularTempoMes(orcamento: String, jurosT: String, resto: String ): Int {
    var mes = 0
    var DividaRestante = jurosT - resto

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - orcamento
        mes = mes + 1
    }
    return mes
}

private fun calcularTempoSemanas(orcamento: String, jurosT: String ,resto: String): Int {
    var semana = 0
    var DividaRestante = jurosT - resto

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - orcamento
        semana = semana + 1
    }
    return semana * 4
}


@Preview(showBackground = true)
@Composable
fun LayoutCalculadorDividasPreview() {
    CalculadorDeDividasTheme {
        LayoutCalculadorDividas()
    }
}