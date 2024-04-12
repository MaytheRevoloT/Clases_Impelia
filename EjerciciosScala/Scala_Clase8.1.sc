//class Person(var Nombre: String, var Apellido: String)
//EN PROGRAMACION FUNCIONAL
case class Person(Nombre:String, Apellido:String)

val jorge=Person("Jorge", "Lopez")
val juan= jorge.copy(Nombre="Juan")

juan.Nombre
jorge.Nombre

//---------------------------
def makeInt(s:String): Option[Int]=
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e:Exception => None
  }

val a =makeInt("1") // Some(1)
val b= makeInt("one")  //None

a
b

//-------------------------
val x="uno"

makeInt(x) match {
  case Some(i) => println(i)
  case None => println("That didn't work")
}
