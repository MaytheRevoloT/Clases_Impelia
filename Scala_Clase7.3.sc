val numeros=List(1,2,3,4,1, 5, 2, 6, 3)
numeros.distinct
numeros.drop(4)
numeros.intersect(List(1,2,4,7))
numeros.diff(List(1,2,4,7))
numeros.slice(2,5)
numeros.takeRight(5) //Ultimos 5 digitos de la derecha
numeros.filter(_<3)
numeros.dropWhile(_<3)
numeros.filterNot(_<3)
numeros.find(_<3)
numeros.takeWhile(_<3)

numeros.filter(_>2).takeWhile(_<6).map(_*10)
//-----------
val nombres= List("jorge", "luis", "pedro")
nombres.map(_.capitalize)

val longituddenombres=nombres.map(s=>(s.capitalize.take(3), s.length)).toMap
longituddenombres

nombres.map(_.take(1)=="j")

numeros.filter(_<5).map(_*20)
nombres.foreach(println)

//----------
def sumar(x:Int, y:Int):Int=
  val Suma= x+y
  println(s"La suma de $x e $y es $Suma")
  Suma

val listaparasuma= List(1,2,3,4,5)
listaparasuma.reduce(sumar)

//Ejercicio
val nombres1 = List("aJorge", "Luis", "Pedro")
println(nombres1.filter(_.take(1) =="a").map(_.capitalize))

//RECURSIVIDAD --- Cuando una funcion se llama asi misma

//Ejercicio
val string1 = "Esto es un string de prueba"
 
val numeroPalabras = string1.split(" ").map(_=> 1).reduce(_+_)
println(s"La frase $string1 tiene $numeroPalabras palabras")

//Ejercicio
import scala.collection.mutable.{Map => MapMutable}
var inventario = MapMutable("Camisa" -> 10, "Pantalón" -> 5, "Zapatos" -> 8)

def agregarProduct(inventarioactual:MapMutable[String, Int], nombre:String, cantidad:Int):Unit=
  inventarioactual.update(nombre, cantidad)

def venderProduct (inventarioactual:MapMutable[String, Int], nombre:String, cantidad:Int):Unit=
  val cantidadDisponible = inventario.getOrElse(nombre, 0)
  if (cantidadDisponible >= cantidad)
    inventarioactual.update(nombre,(cantidadDisponible-cantidad))
  else
  println(s"No hay stock de $nombre")

def mostrarInventario (inventarioactual:MapMutable[String, Int]): Unit={
  for((i,j) <- inventario){
    println(s"$i:$j")
  }
}

agregarProduct(inventario,"Calcetines", 15)
inventario
venderProduct(inventario, "Camisa", 3)
inventario
mostrarInventario(inventario)

