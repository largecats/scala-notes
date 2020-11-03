package main.scala

trait Pilot[-A] {
  def name: String
  def specialization: String
}

object Pilot {
  def perform_generic(pilot: Pilot[Task],
                      mission: Mission[Task]): GenericRecord = {
    println(s"${pilot.name}: I performed a ${mission.name}")
    GenericRecord(pilot.name, mission)
  }

  def perform_military(pilot: Pilot[MilitaryTask],
                       mission: Mission[MilitaryTask]): MilitaryRecord = {
    println(s"${pilot.name}: I performed a ${mission.name}")
    MilitaryRecord(pilot.name, mission)
  }

  def perform_air_to_air_strike(
    pilot: Pilot[AirToAirStrikeTask],
    mission: Mission[AirToAirStrikeTask]
  ): AirToAirStrikeRecord = {
    println(s"${pilot.name}: I performed a ${mission.name}")
    AirToAirStrikeRecord(pilot.name, mission)
  }

}

class GenericPilot(val name: String) extends Pilot[Task] {
  val specialization = "All task"
}

class MilitaryPilot(val name: String) extends Pilot[MilitaryTask] {
  val specialization = "Military task"
}

class AirToAirStrikePilot(val name: String) extends Pilot[AirToAirStrikeTask] {
  override val specialization = "Dog fight"
}
