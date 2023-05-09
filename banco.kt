data class Cliente(val nome: String, val senha: String, var saldo: Double)

var saldoLogado: Double = 0.00
var usuarioLogado: String = ""
val extratoSaque = mutableListOf<String>()
val extratoDeposito = mutableListOf<String>()

val listaClientes = mutableListOf<Cliente>()

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

        var opçao = readlnOrNull().toString()

        if (opçao == "1") {
            println("quanto quer sacar ?")
            var valor = readlnOrNull()?.toInt()
            saldoLogado = saldoLogado - valor!!
            println("Contando notas ")
            println("Retire seu dinheiro abaixo")
            extratoSaque.add(valor.toString())
            println("voltando ao menu")
            true
        } else if (opçao == "2") {
            println("quanto quer depositar ?")
            var valor = readlnOrNull()?.toInt()
            println("Insira as notas abaixo")
            saldoLogado = saldoLogado + valor!!
            println("Conferindo")
            extratoDeposito.add(valor.toString())
            println("voltando ao menu")
            true
        } else if (opçao == "3") {
            println("saques ${extratoSaque}")
            println("depositos ${extratoDeposito}")
            println("Saldo Total ${saldoLogado}")
        } else if (opçao == "4") {
            break
        }


    }
    println("Obrigado Volte Sempre")
}