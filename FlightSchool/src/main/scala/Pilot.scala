package main.scala

trait Pilot[-A] {
  def name: String
  def specialization: String
  def perform(mission: Mission[A]): String
}

class GenericPilot(val name: String) extends Pilot[Task] {
  val specialization = "All task"
  override def perform(mission: Mission[Task]): String = s"${name} performed a ${mission.name}"
}

class MilitaryPilot(val name: String) extends Pilot[MilitaryTask] {
  val specialization = "Military task"
  override def perform(mission: Mission[MilitaryTask]): String = s"${name} performed a ${mission.name}"
}

class AirToAirStrikePilot(val name: String) extends Pilot[AirToAirStrike] {
  override val specialization = "Dog fight"
  def perform(mission: Mission[AirToAirStrike]): String = s"${name} performed a ${mission.name}"
}