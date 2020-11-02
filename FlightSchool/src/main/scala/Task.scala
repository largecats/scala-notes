package main.scala

trait Task {
  def name: String
}

class CivilianTask(val name: String) extends Task
class MilitaryTask(val name: String) extends Task

class CarryPassenger(override val name: String) extends CivilianTask(name)
class CarryCargo(override val name: String) extends CivilianTask(name)

class AirToAirStrike(override val name: String) extends MilitaryTask(name)
class AirToGroundStrike(override val name: String) extends MilitaryTask(name)

