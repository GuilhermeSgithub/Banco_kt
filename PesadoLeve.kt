data class Pessoa(val nome:String, val peso:Double)

fun main() {
    val Pessoas = mutableListOf<Pessoa>()

    while (true){
        println("Nome: ")
        val nome = readLine().toString()
        println("Peso:")
        val peso = readLine()?.toDoubleOrNull() ?: 0.0
        Pessoas.add(Pessoa(nome,peso))
        println("Quer Adicionar Mais Alguém ?  S/N ")
        val resposta = readLine().toString()
        if (resposta == "n"){
            break
        }
    }
    var pessoaMaisPesada : Pessoa? = null
    var pessoaMaisLeve : Pessoa? = null

    for (p in Pessoas){
        if(pessoaMaisPesada == null || p.peso > pessoaMaisPesada.peso)
            pessoaMaisPesada = p

        if (pessoaMaisLeve == null || p.peso < pessoaMaisLeve.peso){
            pessoaMaisLeve = p
        }
    }

    println("Pessoa mais pesada: ${pessoaMaisPesada?.nome} - Peso: ${pessoaMaisPesada?.peso}")
    println("Pessoa mais leve: ${pessoaMaisLeve?.nome} - Peso: ${pessoaMaisLeve?.peso}")
    println("Pessoas cadastradas : ${Pessoas}")
}