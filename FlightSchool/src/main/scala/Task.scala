package main.scala

trait Task {
  def name: String
}

class CivilianTask(val name: String) extends Task
class MilitaryTask(val name: String) extends Task

class CarryPassengerTask(override val name: String) extends CivilianTask(name)
class CarryCargoTask(override val name: String) extends CivilianTask(name)

class AirToAirStrikeTask(override val name: String) extends MilitaryTask(name)
class AirToGroundStrikeTask(override val name: String) extends MilitaryTask(name)

