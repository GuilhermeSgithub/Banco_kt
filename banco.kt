data class Cliente(val nome: String, val senha: String, var saldo: Double)


val listaClientes = mutableListOf<Cliente>()

fun login(): Boolean {
    println("digite seu login")
    val nomeLogin = readlnOrNull()
    println("digite sua senha")
    val senhaLogin = readlnOrNull()

    for (usuario in listaClientes) {
        if (usuario.nome == nomeLogin && usuario.senha == senhaLogin) {
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
            print("Ola bem vindo ao Banco Moruga")
            break
        } else {
            println("Usuario não encontrado tente-novamente")
        }
    }

}
