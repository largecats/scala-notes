package main.scala

trait Mission[+A] {
  def name: String
  def tasks: List[A]
}

case class GenericMission(tasks: List[Task]) extends Mission[Task] {
  def name: String = s"Generic mission involving ${tasks.map(_.name)}"
}

case class MilitaryMission(tasks: List[MilitaryTask]) extends Mission[MilitaryTask] {
  def name: String = s"Military mission involving ${tasks.map(_.name)}"
}

case class AirToAirStrikeMission(tasks: List[AirToAirStrike]) extends Mission[AirToAirStrike] {
  def name: String = s"AirToAirStrike mission involving ${tasks.map(_.name)}"
}