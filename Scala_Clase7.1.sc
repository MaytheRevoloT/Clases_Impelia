//LISTAS
val enteros: List[Int]=List(1,2,3,4,5)
val nombres: List[String]=List("Jorge", "Luis", "Aaron")

val nombres2= "Jorge" :: "Pedro" :: "Maria" :: Nil
val cosas: List[String|Int|Boolean]= List("Jorge", 20, "True")
//val cosas: List[Any]= List("Jorge", 20, "True")

val enteros2=0 :: enteros
val enteros3=List(-2, -1, 0) ::: enteros

//-------------
for nombre <- nombres do println(nombre)

//VECTOR
val enterosvector: Vector[Int]=Vector(1,2,3,4,5)
val nombresvector: Vector[String]=Vector("Jorge", "Luis", "Aaron")

val Jorge= nombresvector(0)

val enterosvector2=enterosvector :+ 6
val enterosvector3=enterosvector ++ enterosvector
//val enterosvector4= enterosvector.toBuffer //Cambiar tipo
//enterosvector4.getClass.getSimpleName//Cambiando a ArrayBufer

for nombre <- nombresvector do println(nombre)

//ARRAYBUFER
import scala.collection.mutable.ArrayBuffer

val nombresx=ArrayBuffer[String]()
val numerosx=ArrayBuffer[Int](100_000) //El segundo indica el espacio

val nombres5=ArrayBuffer[String]("Jorge", "Jose", "Luis")
val numeros5=ArrayBuffer[Int](1, 2,3,4,5,6,7,8)

nombres5 += "Maria"
numeros5 ++= List(-2,-1,0)
numeros5.getClass.getSimpleName

nombres5 -="Jorge"
numeros5 --=Set(1, 5)

numeros5.getClass.getSimpleName()
numeros5(2)=25
numeros5.update(0,1)
numeros5
//---------------
val nombres6=ArrayBuffer[String]("Jorge", "Jose", "Luis", "Jorge")
val indiceJorge=nombres6.indexOf("Jorge")

nombres6.remove(indiceJorge)
nombres6 += "Jorge"
nombres6.filterNot(_=="Jorge") //Para eliminar todos los elementos repetidos

//MAPS
//import scala.collection.mutable.Map //Por defecto Map es Inmutable es Scala
import scala.collection.mutable.{Map => MapMutable}

val ciudades=Map("VLC" -> "Valencia", "BCN" -> "Barcelona", "MAD"->"Madrid")
for (k,v) <- ciudades do  println(s"clave:$k, valor:$v")

val vcl=ciudades("VLC")
val ciudadesextra= ciudades ++Seq("MUC" -> "Murcia", "ZAR"->"Zaragoza")
//No se puede hacer update

//---------
val ciudades2=MapMutable("VLC" -> "Valencia", "BCN" -> "Barcelona", "MAD"->"Madrid")
for (k,v) <- ciudades2 do  println(s"clave:$k, valor:$v")

ciudades2 +=("MUR" ->"Murcia")
//---------
ciudades2.update("BCR", "Barna")

//SET
//No hay orden
val numeros7= Set(1,2,3,4,5)
val numeros7extra= numeros7 + 4
val numeros7extra2= numeros7 ++ Seq(4,6,7,8)
numeros7extra

//RANGE
println(1 to 5)
//(1 until 5 by 2)

val x=(1 until 5 by 2). toBuffer
x
val y=Set.range(1, 7)
y