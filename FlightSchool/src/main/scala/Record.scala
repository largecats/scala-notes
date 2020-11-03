package main.scala

trait Record[+A] {
  def content: String
  def pilotName: String
  def missionName: Mission[A]
}

case class GenericRecord(pilotName: String, mission: Mission[Task]) extends Record[Task] {
  def content: String =
}

case class MilitaryRecord(pilot: Pilot[MilitaryTask], mission: Mission[MilitaryTask]) extends Record[MilitaryTask] {
}