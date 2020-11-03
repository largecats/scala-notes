package main.scala

trait Record[+A] {
  def content: String
  def pilotName: String
  def mission: Mission[A]
}

case class GenericRecord(pilotName: String, mission: Mission[Task])
    extends Record[Task] {
  def content: String = s"${pilotName}: ${mission.name}"
}

case class MilitaryRecord(pilotName: String, mission: Mission[MilitaryTask])
    extends Record[MilitaryTask] {
  def content: String = s"${pilotName}: ${mission.name}"
}

case class AirToAirStrikeRecord(pilotName: String,
                                mission: Mission[AirToAirStrikeTask])
    extends Record[AirToAirStrikeTask] {
  def content: String = s"${pilotName}: ${mission.name}"
}
