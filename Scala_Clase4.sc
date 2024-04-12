//Ejercicio
import scala.io.StdIn.readLine
println("Introduce tu nombre: ")
val nombre = readLine()
println("Introduce tu edad: ")
val edad = readLine()
println("Introduce tu ciudad: ")
val ciudad = readLine()
println(s"¡Hola $nombre! Tienes $edad años y vives en $ciudad.")

//-------------------------------
val x = 2
if x == 1 then println(s"x es $x")
else if x == 2 then println(s"x es $x")
else println(s"No es 1 ni es 2")

//OPERADOR TERNARIO
val y = 8
var resultado = if (y == 10) "Diez" else "Otro numero diferente de 10"
println(resultado)

//-------------------------------

def compara(a: Int, b: Int): Int =
  if a < b then -1
  else if a == b then 0
  else 1
var resultado2 = compara(8, 15)
println(resultado2)

//-------------------------------

val ints = Seq(1, 2, 3)

//FOR

for
  i <- 1 to 2
  j <- 'a' to 'c'
  k <- 1 to 20 by 5
do println(s"i=$i,j=$j,k=$k")

//----------------

for
  i <- 1 to 30
  if i % 2 == 0
do println(i)

//-----------------------------
val list = for i<-10 to 15
yield i*2
println(list)