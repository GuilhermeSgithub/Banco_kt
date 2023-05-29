data class Cliente(val nome: String, val senha: String, var saldo: Double)

var saldoLogado: Double = 0.00
var usuarioLogado: String = ""
val extratoSaque = mutableListOf<Double>()
val extratoDeposito = mutableListOf<Double>()

val listaClientes = mutableListOf<Cliente>()


fun entradaValor(valor: Any): Double {
    val valorSaida = valor.toString()

    if (valor == String) {
        return 0.0
    } else if (valor == "") {
        return 0.0
    } else if (valor == " ") {
        return 0.0
    } else {
        return valorSaida.toDouble()
    }
}


fun login(saldoAtual: Double = 0.00): Boolean {
    println("digite seu login")
    val nomeLogin = readlnOrNull()
    println("digite sua senha")
    val senhaLogin = readlnOrNull()

    for (usuario in listaClientes) {
        if (usuario.nome == nomeLogin && usuario.senha == senhaLogin) {
            saldoLogado = saldoAtual + usuario.saldo
            usuarioLogado = usuario.nome
            return true
        }
    }
    return false
}

fun main() {
    listaClientes.add(Cliente("guilherme", "1748", 100.00))
    listaClientes.add(Cliente("matheus", "1234", 200.00))
    listaClientes.add(Cliente("leonardo", "1832", 8000.00))


    while (true) {
        var logado = login()

        if (logado == true) {
            println("Ola bem vindo ao Banco Moruga")
            break
        } else {
            println("Usuario não encontrado tente-novamente")
        }
    }

    println("olá ${usuarioLogado} seu saldo disponivel é R$ ${saldoLogado}")
    println("oque deseja fazer ?")
    while (true) {
        println("1-Sacar 2-Depositar 3-Extrato 4-Sair")

        val opção = readLine()?.toString()

        when (opção) {
            "1" -> {
                println("quanto quer sacar ?")
                val valor = entradaValor(readLine()?.toDoubleOrNull() ?: 0.0)
                if (saldoLogado <= valor) {
                    println("saldo insuficiente para saque")
                    println("voltando ao menu")
                } else {
                    saldoLogado -= valor
                    println("Contando notas ")
                    println("Retire seu dinheiro abaixo")
                    extratoSaque.add(valor)
                    println("voltando ao menu")
                }
            }

            "2" -> {
                println("quanto quer depositar ?")
                val valor = entradaValor(readLine()?.toDoubleOrNull() ?: 0.0)
                println("Insira as notas abaixo")
                saldoLogado += valor
                println("Conferindo")
                extratoDeposito.add(valor)
                println("voltando ao menu")
            }

            "3" -> {
                println("saques $extratoSaque")
                println("depositos $extratoDeposito")
                println("Saldo Total $saldoLogado")
            }

            "4" -> break
        }
    }

    println("Obrigado Volte Sempre")
}