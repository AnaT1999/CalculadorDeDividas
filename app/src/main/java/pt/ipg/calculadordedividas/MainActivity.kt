package pt.ipg.calculadordedividas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column {
        Text("Calcula a tua divida")
        //Text("Emprestimo")
       // Text("Divida")
        Text("Divida Total")
        //InserirNumeros()
        Text("Juros sobre o Emprestimo")
        //InserirNumeros()
        //Text("Valor a Pagar")
        //Text("Ordenado")
        //InserirNumeros()
        //Text("Valor usado do ordenado (Percentagem)")
        //InserirNumeros()
        Text("Orçamento para pagar a divida mensalmente")
        //InserirNumeros()
        //Text("Tempo em ano")
        //Text("Tempo em meses ")
        //Text("Tempo em semanas")
        Text("Tempo mes até a divida ser paga")

    }
}

@Composable
/*fun InserirNumeros() {

}

 */


private fun calcularPercentagemOrdenado(ordenado: Double, Percentagem: Double = 15.0): String {
     val amount = (Percentagem / 100) * ordenado
     return NumberFormat.getCurrencyInstance().format(amount)
}

private fun calcularJurosEmprestimo(Emprestimo: Double, JurosPerct: Double = 15.0): String {
    val juros = (JurosPerct / 100) * Emprestimo
    val jurosT = Emprestimo + juros
    return NumberFormat.getCurrencyInstance().format(jurosT)
}


private fun calcularTempoMes(ordenado: Double, jurosT: Double ): Int {
    var counter = 0
    var DividaRestante = jurosT

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - ordenado
        counter = counter + 1
    }
    return counter
}

private fun calcularTempoSemanas(ordenado: Double, jurosT: Double ): Int {
    var counter = 0
    var DividaRestante = jurosT

    while(DividaRestante > 0){
        DividaRestante = DividaRestante - ordenado
        counter = counter + 1
    }
    return counter * 4
}


@Preview(showBackground = true)
@Composable
fun LayoutCalculadorDividasPreview() {
    CalculadorDeDividasTheme {
        LayoutCalculadorDividas()
    }
}