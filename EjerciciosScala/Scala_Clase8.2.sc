//Ejercicio
case class Empleado(nombre: String, salario: Option[Double])

def salariomean(empleados: List[Empleado]): Option[Double] = {
  val conSalario = empleados.filter(_.salario!=None)
  val salarioTotal = conSalario.map(_.salario.getOrElse(0.0)).sum
  val numeroempleados = conSalario.length
  if (numeroempleados > 0)
    Some(salarioTotal / numeroempleados)
  else None
}

val empleados = List(
  Empleado("Juan", Some(3000)),
  Empleado("María", Some(2500)),
  Empleado("Pedro", None),
  Empleado("Laura", Some(3200)),
  Empleado("Carlos", None)
)

println(salariomean(empleados))

//Ejercicio
case class Empleado1(nombre: String, salario: Option[Double])

def salariopromedio(empleados: List[Empleado]): Option[Double] =
  val conSalario1 = empleados.flatMap(_.salario)
  if (conSalario1.nonEmpty) Some(conSalario1.sum/conSalario1.length)
  else None

println(salariopromedio(empleados))

//Ejercicio
val promedio = salariopromedio(empleados)
promedio match {
  case Some(valor) => println(s"El salario promedio de los empleados es: $valor")
  case None => println("No puedo calcular el promedio ya que no conozco el salario de ningun empleado")
}

